import android.app.ActivityManager;
import android.content.Context;

public final class cud
{
  public static boolean a(Context paramContext)
  {
    if (cxd.c())
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      return (paramContext != null) && (paramContext.isLowRamDevice());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     cud
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */