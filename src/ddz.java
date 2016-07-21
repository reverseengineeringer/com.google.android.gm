import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import java.io.IOException;

final class ddz
  implements AccountManagerCallback<Account[]>
{
  ddz(ddy paramddy, ded paramded) {}
  
  public final void run(AccountManagerFuture<Account[]> paramAccountManagerFuture)
  {
    try
    {
      paramAccountManagerFuture = (Account[])paramAccountManagerFuture.getResult();
      a.a(paramAccountManagerFuture);
      return;
    }
    catch (AuthenticatorException paramAccountManagerFuture)
    {
      for (;;)
      {
        dri.d(ddy.a, paramAccountManagerFuture, "Unexpected exception trying to get accounts.", new Object[0]);
        paramAccountManagerFuture = null;
      }
    }
    catch (OperationCanceledException paramAccountManagerFuture)
    {
      for (;;) {}
    }
    catch (IOException paramAccountManagerFuture)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     ddz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */