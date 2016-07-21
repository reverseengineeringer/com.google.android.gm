import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;

public final class cxd
{
  public static String a(Context paramContext)
  {
    try
    {
      String str = getPackageManagergetPackageInfogetPackageName0versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      cvm.e(cvm.a, "Error finding package %s", new Object[] { getApplicationInfopackageName });
    }
    return null;
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public static boolean e()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean f()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
}

/* Location:
 * Qualified Name:     cxd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */