import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.PowerManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public abstract class cgu
{
  public static final String h = cvl.a;
  public static final SimpleDateFormat i = new SimpleDateFormat("MM/dd HH:mm:ss.SSS", Locale.US);
  private List<Integer> a = new ArrayList();
  public String j;
  public Exception k;
  public final Context l;
  public final String m;
  public final long n;
  public boolean o;
  public long p;
  public long q;
  public long r;
  public long s;
  public long t;
  public boolean u;
  public int v;
  public int w;
  public int x;
  public cvt y;
  
  public cgu(Context paramContext, String paramString)
  {
    l = paramContext;
    m = paramString;
    n = System.currentTimeMillis();
    x = -1;
    v = cxa.b(l);
    w = cxa.c(l);
    paramContext = (PowerManager)l.getSystemService("power");
    int i1;
    if (Build.VERSION.SDK_INT >= 20)
    {
      i1 = 1;
      if (i1 == 0) {
        break label145;
      }
    }
    label145:
    for (boolean bool = paramContext.isInteractive();; bool = paramContext.isScreenOn())
    {
      u = bool;
      paramContext = cvs.a;
      if (paramContext != null) {
        y = paramContext.a();
      }
      try
      {
        x = l.getPackageManager().getPackageInfo(l.getPackageName(), 0).versionCode;
        return;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        cvm.e(h, "Failed to obtain app version code", new Object[0]);
      }
      i1 = 0;
      break;
    }
  }
  
  public final void a(int paramInt)
  {
    a.add(Integer.valueOf(paramInt));
  }
  
  public abstract boolean a();
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start: ").append(i.format(new Date(n))).append(", syncDuration: ").append(p);
    if (j != null) {
      localStringBuilder.append(", syncResult: ").append(j);
    }
    if (s != 0L) {
      localStringBuilder.append(", previousSnapshotStartTime: ").append(i.format(new Date(s)));
    }
    if (k != null)
    {
      localStringBuilder.append(", exception: ").append(k);
      localStringBuilder.append(", stacktrace: ");
      ctz.a(localStringBuilder, k);
    }
    if (t != 0L) {
      localStringBuilder.append(", dnsLookupDuration: ").append(t);
    }
    localStringBuilder.append(", bytesSent: ").append(q);
    localStringBuilder.append(", bytesReceived: ").append(r);
    localStringBuilder.append(", syncErrors: ").append(a);
    localStringBuilder.append(", syncErrorCount: ").append(a.size());
    return localStringBuilder.toString();
  }
  
  public abstract cfg c();
  
  public final void d()
  {
    int i1 = 0;
    p = (System.currentTimeMillis() - n);
    if ((o) || (!a())) {
      return;
    }
    String str1 = b();
    cvm.b("MailSyncSnapshot", "%s", new Object[] { str1 });
    if (k == null)
    {
      c().c(str1);
      o = true;
      return;
    }
    cfg localcfg = c();
    int i2 = d.getInt("account-sync-error-index", 0);
    if (i2 >= 3) {}
    for (;;)
    {
      String str2 = String.valueOf("account-sync-error");
      str2 = String.valueOf(str2).length() + 11 + str2 + i1;
      e.putString(str2, str1).putInt("account-sync-error-index", i1 + 1).apply();
      break;
      i1 = i2;
    }
  }
  
  public final int[] e()
  {
    int[] arrayOfInt = new int[a.size()];
    int i1 = 0;
    while (i1 < a.size())
    {
      arrayOfInt[i1] = ((Integer)a.get(i1)).intValue();
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  public final int f()
  {
    return a.size();
  }
}

/* Location:
 * Qualified Name:     cgu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */