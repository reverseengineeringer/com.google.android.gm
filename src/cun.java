import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public final class cun
{
  public static int a(Context paramContext)
  {
    int i = -1;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gm.exchange", 0);
      if (paramContext != null) {
        i = versionCode;
      }
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return -1;
  }
}

/* Location:
 * Qualified Name:     cun
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */