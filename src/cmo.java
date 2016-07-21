import android.app.Fragment;
import android.os.SystemClock;
import android.view.View;

final class cmo
  extends cog
{
  cmo(cmn paramcmn, String paramString, Fragment paramFragment)
  {
    super(paramString, paramFragment);
  }
  
  public final void a()
  {
    a.b = SystemClock.elapsedRealtime();
    a.d.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     cmo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */