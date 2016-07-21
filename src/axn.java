import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.service.HostAuthCompat;

public final class axn
  extends awr
{
  public final HostAuth g;
  
  public axn(Account paramAccount, Context paramContext)
  {
    b = paramContext;
    g = paramAccount.d(b);
  }
  
  private final ber f()
  {
    return bam.d(b, g.b);
  }
  
  public final Bundle a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = f().a(paramString1, paramString2);
      return paramString1;
    }
    catch (RemoteException paramString1) {}
    return null;
  }
  
  public final Bundle a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return f().a(paramString1, paramString2, paramBundle);
  }
  
  public final Bundle c()
  {
    try
    {
      Object localObject = f();
      if ((localObject instanceof bfn)) {
        j = 90;
      }
      localObject = ((ber)localObject).a(new HostAuthCompat(g));
      return (Bundle)localObject;
    }
    catch (RemoteException localRemoteException)
    {
      throw new bdi(29, "Call to validate generated an exception", localRemoteException);
    }
  }
  
  public final int d()
  {
    return f().a();
  }
}

/* Location:
 * Qualified Name:     axn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */