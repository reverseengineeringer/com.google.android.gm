import android.content.Context;
import android.content.Intent;

public final class dol
{
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("com.google.android.gm.intent.VALIDATE_ACCOUNT_NOTIFICATIONS");
    localIntent.putExtra("account", paramString);
    paramContext.sendBroadcast(localIntent, "com.google.android.gm.permission.BROADCAST_INTERNAL");
  }
}

/* Location:
 * Qualified Name:     dol
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */