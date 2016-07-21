import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dyp
{
  public static String a(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    if (paramAccount == null) {
      return null;
    }
    paramContext = String.valueOf(bur.a(paramContext, e));
    paramAccount = String.valueOf(cui.b(c));
    return String.valueOf(paramContext).length() + 1 + String.valueOf(paramAccount).length() + paramContext + ":" + paramAccount;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = drp.a(paramString1);
    if (paramString1 == null) {
      return cui.a(paramString2);
    }
    if (TextUtils.isEmpty(o.d())) {
      return "gmail";
    }
    if ("google.com".equals(paramString2)) {
      return "google-corp";
    }
    return "google-apps";
  }
  
  public static boolean a(android.accounts.Account paramAccount)
  {
    return (paramAccount != null) && ("com.google".equals(type));
  }
  
  public static boolean a(ContentResolver paramContentResolver, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile(ghz.a(paramContentResolver, "gmail_account_extras_uri_host_pattern", "(?:.+\\.)?google(?:\\.co[m]?)?\\.\\w{2,3}")).matcher(paramString).matches();
  }
  
  public static boolean a(com.android.mail.providers.Account paramAccount)
  {
    return (paramAccount != null) && ("com.google".equals(e));
  }
  
  public static String b(String paramString1, String paramString2)
  {
    int i = -1;
    switch (paramString2.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      case 0: 
      case 1: 
      default: 
        return paramString1;
        if (paramString2.equals("gmail"))
        {
          i = 0;
          continue;
          if (paramString2.equals("google-corp"))
          {
            i = 1;
            continue;
            if (paramString2.equals("google-apps"))
            {
              i = 2;
              continue;
              if (paramString2.equals("other")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return "google-apps";
    return "other";
  }
}

/* Location:
 * Qualified Name:     dyp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */