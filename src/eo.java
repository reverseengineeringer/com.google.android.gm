import android.app.Activity;
import android.content.pm.PackageManager;

public final class eo
  implements Runnable
{
  public eo(String[] paramArrayOfString, Activity paramActivity, int paramInt) {}
  
  public final void run()
  {
    int[] arrayOfInt = new int[a.length];
    PackageManager localPackageManager = b.getPackageManager();
    String str = b.getPackageName();
    int j = a.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = localPackageManager.checkPermission(a[i], str);
      i += 1;
    }
    ((ep)b).onRequestPermissionsResult(c, a, arrayOfInt);
  }
}

/* Location:
 * Qualified Name:     eo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */