import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class bbm
{
  public static Intent a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, paramContext.getString(arh.s)));
    localIntent.putExtra("FLOW_MODE", 1);
    localIntent.putExtra("FLOW_ACCOUNT_TYPE", paramString);
    localIntent.putExtra("SKIP_LANDING", true);
    localIntent.putExtra("SOURCE_LABEL", "from_settings");
    return localIntent;
  }
}

/* Location:
 * Qualified Name:     bbm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */