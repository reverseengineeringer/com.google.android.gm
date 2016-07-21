import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class bnq
{
  public static boolean a = false;
  public static boolean b = false;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static final SimpleDateFormat g;
  private static String h;
  
  static
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'", Locale.US);
    g = localSimpleDateFormat;
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  
  public static Double a(String paramString)
  {
    if ("2.5".equals(paramString)) {
      return Double.valueOf(2.5D);
    }
    if ("12.0".equals(paramString)) {
      return Double.valueOf(12.0D);
    }
    if ("12.1".equals(paramString)) {
      return Double.valueOf(12.1D);
    }
    if ("14.0".equals(paramString)) {
      return Double.valueOf(14.0D);
    }
    if ("14.1".equals(paramString)) {
      return Double.valueOf(14.1D);
    }
    if ("16.0".equals(paramString)) {
      return Double.valueOf(16.0D);
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "illegal protocol version ".concat(paramString);; paramString = new String("illegal protocol version ")) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 68: 
    default: 
      return "Email";
    case 65: 
      return "Calendar";
    case 66: 
      return "Contacts";
    }
    return "Email";
  }
  
  public static void a(Context paramContext)
  {
    c = paramContext.getString(bnu.a);
    h = paramContext.getString(bnu.b);
    d = paramContext.getString(bnu.h);
    e = paramContext.getString(bnu.i);
    f = paramContext.getString(bnu.j);
  }
  
  public static boolean b(String paramString)
  {
    return (!hbw.b(paramString)) && (a(paramString).doubleValue() >= 14.0D);
  }
  
  public static boolean c(String paramString)
  {
    return (paramString != null) && (a(paramString).doubleValue() >= 16.0D);
  }
  
  public static boolean d(String paramString)
  {
    return c(paramString);
  }
}

/* Location:
 * Qualified Name:     bnq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */