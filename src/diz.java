import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import java.util.Set;

public final class diz
  extends bvu
  implements ejl<Status>
{
  public static final String a = cvl.a;
  final boolean b;
  Activity c;
  public dyz d;
  bvw e;
  fan f;
  private djh g;
  private String h;
  
  public diz()
  {
    this(false);
  }
  
  public diz(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  private final void c(String paramString)
  {
    Object localObject2 = c;
    Object localObject1 = d;
    localObject2 = new eja(((Context)localObject2).getApplicationContext()).a(fae.f);
    Scope localScope = fae.d;
    b.add(localScope);
    localObject1 = ((eja)localObject2).a((ejc)localObject1).a((eje)localObject1);
    if (paramString == null) {}
    for (paramString = null;; paramString = new android.accounts.Account(paramString, "com.google"))
    {
      a = paramString;
      paramString = ((eja)localObject1).a();
      d.e();
      d.f = paramString;
      d.d();
      return;
    }
  }
  
  public final bvx a(boolean paramBoolean, bvw parambvw)
  {
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
      localIntent.setPackage("com.google.android.gms");
      localIntent.putExtra("allowableAccounts", null);
      localIntent.putExtra("allowableAccountTypes", new String[] { "com.google" });
      localIntent.putExtra("addAccountOptions", null);
      localIntent.putExtra("selectedAccount", null);
      localIntent.putExtra("alwaysPromptForAccount", false);
      localIntent.putExtra("descriptionTextOverride", null);
      localIntent.putExtra("authTokenType", null);
      localIntent.putExtra("addAccountRequiredFeatures", null);
      localIntent.putExtra("setGmsCoreAccount", false);
      localIntent.putExtra("overrideTheme", 1);
      localIntent.putExtra("overrideCustomTheme", 0);
      c.startActivityForResult(localIntent, 258);
    }
    e = parambvw;
    g = new djh(c.getFragmentManager(), d, parambvw, this);
    return g;
  }
  
  public final void a()
  {
    d.d();
  }
  
  public final void a(Activity paramActivity, Bundle paramBundle)
  {
    c = paramActivity;
    d = new dja(this, c, paramBundle, "state-resolving-drive-error", "Drive", paramBundle);
    if (paramBundle != null) {
      h = paramBundle.getString("drive_account_key");
    }
    if (h != null) {
      c(h);
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    d.b(paramBundle);
    paramBundle.putString("drive_account_key", h);
    if (f != null) {
      paramBundle.putParcelable("drive_file_key", f.a());
    }
  }
  
  public final void a(fan paramfan)
  {
    f = paramfan;
    paramfan = d.f;
    Object localObject = fae.h.a();
    enz.b(true, "mimeTypes may not be null");
    a = new String[] { "application/vnd.google-apps.folder" };
    paramfan = ((fbb)localObject).a(paramfan);
    try
    {
      c.startIntentSenderForResult(paramfan, 259, null, 0, 0, 0);
      i = 1;
    }
    catch (IntentSender.SendIntentException paramfan)
    {
      for (;;)
      {
        cvm.e(a, paramfan, "Problem moving attachment in Drive", new Object[0]);
        paramfan = c.getString(dge.bX);
        Toast.makeText(c, paramfan, 0).show();
        int i = 0;
        continue;
        paramfan = "intent_not_started";
      }
    }
    localObject = buo.a();
    if (i != 0)
    {
      paramfan = "intent_started";
      ((but)localObject).a("organize_attachment", paramfan, null, 0L);
      return;
    }
  }
  
  public final void a(String paramString, bvw parambvw)
  {
    e = parambvw;
    c(paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    djd localdjd = new djd();
    localdjd.show(c.getFragmentManager(), "drive-id-dialog");
    h = paramString1;
    c(h);
    fae.h.a(d.f, paramString2).a(new djc(this, localdjd));
    buo.a().a("organize_attachment", "fetch_drive_id", null, 0L);
  }
  
  public final boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (d == null) {
      return false;
    }
    if (d.a(paramInt1, paramInt2)) {
      return true;
    }
    switch (paramInt1)
    {
    default: 
      return false;
    case 258: 
      if ((paramInt2 != -1) && (g != null))
      {
        g.a(false, false, null);
        e = null;
      }
      for (;;)
      {
        g = null;
        return true;
        if (e != null)
        {
          h = paramIntent.getStringExtra("authAccount");
          c(h);
        }
      }
    }
    if ((paramInt2 != -1) || (f == null)) {}
    for (;;)
    {
      return true;
      paramIntent = (DriveId)paramIntent.getParcelableExtra("response_drive_id");
      f.a(d.f, hfd.b(paramIntent)).a(this);
    }
  }
  
  public final boolean a(AccountManager paramAccountManager, com.android.mail.providers.Account paramAccount)
  {
    if ((paramAccount != null) && ("com.sidewinder".equals(e)))
    {
      i = 1;
      if (i != 0) {
        break label58;
      }
      if (!dyp.a(paramAccount)) {
        if (paramAccountManager.getAccountsByType("com.google").length <= 0) {
          break label53;
        }
      }
    }
    label53:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label58;
      }
      return true;
      i = 0;
      break;
    }
    label58:
    return false;
  }
  
  public final boolean a(String paramString)
  {
    return (!"application/ics".equals(paramString)) && (!"text/calendar".equals(paramString)) && (!(c instanceof byg));
  }
  
  public final void b()
  {
    d.e();
  }
  
  public final boolean b(String paramString)
  {
    return !"com.google".equals(paramString);
  }
  
  public final boolean c()
  {
    if (d == null) {}
    eiz localeiz;
    do
    {
      return false;
      localeiz = d.f;
    } while ((localeiz == null) || (!localeiz.e()));
    return true;
  }
}

/* Location:
 * Qualified Name:     diz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */