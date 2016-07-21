import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public final class fxk
  extends fwq
{
  private final ejr<fqy> a;
  
  public fxk(ejr<fqy> paramejr)
  {
    a = paramejr;
  }
  
  public final void a(int paramInt, Bundle paramBundle, DataHolder paramDataHolder)
  {
    if (fxo.a(3))
    {
      new StringBuilder("Autocomplete callback: status=").append(paramInt).append("\nresolution=").append(paramBundle).append("\nholder=").append(paramDataHolder);
      fxo.a(3);
    }
    Status localStatus = fxd.a(paramInt, paramBundle);
    if (paramDataHolder == null) {}
    for (paramBundle = null;; paramBundle = new fxy(paramDataHolder))
    {
      a.a(new fxi(localStatus, paramBundle));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     fxk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */