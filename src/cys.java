import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public final class cys
  extends LayerDrawable
{
  public ColorStateList a = null;
  
  private cys(Drawable paramDrawable)
  {
    super(new Drawable[] { paramDrawable });
  }
  
  public static cys a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof cys)) {
      return (cys)paramDrawable;
    }
    return new cys(paramDrawable.mutate());
  }
  
  public final boolean a()
  {
    boolean bool = false;
    if (a != null)
    {
      setColorFilter(a.getColorForState(getState(), 0), PorterDuff.Mode.SRC_IN);
      bool = true;
    }
    return bool;
  }
  
  public final boolean isStateful()
  {
    return true;
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    boolean bool1 = super.setState(paramArrayOfInt);
    boolean bool2 = a();
    return (bool1) || (bool2);
  }
}

/* Location:
 * Qualified Name:     cys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */