import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

final class dbd
  implements dbc
{
  private final Context a;
  
  public dbd(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("Context cannot be null");
    }
    a = paramContext.getApplicationContext();
  }
  
  private final int a(String paramString1, String paramString2)
  {
    if (a == null) {
      return 0;
    }
    return a.getResources().getIdentifier(paramString1, paramString2, a.getPackageName());
  }
  
  public final int a(String paramString, int paramInt)
  {
    int i = a(paramString, "integer");
    if (i == 0) {
      return paramInt;
    }
    try
    {
      int j = Integer.parseInt(a.getString(i));
      return j;
    }
    catch (NumberFormatException paramString)
    {
      dav.f("NumberFormatException parsing " + a.getString(i));
    }
    return paramInt;
  }
  
  public final String a(String paramString)
  {
    int i = a(paramString, "string");
    if (i == 0) {
      return null;
    }
    return a.getString(i);
  }
  
  public final Double b(String paramString)
  {
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      double d = Double.parseDouble(paramString);
      return Double.valueOf(d);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      dav.f("NumberFormatException parsing " + paramString);
    }
    return null;
  }
  
  public final boolean c(String paramString)
  {
    int i = a(paramString, "bool");
    if (i == 0) {
      return false;
    }
    return "true".equalsIgnoreCase(a.getString(i));
  }
}

/* Location:
 * Qualified Name:     dbd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */