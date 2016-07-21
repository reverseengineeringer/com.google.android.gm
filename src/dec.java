import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import java.io.IOException;

final class dec
  implements AccountManagerCallback<Bundle>
{
  dec(def paramdef) {}
  
  public final void run(AccountManagerFuture<Bundle> paramAccountManagerFuture)
  {
    try
    {
      paramAccountManagerFuture.getResult();
      bool = true;
    }
    catch (OperationCanceledException paramAccountManagerFuture)
    {
      for (;;)
      {
        dri.a(ddy.a, paramAccountManagerFuture, "promptForCredentials()", new Object[0]);
        boolean bool = false;
      }
    }
    catch (IOException paramAccountManagerFuture)
    {
      for (;;) {}
    }
    catch (AuthenticatorException paramAccountManagerFuture)
    {
      for (;;) {}
    }
    a.a(bool);
  }
}

/* Location:
 * Qualified Name:     dec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */