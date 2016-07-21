import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView;
import java.util.ArrayList;

public final class fsz
  extends AnimatorListenerAdapter
{
  public fsz(SelectedAccountNavigationView paramSelectedAccountNavigationView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    a.j.u.setVisibility(8);
    a.j.r.setVisibility(8);
    if (a.j.v != null) {
      a.j.v.setVisibility(8);
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
 * Qualified Name:     fsz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */