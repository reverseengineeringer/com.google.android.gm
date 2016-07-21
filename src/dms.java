import android.accounts.Account;
import android.content.Context;

public final class dms
{
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "oauth2:https://www.googleapis.com/auth/gmail.full_access";
    }
    return ghz.a(paramContext.getContentResolver(), "gmail_full_access_dev_code", "oauth2:https://www.googleapis.com/auth/gmail.full_access");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString2.startsWith("oauth2:")) {}
    for (paramString2 = "oauth2";; paramString2 = "gx")
    {
      paramString2 = String.valueOf(paramString2);
      return String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length() + paramString1 + "_" + paramString2;
    }
  }
  
  public static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "oauth2";
    }
    return "gx";
  }
  
  public static boolean a(drj paramdrj)
  {
    boolean bool = paramdrj.a("bx_tmpod", false);
    dri.b(drj.a, "reading gmail-oauth2-disabled CF, val=%s acct=%s", new Object[] { Boolean.valueOf(bool), j.name });
    return !bool;
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      return "oauth2:https://www.googleapis.com/auth/gmail.readonly";
    }
    return ghz.a(paramContext.getContentResolver(), "gmail_readonly_dev_code", "oauth2:https://www.googleapis.com/auth/gmail.readonly");
  }
}

/* Location:
 * Qualified Name:     dms
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */