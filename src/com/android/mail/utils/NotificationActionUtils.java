package com.android.mail.utils;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.SystemClock;
import android.widget.RemoteViews;
import btw;
import bub;
import buc;
import bud;
import bue;
import buj;
import cbk;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Message;
import cus;
import cvm;
import cvw;
import cvz;
import cwk;
import cwp;
import hc;
import hf;
import ht;
import is;
import iu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jg;

public final class NotificationActionUtils
{
  public static final cwk<NotificationActionUtils.NotificationAction> a = new cwk();
  public static final Set<Conversation> b = new HashSet();
  public static final cwp c = new cwp();
  private static long d = -1L;
  
  private static int a(cvw paramcvw, int paramInt)
  {
    switch (cvu.a[paramcvw.ordinal()])
    {
    default: 
      return paramInt;
    case 1: 
      return bub.ax;
    case 2: 
      return bub.ay;
    case 3: 
      return bub.av;
    }
    return bub.aw;
  }
  
  private static PendingIntent a(Context paramContext, Account paramAccount, Conversation paramConversation, Message paramMessage, Folder paramFolder, Intent paramIntent, cvw paramcvw, int paramInt, long paramLong)
  {
    Uri localUri = f;
    paramMessage = new NotificationActionUtils.NotificationAction(paramcvw, paramAccount, paramConversation, paramMessage, paramFolder, paramLong, 1, paramInt);
    switch (cvu.a[paramcvw.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Invalid NotificationActionType");
    case 1: 
    case 2: 
      paramMessage = jg.a(paramContext);
      if (paramcvw == cvw.d) {}
      for (boolean bool = true;; bool = false)
      {
        paramAccount = a(paramContext, paramAccount, localUri, bool);
        paramAccount.setPackage(paramContext.getPackageName());
        paramAccount.setData(a(c));
        paramAccount.putExtra("extra-notification-folder", paramFolder);
        paramAccount.putExtra("extra-notification-conversation", c);
        paramMessage.a(paramIntent).a(paramAccount);
        return paramMessage.a(paramInt);
      }
    }
    if (paramcvw == cvw.a) {}
    for (paramAccount = "com.android.mail.action.notification.ARCHIVE";; paramAccount = "com.android.mail.action.notification.DELETE")
    {
      paramAccount = new Intent(paramAccount);
      paramAccount.setPackage(paramContext.getPackageName());
      paramAccount.setData(a(c));
      a(paramAccount, paramMessage);
      return PendingIntent.getService(paramContext, paramInt, paramAccount, 134217728);
    }
  }
  
  private static Intent a(Context paramContext, Account paramAccount, Uri paramUri, boolean paramBoolean)
  {
    paramContext = cbk.a(paramContext, paramAccount, paramUri, paramBoolean);
    paramContext.putExtra("notification", true);
    return paramContext;
  }
  
  private static Uri a(Uri paramUri)
  {
    return paramUri.buildUpon().appendQueryParameter("type", "wear").build();
  }
  
  private static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    a.b(paramInt);
    if (paramBoolean) {
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(paramInt);
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, hf paramhf, ht paramht, Account paramAccount, Conversation paramConversation, Message paramMessage, Folder paramFolder, int paramInt, long paramLong, Set<String> paramSet)
  {
    Object localObject1 = new ArrayList(paramSet.size());
    paramSet = paramSet.iterator();
    Object localObject2;
    while (paramSet.hasNext())
    {
      localObject2 = (String)paramSet.next();
      ((List)localObject1).add((cvw)cvw.g.get(localObject2));
    }
    paramSet = new ArrayList(((List)localObject1).size());
    if (paramFolder.d(8194))
    {
      if (((List)localObject1).contains(cvw.a)) {
        paramSet.add(cvw.a);
      }
      if (((List)localObject1).contains(cvw.b)) {
        paramSet.add(cvw.b);
      }
      if (((List)localObject1).contains(cvw.c)) {
        paramSet.add(cvw.c);
      }
      if (((List)localObject1).contains(cvw.d)) {
        paramSet.add(cvw.d);
      }
      localObject1 = paramSet.iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cvw)((Iterator)localObject1).next();
        paramSet = f;
        Object localObject3 = new NotificationActionUtils.NotificationAction((cvw)localObject2, paramAccount, paramConversation, paramMessage, paramFolder, paramLong, 0, paramInt);
        label557:
        int i;
        switch (cvu.a[localObject2.ordinal()])
        {
        default: 
          throw new IllegalArgumentException("Invalid NotificationActionType");
          if (paramFolder.a())
          {
            if (((List)localObject1).contains(cvw.b)) {
              paramSet.add(cvw.b);
            }
            if (((List)localObject1).contains(cvw.c)) {
              paramSet.add(cvw.c);
            }
            if (!((List)localObject1).contains(cvw.d)) {
              break;
            }
            paramSet.add(cvw.d);
            break;
          }
          if (((List)localObject1).contains(cvw.a)) {
            paramSet.add(cvw.a);
          }
          if (((List)localObject1).contains(cvw.b)) {
            paramSet.add(cvw.b);
          }
          if (((List)localObject1).contains(cvw.c)) {
            paramSet.add(cvw.c);
          }
          if (!((List)localObject1).contains(cvw.d)) {
            break;
          }
          paramSet.add(cvw.d);
          break;
        case 1: 
          localObject3 = jg.a(paramContext);
          paramSet = a(paramContext, paramAccount, paramSet, false);
          paramSet.setPackage(paramContext.getPackageName());
          paramSet.setData(c);
          paramSet.putExtra("extra-notification-folder", paramFolder);
          ((jg)localObject3).a(paramIntent).a(paramSet);
          paramSet = ((jg)localObject3).a(paramInt);
          i = ((cvw)localObject2).a(paramFolder);
          localObject3 = paramContext.getString(((cvw)localObject2).b(paramFolder));
          paramSet = new hc(i, (CharSequence)localObject3, paramSet).a();
          u.add(paramSet);
          paramSet = a(paramContext, paramAccount, paramConversation, paramMessage, paramFolder, paramIntent, (cvw)localObject2, paramInt, paramLong);
          paramSet = new hc(a((cvw)localObject2, i), (CharSequence)localObject3, paramSet);
          if ((localObject2 == cvw.c) || (localObject2 == cvw.d))
          {
            Object localObject4 = paramContext.getResources().getStringArray(btw.f);
            iu localiu = new iu("wear_reply");
            b = ((CharSequence)localObject3);
            c = ((CharSequence[])localObject4);
            localObject4 = new is(a, b, c, d, e);
            if (a == null) {
              a = new ArrayList();
            }
            a.add(localObject4);
          }
          paramht.a(paramSet.a());
          cvm.b("NotifActionUtils", "Adding wearable action: %s", new Object[] { localObject3 });
          if ((localObject2 == cvw.a) || (localObject2 == cvw.b)) {
            if (localObject2 != cvw.a) {}
          }
          break;
        case 2: 
        case 3: 
        case 4: 
          for (paramSet = cvw.b;; paramSet = cvw.a)
          {
            i = paramSet.a(paramFolder);
            localObject2 = paramContext.getString(paramSet.b(paramFolder));
            localObject3 = a(paramContext, paramAccount, paramConversation, paramMessage, paramFolder, paramIntent, paramSet, paramInt, paramLong);
            paramht.a(new hc(a(paramSet, i), (CharSequence)localObject2, (PendingIntent)localObject3).a());
            cvm.b("NotifActionUtils", "Adding wearable action: %s", new Object[] { localObject2 });
            break;
            localObject3 = jg.a(paramContext);
            paramSet = a(paramContext, paramAccount, paramSet, true);
            paramSet.setPackage(paramContext.getPackageName());
            paramSet.setData(c);
            paramSet.putExtra("extra-notification-folder", paramFolder);
            ((jg)localObject3).a(paramIntent).a(paramSet);
            paramSet = ((jg)localObject3).a(paramInt);
            break label557;
            paramSet = new Intent("com.android.mail.action.notification.ARCHIVE");
            paramSet.setPackage(paramContext.getPackageName());
            paramSet.setData(c);
            a(paramSet, (NotificationActionUtils.NotificationAction)localObject3);
            paramSet = PendingIntent.getService(paramContext, paramInt, paramSet, 134217728);
            break label557;
            paramSet = new Intent("com.android.mail.action.notification.DELETE");
            paramSet.setPackage(paramContext.getPackageName());
            paramSet.setData(c);
            a(paramSet, (NotificationActionUtils.NotificationAction)localObject3);
            paramSet = PendingIntent.getService(paramContext, paramInt, paramSet, 134217728);
            break label557;
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, Account paramAccount, Folder paramFolder)
  {
    String str = null;
    Object localObject;
    if (paramAccount == null)
    {
      localObject = null;
      if (paramFolder != null) {
        break label112;
      }
    }
    for (;;)
    {
      cvm.c("NotifActionUtils", "resendNotifications account: %s, folder: %s", new Object[] { localObject, str });
      localObject = new Intent("com.android.mail.action.RESEND_NOTIFICATIONS");
      ((Intent)localObject).setPackage(paramContext.getPackageName());
      if (paramAccount != null) {
        ((Intent)localObject).putExtra("accountUri", g);
      }
      if (paramFolder != null) {
        ((Intent)localObject).putExtra("folderUri", c.b);
      }
      paramContext.startService((Intent)localObject);
      return;
      localObject = cvm.a("NotifActionUtils", c);
      break;
      label112:
      str = cvm.a("NotifActionUtils", d);
    }
  }
  
  public static void a(Context paramContext, NotificationActionUtils.NotificationAction paramNotificationAction)
  {
    cvm.c("NotifActionUtils", "registerUndoTimeout for %s", new Object[] { a });
    if (d == -1L) {
      d = paramContext.getResources().getInteger(bud.I);
    }
    ((AlarmManager)paramContext.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + d, g(paramContext, paramNotificationAction));
  }
  
  private static void a(Intent paramIntent, NotificationActionUtils.NotificationAction paramNotificationAction)
  {
    Parcel localParcel = Parcel.obtain();
    paramNotificationAction.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramIntent.putExtra("com.android.mail.extra.EXTRA_NOTIFICATION_ACTION", localParcel.marshall());
  }
  
  public static void b(Context paramContext, NotificationActionUtils.NotificationAction paramNotificationAction)
  {
    cvm.c("NotifActionUtils", "cancelUndoTimeout for %s", new Object[] { a });
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(g(paramContext, paramNotificationAction));
  }
  
  public static void c(Context paramContext, NotificationActionUtils.NotificationAction paramNotificationAction)
  {
    cvm.c("NotifActionUtils", "processDestructiveAction: %s", new Object[] { a });
    Object localObject1 = a;
    Object localObject2 = c;
    paramNotificationAction = d;
    paramContext = paramContext.getContentResolver();
    localObject2 = c.buildUpon().appendQueryParameter("forceUiNotifications", Boolean.TRUE.toString()).build();
    switch (cvu.a[localObject1.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("The specified NotificationActionType is not a destructive action.");
    case 3: 
      if (paramNotificationAction.d(8194))
      {
        paramNotificationAction = new ContentValues(1);
        paramNotificationAction.put("operation", "archive");
        paramContext.update((Uri)localObject2, paramNotificationAction, null, null);
        return;
      }
      localObject1 = new ContentValues(1);
      ((ContentValues)localObject1).put("folders_updated", c.b.buildUpon().appendPath(Boolean.FALSE.toString()).toString());
      paramContext.update((Uri)localObject2, (ContentValues)localObject1, null, null);
      return;
    }
    paramContext.delete((Uri)localObject2, null, null);
  }
  
  public static void d(Context paramContext, NotificationActionUtils.NotificationAction paramNotificationAction)
  {
    cvm.c("NotifActionUtils", "createUndoNotification for %s", new Object[] { a });
    int j = g;
    cvm.c("NotifActionUtils", "createUndoNotification for %s", new Object[] { a });
    Object localObject1 = new hf(paramContext);
    ((hf)localObject1).a(bub.aE);
    ((hf)localObject1).a(e);
    w = "email";
    Object localObject2 = new RemoteViews(paramContext.getPackageName(), bue.am);
    int k = buc.aW;
    int i;
    switch (cvu.a[a.ordinal()])
    {
    default: 
      throw new IllegalStateException("There is no action text for this NotificationActionType.");
    case 3: 
      if (d.d(8194)) {
        i = buj.du;
      }
      break;
    }
    long l;
    for (;;)
    {
      ((RemoteViews)localObject2).setTextViewText(k, paramContext.getString(i));
      String str = paramContext.getPackageName();
      Object localObject3 = new Intent("com.android.mail.action.notification.UNDO");
      ((Intent)localObject3).setPackage(str);
      ((Intent)localObject3).setData(c.c);
      a((Intent)localObject3, paramNotificationAction);
      localObject3 = PendingIntent.getService(paramContext, j, (Intent)localObject3, 268435456);
      ((RemoteViews)localObject2).setOnClickPendingIntent(buc.fb, (PendingIntent)localObject3);
      B.contentView = ((RemoteViews)localObject2);
      localObject2 = new Intent("com.android.mail.action.notification.DESTRUCT");
      ((Intent)localObject2).setPackage(str);
      ((Intent)localObject2).setData(c.c);
      a((Intent)localObject2, paramNotificationAction);
      ((hf)localObject1).a(PendingIntent.getService(paramContext, j, (Intent)localObject2, 268435456));
      localObject1 = ((hf)localObject1).b();
      ((NotificationManager)paramContext.getSystemService("notification")).notify(j, (Notification)localObject1);
      a.a(j, paramNotificationAction);
      paramContext = c;
      l = e;
      i = cwp.a(a, c, j);
      if (i < 0) {
        break;
      }
      b[i] = l;
      return;
      i = buj.dw;
      continue;
      i = buj.dv;
    }
    i ^= 0xFFFFFFFF;
    if (c >= a.length)
    {
      k = c + 1;
      paramNotificationAction = new int[k];
      localObject1 = new long[k];
      System.arraycopy(a, 0, paramNotificationAction, 0, a.length);
      System.arraycopy(b, 0, localObject1, 0, b.length);
      a = paramNotificationAction;
      b = ((long[])localObject1);
    }
    if (c - i != 0)
    {
      System.arraycopy(a, i, a, i + 1, c - i);
      System.arraycopy(b, i, b, i + 1, c - i);
    }
    a[i] = j;
    b[i] = l;
    c += 1;
  }
  
  public static void e(Context paramContext, NotificationActionUtils.NotificationAction paramNotificationAction)
  {
    cvm.c("NotifActionUtils", "cancelUndoNotification for %s", new Object[] { a });
    Account localAccount = b;
    Folder localFolder = d;
    paramNotificationAction = c;
    int i = cvz.a(localAccount.c(), localFolder);
    b.add(paramNotificationAction);
    a(paramContext, i, false);
    a(paramContext, localAccount, localFolder);
  }
  
  public static void f(Context paramContext, NotificationActionUtils.NotificationAction paramNotificationAction)
  {
    cvm.c("NotifActionUtils", "processUndoNotification, %s", new Object[] { a });
    Account localAccount = b;
    Folder localFolder = d;
    int i = cvz.a(localAccount.c(), localFolder);
    a(paramContext, i, true);
    c.a(i);
    c(paramContext, paramNotificationAction);
  }
  
  private static PendingIntent g(Context paramContext, NotificationActionUtils.NotificationAction paramNotificationAction)
  {
    Intent localIntent = new Intent("com.android.mail.action.notification.UNDO_TIMEOUT");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.setData(c.c);
    a(localIntent, paramNotificationAction);
    return PendingIntent.getService(paramContext, b.hashCode() ^ d.hashCode(), localIntent, 0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.NotificationActionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */