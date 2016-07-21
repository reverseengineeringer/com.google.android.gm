package com.google.android.libraries.performance.primes.metriccapture;

import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.Method;

public abstract class PackageStatsCapture$PackageStatsInvocation
{
  private final String a;
  private final Class<?>[] b;
  
  public PackageStatsCapture$PackageStatsInvocation(String paramString, Class<?>[] paramArrayOfClass)
  {
    a = paramString;
    b = paramArrayOfClass;
  }
  
  public abstract Object[] a(String paramString, int paramInt, IPackageStatsObserver paramIPackageStatsObserver);
  
  boolean invoke(PackageManager paramPackageManager, String paramString, int paramInt, IPackageStatsObserver paramIPackageStatsObserver)
  {
    try
    {
      paramPackageManager.getClass().getMethod(a, b).invoke(paramPackageManager, a(paramString, paramInt, paramIPackageStatsObserver));
      return true;
    }
    catch (Exception paramPackageManager)
    {
      Log.e("PackageStatsCapture", "PackageStats failure", paramPackageManager);
      return false;
    }
    catch (Error paramPackageManager)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException paramPackageManager)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.libraries.performance.primes.metriccapture.PackageStatsCapture.PackageStatsInvocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */