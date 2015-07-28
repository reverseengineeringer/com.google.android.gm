package com.android.mail.providers;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.Loader.OnLoadCompleteListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.MatrixCursorWithExtra;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public abstract class MailAppProvider
  extends ContentProvider
  implements Loader.OnLoadCompleteListener<Cursor>
{
  private static final String LOG_TAG = ;
  private static final Set<Uri> PENDING_ACCOUNT_URIS = Sets.newHashSet();
  private static String sAuthority;
  private static MailAppProvider sInstance;
  private final Map<Uri, AccountCacheEntry> mAccountCache = Maps.newHashMap();
  private volatile boolean mAccountsFullyLoaded = false;
  private final Map<Uri, CursorLoader> mCursorLoaderMap = Maps.newHashMap();
  private ContentResolver mResolver;
  private SharedPreferences mSharedPrefs;
  
  private void addAccountImpl(Account paramAccount, Uri paramUri, int paramInt, boolean paramBoolean)
  {
    Map localMap = mAccountCache;
    if (paramAccount != null) {}
    try
    {
      LogUtils.v(LOG_TAG, "adding account %s", new Object[] { paramAccount });
      mAccountCache.put(uri, new AccountCacheEntry(paramAccount, paramUri, paramInt));
      if (paramBoolean) {
        broadcastAccountChange();
      }
      cacheAccountList();
      return;
    }
    finally {}
  }
  
  private void addAccountImpl(Account paramAccount, Uri paramUri, boolean paramBoolean)
  {
    addAccountImpl(paramAccount, paramUri, mAccountCache.size(), paramBoolean);
  }
  
  public static void addAccountsForUriAsync(Uri paramUri)
  {
    synchronized (PENDING_ACCOUNT_URIS)
    {
      MailAppProvider localMailAppProvider = getInstance();
      if (localMailAppProvider != null)
      {
        localMailAppProvider.startAccountsLoader(paramUri);
        return;
      }
      PENDING_ACCOUNT_URIS.add(paramUri);
    }
  }
  
  private static void broadcastAccountChange()
  {
    MailAppProvider localMailAppProvider = sInstance;
    if (localMailAppProvider != null) {
      mResolver.notifyChange(getAccountsUri(), null);
    }
  }
  
  private void cacheAccountList()
  {
    Object localObject2 = Lists.newArrayList();
    synchronized (mAccountCache)
    {
      ((List)localObject2).addAll(mAccountCache.values());
      Collections.sort((List)localObject2);
      ??? = Sets.newHashSet();
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((Set)???).add(((AccountCacheEntry)((Iterator)localObject2).next()).serialize());
      }
    }
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putStringSet("accountList", (Set)???);
    localEditor.apply();
  }
  
  public static Account getAccountFromAccountUri(Uri paramUri)
  {
    MailAppProvider localMailAppProvider = getInstance();
    if ((localMailAppProvider != null) && (mAccountsFullyLoaded)) {
      synchronized (mAccountCache)
      {
        paramUri = (AccountCacheEntry)mAccountCache.get(paramUri);
        if (paramUri != null)
        {
          paramUri = mAccount;
          return paramUri;
        }
      }
    }
    return null;
  }
  
  public static Uri getAccountsUri()
  {
    return Uri.parse("content://" + sAuthority + "/");
  }
  
  public static MailAppProvider getInstance()
  {
    return sInstance;
  }
  
  public static Intent getNoAccountIntent(Context paramContext)
  {
    return getInstance().getNoAccountsIntent(paramContext);
  }
  
  private SharedPreferences getPreferences()
  {
    if (mSharedPrefs == null) {
      mSharedPrefs = getContext().getSharedPreferences("MailAppProvider", 0);
    }
    return mSharedPrefs;
  }
  
  private void loadCachedAccountList()
  {
    Object localObject = getPreferences().getStringSet("accountList", null);
    int i;
    if (localObject != null)
    {
      i = 0;
      localObject = ((Set)localObject).iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        try
        {
          AccountCacheEntry localAccountCacheEntry = new AccountCacheEntry(str, i);
          if (mAccount.settings == null) {
            break label164;
          }
          Account localAccount = mAccount;
          ContentProviderClient localContentProviderClient = mResolver.acquireContentProviderClient(uri);
          if (localContentProviderClient != null)
          {
            localContentProviderClient.release();
            addAccountImpl(localAccount, mAccountsQueryUri, false);
          }
          else
          {
            LogUtils.e(LOG_TAG, "Dropping account without provider: %s", new Object[] { name });
          }
        }
        catch (Exception localException)
        {
          LogUtils.e(LOG_TAG, localException, "Unable to create account object from serialized string '%s'", new Object[] { str });
        }
        continue;
        label164:
        LogUtils.e(LOG_TAG, "Dropping account that doesn't specify settings", new Object[0]);
      }
      else
      {
        broadcastAccountChange();
        return;
      }
      i += 1;
    }
  }
  
  private void removeAccounts(Set<Uri> paramSet, boolean paramBoolean)
  {
    synchronized (mAccountCache)
    {
      paramSet = paramSet.iterator();
      if (paramSet.hasNext())
      {
        Uri localUri = (Uri)paramSet.next();
        LogUtils.d(LOG_TAG, "Removing account %s", new Object[] { localUri });
        mAccountCache.remove(localUri);
      }
    }
    if (paramBoolean) {
      broadcastAccountChange();
    }
    cacheAccountList();
  }
  
  private void startAccountsLoader(Uri paramUri)
  {
    try
    {
      CursorLoader localCursorLoader1 = new CursorLoader(getContext(), paramUri, UIProvider.ACCOUNTS_PROJECTION, null, null, null);
      localCursorLoader1.registerListener(paramUri.hashCode(), this);
      localCursorLoader1.startLoading();
      CursorLoader localCursorLoader2 = (CursorLoader)mCursorLoaderMap.get(paramUri);
      if (localCursorLoader2 != null) {
        localCursorLoader2.stopLoading();
      }
      mCursorLoaderMap.put(paramUri, localCursorLoader1);
      return;
    }
    finally {}
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  protected abstract String getAuthority();
  
  public String getLastSentFromAccount()
  {
    return getPreferences().getString("lastSendFromAccount", null);
  }
  
  public String getLastViewedAccount()
  {
    return getPreferences().getString("lastViewedAccount", null);
  }
  
  protected abstract Intent getNoAccountsIntent(Context paramContext);
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return paramUri;
  }
  
  public boolean onCreate()
  {
    sAuthority = getAuthority();
    mResolver = getContext().getContentResolver();
    ??? = new Intent("com.google.android.gm2.providers.protos.boot.intent.ACTION_PROVIDER_CREATED");
    getContext().sendBroadcast((Intent)???);
    loadCachedAccountList();
    synchronized (PENDING_ACCOUNT_URIS)
    {
      sInstance = this;
      Object localObject2 = ImmutableSet.copyOf(PENDING_ACCOUNT_URIS);
      PENDING_ACCOUNT_URIS.clear();
      localObject2 = ((Set)localObject2).iterator();
      if (((Iterator)localObject2).hasNext()) {
        addAccountsForUriAsync((Uri)((Iterator)localObject2).next());
      }
    }
    return true;
  }
  
  public void onLoadComplete(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    if (paramCursor == null)
    {
      LogUtils.d(LOG_TAG, "null account cursor returned", new Object[0]);
      return;
    }
    LogUtils.d(LOG_TAG, "Cursor with %d accounts returned", new Object[] { Integer.valueOf(paramCursor.getCount()) });
    paramLoader = ((CursorLoader)paramLoader).getUri();
    Object localObject2;
    int i;
    Object localObject3;
    synchronized (mAccountCache)
    {
      localObject2 = ImmutableSet.copyOf(mAccountCache.values());
      i = 0;
      ??? = Sets.newHashSet();
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AccountCacheEntry)((Iterator)localObject2).next();
        if (paramLoader.equals(mAccountsQueryUri)) {
          ((Set)???).add(mAccount.uri);
        }
        if (mPosition > i) {
          i = mPosition;
        }
      }
    }
    if (paramCursor.getExtras().getInt("accounts_loaded") != 0) {}
    for (boolean bool = true;; bool = false)
    {
      mAccountsFullyLoaded = bool;
      localObject2 = Sets.newHashSet();
      while (paramCursor.moveToNext())
      {
        localObject3 = new Account(paramCursor);
        ((Set)localObject2).add(uri);
        addAccountImpl((Account)localObject3, paramLoader, i, false);
        i += 1;
      }
    }
    ((Set)???).removeAll((Collection)localObject2);
    if ((((Set)???).size() > 0) && (mAccountsFullyLoaded)) {
      removeAccounts((Set)???, false);
    }
    broadcastAccountChange();
  }
  
  public Cursor query(Uri paramUri, String[] arg2, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramUri = UIProviderValidator.validateAccountProjection(???);
    paramArrayOfString2 = new Bundle();
    int i;
    if (mAccountsFullyLoaded)
    {
      i = 1;
      paramArrayOfString2.putInt("accounts_loaded", i);
      paramString1 = Lists.newArrayList();
    }
    CharSequence localCharSequence;
    for (;;)
    {
      synchronized (mAccountCache)
      {
        paramString1.addAll(mAccountCache.values());
        Collections.sort(paramString1);
        ??? = new MatrixCursorWithExtra(paramUri, paramString1.size(), paramArrayOfString2);
        paramString1 = paramString1.iterator();
        if (!paramString1.hasNext()) {
          break label1446;
        }
        paramArrayOfString2 = nextmAccount;
        paramString2 = ???.newRow();
        int k = paramUri.length;
        i = 0;
        if (i < k)
        {
          localCharSequence = paramUri[i];
          if (TextUtils.equals(localCharSequence, "_id"))
          {
            paramString2.add(Integer.valueOf(0));
            i += 1;
          }
        }
        else
        {
          continue;
          i = 0;
        }
      }
      if (TextUtils.equals(localCharSequence, "name"))
      {
        paramString2.add(name);
      }
      else if (TextUtils.equals(localCharSequence, "providerVersion"))
      {
        paramString2.add(Integer.valueOf(providerVersion));
      }
      else if (TextUtils.equals(localCharSequence, "accountUri"))
      {
        paramString2.add(uri);
      }
      else if (TextUtils.equals(localCharSequence, "capabilities"))
      {
        paramString2.add(Integer.valueOf(capabilities));
      }
      else if (TextUtils.equals(localCharSequence, "folderListUri"))
      {
        paramString2.add(folderListUri);
      }
      else if (TextUtils.equals(localCharSequence, "fullFolderListUri"))
      {
        paramString2.add(fullFolderListUri);
      }
      else if (TextUtils.equals(localCharSequence, "searchUri"))
      {
        paramString2.add(searchUri);
      }
      else if (TextUtils.equals(localCharSequence, "accountFromAddresses"))
      {
        paramString2.add(accountFromAddresses);
      }
      else if (TextUtils.equals(localCharSequence, "saveDraftUri"))
      {
        paramString2.add(saveDraftUri);
      }
      else if (TextUtils.equals(localCharSequence, "sendMailUri"))
      {
        paramString2.add(sendMessageUri);
      }
      else if (TextUtils.equals(localCharSequence, "expungeMessageUri"))
      {
        paramString2.add(expungeMessageUri);
      }
      else if (TextUtils.equals(localCharSequence, "undoUri"))
      {
        paramString2.add(undoUri);
      }
      else if (TextUtils.equals(localCharSequence, UIProvider.AccountColumns.SETTINGS_INTENT_URI))
      {
        paramString2.add(settingsIntentUri);
      }
      else if (TextUtils.equals(localCharSequence, UIProvider.AccountColumns.HELP_INTENT_URI))
      {
        paramString2.add(helpIntentUri);
      }
      else if (TextUtils.equals(localCharSequence, UIProvider.AccountColumns.SEND_FEEDBACK_INTENT_URI))
      {
        paramString2.add(sendFeedbackIntentUri);
      }
      else if (TextUtils.equals(localCharSequence, UIProvider.AccountColumns.REAUTHENTICATION_INTENT_URI))
      {
        paramString2.add(reauthenticationIntentUri);
      }
      else if (TextUtils.equals(localCharSequence, "syncStatus"))
      {
        paramString2.add(Integer.valueOf(syncStatus));
      }
      else if (TextUtils.equals(localCharSequence, "composeUri"))
      {
        paramString2.add(composeIntentUri);
      }
      else if (TextUtils.equals(localCharSequence, "mimeType"))
      {
        paramString2.add(mimeType);
      }
      else if (TextUtils.equals(localCharSequence, "recentFolderListUri"))
      {
        paramString2.add(recentFolderListUri);
      }
      else if (TextUtils.equals(localCharSequence, "defaultRecentFolderListUri"))
      {
        paramString2.add(defaultRecentFolderListUri);
      }
      else if (TextUtils.equals(localCharSequence, "manualSyncUri"))
      {
        paramString2.add(manualSyncUri);
      }
      else if (TextUtils.equals(localCharSequence, "viewProxyUri"))
      {
        paramString2.add(viewIntentProxyUri);
      }
      else if (TextUtils.equals(localCharSequence, "accountCookieUri"))
      {
        paramString2.add(accoutCookieQueryUri);
      }
      else if (TextUtils.equals(localCharSequence, "color"))
      {
        paramString2.add(Integer.valueOf(color));
      }
      else if (TextUtils.equals(localCharSequence, "signature"))
      {
        paramString2.add(settings.signature);
      }
      else if (TextUtils.equals(localCharSequence, "auto_advance"))
      {
        paramString2.add(Integer.valueOf(settings.autoAdvance));
      }
      else if (TextUtils.equals(localCharSequence, "message_text_size"))
      {
        paramString2.add(Integer.valueOf(settings.messageTextSize));
      }
      else if (TextUtils.equals(localCharSequence, "reply_behavior"))
      {
        paramString2.add(Integer.valueOf(settings.replyBehavior));
      }
      else
      {
        int j;
        if (TextUtils.equals(localCharSequence, "hide_checkboxes"))
        {
          if (settings.hideCheckboxes) {}
          for (j = 1;; j = 0)
          {
            paramString2.add(Integer.valueOf(j));
            break;
          }
        }
        if (TextUtils.equals(localCharSequence, "confirm_delete"))
        {
          if (settings.confirmDelete) {}
          for (j = 1;; j = 0)
          {
            paramString2.add(Integer.valueOf(j));
            break;
          }
        }
        if (TextUtils.equals(localCharSequence, "confirm_archive"))
        {
          if (settings.confirmArchive) {}
          for (j = 1;; j = 0)
          {
            paramString2.add(Integer.valueOf(j));
            break;
          }
        }
        if (TextUtils.equals(localCharSequence, "confirm_send"))
        {
          if (settings.confirmSend) {}
          for (j = 1;; j = 0)
          {
            paramString2.add(Integer.valueOf(j));
            break;
          }
        }
        if (TextUtils.equals(localCharSequence, "default_inbox"))
        {
          paramString2.add(settings.defaultInbox);
        }
        else if (TextUtils.equals(localCharSequence, "default_inbox_name"))
        {
          paramString2.add(settings.defaultInboxName);
        }
        else if (TextUtils.equals(localCharSequence, "snap_headers"))
        {
          paramString2.add(Integer.valueOf(settings.snapHeaders));
        }
        else
        {
          if (TextUtils.equals(localCharSequence, "force_reply_from_default"))
          {
            if (settings.forceReplyFromDefault) {}
            for (j = 1;; j = 0)
            {
              paramString2.add(Integer.valueOf(j));
              break;
            }
          }
          if (TextUtils.equals(localCharSequence, "max_attachment_size"))
          {
            paramString2.add(Integer.valueOf(settings.maxAttachmentSize));
          }
          else if (TextUtils.equals(localCharSequence, "swipe"))
          {
            paramString2.add(Integer.valueOf(settings.swipe));
          }
          else
          {
            if (TextUtils.equals(localCharSequence, "priority_inbox_arrows_enabled"))
            {
              if (settings.priorityArrowsEnabled) {}
              for (j = 1;; j = 0)
              {
                paramString2.add(Integer.valueOf(j));
                break;
              }
            }
            if (TextUtils.equals(localCharSequence, "setup_intent_uri"))
            {
              paramString2.add(settings.setupIntentUri);
            }
            else
            {
              if (!TextUtils.equals(localCharSequence, "conversation_view_mode")) {
                break;
              }
              paramString2.add(Integer.valueOf(settings.conversationViewMode));
            }
          }
        }
      }
    }
    throw new IllegalStateException("Column not found: " + localCharSequence);
    label1446:
    ???.setNotificationUri(mResolver, getAccountsUri());
    return (Cursor)???;
  }
  
  public void setLastSentFromAccount(String paramString)
  {
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putString("lastSendFromAccount", paramString);
    localEditor.apply();
  }
  
  public void setLastViewedAccount(String paramString)
  {
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putString("lastViewedAccount", paramString);
    localEditor.apply();
  }
  
  public void shutdown()
  {
    synchronized (PENDING_ACCOUNT_URIS)
    {
      sInstance = null;
      ??? = mCursorLoaderMap.values().iterator();
      if (((Iterator)???).hasNext()) {
        ((CursorLoader)((Iterator)???).next()).stopLoading();
      }
    }
    mCursorLoaderMap.clear();
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  private static class AccountCacheEntry
    implements Comparable<AccountCacheEntry>
  {
    private static final Pattern ACCOUNT_ENTRY_COMPONENT_SEPARATOR_PATTERN = Pattern.compile("\\^\\*\\*\\^");
    final Account mAccount;
    final Uri mAccountsQueryUri;
    final int mPosition;
    
    public AccountCacheEntry(Account paramAccount, Uri paramUri, int paramInt)
    {
      mAccount = paramAccount;
      mAccountsQueryUri = paramUri;
      mPosition = paramInt;
    }
    
    public AccountCacheEntry(String paramString, int paramInt)
      throws IllegalArgumentException
    {
      String[] arrayOfString = TextUtils.split(paramString, ACCOUNT_ENTRY_COMPONENT_SEPARATOR_PATTERN);
      if (arrayOfString.length != 2) {
        throw new IllegalArgumentException("AccountCacheEntry de-serializing failed. Wrong number of members detected. " + arrayOfString.length + " detected");
      }
      mAccount = Account.newinstance(arrayOfString[0]);
      if (mAccount == null) {
        throw new IllegalArgumentException("AccountCacheEntry de-serializing failed. Account object could not be created from the serialized string: " + paramString);
      }
      if (mAccount.settings == Settings.EMPTY_SETTINGS) {
        throw new IllegalArgumentException("AccountCacheEntry de-serializing failed. Settings could not be created from the string: " + paramString);
      }
      if (!TextUtils.isEmpty(arrayOfString[1])) {}
      for (paramString = Uri.parse(arrayOfString[1]);; paramString = null)
      {
        mAccountsQueryUri = paramString;
        mPosition = paramInt;
        return;
      }
    }
    
    public int compareTo(AccountCacheEntry paramAccountCacheEntry)
    {
      return mPosition - mPosition;
    }
    
    /* Error */
    public String serialize()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new 52	java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   9: astore_2
      //   10: aload_2
      //   11: aload_0
      //   12: getfield 37	com/android/mail/providers/MailAppProvider$AccountCacheEntry:mAccount	Lcom/android/mail/providers/Account;
      //   15: invokevirtual 109	com/android/mail/providers/Account:serialize	()Ljava/lang/String;
      //   18: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: ldc 111
      //   23: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   26: pop
      //   27: aload_0
      //   28: getfield 39	com/android/mail/providers/MailAppProvider$AccountCacheEntry:mAccountsQueryUri	Landroid/net/Uri;
      //   31: ifnull +26 -> 57
      //   34: aload_0
      //   35: getfield 39	com/android/mail/providers/MailAppProvider$AccountCacheEntry:mAccountsQueryUri	Landroid/net/Uri;
      //   38: invokevirtual 112	android/net/Uri:toString	()Ljava/lang/String;
      //   41: astore_1
      //   42: aload_2
      //   43: aload_1
      //   44: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: pop
      //   48: aload_2
      //   49: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   52: astore_1
      //   53: aload_0
      //   54: monitorexit
      //   55: aload_1
      //   56: areturn
      //   57: ldc 114
      //   59: astore_1
      //   60: goto -18 -> 42
      //   63: astore_1
      //   64: aload_0
      //   65: monitorexit
      //   66: aload_1
      //   67: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	AccountCacheEntry
      //   41	19	1	str	String
      //   63	4	1	localObject	Object
      //   9	40	2	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   2	42	63	finally
      //   42	53	63	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.MailAppProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */