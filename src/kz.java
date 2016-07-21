import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class kz
  extends Drawable.ConstantState
{
  int a;
  Drawable.ConstantState b;
  ColorStateList c = null;
  PorterDuff.Mode d = ky.a;
  
  kz(kz paramkz)
  {
    if (paramkz != null)
    {
      a = a;
      b = b;
      c = c;
      d = d;
    }
  }
  
  public int getChangingConfigurations()
  {
    int j = a;
    if (b != null) {}
    for (int i = b.getChangingConfigurations();; i = 0) {
      return i | j;
    }
  }
  
  public Drawable newDrawable()
  {
    return newDrawable(null);
  }
  
  public abstract Drawable newDrawable(Resources paramResources);
}

/* Location:
 * Qualified Name:     kz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */