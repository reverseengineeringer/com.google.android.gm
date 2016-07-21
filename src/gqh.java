import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

public final class gqh
{
  public final AccountManager a;
  
  private gqh(AccountManager paramAccountManager)
  {
    a = ((AccountManager)hbe.a(paramAccountManager));
  }
  
  public gqh(Context paramContext)
  {
    this(AccountManager.get(paramContext));
  }
  
  public final Account a(String paramString)
  {
    if (paramString != null)
    {
      Account[] arrayOfAccount = a.getAccountsByType("com.google");
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        Account localAccount = arrayOfAccount[i];
        if (paramString.equals(name)) {
          return localAccount;
        }
        i += 1;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     gqh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */