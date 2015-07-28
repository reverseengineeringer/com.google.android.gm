package com.android.mail.providers;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Account
  extends android.accounts.Account
  implements Parcelable
{
  public static final Parcelable.Creator<Account> CREATOR;
  private static final String LOG_TAG;
  public String accountFromAddresses;
  public final Uri accoutCookieQueryUri;
  public final int capabilities;
  public final int color;
  public final Uri composeIntentUri;
  public final Uri defaultRecentFolderListUri;
  public final Uri expungeMessageUri;
  public final Uri folderListUri;
  public Uri fullFolderListUri;
  public final Uri helpIntentUri;
  private transient List<ReplyFromAccount> mReplyFroms;
  public final Uri manualSyncUri;
  public final String mimeType;
  public final int providerVersion;
  public final Uri reauthenticationIntentUri;
  public final Uri recentFolderListUri;
  public final Uri saveDraftUri;
  public final Uri searchUri;
  public final Uri sendFeedbackIntentUri;
  public final Uri sendMessageUri;
  public final Settings settings;
  public final Uri settingsIntentUri;
  public final int syncStatus;
  public final Uri undoUri;
  public final Uri uri;
  public final Uri viewIntentProxyUri;
  
  static
  {
    if (!Account.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LOG_TAG = LogTag.getLogTag();
      CREATOR = new Parcelable.Creator()
      {
        public Account createFromParcel(Parcel paramAnonymousParcel)
        {
          return new Account(paramAnonymousParcel);
        }
        
        public Account[] newArray(int paramAnonymousInt)
        {
          return new Account[paramAnonymousInt];
        }
      };
      return;
    }
  }
  
  public Account(Cursor paramCursor)
  {
    super(paramCursor.getString(1), "unknown");
    accountFromAddresses = paramCursor.getString(8);
    capabilities = paramCursor.getInt(4);
    providerVersion = paramCursor.getInt(2);
    uri = Uri.parse(paramCursor.getString(3));
    folderListUri = Uri.parse(paramCursor.getString(5));
    fullFolderListUri = Utils.getValidUri(paramCursor.getString(6));
    searchUri = Utils.getValidUri(paramCursor.getString(7));
    saveDraftUri = Utils.getValidUri(paramCursor.getString(9));
    sendMessageUri = Utils.getValidUri(paramCursor.getString(10));
    expungeMessageUri = Utils.getValidUri(paramCursor.getString(11));
    undoUri = Utils.getValidUri(paramCursor.getString(12));
    settingsIntentUri = Utils.getValidUri(paramCursor.getString(13));
    helpIntentUri = Utils.getValidUri(paramCursor.getString(15));
    sendFeedbackIntentUri = Utils.getValidUri(paramCursor.getString(16));
    reauthenticationIntentUri = Utils.getValidUri(paramCursor.getString(17));
    syncStatus = paramCursor.getInt(14);
    composeIntentUri = Utils.getValidUri(paramCursor.getString(18));
    mimeType = paramCursor.getString(19);
    recentFolderListUri = Utils.getValidUri(paramCursor.getString(20));
    color = paramCursor.getInt(21);
    defaultRecentFolderListUri = Utils.getValidUri(paramCursor.getString(22));
    manualSyncUri = Utils.getValidUri(paramCursor.getString(23));
    viewIntentProxyUri = Utils.getValidUri(paramCursor.getString(24));
    accoutCookieQueryUri = Utils.getValidUri(paramCursor.getString(25));
    settings = new Settings(paramCursor);
  }
  
  public Account(Parcel paramParcel)
  {
    super(paramParcel);
    providerVersion = paramParcel.readInt();
    uri = ((Uri)paramParcel.readParcelable(null));
    capabilities = paramParcel.readInt();
    folderListUri = ((Uri)paramParcel.readParcelable(null));
    fullFolderListUri = ((Uri)paramParcel.readParcelable(null));
    searchUri = ((Uri)paramParcel.readParcelable(null));
    accountFromAddresses = paramParcel.readString();
    saveDraftUri = ((Uri)paramParcel.readParcelable(null));
    sendMessageUri = ((Uri)paramParcel.readParcelable(null));
    expungeMessageUri = ((Uri)paramParcel.readParcelable(null));
    undoUri = ((Uri)paramParcel.readParcelable(null));
    settingsIntentUri = ((Uri)paramParcel.readParcelable(null));
    helpIntentUri = ((Uri)paramParcel.readParcelable(null));
    sendFeedbackIntentUri = ((Uri)paramParcel.readParcelable(null));
    reauthenticationIntentUri = ((Uri)paramParcel.readParcelable(null));
    syncStatus = paramParcel.readInt();
    composeIntentUri = ((Uri)paramParcel.readParcelable(null));
    mimeType = paramParcel.readString();
    recentFolderListUri = ((Uri)paramParcel.readParcelable(null));
    color = paramParcel.readInt();
    defaultRecentFolderListUri = ((Uri)paramParcel.readParcelable(null));
    manualSyncUri = ((Uri)paramParcel.readParcelable(null));
    viewIntentProxyUri = ((Uri)paramParcel.readParcelable(null));
    accoutCookieQueryUri = ((Uri)paramParcel.readParcelable(null));
    paramParcel = Settings.newInstance(paramParcel.readString());
    if (paramParcel != null)
    {
      settings = paramParcel;
      return;
    }
    LogUtils.e(LOG_TAG, new Throwable(), "Unexpected null settings in Account(Parcel)", new Object[0]);
    settings = Settings.EMPTY_SETTINGS;
  }
  
  private Account(String paramString1, String paramString2, String paramString3)
    throws JSONException
  {
    super(paramString1, paramString2);
    paramString1 = new JSONObject(paramString3);
    providerVersion = paramString1.getInt("providerVersion");
    uri = Uri.parse(paramString1.optString("accountUri"));
    capabilities = paramString1.getInt("capabilities");
    folderListUri = Utils.getValidUri(paramString1.optString("folderListUri"));
    fullFolderListUri = Utils.getValidUri(paramString1.optString("fullFolderListUri"));
    searchUri = Utils.getValidUri(paramString1.optString("searchUri"));
    accountFromAddresses = paramString1.optString("accountFromAddresses", "");
    saveDraftUri = Utils.getValidUri(paramString1.optString("saveDraftUri"));
    sendMessageUri = Utils.getValidUri(paramString1.optString("sendMailUri"));
    expungeMessageUri = Utils.getValidUri(paramString1.optString("expungeMessageUri"));
    undoUri = Utils.getValidUri(paramString1.optString("undoUri"));
    settingsIntentUri = Utils.getValidUri(paramString1.optString(UIProvider.AccountColumns.SETTINGS_INTENT_URI));
    helpIntentUri = Utils.getValidUri(paramString1.optString(UIProvider.AccountColumns.HELP_INTENT_URI));
    sendFeedbackIntentUri = Utils.getValidUri(paramString1.optString(UIProvider.AccountColumns.SEND_FEEDBACK_INTENT_URI));
    reauthenticationIntentUri = Utils.getValidUri(paramString1.optString(UIProvider.AccountColumns.REAUTHENTICATION_INTENT_URI));
    syncStatus = paramString1.optInt("syncStatus");
    composeIntentUri = Utils.getValidUri(paramString1.optString("composeUri"));
    mimeType = paramString1.optString("mimeType");
    recentFolderListUri = Utils.getValidUri(paramString1.optString("recentFolderListUri"));
    color = paramString1.optInt("color", 0);
    defaultRecentFolderListUri = Utils.getValidUri(paramString1.optString("defaultRecentFolderListUri"));
    manualSyncUri = Utils.getValidUri(paramString1.optString("manualSyncUri"));
    viewIntentProxyUri = Utils.getValidUri(paramString1.optString("viewProxyUri"));
    accoutCookieQueryUri = Utils.getValidUri(paramString1.optString("accountCookieUri"));
    paramString1 = Settings.newInstance(paramString1.optJSONObject("settings"));
    if (paramString1 != null)
    {
      settings = paramString1;
      return;
    }
    LogUtils.e(LOG_TAG, new Throwable(), "Unexpected null settings in Account(name, type, jsonAccount)", new Object[0]);
    settings = Settings.EMPTY_SETTINGS;
  }
  
  public static int findPosition(Account[] paramArrayOfAccount, Uri paramUri)
  {
    if ((paramArrayOfAccount != null) && (paramArrayOfAccount.length > 0) && (paramUri != null))
    {
      int i = 0;
      int j = paramArrayOfAccount.length;
      while (i < j)
      {
        if (uri.equals(paramUri))
        {
          LogUtils.d(LOG_TAG, "findPositionOfAccount: Found needle at position %d", new Object[] { Integer.valueOf(i) });
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static Account[] getAllAccounts(Cursor paramCursor)
  {
    int k = paramCursor.getCount();
    if ((k <= 0) || (!paramCursor.moveToFirst()))
    {
      paramCursor = new Account[0];
      return paramCursor;
    }
    Account[] arrayOfAccount = new Account[k];
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      arrayOfAccount[i] = new Account(paramCursor);
      if (!paramCursor.moveToNext())
      {
        paramCursor = arrayOfAccount;
        if ($assertionsDisabled) {
          break;
        }
        paramCursor = arrayOfAccount;
        if (j == k) {
          break;
        }
        throw new AssertionError();
      }
    }
  }
  
  public static Account newinstance(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        localObject = new Account((String)((JSONObject)localObject).get("name"), (String)((JSONObject)localObject).get("type"), paramString);
        return (Account)localObject;
      }
      catch (JSONException localJSONException2)
      {
        for (;;) {}
      }
      localJSONException1 = localJSONException1;
    }
    tmp52_49[0] = paramString;
    LogUtils.e(LOG_TAG, localJSONException1, "Could not create an account from this input: \"%s\"", tmp52_49);
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
      paramObject = (Account)paramObject;
    } while ((TextUtils.equals(name, name)) && (TextUtils.equals(type, type)) && (capabilities == capabilities) && (providerVersion == providerVersion) && (Objects.equal(uri, uri)) && (Objects.equal(folderListUri, folderListUri)) && (Objects.equal(fullFolderListUri, fullFolderListUri)) && (Objects.equal(searchUri, searchUri)) && (Objects.equal(accountFromAddresses, accountFromAddresses)) && (Objects.equal(saveDraftUri, saveDraftUri)) && (Objects.equal(sendMessageUri, sendMessageUri)) && (Objects.equal(expungeMessageUri, expungeMessageUri)) && (Objects.equal(undoUri, undoUri)) && (Objects.equal(settingsIntentUri, settingsIntentUri)) && (Objects.equal(helpIntentUri, helpIntentUri)) && (Objects.equal(sendFeedbackIntentUri, sendFeedbackIntentUri)) && (Objects.equal(reauthenticationIntentUri, reauthenticationIntentUri)) && (syncStatus == syncStatus) && (Objects.equal(composeIntentUri, composeIntentUri)) && (TextUtils.equals(mimeType, mimeType)) && (Objects.equal(recentFolderListUri, recentFolderListUri)) && (color == color) && (Objects.equal(defaultRecentFolderListUri, defaultRecentFolderListUri)) && (Objects.equal(viewIntentProxyUri, viewIntentProxyUri)) && (Objects.equal(accoutCookieQueryUri, accoutCookieQueryUri)) && (Objects.equal(settings, settings)));
    return false;
  }
  
  public List<ReplyFromAccount> getReplyFroms()
  {
    if (mReplyFroms == null)
    {
      mReplyFroms = Lists.newArrayList();
      if (supportsCapability(524288)) {
        return mReplyFroms;
      }
      mReplyFroms.add(new ReplyFromAccount(this, uri, name, name, name, false, false));
      if (!TextUtils.isEmpty(accountFromAddresses)) {
        try
        {
          JSONArray localJSONArray = new JSONArray(accountFromAddresses);
          int i = 0;
          int j = localJSONArray.length();
          while (i < j)
          {
            ReplyFromAccount localReplyFromAccount = ReplyFromAccount.deserialize(this, localJSONArray.getJSONObject(i));
            if (localReplyFromAccount != null) {
              mReplyFroms.add(localReplyFromAccount);
            }
            i += 1;
          }
          return mReplyFroms;
        }
        catch (JSONException localJSONException)
        {
          LogUtils.e(LOG_TAG, localJSONException, "Unable to parse accountFromAddresses. name=%s", new Object[] { name });
        }
      }
    }
  }
  
  public int hashCode()
  {
    return super.hashCode() ^ Objects.hashCode(new Object[] { name, type, Integer.valueOf(capabilities), Integer.valueOf(providerVersion), uri, folderListUri, fullFolderListUri, searchUri, accountFromAddresses, saveDraftUri, sendMessageUri, expungeMessageUri, undoUri, settingsIntentUri, helpIntentUri, sendFeedbackIntentUri, reauthenticationIntentUri, Integer.valueOf(syncStatus), composeIntentUri, mimeType, recentFolderListUri, Integer.valueOf(color), defaultRecentFolderListUri, viewIntentProxyUri, accoutCookieQueryUri });
  }
  
  public boolean isAccountInitializationRequired()
  {
    return (syncStatus & 0x20) == 32;
  }
  
  public boolean isAccountReady()
  {
    return (!isAccountInitializationRequired()) && (!isAccountSyncRequired());
  }
  
  public boolean isAccountSyncRequired()
  {
    return (syncStatus & 0x8) == 8;
  }
  
  public boolean matches(Account paramAccount)
  {
    return (paramAccount != null) && (Objects.equal(uri, uri));
  }
  
  public boolean ownsFromAddress(String paramString)
  {
    Iterator localIterator = getReplyFroms().iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(nextaddress, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public String serialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 192	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 415	org/json/JSONObject:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: ldc_w 300
    //   14: aload_0
    //   15: getfield 318	android/accounts/Account:name	Ljava/lang/String;
    //   18: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload_1
    //   23: ldc_w 308
    //   26: aload_0
    //   27: getfield 325	android/accounts/Account:type	Ljava/lang/String;
    //   30: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: pop
    //   34: aload_1
    //   35: ldc -60
    //   37: aload_0
    //   38: getfield 92	com/android/mail/providers/Account:providerVersion	I
    //   41: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   44: pop
    //   45: aload_1
    //   46: ldc -55
    //   48: aload_0
    //   49: getfield 100	com/android/mail/providers/Account:uri	Landroid/net/Uri;
    //   52: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload_1
    //   57: ldc -50
    //   59: aload_0
    //   60: getfield 90	com/android/mail/providers/Account:capabilities	I
    //   63: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   66: pop
    //   67: aload_1
    //   68: ldc -49
    //   70: aload_0
    //   71: getfield 102	com/android/mail/providers/Account:folderListUri	Landroid/net/Uri;
    //   74: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   77: pop
    //   78: aload_1
    //   79: ldc -48
    //   81: aload_0
    //   82: getfield 109	com/android/mail/providers/Account:fullFolderListUri	Landroid/net/Uri;
    //   85: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   88: pop
    //   89: aload_1
    //   90: ldc -47
    //   92: aload_0
    //   93: getfield 111	com/android/mail/providers/Account:searchUri	Landroid/net/Uri;
    //   96: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload_1
    //   101: ldc -46
    //   103: aload_0
    //   104: getfield 84	com/android/mail/providers/Account:accountFromAddresses	Ljava/lang/String;
    //   107: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   110: pop
    //   111: aload_1
    //   112: ldc -40
    //   114: aload_0
    //   115: getfield 113	com/android/mail/providers/Account:saveDraftUri	Landroid/net/Uri;
    //   118: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   121: pop
    //   122: aload_1
    //   123: ldc -38
    //   125: aload_0
    //   126: getfield 115	com/android/mail/providers/Account:sendMessageUri	Landroid/net/Uri;
    //   129: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   132: pop
    //   133: aload_1
    //   134: ldc -37
    //   136: aload_0
    //   137: getfield 117	com/android/mail/providers/Account:expungeMessageUri	Landroid/net/Uri;
    //   140: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_1
    //   145: ldc -36
    //   147: aload_0
    //   148: getfield 119	com/android/mail/providers/Account:undoUri	Landroid/net/Uri;
    //   151: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   154: pop
    //   155: aload_1
    //   156: getstatic 225	com/android/mail/providers/UIProvider$AccountColumns:SETTINGS_INTENT_URI	Ljava/lang/String;
    //   159: aload_0
    //   160: getfield 121	com/android/mail/providers/Account:settingsIntentUri	Landroid/net/Uri;
    //   163: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload_1
    //   168: getstatic 228	com/android/mail/providers/UIProvider$AccountColumns:HELP_INTENT_URI	Ljava/lang/String;
    //   171: aload_0
    //   172: getfield 123	com/android/mail/providers/Account:helpIntentUri	Landroid/net/Uri;
    //   175: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload_1
    //   180: getstatic 231	com/android/mail/providers/UIProvider$AccountColumns:SEND_FEEDBACK_INTENT_URI	Ljava/lang/String;
    //   183: aload_0
    //   184: getfield 125	com/android/mail/providers/Account:sendFeedbackIntentUri	Landroid/net/Uri;
    //   187: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_1
    //   192: getstatic 234	com/android/mail/providers/UIProvider$AccountColumns:REAUTHENTICATION_INTENT_URI	Ljava/lang/String;
    //   195: aload_0
    //   196: getfield 127	com/android/mail/providers/Account:reauthenticationIntentUri	Landroid/net/Uri;
    //   199: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   202: pop
    //   203: aload_1
    //   204: ldc -21
    //   206: aload_0
    //   207: getfield 129	com/android/mail/providers/Account:syncStatus	I
    //   210: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   213: pop
    //   214: aload_1
    //   215: ldc -16
    //   217: aload_0
    //   218: getfield 131	com/android/mail/providers/Account:composeIntentUri	Landroid/net/Uri;
    //   221: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   224: pop
    //   225: aload_1
    //   226: ldc -15
    //   228: aload_0
    //   229: getfield 133	com/android/mail/providers/Account:mimeType	Ljava/lang/String;
    //   232: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   235: pop
    //   236: aload_1
    //   237: ldc -14
    //   239: aload_0
    //   240: getfield 135	com/android/mail/providers/Account:recentFolderListUri	Landroid/net/Uri;
    //   243: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: aload_1
    //   248: ldc -13
    //   250: aload_0
    //   251: getfield 137	com/android/mail/providers/Account:color	I
    //   254: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   257: pop
    //   258: aload_1
    //   259: ldc -9
    //   261: aload_0
    //   262: getfield 139	com/android/mail/providers/Account:defaultRecentFolderListUri	Landroid/net/Uri;
    //   265: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload_1
    //   270: ldc -8
    //   272: aload_0
    //   273: getfield 141	com/android/mail/providers/Account:manualSyncUri	Landroid/net/Uri;
    //   276: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload_1
    //   281: ldc -6
    //   283: aload_0
    //   284: getfield 143	com/android/mail/providers/Account:viewIntentProxyUri	Landroid/net/Uri;
    //   287: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload_1
    //   292: ldc -4
    //   294: aload_0
    //   295: getfield 145	com/android/mail/providers/Account:accoutCookieQueryUri	Landroid/net/Uri;
    //   298: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   301: pop
    //   302: aload_0
    //   303: getfield 151	com/android/mail/providers/Account:settings	Lcom/android/mail/providers/Settings;
    //   306: ifnull +17 -> 323
    //   309: aload_1
    //   310: ldc -3
    //   312: aload_0
    //   313: getfield 151	com/android/mail/providers/Account:settings	Lcom/android/mail/providers/Settings;
    //   316: invokevirtual 426	com/android/mail/providers/Settings:toJSON	()Lorg/json/JSONObject;
    //   319: invokevirtual 419	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   322: pop
    //   323: aload_1
    //   324: invokevirtual 429	org/json/JSONObject:toString	()Ljava/lang/String;
    //   327: astore_1
    //   328: aload_0
    //   329: monitorexit
    //   330: aload_1
    //   331: areturn
    //   332: astore_2
    //   333: getstatic 64	com/android/mail/providers/Account:LOG_TAG	Ljava/lang/String;
    //   336: aload_2
    //   337: ldc_w 431
    //   340: iconst_1
    //   341: anewarray 178	java/lang/Object
    //   344: dup
    //   345: iconst_0
    //   346: aload_0
    //   347: getfield 318	android/accounts/Account:name	Ljava/lang/String;
    //   350: aastore
    //   351: invokestatic 434	com/android/mail/utils/LogUtils:wtf	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   354: pop
    //   355: goto -32 -> 323
    //   358: astore_1
    //   359: aload_0
    //   360: monitorexit
    //   361: aload_1
    //   362: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	Account
    //   9	322	1	localObject1	Object
    //   358	4	1	localObject2	Object
    //   332	5	2	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   10	323	332	org/json/JSONException
    //   2	10	358	finally
    //   10	323	358	finally
    //   323	328	358	finally
    //   333	355	358	finally
  }
  
  public boolean supportsCapability(int paramInt)
  {
    return (capabilities & paramInt) != 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(name);
    localStringBuilder.append(",type=");
    localStringBuilder.append(type);
    localStringBuilder.append(",accountFromAddressUri=");
    localStringBuilder.append(accountFromAddresses);
    localStringBuilder.append(",capabilities=");
    localStringBuilder.append(capabilities);
    localStringBuilder.append(",providerVersion=");
    localStringBuilder.append(providerVersion);
    localStringBuilder.append(",folderListUri=");
    localStringBuilder.append(folderListUri);
    localStringBuilder.append(",fullFolderListUri=");
    localStringBuilder.append(fullFolderListUri);
    localStringBuilder.append(",searchUri=");
    localStringBuilder.append(searchUri);
    localStringBuilder.append(",saveDraftUri=");
    localStringBuilder.append(saveDraftUri);
    localStringBuilder.append(",sendMessageUri=");
    localStringBuilder.append(sendMessageUri);
    localStringBuilder.append(",expungeMessageUri=");
    localStringBuilder.append(expungeMessageUri);
    localStringBuilder.append(",undoUri=");
    localStringBuilder.append(undoUri);
    localStringBuilder.append(",settingsIntentUri=");
    localStringBuilder.append(settingsIntentUri);
    localStringBuilder.append(",helpIntentUri=");
    localStringBuilder.append(helpIntentUri);
    localStringBuilder.append(",sendFeedbackIntentUri=");
    localStringBuilder.append(sendFeedbackIntentUri);
    localStringBuilder.append(",reauthenticationIntentUri=");
    localStringBuilder.append(reauthenticationIntentUri);
    localStringBuilder.append(",syncStatus=");
    localStringBuilder.append(syncStatus);
    localStringBuilder.append(",composeIntentUri=");
    localStringBuilder.append(composeIntentUri);
    localStringBuilder.append(",mimeType=");
    localStringBuilder.append(mimeType);
    localStringBuilder.append(",recentFoldersUri=");
    localStringBuilder.append(recentFolderListUri);
    localStringBuilder.append(",color=");
    localStringBuilder.append(Integer.toHexString(color));
    localStringBuilder.append(",defaultRecentFoldersUri=");
    localStringBuilder.append(defaultRecentFolderListUri);
    localStringBuilder.append(",settings=");
    localStringBuilder.append(settings.serialize());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(providerVersion);
    paramParcel.writeParcelable(uri, 0);
    paramParcel.writeInt(capabilities);
    paramParcel.writeParcelable(folderListUri, 0);
    paramParcel.writeParcelable(fullFolderListUri, 0);
    paramParcel.writeParcelable(searchUri, 0);
    paramParcel.writeString(accountFromAddresses);
    paramParcel.writeParcelable(saveDraftUri, 0);
    paramParcel.writeParcelable(sendMessageUri, 0);
    paramParcel.writeParcelable(expungeMessageUri, 0);
    paramParcel.writeParcelable(undoUri, 0);
    paramParcel.writeParcelable(settingsIntentUri, 0);
    paramParcel.writeParcelable(helpIntentUri, 0);
    paramParcel.writeParcelable(sendFeedbackIntentUri, 0);
    paramParcel.writeParcelable(reauthenticationIntentUri, 0);
    paramParcel.writeInt(syncStatus);
    paramParcel.writeParcelable(composeIntentUri, 0);
    paramParcel.writeString(mimeType);
    paramParcel.writeParcelable(recentFolderListUri, 0);
    paramParcel.writeInt(color);
    paramParcel.writeParcelable(defaultRecentFolderListUri, 0);
    paramParcel.writeParcelable(manualSyncUri, 0);
    paramParcel.writeParcelable(viewIntentProxyUri, 0);
    paramParcel.writeParcelable(accoutCookieQueryUri, 0);
    if (settings == null) {
      LogUtils.e(LOG_TAG, "unexpected null settings object in writeToParcel", new Object[0]);
    }
    if (settings != null) {}
    for (String str = settings.serialize();; str = "")
    {
      paramParcel.writeString(str);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Account
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */