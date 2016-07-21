import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.feedback.FeedbackOptions;
import com.google.android.gms.feedback.FileTeleporter;
import com.google.android.gms.feedback.ThemeSettings;
import com.google.android.gms.googlehelp.GoogleHelp;
import com.google.android.libraries.social.licenses.LicenseMenuActivity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class dyv
  implements cuo
{
  public static final String a = cvl.a;
  
  private static android.accounts.Account a(com.android.mail.providers.Account paramAccount, com.android.mail.providers.Account[] paramArrayOfAccount)
  {
    Object localObject = null;
    if ((paramAccount != null) && ("com.google".equals(e))) {
      paramAccount = paramAccount.c();
    }
    do
    {
      return paramAccount;
      paramAccount = (com.android.mail.providers.Account)localObject;
    } while (paramArrayOfAccount == null);
    int j = paramArrayOfAccount.length;
    int i = 0;
    for (;;)
    {
      paramAccount = (com.android.mail.providers.Account)localObject;
      if (i >= j) {
        break;
      }
      paramAccount = paramArrayOfAccount[i];
      if ((paramAccount != null) && ("com.google".equals(e))) {
        return paramAccount.c();
      }
      i += 1;
    }
  }
  
  public static Uri a(Context paramContext)
  {
    return Uri.parse(ghz.a(paramContext.getContentResolver(), "gmail_context_sensitive_help_url", "https://support.google.com/mail")).buildUpon().appendPath("topic").appendPath("6029993").appendQueryParameter("hl", a()).build();
  }
  
  public static FeedbackOptions a(Context paramContext, com.android.mail.providers.Account paramAccount, com.android.mail.providers.Account[] paramArrayOfAccount, Bitmap paramBitmap)
  {
    int j = 0;
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    Object localObject1 = ctl.b(paramContext);
    Object localObject2 = new HashSet();
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      ((Set)localObject2).add(dyp.a(paramContext, localObject1[i]));
      i += 1;
    }
    if (((Set)localObject2).size() > 0)
    {
      localPrintWriter.print("all-account-domains: ");
      localPrintWriter.println(TextUtils.join("/", (Iterable)localObject2));
    }
    if (paramAccount != null)
    {
      localPrintWriter.print("current-account-domain: ");
      localPrintWriter.println(dyp.a(paramContext, paramAccount));
    }
    if ((paramArrayOfAccount != null) && (paramArrayOfAccount.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localPrintWriter.print("included-all-accounts: ");
      localPrintWriter.println(bool);
      localObject1 = paramArrayOfAccount;
      if (!bool)
      {
        localObject1 = paramArrayOfAccount;
        if (paramAccount != null)
        {
          localObject1 = new com.android.mail.providers.Account[1];
          localObject1[0] = paramAccount;
        }
      }
      if (localObject1 == null) {
        break;
      }
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        paramArrayOfAccount = localObject1[i];
        localObject2 = c;
        dnm localdnm = dnm.a(paramContext, (String)localObject2);
        localPrintWriter.println();
        ctl.a("", localPrintWriter, (String)localObject2, dfh.a(paramContext, paramArrayOfAccount), localdnm);
        i += 1;
      }
    }
    localPrintWriter.flush();
    paramArrayOfAccount = localStringWriter.toString().getBytes();
    localObject1 = new fjl();
    d.add(new FileTeleporter(paramArrayOfAccount, "text/plain", "AccountStates.txt"));
    paramArrayOfAccount = ((fjl)localObject1).a("build-flavor", "release").a("current-account-domain", dyp.a(paramContext, paramAccount));
    if ((paramAccount != null) && ("com.google".equals(e)))
    {
      paramContext = cui.b(dnm.a(paramContext, c).g());
      if (!TextUtils.isEmpty(paramContext)) {
        paramArrayOfAccount.a("Gmailify domain", paramContext);
      }
    }
    paramContext = cvs.a;
    if (paramContext != null)
    {
      paramContext = b;
      if (paramContext != null)
      {
        paramArrayOfAccount.a("network-quality-latency", String.valueOf(a));
        paramArrayOfAccount.a("network-quality-down", String.valueOf(b));
        paramArrayOfAccount.a("network-quality-up", String.valueOf(c));
      }
    }
    if (paramBitmap != null) {
      a = paramBitmap;
    }
    return paramArrayOfAccount.a();
  }
  
  public static String a()
  {
    Locale localLocale2 = Locale.getDefault();
    Locale localLocale1 = localLocale2;
    if (localLocale2 == Locale.US) {
      localLocale1 = Locale.ENGLISH;
    }
    return cxa.a(localLocale1);
  }
  
  public final void a(Activity paramActivity, int paramInt)
  {
    a(paramActivity, null, paramActivity.getResources().getString(paramInt), null);
  }
  
  public final void a(Activity paramActivity, com.android.mail.providers.Account paramAccount, String paramString, com.android.mail.providers.Account[] paramArrayOfAccount)
  {
    Object localObject = a(paramActivity);
    Intent localIntent1 = dfh.b(paramActivity, Uri.parse(ghz.a(paramActivity.getContentResolver(), "gmail_privacy_policy_url", "https://www.google.com/policies/privacy/")));
    String str1 = paramActivity.getString(dge.fh);
    Intent localIntent2 = new Intent(paramActivity, LicenseMenuActivity.class);
    String str2 = paramActivity.getString(dge.eC);
    Intent localIntent3 = dfh.b(paramActivity, Uri.parse(ghz.a(paramActivity.getContentResolver(), "gmail_terms_of_service_url", "https://www.google.com/policies/terms/")));
    String str3 = paramActivity.getString(dge.fS);
    FeedbackOptions localFeedbackOptions = a(paramActivity, paramAccount, paramArrayOfAccount, GoogleHelp.a(paramActivity));
    paramString = new GoogleHelp(paramString);
    w = foq.a(localFeedbackOptions, paramActivity.getCacheDir());
    w.Y = "GoogleHelp";
    q = ((Uri)localObject);
    localObject = new ThemeSettings();
    b = 1;
    c = paramActivity.getResources().getColor(dfv.z);
    t = ((ThemeSettings)localObject);
    paramString = paramString.a(dfy.bA, str1, localIntent1).a(dfy.bw, str2, localIntent2).a(dfy.cq, str3, localIntent3);
    c = a(paramAccount, paramArrayOfAccount);
    paramAccount = new Intent("com.google.android.gms.googlehelp.HELP").setPackage("com.google.android.gms").putExtra("EXTRA_GOOGLE_HELP", paramString);
    dri.c(a, "Launching GoogleHelp", new Object[0]);
    paramActivity = new fkh(paramActivity);
    if ((!paramAccount.getAction().equals("com.google.android.gms.googlehelp.HELP")) || (!paramAccount.hasExtra("EXTRA_GOOGLE_HELP"))) {
      throw new IllegalArgumentException("The intent you are trying to launch is not GoogleHelp intent! This class only supports GoogleHelp intents.");
    }
    int j = eik.a(a);
    if (j == 0)
    {
      fle.a(b, new fki(paramActivity, paramAccount));
      return;
    }
    paramAccount = (GoogleHelp)paramAccount.getParcelableExtra("EXTRA_GOOGLE_HELP");
    paramAccount = new Intent("android.intent.action.VIEW").setData(q);
    if (j != 7)
    {
      if (a.getPackageManager().queryIntentActivities(paramAccount, 0).size() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        a.startActivity(paramAccount);
        return;
      }
    }
    eik.a(j, a);
  }
}

/* Location:
 * Qualified Name:     dyv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */