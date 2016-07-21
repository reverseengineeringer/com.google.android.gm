import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.googlehelp.GoogleHelp;

final class fkm
  extends fkp
{
  fkm(fkl paramfkl, eiz parameiz, Intent paramIntent, Bitmap paramBitmap, Activity paramActivity)
  {
    super(parameiz);
  }
  
  protected final void a(fkw paramfkw)
  {
    try
    {
      paramfkw.a((GoogleHelp)a.getParcelableExtra("EXTRA_GOOGLE_HELP"), h, new fkn(this));
      return;
    }
    catch (Exception paramfkw)
    {
      Log.e("gH_GoogleHelpApiImpl", "Starting help failed!", paramfkw);
      c(fkl.a);
    }
  }
}

/* Location:
 * Qualified Name:     fkm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */