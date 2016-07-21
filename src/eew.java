import android.os.RemoteException;

public final class eew
  extends RuntimeException
{
  private final RemoteException a;
  
  public eew(RemoteException paramRemoteException)
  {
    super(paramRemoteException);
    a = paramRemoteException;
  }
}

/* Location:
 * Qualified Name:     eew
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */