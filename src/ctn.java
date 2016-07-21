import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import java.io.IOException;

final class ctn
  implements AccountManagerCallback<Boolean>
{
  ctn(cto paramcto) {}
  
  public final void run(AccountManagerFuture<Boolean> paramAccountManagerFuture)
  {
    try
    {
      a.a(((Boolean)paramAccountManagerFuture.getResult()).booleanValue());
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
 * Qualified Name:     ctn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */