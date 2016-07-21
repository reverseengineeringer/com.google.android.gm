import android.os.Bundle;

public final class fxm
  extends fwq
{
  private final ejr<ejk> a;
  
  public fxm(ejr<ejk> paramejr)
  {
    a = paramejr;
  }
  
  public final void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (fxo.a(3))
    {
      new StringBuilder("Bundle callback: status=").append(paramInt).append("\nresolution=").append(paramBundle1).append("\nbundle=").append(paramBundle2);
      fxo.a(3);
    }
    paramBundle1 = fxd.a(paramInt, paramBundle1);
    a.a(new fxn(paramBundle1));
  }
}

/* Location:
 * Qualified Name:     fxm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */