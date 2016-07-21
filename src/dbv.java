import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.apps.common.drive.aclfix.PotentialFix;

public final class dbv
  extends dbx<String>
{
  private static String b(Context paramContext, Bundle paramBundle)
  {
    String str2 = paramBundle.getString("account");
    Object localObject = (PotentialFix)paramBundle.getParcelable("fix");
    String str1 = paramBundle.getString("role");
    boolean bool = paramBundle.getBoolean("useConscrypt");
    try
    {
      paramContext = a(paramContext, str2, "oauth2:https://www.googleapis.com/auth/drive", Boolean.valueOf(bool).booleanValue());
      paramBundle = new gvq();
      str2 = a;
      recipientEmailAddresses = b;
      fileIds = c;
      role = str1;
      fixOptionType = str2;
      if (Log.isLoggable("DriveUtils", 2))
      {
        localObject = String.valueOf(paramBundle);
        new StringBuilder(String.valueOf(localObject).length() + 25).append("fix permissions request: ").append((String)localObject);
      }
      new gvi(paramContext.d(), paramBundle).c();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("DriveUtils", "problem fixing Drive permission", paramContext);
      }
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     dbv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */