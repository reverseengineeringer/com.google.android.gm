import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class vx
  extends ImageView
{
  Animation.AnimationListener a;
  int b;
  
  public vx(Context paramContext)
  {
    super(paramContext);
    float f = getContextgetResourcesgetDisplayMetricsdensity;
    int i = (int)(20.0F * f * 2.0F);
    int j = (int)(1.75F * f);
    int k = (int)(0.0F * f);
    b = ((int)(3.5F * f));
    if (a())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      rg.f(this, f * 4.0F);
    }
    for (;;)
    {
      paramContext.getPaint().setColor(-328966);
      setBackgroundDrawable(paramContext);
      return;
      paramContext = new ShapeDrawable(new vy(this, b, i));
      rg.a(this, 1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(b, k, j, 503316480);
      i = b;
      setPadding(i, i, i, i);
    }
  }
  
  private static boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public final void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (a != null) {
      a.onAnimationEnd(getAnimation());
    }
  }
  
  public final void onAnimationStart()
  {
    super.onAnimationStart();
    if (a != null) {
      a.onAnimationStart(getAnimation());
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!a()) {
      setMeasuredDimension(getMeasuredWidth() + b * 2, getMeasuredHeight() + b * 2);
    }
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     vx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */