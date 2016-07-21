import android.app.Activity;
import android.content.Context;

public final class cwm
{
  public static void a(Activity paramActivity, int paramInt, String... paramVarArgs)
  {
    cfm localcfm = cfm.a(paramActivity.getApplicationContext());
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localcfm.f(paramVarArgs[i]);
      i += 1;
    }
    paramActivity.requestPermissions(paramVarArgs, paramInt);
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if (!cxd.e()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
      } while (b(paramActivity, paramString));
      bool1 = cfm.a(paramActivity.getApplicationContext()).e(paramString);
      bool2 = paramActivity.shouldShowRequestPermissionRationale(paramString);
    } while ((bool1) && (!bool2));
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (cxd.e()) {
      return b(paramContext, paramString);
    }
    return true;
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    return paramContext.checkSelfPermission(paramString) == 0;
  }
}

/* Location:
 * Qualified Name:     cwm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */