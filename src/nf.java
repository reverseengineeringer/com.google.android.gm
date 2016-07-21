import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

final class nf
{
  private static Method a;
  
  static
  {
    try
    {
      a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[] { Locale.class });
      return;
    }
    catch (Exception localException)
    {
      throw new IllegalStateException(localException);
    }
  }
  
  public static String a(Locale paramLocale)
  {
    try
    {
      String str = ((Locale)a.invoke(null, new Object[] { paramLocale })).getScript();
      return str;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.w("ICUCompatIcs", localInvocationTargetException);
      return paramLocale.getScript();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.w("ICUCompatIcs", localIllegalAccessException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     nf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */