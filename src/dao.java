import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class dao
  implements dbo
{
  private static dao j;
  boolean a;
  volatile String b;
  volatile Boolean c;
  private czj d;
  private Context e;
  private dbm f;
  private cza g;
  private final Map<String, dbm> h = new HashMap();
  private String i;
  
  dao() {}
  
  private dao(Context paramContext)
  {
    this(paramContext, dah.f);
  }
  
  private dao(Context paramContext, czj paramczj)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    e = paramContext.getApplicationContext();
    d = paramczj;
    g = new cza();
    d.a(new dap(this));
    d.a(new daq(this));
  }
  
  public static dao a(Context paramContext)
  {
    try
    {
      if (j == null) {
        j = new dao(paramContext);
      }
      paramContext = j;
      return paramContext;
    }
    finally {}
  }
  
  public final dbm a(String paramString)
  {
    if (paramString == null) {
      try
      {
        throw new IllegalArgumentException("trackingId cannot be null");
      }
      finally {}
    }
    dbm localdbm2 = (dbm)h.get(paramString);
    dbm localdbm1 = localdbm2;
    if (localdbm2 == null)
    {
      localdbm2 = new dbm(paramString, this);
      h.put(paramString, localdbm2);
      localdbm1 = localdbm2;
      if (f == null)
      {
        f = localdbm2;
        localdbm1 = localdbm2;
      }
    }
    dam.a.a(dan.N);
    return localdbm1;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      try
      {
        throw new IllegalArgumentException("hit cannot be null");
      }
      finally {}
    }
    paramMap.put("language", dbp.a(Locale.getDefault()));
    if (!g.a) {}
    czb localczb;
    for (int k = 0;; k = b)
    {
      paramMap.put("adSenseAdMobHitId", Integer.toString(k));
      paramMap.put("screenResolution", e.getResources().getDisplayMetrics().widthPixels + "x" + e.getResources().getDisplayMetrics().heightPixels);
      paramMap.put("usage", dam.a.b());
      dam.a.a();
      d.a(paramMap);
      i = ((String)paramMap.get("trackingId"));
      return;
      localczb = czb.a;
      b = (c.nextInt(2147483646) + 1);
    }
  }
}

/* Location:
 * Qualified Name:     dao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */