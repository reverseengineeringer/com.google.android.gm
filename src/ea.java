import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;

final class ea
  extends Drawable.ConstantState
{
  private final Drawable.ConstantState a;
  
  public ea(Drawable.ConstantState paramConstantState)
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
    dt localdt = new dt();
    b = ((VectorDrawable)a.newDrawable());
    return localdt;
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    dt localdt = new dt();
    b = ((VectorDrawable)a.newDrawable(paramResources));
    return localdt;
  }
  
  public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
  {
    dt localdt = new dt();
    b = ((VectorDrawable)a.newDrawable(paramResources, paramTheme));
    return localdt;
  }
}

/* Location:
 * Qualified Name:     ea
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */