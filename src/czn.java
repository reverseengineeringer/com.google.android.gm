import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class czn
{
  private static czn m;
  public boolean a = false;
  public boolean b = false;
  public int c = 0;
  public long d;
  public long e;
  public final Map<String, String> f = new HashMap();
  public dbm g = null;
  public dbc h;
  public czl i = new czo(this);
  public Timer j;
  public TimerTask k;
  public boolean l = false;
  private String n;
  private String o;
  private String p;
  private int q = 1800;
  private boolean r;
  private Double s;
  private boolean t;
  private boolean u;
  private Thread.UncaughtExceptionHandler v;
  private Context w;
  private dao x;
  private dbi y;
  
  public static czn a()
  {
    if (m == null) {
      m = new czn();
    }
    return m;
  }
  
  public static dbm b()
  {
    if (aw == null) {
      throw new IllegalStateException("You must call EasyTracker.getInstance().setContext(context) or startActivity(activity) before calling getTracker()");
    }
    return ag;
  }
  
  public final void a(Context paramContext)
  {
    boolean bool2 = true;
    if (paramContext == null) {
      dav.b("Context cannot be null");
    }
    Object localObject;
    dbd localdbd;
    dao localdao;
    do
    {
      return;
      localObject = czv.a();
      localdbd = new dbd(paramContext.getApplicationContext());
      localdao = dao.a(paramContext.getApplicationContext());
      if (paramContext == null) {
        dav.b("Context cannot be null");
      }
    } while (w != null);
    w = paramContext.getApplicationContext();
    x = localdao;
    y = ((dbi)localObject);
    h = localdbd;
    n = h.a("ga_trackingId");
    if (TextUtils.isEmpty(n))
    {
      n = h.a("ga_api_key");
      if (TextUtils.isEmpty(n))
      {
        dav.b("EasyTracker requested, but missing required ga_trackingId");
        g = new czp(this);
        return;
      }
    }
    a = true;
    o = h.a("ga_appName");
    p = h.a("ga_appVersion");
    r = h.c("ga_debug");
    s = h.b("ga_sampleFrequency");
    if (s == null) {
      s = new Double(h.a("ga_sampleRate", 100));
    }
    q = h.a("ga_dispatchPeriod", 1800);
    d = (h.a("ga_sessionTimeout", 30) * 1000);
    boolean bool1 = bool2;
    if (!h.c("ga_autoActivityTracking")) {
      if (!h.c("ga_auto_activity_tracking")) {
        break label548;
      }
    }
    label548:
    for (bool1 = bool2;; bool1 = false)
    {
      b = bool1;
      t = h.c("ga_anonymizeIp");
      u = h.c("ga_reportUncaughtExceptions");
      g = x.a(n);
      if (!TextUtils.isEmpty(o))
      {
        dav.c("setting appName to " + o);
        g.a(o);
      }
      if (p != null) {
        g.b(p);
      }
      g.a(t);
      g.a(s.doubleValue());
      paramContext = x;
      bool1 = r;
      dam.a.a(dan.L);
      a = bool1;
      dav.a = bool1;
      y.a(q);
      if (!u) {
        break;
      }
      localObject = v;
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = new czs(g, y, Thread.getDefaultUncaughtExceptionHandler(), w);
      }
      Thread.setDefaultUncaughtExceptionHandler(paramContext);
      return;
    }
  }
  
  public final void c()
  {
    try
    {
      if (j != null)
      {
        j.cancel();
        j = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     czn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */