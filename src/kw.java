import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

final class kw
{
  static Method a;
  static boolean b;
  private static Method c;
  private static boolean d;
  
  public static int a(Drawable paramDrawable)
  {
    if (!d) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
      c = localMethod;
      localMethod.setAccessible(true);
      d = true;
      if (c != null) {
        try
        {
          int i = ((Integer)c.invoke(paramDrawable, new Object[0])).intValue();
          return i;
        }
        catch (Exception paramDrawable)
        {
          c = null;
        }
      }
      return -1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     kw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */