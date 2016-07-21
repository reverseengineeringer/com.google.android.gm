import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

public final class cuh
{
  private static Boolean a = null;
  
  public static void a(Context paramContext, String paramString)
  {
    if (a != null)
    {
      cvm.b("EasBundling", "ignoring init() after the first one", new Object[0]);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, paramString);
    boolean bool;
    if (paramContext.getPackageManager().resolveService(localIntent, 0) != null)
    {
      bool = true;
      a = Boolean.valueOf(bool);
      if (!cvm.a("EasBundling", 3)) {
        break label97;
      }
    }
    label97:
    for (paramContext = new Throwable();; paramContext = null)
    {
      cvm.d("EasBundling", paramContext, "in EasBundling.init, isBundlingEnabled=%s", new Object[] { a });
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean a()
  {
    if (bhk.b()) {
      return true;
    }
    cvm.b("EasBundling", "bundling=%s", new Object[] { a });
    return a.booleanValue();
  }
}

/* Location:
 * Qualified Name:     cuh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */