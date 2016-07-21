import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;

final class glb
  extends gkv
{
  private final gna a;
  
  glb(gna paramgna, gks paramgks, int paramInt)
  {
    super(paramgks, paramInt);
    a = paramgna;
  }
  
  protected final void b(String paramString, hri paramhri)
  {
    if (paramhri == null)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "metric is null, skipping recorded metric for event: ".concat(paramString);; paramString = new String("metric is null, skipping recorded metric for event: "))
      {
        Log.w("SingleProcRecorder", paramString);
        return;
      }
    }
    Object localObject;
    if (paramhri == null)
    {
      Log.w("MetricStamper", "Unexpected null metric to stamp, Stamping has been skipped.");
      localObject = null;
    }
    for (;;)
    {
      if (paramString != null) {
        c = paramString;
      }
      a.a((hri)localObject);
      return;
      if (glc.a == null)
      {
        Log.w("MetricStamper", "MetricStamper.initialize() was never called, stamping has been skipped.");
        localObject = paramhri;
        continue;
      }
      int i;
      if (ac == null)
      {
        ac = ab.getPackageName();
        localObject = ab.getPackageManager();
        if (Build.VERSION.SDK_INT < 20) {
          break label261;
        }
        glc localglc = glc.a;
        if (!((PackageManager)localObject).hasSystemFeature("android.hardware.type.watch")) {
          break label256;
        }
        i = 2;
        label161:
        e = i;
      }
      try
      {
        for (;;)
        {
          ad = getPackageInfoac, 0).versionName;
          e = new hqm();
          e.a = ac;
          e.c = ae;
          localObject = paramhri;
          if (ad == null) {
            break;
          }
          e.b = ad;
          localObject = paramhri;
          break;
          label256:
          i = 1;
          break label161;
          label261:
          ae = 1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          Log.w("MetricStamper", String.format("Failed to get Package info for: %s, %s", new Object[] { ac, localNameNotFoundException }));
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     glb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */