import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class ko
  implements kp
{
  public void a(Drawable paramDrawable) {}
  
  public void a(Drawable paramDrawable, float paramFloat1, float paramFloat2) {}
  
  public void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof lj)) {
      ((lj)paramDrawable).setTint(paramInt);
    }
  }
  
  public void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    if ((paramDrawable instanceof lj)) {
      ((lj)paramDrawable).setTintList(paramColorStateList);
    }
  }
  
  public void a(Drawable paramDrawable, Resources.Theme paramTheme) {}
  
  public void a(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    if ((paramDrawable instanceof lj)) {
      ((lj)paramDrawable).setTintMode(paramMode);
    }
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean) {}
  
  public void b(Drawable paramDrawable, int paramInt) {}
  
  public boolean b(Drawable paramDrawable)
  {
    return false;
  }
  
  public Drawable c(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof lj)) {
      localObject = new ky(paramDrawable);
    }
    return (Drawable)localObject;
  }
  
  public int d(Drawable paramDrawable)
  {
    return 0;
  }
  
  public int e(Drawable paramDrawable)
  {
    return 0;
  }
  
  public boolean f(Drawable paramDrawable)
  {
    return false;
  }
  
  public ColorFilter g(Drawable paramDrawable)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     ko
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */