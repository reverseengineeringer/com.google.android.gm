import android.content.Context;
import android.content.Intent;

public final class btg
{
  public static boolean a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.google.android.gm.exchange", paramString);
    return paramContext.stopService(localIntent);
  }
}

/* Location:
 * Qualified Name:     btg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */