import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public final class bj
  implements Handler.Callback
{
  public final boolean handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      return false;
    case 0: 
      paramMessage = (Snackbar)obj;
      if (c.getParent() == null)
      {
        localObject = c.getLayoutParams();
        if ((localObject instanceof ag))
        {
          bs localbs = new bs(paramMessage);
          f = SwipeDismissBehavior.a(0.0F, 0.1F, 1.0F);
          g = SwipeDismissBehavior.a(0.0F, 0.6F, 1.0F);
          d = 0;
          c = new bl(paramMessage);
          ((ag)localObject).a(localbs);
        }
        b.addView(c);
      }
      c.d = new bm(paramMessage);
      if (rg.w(c)) {
        if (paramMessage.d()) {
          paramMessage.a();
        }
      }
      for (;;)
      {
        return true;
        paramMessage.b();
        continue;
        c.c = new bo(paramMessage);
      }
    }
    Object localObject = (Snackbar)obj;
    int i = arg1;
    if ((((Snackbar)localObject).d()) && (c.getVisibility() == 0)) {
      if (Build.VERSION.SDK_INT >= 14) {
        rg.q(c).c(c.getHeight()).a(p.b).a(250L).a(new br((Snackbar)localObject, i)).b();
      }
    }
    for (;;)
    {
      return true;
      paramMessage = AnimationUtils.loadAnimation(c.getContext(), b.d);
      paramMessage.setInterpolator(p.b);
      paramMessage.setDuration(250L);
      paramMessage.setAnimationListener(new bk((Snackbar)localObject, i));
      c.startAnimation(paramMessage);
      continue;
      ((Snackbar)localObject).c();
    }
  }
}

/* Location:
 * Qualified Name:     bj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */