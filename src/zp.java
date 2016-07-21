import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

final class zp
  implements zj
{
  final Activity a;
  
  zp(Activity paramActivity)
  {
    a = paramActivity;
  }
  
  public final Drawable a()
  {
    TypedArray localTypedArray = b().obtainStyledAttributes(null, new int[] { 16843531 }, 16843470, 0);
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }
  
  public final void a(int paramInt)
  {
    ActionBar localActionBar = a.getActionBar();
    if (localActionBar != null) {
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
  
  public final void a(Drawable paramDrawable, int paramInt)
  {
    ActionBar localActionBar = a.getActionBar();
    if (localActionBar != null)
    {
      localActionBar.setHomeAsUpIndicator(paramDrawable);
      localActionBar.setHomeActionContentDescription(paramInt);
    }
  }
  
  public final Context b()
  {
    ActionBar localActionBar = a.getActionBar();
    if (localActionBar != null) {
      return localActionBar.getThemedContext();
    }
    return a;
  }
  
  public final boolean c()
  {
    ActionBar localActionBar = a.getActionBar();
    return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
  }
}

/* Location:
 * Qualified Name:     zp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */