import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.dataservice.TokenRequest;
import com.google.android.gms.auth.firstparty.dataservice.TokenResponse;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import java.util.UUID;

final class eai
  implements Runnable
{
  private static final String a = cvl.a;
  private final Context b;
  private final String c;
  
  eai(Context paramContext, String paramString)
  {
    b = paramContext;
    c = paramString;
  }
  
  public final void run()
  {
    Object localObject1 = new eet(b);
    Object localObject2 = UUID.randomUUID().toString();
    Object localObject3 = new TokenRequest();
    l = true;
    j = new AppDescription(b.getPackageName(), b.getApplicationInfo().uid, (String)localObject2, (String)localObject2);
    c = c;
    b = "oauth2:https://www.googleapis.com/auth/gmail.readonly";
    dri.b(a, "Token request created", new Object[0]);
    for (;;)
    {
      try
      {
        enz.a(localObject3, "TokenRequest cannot be null!");
        localObject2 = (TokenResponse)((eet)localObject1).a(new eeu((eet)localObject1, (TokenRequest)localObject3));
        localObject1 = null;
        if (localObject2 != null) {
          localObject1 = d;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          dri.c(a, "Successfully obtained token forcing email check", new Object[0]);
          return;
        }
        localObject3 = a;
        if (localObject2 == null)
        {
          localObject1 = "response";
          dri.d((String)localObject3, "Failed to obtain token - %s was null", new Object[] { localObject1 });
          return;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        dri.e(a, "Failed to obtain token - %s", new Object[] { localRuntimeException.getMessage() });
        return;
      }
      String str = "token";
    }
  }
}

/* Location:
 * Qualified Name:     eai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */