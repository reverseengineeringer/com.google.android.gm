import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class lb
  extends ky
{
  lb(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  lb(kz paramkz, Resources paramResources)
  {
    super(paramkz, paramResources);
  }
  
  protected final Drawable a(Drawable.ConstantState paramConstantState, Resources paramResources)
  {
    return paramConstantState.newDrawable(paramResources);
  }
  
  final kz b()
  {
    return new lc(b);
  }
}

/* Location:
 * Qualified Name:     lb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */