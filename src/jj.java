import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

final class jj
  implements ji
{
  public final PendingIntent a(Context paramContext, Intent[] paramArrayOfIntent, int paramInt1, int paramInt2)
  {
    paramArrayOfIntent = new Intent(paramArrayOfIntent[(paramArrayOfIntent.length - 1)]);
    paramArrayOfIntent.addFlags(268435456);
    return PendingIntent.getActivity(paramContext, paramInt1, paramArrayOfIntent, 134217728);
  }
}

/* Location:
 * Qualified Name:     jj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */