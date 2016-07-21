import android.os.Handler;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class cug
  implements ViewTreeObserver.OnPreDrawListener, Runnable
{
  cug(cue paramcue) {}
  
  public final boolean onPreDraw()
  {
    cue localcue = a;
    if (a != 1)
    {
      a = 1;
      if (b != null) {
        b.a(localcue, 1);
      }
    }
    a.c.removeCallbacks(this);
    a.c.postDelayed(this, 100L);
    return true;
  }
  
  public final void run()
  {
    cue localcue = a;
    if (a != 0)
    {
      a = 0;
      if (b != null) {
        b.a(localcue, 0);
      }
    }
  }
}

/* Location:
 * Qualified Name:     cug
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */