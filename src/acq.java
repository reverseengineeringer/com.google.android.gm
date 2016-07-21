import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public class acq
  extends Drawable
  implements Drawable.Callback
{
  public Drawable m;
  
  public acq(Drawable paramDrawable)
  {
    if (m != null) {
      m.setCallback(null);
    }
    m = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    m.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    return m.getChangingConfigurations();
  }
  
  public Drawable getCurrent()
  {
    return m.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return m.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return m.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return m.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return m.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return m.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return m.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    return m.getState();
  }
  
  public Region getTransparentRegion()
  {
    return m.getTransparentRegion();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    return kn.b(m);
  }
  
  public boolean isStateful()
  {
    return m.isStateful();
  }
  
  public void jumpToCurrentState()
  {
    kn.a(m);
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    m.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return m.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    m.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    kn.a(m, paramBoolean);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    m.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    m.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    m.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    m.setFilterBitmap(paramBoolean);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    kn.a(m, paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    kn.a(m, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    return m.setState(paramArrayOfInt);
  }
  
  public void setTint(int paramInt)
  {
    kn.a(m, paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    kn.a(m, paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    kn.a(m, paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (super.setVisible(paramBoolean1, paramBoolean2)) || (m.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     acq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */