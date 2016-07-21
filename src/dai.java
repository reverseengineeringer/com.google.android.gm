import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class dai
  implements Runnable
{
  dai(dah paramdah, Map paramMap, long paramLong) {}
  
  public final void run()
  {
    a.put("clientId", c.e);
    double d;
    int i;
    if (!c.a)
    {
      localObject1 = a;
      if (((Map)localObject1).get("sampleRate") == null) {
        break label130;
      }
      d = dbp.b((String)((Map)localObject1).get("sampleRate"));
      if (d > 0.0D) {
        break label76;
      }
      i = 1;
    }
    while (i != 0)
    {
      return;
      label76:
      if (d < 100.0D)
      {
        localObject1 = (String)((Map)localObject1).get("clientId");
        if ((localObject1 != null) && (Math.abs(((String)localObject1).hashCode()) % 10000 >= d * 100.0D))
        {
          i = 1;
          continue;
        }
      }
      label130:
      i = 0;
    }
    if (!TextUtils.isEmpty(c.d))
    {
      a.put("campaign", c.d);
      c.d = null;
    }
    Object localObject4 = c;
    Object localObject8 = a;
    Object localObject1 = h.getPackageManager();
    Object localObject6 = h.getPackageName();
    Object localObject9 = ((PackageManager)localObject1).getInstallerPackageName((String)localObject6);
    for (;;)
    {
      try
      {
        localObject4 = ((PackageManager)localObject1).getPackageInfo(h.getPackageName(), 0);
        if (localObject4 == null) {
          break label1103;
        }
        localObject1 = ((PackageManager)localObject1).getApplicationLabel(applicationInfo).toString();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        String str;
        localObject4 = localObject6;
        dav.b("Error retrieving package info: appName set to " + (String)localObject4);
        localObject2 = null;
        continue;
      }
      try
      {
        localObject7 = versionName;
        localObject4 = localObject1;
        localObject1 = localObject7;
        dah.a((Map)localObject8, "appName", (String)localObject4);
        dah.a((Map)localObject8, "appVersion", (String)localObject1);
        dah.a((Map)localObject8, "appId", (String)localObject6);
        dah.a((Map)localObject8, "appInstallerId", (String)localObject9);
        ((Map)localObject8).put("apiVersion", "1");
        localObject1 = a;
        localObject4 = dbp.d((String)((Map)localObject1).get("campaign"));
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject4 = dbp.a((String)localObject4);
          ((Map)localObject1).put("campaignContent", ((Map)localObject4).get("utm_content"));
          ((Map)localObject1).put("campaignMedium", ((Map)localObject4).get("utm_medium"));
          ((Map)localObject1).put("campaignName", ((Map)localObject4).get("utm_campaign"));
          ((Map)localObject1).put("campaignSource", ((Map)localObject4).get("utm_source"));
          ((Map)localObject1).put("campaignKeyword", ((Map)localObject4).get("utm_term"));
          ((Map)localObject1).put("campaignId", ((Map)localObject4).get("utm_id"));
          ((Map)localObject1).put("gclid", ((Map)localObject4).get("gclid"));
          ((Map)localObject1).put("dclid", ((Map)localObject4).get("dclid"));
          ((Map)localObject1).put("gmob_t", ((Map)localObject4).get("gmob_t"));
        }
        localObject1 = c;
        localObject4 = a;
        localObject6 = (String)((Map)localObject4).get("rawException");
        if (localObject6 != null)
        {
          ((Map)localObject4).remove("rawException");
          localObject6 = new ByteArrayInputStream(dbp.e((String)localObject6));
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2)
      {
        localObject5 = localObject3;
        continue;
      }
      try
      {
        localObject6 = new ObjectInputStream((InputStream)localObject6);
        localObject7 = ((ObjectInputStream)localObject6).readObject();
        ((ObjectInputStream)localObject6).close();
        if ((localObject7 instanceof Throwable))
        {
          localObject6 = (Throwable)localObject7;
          localObject7 = new ArrayList();
          ((Map)localObject4).put("exDescription", new dbl(h, (Collection)localObject7).a((String)((Map)localObject4).get("exceptionThreadName"), (Throwable)localObject6));
        }
      }
      catch (IOException localIOException)
      {
        dav.f("IOException reading exception");
        continue;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        dav.f("ClassNotFoundException reading exception");
        continue;
        localObject3 = localObject4;
        if (!((String)localObject4).contains("*")) {
          break label955;
        }
        localObject3 = ((String)localObject4).substring(0, ((String)localObject4).indexOf("*"));
        localObject3 = (day)a.get(localObject3);
        continue;
        localObject6 = c.g;
        l = b;
        localObject8 = a;
        localObject4 = (String)((Map)localObject8).get("internalHitUrl");
        localObject3 = localObject4;
        if (localObject4 != null) {
          break label1057;
        }
        if (!((Map)localObject8).containsKey("useSecure")) {
          break label1086;
        }
        if (!dbp.c((String)((Map)localObject8).get("useSecure"))) {
          break label1078;
        }
        localObject3 = "https://ssl.google-analytics.com/collect";
        ((dbj)localObject6).a((Map)localObject7, l, (String)localObject3, c.b);
        return;
      }
      localObject8 = c.c;
      localObject1 = a;
      Object localObject7 = new HashMap();
      localObject9 = ((Map)localObject1).entrySet().iterator();
      if (((Iterator)localObject9).hasNext())
      {
        localObject6 = (Map.Entry)((Iterator)localObject9).next();
        localObject4 = (String)((Map.Entry)localObject6).getKey();
        if (((String)localObject4).startsWith("&"))
        {
          localObject1 = new day(((String)localObject4).substring(1), null, null);
          if (localObject1 == null) {
            continue;
          }
          str = ((day)localObject1).a((String)((Map.Entry)localObject6).getKey());
          if (str == null) {
            continue;
          }
          localObject6 = (String)((Map.Entry)localObject6).getValue();
          localObject4 = localObject6;
          if (b != null) {
            localObject4 = b.a((String)localObject6);
          }
          if ((localObject4 == null) || (((String)localObject4).equals(a))) {
            continue;
          }
          ((Map)localObject7).put(str, localObject4);
          continue;
        }
      }
      for (;;)
      {
        Object localObject2;
        label955:
        long l;
        label1057:
        label1078:
        localObject3 = "http://www.google-analytics.com/collect";
        continue;
        label1086:
        localObject3 = "https://ssl.google-analytics.com/collect";
      }
      label1103:
      Object localObject3 = null;
      Object localObject5 = localObject6;
    }
  }
}

/* Location:
 * Qualified Name:     dai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */