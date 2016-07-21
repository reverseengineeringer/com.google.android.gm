import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public final class ehi
{
  public static final eiu<ehp> a = new eiu();
  public static final eiq<ehp, Object> b = new ehj();
  public static final eip<Object> c = new eip("ClearcutLogger.API", b, a);
  public static final ehn d = new ehw();
  private final Context e;
  private final String f;
  private final int g;
  private String h;
  private int i = -1;
  private String j;
  private String k;
  private final boolean l;
  private int m = 0;
  private final ehn n;
  private final eov o;
  private ehm p;
  
  @Deprecated
  public ehi(Context paramContext, String paramString)
  {
    this(paramContext, paramString, null, null, d, epb.c());
  }
  
  private ehi(Context paramContext, String paramString1, String paramString2, String paramString3, ehn paramehn, eov parameov)
  {
    e = paramContext;
    f = paramContext.getPackageName();
    g = a(paramContext);
    i = -1;
    h = paramString1;
    j = null;
    k = null;
    l = false;
    n = paramehn;
    o = parameov;
    p = new ehm();
    m = 0;
    if (l)
    {
      if (j == null) {
        bool = true;
      }
      enz.b(bool, "can't be anonymous with an upload account");
    }
  }
  
  private static int a(Context paramContext)
  {
    try
    {
      int i1 = getPackageManagergetPackageInfogetPackageName0versionCode;
      return i1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("ClearcutLogger", "This can't happen.");
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     ehi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */