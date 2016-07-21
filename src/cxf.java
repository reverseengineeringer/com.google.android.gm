import android.content.Context;
import android.content.SharedPreferences;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.ui.MailActivity;

public final class cxf
{
  public static String a()
  {
    String str = null;
    cgr localcgr = cgr.b;
    if (localcgr != null) {
      str = localcgr.d().getString("lastViewedVisualElementLoggingAccount", null);
    }
    return str;
  }
  
  public static boolean a(Context paramContext, Account paramAccount)
  {
    return (paramContext != null) && (!cxa.a(paramContext.getResources())) && (paramAccount != null) && (paramAccount.a(17179869184L));
  }
  
  public static boolean a(MailActivity paramMailActivity)
  {
    Account localAccount = l.a();
    Folder localFolder = l.p();
    return (a(paramMailActivity, localAccount)) && (localFolder != null) && (localFolder.a(262144));
  }
}

/* Location:
 * Qualified Name:     cxf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */