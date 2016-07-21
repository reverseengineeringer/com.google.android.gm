import android.os.Build.VERSION;
import android.widget.PopupWindow;

public final class xl
{
  public static final xr a = new xo();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      a = new xn();
      return;
    }
    if (i >= 21)
    {
      a = new xm();
      return;
    }
    if (i >= 19)
    {
      a = new xq();
      return;
    }
    if (i >= 9)
    {
      a = new xp();
      return;
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    a.a(paramPopupWindow, paramInt);
  }
}

/* Location:
 * Qualified Name:     xl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */