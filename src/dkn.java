import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.android.mail.providers.Account;
import com.google.android.gm.GmailIntentService;
import com.google.android.gm.OpenBrowserTrampolineActivity;
import com.google.android.gm.gmailify.GmailifyHandleErrorActivity;
import com.google.android.gm.gmailify.GmailifyOptInActivity;
import com.google.android.gm.utils.WebViewUrl;
import java.util.Date;

public final class dkn
{
  private static final String a = cvl.a;
  private static final SparseArray<Boolean> b = new SparseArray();
  
  private static int a(String paramString)
  {
    return String.valueOf(paramString).concat("g6y").hashCode();
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, WebViewUrl paramWebViewUrl, String paramString3)
  {
    if (b)
    {
      paramContext = new Intent(paramContext, GmailifyHandleErrorActivity.class);
      paramContext.putExtra("email", paramString1);
      paramContext.putExtra("gmail", paramString2);
      paramContext.putExtra("errorUrl", paramWebViewUrl);
      paramContext.putExtra("analytics", paramString3);
      return paramContext;
    }
    paramContext = new Intent(paramContext, OpenBrowserTrampolineActivity.class);
    paramContext.setData(Uri.parse(a));
    return paramContext;
  }
  
  public static void a(Activity paramActivity, Account paramAccount)
  {
    Intent localIntent = new Intent(paramActivity, GmailifyOptInActivity.class);
    localIntent.putExtra("account", paramAccount);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    int i = a(paramString);
    if (b.get(i) == Boolean.TRUE)
    {
      b.remove(i);
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(i);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    int i = a(paramString1);
    if (b.get(i) != Boolean.TRUE)
    {
      b.put(i, Boolean.TRUE);
      dnm.a(paramContext, paramString2);
      dfh.a(paramContext, i, paramString1, paramString3, a(paramContext, paramString1, paramString2, new WebViewUrl(paramString4, paramBoolean, paramString5), "notif"));
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = dlo.a(paramContext);
    long l1 = chq.a();
    long l2 = d.getLong("availability-check-timestamp", 0L);
    long l3 = ghz.a(paramContext.getContentResolver(), "gmail_g6y_availability_status_throttle_duration", 900000L);
    if ((paramBoolean) || (l2 == 0L) || (l1 > l3 + l2))
    {
      cvm.b(a, "g6y: check availability of all accounts, force=%1$b lastTime=%2$tF %2$tT", new Object[] { Boolean.valueOf(paramBoolean), new Date(l2) });
      e.putLong("availability-check-timestamp", l1).apply();
      localObject = new Intent(paramContext, GmailIntentService.class);
      ((Intent)localObject).setAction("com.google.android.gm.gmailify.intent.UPDATE_AVAILABILITY");
      paramContext.startService((Intent)localObject);
      return;
    }
    cvm.b(a, "g6y: availability already checked at %1$tF %1$tT", new Object[] { new Date(l2) });
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
}

/* Location:
 * Qualified Name:     dkn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */