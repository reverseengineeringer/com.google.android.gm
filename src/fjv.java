import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.concurrent.atomic.AtomicInteger;

public final class fjv
{
  public static int a = 5000000;
  public static int b = 6500000;
  public static int c = 7000000;
  private static final AtomicInteger d = new AtomicInteger(1);
  
  public static String a(Context paramContext)
  {
    return fmf.a(paramContext);
  }
  
  public static int b(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = getPackageInfoa0versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return -1;
  }
}

/* Location:
 * Qualified Name:     fjv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */