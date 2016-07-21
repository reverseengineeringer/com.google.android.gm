import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.apps.common.drive.aclfix.PotentialFix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dbt
  extends dbx<dbu>
{
  private static dbu b(Context paramContext, Bundle paramBundle)
  {
    String str = paramBundle.getString("account");
    Object localObject1 = paramBundle.getStringArrayList("recipients");
    Object localObject2 = paramBundle.getStringArrayList("fileIds");
    boolean bool = paramBundle.getBoolean("useConscrypt");
    for (;;)
    {
      try
      {
        paramContext = a(paramContext, str, "oauth2:https://www.googleapis.com/auth/drive", Boolean.valueOf(bool).booleanValue());
        paramBundle = new gvl();
        recipientEmailAddresses = ((List)localObject1);
        fileIds = ((List)localObject2);
        role = "READER";
        bool = Log.isLoggable("DriveUtils", 2);
        if (bool)
        {
          localObject1 = String.valueOf(paramBundle.c());
          if (((String)localObject1).length() != 0) {
            "check permissions request: ".concat((String)localObject1);
          }
        }
        else
        {
          paramContext = (gvm)new gvh(paramContext.d(), paramBundle).c();
          if (bool)
          {
            paramBundle = String.valueOf(paramContext.c());
            if (paramBundle.length() == 0) {
              break label250;
            }
            "check permissions response: ".concat(paramBundle);
          }
          if (paramContext != null)
          {
            localObject1 = fixOptions;
            paramBundle = new ArrayList();
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((List)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (gvn)((Iterator)localObject1).next();
            if (!PotentialFix.a(optionType)) {
              continue;
            }
            paramBundle.add(new PotentialFix((gvn)localObject2));
            continue;
          }
          return null;
        }
      }
      catch (Exception paramContext)
      {
        Log.e("DriveUtils", "problem checking Drive permission", paramContext);
      }
      new String("check permissions request: ");
      continue;
      label250:
      new String("check permissions response: ");
    }
    paramContext = new dbu(fixabilitySummaryState, paramBundle);
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     dbt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */