import android.app.ActivityManager;
import android.os.Build;

public final class bhk
{
  public static boolean a()
  {
    return (ActivityManager.isRunningInTestHarness()) || (b()) || (ActivityManager.isUserAMonkey());
  }
  
  public static boolean b()
  {
    return "robolectric".equals(Build.FINGERPRINT);
  }
}

/* Location:
 * Qualified Name:     bhk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */