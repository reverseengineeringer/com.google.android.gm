import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class qe
{
  static final qi a = new qf();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      a = new qh();
      return;
    }
    if (i >= 11)
    {
      a = new qg();
      return;
    }
  }
  
  public static MenuItem a(MenuItem paramMenuItem, View paramView)
  {
    if ((paramMenuItem instanceof ll)) {
      return ((ll)paramMenuItem).setActionView(paramView);
    }
    return a.a(paramMenuItem, paramView);
  }
  
  public static MenuItem a(MenuItem paramMenuItem, oy paramoy)
  {
    if ((paramMenuItem instanceof ll)) {
      return ((ll)paramMenuItem).a(paramoy);
    }
    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
    return paramMenuItem;
  }
  
  public static View a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof ll)) {
      return ((ll)paramMenuItem).getActionView();
    }
    return a.a(paramMenuItem);
  }
  
  public static void a(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof ll))
    {
      ((ll)paramMenuItem).setShowAsAction(paramInt);
      return;
    }
    a.a(paramMenuItem, paramInt);
  }
  
  public static MenuItem b(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof ll)) {
      return ((ll)paramMenuItem).setActionView(paramInt);
    }
    return a.b(paramMenuItem, paramInt);
  }
  
  public static boolean b(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof ll)) {
      return ((ll)paramMenuItem).expandActionView();
    }
    return a.b(paramMenuItem);
  }
  
  public static boolean c(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof ll)) {
      return ((ll)paramMenuItem).isActionViewExpanded();
    }
    return a.c(paramMenuItem);
  }
}

/* Location:
 * Qualified Name:     qe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */