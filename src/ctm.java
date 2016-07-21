import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import java.io.IOException;

final class ctm
  implements AccountManagerCallback<Bundle>
{
  ctm(cto paramcto) {}
  
  public final void run(AccountManagerFuture<Bundle> paramAccountManagerFuture)
  {
    try
    {
      boolean bool = ((Bundle)paramAccountManagerFuture.getResult()).getBoolean("booleanResult");
      a.a(bool);
      return;
    }
    catch (AuthenticatorException paramAccountManagerFuture)
    {
      a.a(false);
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
 * Qualified Name:     ctm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */