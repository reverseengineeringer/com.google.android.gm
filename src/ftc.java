import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView;
import java.util.ArrayList;

public final class ftc
  extends AnimatorListenerAdapter
{
  public ftc(SelectedAccountNavigationView paramSelectedAccountNavigationView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = a;
    if (i != null) {
      i.a(h);
    }
    paramAnimator = a;
    if (u != null)
    {
      h = u;
      u = null;
    }
    if ((v != null) || (w != null))
    {
      g.clear();
      if (v != null) {
        g.add(v);
      }
      if (w != null) {
        g.add(w);
      }
      v = null;
      w = null;
    }
    a.a();
    a.t = null;
  }
}

/* Location:
 * Qualified Name:     ftc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */