import android.accounts.Account;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.util.Log;

public final class frw
  extends AsyncTask<Void, Void, Account[]>
{
  public frw(fru paramfru) {}
  
  private final Account[] a()
  {
    if (isCancelled()) {
      return null;
    }
    try
    {
      Account[] arrayOfAccount = ecy.c(a.a, "com.google");
      return arrayOfAccount;
    }
    catch (eij localeij)
    {
      Log.e("AccountOrderingHelper", "Failed to get accounts", localeij);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    catch (eii localeii)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     frw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */