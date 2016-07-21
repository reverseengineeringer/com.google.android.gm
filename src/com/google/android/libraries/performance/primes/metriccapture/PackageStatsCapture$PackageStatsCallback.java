package com.google.android.libraries.performance.primes.metriccapture;

import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageStats;
import android.util.Log;
import java.util.concurrent.Semaphore;

final class PackageStatsCapture$PackageStatsCallback
  extends IPackageStatsObserver.Stub
{
  final Semaphore a = new Semaphore(1);
  volatile PackageStats b;
  
  public final void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Log.isLoggable("PackageStatsCapture", 3))
      {
        String str = String.valueOf(paramPackageStats);
        new StringBuilder(String.valueOf(str).length() + 30).append("Success getting PackageStats: ").append(str);
      }
      b = paramPackageStats;
    }
    for (;;)
    {
      a.release();
      return;
      Log.w("PackageStatsCapture", "Failure getting PackageStats");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.libraries.performance.primes.metriccapture.PackageStatsCapture.PackageStatsCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */