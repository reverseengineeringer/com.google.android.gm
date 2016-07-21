import android.os.Bundle;
import android.os.ParcelFileDescriptor;

final class fxf
  extends fwq
{
  private final ejr<frh> a;
  
  public fxf(ejr<frh> paramejr)
  {
    a = paramejr;
  }
  
  public final void a(int paramInt, Bundle paramBundle1, ParcelFileDescriptor paramParcelFileDescriptor, Bundle paramBundle2)
  {
    int i = 0;
    if (fxo.a(3))
    {
      new StringBuilder("Avatar callback: status=").append(paramInt).append(" resolution=").append(paramBundle1).append(" pfd=").append(paramParcelFileDescriptor);
      fxo.a(3);
    }
    paramBundle1 = fxd.a(paramInt, paramBundle1);
    boolean bool;
    if (paramBundle2 != null)
    {
      bool = paramBundle2.getBoolean("rewindable");
      paramInt = paramBundle2.getInt("width");
      i = paramBundle2.getInt("height");
    }
    for (;;)
    {
      a.a(new fxh(paramBundle1, paramParcelFileDescriptor, bool, paramInt, i));
      return;
      paramInt = 0;
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     fxf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */