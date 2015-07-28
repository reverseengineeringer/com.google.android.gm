package com.google.android.gm;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.LogUtils;
import com.google.android.gm.provider.MailEngine;
import com.google.android.gsf.GoogleLoginServiceConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountHelper
{
  private final Context mContext;
  
  public AccountHelper(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public AccountHelper(RestrictedActivity paramRestrictedActivity)
  {
    mContext = paramRestrictedActivity.getContext();
  }
  
  public static void getSyncingAccounts(Context paramContext, AccountManagerCallback<Account[]> paramAccountManagerCallback)
  {
    AccountManager.get(paramContext).getAccountsByTypeAndFeatures("com.google", new String[] { GoogleLoginServiceConstants.featureForService("mail") }, paramAccountManagerCallback, null);
  }
  
  public static List<String> mergeAccountLists(List<String> paramList, Account[] paramArrayOfAccount, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramArrayOfAccount.length)
    {
      String str = name;
      MailEngine localMailEngine = MailEngine.getMailEngine(str);
      if (((localMailEngine != null) && (localMailEngine.labelsSynced())) || (paramBoolean)) {
        localArrayList.add(str);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramBoolean) || ((paramList != null) && (paramList.contains(str)))) {
          localArrayList.add(str);
        }
      }
    }
    return localArrayList;
  }
  
  public static void promptForCredentials(Activity paramActivity, String paramString, CredentialsCallback paramCredentialsCallback)
  {
    paramString = new Account(paramString, "com.google");
    Bundle localBundle = new Bundle();
    AccountManager.get(paramActivity).getAuthToken(paramString, "mail", localBundle, paramActivity, new AccountManagerCallback()
    {
      public void run(AccountManagerFuture<Bundle> paramAnonymousAccountManagerFuture)
      {
        boolean bool = false;
        try
        {
          paramAnonymousAccountManagerFuture = (Bundle)paramAnonymousAccountManagerFuture.getResult();
          bool = true;
        }
        catch (OperationCanceledException paramAnonymousAccountManagerFuture)
        {
          for (;;)
          {
            LogUtils.v("Gmail", "promptForCredentials(): User Canceled", new Object[0]);
          }
        }
        catch (IOException paramAnonymousAccountManagerFuture)
        {
          for (;;)
          {
            LogUtils.v("Gmail", "promptForCredentials(): IO Error", new Object[0]);
          }
        }
        catch (AuthenticatorException paramAnonymousAccountManagerFuture)
        {
          for (;;)
          {
            LogUtils.v("Gmail", "promptForCredentials(): Not Authenticated", new Object[0]);
          }
        }
        val$callback.onCredentialsResult(bool);
      }
    }, null);
  }
  
  public static void showAddAccount(Activity paramActivity, AddAccountCallback paramAddAccountCallback)
  {
    Bundle localBundle = null;
    final PendingIntent localPendingIntent = PendingIntent.getActivity(paramActivity, -1, new Intent("android.intent.action.VIEW"), 0);
    if (Gmail.isRunningICSOrLater())
    {
      localBundle = new Bundle();
      localBundle.putBoolean("allowSkip", false);
      localBundle.putString("introMessage", paramActivity.getResources().getString(2131493171));
      localBundle.putParcelable("pendingIntent", localPendingIntent);
    }
    AccountManager.get(paramActivity).addAccount("com.google", "mail", null, localBundle, paramActivity, new AccountManagerCallback()
    {
      /* Error */
      public void run(AccountManagerFuture<Bundle> paramAnonymousAccountManagerFuture)
      {
        // Byte code:
        //   0: aload_1
        //   1: invokeinterface 40 1 0
        //   6: ifeq +28 -> 34
        //   9: aload_0
        //   10: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   13: ifnull +13 -> 26
        //   16: aload_0
        //   17: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   20: aconst_null
        //   21: invokeinterface 46 2 0
        //   26: aload_0
        //   27: getfield 22	com/google/android/gm/AccountHelper$2:val$pendingIntent	Landroid/app/PendingIntent;
        //   30: invokevirtual 51	android/app/PendingIntent:cancel	()V
        //   33: return
        //   34: aconst_null
        //   35: astore_2
        //   36: aconst_null
        //   37: astore 4
        //   39: aconst_null
        //   40: astore 5
        //   42: aconst_null
        //   43: astore_3
        //   44: aconst_null
        //   45: astore 6
        //   47: aload_1
        //   48: invokeinterface 55 1 0
        //   53: checkcast 57	android/os/Bundle
        //   56: astore_1
        //   57: aload_1
        //   58: ldc 59
        //   60: invokevirtual 63	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   63: astore 7
        //   65: aload_1
        //   66: ldc 65
        //   68: invokevirtual 63	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   71: astore 8
        //   73: aload 6
        //   75: astore_1
        //   76: aload 7
        //   78: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   81: ifne +42 -> 123
        //   84: aload 6
        //   86: astore_1
        //   87: aload 8
        //   89: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   92: ifne +31 -> 123
        //   95: new 73	android/accounts/Account
        //   98: dup
        //   99: aload 7
        //   101: aload 8
        //   103: invokespecial 76	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   106: astore_1
        //   107: aload_1
        //   108: ldc 78
        //   110: invokestatic 84	android/content/ContentResolver:getIsSyncable	(Landroid/accounts/Account;Ljava/lang/String;)I
        //   113: ifge +10 -> 123
        //   116: aload_1
        //   117: ldc 78
        //   119: iconst_1
        //   120: invokestatic 88	android/content/ContentResolver:setSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;Z)V
        //   123: aload_0
        //   124: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   127: ifnull +13 -> 140
        //   130: aload_0
        //   131: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   134: aload_1
        //   135: invokeinterface 46 2 0
        //   140: aload_0
        //   141: getfield 22	com/google/android/gm/AccountHelper$2:val$pendingIntent	Landroid/app/PendingIntent;
        //   144: invokevirtual 51	android/app/PendingIntent:cancel	()V
        //   147: return
        //   148: astore_1
        //   149: aload_2
        //   150: astore_1
        //   151: aload_0
        //   152: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   155: ifnull +13 -> 168
        //   158: aload_0
        //   159: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   162: aload_1
        //   163: invokeinterface 46 2 0
        //   168: aload_0
        //   169: getfield 22	com/google/android/gm/AccountHelper$2:val$pendingIntent	Landroid/app/PendingIntent;
        //   172: invokevirtual 51	android/app/PendingIntent:cancel	()V
        //   175: return
        //   176: astore_1
        //   177: aload 4
        //   179: astore_1
        //   180: aload_0
        //   181: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   184: ifnull +13 -> 197
        //   187: aload_0
        //   188: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   191: aload_1
        //   192: invokeinterface 46 2 0
        //   197: aload_0
        //   198: getfield 22	com/google/android/gm/AccountHelper$2:val$pendingIntent	Landroid/app/PendingIntent;
        //   201: invokevirtual 51	android/app/PendingIntent:cancel	()V
        //   204: return
        //   205: astore_1
        //   206: aload 5
        //   208: astore_1
        //   209: aload_0
        //   210: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   213: ifnull +13 -> 226
        //   216: aload_0
        //   217: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   220: aload_1
        //   221: invokeinterface 46 2 0
        //   226: aload_0
        //   227: getfield 22	com/google/android/gm/AccountHelper$2:val$pendingIntent	Landroid/app/PendingIntent;
        //   230: invokevirtual 51	android/app/PendingIntent:cancel	()V
        //   233: return
        //   234: astore_2
        //   235: aload_3
        //   236: astore_1
        //   237: aload_0
        //   238: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   241: ifnull +13 -> 254
        //   244: aload_0
        //   245: getfield 20	com/google/android/gm/AccountHelper$2:val$callback	Lcom/google/android/gm/AccountHelper$AddAccountCallback;
        //   248: aload_1
        //   249: invokeinterface 46 2 0
        //   254: aload_0
        //   255: getfield 22	com/google/android/gm/AccountHelper$2:val$pendingIntent	Landroid/app/PendingIntent;
        //   258: invokevirtual 51	android/app/PendingIntent:cancel	()V
        //   261: aload_2
        //   262: athrow
        //   263: astore_2
        //   264: goto -27 -> 237
        //   267: astore_2
        //   268: goto -59 -> 209
        //   271: astore_2
        //   272: goto -92 -> 180
        //   275: astore_2
        //   276: goto -125 -> 151
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	279	0	this	2
        //   0	279	1	paramAnonymousAccountManagerFuture	AccountManagerFuture<Bundle>
        //   35	115	2	localObject1	Object
        //   234	28	2	localObject2	Object
        //   263	1	2	localObject3	Object
        //   267	1	2	localAuthenticatorException	AuthenticatorException
        //   271	1	2	localIOException	IOException
        //   275	1	2	localOperationCanceledException	OperationCanceledException
        //   43	193	3	localObject4	Object
        //   37	141	4	localObject5	Object
        //   40	167	5	localObject6	Object
        //   45	40	6	localObject7	Object
        //   63	37	7	str1	String
        //   71	31	8	str2	String
        // Exception table:
        //   from	to	target	type
        //   47	73	148	android/accounts/OperationCanceledException
        //   76	84	148	android/accounts/OperationCanceledException
        //   87	107	148	android/accounts/OperationCanceledException
        //   47	73	176	java/io/IOException
        //   76	84	176	java/io/IOException
        //   87	107	176	java/io/IOException
        //   47	73	205	android/accounts/AuthenticatorException
        //   76	84	205	android/accounts/AuthenticatorException
        //   87	107	205	android/accounts/AuthenticatorException
        //   47	73	234	finally
        //   76	84	234	finally
        //   87	107	234	finally
        //   107	123	263	finally
        //   107	123	267	android/accounts/AuthenticatorException
        //   107	123	271	java/io/IOException
        //   107	123	275	android/accounts/OperationCanceledException
      }
    }, null);
  }
  
  public void asyncGetAccountsInfo(final AccountResultsCallback paramAccountResultsCallback)
  {
    AccountManager localAccountManager = AccountManager.get(mContext);
    String str = GoogleLoginServiceConstants.featureForService("mail");
    paramAccountResultsCallback = new AccountManagerCallback()
    {
      public void run(AccountManagerFuture<Account[]> paramAnonymousAccountManagerFuture)
      {
        Object localObject = null;
        try
        {
          paramAnonymousAccountManagerFuture = (Account[])paramAnonymousAccountManagerFuture.getResult();
          paramAccountResultsCallback.exec(paramAnonymousAccountManagerFuture);
          return;
        }
        catch (OperationCanceledException paramAnonymousAccountManagerFuture)
        {
          for (;;)
          {
            LogUtils.w("Gmail", paramAnonymousAccountManagerFuture, "Unexpected exception trying to get accounts.", new Object[0]);
            paramAnonymousAccountManagerFuture = (AccountManagerFuture<Account[]>)localObject;
          }
        }
        catch (IOException paramAnonymousAccountManagerFuture)
        {
          for (;;)
          {
            LogUtils.w("Gmail", paramAnonymousAccountManagerFuture, "Unexpected exception trying to get accounts.", new Object[0]);
            paramAnonymousAccountManagerFuture = (AccountManagerFuture<Account[]>)localObject;
          }
        }
        catch (AuthenticatorException paramAnonymousAccountManagerFuture)
        {
          for (;;)
          {
            LogUtils.w("Gmail", paramAnonymousAccountManagerFuture, "Unexpected exception trying to get accounts.", new Object[0]);
            paramAnonymousAccountManagerFuture = (AccountManagerFuture<Account[]>)localObject;
          }
        }
      }
    };
    localAccountManager.getAccountsByTypeAndFeatures("com.google", new String[] { str }, paramAccountResultsCallback, null);
  }
  
  public String validateAccountName(String paramString)
  {
    if ((paramString != null) && (Utils.isValidGoogleAccount(mContext, paramString))) {
      return paramString;
    }
    return null;
  }
  
  public static abstract interface AccountResultsCallback
  {
    public abstract void exec(Account[] paramArrayOfAccount);
  }
  
  public static abstract interface AddAccountCallback
  {
    public abstract void onResult(Account paramAccount);
  }
  
  public static abstract interface CredentialsCallback
  {
    public abstract void onCredentialsResult(boolean paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.AccountHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */