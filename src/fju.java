import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

final class fju
  extends Thread
{
  private final String b;
  private final fke c;
  private final Bundle d;
  
  fju(fjt paramfjt, String paramString, IBinder paramIBinder, Bundle paramBundle)
  {
    b = paramString;
    if (paramIBinder == null) {
      paramfjt = null;
    }
    for (;;)
    {
      c = paramfjt;
      d = paramBundle;
      return;
      paramfjt = paramIBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
      if ((paramfjt != null) && ((paramfjt instanceof fke))) {
        paramfjt = (fke)paramfjt;
      } else {
        paramfjt = new fkg(paramIBinder);
      }
    }
  }
  
  public final void run()
  {
    int i = a.a(new fkc(b, d));
    try
    {
      c.a(i);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("GcmTaskService", "Error reporting result of operation to scheduler for " + b);
      return;
    }
    finally
    {
      fjt.a(a, b);
    }
  }
}

/* Location:
 * Qualified Name:     fju
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */