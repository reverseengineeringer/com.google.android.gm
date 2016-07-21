import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;

public final class dyd
  extends cst
{
  static final String a = cvl.a;
  public final Context b;
  public ServiceConnection c;
  public dde d;
  private int e;
  
  public dyd(Context paramContext)
  {
    b = paramContext.getApplicationContext();
    e = 0;
  }
  
  private static void a(String paramString)
  {
    buo.a().a("cal-promo", "skip", paramString, 0L);
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.google.android.calendar", 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private final boolean b()
  {
    if (!a(b))
    {
      dri.c(a, "calPromotion: Calendar is not installed yet.", new Object[0]);
      return true;
    }
    for (;;)
    {
      try
      {
        if (d != null)
        {
          if (!d.a()) {
            continue;
          }
          e = 1;
          dmv.a().a(b, null, "is-calendar-oobe", Boolean.valueOf(true));
        }
        switch (e)
        {
        default: 
          int i = b.getResources().getConfiguration().screenLayout & 0xF;
          if (i != 1) {
            break label256;
          }
          DisplayMetrics localDisplayMetrics = b.getResources().getDisplayMetrics();
          dri.c(a, "calPromotion: resolution too low: width=%d, density=%d, screen=%d", new Object[] { Integer.valueOf(widthPixels), Integer.valueOf(densityDpi), Integer.valueOf(i) });
          a("low_resolution");
          return false;
          e = 2;
          continue;
        }
      }
      catch (RemoteException localRemoteException)
      {
        dri.d(a, localRemoteException, "Can't query Calendar OOBE state", new Object[0]);
        continue;
        dri.b(a, "calPromotion: OOBE service is not bound yet.", new Object[0]);
        a("oobe_not_bound");
        return false;
      }
      dri.b(a, "calPromotion: at least one account is already a Calendar user", new Object[0]);
      a("oobe_complete");
      return false;
      if (c == null) {
        a();
      }
    }
    label256:
    dri.c(a, "calPromotion: lets show calendar promotion", new Object[0]);
    return true;
  }
  
  public final bxs a(bxp parambxp, Conversation paramConversation)
  {
    if (x == 0)
    {
      a("no_smart_mail");
      return null;
    }
    buo.a().a("cal-promo", "smart_mail", String.valueOf(x), 0L);
    Account localAccount = b.a();
    if (localAccount == null)
    {
      dri.b(a, "calPromo: Not showing promo if unable to determine account type", new Object[0]);
      a("no_account");
      return null;
    }
    if (!ddh.b(c))
    {
      dri.b(a, "calPromo: Not showing promo for non-consumer account", new Object[0]);
      a("not_consumer_account");
      return null;
    }
    if (!dyb.a(b, c))
    {
      dri.b(a, "calPromo: Not showing promo as gservice is off", new Object[0]);
      if (dyb.c(b, c)) {
        a("too_many_promotion");
      }
      for (;;)
      {
        return null;
        a("gservice_off");
      }
    }
    dri.c(a, "calPromo: type=%d", new Object[] { Integer.valueOf(x) });
    if (b())
    {
      buo.a().a("cal-promo", "create", String.valueOf(x), 0L);
      return new dya(parambxp, paramConversation);
    }
    return null;
  }
  
  public final void a()
  {
    if (dmv.a().a(b, null, "is-calendar-oobe", false)) {
      dri.b(a, "calPromotion: disabled or oobe complete", new Object[0]);
    }
    for (;;)
    {
      return;
      try
      {
        c = new dye(this);
        Intent localIntent = new Intent();
        localIntent.setClassName("com.google.android.calendar", "com.google.android.calendar.timely.CalendarOobeService");
        if (!b.bindService(localIntent, c, 1))
        {
          dri.d(a, "failed to bind to Calendar OOBE service", new Object[0]);
          c = null;
          d = null;
          return;
        }
      }
      catch (SecurityException localSecurityException)
      {
        dri.d(a, localSecurityException, "Do not have permission to bind to Calendar OOBE", new Object[0]);
      }
    }
  }
}

/* Location:
 * Qualified Name:     dyd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */