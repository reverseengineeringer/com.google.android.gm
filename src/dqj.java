import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.http.AndroidHttpClient;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.util.List;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class dqj
{
  private static final String a = cvl.a;
  private Context b;
  private String c;
  
  public dqj(Context paramContext, String paramString)
  {
    b = paramContext;
    c = paramString;
  }
  
  private final String a(Configuration paramConfiguration)
  {
    int i = 0;
    try
    {
      int j = b.getPackageManager().getPackageInfo(b.getApplicationInfo().packageName, 0).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        dri.e(a, "Error finding package %s", new Object[] { b.getApplicationInfo().packageName });
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        dri.e(a, localUnsupportedOperationException, "Error getting the PackageManager", new Object[0]);
        continue;
        localUnsupportedOperationException.append("?swdp");
        continue;
        localUnsupportedOperationException.append(" ?density");
      }
    }
    localStringBuilder = new StringBuilder(c);
    localStringBuilder.append('/').append(i);
    localStringBuilder.append(" (");
    if (smallestScreenWidthDp != 0)
    {
      localStringBuilder.append("sw").append(smallestScreenWidthDp).append("dp");
      localStringBuilder.append(';');
      if ((!cxd.b()) || (densityDpi == 0)) {
        break label206;
      }
      localStringBuilder.append(" ").append(densityDpi).append("dpi");
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  private final List<ddt> b()
  {
    try
    {
      if (ghz.a(b.getContentResolver(), "gmail_bypass_android_proxy", cuu.a.booleanValue()))
      {
        hef localhef = hef.a(ddt.a("url:android-gmail-bypass-proxy", "https://mail.google.com/ rewrite https://mail.google.com/"), ddt.a("url:android-gmail-dasher-bypass-proxy", "https://mail.google.com/a/ rewrite https://mail.google.com/a/"));
        return localhef;
      }
    }
    catch (ddu localddu)
    {
      dri.e(a, localddu, "Failed to create proxy bypass rules", new Object[0]);
    }
    return hii.a;
  }
  
  public final dqk a()
  {
    Object localObject3 = null;
    Object localObject1 = b.getResources().getConfiguration();
    Object localObject4 = buo.a();
    ((but)localObject4).b("device_info", smallestScreenWidthDp, "swdp", null);
    int i;
    ContentResolver localContentResolver;
    HttpParams localHttpParams;
    int j;
    String str;
    int k;
    int m;
    if (cxd.b())
    {
      i = densityDpi;
      ((but)localObject4).b("device_info", i, "dpi", null);
      localObject1 = a((Configuration)localObject1);
      localObject4 = ddx.a;
      b = b();
      localObject4 = new dqk(b, (ddx)localObject4, (String)localObject1);
      localObject1 = a;
      a.enableCurlLogging((String)localObject1, 2);
      localContentResolver = b.getContentResolver();
      localHttpParams = ((dqk)localObject4).getParams();
      j = ghz.a(localContentResolver, "gmail_sync_timeout_experimental_group_percentage", 0);
      i = ghz.a(localContentResolver, "gmail_sync_timeout_num_experimental_groups", 0);
      if ((j > 0) && (i > 0))
      {
        str = Settings.Secure.getString(localContentResolver, "android_id");
        localObject1 = localObject3;
      }
    }
    else
    {
      try
      {
        if (!TextUtils.isEmpty(str))
        {
          k = (int)Long.parseLong(str, 16);
          localObject1 = Integer.valueOf(k);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          dri.b(a, "Invalid android id: %s", new Object[] { str });
          localObject2 = localObject3;
          continue;
          m = j;
          continue;
          k = j;
          continue;
          i = j;
        }
      }
      if (localObject1 != null)
      {
        j = (int)(100.0F / j * i);
        j = ((Integer)localObject1).intValue() % j;
        if (j < i)
        {
          dri.b(a, "Account is in Gmail timeout experimental group %d", new Object[] { Integer.valueOf(j) });
          c = true;
          localObject1 = String.valueOf("gmail_sync_timeout_experimental_group_connection_timeout_");
          m = ghz.a(localContentResolver, String.valueOf(localObject1).length() + 11 + (String)localObject1 + j, -1);
          localObject1 = String.valueOf("gmail_sync_timeout_experimental_group_socket_timeout_");
          k = ghz.a(localContentResolver, String.valueOf(localObject1).length() + 11 + (String)localObject1 + j, -1);
          localObject1 = String.valueOf("gmail_sync_timeout_experimental_group_cm_timeout_");
          i = ghz.a(localContentResolver, String.valueOf(localObject1).length() + 11 + (String)localObject1 + j, -1);
        }
      }
    }
    for (;;)
    {
      j = ghz.a(localContentResolver, "gmail_timeout_ms", -1);
      if (m != -1)
      {
        if (m != -1)
        {
          dri.c(a, "Changing connection timeout (because of gservices) to %d", new Object[] { Integer.valueOf(j) });
          HttpConnectionParams.setConnectionTimeout(localHttpParams, m);
        }
        if (k == -1) {
          break label556;
        }
        if (k != -1)
        {
          dri.c(a, "Changing socket timeout (because of gservices) to %d", new Object[] { Integer.valueOf(j) });
          HttpConnectionParams.setSoTimeout(localHttpParams, k);
        }
        if (i == -1) {
          break label561;
        }
        if (i != -1)
        {
          dri.c(a, "Changing connection manager timeout (because of gservices) to %d", new Object[] { Integer.valueOf(j) });
          ConnManagerParams.setTimeout(localHttpParams, i);
        }
        return (dqk)localObject4;
        i = -1;
        break;
      }
      Object localObject2;
      label556:
      label561:
      i = -1;
      k = -1;
      m = -1;
    }
  }
}

/* Location:
 * Qualified Name:     dqj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */