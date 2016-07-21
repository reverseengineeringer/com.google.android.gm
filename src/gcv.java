import android.os.RemoteException;
import android.util.Log;

final class gcv
  implements Runnable
{
  gcv(gct paramgct, String paramString1, String paramString2, gcn paramgcn) {}
  
  public final void run()
  {
    try
    {
      boolean bool = d.a.e.b();
      c.a(bool);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     gcv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */