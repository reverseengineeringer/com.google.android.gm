import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class dn
  extends Drawable.ConstantState
{
  private final Drawable.ConstantState a;
  
  public dn(Drawable.ConstantState paramConstantState)
  {
    a = paramConstantState;
  }
  
  public final boolean canApplyTheme()
  {
    return a.canApplyTheme();
  }
  
  public final int getChangingConfigurations()
  {
    return a.getChangingConfigurations();
  }
  
  public final Drawable newDrawable()
  {
    dk localdk = new dk();
    b = a.newDrawable();
    b.setCallback(a);
    return localdk;
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    dk localdk = new dk();
    b = a.newDrawable(paramResources);
    b.setCallback(a);
    return localdk;
  }
  
  public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
  {
    dk localdk = new dk();
    b = a.newDrawable(paramResources, paramTheme);
    b.setCallback(a);
    return localdk;
  }
}

/* Location:
 * Qualified Name:     dn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */