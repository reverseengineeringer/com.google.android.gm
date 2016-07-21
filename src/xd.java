import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

final class xd
  extends Drawable
  implements Animatable
{
  static final Interpolator a = new vr();
  private static final Interpolator e = new LinearInterpolator();
  final xh b;
  float c;
  boolean d;
  private final int[] f = { -16777216 };
  private final ArrayList<Animation> g = new ArrayList();
  private float h;
  private Resources i;
  private View j;
  private Animation k;
  private double l;
  private double m;
  private final Drawable.Callback n = new xg(this);
  
  public xd(Context paramContext, View paramView)
  {
    j = paramView;
    i = paramContext.getResources();
    b = new xh(n);
    b.a(f);
    paramContext = b;
    float f1 = i.getDisplayMetrics().density;
    l = (f1 * 40.0D);
    m = (f1 * 40.0D);
    float f2 = 2.5F * f1;
    g = f2;
    b.setStrokeWidth(f2);
    paramContext.d();
    q = (8.75D * f1);
    paramContext.a(0);
    r = ((int)(10.0F * f1));
    s = ((int)(f1 * 5.0F));
    f1 = Math.min((int)l, (int)m);
    if ((q <= 0.0D) || (f1 < 0.0F)) {}
    for (f1 = (float)Math.ceil(g / 2.0F);; f1 = (float)(f1 / 2.0F - q))
    {
      h = f1;
      paramContext = b;
      paramView = new xe(this, paramContext);
      paramView.setRepeatCount(-1);
      paramView.setRepeatMode(1);
      paramView.setInterpolator(e);
      paramView.setAnimationListener(new xf(this, paramContext));
      k = paramView;
      return;
    }
  }
  
  static float a(xh paramxh)
  {
    return (float)Math.toRadians(g / (6.283185307179586D * q));
  }
  
  static void a(float paramFloat, xh paramxh)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int i1 = i[j];
      int i5 = i[paramxh.a()];
      int i4 = Integer.valueOf(i1).intValue();
      i1 = i4 >> 24 & 0xFF;
      int i2 = i4 >> 16 & 0xFF;
      int i3 = i4 >> 8 & 0xFF;
      i4 &= 0xFF;
      i5 = Integer.valueOf(i5).intValue();
      int i6 = (int)(((i5 >> 24 & 0xFF) - i1) * paramFloat);
      int i7 = (int)(((i5 >> 16 & 0xFF) - i2) * paramFloat);
      int i8 = (int)(((i5 >> 8 & 0xFF) - i3) * paramFloat);
      w = ((int)(paramFloat * ((i5 & 0xFF) - i4)) + i4 | i1 + i6 << 24 | i2 + i7 << 16 | i8 + i3 << 8);
    }
  }
  
  public final void a(float paramFloat)
  {
    xh localxh = b;
    if (paramFloat != p)
    {
      p = paramFloat;
      localxh.d();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    b.a(paramBoolean);
  }
  
  public final void b(float paramFloat)
  {
    b.a(0.0F);
    b.b(paramFloat);
  }
  
  final void c(float paramFloat)
  {
    h = paramFloat;
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i1 = paramCanvas.save();
    paramCanvas.rotate(h, localRect.exactCenterX(), localRect.exactCenterY());
    xh localxh = b;
    RectF localRectF = a;
    localRectF.set(localRect);
    localRectF.inset(h, h);
    float f1 = 360.0F * (d + f);
    float f2 = (e + f) * 360.0F - f1;
    b.setColor(w);
    paramCanvas.drawArc(localRectF, f1, f2, false, b);
    if (n)
    {
      if (o != null) {
        break label434;
      }
      o = new Path();
      o.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      float f3 = (int)h / 2;
      float f4 = p;
      float f5 = (float)(q * Math.cos(0.0D) + localRect.exactCenterX());
      float f6 = (float)(q * Math.sin(0.0D) + localRect.exactCenterY());
      o.moveTo(0.0F, 0.0F);
      o.lineTo(r * p, 0.0F);
      o.lineTo(r * p / 2.0F, s * p);
      o.offset(f5 - f3 * f4, f6);
      o.close();
      c.setColor(w);
      paramCanvas.rotate(f1 + f2 - 5.0F, localRect.exactCenterX(), localRect.exactCenterY());
      paramCanvas.drawPath(o, c);
      if (t < 255)
      {
        u.setColor(v);
        u.setAlpha(255 - t);
        paramCanvas.drawCircle(localRect.exactCenterX(), localRect.exactCenterY(), localRect.width() / 2, u);
      }
      paramCanvas.restoreToCount(i1);
      return;
      label434:
      o.reset();
    }
  }
  
  public final int getAlpha()
  {
    return b.t;
  }
  
  public final int getIntrinsicHeight()
  {
    return (int)m;
  }
  
  public final int getIntrinsicWidth()
  {
    return (int)l;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    ArrayList localArrayList = g;
    int i2 = localArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Animation localAnimation = (Animation)localArrayList.get(i1);
      if ((localAnimation.hasStarted()) && (!localAnimation.hasEnded())) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public final void setAlpha(int paramInt)
  {
    b.t = paramInt;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    xh localxh = b;
    b.setColorFilter(paramColorFilter);
    localxh.d();
  }
  
  public final void start()
  {
    k.reset();
    b.b();
    if (b.e != b.d)
    {
      d = true;
      k.setDuration(666L);
      j.startAnimation(k);
      return;
    }
    b.a(0);
    b.c();
    k.setDuration(1332L);
    j.startAnimation(k);
  }
  
  public final void stop()
  {
    j.clearAnimation();
    c(0.0F);
    b.a(false);
    b.a(0);
    b.c();
  }
}

/* Location:
 * Qualified Name:     xd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */