import android.content.pm.IPackageStatsObserver;
import com.google.android.libraries.performance.primes.metriccapture.PackageStatsCapture.PackageStatsInvocation;

public final class gmv
  extends PackageStatsCapture.PackageStatsInvocation
{
  public gmv(String paramString, Class[] paramArrayOfClass)
  {
    super(paramString, paramArrayOfClass);
  }
  
  final Object[] a(String paramString, int paramInt, IPackageStatsObserver paramIPackageStatsObserver)
  {
    return new Object[] { paramString, paramIPackageStatsObserver };
  }
}

/* Location:
 * Qualified Name:     gmv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */