import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public final class bb
  extends av
{
  private final Interpolator p;
  private InsetDrawable q;
  
  public bb(di paramdi, bi parambi)
  {
    super(paramdi, parambi);
    if (paramdi.isInEditMode()) {}
    for (paramdi = null;; paramdi = AnimationUtils.loadInterpolator(m.getContext(), 17563661))
    {
      p = paramdi;
      return;
    }
  }
  
  private final Animator a(Animator paramAnimator)
  {
    paramAnimator.setInterpolator(p);
    return paramAnimator;
  }
  
  final void a() {}
  
  public final void a(float paramFloat)
  {
    m.setElevation(paramFloat);
    if (n.b()) {
      d();
    }
  }
  
  final void a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    d = kn.e(f());
    kn.a(d, paramColorStateList);
    if (paramMode != null) {
      kn.a(d, paramMode);
    }
    if (paramInt2 > 0) {
      f = a(paramInt2, paramColorStateList);
    }
    for (paramColorStateList = new LayerDrawable(new Drawable[] { f, d });; paramColorStateList = d)
    {
      e = new RippleDrawable(ColorStateList.valueOf(paramInt1), paramColorStateList, null);
      g = e;
      n.a(e);
      return;
      f = null;
    }
  }
  
  final void a(Rect paramRect)
  {
    if (n.b())
    {
      float f1 = n.a();
      float f2 = m.getElevation() + this.i;
      int i = (int)Math.ceil(bh.b(f2, f1, false));
      int j = (int)Math.ceil(bh.a(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  final void a(int[] paramArrayOfInt) {}
  
  final void b(float paramFloat)
  {
    StateListAnimator localStateListAnimator = new StateListAnimator();
    localStateListAnimator.addState(j, a(ObjectAnimator.ofFloat(m, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(k, a(ObjectAnimator.ofFloat(m, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(l, a(ObjectAnimator.ofFloat(m, "translationZ", new float[] { 0.0F })));
    m.setStateListAnimator(localStateListAnimator);
    if (n.b()) {
      d();
    }
  }
  
  final void b(Rect paramRect)
  {
    if (n.b())
    {
      q = new InsetDrawable(e, left, top, right, bottom);
      n.a(q);
      return;
    }
    n.a(e);
  }
  
  final boolean b()
  {
    return false;
  }
  
  final y e()
  {
    return new z();
  }
}

/* Location:
 * Qualified Name:     bb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */