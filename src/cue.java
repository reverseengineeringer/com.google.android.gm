import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;

public final class cue
{
  int a = 0;
  cuf b;
  final Handler c = new Handler();
  private View d;
  private final cug e = new cug(this);
  
  public final void a(View paramView)
  {
    if (d == paramView) {}
    do
    {
      return;
      if (d != null) {
        d.getViewTreeObserver().removeOnPreDrawListener(e);
      }
      d = paramView;
    } while (d == null);
    d.getViewTreeObserver().addOnPreDrawListener(e);
  }
  
  public final void a(cuf paramcuf)
  {
    b = paramcuf;
    if (b != null) {
      b.a(this, a);
    }
  }
}

/* Location:
 * Qualified Name:     cue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */