import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import com.google.android.gm.provider.GmailProvider;
import java.io.IOException;
import java.util.Arrays;

public final class dqm
  implements AccountManagerCallback<Account[]>
{
  public dqm(GmailProvider paramGmailProvider) {}
  
  public final void run(AccountManagerFuture<Account[]> paramAccountManagerFuture)
  {
    try
    {
      paramAccountManagerFuture = (Account[])paramAccountManagerFuture.getResult();
      if (!Arrays.equals(a.d, paramAccountManagerFuture))
      {
        a.d = paramAccountManagerFuture;
        GmailProvider.a(a.getContext());
      }
      return;
    }
    catch (AuthenticatorException paramAccountManagerFuture)
    {
      dri.d("Gmail", paramAccountManagerFuture, "Unexpected exception trying to get accounts.", new Object[0]);
      return;
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
 * Qualified Name:     dqm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */