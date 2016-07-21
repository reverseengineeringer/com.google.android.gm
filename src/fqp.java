import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;

public abstract class fqp<T extends IInterface>
  extends emr<T>
{
  public fqp(Context paramContext, int paramInt, emc paramemc, ejc paramejc, eje parameje)
  {
    super(paramContext, paramContext.getMainLooper(), paramInt, paramemc, paramejc, parameje);
  }
  
  protected final String a()
  {
    return "com.google.android.gms.icing.INDEX_SERVICE";
  }
  
  public final T m()
  {
    try
    {
      IInterface localIInterface = k();
      return localIInterface;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      RemoteException localRemoteException = new RemoteException();
      localRemoteException.initCause(localIllegalStateException);
      throw localRemoteException;
    }
  }
}

/* Location:
 * Qualified Name:     fqp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */