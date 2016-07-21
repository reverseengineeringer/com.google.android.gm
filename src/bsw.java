import android.content.Context;
import android.content.Intent;

public final class bsw
{
  public static void a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.android.email.UPDATE_AUTH_NOTIFICATION");
    localIntent.putExtra("account_id", paramLong);
    localIntent.putExtra("auth_failed", paramBoolean);
    paramContext.sendBroadcast(localIntent);
  }
}

/* Location:
 * Qualified Name:     bsw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */