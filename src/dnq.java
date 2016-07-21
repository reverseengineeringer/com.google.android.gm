import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.Settings.System;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class dnq
  extends cfj
{
  protected final void a(Context paramContext, int paramInt)
  {
    Object localObject3 = dmv.a().h(paramContext);
    dmv localdmv = dmv.a();
    cfm localcfm = cfm.a(paramContext);
    boolean bool;
    Object localObject1;
    Object localObject2;
    if (paramInt <= 0)
    {
      label151:
      label160:
      int i;
      if (localdmv.b(paramContext, null, "action-strip-action-reply-all"))
      {
        if (localdmv.b(paramContext, null, "action-strip-action-reply-all"))
        {
          bool = localdmv.a(paramContext, null, "action-strip-action-reply-all", false);
          e.putBoolean("default-reply-all", bool).apply();
          localObject1 = b;
          localObject2 = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
          ((Intent)localObject2).setPackage(((Context)localObject1).getPackageName());
          ((Context)localObject1).startService((Intent)localObject2);
        }
      }
      else
      {
        localObject1 = paramContext.getSharedPreferences("Gmail", 0).getString("swipe-key", "archive");
        if (!"delete".equals(localObject1)) {
          break label761;
        }
        localcfm.b("delete");
        Iterator localIterator = ((List)localObject3).iterator();
        if (!localIterator.hasNext()) {
          break label852;
        }
        String str1 = (String)localIterator.next();
        localObject1 = dnm.a(paramContext, str1);
        if (localdmv.b(paramContext, str1, "enable-notifications")) {
          ((cfg)localObject1).a(localdmv.a(paramContext, str1, "enable-notifications", true));
        }
        ((cfg)localObject1).l();
        dra localdra = drd.a(paramContext, str1, false);
        i = 0;
        label235:
        if (i < a.size())
        {
          dqz localdqz = localdra.a(i);
          String str2 = localdqz.b();
          localObject1 = null;
          if (dmv.f(paramContext, str1).equals(str2))
          {
            localObject3 = new HashSet();
            localObject1 = String.valueOf(Boolean.toString(true));
            ((Set)localObject3).add(String.valueOf(localObject1).length() + 11 + 1 + (String)localObject1);
            localObject2 = localdmv.a(paramContext, str1, "ringtone", null);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = localdmv.a(paramContext, null, "ringtone", null);
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = Settings.System.DEFAULT_NOTIFICATION_URI.toString();
            }
            localObject1 = String.valueOf(localObject2);
            ((Set)localObject3).add(String.valueOf(localObject1).length() + 11 + 2 + (String)localObject1);
            if (!localdmv.a(paramContext, str1, "vibrate", false)) {
              break label831;
            }
            localObject1 = paramContext.getResources().getString(dge.eL);
            label457:
            localObject1 = String.valueOf(localdmv.a(paramContext, str1, "vibrateWhen", (String)localObject1));
            ((Set)localObject3).add(String.valueOf(localObject1).length() + 11 + 3 + (String)localObject1);
            localObject1 = String.valueOf(Boolean.toString(localdmv.a(paramContext, str1, "unobtrusive", true)));
            ((Set)localObject3).add(String.valueOf(localObject1).length() + 11 + 4 + (String)localObject1);
            localObject1 = localObject3;
          }
          localObject1 = localdmv.b(paramContext, str1, str2, (Set)localObject1);
          if (localObject1 != null)
          {
            localObject2 = new dnn(paramContext, str1, dfh.c(paramContext, str1, localdqz.b()), false);
            localObject3 = dmv.a((Set)localObject1, 1);
            if (localObject3 != null) {
              ((cfk)localObject2).a(Boolean.parseBoolean((String)localObject3));
            }
            localObject3 = dmv.a((Set)localObject1, 2);
            if (localObject3 != null) {
              ((cfk)localObject2).b((String)localObject3);
            }
            ((cfk)localObject2).b(dmv.a(paramContext, (Set)localObject1));
            localObject1 = dmv.a((Set)localObject1, 4);
            if (localObject1 != null) {
              if (Boolean.parseBoolean((String)localObject1)) {
                break label846;
              }
            }
          }
        }
      }
      label761:
      label831:
      label846:
      for (bool = true;; bool = false)
      {
        ((cfk)localObject2).c(bool);
        ((cfk)localObject2).l();
        i += 1;
        break label235;
        break label160;
        localObject2 = (Boolean)d.a(paramContext);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Boolean.valueOf(paramContext.getResources().getBoolean(dfu.b));
        }
        bool = ((Boolean)localObject1).booleanValue();
        break;
        if (!"disabled".equals(localObject1)) {
          break label151;
        }
        e.putBoolean("conversation-list-swipe", false).apply();
        localObject1 = b;
        localObject2 = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
        ((Intent)localObject2).setPackage(((Context)localObject1).getPackageName());
        ((Context)localObject1).startService((Intent)localObject2);
        break label151;
        localObject1 = paramContext.getResources().getString(dge.eK);
        break label457;
      }
    }
    label852:
    if (paramInt < 2)
    {
      localcfm.a(localdmv.c(paramContext));
      localcfm.b(localdmv.a(paramContext, null, "display_sender_images_patterns_set", Collections.emptySet()));
    }
    if (paramInt < 3)
    {
      localObject1 = paramContext.getSharedPreferences("Gmail", 0);
      if (((SharedPreferences)localObject1).contains("conversation-list-sender-image")) {
        break label1413;
      }
      if (!((SharedPreferences)localObject1).contains("hide-checkboxes"))
      {
        if (!((SharedPreferences)localObject1).contains("allow-batch")) {
          break label1413;
        }
        bool = ((SharedPreferences)localObject1).getBoolean("allow-batch", true);
        e.putBoolean("conversation-list-sender-image", bool).apply();
        localObject1 = b;
        localObject2 = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
        ((Intent)localObject2).setPackage(((Context)localObject1).getPackageName());
        ((Context)localObject1).startService((Intent)localObject2);
      }
    }
    else if (paramInt < 4)
    {
      bool = localdmv.g(paramContext).contains("archive");
      e.putBoolean("confirm-archive", bool).apply();
      localObject1 = b;
      localObject2 = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
      ((Intent)localObject2).setPackage(((Context)localObject1).getPackageName());
      ((Context)localObject1).startService((Intent)localObject2);
      bool = localdmv.g(paramContext).contains("delete");
      e.putBoolean("confirm-delete", bool).apply();
      localObject1 = b;
      localObject2 = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
      ((Intent)localObject2).setPackage(((Context)localObject1).getPackageName());
      ((Context)localObject1).startService((Intent)localObject2);
      bool = localdmv.g(paramContext).contains("send");
      e.putBoolean("confirm-send", bool).apply();
      localObject1 = b;
      localObject2 = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
      ((Intent)localObject2).setPackage(((Context)localObject1).getPackageName());
      ((Context)localObject1).startService((Intent)localObject2);
      if (localdmv.f(paramContext) == null) {
        break label1429;
      }
      paramInt = 1;
      label1242:
      if (paramInt == 0) {
        break label1459;
      }
      if (!"newer".equals(localdmv.e(paramContext))) {
        break label1434;
      }
      paramInt = 2;
      label1263:
      localcfm.d(paramInt);
      localcfm.d(localdmv.a(paramContext, null, "conversation-mode2", true));
      paramContext = localdmv.a(paramContext, null, "snap-headers", paramContext.getResources().getString(dge.eJ));
      paramInt = 0;
      label1308:
      if (paramInt >= 3) {
        break label1476;
      }
      if (!TextUtils.equals(paramContext, new String[] { "always", "portrait", "never" }[paramInt])) {
        break label1464;
      }
    }
    for (;;)
    {
      if (paramInt != -1) {}
      for (paramInt = new int[] { 0, 1, 2 }[paramInt];; paramInt = 0)
      {
        e.putInt("snap-header-mode", paramInt).apply();
        return;
        if (!((SharedPreferences)localObject1).getBoolean("hide-checkboxes", false))
        {
          bool = true;
          break;
        }
        bool = false;
        break;
        label1413:
        bool = ((SharedPreferences)localObject1).getBoolean("conversation-list-sender-image", true);
        break;
        label1429:
        paramInt = 0;
        break label1242;
        label1434:
        if ("older".equals(localdmv.e(paramContext)))
        {
          paramInt = 1;
          break label1263;
        }
        paramInt = 3;
        break label1263;
        label1459:
        paramInt = 0;
        break label1263;
        label1464:
        paramInt += 1;
        break label1308;
      }
      label1476:
      paramInt = -1;
    }
  }
}

/* Location:
 * Qualified Name:     dnq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */