package com.google.android.libraries.performance.primes.metriccapture;

import android.content.Context;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.Process;
import android.util.Log;
import gmv;
import gmw;
import gmx;
import gom;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class PackageStatsCapture
{
  static final PackageStatsCapture.PackageStatsInvocation[] GETTER_INVOCATIONS = { new gmv("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }), new gmw("getPackageSizeInfo", new Class[] { String.class, Integer.TYPE, IPackageStatsObserver.class }), new gmx("getPackageSizeInfoAsUser", new Class[] { String.class, Integer.TYPE, IPackageStatsObserver.class }) };
  
  private static boolean a()
  {
    try
    {
      boolean bool = Modifier.isAbstract(PackageStatsCapture.PackageStatsCallback.class.getMethod("onGetStatsCompleted", new Class[] { PackageStats.class, Boolean.TYPE }).getModifiers());
      return !bool;
    }
    catch (Exception localException)
    {
      return false;
    }
    catch (Error localError)
    {
      for (;;) {}
    }
  }
  
  public static PackageStats getPackageStats(Context paramContext)
  {
    for (;;)
    {
      try
      {
        
        if (paramContext.getPackageManager().checkPermission("android.permission.GET_PACKAGE_SIZE", paramContext.getPackageName()) == 0) {
          break label59;
        }
        if (paramContext.checkCallingOrSelfPermission("android.permission.GET_PACKAGE_SIZE") != 0) {
          break label64;
        }
        break label59;
      }
      finally {}
      if (i != 0) {
        return getPackageStatsUsingInternalAPI(paramContext, 15000L, GETTER_INVOCATIONS);
      }
      Log.w("PackageStatsCapture", "android.permission.GET_PACKAGE_SIZE required");
      return null;
      label59:
      int i = 1;
      continue;
      label64:
      i = 0;
    }
  }
  
  static PackageStats getPackageStatsUsingInternalAPI(Context paramContext, long paramLong, PackageStatsCapture.PackageStatsInvocation... paramVarArgs)
  {
    if (!a())
    {
      Log.w("PackageStatsCapture", "Callback implementation stripped by proguard.");
      return null;
    }
    PackageStatsCapture.PackageStatsCallback localPackageStatsCallback = new PackageStatsCapture.PackageStatsCallback();
    for (;;)
    {
      int i;
      try
      {
        a.acquire();
        PackageManager localPackageManager = paramContext.getPackageManager();
        paramContext = paramContext.getPackageName();
        int j = Process.myUid();
        int k = paramVarArgs.length;
        i = 0;
        if (i >= k) {
          break;
        }
        if (paramVarArgs[i].invoke(localPackageManager, paramContext, j, localPackageStatsCallback))
        {
          if (a.tryAcquire(paramLong, TimeUnit.MILLISECONDS)) {
            return b;
          }
          Log.w("PackageStatsCapture", "Timeout while waiting for PackageStats callback");
          return null;
        }
      }
      catch (InterruptedException paramContext)
      {
        Thread.currentThread().interrupt();
        return null;
      }
      i += 1;
    }
    Log.w("PackageStatsCapture", "Couldn't capture PackageStats.");
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.libraries.performance.primes.metriccapture.PackageStatsCapture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */