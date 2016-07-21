import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;

public final class kl
{
  public static int a(Context paramContext, String paramString)
  {
    int i = Process.myPid();
    int j = Process.myUid();
    String str1 = paramContext.getPackageName();
    if (paramContext.checkPermission(paramString, i, j) == -1) {
      return -1;
    }
    String str2 = es.a.a(paramString);
    if (str2 != null)
    {
      paramString = str1;
      if (str1 == null)
      {
        paramString = paramContext.getPackageManager().getPackagesForUid(j);
        if ((paramString == null) || (paramString.length <= 0)) {
          return -1;
        }
        paramString = paramString[0];
      }
      if (es.a.a(paramContext, str2, paramString) != 0) {
        return -2;
      }
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     kl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */