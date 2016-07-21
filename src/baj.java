import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class baj
  extends AbstractAccountAuthenticator
{
  public baj(bai parambai, Context paramContext)
  {
    super(paramContext);
  }
  
  public final Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
  {
    boolean bool2 = false;
    paramString2 = bam.f(a, paramString1);
    paramString2 = bam.e(a, paramString2);
    if ((paramBundle != null) && (paramBundle.containsKey("password")) && (paramBundle.containsKey("username")))
    {
      paramAccountAuthenticatorResponse = new Account(paramBundle.getString("username"), paramString1);
      AccountManager.get(a).addAccountExplicitly(paramAccountAuthenticatorResponse, paramBundle.getString("password"), null);
      if ((paramString2 != null) && (u))
      {
        bool1 = paramBundle.getBoolean("contacts", false);
        ContentResolver.setIsSyncable(paramAccountAuthenticatorResponse, "com.android.contacts", 1);
        ContentResolver.setSyncAutomatically(paramAccountAuthenticatorResponse, "com.android.contacts", bool1);
      }
      if ((paramString2 != null) && (v))
      {
        bool1 = paramBundle.getBoolean("calendar", false);
        ContentResolver.setIsSyncable(paramAccountAuthenticatorResponse, "com.android.calendar", 1);
        ContentResolver.setSyncAutomatically(paramAccountAuthenticatorResponse, "com.android.calendar", bool1);
      }
      boolean bool1 = bool2;
      if (paramBundle.containsKey("email"))
      {
        bool1 = bool2;
        if (paramBundle.getBoolean("email")) {
          bool1 = true;
        }
      }
      ContentResolver.setIsSyncable(paramAccountAuthenticatorResponse, bdv.F, 1);
      ContentResolver.setSyncAutomatically(paramAccountAuthenticatorResponse, bdv.F, bool1);
      paramAccountAuthenticatorResponse = new Bundle();
      paramAccountAuthenticatorResponse.putString("authAccount", paramBundle.getString("username"));
      paramAccountAuthenticatorResponse.putString("accountType", paramString1);
      return paramAccountAuthenticatorResponse;
    }
    paramString2 = new Bundle();
    paramString1 = bbm.a(a, paramString1);
    paramString1.putExtra("accountAuthenticatorResponse", paramAccountAuthenticatorResponse);
    paramString2.putParcelable("intent", paramString1);
    return paramString2;
  }
  
  public final Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle)
  {
    return null;
  }
  
  public final Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString)
  {
    return null;
  }
  
  public final Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    return null;
  }
  
  public final String getAuthTokenLabel(String paramString)
  {
    return null;
  }
  
  public final Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString)
  {
    return null;
  }
  
  public final Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     baj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */