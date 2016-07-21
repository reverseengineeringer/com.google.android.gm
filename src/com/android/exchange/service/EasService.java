package com.android.exchange.service;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import bdv;
import bnq;
import bnz;
import bob;
import bqc;
import bqi;
import brv;
import brw;
import bsr;
import bst;
import bsu;
import btg;
import buo;
import but;
import com.android.emailcommon.provider.Mailbox;
import cuh;
import cvm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kl;
import nx;

public class EasService
  extends Service
{
  public static final String a;
  public final bst b = new bst(this);
  public final brw c = new brw(this, b);
  
  static
  {
    String str1 = String.valueOf("syncInterval=");
    String str2 = String.valueOf(Integer.toString(-2));
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      a = str1;
      return;
    }
  }
  
  private final void a()
  {
    boolean bool3 = true;
    for (;;)
    {
      boolean bool5;
      try
      {
        Object localObject1 = getSharedPreferences("AndroidMail.Main", 0);
        boolean bool4 = ((SharedPreferences)localObject1).getBoolean("need_eas16_resync_calendar", false);
        bool5 = ((SharedPreferences)localObject1).getBoolean("need_eas16_resync_contacts", false);
        try
        {
          if (kl.a(this, "android.permission.WRITE_CALENDAR") == 0)
          {
            i = kl.a(this, "android.permission.READ_CALENDAR");
            if (i == 0)
            {
              bool1 = true;
              bool2 = bool1;
            }
          }
        }
        catch (RuntimeException localRuntimeException1)
        {
          int i;
          HashMap localHashMap;
          cvm.d("Exchange", localRuntimeException1, "Exception while checking Calendar permission", new Object[0]);
          boolean bool2 = false;
          continue;
        }
        try
        {
          if (kl.a(this, "android.permission.WRITE_CONTACTS") != 0) {
            break label284;
          }
          i = kl.a(this, "android.permission.READ_CONTACTS");
          if (i != 0) {
            break label284;
          }
          bool1 = bool3;
        }
        catch (RuntimeException localRuntimeException2)
        {
          cvm.d("Exchange", localRuntimeException2, "Exception while checking Contacts permission", new Object[0]);
          bool1 = false;
          continue;
        }
        cvm.c("Exchange", "needResyncCalendar: %s, hasCalendarPermission: %s, needResyncContacts: %s, hasContactsPermission: %s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool2), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
        if ((!bool4) || (!bool2)) {
          break label272;
        }
        localObject1 = ((SharedPreferences)localObject1).edit();
        localHashMap = new HashMap();
        if ((bool4) && (bool2))
        {
          a(localHashMap);
          ((SharedPreferences.Editor)localObject1).remove("need_eas16_resync_calendar").apply();
        }
        if ((bool5) && (bool1))
        {
          b(localHashMap);
          ((SharedPreferences.Editor)localObject1).remove("need_eas16_resync_contacts").apply();
        }
        return;
      }
      finally {}
      boolean bool1 = false;
      continue;
      label272:
      if ((bool5) && (bool1))
      {
        continue;
        label284:
        bool1 = false;
      }
    }
  }
  
  private final void a(Map<Long, com.android.emailcommon.provider.Account> paramMap)
  {
    Object localObject5 = getContentResolver();
    Object localObject6 = Mailbox.b(this, 65);
    Object localObject3 = new HashSet();
    Object localObject4 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap1 = new HashMap();
    int i = 0;
    while (i < localObject6.length)
    {
      if ((com.android.emailcommon.provider.Account)paramMap.get(Long.valueOf(g)) == null)
      {
        localObject1 = com.android.emailcommon.provider.Account.a(this, g);
        paramMap.put(Long.valueOf(D), localObject1);
        ((Map)localObject4).put(d, localObject1);
      }
      i += 1;
    }
    Cursor localCursor = ((ContentResolver)localObject5).query(CalendarContract.Calendars.CONTENT_URI, new String[] { "_id", "account_name", "_sync_id" }, null, null, null);
    long l;
    Object localObject2;
    if (localCursor != null) {
      while (localCursor.moveToNext())
      {
        com.android.emailcommon.provider.Account localAccount = (com.android.emailcommon.provider.Account)((Map)localObject4).get(localCursor.getString(localCursor.getColumnIndex("account_name")));
        if (localAccount != null)
        {
          l = localCursor.getLong(localCursor.getColumnIndex("_id"));
          localObject1 = localCursor.getString(localCursor.getColumnIndex("_sync_id"));
          i = 0;
          for (;;)
          {
            if (i < localObject6.length)
            {
              if ((g == D) && (d.equals(localObject1))) {
                localHashMap1.put(Long.valueOf(l), localObject6[i]);
              }
            }
            else
            {
              localObject2 = (Set)localHashMap2.get(d);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = new HashSet();
                localHashMap2.put(d, localObject1);
              }
              ((Set)localObject1).add(Long.valueOf(l));
              break;
            }
            i += 1;
          }
        }
      }
    }
    Object localObject1 = localHashMap2.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject6 = (String)((Iterator)localObject1).next();
      localObject2 = (Set)localHashMap2.get(localObject6);
      localObject6 = (com.android.emailcommon.provider.Account)((Map)localObject4).get(localObject6);
      if ((((Set)localObject2).size() > 1) && (l != null) && (bnq.a(l).doubleValue() >= 16.0D))
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Set)localObject3).add((Long)((Iterator)localObject2).next());
        }
      }
    }
    localObject1 = ((ContentResolver)localObject5).query(CalendarContract.Events.CONTENT_URI, new String[] { "calendar_id", "account_name" }, "original_id NOTNULL", null, null);
    if (localObject1 != null)
    {
      while (((Cursor)localObject1).moveToNext())
      {
        l = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex("calendar_id"));
        localObject2 = (com.android.emailcommon.provider.Account)((Map)localObject4).get(((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("account_name")));
        if ((localObject2 != null) && (l != null) && (bnq.a(l).doubleValue() >= 16.0D)) {
          ((Set)localObject3).add(Long.valueOf(l));
        }
      }
      ((Cursor)localObject1).close();
    }
    cvm.c("Exchange", "Marking %d calendars for resync", new Object[] { Integer.valueOf(((Set)localObject3).size()) });
    localObject1 = ((Set)localObject3).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Long)((Iterator)localObject1).next();
      localObject2 = (Mailbox)localHashMap1.get(localObject3);
      localObject3 = String.valueOf(localObject3);
      if (localObject2 == null)
      {
        cvm.d("Exchange", "Mailbox is null. Skipping sync for calendar id: %s", new Object[] { localObject3 });
        buo.a().a("Eas16SyncError", "sync_calendar", "null_mailbox", 0L);
      }
      else
      {
        cvm.c("Exchange", "Wiping calendar id: %s", new Object[] { localObject3 });
        localObject4 = (com.android.emailcommon.provider.Account)paramMap.get(Long.valueOf(g));
        localObject5 = bnz.a(CalendarContract.Events.CONTENT_URI, d, bnq.c);
        getContentResolver().delete((Uri)localObject5, "calendar_id=?", new String[] { localObject3 });
        Mailbox.a(getContentResolver(), new android.accounts.Account(d, bnq.c), ((Mailbox)localObject2).c());
      }
    }
  }
  
  private final void b(Map<Long, com.android.emailcommon.provider.Account> paramMap)
  {
    Object localObject3 = new HashSet();
    Object localObject4 = new ArrayList();
    Object localObject5 = Mailbox.b(this, 66);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    int i = 0;
    while (i < localObject5.length)
    {
      if ((com.android.emailcommon.provider.Account)paramMap.get(Long.valueOf(g)) == null)
      {
        localObject1 = com.android.emailcommon.provider.Account.a(this, g);
        paramMap.put(Long.valueOf(D), localObject1);
      }
      i += 1;
    }
    i = 0;
    Object localObject2;
    while (i < localObject5.length)
    {
      localHashMap1.put(Long.valueOf(localObject5[i].c()), localObject5[i]);
      localObject2 = (Set)localHashMap2.get(Long.valueOf(g));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        localHashMap2.put(Long.valueOf(g), localObject1);
      }
      ((Set)localObject1).add(Long.valueOf(localObject5[i].c()));
      i += 1;
    }
    Object localObject1 = localHashMap2.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject5 = (Long)((Iterator)localObject1).next();
      localObject2 = (Set)localHashMap2.get(localObject5);
      if (((Set)localObject2).size() > 1)
      {
        localObject5 = com.android.emailcommon.provider.Account.a(this, ((Long)localObject5).longValue());
        if ((localObject5 != null) && (l != null) && (bnq.a(l).doubleValue() >= 16.0D))
        {
          ((List)localObject4).remove(localObject5);
          ((List)localObject4).add(localObject5);
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Set)localObject3).add((Mailbox)localHashMap1.get((Long)((Iterator)localObject2).next()));
          }
        }
      }
    }
    localObject1 = ((List)localObject4).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (com.android.emailcommon.provider.Account)((Iterator)localObject1).next();
      localObject2 = bob.a(ContactsContract.RawContacts.CONTENT_URI, d);
      localObject4 = d;
      getContentResolver().delete((Uri)localObject2, "account_name=?", new String[] { localObject4 });
    }
    localObject1 = ((Set)localObject3).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Mailbox)((Iterator)localObject1).next();
      localObject3 = (com.android.emailcommon.provider.Account)paramMap.get(Long.valueOf(g));
      Mailbox.a(getContentResolver(), new android.accounts.Account(d, bnq.c), ((Mailbox)localObject2).c());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return c;
  }
  
  public void onCreate()
  {
    if (!cuh.a()) {
      bsr.a(this);
    }
    cvm.c("Exchange", "EasService.onCreate", new Object[0]);
    super.onCreate();
    bce.a = getCacheDir();
    bdv.i(this);
    bnq.a(this);
    c.b();
    cvm.c("Exchange", "EasService.onCreate stoppedOldService=%s", new Object[] { Boolean.valueOf(btg.a(this, "com.android.exchange.service.EasService")) });
    a();
    startService(new Intent(this, EasService.class));
    new brv(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  public void onDestroy()
  {
    cvm.c("Exchange", "onDestroy", new Object[0]);
    bst localbst = b;
    a.lock();
    int i = 0;
    try
    {
      while (i < b.a())
      {
        ((bsu)b.c(i)).a();
        i += 1;
      }
      return;
    }
    finally
    {
      a.unlock();
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && ((cuh.a()) || (TextUtils.equals(bnq.f, paramIntent.getAction()))))
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        if (!paramIntent.getBooleanExtra("ServiceProxy.FORCE_SHUTDOWN", false)) {
          break label64;
        }
        cvm.b("Exchange", "Forced shutdown, killing process", new Object[0]);
        System.exit(-1);
      }
    }
    label64:
    do
    {
      return 1;
      paramInt1 = 0;
      break;
      if (paramIntent.getBooleanExtra("START_PING", false))
      {
        cvm.b("Exchange", "Restarting ping", new Object[0]);
        bqi.b((android.accounts.Account)paramIntent.getParcelableExtra("ACCOUNT"), paramIntent.getLongExtra("PING_DELAY", 0L));
        return 1;
      }
    } while (!paramIntent.getBooleanExtra("SYNC_OUTBOX", false));
    cvm.b("Exchange", "Requesting outbox sync after delay", new Object[0]);
    bqc.a((android.accounts.Account)paramIntent.getParcelableExtra("ACCOUNT"), paramIntent.getLongExtra("MAILBOX_ID", -1L));
    return 1;
  }
}

/* Location:
 * Qualified Name:     com.android.exchange.service.EasService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */