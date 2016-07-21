import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.Method;

final class zq
{
  private static final int[] a = { 16843531 };
  
  public static Drawable a(Activity paramActivity)
  {
    paramActivity = paramActivity.obtainStyledAttributes(a);
    Drawable localDrawable = paramActivity.getDrawable(0);
    paramActivity.recycle();
    return localDrawable;
  }
  
  public static zr a(Activity paramActivity, Drawable paramDrawable, int paramInt)
  {
    zr localzr = new zr(paramActivity);
    if (a != null) {
      try
      {
        paramActivity = paramActivity.getActionBar();
        a.invoke(paramActivity, new Object[] { paramDrawable });
        b.invoke(paramActivity, new Object[] { Integer.valueOf(paramInt) });
        return localzr;
      }
      catch (Exception paramActivity)
      {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", paramActivity);
        return localzr;
      }
    }
    if (c != null)
    {
      c.setImageDrawable(paramDrawable);
      return localzr;
    }
    Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
    return localzr;
  }
  
  public static zr a(zr paramzr, Activity paramActivity, int paramInt)
  {
    zr localzr = paramzr;
    if (paramzr == null) {
      localzr = new zr(paramActivity);
    }
    if (a != null) {}
    try
    {
      paramzr = paramActivity.getActionBar();
      b.invoke(paramzr, new Object[] { Integer.valueOf(paramInt) });
      if (Build.VERSION.SDK_INT <= 19) {
        paramzr.setSubtitle(paramzr.getSubtitle());
      }
      return localzr;
    }
    catch (Exception paramzr)
    {
      Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", paramzr);
    }
    return localzr;
  }
}

/* Location:
 * Qualified Name:     zq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */