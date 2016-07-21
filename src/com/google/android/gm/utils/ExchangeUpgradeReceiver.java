package com.google.android.gm.utils;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.android.exchange.service.CalendarSyncAdapterService;
import com.android.exchange.service.ContactsSyncAdapterService;
import com.android.exchange.service.EasService;
import com.android.exchange.service.EmailSyncAdapterService;
import cvm;

public class ExchangeUpgradeReceiver
  extends BroadcastReceiver
{
  private static boolean a(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getServiceInfo(new ComponentName("com.google.android.gm.exchange", "com.android.exchange.service.EasService"), 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      cvm.b("EasBundling", paramContext, "Gmail: failed to resolve standalone Exchange EasService", new Object[0]);
    }
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("android.intent.action.PACKAGE_REPLACED".equals(paramIntent.getAction())) && (!"com.google.android.gm.exchange".equals(paramIntent.getData().getSchemeSpecificPart()))) {
      return;
    }
    boolean bool = a(paramContext);
    cvm.d("EasBundling", "Gmail: isExchangeLegacy=%s action=%s data=%s", new Object[] { Boolean.valueOf(bool), paramIntent.getAction(), paramIntent.getDataString() });
    int i;
    label110:
    int j;
    label113:
    ComponentName localComponentName;
    if (!bool)
    {
      bool = true;
      paramIntent = EasService.class.getName();
      String str1 = EmailSyncAdapterService.class.getName();
      String str2 = ContactsSyncAdapterService.class.getName();
      String str3 = CalendarSyncAdapterService.class.getName();
      if (!bool) {
        break label246;
      }
      i = 1;
      j = 0;
      if (j >= 4) {
        break label257;
      }
      localComponentName = new ComponentName(paramContext, new String[] { paramIntent, str1, str2, str3 }[j]);
      if (j != 3) {
        break label251;
      }
    }
    label246:
    label251:
    for (int k = 0;; k = 1)
    {
      cvm.b("EasBundling", "setting %s to enabled=%s (%s). initial=%s flags=%s", new Object[] { localComponentName, Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(paramContext.getPackageManager().getComponentEnabledSetting(localComponentName)), Integer.valueOf(k) });
      paramContext.getPackageManager().setComponentEnabledSetting(localComponentName, i, k);
      j += 1;
      break label113;
      bool = false;
      break;
      i = 0;
      break label110;
    }
    label257:
    cvm.b("EasBundling", "done with enable/disable loop", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.utils.ExchangeUpgradeReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */