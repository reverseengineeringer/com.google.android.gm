import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.io.IOException;
import java.net.URLEncoder;

public class dgr
  extends cot<String>
{
  private static final String a = cvl.a;
  private final String b;
  private final String c;
  
  public dgr(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    b = paramString1;
    c = paramString2;
  }
  
  private final String b()
  {
    Object localObject = CookieSyncManager.createInstance(getContext());
    CookieManager.getInstance().removeAllCookie();
    ((CookieSyncManager)localObject).sync();
    Context localContext = getContext();
    localObject = a();
    dri.b(a, "Getting Gaia login link in background for %s", new Object[] { localObject });
    localObject = String.valueOf(URLEncoder.encode((String)localObject));
    if (((String)localObject).length() != 0) {}
    for (localObject = "service=mail&continue=".concat((String)localObject);; localObject = new String("service=mail&continue="))
    {
      localObject = String.valueOf(URLEncoder.encode((String)localObject));
      localObject = String.valueOf(localObject).length() + 14 + "weblogin:" + (String)localObject + "&de=1";
      if (!TextUtils.isEmpty(b)) {
        break;
      }
      return null;
    }
    int i = 0;
    for (;;)
    {
      if (i < 2) {
        try
        {
          String str = ecy.b(localContext, b, (String)localObject);
          return str;
        }
        catch (edf localedf)
        {
          dri.d(a, "User recoverable exception for scope: %s. Retrying.", new Object[] { localObject });
          i += 1;
        }
        catch (ecx localecx)
        {
          dri.e(a, "Google auth exception for scope: %s", new Object[] { localObject });
          return null;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            dri.d(a, "IO exception for scope: %s. Retrying.", new Object[] { localObject });
          }
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    return c;
  }
}

/* Location:
 * Qualified Name:     dgr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */