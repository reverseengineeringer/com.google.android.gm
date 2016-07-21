import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ap
  extends ay
{
  boolean a;
  bh b;
  private int c;
  private bz p;
  
  public ap(di paramdi, bi parambi)
  {
    super(paramdi, parambi);
    c = paramdi.getResources().getInteger(17694720);
    p = new bz();
    parambi = p;
    View localView = parambi.a();
    if (localView != paramdi)
    {
      if (localView != null)
      {
        localView = parambi.a();
        int j = a.size();
        int i = 0;
        while (i < j)
        {
          Animation localAnimation = a.get(i)).b;
          if (localView.getAnimation() == localAnimation) {
            localView.clearAnimation();
          }
          i += 1;
        }
        d = null;
        b = null;
        c = null;
      }
      if (paramdi != null) {
        d = new WeakReference(paramdi);
      }
    }
    p.a(j, a(new at(this)));
    p.a(k, a(new at(this)));
    p.a(l, a(new au(this)));
  }
  
  private final Animation a(Animation paramAnimation)
  {
    paramAnimation.setInterpolator(p.b);
    paramAnimation.setDuration(c);
    return paramAnimation;
  }
  
  void a()
  {
    bz localbz = p;
    if (c != null)
    {
      View localView = localbz.a();
      if ((localView != null) && (localView.getAnimation() == c)) {
        localView.clearAnimation();
      }
    }
  }
  
  void a(float paramFloat)
  {
    if (b != null)
    {
      b.a(paramFloat, i + paramFloat);
      d();
    }
  }
  
  final void a(ColorStateList paramColorStateList)
  {
    if (d != null) {
      kn.a(d, paramColorStateList);
    }
    if (f != null) {
      f.a(paramColorStateList);
    }
  }
  
  void a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    d = kn.e(f());
    kn.a(d, paramColorStateList);
    if (paramMode != null) {
      kn.a(d, paramMode);
    }
    e = kn.e(f());
    kn.a(e, new ColorStateList(new int[][] { k, j, new int[0] }, new int[] { paramInt1, paramInt1, 0 }));
    if (paramInt2 > 0)
    {
      f = a(paramInt2, paramColorStateList);
      paramColorStateList = new Drawable[3];
      paramColorStateList[0] = f;
      paramColorStateList[1] = d;
      paramColorStateList[2] = e;
    }
    for (;;)
    {
      g = new LayerDrawable(paramColorStateList);
      b = new bh(m.getResources(), g, n.a(), h, h + i);
      paramColorStateList = b;
      k = false;
      paramColorStateList.invalidateSelf();
      n.a(b);
      return;
      f = null;
      paramColorStateList = new Drawable[2];
      paramColorStateList[0] = d;
      paramColorStateList[1] = e;
    }
  }
  
  final void a(PorterDuff.Mode paramMode)
  {
    if (d != null) {
      kn.a(d, paramMode);
    }
  }
  
  void a(Rect paramRect)
  {
    b.getPadding(paramRect);
  }
  
  void a(ba paramba, boolean paramBoolean)
  {
    if ((a) || (m.getVisibility() != 0)) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(m.getContext(), b.b);
    localAnimation.setInterpolator(p.c);
    localAnimation.setDuration(200L);
    localAnimation.setAnimationListener(new aq(this, false, paramba));
    m.startAnimation(localAnimation);
  }
  
  void a(int[] paramArrayOfInt)
  {
    bz localbz = p;
    int j = a.size();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = (cb)a.get(i);
      if (!StateSet.stateSetMatches(a, paramArrayOfInt)) {}
    }
    for (paramArrayOfInt = (int[])localObject;; paramArrayOfInt = null)
    {
      if (paramArrayOfInt != b)
      {
        if ((b != null) && (c != null))
        {
          localObject = localbz.a();
          if ((localObject != null) && (((View)localObject).getAnimation() == c)) {
            ((View)localObject).clearAnimation();
          }
          c = null;
        }
        b = paramArrayOfInt;
        localObject = (View)d.get();
        if ((paramArrayOfInt != null) && (localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          c = b;
          paramArrayOfInt = localbz.a();
          if (paramArrayOfInt != null) {
            paramArrayOfInt.startAnimation(c);
          }
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  void b(float paramFloat)
  {
    if (b != null)
    {
      bh localbh = b;
      float f = h;
      localbh.a(j, f + paramFloat);
      d();
    }
  }
  
  void b(ba paramba, boolean paramBoolean)
  {
    if ((m.getVisibility() != 0) || (a))
    {
      m.clearAnimation();
      m.a(0, false);
      Animation localAnimation = AnimationUtils.loadAnimation(m.getContext(), b.a);
      localAnimation.setDuration(200L);
      localAnimation.setInterpolator(p.d);
      localAnimation.setAnimationListener(new ar(this, paramba));
      m.startAnimation(localAnimation);
    }
  }
}

/* Location:
 * Qualified Name:     ap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */