import android.content.pm.PackageStats;
import android.util.Log;
import com.google.android.libraries.performance.primes.metriccapture.PackageStatsCapture;

final class glg
  implements Runnable
{
  glg(glf paramglf) {}
  
  public final void run()
  {
    Object localObject = PackageStatsCapture.getPackageStats(a.a);
    if (localObject != null)
    {
      hri localhri = new hri();
      hrd localhrd = new hrd();
      a = Long.valueOf(cacheSize);
      b = Long.valueOf(codeSize);
      c = Long.valueOf(dataSize);
      d = Long.valueOf(externalCacheSize);
      e = Long.valueOf(externalCodeSize);
      f = Long.valueOf(externalDataSize);
      g = Long.valueOf(externalMediaSize);
      h = Long.valueOf(externalObbSize);
      i = localhrd;
      localObject = String.valueOf(i.toString());
      if (((String)localObject).length() != 0) {
        "pkgMetric: ".concat((String)localObject);
      }
      for (;;)
      {
        a.b.a(localhri);
        return;
        new String("pkgMetric: ");
      }
    }
    Log.w("PackageMetricService", "PackageStats capture failed.");
  }
}

/* Location:
 * Qualified Name:     glg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */