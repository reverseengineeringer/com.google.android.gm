import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

final class gcu
  implements Runnable
{
  gcu(gct paramgct, List paramList, String paramString, gcn paramgcn) {}
  
  public final void run()
  {
    try
    {
      Object localObject = d.a.e;
      Collections.unmodifiableSet(new HashSet(a));
      localObject = ((ejf)localObject).a();
      localObject = new CheckServerAuthResult(a, b);
      c.a((CheckServerAuthResult)localObject);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     gcu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */