import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

final class jk
  implements ji
{
  public final PendingIntent a(Context paramContext, Intent[] paramArrayOfIntent, int paramInt1, int paramInt2)
  {
    paramArrayOfIntent[0] = new Intent(paramArrayOfIntent[0]).addFlags(268484608);
    return PendingIntent.getActivities(paramContext, paramInt1, paramArrayOfIntent, 134217728);
  }
}

/* Location:
 * Qualified Name:     jk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */