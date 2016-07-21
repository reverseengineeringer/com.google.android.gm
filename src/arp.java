import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Policy;

final class arp
  extends AsyncTask<Void, Integer, bdi>
{
  final Context a;
  final aro b;
  final int c;
  final SetupDataFragment d;
  final Bundle e;
  final Account f;
  final String g;
  final String h;
  final String i;
  
  public arp(Context paramContext, aro paramaro, int paramInt, SetupDataFragment paramSetupDataFragment, Bundle paramBundle)
  {
    a = paramContext;
    b = paramaro;
    c = paramInt;
    d = paramSetupDataFragment;
    e = paramBundle;
    f = b;
    if (f.t != null) {
      g = f.t.c;
    }
    for (h = f.t.g;; h = null)
    {
      i = f.d;
      return;
      g = null;
    }
  }
  
  private final bdi a()
  {
    for (;;)
    {
      try
      {
        if ((c & 0x8) == 0) {
          break;
        }
        if (isCancelled()) {
          return null;
        }
        cvm.b(bbw.a, "Begin auto-discover for %s", new Object[] { i });
        publishProgress(new Integer[] { Integer.valueOf(2) });
        Object localObject1 = awr.a(f, a);
        if ((((awr)localObject1).d() >= 7) && (e != null))
        {
          localObject1 = ((awr)localObject1).a(i, h, e);
          cvm.b(aro.a, "AccountCheckTask.doInBackground: Autodiscover result = %s", new Object[] { localObject1 });
          localObject1 = new arq((Bundle)localObject1);
          return (bdi)localObject1;
        }
      }
      catch (bdi localbdi)
      {
        cvm.e(cvm.a, localbdi, "AccountCheckTask.doInBackground: %s", new Object[] { bbo.a(a, localbdi) });
        return localbdi;
      }
      localObject2 = localbdi.a(i, h);
    }
    Integer localInteger;
    if (((c & 0x2) != 0) || (b()))
    {
      if (isCancelled()) {
        return null;
      }
      cvm.b(bbw.a, "Begin check of incoming email settings", new Object[0]);
      publishProgress(new Integer[] { Integer.valueOf(3) });
      localObject2 = awr.a(f, a).c();
      if (localObject2 == null)
      {
        cvm.e(cvm.a, "AccountCheckTask.doInBackground failed with unspecified exception", new Object[0]);
        return new bdi(28);
      }
      f.l = ((Bundle)localObject2).getString("validate_protocol_version");
      int k = ((Bundle)localObject2).getInt("validate_result_code");
      if (((Bundle)localObject2).containsKey("validate_result_status"))
      {
        localInteger = Integer.valueOf(((Bundle)localObject2).getInt("validate_result_status"));
        String str = ((Bundle)localObject2).getString("validate_redirect_address", null);
        if (str != null) {
          f.t.c = str;
        }
        int j = k;
        if (k == 7)
        {
          j = k;
          if (f.h()) {
            j = -1;
          }
        }
        if (j == 7)
        {
          d.a((Policy)((Bundle)localObject2).getParcelable("validate_policy_set"));
          localObject2 = new bdi(j, g);
        }
        label389:
        while (localObject2 != null)
        {
          f = localInteger;
          cvm.e(cvm.a, "AccountCheckTask.doInBackground: %s\nError message = \"%s\"", new Object[] { bbo.a(a, (bdi)localObject2), ((bdi)localObject2).getMessage() });
          return (bdi)localObject2;
          if (j == 8)
          {
            localObject2 = getParcelable"validate_policy_set"w.split("\001");
            localObject2 = new bdi(j, g, localObject2);
          }
          else if (j == 21)
          {
            localObject2 = new bdi(21);
          }
          else
          {
            if (j == -1) {
              break label685;
            }
            localObject2 = new bdi(j, ((Bundle)localObject2).getString("validate_error_message"));
          }
        }
      }
    }
    else
    {
      if (f.t == null) {
        break label696;
      }
      localObject2 = f.t.b;
    }
    label685:
    label696:
    for (Object localObject2 = bam.e(a, (String)localObject2);; localObject2 = null)
    {
      if (((localObject2 == null) || (m)) && (((c & 0x4) != 0) || (b())))
      {
        if (isCancelled()) {
          return null;
        }
        cvm.b(bbw.a, "Begin check of outgoing email settings", new Object[0]);
        publishProgress(new Integer[] { Integer.valueOf(4) });
        localObject2 = new aye(a, f);
        a.f();
        ((aye)localObject2).a();
        a.f();
      }
      localObject2 = bbz.a(a);
      if (localObject2 != null)
      {
        ((bbx)localObject2).b(f.D, false);
        ((bbx)localObject2).b(f.D, true);
      }
      return null;
      localObject2 = null;
      break label389;
      localInteger = null;
      break;
    }
  }
  
  private final boolean b()
  {
    return (c & 0x1) != 0;
  }
}

/* Location:
 * Qualified Name:     arp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */