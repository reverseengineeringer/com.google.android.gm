import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

abstract class ds
  extends Drawable
  implements lj
{
  Drawable b;
  
  static TypedArray a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    if (b != null) {
      kn.a(b, paramTheme);
    }
  }
  
  public void clearColorFilter()
  {
    if (b != null)
    {
      b.clearColorFilter();
      return;
    }
    super.clearColorFilter();
  }
  
  public ColorFilter getColorFilter()
  {
    if (b != null)
    {
      Drawable localDrawable = b;
      return kn.a.g(localDrawable);
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    if (b != null) {
      return b.getCurrent();
    }
    return super.getCurrent();
  }
  
  public int getLayoutDirection()
  {
    if (b != null) {
      kn.g(b);
    }
    return 0;
  }
  
  public int getMinimumHeight()
  {
    if (b != null) {
      return b.getMinimumHeight();
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    if (b != null) {
      return b.getMinimumWidth();
    }
    return super.getMinimumWidth();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (b != null) {
      return b.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    if (b != null) {
      return b.getState();
    }
    return super.getState();
  }
  
  public Region getTransparentRegion()
  {
    if (b != null) {
      return b.getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public boolean isAutoMirrored()
  {
    if (b != null) {
      kn.b(b);
    }
    return false;
  }
  
  public void jumpToCurrentState()
  {
    if (b != null) {
      kn.a(b);
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (b != null)
    {
      b.setBounds(paramRect);
      return;
    }
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (b != null) {
      return b.setLevel(paramInt);
    }
    return super.onLevelChange(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (b != null) {
      kn.a(b, paramBoolean);
    }
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    if (b != null)
    {
      b.setChangingConfigurations(paramInt);
      return;
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if (b != null)
    {
      b.setColorFilter(paramInt, paramMode);
      return;
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (b != null) {
      b.setFilterBitmap(paramBoolean);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (b != null) {
      kn.a(b, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (b != null) {
      kn.a(b, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (b != null) {
      return b.setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
}

/* Location:
 * Qualified Name:     ds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */