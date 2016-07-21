import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public final class cqd
{
  public static DecelerateInterpolator a = new DecelerateInterpolator(1.0F);
  public static int b = -1;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static float g;
  public static float h = 0.0F;
  public static float i = 0.4F;
  public float j;
  public final cqi k;
  public final int l;
  public final VelocityTracker m;
  public float n;
  public boolean o;
  public cqj p;
  public View q;
  public boolean r;
  public float s;
  public float t;
  public float u;
  
  public cqd(Context paramContext, cqi paramcqi, float paramFloat1, float paramFloat2)
  {
    k = paramcqi;
    l = 0;
    m = VelocityTracker.obtain();
    s = paramFloat1;
    j = paramFloat2;
    if (b == -1)
    {
      paramContext = paramContext.getResources();
      b = paramContext.getInteger(bud.F);
      c = paramContext.getInteger(bud.l);
      d = paramContext.getInteger(bud.v);
      e = paramContext.getInteger(bud.u);
      f = paramContext.getInteger(bud.D);
      g = paramContext.getDimension(bua.S);
    }
  }
  
  private static void a(View paramView, RectF paramRectF)
  {
    while ((paramView.getParent() != null) && ((paramView.getParent() instanceof View)))
    {
      paramView = (View)paramView.getParent();
      paramView.getMatrix().mapRect(paramRectF);
      paramView.invalidate((int)Math.floor(left), (int)Math.floor(top), (int)Math.ceil(right), (int)Math.ceil(bottom));
    }
  }
  
  public static void b(View paramView)
  {
    a(paramView, new RectF(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()));
  }
  
  public final float a(View paramView)
  {
    if (l == 0) {
      return paramView.getMeasuredWidth();
    }
    return paramView.getMeasuredHeight();
  }
  
  public final ObjectAnimator a(View paramView, float paramFloat)
  {
    if (l == 0) {}
    for (String str = "translationX";; str = "translationY") {
      return ObjectAnimator.ofFloat(paramView, str, new float[] { paramFloat });
    }
  }
}

/* Location:
 * Qualified Name:     cqd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */