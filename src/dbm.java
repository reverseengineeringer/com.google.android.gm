import android.text.TextUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class dbm
{
  private static final DecimalFormat a = new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US));
  private final dbo b;
  private final dbn c;
  private volatile boolean d = false;
  private volatile boolean e = false;
  private long f = 120000L;
  private long g;
  private boolean h = true;
  
  dbm()
  {
    b = null;
    c = null;
  }
  
  dbm(String paramString, dbo paramdbo)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("trackingId cannot be null");
    }
    b = paramdbo;
    c = new dbn();
    c.b("trackingId", paramString);
    c.b("sampleRate", "100");
    c.a("sessionControl", "start");
    c.b("useSecure", Boolean.toString(true));
  }
  
  private final void a(String paramString, Map<String, String> paramMap)
  {
    e = true;
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("hitType", paramString);
    c.a((Map)localObject, Boolean.valueOf(true));
    if (!c()) {
      dav.g("Too many hits sent too quickly, throttling invoked.");
    }
    for (;;)
    {
      c.a();
      return;
      b.a(c.b());
    }
  }
  
  private final void b()
  {
    if (d) {
      throw new IllegalStateException("Tracker closed");
    }
  }
  
  private final boolean c()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = h;
        if (!bool2) {
          return bool1;
        }
        long l1 = System.currentTimeMillis();
        if (f < 120000L)
        {
          long l2 = l1 - g;
          if (l2 > 0L) {
            f = Math.min(120000L, l2 + f);
          }
        }
        g = l1;
        if (f >= 2000L)
        {
          f -= 2000L;
          continue;
        }
        dav.g("Excessive tracking detected.  Tracking call ignored.");
      }
      finally {}
      bool1 = false;
    }
  }
  
  public Map<String, String> a(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("exDescription", paramString);
    localHashMap.put("exFatal", Boolean.toString(true));
    dam.a.a(dan.H);
    return localHashMap;
  }
  
  public void a()
  {
    b();
    dam.a.a(dan.m);
    c.a("sessionControl", "start");
  }
  
  public void a(double paramDouble)
  {
    dam.a.a(dan.w);
    c.b("sampleRate", Double.toString(paramDouble));
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt <= 0)
    {
      dav.f("index must be > 0, ignoring setCustomDimension call for " + paramInt + ", " + paramString);
      return;
    }
    c.a(dbp.a("customDimension", paramInt), paramString);
  }
  
  public void a(String paramString)
  {
    if (e)
    {
      dav.g("Tracking already started, setAppName call ignored");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      dav.g("setting appName to empty value not allowed, call ignored");
      return;
    }
    dam.a.a(dan.o);
    c.b("appName", paramString);
  }
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    b();
    dam.a.a(dan.h);
    dam.a.a(true);
    a("timing", b(paramString1, paramLong, paramString2, paramString3));
    dam.a.a(false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    b();
    dam.a.a(dan.c);
    dam.a.a(true);
    a("event", b(paramString1, paramString2, paramString3, paramLong));
    dam.a.a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    dam.a.a(dan.u);
    c.b("anonymizeIp", Boolean.toString(paramBoolean));
  }
  
  public Map<String, String> b(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timingCategory", paramString1);
    localHashMap.put("timingValue", Long.toString(paramLong));
    localHashMap.put("timingVar", paramString2);
    localHashMap.put("timingLabel", paramString3);
    dam.a.a(dan.J);
    return localHashMap;
  }
  
  public Map<String, String> b(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventCategory", paramString1);
    localHashMap.put("eventAction", paramString2);
    localHashMap.put("eventLabel", paramString3);
    if (paramLong != null) {
      localHashMap.put("eventValue", Long.toString(paramLong.longValue()));
    }
    dam.a.a(dan.Y);
    return localHashMap;
  }
  
  public void b(String paramString)
  {
    if (e)
    {
      dav.g("Tracking already started, setAppVersion call ignored");
      return;
    }
    dam.a.a(dan.q);
    c.b("appVersion", paramString);
  }
  
  public void c(String paramString)
  {
    b();
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalStateException("trackView requires a appScreen to be set");
    }
    dam.a.a(dan.b);
    c.b("description", paramString);
    a("appview", null);
  }
  
  public void d(String paramString)
  {
    b();
    dam.a.a(dan.e);
    dam.a.a(true);
    a("exception", a(paramString, true));
    dam.a.a(false);
  }
}

/* Location:
 * Qualified Name:     dbm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */