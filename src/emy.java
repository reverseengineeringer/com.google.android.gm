import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class emy
  extends ems
{
  public final IBinder g;
  
  public emy(emr paramemr, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paramemr, paramInt, paramBundle);
    g = paramIBinder;
  }
  
  protected final void a(ConnectionResult paramConnectionResult)
  {
    if (emr.e(h) != null) {
      emr.e(h).a(paramConnectionResult);
    }
    emr.g();
  }
  
  protected final boolean a()
  {
    IInterface localIInterface;
    do
    {
      try
      {
        String str = g.getInterfaceDescriptor();
        if (!h.b().equals(str))
        {
          Log.e("GmsClient", "service descriptor mismatch: " + h.b() + " vs. " + str);
          return false;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("GmsClient", "service probably died");
        return false;
      }
      localIInterface = h.a(g);
    } while ((localIInterface == null) || (!emr.a(h, 2, 3, localIInterface)));
    if (emr.b(h) != null) {
      emr.b(h).a(null);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     emy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */