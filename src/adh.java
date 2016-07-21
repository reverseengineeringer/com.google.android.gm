import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

final class adh
  implements MenuItem.OnMenuItemClickListener
{
  private static final Class<?>[] a = { MenuItem.class };
  private Object b;
  private Method c;
  
  public adh(Object paramObject, String paramString)
  {
    b = paramObject;
    Class localClass = paramObject.getClass();
    try
    {
      c = localClass.getMethod(paramString, a);
      return;
    }
    catch (Exception paramObject)
    {
      paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
      paramString.initCause((Throwable)paramObject);
      throw paramString;
    }
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      if (c.getReturnType() == Boolean.TYPE) {
        return ((Boolean)c.invoke(b, new Object[] { paramMenuItem })).booleanValue();
      }
      c.invoke(b, new Object[] { paramMenuItem });
      return true;
    }
    catch (Exception paramMenuItem)
    {
      throw new RuntimeException(paramMenuItem);
    }
  }
}

/* Location:
 * Qualified Name:     adh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */