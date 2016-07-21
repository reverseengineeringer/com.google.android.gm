import android.app.AppOpsManager;
import android.content.Context;

final class et
  extends eu
{
  public final int a(Context paramContext, String paramString1, String paramString2)
  {
    return ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOp(paramString1, paramString2);
  }
  
  public final String a(String paramString)
  {
    return AppOpsManager.permissionToOp(paramString);
  }
}

/* Location:
 * Qualified Name:     et
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */