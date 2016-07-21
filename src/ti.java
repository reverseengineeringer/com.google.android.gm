import android.view.View;
import java.lang.ref.WeakReference;

final class ti
  implements Runnable
{
  WeakReference<View> a;
  tg b;
  
  ti(th paramth, tg paramtg, View paramView)
  {
    a = new WeakReference(paramView);
    b = paramtg;
  }
  
  public final void run()
  {
    View localView = (View)a.get();
    if (localView != null) {
      c.c(b, localView);
    }
  }
}

/* Location:
 * Qualified Name:     ti
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */