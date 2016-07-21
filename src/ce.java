import android.support.design.widget.SwipeDismissBehavior;
import android.view.View;

public final class ce
  implements Runnable
{
  private final View b;
  private final boolean c;
  
  ce(SwipeDismissBehavior paramSwipeDismissBehavior, View paramView, boolean paramBoolean)
  {
    b = paramView;
    c = paramBoolean;
  }
  
  public final void run()
  {
    if ((a.b != null) && (a.b.c())) {
      rg.a(b, this);
    }
    while ((!c) || (a.c == null)) {
      return;
    }
    a.c.a(b);
  }
}

/* Location:
 * Qualified Name:     ce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */