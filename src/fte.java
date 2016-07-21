import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView;
import java.util.ArrayList;

public final class fte
  implements View.OnClickListener
{
  public fte(SelectedAccountNavigationView paramSelectedAccountNavigationView) {}
  
  public final void onClick(View paramView)
  {
    if ((a.q != null) && (a.g != null) && (a.g.size() >= 2))
    {
      paramView = a.q;
      a.g.get(1);
      if (!paramView.a()) {}
    }
    do
    {
      return;
      paramView = a;
    } while ((g == null) || (g.size() == 0));
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject3 = j.m;
    Object localObject2 = j.q;
    ((View)localObject3).bringToFront();
    Object localObject1 = (fyb)g.get(1);
    if (n == 0.0F) {
      n = j.p.getWidth();
    }
    localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
    Object localObject4 = ObjectAnimator.ofFloat(j.i, "alpha", new float[] { 1.0F, 0.0F });
    if (r) {}
    for (int i = ((ViewGroup.MarginLayoutParams)localObject2).getMarginStart();; i = leftMargin)
    {
      float f1 = m / n;
      float f2 = m;
      float f3 = n;
      float f4 = bottomMargin;
      float f5 = j.i.getLeft() - (i + ((View)localObject3).getLeft());
      float f6 = n;
      float f7 = m;
      localObject2 = localAnimatorSet.play((Animator)localObject4);
      localObject4 = ObjectAnimator.ofFloat(localObject3, "translationX", new float[] { f5 - (f6 - f7) * 0.5F });
      ((ObjectAnimator)localObject4).setDuration(450L);
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject3, "translationY", new float[] { (f2 - (f3 - f4)) * 0.5F });
      localObjectAnimator1.setDuration(450L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject3, "scaleY", new float[] { f1 });
      localObjectAnimator2.setDuration(300L);
      localObject3 = ObjectAnimator.ofFloat(localObject3, "scaleX", new float[] { f1 });
      ((ObjectAnimator)localObject3).setDuration(300L);
      ((AnimatorSet.Builder)localObject2).with((Animator)localObject4).with(localObjectAnimator1).with(localObjectAnimator2).with((Animator)localObject3);
      localObject3 = j.x;
      localObject4 = j.A;
      if (localObject4 != null) {
        ((ImageView)localObject4).setImageDrawable(j.o.getDrawable());
      }
      if (localObject3 != null)
      {
        ((View)localObject3).setVisibility(0);
        localObject4 = ObjectAnimator.ofFloat(localObject3, "alpha", new float[] { 1.0F });
        ((ObjectAnimator)localObject4).setDuration(450L);
        localObjectAnimator1 = ObjectAnimator.ofFloat(localObject3, "scaleY", new float[] { 1.0F });
        localObjectAnimator1.setDuration(450L);
        localObject3 = ObjectAnimator.ofFloat(localObject3, "scaleX", new float[] { 1.0F });
        ((ObjectAnimator)localObject3).setDuration(450L);
        ((AnimatorSet.Builder)localObject2).with((Animator)localObject4).with((Animator)localObject3).with(localObjectAnimator1);
      }
      if ((j.r != null) && (j.f != null))
      {
        j.r.setAlpha(0.0F);
        j.r.setTranslationX(0.0F);
        paramView.a((fyb)localObject1, (AnimatorSet.Builder)localObject2, 150);
      }
      if (j.n != null)
      {
        localObject3 = ObjectAnimator.ofFloat(j.n, "alpha", new float[] { 0.0F });
        ((ObjectAnimator)localObject3).setDuration(300L);
        ((AnimatorSet.Builder)localObject2).with((Animator)localObject3);
      }
      if (j.v != null)
      {
        paramView.a(j, j.v, (fyb)localObject1);
        j.v.setVisibility(0);
        localObject1 = ObjectAnimator.ofFloat(j.v, "alpha", new float[] { 1.0F });
        ((ObjectAnimator)localObject1).setDuration(300L);
        ((AnimatorSet.Builder)localObject2).with((Animator)localObject1);
      }
      localAnimatorSet.addListener(new fta(paramView));
      localObject1 = h;
      h = ((fyb)g.get(1));
      g.add(1, localObject1);
      g.remove(2);
      paramView.b(300);
      localAnimatorSet.setInterpolator(s);
      t = localAnimatorSet;
      t.start();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     fte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */