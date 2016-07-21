import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public final class emk
  extends emf
{
  int a;
  private Account b;
  private Context c;
  
  public static Account a(eme parameme)
  {
    Account localAccount = null;
    long l;
    if (parameme != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      localAccount = parameme.a();
      return localAccount;
    }
    catch (RemoteException parameme)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  public final Account a()
  {
    int i = Binder.getCallingUid();
    if (i == a) {
      return b;
    }
    if (eik.a(c, i))
    {
      a = i;
      return b;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof emk)) {
      return false;
    }
    return b.equals(b);
  }
}

/* Location:
 * Qualified Name:     emk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */