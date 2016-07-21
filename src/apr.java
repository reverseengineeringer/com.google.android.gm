import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public final class apr
  extends View
{
  private final Paint a = new Paint();
  private boolean b = false;
  private boolean c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private boolean k;
  private boolean l;
  private int m;
  private int n;
  private int o;
  private int p;
  private float q;
  private float r;
  private int s;
  private int t;
  private aps u;
  private int v;
  private double w;
  private boolean x;
  
  public apr(Context paramContext)
  {
    super(paramContext);
  }
  
  public final int a(float paramFloat1, float paramFloat2, boolean paramBoolean, Boolean[] paramArrayOfBoolean)
  {
    int i2 = 1;
    if (!c) {
      return -1;
    }
    double d1 = Math.sqrt((paramFloat2 - o) * (paramFloat2 - o) + (paramFloat1 - n) * (paramFloat1 - n));
    label103:
    label111:
    int i3;
    int i1;
    if (l) {
      if (paramBoolean) {
        if ((int)Math.abs(d1 - (int)(p * f)) <= (int)Math.abs(d1 - (int)(p * g)))
        {
          paramBoolean = true;
          paramArrayOfBoolean[0] = Boolean.valueOf(paramBoolean);
          i3 = (int)(Math.asin(Math.abs(paramFloat2 - o) / d1) * 180.0D / 3.141592653589793D);
          if (paramFloat1 <= n) {
            break label339;
          }
          i1 = 1;
          label152:
          if (paramFloat2 >= o) {
            break label345;
          }
        }
      }
    }
    for (;;)
    {
      if ((i1 == 0) || (i2 == 0)) {
        break label351;
      }
      return 90 - i3;
      paramBoolean = false;
      break label103;
      i1 = (int)(p * f);
      i3 = t;
      int i4 = (int)(p * g);
      int i5 = t;
      int i6 = (int)(p * ((g + f) / 2.0F));
      if ((d1 >= i1 - i3) && (d1 <= i6))
      {
        paramArrayOfBoolean[0] = Boolean.valueOf(true);
        break label111;
      }
      if ((d1 > i4 + i5) || (d1 < i6)) {
        break;
      }
      paramArrayOfBoolean[0] = Boolean.valueOf(false);
      break label111;
      if ((paramBoolean) || ((int)Math.abs(d1 - s) <= (int)(p * (1.0F - h)))) {
        break label111;
      }
      return -1;
      label339:
      i1 = 0;
      break label152;
      label345:
      i2 = 0;
    }
    label351:
    if (i1 != 0) {
      return i3 + 90;
    }
    if (i2 == 0) {
      return 270 - i3;
    }
    return i3 + 270;
  }
  
  public final ObjectAnimator a()
  {
    if ((!b) || (!c))
    {
      Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
      return null;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.2F, q), Keyframe.ofFloat(1.0F, r) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) }) }).setDuration(500L);
    localObjectAnimator.addUpdateListener(u);
    return localObjectAnimator;
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    v = paramInt;
    w = (paramInt * 3.141592653589793D / 180.0D);
    x = paramBoolean2;
    if (l)
    {
      if (paramBoolean1) {
        h = f;
      }
    }
    else {
      return;
    }
    h = g;
  }
  
  final void a(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getResources();
    int i1;
    if (paramBoolean) {
      i1 = paramContext.getColor(aog.m);
    }
    for (m = 102;; m = 51)
    {
      a.setColor(i1);
      return;
      i1 = paramContext.getColor(aog.b);
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4)
  {
    int i2 = -1;
    if (b)
    {
      Log.e("RadialSelectorView", "This RadialSelectorView may only be initialized once.");
      return;
    }
    paramContext = paramContext.getResources();
    int i1 = paramContext.getColor(aog.b);
    a.setColor(i1);
    a.setAntiAlias(true);
    m = 51;
    k = paramBoolean1;
    if (paramBoolean1)
    {
      d = Float.parseFloat(paramContext.getString(aol.c));
      l = paramBoolean2;
      if (!paramBoolean2) {
        break label237;
      }
      f = Float.parseFloat(paramContext.getString(aol.j));
      g = Float.parseFloat(paramContext.getString(aol.l));
      label116:
      i = Float.parseFloat(paramContext.getString(aol.s));
      j = 1.0F;
      if (!paramBoolean3) {
        break label254;
      }
    }
    label237:
    label254:
    for (i1 = -1;; i1 = 1)
    {
      q = (i1 * 0.05F + 1.0F);
      i1 = i2;
      if (paramBoolean3) {
        i1 = 1;
      }
      r = (0.3F * i1 + 1.0F);
      u = new aps(this);
      a(paramInt, paramBoolean4, false);
      b = true;
      return;
      d = Float.parseFloat(paramContext.getString(aol.b));
      e = Float.parseFloat(paramContext.getString(aol.a));
      break;
      h = Float.parseFloat(paramContext.getString(aol.k));
      break label116;
    }
  }
  
  public final ObjectAnimator b()
  {
    if ((!b) || (!c))
    {
      Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
      return null;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[] { Keyframe.ofFloat(0.0F, r), Keyframe.ofFloat(0.2F, r), Keyframe.ofFloat(0.84F, q), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.2F, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) }).setDuration(625L);
    localObjectAnimator.addUpdateListener(u);
    return localObjectAnimator;
  }
  
  public final boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    int i1 = 1;
    if ((getWidth() == 0) || (!b)) {
      return;
    }
    if (!c)
    {
      n = (getWidth() / 2);
      o = (getHeight() / 2);
      p = ((int)(Math.min(n, o) * d));
      if (!k)
      {
        i2 = (int)(p * e);
        o -= i2 / 2;
      }
      t = ((int)(p * i));
      c = true;
    }
    s = ((int)(p * h * j));
    int i2 = n;
    i2 = (int)(s * Math.sin(w)) + i2;
    int i3 = o - (int)(s * Math.cos(w));
    a.setAlpha(m);
    paramCanvas.drawCircle(i2, i3, t, a);
    int i4 = x;
    if (v % 30 != 0)
    {
      if ((i1 | i4) == 0) {
        break label314;
      }
      a.setAlpha(255);
      paramCanvas.drawCircle(i2, i3, t * 2 / 7, a);
      i1 = i3;
    }
    for (;;)
    {
      a.setAlpha(255);
      a.setStrokeWidth(1.0F);
      paramCanvas.drawLine(n, o, i2, i1, a);
      return;
      i1 = 0;
      break;
      label314:
      i1 = s - t;
      i2 = n;
      i3 = (int)(i1 * Math.sin(w));
      i1 = o - (int)(i1 * Math.cos(w));
      i2 += i3;
    }
  }
}

/* Location:
 * Qualified Name:     apr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */