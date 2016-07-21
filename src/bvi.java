import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public class bvi
  extends Drawable
  implements Drawable.Callback
{
  public final Drawable b;
  public final Drawable c;
  public final int d;
  public final int e;
  public final int f;
  public final ValueAnimator g;
  float h = 0.0F;
  boolean i = true;
  
  public bvi(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt)
  {
    b = paramDrawable1;
    c = paramDrawable2;
    b.setCallback(this);
    c.setCallback(this);
    d = paramInt;
    e = 0;
    f = 150;
    g = ValueAnimator.ofFloat(new float[] { 0.0F, 2.0F }).setDuration(e + d + f);
    g.addUpdateListener(new bvj(this));
    a(true);
  }
  
  public void a()
  {
    if (!i) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      if ((g.isStarted()) || (i)) {
        break;
      }
      g.start();
      return;
    }
    g.reverse();
  }
  
  public void a(boolean paramBoolean)
  {
    float f2 = h;
    g.cancel();
    if (paramBoolean) {}
    for (float f1 = 0.0F;; f1 = 2.0F)
    {
      h = f1;
      i = paramBoolean;
      if (h != f2) {
        invalidateSelf();
      }
      return;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if (i != paramBoolean) {
      a();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if ((!isVisible()) || (localRect.isEmpty())) {
      return;
    }
    float f1 = e + d + f;
    float f2 = e / f1;
    f1 = ((f1 - f) / f1 + f2) / 2.0F;
    int j;
    Drawable localDrawable;
    if (h / 2.0F < f1)
    {
      j = 1;
      if (j == 0) {
        break label158;
      }
      localDrawable = b;
      label85:
      f1 = e + d + f;
      if (h / 2.0F > e / f1) {
        break label167;
      }
      f1 = 1.0F;
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.scale(f1, 1.0F, localRect.exactCenterX(), localRect.exactCenterY());
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
      return;
      j = 0;
      break;
      label158:
      localDrawable = c;
      break label85;
      label167:
      if (h / 2.0F >= (f1 - f) / f1)
      {
        f1 = 1.0F;
      }
      else
      {
        float f3 = h / 2.0F;
        f2 = (e / f1 + (f1 - f) / f1) / 2.0F;
        f3 = Math.abs(f3 - f2);
        f1 = 1.0F / (f2 - e / f1) * f3;
      }
    }
  }
  
  public int getOpacity()
  {
    return resolveOpacity(b.getOpacity(), c.getOpacity());
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (paramRect.isEmpty())
    {
      b.setBounds(0, 0, 0, 0);
      c.setBounds(0, 0, 0, 0);
      return;
    }
    b.setBounds(paramRect);
    c.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return (b.setLevel(paramInt)) || (c.setLevel(paramInt));
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    b.setAlpha(paramInt);
    c.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    b.setColorFilter(paramColorFilter);
    c.setColorFilter(paramColorFilter);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     bvi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */