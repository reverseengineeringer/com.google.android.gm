import android.widget.PopupWindow;
import java.lang.reflect.Method;

class xp
  extends xo
{
  public void a(PopupWindow paramPopupWindow, int paramInt)
  {
    if (!xt.b) {}
    try
    {
      xt.a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
      xt.a.setAccessible(true);
      xt.b = true;
      if (xt.a != null) {}
      try
      {
        xt.a.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception paramPopupWindow) {}
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     xp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */