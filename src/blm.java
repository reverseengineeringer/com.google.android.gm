import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.android.ex.photo.PhotoViewPager;

public class blm
  extends zh
  implements blz
{
  public blq l;
  private bli m;
  
  public blq g()
  {
    return new blq(this);
  }
  
  public final blq h()
  {
    return l;
  }
  
  public final Context i()
  {
    return this;
  }
  
  public final blg j()
  {
    if (m == null) {
      m = new bli(f().a());
    }
    return m;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    l.a(paramInt1, paramInt2);
  }
  
  public void onBackPressed()
  {
    int i = 0;
    blq localblq = l;
    if ((n) && (!A)) {
      localblq.a();
    }
    for (;;)
    {
      i = 1;
      do
      {
        if (i == 0) {
          super.onBackPressed();
        }
        return;
      } while (!u);
      c.getIntent();
      i = i.getMeasuredWidth();
      int j = i.getMeasuredHeight();
      float f = Math.max(x / i, y / j);
      i = blq.a(v, x, i, f);
      j = blq.a(w, y, j, f);
      int k = Build.VERSION.SDK_INT;
      if (k >= 14)
      {
        if (localblq.e())
        {
          j.animate().alpha(0.0F).setDuration(250L).start();
          j.setVisibility(0);
        }
        blv localblv = new blv(localblq);
        if ((localblq.f()) && (l.getVisibility() == 0))
        {
          localObject = l.animate().scaleX(f).scaleY(f).translationX(i).translationY(j).setDuration(250L);
          label245:
          if (!e.equals(f)) {
            ((ViewPropertyAnimator)localObject).alpha(0.0F);
          }
          if (k < 16) {
            break label328;
          }
          ((ViewPropertyAnimator)localObject).withEndAction(localblv);
        }
        for (;;)
        {
          ((ViewPropertyAnimator)localObject).start();
          break;
          localObject = k.animate().scaleX(f).scaleY(f).translationX(i).translationY(j).setDuration(250L);
          break label245;
          label328:
          D.postDelayed(localblv, 250L);
        }
      }
      if (localblq.e())
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((Animation)localObject).setDuration(250L);
        j.startAnimation((Animation)localObject);
        j.setVisibility(0);
      }
      Object localObject = new ScaleAnimation(1.0F, 1.0F, f, f);
      ((Animation)localObject).setDuration(250L);
      ((Animation)localObject).setAnimationListener(new blw(localblq));
      if ((localblq.f()) && (l.getVisibility() == 0)) {
        l.startAnimation((Animation)localObject);
      } else {
        k.startAnimation((Animation)localObject);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    l = g();
    l.a_(paramBundle);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    l.a(paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    l.o = true;
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return (l.a(paramMenuItem)) || (super.onOptionsItemSelected(paramMenuItem));
  }
  
  protected void onPause()
  {
    l.p = true;
    super.onPause();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    l.d();
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    l.h();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    l.b(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    l.g();
  }
  
  public void onStop()
  {
    l.i();
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     blm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */