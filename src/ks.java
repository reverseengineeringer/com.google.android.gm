import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

class ks
  extends kr
{
  public void b(Drawable paramDrawable, int paramInt)
  {
    if (!kw.b) {}
    try
    {
      kw.a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
      kw.a.setAccessible(true);
      kw.b = true;
      if (kw.a != null) {}
      try
      {
        kw.a.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception paramDrawable)
      {
        kw.a = null;
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
  }
  
  public int d(Drawable paramDrawable)
  {
    int i = kw.a(paramDrawable);
    if (i >= 0) {
      return i;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     ks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */