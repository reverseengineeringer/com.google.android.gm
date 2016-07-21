import android.content.pm.IPackageStatsObserver;
import com.google.android.libraries.performance.primes.metriccapture.PackageStatsCapture.PackageStatsInvocation;

public final class gmx
  extends PackageStatsCapture.PackageStatsInvocation
{
  public gmx(String paramString, Class[] paramArrayOfClass)
  {
    super(paramString, paramArrayOfClass);
  }
  
  final Object[] a(String paramString, int paramInt, IPackageStatsObserver paramIPackageStatsObserver)
  {
    return new Object[] { paramString, Integer.valueOf(paramInt), paramIPackageStatsObserver };
  }
}

/* Location:
 * Qualified Name:     gmx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */