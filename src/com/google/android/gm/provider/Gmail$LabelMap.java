package com.google.android.gm.provider;

import android.content.ContentQueryMap;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public final class Gmail$LabelMap
  extends Observable
{
  private static final ContentValues EMPTY_CONTENT_VALUES = new ContentValues();
  private Map<String, Long> mCanonicalNameToId;
  private boolean mContentQueryMapPopulated = false;
  private long mLabelIdCached;
  private long mLabelIdChat;
  private long mLabelIdDraft;
  private long mLabelIdIgnored;
  private long mLabelIdImportantImap;
  private long mLabelIdInbox;
  private long mLabelIdMarkImportant;
  private long mLabelIdMarkUnimportant;
  private long mLabelIdOutbox;
  private long mLabelIdSent;
  private long mLabelIdSpam;
  private long mLabelIdStarred;
  private long mLabelIdTrash;
  private long mLabelIdUnread;
  private Boolean mLabelsSynced = null;
  private ContentQueryMap mQueryMap;
  
  public Gmail$LabelMap(ContentResolver paramContentResolver, Cursor paramCursor, boolean paramBoolean)
  {
    init(paramCursor);
  }
  
  public Gmail$LabelMap(ContentResolver paramContentResolver, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    init(paramContentResolver.query(Uri.withAppendedPath(Gmail.getLabelsUri(paramString), "1"), Gmail.LABEL_PROJECTION, null, null, null));
  }
  
  private void checkLabelsSynced()
  {
    if (!labelsSynced()) {
      throw new IllegalStateException("LabelMap not initalized");
    }
  }
  
  private ContentValues getLabelIdValues(long paramLong)
  {
    if (mContentQueryMapPopulated) {}
    for (ContentValues localContentValues = mQueryMap.getValues(Long.toString(paramLong)); localContentValues != null; localContentValues = null) {
      return localContentValues;
    }
    return EMPTY_CONTENT_VALUES;
  }
  
  private void init(Cursor paramCursor)
  {
    mQueryMap = new LabelsContentQueryMap(paramCursor, "_id");
    mCanonicalNameToId = Maps.newHashMap();
    mQueryMap.addObserver(new Observer()
    {
      public void update(Observable paramAnonymousObservable, Object paramAnonymousObject)
      {
        Gmail.LabelMap.this.updateDataStructures();
        setChanged();
        notifyObservers();
      }
    });
  }
  
  private void updateDataStructures()
  {
    for (;;)
    {
      Object localObject2;
      long l;
      boolean bool;
      try
      {
        mContentQueryMapPopulated = true;
        mCanonicalNameToId.clear();
        Iterator localIterator = mQueryMap.getRows().entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        if (str == null) {
          continue;
        }
        l = Long.valueOf(str).longValue();
        localObject2 = ((ContentValues)((Map.Entry)localObject2).getValue()).getAsString("canonicalName");
        mCanonicalNameToId.put(localObject2, Long.valueOf(l));
        if ("^f".equals(localObject2))
        {
          mLabelIdSent = l;
          if ((mLabelIdSent == 0L) || (mLabelIdInbox == 0L) || (mLabelIdDraft == 0L) || (mLabelIdUnread == 0L) || (mLabelIdTrash == 0L) || (mLabelIdSpam == 0L) || (mLabelIdStarred == 0L) || (mLabelIdChat == 0L) || (mLabelIdIgnored == 0L)) {
            break label470;
          }
          bool = true;
          mLabelsSynced = Boolean.valueOf(bool);
          continue;
        }
        if (!"^i".equals(localObject2)) {
          break label250;
        }
      }
      finally {}
      mLabelIdInbox = l;
      continue;
      label250:
      if ("^r".equals(localObject2))
      {
        mLabelIdDraft = l;
      }
      else if ("^u".equals(localObject2))
      {
        mLabelIdUnread = l;
      }
      else if ("^k".equals(localObject2))
      {
        mLabelIdTrash = l;
      }
      else if ("^s".equals(localObject2))
      {
        mLabelIdSpam = l;
      }
      else if ("^t".equals(localObject2))
      {
        mLabelIdStarred = l;
      }
      else if ("^b".equals(localObject2))
      {
        mLabelIdChat = l;
      }
      else if ("^g".equals(localObject2))
      {
        mLabelIdIgnored = l;
      }
      else if ("^^cached".equals(localObject2))
      {
        mLabelIdCached = l;
      }
      else if ("^^out".equals(localObject2))
      {
        mLabelIdOutbox = l;
      }
      else if ("^io_im".equals(localObject2))
      {
        mLabelIdImportantImap = l;
      }
      else if ("^^important".equals(localObject2))
      {
        mLabelIdMarkImportant = l;
      }
      else if ("^^unimportant".equals(localObject2))
      {
        mLabelIdMarkUnimportant = l;
        continue;
        label470:
        bool = false;
      }
    }
  }
  
  public void close()
  {
    mQueryMap.close();
  }
  
  public String getCanonicalName(long paramLong)
  {
    return getLabelIdValues(paramLong).getAsString("canonicalName");
  }
  
  @Deprecated
  public long getLabelId(String paramString)
    throws IllegalArgumentException
  {
    try
    {
      if (labelPresent(paramString))
      {
        long l = ((Long)mCanonicalNameToId.get(paramString)).longValue();
        return l;
      }
      throw new IllegalArgumentException("Unknown canonical name: " + paramString);
    }
    finally {}
  }
  
  public long getLabelIdCached()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdCached;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLabelIdDraft()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdDraft;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLabelIdIgnored()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdIgnored;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLabelIdImportantImap()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdImportantImap;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLabelIdInbox()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdInbox;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLabelIdOutbox()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdOutbox;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLabelIdSent()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdSent;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLabelIdSpam()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdSpam;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLabelIdStarred()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdStarred;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLabelIdTrash()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdTrash;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLabelIdUnread()
  {
    try
    {
      checkLabelsSynced();
      long l = mLabelIdUnread;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getName(long paramLong)
  {
    return getLabelIdValues(paramLong).getAsString("name");
  }
  
  public int getNumConversations(long paramLong)
  {
    return getLabelIdValues(paramLong).getAsInteger("numConversations").intValue();
  }
  
  public int getNumUnreadConversations(long paramLong)
  {
    Integer localInteger = getLabelIdValues(paramLong).getAsInteger("numUnreadConversations");
    if ((localInteger == null) || (localInteger.intValue() < 0)) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  ContentQueryMap getQueryMap()
  {
    return mQueryMap;
  }
  
  public boolean labelPresent(String paramString)
  {
    try
    {
      boolean bool = mCanonicalNameToId.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public boolean labelsSynced()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/google/android/gm/provider/Gmail$LabelMap:mLabelsSynced	Ljava/lang/Boolean;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 52	com/google/android/gm/provider/Gmail$LabelMap:mLabelsSynced	Ljava/lang/Boolean;
    //   13: invokevirtual 344	java/lang/Boolean:booleanValue	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	LabelMap
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  /* Error */
  boolean labelsSynchronizationStateInitialized()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/google/android/gm/provider/Gmail$LabelMap:mLabelsSynced	Ljava/lang/Boolean;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	LabelMap
    //   12	7	1	bool	boolean
    //   6	2	2	localBoolean	Boolean
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public void requery()
  {
    mQueryMap.requery();
  }
  
  static class LabelsContentQueryMap
    extends ContentQueryMap
  {
    public LabelsContentQueryMap(Cursor paramCursor, String paramString)
    {
      super(paramString, true, null);
      super.setKeepUpdated(false);
    }
    
    public void setKeepUpdated(boolean paramBoolean) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Gmail.LabelMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */