import android.os.RemoteException;

public final class bbc
  implements bdd
{
  private final long b;
  private final long c;
  private final bfb d;
  
  public bbc(bba parambba, long paramLong1, long paramLong2, bfb parambfb)
  {
    b = paramLong1;
    c = paramLong2;
    d = parambfb;
  }
  
  public final void a(int paramInt)
  {
    try
    {
      d.a(b, c, 1, paramInt);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public final void a(bdg parambdg) {}
}

/* Location:
 * Qualified Name:     bbc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */