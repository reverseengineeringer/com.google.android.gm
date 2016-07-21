import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;

final class lh
  extends lf
{
  lh(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  lh(kz paramkz, Resources paramResources)
  {
    super(paramkz, paramResources);
  }
  
  final kz b()
  {
    return new li(b);
  }
  
  protected final boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT == 21)
    {
      Drawable localDrawable = c;
      if ((!(localDrawable instanceof GradientDrawable)) && (!(localDrawable instanceof DrawableContainer)))
      {
        bool1 = bool2;
        if (!(localDrawable instanceof InsetDrawable)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Rect getDirtyBounds()
  {
    return c.getDirtyBounds();
  }
  
  public final void getOutline(Outline paramOutline)
  {
    c.getOutline(paramOutline);
  }
  
  public final void setHotspot(float paramFloat1, float paramFloat2)
  {
    c.setHotspot(paramFloat1, paramFloat2);
  }
  
  public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    if (super.setState(paramArrayOfInt))
    {
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public final void setTint(int paramInt)
  {
    if (c())
    {
      super.setTint(paramInt);
      return;
    }
    c.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (c())
    {
      super.setTintList(paramColorStateList);
      return;
    }
    c.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (c())
    {
      super.setTintMode(paramMode);
      return;
    }
    c.setTintMode(paramMode);
  }
}

/* Location:
 * Qualified Name:     lh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */