package com.android.mail.providers;

import android.net.Uri;
import android.text.TextUtils;
import java.util.regex.Pattern;

class MailAppProvider$AccountCacheEntry
  implements Comparable<AccountCacheEntry>
{
  private static final Pattern ACCOUNT_ENTRY_COMPONENT_SEPARATOR_PATTERN = Pattern.compile("\\^\\*\\*\\^");
  final Account mAccount;
  final Uri mAccountsQueryUri;
  final int mPosition;
  
  public MailAppProvider$AccountCacheEntry(Account paramAccount, Uri paramUri, int paramInt)
  {
    mAccount = paramAccount;
    mAccountsQueryUri = paramUri;
    mPosition = paramInt;
  }
  
  public MailAppProvider$AccountCacheEntry(String paramString, int paramInt)
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

/* Location:
 * Qualified Name:     com.android.mail.providers.MailAppProvider.AccountCacheEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */