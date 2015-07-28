package com.android.mail.browse;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.UIProvider;
import com.android.mail.utils.LogUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class ConversationCursor
  implements Cursor
{
  private static final Collection<Conversation> EMPTY_DELETION_LIST = ;
  static ConversationProvider sProvider;
  private static ContentResolver sResolver;
  private static int sSequence = 0;
  private static int sUriColumnIndex;
  private HashMap<String, ContentValues> mCacheMap = new HashMap();
  private Object mCacheMapLock = new Object();
  private String[] mColumnNames;
  private final CursorObserver mCursorObserver;
  private boolean mCursorObserverRegistered = false;
  private boolean mDeferSync = false;
  private int mDeletedCount = 0;
  private boolean mInitialConversationLimit = false;
  private List<ConversationListener> mListeners = Lists.newArrayList();
  private final String mName;
  private boolean mPaused = false;
  private int mPosition = -1;
  private boolean mRefreshReady = false;
  private boolean mRefreshRequired = false;
  private RefreshTask mRefreshTask;
  private volatile Cursor mRequeryCursor;
  Cursor mUnderlyingCursor;
  private String[] qProjection;
  private Uri qUri;
  private List<Conversation> sMostlyDead = Lists.newArrayList();
  
  public ConversationCursor(Activity paramActivity, Uri paramUri, boolean paramBoolean, String paramString)
  {
    mInitialConversationLimit = paramBoolean;
    sResolver = paramActivity.getContentResolver();
    sUriColumnIndex = 1;
    qUri = paramUri;
    mName = paramString;
    qProjection = UIProvider.CONVERSATION_PROJECTION;
    mCursorObserver = new CursorObserver(new Handler(Looper.getMainLooper()));
  }
  
  private int apply(Context paramContext, Collection<ConversationOperation> paramCollection)
  {
    return sProvider.apply(paramCollection, this);
  }
  
  private int applyAction(Context paramContext, Collection<Conversation> paramCollection, int paramInt)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new ConversationOperation(paramInt, (Conversation)paramCollection.next()));
    }
    return apply(paramContext, localArrayList);
  }
  
  private void cacheValue(String paramString1, String paramString2, Object paramObject)
  {
    if (offUiThread()) {
      LogUtils.e("ConversationCursor", new Error(), "cacheValue incorrectly being called from non-UI thread", new Object[0]);
    }
    for (;;)
    {
      ContentValues localContentValues1;
      boolean bool;
      int i;
      synchronized (mCacheMapLock)
      {
        ContentValues localContentValues2 = (ContentValues)mCacheMap.get(paramString1);
        localContentValues1 = localContentValues2;
        if (localContentValues2 == null)
        {
          localContentValues1 = new ContentValues();
          mCacheMap.put(paramString1, localContentValues1);
        }
        if (paramString2 == "__deleted__")
        {
          bool = ((Boolean)paramObject).booleanValue();
          if (localContentValues1.get(paramString2) == null) {
            break label404;
          }
          i = 1;
          if ((bool) && (i == 0))
          {
            mDeletedCount += 1;
            LogUtils.i("ConversationCursor", "Deleted %s, incremented deleted count=%d", new Object[] { paramString1, Integer.valueOf(mDeletedCount) });
          }
        }
        else
        {
          if (!(paramObject instanceof Boolean)) {
            break label328;
          }
          if (!((Boolean)paramObject).booleanValue()) {
            break label410;
          }
          i = 1;
          localContentValues1.put(paramString2, Integer.valueOf(i));
          localContentValues1.put("__updatetime__", Long.valueOf(System.currentTimeMillis()));
          if (paramString2 != "__deleted__") {
            LogUtils.i("ConversationCursor", "Caching value for %s: %s", new Object[] { paramString1, paramString2 });
          }
          return;
        }
        if ((!bool) && (i != 0))
        {
          mDeletedCount -= 1;
          localContentValues1.remove(paramString2);
          LogUtils.i("ConversationCursor", "Undeleted %s, decremented deleted count=%d", new Object[] { paramString1, Integer.valueOf(mDeletedCount) });
          return;
        }
      }
      if (!bool)
      {
        LogUtils.i("ConversationCursor", "Undeleted %s, IGNORING, deleted count=%d", new Object[] { paramString1, Integer.valueOf(mDeletedCount) });
        return;
        label328:
        if ((paramObject instanceof Integer))
        {
          localContentValues1.put(paramString2, (Integer)paramObject);
        }
        else if ((paramObject instanceof String))
        {
          localContentValues1.put(paramString2, (String)paramObject);
        }
        else
        {
          paramString1 = paramObject.getClass().getName();
          throw new IllegalArgumentException("Value class not compatible with cache: " + paramString1);
          label404:
          i = 0;
          continue;
          label410:
          i = 0;
        }
      }
    }
  }
  
  private void checkNotifyUI()
  {
    if ((!mPaused) && (!mDeferSync))
    {
      if ((mRefreshRequired) && (mRefreshTask == null)) {
        notifyRefreshRequired();
      }
      while (!mRefreshReady) {
        return;
      }
      notifyRefreshReady();
      return;
    }
    String str1;
    if (mPaused)
    {
      str1 = "Paused ";
      if (!mDeferSync) {
        break label96;
      }
    }
    label96:
    for (String str2 = "Defer";; str2 = "")
    {
      LogUtils.i("ConversationCursor", "[checkNotifyUI: %s%s", new Object[] { str1, str2 });
      return;
      str1 = "";
      break;
    }
  }
  
  private Cursor doQuery(boolean paramBoolean)
  {
    Object localObject2 = qUri;
    Object localObject1 = localObject2;
    if (paramBoolean) {
      localObject1 = ((Uri)localObject2).buildUpon().appendQueryParameter("limit", "50").build();
    }
    long l = System.currentTimeMillis();
    localObject2 = sResolver.query((Uri)localObject1, qProjection, null, null, null);
    if (localObject2 == null)
    {
      Log.w("ConversationCursor", "doQuery returning null cursor, uri: " + localObject1);
      return (Cursor)localObject2;
    }
    LogUtils.i("ConversationCursor", "ConversationCursor query: %s, %dms, %d results", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(((Cursor)localObject2).getCount()) });
    return (Cursor)localObject2;
  }
  
  private Object getCachedValue(int paramInt)
  {
    return getCachedValue(mUnderlyingCursor.getString(sUriColumnIndex), paramInt);
  }
  
  private Object getCachedValue(String paramString, int paramInt)
  {
    ContentValues localContentValues = (ContentValues)mCacheMap.get(paramString);
    if (localContentValues != null)
    {
      if (paramInt == -1) {}
      for (paramString = "__deleted__";; paramString = mColumnNames[paramInt]) {
        return localContentValues.get(paramString);
      }
    }
    return null;
  }
  
  private ArrayList<ConversationOperation> getOperationsForConversations(Collection<Conversation> paramCollection, int paramInt, ContentValues paramContentValues)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(getOperationForConversation((Conversation)paramCollection.next(), paramInt, paramContentValues));
    }
    return localArrayList;
  }
  
  private void notifyDataChanged()
  {
    LogUtils.i("ConversationCursor", "[Notify %s: onDataSetChanged()]", new Object[] { mName });
    synchronized (mListeners)
    {
      Iterator localIterator = mListeners.iterator();
      if (localIterator.hasNext()) {
        ((ConversationListener)localIterator.next()).onDataSetChanged();
      }
    }
  }
  
  private void notifyRefreshReady()
  {
    LogUtils.i("ConversationCursor", "[Notify %s: onRefreshReady(), %d listeners]", new Object[] { mName, Integer.valueOf(mListeners.size()) });
    synchronized (mListeners)
    {
      Iterator localIterator = mListeners.iterator();
      if (localIterator.hasNext()) {
        ((ConversationListener)localIterator.next()).onRefreshReady();
      }
    }
  }
  
  private void notifyRefreshRequired()
  {
    LogUtils.i("ConversationCursor", "[Notify %s: onRefreshRequired()]", new Object[] { mName });
    if (!mDeferSync) {
      synchronized (mListeners)
      {
        Iterator localIterator = mListeners.iterator();
        if (localIterator.hasNext()) {
          ((ConversationListener)localIterator.next()).onRefreshRequired();
        }
      }
    }
  }
  
  static boolean offUiThread()
  {
    return Looper.getMainLooper().getThread() != Thread.currentThread();
  }
  
  private void recalibratePosition()
  {
    int i = mPosition;
    moveToFirst();
    moveToPosition(i);
  }
  
  private void resetCursor(Cursor paramCursor)
  {
    for (;;)
    {
      Iterator localIterator;
      Object localObject2;
      ContentValues localContentValues;
      synchronized (mCacheMapLock)
      {
        localIterator = mCacheMap.entrySet().iterator();
        long l = System.currentTimeMillis();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator.next();
        localContentValues = (ContentValues)((Map.Entry)localObject2).getValue();
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        if (l - localContentValues.getAsLong("__updatetime__").longValue() < 10000L) {
          LogUtils.i("ConversationCursor", "IN resetCursor, keep recent changes to %s", new Object[] { localObject2 });
        }
      }
      if (localContentValues.containsKey("__deleted__"))
      {
        mDeletedCount -= 1;
        LogUtils.i("ConversationCursor", "IN resetCursor, sDeletedCount decremented to: %d by %s", new Object[] { Integer.valueOf(mDeletedCount), localObject2 });
      }
      localIterator.remove();
    }
    if (mUnderlyingCursor != null) {
      close();
    }
    mUnderlyingCursor = paramCursor;
    mPosition = -1;
    mUnderlyingCursor.moveToPosition(mPosition);
    if (!mCursorObserverRegistered)
    {
      mUnderlyingCursor.registerContentObserver(mCursorObserver);
      mCursorObserverRegistered = true;
    }
    mRefreshRequired = false;
  }
  
  private void setCursor(Cursor paramCursor)
  {
    if (mUnderlyingCursor != null) {
      close();
    }
    mColumnNames = paramCursor.getColumnNames();
    mRefreshRequired = false;
    mRefreshReady = false;
    mRefreshTask = null;
    resetCursor(paramCursor);
  }
  
  private void underlyingChanged()
  {
    synchronized (mCacheMapLock)
    {
      boolean bool = mCursorObserverRegistered;
      if (!bool) {}
    }
    try
    {
      mUnderlyingCursor.unregisterContentObserver(mCursorObserver);
      mCursorObserverRegistered = false;
      mRefreshRequired = true;
      if (!mPaused) {
        notifyRefreshRequired();
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  private void undoLocal()
  {
    sProvider.undo(this);
  }
  
  private static Uri uriFromCachingUri(Uri paramUri)
  {
    if (!paramUri.getAuthority().equals(ConversationProvider.AUTHORITY)) {
      return paramUri;
    }
    List localList = paramUri.getPathSegments();
    paramUri = new Uri.Builder().scheme(paramUri.getScheme()).authority((String)localList.get(0));
    int i = 1;
    while (i < localList.size())
    {
      paramUri.appendPath((String)localList.get(i));
      i += 1;
    }
    return paramUri.build();
  }
  
  private static String uriStringFromCachingUri(Uri paramUri)
  {
    return Uri.decode(uriFromCachingUri(paramUri).toString());
  }
  
  private static String uriToCachingUriString(Uri paramUri)
  {
    String str = paramUri.getAuthority();
    return paramUri.getScheme() + "://" + ConversationProvider.AUTHORITY + "/" + str + paramUri.getPath();
  }
  
  public void addListener(ConversationListener paramConversationListener)
  {
    synchronized (mListeners)
    {
      if (!mListeners.contains(paramConversationListener))
      {
        mListeners.add(paramConversationListener);
        return;
      }
      LogUtils.i("ConversationCursor", "Ignoring duplicate add of listener", new Object[0]);
    }
  }
  
  public int archive(Context paramContext, Collection<Conversation> paramCollection)
  {
    return applyAction(paramContext, paramCollection, 3);
  }
  
  boolean clearMostlyDead(String paramString)
  {
    Object localObject = getCachedValue(paramString, 15);
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      if ((i & 0x1) != 0)
      {
        cacheValue(paramString, "conversationFlags", Integer.valueOf(i & 0xFFFFFFFE));
        return true;
      }
    }
    return false;
  }
  
  public void close()
  {
    if ((mUnderlyingCursor == null) || (mUnderlyingCursor.isClosed()) || (mCursorObserverRegistered)) {}
    try
    {
      mUnderlyingCursor.unregisterContentObserver(mCursorObserver);
      mCursorObserverRegistered = false;
      mUnderlyingCursor.close();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  void commitMostlyDead(Conversation paramConversation)
  {
    convFlags &= 0xFFFFFFFE;
    sMostlyDead.remove(paramConversation);
    LogUtils.i("ConversationCursor", "[All dead: %s]", new Object[] { uri });
    if (sMostlyDead.isEmpty())
    {
      mDeferSync = false;
      checkNotifyUI();
    }
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void deactivate()
  {
    throw new UnsupportedOperationException();
  }
  
  public int delete(Context paramContext, Collection<Conversation> paramCollection)
  {
    return applyAction(paramContext, paramCollection, 0);
  }
  
  public void disable()
  {
    close();
    mCacheMap.clear();
    mListeners.clear();
    mUnderlyingCursor = null;
  }
  
  public int discardDrafts(Context paramContext, Collection<Conversation> paramCollection)
  {
    return applyAction(paramContext, paramCollection, 8);
  }
  
  public byte[] getBlob(int paramInt)
  {
    Object localObject = getCachedValue(paramInt);
    if (localObject != null) {
      return (byte[])localObject;
    }
    return mUnderlyingCursor.getBlob(paramInt);
  }
  
  public int getColumnCount()
  {
    return mUnderlyingCursor.getColumnCount();
  }
  
  public int getColumnIndex(String paramString)
  {
    return mUnderlyingCursor.getColumnIndex(paramString);
  }
  
  public int getColumnIndexOrThrow(String paramString)
    throws IllegalArgumentException
  {
    return mUnderlyingCursor.getColumnIndexOrThrow(paramString);
  }
  
  public String getColumnName(int paramInt)
  {
    return mUnderlyingCursor.getColumnName(paramInt);
  }
  
  public String[] getColumnNames()
  {
    return mUnderlyingCursor.getColumnNames();
  }
  
  public int getCount()
  {
    if (mUnderlyingCursor == null) {
      throw new IllegalStateException("getCount() on disabled cursor: " + mName + "(" + qUri + ")");
    }
    return mUnderlyingCursor.getCount() - mDeletedCount;
  }
  
  public Set<String> getDeletedItems()
  {
    synchronized (mCacheMapLock)
    {
      HashSet localHashSet = Sets.newHashSet();
      Iterator localIterator = mCacheMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((ContentValues)localEntry.getValue()).containsKey("__deleted__")) {
          localHashSet.add(uriToCachingUriString(Uri.parse((String)localEntry.getKey())));
        }
      }
    }
    return localSet;
  }
  
  public double getDouble(int paramInt)
  {
    Object localObject = getCachedValue(paramInt);
    if (localObject != null) {
      return ((Double)localObject).doubleValue();
    }
    return mUnderlyingCursor.getDouble(paramInt);
  }
  
  public Bundle getExtras()
  {
    if (mUnderlyingCursor != null) {
      return mUnderlyingCursor.getExtras();
    }
    return Bundle.EMPTY;
  }
  
  public float getFloat(int paramInt)
  {
    Object localObject = getCachedValue(paramInt);
    if (localObject != null) {
      return ((Float)localObject).floatValue();
    }
    return mUnderlyingCursor.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    Object localObject = getCachedValue(paramInt);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    return mUnderlyingCursor.getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    Object localObject = getCachedValue(paramInt);
    if (localObject != null) {
      return ((Long)localObject).longValue();
    }
    return mUnderlyingCursor.getLong(paramInt);
  }
  
  public ConversationOperation getOperationForConversation(Conversation paramConversation, int paramInt, ContentValues paramContentValues)
  {
    return new ConversationOperation(paramInt, paramConversation, paramContentValues);
  }
  
  public int getPosition()
  {
    return mPosition;
  }
  
  public short getShort(int paramInt)
  {
    Object localObject = getCachedValue(paramInt);
    if (localObject != null) {
      return ((Short)localObject).shortValue();
    }
    return mUnderlyingCursor.getShort(paramInt);
  }
  
  public String getString(int paramInt)
  {
    if (paramInt == sUriColumnIndex) {
      return uriToCachingUriString(Uri.parse(mUnderlyingCursor.getString(paramInt)));
    }
    Object localObject = getCachedValue(paramInt);
    if (localObject != null) {
      return (String)localObject;
    }
    return mUnderlyingCursor.getString(paramInt);
  }
  
  public int getType(int paramInt)
  {
    return mUnderlyingCursor.getType(paramInt);
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    throw new UnsupportedOperationException();
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public boolean isAfterLast()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isBeforeFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isClosed()
  {
    return (mUnderlyingCursor == null) || (mUnderlyingCursor.isClosed());
  }
  
  public boolean isFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isLast()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isNull(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isRefreshReady()
  {
    return mRefreshReady;
  }
  
  public boolean isRefreshRequired()
  {
    return mRefreshRequired;
  }
  
  /* Error */
  public void load()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 95	com/android/mail/browse/ConversationCursor:mCacheMapLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: ldc -2
    //   9: ldc_w 738
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 298	com/android/mail/utils/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   19: pop
    //   20: aload_0
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 103	com/android/mail/browse/ConversationCursor:mInitialConversationLimit	Z
    //   26: invokespecial 160	com/android/mail/browse/ConversationCursor:doQuery	(Z)Landroid/database/Cursor;
    //   29: invokespecial 740	com/android/mail/browse/ConversationCursor:setCursor	(Landroid/database/Cursor;)V
    //   32: aload_0
    //   33: getfield 103	com/android/mail/browse/ConversationCursor:mInitialConversationLimit	Z
    //   36: ifeq +13 -> 49
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 103	com/android/mail/browse/ConversationCursor:mInitialConversationLimit	Z
    //   44: aload_0
    //   45: invokevirtual 743	com/android/mail/browse/ConversationCursor:refresh	()Z
    //   48: pop
    //   49: aload_1
    //   50: monitorexit
    //   51: return
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 103	com/android/mail/browse/ConversationCursor:mInitialConversationLimit	Z
    //   57: ifeq +13 -> 70
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 103	com/android/mail/browse/ConversationCursor:mInitialConversationLimit	Z
    //   65: aload_0
    //   66: invokevirtual 743	com/android/mail/browse/ConversationCursor:refresh	()Z
    //   69: pop
    //   70: aload_2
    //   71: athrow
    //   72: astore_2
    //   73: aload_1
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	ConversationCursor
    //   4	70	1	localObject1	Object
    //   52	19	2	localObject2	Object
    //   72	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	32	52	finally
    //   32	49	72	finally
    //   49	51	72	finally
    //   53	70	72	finally
    //   70	72	72	finally
    //   73	75	72	finally
  }
  
  public int mostlyArchive(Context paramContext, Collection<Conversation> paramCollection)
  {
    return applyAction(paramContext, paramCollection, 131);
  }
  
  public int mostlyDelete(Context paramContext, Collection<Conversation> paramCollection)
  {
    return applyAction(paramContext, paramCollection, 128);
  }
  
  public int mostlyDestructiveUpdate(Context paramContext, Collection<Conversation> paramCollection, String paramString1, String paramString2)
  {
    return mostlyDestructiveUpdate(paramContext, paramCollection, new String[] { paramString1 }, new String[] { paramString2 });
  }
  
  public int mostlyDestructiveUpdate(Context paramContext, Collection<Conversation> paramCollection, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    ContentValues localContentValues = new ContentValues();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      localContentValues.put(paramArrayOfString1[i], paramArrayOfString2[i]);
      i += 1;
    }
    return apply(paramContext, getOperationsForConversations(paramCollection, 130, localContentValues));
  }
  
  public boolean move(int paramInt)
  {
    throw new UnsupportedOperationException("move unsupported!");
  }
  
  public boolean moveToFirst()
  {
    if (mUnderlyingCursor == null) {
      throw new IllegalStateException("moveToFirst() on disabled cursor: " + mName + "(" + qUri + ")");
    }
    mUnderlyingCursor.moveToPosition(-1);
    mPosition = -1;
    return moveToNext();
  }
  
  public boolean moveToLast()
  {
    throw new UnsupportedOperationException("moveToLast unsupported!");
  }
  
  public boolean moveToNext()
  {
    do
    {
      if (!mUnderlyingCursor.moveToNext())
      {
        mPosition = getCount();
        LogUtils.i("ConversationCursor", "*** moveToNext returns false; pos = %d, und = %d, del = %d", new Object[] { Integer.valueOf(mPosition), Integer.valueOf(mUnderlyingCursor.getPosition()), Integer.valueOf(mDeletedCount) });
        return false;
      }
    } while ((getCachedValue(-1) instanceof Integer));
    mPosition += 1;
    return true;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    boolean bool = true;
    if (mUnderlyingCursor == null) {
      throw new IllegalStateException("moveToPosition() on disabled cursor: " + mName + "(" + qUri + ")");
    }
    if (mUnderlyingCursor.getPosition() == -1) {
      LogUtils.i("ConversationCursor", "*** Underlying cursor position is -1 asking to move from %d to %d", new Object[] { Integer.valueOf(mPosition), Integer.valueOf(paramInt) });
    }
    if (paramInt == 0) {
      return moveToFirst();
    }
    if (paramInt < 0)
    {
      mPosition = -1;
      mUnderlyingCursor.moveToPosition(mPosition);
      return false;
    }
    if (paramInt == mPosition)
    {
      if (paramInt < getCount()) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    if (paramInt > mPosition)
    {
      while (paramInt > mPosition) {
        if (!moveToNext()) {
          return false;
        }
      }
      return true;
    }
    if ((paramInt >= 0) && (mPosition - paramInt > paramInt))
    {
      LogUtils.i("ConversationCursor", "*** Move from %d to %d, starting from first", new Object[] { Integer.valueOf(mPosition), Integer.valueOf(paramInt) });
      moveToFirst();
      return moveToPosition(paramInt);
    }
    while (paramInt < mPosition) {
      if (!moveToPrevious()) {
        return false;
      }
    }
    return true;
  }
  
  public boolean moveToPrevious()
  {
    do
    {
      if (!mUnderlyingCursor.moveToPrevious())
      {
        mPosition = -1;
        return false;
      }
    } while ((getCachedValue(-1) instanceof Integer));
    mPosition -= 1;
    return true;
  }
  
  public int mute(Context paramContext, Collection<Conversation> paramCollection)
  {
    return applyAction(paramContext, paramCollection, 4);
  }
  
  public void pause()
  {
    LogUtils.i("ConversationCursor", "[Paused: %s]", new Object[] { mName });
    mPaused = true;
  }
  
  public boolean refresh()
  {
    LogUtils.i("ConversationCursor", "[refresh() %s]", new Object[] { mName });
    synchronized (mCacheMapLock)
    {
      if (mRefreshTask != null)
      {
        LogUtils.i("ConversationCursor", "[refresh() %s returning; already running %d]", new Object[] { mName, Integer.valueOf(mRefreshTask.hashCode()) });
        return false;
      }
      mRefreshTask = new RefreshTask(null);
      mRefreshTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return true;
    }
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public void removeListener(ConversationListener paramConversationListener)
  {
    synchronized (mListeners)
    {
      mListeners.remove(paramConversationListener);
      return;
    }
  }
  
  public int reportNotSpam(Context paramContext, Collection<Conversation> paramCollection)
  {
    return applyAction(paramContext, paramCollection, 6);
  }
  
  public int reportPhishing(Context paramContext, Collection<Conversation> paramCollection)
  {
    return applyAction(paramContext, paramCollection, 7);
  }
  
  public int reportSpam(Context paramContext, Collection<Conversation> paramCollection)
  {
    return applyAction(paramContext, paramCollection, 5);
  }
  
  public boolean requery()
  {
    return true;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    if (mUnderlyingCursor != null) {
      return mUnderlyingCursor.respond(paramBundle);
    }
    return Bundle.EMPTY;
  }
  
  public void resume()
  {
    LogUtils.i("ConversationCursor", "[Resumed: %s]", new Object[] { mName });
    mPaused = false;
    checkNotifyUI();
  }
  
  public void setConversationColumn(Uri arg1, String paramString, Object paramObject)
  {
    String str = uriStringFromCachingUri(???);
    synchronized (mCacheMapLock)
    {
      cacheValue(str, paramString, paramObject);
      notifyDataChanged();
      return;
    }
  }
  
  void setMostlyDead(String paramString, Conversation paramConversation)
  {
    LogUtils.i("ConversationCursor", "[Mostly dead, deferring: %s] ", new Object[] { paramString });
    cacheValue(paramString, "conversationFlags", Integer.valueOf(1));
    convFlags |= 0x1;
    sMostlyDead.add(paramConversation);
    mDeferSync = true;
  }
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }
  
  public void sync()
  {
    if (mRequeryCursor == null)
    {
      LogUtils.i("ConversationCursor", "[sync() %s; no requery cursor]", new Object[] { mName });
      return;
    }
    synchronized (mCacheMapLock)
    {
      LogUtils.i("ConversationCursor", "[sync() %s]", new Object[] { mName });
      resetCursor(mRequeryCursor);
      mRequeryCursor = null;
      mRefreshTask = null;
      mRefreshReady = false;
      notifyDataChanged();
      return;
    }
  }
  
  public void undo(final Context paramContext, final Uri paramUri)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        Cursor localCursor = paramContext.getContentResolver().query(paramUri, UIProvider.UNDO_PROJECTION, null, null, null);
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }).start();
    undoLocal();
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public int updateBoolean(Context paramContext, Conversation paramConversation, String paramString, boolean paramBoolean)
  {
    return updateBoolean(paramContext, Arrays.asList(new Conversation[] { paramConversation }), paramString, paramBoolean);
  }
  
  public int updateBoolean(Context paramContext, Collection<Conversation> paramCollection, String paramString, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(paramString, Boolean.valueOf(paramBoolean));
    return updateValues(paramContext, paramCollection, localContentValues);
  }
  
  public int updateBulkValues(Context paramContext, Collection<ConversationOperation> paramCollection)
  {
    return apply(paramContext, paramCollection);
  }
  
  public int updateInt(Context paramContext, Collection<Conversation> paramCollection, String paramString, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(paramString, Integer.valueOf(paramInt));
    return updateValues(paramContext, paramCollection, localContentValues);
  }
  
  public int updateStrings(Context paramContext, Collection<Conversation> paramCollection, String paramString, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    ContentValues localContentValues = new ContentValues();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Conversation localConversation = (Conversation)paramCollection.next();
      localContentValues.put(paramString, (String)paramArrayList.get(0));
      localArrayList.add(getOperationForConversation(localConversation, 2, localContentValues));
    }
    return apply(paramContext, localArrayList);
  }
  
  public int updateValues(Context paramContext, Collection<Conversation> paramCollection, ContentValues paramContentValues)
  {
    return apply(paramContext, getOperationsForConversations(paramCollection, 2, paramContentValues));
  }
  
  public static abstract interface ConversationListener
  {
    public abstract void onDataSetChanged();
    
    public abstract void onRefreshReady();
    
    public abstract void onRefreshRequired();
  }
  
  public class ConversationOperation
  {
    private final Conversation mConversation;
    private final boolean mLocalDeleteOnUpdate;
    private final boolean mMostlyDead;
    private boolean mRecalibrateRequired = true;
    private final int mType;
    private final Uri mUri;
    private final ContentValues mValues;
    
    public ConversationOperation(int paramInt, Conversation paramConversation)
    {
      this(paramInt, paramConversation, null);
    }
    
    public ConversationOperation(int paramInt, Conversation paramConversation, ContentValues paramContentValues)
    {
      mType = paramInt;
      mUri = uri;
      mConversation = paramConversation;
      mValues = paramContentValues;
      mLocalDeleteOnUpdate = localDeleteOnUpdate;
      mMostlyDead = paramConversation.isMostlyDead();
    }
    
    private ContentProviderOperation execute(Uri paramUri)
    {
      Uri localUri = paramUri.buildUpon().appendQueryParameter("seq", Integer.toString(ConversationCursor.sSequence)).build();
      switch (mType)
      {
      default: 
        throw new UnsupportedOperationException("No such ConversationOperation type: " + mType);
      case 2: 
        if (mLocalDeleteOnUpdate) {
          ConversationCursor.sProvider.deleteLocal(mUri, ConversationCursor.this);
        }
        while (!mMostlyDead)
        {
          return ContentProviderOperation.newUpdate(localUri).withValues(mValues).build();
          ConversationCursor.sProvider.updateLocal(mUri, mValues, ConversationCursor.this);
          mRecalibrateRequired = false;
        }
        ConversationCursor.sProvider.commitMostlyDead(mConversation, ConversationCursor.this);
        return null;
      case 130: 
        ConversationCursor.sProvider.setMostlyDead(mConversation, ConversationCursor.this);
        return ContentProviderOperation.newUpdate(localUri).withValues(mValues).build();
      case 1: 
        ConversationCursor.ConversationProvider.access$2000(ConversationCursor.sProvider, mUri, mValues);
        return ContentProviderOperation.newInsert(localUri).withValues(mValues).build();
      case 0: 
        ConversationCursor.sProvider.deleteLocal(mUri, ConversationCursor.this);
        if (!mMostlyDead) {
          return ContentProviderOperation.newDelete(localUri).build();
        }
        ConversationCursor.sProvider.commitMostlyDead(mConversation, ConversationCursor.this);
        return null;
      case 128: 
        ConversationCursor.sProvider.setMostlyDead(mConversation, ConversationCursor.this);
        return ContentProviderOperation.newDelete(localUri).build();
      case 3: 
        ConversationCursor.sProvider.deleteLocal(mUri, ConversationCursor.this);
        if (!mMostlyDead) {
          return ContentProviderOperation.newUpdate(localUri).withValue("operation", "archive").build();
        }
        ConversationCursor.sProvider.commitMostlyDead(mConversation, ConversationCursor.this);
        return null;
      case 131: 
        ConversationCursor.sProvider.setMostlyDead(mConversation, ConversationCursor.this);
        return ContentProviderOperation.newUpdate(localUri).withValue("operation", "archive").build();
      case 4: 
        if (mLocalDeleteOnUpdate) {
          ConversationCursor.sProvider.deleteLocal(mUri, ConversationCursor.this);
        }
        return ContentProviderOperation.newUpdate(localUri).withValue("operation", "mute").build();
      case 5: 
      case 6: 
        ConversationCursor.sProvider.deleteLocal(mUri, ConversationCursor.this);
        if (mType == 5) {}
        for (paramUri = "report_spam";; paramUri = "report_not_spam") {
          return ContentProviderOperation.newUpdate(localUri).withValue("operation", paramUri).build();
        }
      case 7: 
        ConversationCursor.sProvider.deleteLocal(mUri, ConversationCursor.this);
        return ContentProviderOperation.newUpdate(localUri).withValue("operation", "report_phishing").build();
      }
      ConversationCursor.sProvider.deleteLocal(mUri, ConversationCursor.this);
      return ContentProviderOperation.newUpdate(localUri).withValue("operation", "discard_drafts").build();
    }
  }
  
  public static abstract class ConversationProvider
    extends ContentProvider
  {
    public static String AUTHORITY;
    private ArrayList<Uri> mUndoDeleteUris = new ArrayList();
    private int mUndoSequence = 0;
    
    private void insertLocal(Uri paramUri, ContentValues paramContentValues) {}
    
    void addToUndoSequence(Uri paramUri)
    {
      if (ConversationCursor.sSequence != mUndoSequence)
      {
        mUndoSequence = ConversationCursor.sSequence;
        mUndoDeleteUris.clear();
      }
      mUndoDeleteUris.add(paramUri);
    }
    
    public int apply(Collection<ConversationCursor.ConversationOperation> paramCollection, final ConversationCursor paramConversationCursor)
    {
      final HashMap localHashMap = new HashMap();
      ConversationCursor.access$1208();
      int i = 0;
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        ConversationCursor.ConversationOperation localConversationOperation = (ConversationCursor.ConversationOperation)localIterator.next();
        Uri localUri = ConversationCursor.uriFromCachingUri(mUri);
        String str = localUri.getAuthority();
        Object localObject = (ArrayList)localHashMap.get(str);
        paramCollection = (Collection<ConversationCursor.ConversationOperation>)localObject;
        if (localObject == null)
        {
          paramCollection = new ArrayList();
          localHashMap.put(str, paramCollection);
        }
        localObject = localConversationOperation.execute(localUri);
        if (localObject != null) {
          paramCollection.add(localObject);
        }
        if (mRecalibrateRequired) {
          i = 1;
        }
      }
      if (i != 0) {
        paramConversationCursor.recalibratePosition();
      }
      paramConversationCursor.notifyDataChanged();
      paramCollection = localHashMap.keySet().iterator();
      for (;;)
      {
        if (paramCollection.hasNext()) {
          paramConversationCursor = (String)paramCollection.next();
        }
        try
        {
          if (ConversationCursor.offUiThread()) {
            ConversationCursor.sResolver.applyBatch(paramConversationCursor, (ArrayList)localHashMap.get(paramConversationCursor));
          } else {
            new Thread(new Runnable()
            {
              public void run()
              {
                try
                {
                  ConversationCursor.sResolver.applyBatch(paramConversationCursor, (ArrayList)localHashMap.get(paramConversationCursor));
                  return;
                }
                catch (OperationApplicationException localOperationApplicationException) {}catch (RemoteException localRemoteException) {}
              }
            }).start();
          }
        }
        catch (OperationApplicationException paramConversationCursor)
        {
          continue;
          return ConversationCursor.sSequence;
        }
        catch (RemoteException paramConversationCursor) {}
      }
    }
    
    boolean clearMostlyDead(Uri paramUri, ConversationCursor paramConversationCursor)
    {
      return paramConversationCursor.clearMostlyDead(ConversationCursor.uriStringFromCachingUri(paramUri));
    }
    
    void commitMostlyDead(Conversation paramConversation, ConversationCursor paramConversationCursor)
    {
      paramConversationCursor.commitMostlyDead(paramConversation);
    }
    
    public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
    {
      throw new IllegalStateException("Unexpected call to ConversationProvider.delete");
    }
    
    void deleteLocal(Uri paramUri, ConversationCursor paramConversationCursor)
    {
      paramConversationCursor.cacheValue(ConversationCursor.access$1300(paramUri), "__deleted__", Boolean.valueOf(true));
      addToUndoSequence(paramUri);
    }
    
    protected abstract String getAuthority();
    
    public String getType(Uri paramUri)
    {
      return null;
    }
    
    public Uri insert(Uri paramUri, ContentValues paramContentValues)
    {
      insertLocal(paramUri, paramContentValues);
      return ProviderExecute.opInsert(paramUri, paramContentValues);
    }
    
    public boolean onCreate()
    {
      ConversationCursor.sProvider = this;
      AUTHORITY = getAuthority();
      return true;
    }
    
    public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
    {
      return ConversationCursor.sResolver.query(ConversationCursor.uriFromCachingUri(paramUri), paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    
    void setMostlyDead(Conversation paramConversation, ConversationCursor paramConversationCursor)
    {
      Uri localUri = uri;
      paramConversationCursor.setMostlyDead(ConversationCursor.uriStringFromCachingUri(localUri), paramConversation);
      addToUndoSequence(localUri);
    }
    
    void undeleteLocal(Uri paramUri, ConversationCursor paramConversationCursor)
    {
      paramConversationCursor.cacheValue(ConversationCursor.access$1300(paramUri), "__deleted__", Boolean.valueOf(false));
    }
    
    public void undo(ConversationCursor paramConversationCursor)
    {
      if (ConversationCursor.sSequence == mUndoSequence)
      {
        Iterator localIterator = mUndoDeleteUris.iterator();
        while (localIterator.hasNext())
        {
          Uri localUri = (Uri)localIterator.next();
          if (!clearMostlyDead(localUri, paramConversationCursor)) {
            undeleteLocal(localUri, paramConversationCursor);
          }
        }
        mUndoSequence = 0;
        paramConversationCursor.recalibratePosition();
        paramConversationCursor.notifyDataChanged();
      }
    }
    
    public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    {
      throw new IllegalStateException("Unexpected call to ConversationProvider.delete");
    }
    
    void updateLocal(Uri paramUri, ContentValues paramContentValues, ConversationCursor paramConversationCursor)
    {
      if (paramContentValues == null) {}
      for (;;)
      {
        return;
        paramUri = ConversationCursor.uriStringFromCachingUri(paramUri);
        Iterator localIterator = paramContentValues.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramConversationCursor.cacheValue(paramUri, str, paramContentValues.get(str));
        }
      }
    }
    
    static class ProviderExecute
      implements Runnable
    {
      final int mCode;
      final Uri mUri;
      final ContentValues mValues;
      
      ProviderExecute(int paramInt, Uri paramUri, ContentValues paramContentValues)
      {
        mCode = paramInt;
        mUri = ConversationCursor.uriFromCachingUri(paramUri);
        mValues = paramContentValues;
      }
      
      static Uri opInsert(Uri paramUri, ContentValues paramContentValues)
      {
        paramUri = new ProviderExecute(1, paramUri, paramContentValues);
        if (ConversationCursor.offUiThread()) {
          return (Uri)paramUri.go();
        }
        new Thread(paramUri).start();
        return null;
      }
      
      public Object go()
      {
        switch (mCode)
        {
        default: 
          return null;
        case 0: 
          return Integer.valueOf(ConversationCursor.sResolver.delete(mUri, null, null));
        case 1: 
          return ConversationCursor.sResolver.insert(mUri, mValues);
        }
        return Integer.valueOf(ConversationCursor.sResolver.update(mUri, mValues, null, null));
      }
      
      public void run()
      {
        go();
      }
    }
  }
  
  private class CursorObserver
    extends ContentObserver
  {
    public CursorObserver(Handler paramHandler)
    {
      super();
    }
    
    public void onChange(boolean paramBoolean)
    {
      ConversationCursor.this.underlyingChanged();
    }
  }
  
  private class RefreshTask
    extends AsyncTask<Void, Void, Void>
  {
    private Cursor mCursor = null;
    
    private RefreshTask() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      LogUtils.i("ConversationCursor", "[Start refresh of %s: %d]", new Object[] { mName, Integer.valueOf(hashCode()) });
      mCursor = ConversationCursor.this.doQuery(false);
      mCursor.getCount();
      return null;
    }
    
    protected void onCancelled()
    {
      LogUtils.i("ConversationCursor", "[Ignoring refresh result: %d]", new Object[] { Integer.valueOf(hashCode()) });
      if (mCursor != null) {
        mCursor.close();
      }
    }
    
    protected void onPostExecute(Void arg1)
    {
      synchronized (mCacheMapLock)
      {
        if (isClosed())
        {
          onCancelled();
          return;
        }
        ConversationCursor.access$302(ConversationCursor.this, mCursor);
        ConversationCursor.access$402(ConversationCursor.this, true);
        LogUtils.i("ConversationCursor", "[Query done %s: %d]", new Object[] { mName, Integer.valueOf(hashCode()) });
        if ((!mDeferSync) && (!mPaused)) {
          ConversationCursor.this.notifyRefreshReady();
        }
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */