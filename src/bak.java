import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.email.service.EasTestAuthenticatorService;

public final class bak
  extends AbstractAccountAuthenticator
{
  public bak(EasTestAuthenticatorService paramEasTestAuthenticatorService, Context paramContext)
  {
    super(paramContext);
  }
  
  public final Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("password")) && (paramBundle.containsKey("username")))
    {
      paramAccountAuthenticatorResponse = new Account(paramBundle.getString("username"), "com.android.test_exchange");
      AccountManager.get(a).addAccountExplicitly(paramAccountAuthenticatorResponse, paramBundle.getString("password"), null);
      paramAccountAuthenticatorResponse = new Bundle();
      paramAccountAuthenticatorResponse.putString("authAccount", "com.android.test_exchange");
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
 * Qualified Name:     bak
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */