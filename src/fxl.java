import android.os.Bundle;

public final class fxl
  extends fwq
{
  public final ekv<frl> a;
  
  public fxl(ekv<frl> paramekv)
  {
    a = paramekv;
  }
  
  public final void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (fxo.a(3))
    {
      new StringBuilder("Bundle callback: status=").append(paramInt).append("\nresolution=").append(paramBundle1).append("\nbundle=").append(paramBundle2);
      fxo.a(3);
    }
    if (paramInt != 0)
    {
      fxo.a("PeopleClient", "Non-success data changed callback received.");
      return;
    }
    a.a(new fxj(paramBundle2.getString("account"), paramBundle2.getString("pagegaiaid"), paramBundle2.getInt("scope")));
  }
}

/* Location:
 * Qualified Name:     fxl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */