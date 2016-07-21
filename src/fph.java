import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;

final class fph
  extends foy
{
  private final ejr<fqu> a;
  
  public fph(ejr<fqu> paramejr)
  {
    a = paramejr;
  }
  
  public final void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (paramBundle != null) {}
    for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
    {
      paramBundle = new Status(paramInt1, null, paramBundle);
      a.a(new fpk(paramBundle, paramIntent));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     fph
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */