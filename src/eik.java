import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class eik
{
  @Deprecated
  public static final int a = 7895000;
  public static boolean b = false;
  public static boolean c = false;
  static final AtomicBoolean d = new AtomicBoolean();
  private static int e = -1;
  private static final Object f = new Object();
  private static String g = null;
  private static Integer h = null;
  
  @Deprecated
  public static int a(Context paramContext)
  {
    if (emo.a) {
      return 0;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        paramContext.getResources().getString(eaz.s);
        if ("com.google.android.gms".equals(paramContext.getPackageName())) {
          break label286;
        }
      }
      catch (Throwable localThrowable)
      {
        synchronized (f)
        {
          if (g == null)
          {
            g = paramContext.getPackageName();
            try
            {
              localObject3 = getPackageManagergetApplicationInfogetPackageName128metaData;
              if (localObject3 == null) {
                continue;
              }
              h = Integer.valueOf(((Bundle)localObject3).getInt("com.google.android.gms.version"));
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException1)
            {
              Object localObject3;
              Log.wtf("GooglePlayServicesUtil", "This should never happen.", localNameNotFoundException1);
              continue;
            }
            localObject3 = h;
            if (localObject3 != null) {
              break;
            }
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            localThrowable = localThrowable;
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
            continue;
            h = null;
          }
        }
      }
      if (!g.equals(paramContext.getPackageName())) {
        throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + g + "' and this call used package '" + paramContext.getPackageName() + "'.");
      }
    }
    if (localNameNotFoundException1.intValue() != a) {
      throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + a + " but" + " found " + localNameNotFoundException1 + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
    }
    label286:
    Object localObject4;
    for (;;)
    {
      try
      {
        localObject2 = localPackageManager.getPackageInfo("com.google.android.gms", 64);
        localObject4 = eim.a;
        if (versionCode % 1000 / 100 == 3)
        {
          i = 1;
          if ((i == 0) && (!eoz.a(paramContext))) {
            break;
          }
          if (eim.a((PackageInfo)localObject2, eut.a) != null) {
            break label475;
          }
          Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
          return 9;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
        return 1;
      }
      i = 0;
    }
    try
    {
      localObject4 = eim.a(localPackageManager.getPackageInfo("com.android.vending", 64), eut.a);
      if (localObject4 == null)
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      if (a(paramContext, "com.android.vending"))
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store is updating.");
        if (eim.a((PackageInfo)localObject2, eut.a) == null)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
          return 9;
          if (eim.a((PackageInfo)localObject2, new epk[] { localNameNotFoundException2 }) == null)
          {
            Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
            return 9;
          }
        }
      }
      else
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
        return 9;
      }
    }
    label475:
    int i = a / 1000;
    if (versionCode / 1000 < i)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + a + " but found " + versionCode);
      return 2;
    }
    Object localObject2 = applicationInfo;
    paramContext = (Context)localObject2;
    if (localObject2 == null) {}
    try
    {
      paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
      if (!enabled) {
        return 3;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
      paramContext.printStackTrace();
      return 1;
    }
    return 0;
  }
  
  @Deprecated
  public static Dialog a(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return b(paramInt1, paramActivity, null, paramInt2, null);
  }
  
  @Deprecated
  public static String a(int paramInt)
  {
    return ConnectionResult.a(paramInt);
  }
  
  @Deprecated
  public static void a(int paramInt, Context paramContext)
  {
    PendingIntent localPendingIntent = null;
    int i = paramInt;
    if (eoz.a(paramContext))
    {
      i = paramInt;
      if (paramInt == 2) {
        i = 42;
      }
    }
    if (!b(paramContext, i)) {
      if (i != 9) {
        break label70;
      }
    }
    label70:
    for (boolean bool = a(paramContext, "com.android.vending"); bool; bool = false)
    {
      paramContext = new eil(paramContext);
      paramContext.sendMessageDelayed(paramContext.obtainMessage(1), 120000L);
      return;
    }
    Object localObject3 = paramContext.getResources();
    Object localObject4 = e(paramContext);
    Object localObject1 = paramContext.getResources();
    Object localObject2;
    switch (i)
    {
    default: 
      Log.e("GoogleApiAvailability", "Unexpected error code " + i);
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((Resources)localObject3).getString(eaz.p);
      }
      localObject1 = paramContext.getResources();
      switch (i)
      {
      default: 
        localObject1 = ((Resources)localObject1).getString(eaz.s);
        label378:
        localObject4 = b(i);
        if (localObject4 == null)
        {
          label389:
          if (!eoz.a(paramContext)) {
            break label1035;
          }
          enz.a(epf.a(16));
          localObject1 = new Notification.Builder(paramContext).setSmallIcon(eay.b).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText((String)localObject2 + " " + (String)localObject1)).addAction(eay.a, ((Resources)localObject3).getString(eaz.A), localPendingIntent).build();
          switch (i)
          {
          default: 
            label486:
            paramInt = 0;
            label538:
            if (paramInt != 0) {
              d.set(false);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    for (paramInt = 10436;; paramInt = 39789)
    {
      ((NotificationManager)paramContext.getSystemService("notification")).notify(paramInt, (Notification)localObject1);
      return;
      localObject1 = null;
      break;
      localObject1 = ((Resources)localObject1).getString(eaz.k);
      break;
      localObject1 = ((Resources)localObject1).getString(eaz.g);
      break;
      localObject1 = ((Resources)localObject1).getString(eaz.z);
      break;
      localObject1 = ((Resources)localObject1).getString(eaz.x);
      break;
      localObject1 = ((Resources)localObject1).getString(eaz.c);
      break;
      Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
      localObject1 = ((Resources)localObject1).getString(eaz.u);
      break;
      Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
      localObject1 = ((Resources)localObject1).getString(eaz.o);
      break;
      Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
      localObject1 = null;
      break;
      Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
      localObject1 = null;
      break;
      Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
      localObject1 = ((Resources)localObject1).getString(eaz.m);
      break;
      Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
      localObject1 = null;
      break;
      Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
      localObject1 = null;
      break;
      Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
      localObject1 = ((Resources)localObject1).getString(eaz.r);
      break;
      if (epc.a((Resources)localObject1))
      {
        localObject1 = ((Resources)localObject1).getString(eaz.j, new Object[] { localObject4 });
        break label378;
      }
      localObject1 = ((Resources)localObject1).getString(eaz.i, new Object[] { localObject4 });
      break label378;
      localObject1 = ((Resources)localObject1).getString(eaz.y, new Object[] { localObject4 });
      break label378;
      localObject1 = ((Resources)localObject1).getString(eaz.w, new Object[] { localObject4 });
      break label378;
      localObject1 = ((Resources)localObject1).getString(eaz.a, new Object[] { localObject4 });
      break label378;
      localObject1 = ((Resources)localObject1).getString(eaz.f, new Object[] { localObject4 });
      break label378;
      localObject1 = ((Resources)localObject1).getString(eaz.t, new Object[] { localObject4 });
      break label378;
      localObject1 = ((Resources)localObject1).getString(eaz.n);
      break label378;
      localObject1 = ((Resources)localObject1).getString(eaz.l);
      break label378;
      localObject1 = ((Resources)localObject1).getString(eaz.d, new Object[] { localObject4 });
      break label378;
      localObject1 = ((Resources)localObject1).getString(eaz.q);
      break label378;
      localPendingIntent = PendingIntent.getActivity(paramContext, 0, (Intent)localObject4, 268435456);
      break label389;
      label1035:
      localObject3 = ((Resources)localObject3).getString(eaz.p);
      if (epf.a(11))
      {
        localObject2 = new Notification.Builder(paramContext).setSmallIcon(17301642).setContentTitle((CharSequence)localObject2).setContentText((CharSequence)localObject1).setContentIntent(localPendingIntent).setTicker((CharSequence)localObject3).setAutoCancel(true);
        if (epf.a(20)) {
          ((Notification.Builder)localObject2).setLocalOnly(true);
        }
        if (epf.a(16)) {
          ((Notification.Builder)localObject2).setStyle(new Notification.BigTextStyle().bigText((CharSequence)localObject1));
        }
        for (localObject1 = ((Notification.Builder)localObject2).build();; localObject1 = ((Notification.Builder)localObject2).getNotification())
        {
          if (Build.VERSION.SDK_INT == 19) {
            extras.putBoolean("android.support.localOnly", true);
          }
          break;
        }
      }
      localObject3 = new Notification(17301642, (CharSequence)localObject3, System.currentTimeMillis());
      flags |= 0x10;
      ((Notification)localObject3).setLatestEventInfo(paramContext, (CharSequence)localObject2, (CharSequence)localObject1, localPendingIntent);
      localObject1 = localObject3;
      break label486;
      paramInt = 1;
      break label538;
    }
  }
  
  @Deprecated
  public static boolean a(int paramInt, Activity paramActivity)
  {
    return a(paramInt, paramActivity, null, 0, null);
  }
  
  public static boolean a(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramFragment = b(paramInt1, paramActivity, paramFragment, paramInt2, paramOnCancelListener);
    if (paramFragment == null) {
      return false;
    }
    Object localObject;
    if ((paramActivity instanceof fj))
    {
      paramActivity = ((fj)paramActivity).a_();
      localObject = new ein();
      paramFragment = (Dialog)enz.a(paramFragment, "Cannot display null dialog");
      paramFragment.setOnCancelListener(null);
      paramFragment.setOnDismissListener(null);
      ai = paramFragment;
      if (paramOnCancelListener != null) {
        aj = paramOnCancelListener;
      }
      ((ein)localObject).a(paramActivity, "GooglePlayServicesErrorDialog");
    }
    for (;;)
    {
      return true;
      if (!epf.a(11)) {
        break;
      }
      paramActivity = paramActivity.getFragmentManager();
      localObject = new eig();
      paramFragment = (Dialog)enz.a(paramFragment, "Cannot display null dialog");
      paramFragment.setOnCancelListener(null);
      paramFragment.setOnDismissListener(null);
      a = paramFragment;
      if (paramOnCancelListener != null) {
        b = paramOnCancelListener;
      }
      ((eig)localObject).show(paramActivity, "GooglePlayServicesErrorDialog");
    }
    throw new RuntimeException("This Activity does not support Fragments.");
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    return (a(paramContext, paramInt, "com.google.android.gms")) && (a(paramContext.getPackageManager(), "com.google.android.gms"));
  }
  
  private static boolean a(Context paramContext, int paramInt, String paramString)
  {
    boolean bool2 = false;
    if (epf.a(19)) {
      paramContext = (AppOpsManager)paramContext.getSystemService("appops");
    }
    for (;;)
    {
      try
      {
        paramContext.checkPackage(paramInt, paramString);
        bool1 = true;
        return bool1;
      }
      catch (SecurityException paramContext) {}
      paramContext = paramContext.getPackageManager().getPackagesForUid(paramInt);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        paramInt = 0;
        for (;;)
        {
          bool1 = bool2;
          if (paramInt >= paramContext.length) {
            break;
          }
          if (paramString.equals(paramContext[paramInt])) {
            return true;
          }
          paramInt += 1;
        }
      }
    }
    return false;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    if (epf.a(21))
    {
      paramContext = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
      } while (!paramString.equals(((PackageInstaller.SessionInfo)paramContext.next()).getAppPackageName()));
      return true;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      boolean bool = getApplicationInfo8192enabled;
      if (bool) {
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean a(PackageManager paramPackageManager)
  {
    if (!b(paramPackageManager)) {
      if (!b) {
        break label23;
      }
    }
    label23:
    for (boolean bool = c; !bool; bool = "user".equals(Build.TYPE)) {
      return true;
    }
    return false;
  }
  
  @Deprecated
  public static boolean a(PackageManager paramPackageManager, int paramInt)
  {
    eim.a.a(paramPackageManager, paramInt);
    return true;
  }
  
  @Deprecated
  public static boolean a(PackageManager paramPackageManager, String paramString)
  {
    return eim.a.a(paramPackageManager, paramString);
  }
  
  private static Dialog b(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject3 = null;
    if (paramInt1 == 0) {
      return null;
    }
    int i = paramInt1;
    if (eoz.a(paramActivity))
    {
      i = paramInt1;
      if (paramInt1 == 2) {
        i = 42;
      }
    }
    if (epf.a(14))
    {
      localObject1 = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, (TypedValue)localObject1, true);
      if (!"Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(resourceId))) {}
    }
    for (Object localObject1 = new AlertDialog.Builder(paramActivity, 5);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new AlertDialog.Builder(paramActivity);
      }
      localObject1 = e(paramActivity);
      Resources localResources = paramActivity.getResources();
      switch (i)
      {
      default: 
        localObject1 = localResources.getString(eaz.s);
        ((AlertDialog.Builder)localObject2).setMessage((CharSequence)localObject1);
        if (paramOnCancelListener != null) {
          ((AlertDialog.Builder)localObject2).setOnCancelListener(paramOnCancelListener);
        }
        paramOnCancelListener = b(i);
        if (paramFragment == null)
        {
          paramOnCancelListener = new emp(paramActivity, paramOnCancelListener, paramInt2);
          label271:
          paramFragment = paramActivity.getResources();
          switch (i)
          {
          default: 
            paramFragment = paramFragment.getString(17039370);
            label328:
            if (paramFragment != null) {
              ((AlertDialog.Builder)localObject2).setPositiveButton(paramFragment, paramOnCancelListener);
            }
            paramFragment = paramActivity.getResources();
            paramActivity = (Activity)localObject3;
            switch (i)
            {
            default: 
              Log.e("GoogleApiAvailability", "Unexpected error code " + i);
              paramActivity = (Activity)localObject3;
            }
            break;
          }
        }
        break;
      }
      for (;;)
      {
        if (paramActivity != null) {
          ((AlertDialog.Builder)localObject2).setTitle(paramActivity);
        }
        return ((AlertDialog.Builder)localObject2).create();
        if (epc.a(localResources))
        {
          localObject1 = localResources.getString(eaz.j, new Object[] { localObject1 });
          break;
        }
        localObject1 = localResources.getString(eaz.i, new Object[] { localObject1 });
        break;
        localObject1 = localResources.getString(eaz.f, new Object[] { localObject1 });
        break;
        localObject1 = localResources.getString(eaz.y, new Object[] { localObject1 });
        break;
        localObject1 = localResources.getString(eaz.w, new Object[] { localObject1 });
        break;
        localObject1 = localResources.getString(eaz.b, new Object[] { localObject1 });
        break;
        localObject1 = localResources.getString(eaz.t, new Object[] { localObject1 });
        break;
        localObject1 = localResources.getString(eaz.n);
        break;
        localObject1 = localResources.getString(eaz.l);
        break;
        localObject1 = localResources.getString(eaz.d, new Object[] { localObject1 });
        break;
        localObject1 = localResources.getString(eaz.q);
        break;
        paramOnCancelListener = new emp(paramFragment, paramOnCancelListener, paramInt2);
        break label271;
        paramFragment = paramFragment.getString(eaz.h);
        break label328;
        paramFragment = paramFragment.getString(eaz.e);
        break label328;
        paramFragment = paramFragment.getString(eaz.v);
        break label328;
        paramActivity = paramFragment.getString(eaz.k);
        continue;
        paramActivity = paramFragment.getString(eaz.g);
        continue;
        paramActivity = paramFragment.getString(eaz.z);
        continue;
        paramActivity = paramFragment.getString(eaz.x);
        continue;
        paramActivity = paramFragment.getString(eaz.c);
        continue;
        Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
        paramActivity = paramFragment.getString(eaz.u);
        continue;
        Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
        paramActivity = paramFragment.getString(eaz.o);
        continue;
        Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
        paramActivity = (Activity)localObject3;
        continue;
        Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
        paramActivity = (Activity)localObject3;
        continue;
        Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
        paramActivity = paramFragment.getString(eaz.m);
        continue;
        Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
        paramActivity = (Activity)localObject3;
        continue;
        Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
        paramActivity = (Activity)localObject3;
        continue;
        Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
        paramActivity = paramFragment.getString(eaz.r);
      }
    }
  }
  
  @Deprecated
  public static Intent b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return eni.b("com.google.android.gms");
    case 42: 
      return eni.a();
    }
    return eni.a("com.google.android.gms");
  }
  
  @Deprecated
  public static void b(Context paramContext)
  {
    int i = a(paramContext);
    if (i != 0)
    {
      paramContext = b(i);
      Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + i);
      if (paramContext == null) {
        throw new eii(i);
      }
      throw new eij(i, "Google Play Services not available", paramContext);
    }
  }
  
  @Deprecated
  public static boolean b(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return a(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  private static boolean b(PackageManager paramPackageManager)
  {
    synchronized (f)
    {
      int i = e;
      if (i == -1) {}
      try
      {
        paramPackageManager = paramPackageManager.getPackageInfo("com.google.android.gms", 64);
        eim localeim = eim.a;
        if (eim.a(paramPackageManager, new epk[] { epj.b[1] }) != null) {}
        for (e = 1; e != 0; e = 0) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramPackageManager)
      {
        for (;;)
        {
          e = 0;
        }
      }
    }
    return false;
  }
  
  @Deprecated
  public static void c(Context paramContext)
  {
    if (d.getAndSet(true)) {
      return;
    }
    try
    {
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(10436);
      return;
    }
    catch (SecurityException paramContext) {}
  }
  
  @Deprecated
  public static boolean c(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return false;
    }
    return true;
  }
  
  public static Context d(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  private static String e(Context paramContext)
  {
    Object localObject2 = getApplicationInfoname;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = paramContext.getPackageName();
      localObject2 = paramContext.getApplicationContext().getPackageManager();
    }
    try
    {
      paramContext = ((PackageManager)localObject2).getApplicationInfo(paramContext.getPackageName(), 0);
      if (paramContext != null) {
        localObject1 = ((PackageManager)localObject2).getApplicationLabel(paramContext).toString();
      }
      return (String)localObject1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     eik
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */