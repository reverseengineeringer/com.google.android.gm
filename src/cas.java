import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.accessibility.AccessibilityManager;
import com.android.emailcommon.mail.Address;
import com.android.mail.browse.calendar.ExchangeRsvpController.2;
import com.android.mail.providers.Account;
import com.android.mail.providers.Event;
import com.android.mail.providers.Message;
import com.android.mail.ui.toastbar.ActionableToastBar;
import com.android.mail.ui.toastbar.ToastBarOperation;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.accounts.api.AccountData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public final class cas
  implements aob, aor, aqa, ctd
{
  static final String a = cvl.a;
  public Message b;
  public Message c;
  public int d;
  public long e;
  public long f;
  public Calendar g;
  public Handler h = new Handler();
  public Fragment i;
  public cbf j;
  public Account k;
  public boolean l = false;
  public boolean m = false;
  public final Runnable n = new cat(this);
  private cav o;
  private ToastBarOperation p;
  private Map<String, Address> q;
  private ActionableToastBar r;
  
  public cas(Fragment paramFragment, cbf paramcbf, Account paramAccount, Map<String, Address> paramMap)
  {
    i = paramFragment;
    j = paramcbf;
    k = paramAccount;
    q = paramMap;
  }
  
  private static int a(Context paramContext, String paramString)
  {
    int i1 = -1;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        i1 = versionCode;
      }
      return i1;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return -1;
  }
  
  public final void a()
  {
    f().a(b.f, j.c(b));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    g.set(11, paramInt1);
    g.set(12, paramInt2);
    g.set(13, 0);
    g.set(14, 0);
    long l1 = b.T.c;
    long l2 = b.T.b;
    e = g.getTimeInMillis();
    f = (l1 - l2 + g.getTimeInMillis());
    e();
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (g == null) {
      g = Calendar.getInstance();
    }
    g.set(paramInt1, paramInt2, paramInt3);
    apv localapv = new apv(this);
    b = this;
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(b.T.b);
    paramInt1 = ((Calendar)localObject1).get(11);
    paramInt2 = ((Calendar)localObject1).get(12);
    boolean bool = DateFormat.is24HourFormat(i.getActivity());
    if (c != null) {
      c.dismiss();
    }
    Object localObject2;
    if (aom.a())
    {
      localObject1 = new apw();
      localObject2 = new Bundle(3);
      ((Bundle)localObject2).putInt("hour", paramInt1);
      ((Bundle)localObject2).putInt("minute", paramInt2);
      ((Bundle)localObject2).putBoolean("24hour", bool);
      ((apw)localObject1).setArguments((Bundle)localObject2);
      b = new apy(a);
      a = b;
    }
    for (c = ((DialogFragment)localObject1);; c = ((DialogFragment)localObject2))
    {
      c.show(i.getFragmentManager(), "ProposeTimeTimePickerDialog");
      return;
      localObject1 = new apz(a);
      localObject2 = new aqb();
      b = ((aqi)localObject1);
      g = paramInt1;
      h = paramInt2;
      i = bool;
      l = false;
      j = false;
      a = b;
    }
  }
  
  public final void a(Context paramContext)
  {
    p = null;
    c();
  }
  
  public final void a(Uri paramUri, int paramInt)
  {
    f().a(paramUri, paramInt);
  }
  
  public final void a(boolean paramBoolean)
  {
    boolean bool = false;
    if (r == null) {
      r = ((ActionableToastBar)i.getActivity().findViewById(buc.fr));
    }
    String str;
    if ((p == null) || (paramBoolean)) {
      switch (d)
      {
      default: 
        cvm.f(a, "sendRsvpResponseCommand, unknown RSVP response type", new Object[0]);
        str = "";
      }
    }
    for (;;)
    {
      p = new ExchangeRsvpController.2(this);
      r.a = true;
      int i1 = buj.dO;
      paramBoolean = bool;
      if (!((AccessibilityManager)i.getActivity().getSystemService("accessibility")).isTouchExplorationEnabled()) {
        paramBoolean = true;
      }
      r.a(this, str, i1, true, paramBoolean, p);
      return;
      str = i.getString(buj.dP);
      continue;
      str = i.getString(buj.dR);
      continue;
      str = i.getString(buj.dQ);
    }
  }
  
  public final void b()
  {
    if (p != null)
    {
      a(b.f, j.c(b));
      p = null;
    }
  }
  
  public final void c()
  {
    int i3 = 1;
    int i2 = 0;
    Object localObject1 = i.getActivity();
    if (a((Context)localObject1, "com.google.android.calendar") >= 2015101466)
    {
      i1 = cun.a((Context)localObject1);
      if ((i1 == -1) || (i1 >= 504198))
      {
        i1 = 1;
        if ((i1 == 0) || (eik.a((Context)localObject1) != 0) || (!k.a(8589934592L))) {
          break label454;
        }
      }
    }
    label442:
    label454:
    for (int i1 = i3;; i1 = 0)
    {
      if (i1 != 0) {}
      for (;;)
      {
        try
        {
          Fragment localFragment = i;
          Object localObject2 = i.getActivity();
          Object localObject3 = b;
          Object localObject4 = k.c;
          Object localObject5 = q;
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(aT.f).a);
          if (TextUtils.isEmpty(T.g))
          {
            localObject1 = ((Message)localObject3).h();
            i1 = i2;
            if (i1 < localObject1.length)
            {
              Address localAddress = cxa.a((Map)localObject5, localObject1[i1]);
              if (localAddress == null) {
                break label442;
              }
              localArrayList.add(a);
              break label442;
            }
          }
          else
          {
            localObject1 = Message.f(T.g);
            i1 = i2;
            continue;
          }
          localObject3 = new Intent("com.google.android.calendar.FIND_TIME").setPackage("com.google.android.calendar").setFlags(524288).putExtra("type", 2).putExtra("start_millis", T.b).putExtra("end_millis", T.c).putStringArrayListExtra("attendees", localArrayList);
          localObject4 = AccountData.a((String)localObject4);
          localObject5 = flw.b;
          enz.a(localObject2, "Context must not be null.");
          enz.a(localObject3, "Intent must not be null.");
          enz.a(localObject4, "Account data must not be null.");
          localObject1 = ((Intent)localObject3).getComponent();
          if (localObject1 != null)
          {
            localObject1 = ((ComponentName)localObject1).getPackageName();
            if ((localObject1 != null) && (a.a(((Context)localObject2).getPackageManager(), (String)localObject1)))
            {
              localObject1 = Parcel.obtain();
              ((SafeParcelable)localObject4).writeToParcel((Parcel)localObject1, 0);
              localObject2 = ((Parcel)localObject1).marshall();
              ((Parcel)localObject1).recycle();
              ((Intent)localObject3).putExtra("com.google.android.gms.accounts.ACCOUNT_DATA", (byte[])localObject2);
            }
            localFragment.startActivityForResult((Intent)localObject3, 5);
            return;
          }
          localObject1 = ((Intent)localObject3).getPackage();
          continue;
          d();
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          d();
          return;
        }
        return;
        i1 += 1;
      }
      i1 = 0;
      break;
    }
  }
  
  public final void d()
  {
    aon localaon = new aon(this);
    d = true;
    a = this;
    Calendar localCalendar = Calendar.getInstance();
    b = localCalendar;
    if (b.T.b < localCalendar.getTimeInMillis()) {
      localaon.a(localCalendar.get(1), localCalendar.get(2), localCalendar.get(5));
    }
    for (;;)
    {
      c.show(i.getFragmentManager(), "ProposeTimeDatePickerDialog");
      return;
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(b.T.b);
      localaon.a(localCalendar.get(1), localCalendar.get(2), localCalendar.get(5));
    }
  }
  
  public final void e()
  {
    Object localObject = new ContentValues(3);
    ((ContentValues)localObject).put("rsvp", Integer.valueOf(d));
    ((ContentValues)localObject).put("start_millis", Long.valueOf(e));
    ((ContentValues)localObject).put("end_millis", Long.valueOf(f));
    localObject = cbk.a(i.getActivity(), k, b, (ContentValues)localObject);
    i.startActivityForResult((Intent)localObject, 6);
  }
  
  public final cav f()
  {
    if (o == null) {
      o = new cav(i.getActivity());
    }
    return o;
  }
}

/* Location:
 * Qualified Name:     cas
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */