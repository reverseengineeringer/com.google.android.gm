import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

final class zo
  implements zj
{
  final Activity a;
  zr b;
  
  zo(Activity paramActivity)
  {
    a = paramActivity;
  }
  
  public final Drawable a()
  {
    return zq.a(a);
  }
  
  public final void a(int paramInt)
  {
    b = zq.a(b, a, paramInt);
  }
  
  public final void a(Drawable paramDrawable, int paramInt)
  {
    a.getActionBar().setDisplayShowHomeEnabled(true);
    b = zq.a(a, paramDrawable, paramInt);
    a.getActionBar().setDisplayShowHomeEnabled(false);
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
 * Qualified Name:     zo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */