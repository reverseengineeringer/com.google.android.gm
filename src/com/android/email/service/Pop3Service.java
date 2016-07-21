package com.android.email.service;

import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.TrafficStats;
import android.os.IBinder;
import awr;
import axg;
import axi;
import axk;
import baa;
import bal;
import bbf;
import bbg;
import bbk;
import bbx;
import bbz;
import bcf;
import bcl;
import bcs;
import bdf;
import bdg;
import bdi;
import bdk;
import beb;
import bec;
import bed;
import bgt;
import cfg;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import cvm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Pop3Service
  extends Service
{
  private bal a = new bal();
  
  public static int a(Context paramContext, Account paramAccount, Mailbox paramMailbox, int paramInt, bbk parambbk)
  {
    TrafficStats.setThreadStatsTag(bcf.a(paramAccount));
    bbx localbbx = bbz.a(paramContext);
    try
    {
      b(paramContext, paramAccount, paramMailbox, paramInt, parambbk);
      if (localbbx != null) {
        localbbx.b(D, true);
      }
      return 0;
    }
    catch (bdi paramContext)
    {
      cvm.a("Pop3Service", paramContext, "synchronizeMailbox", new Object[0]);
      if (((paramContext instanceof bcs)) && (localbbx != null)) {
        localbbx.a(D, true);
      }
      throw paramContext;
    }
  }
  
  private static bdk a(Context paramContext, Account paramAccount, axi paramaxi, ArrayList<axk> paramArrayList, Mailbox paramMailbox)
  {
    cvm.a("Pop3Service", "Loading %d new messages", new Object[] { Integer.valueOf(paramArrayList.size()) });
    bdk localbdk = new bdk();
    for (;;)
    {
      try
      {
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          axk localaxk = (axk)paramArrayList.next();
          cvm.a("Pop3Service", "Fetching at most %d lines for message %s", new Object[] { Integer.valueOf(1684), f });
          localbdk.a(paramaxi.a(localaxk, 1684));
          d += 1;
          if (!d)
          {
            cvm.a("Pop3Service", "Message %s is incomplete, marking as partial", new Object[] { f });
            i = 2;
            baa.a(paramContext, localaxk, paramAccount, paramMailbox, i);
          }
        }
        else
        {
          return localbdk;
        }
      }
      catch (IOException paramContext)
      {
        throw new bdi(1, "Pop3Service.loadUnsyncedMessages", paramContext);
      }
      int i = 1;
    }
  }
  
  private static bdk a(Context paramContext, Account paramAccount, Mailbox paramMailbox, axi paramaxi, HashMap<String, axk> paramHashMap)
  {
    cvm.a("Pop3Service", "Fetching full bodies for partial messages", new Object[0]);
    bdk localbdk = new bdk();
    Cursor localCursor = paramContext.getContentResolver().query(beb.a, beb.g, "accountKey=? AND flagLoaded=5", new String[] { Long.toString(D) }, null);
    while (localCursor != null)
    {
      beb localbeb;
      String str;
      try
      {
        if (!localCursor.moveToNext()) {
          break;
        }
        localbeb = new beb();
        localbeb.a(localCursor);
        str = x;
        cvm.a("Pop3Service", "Fetching full body for message %s", new Object[] { str });
        localaxk = (axk)paramHashMap.get(str);
        if (localaxk == null) {}
      }
      finally
      {
        try
        {
          axk localaxk;
          localbdk.a(paramaxi.a(localaxk, -1));
          e += 1;
          cvm.a("Pop3Service", "Saving full body for message %s", new Object[] { str });
          baa.a(paramContext, localaxk, paramAccount, paramMailbox, 1);
        }
        catch (IOException paramContext)
        {
          throw new bdi(1, "Pop3Service.fetchLoadFullBodyMessages", paramContext);
        }
        paramContext = finally;
        if (localCursor != null) {
          localCursor.close();
        }
      }
      cvm.e("Pop3Service", "Could not find remote message for message %s", new Object[] { str });
      r = 2;
      localbeb.h(paramContext);
    }
    if (localCursor != null) {
      localCursor.close();
    }
    return localbdk;
  }
  
  /* Error */
  private static HashMap<String, bbg> a(ContentResolver paramContentResolver, Mailbox paramMailbox)
  {
    // Byte code:
    //   0: new 193	java/util/HashMap
    //   3: dup
    //   4: invokespecial 221	java/util/HashMap:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getstatic 157	beb:a	Landroid/net/Uri;
    //   12: getstatic 225	bbg:a	[Ljava/lang/String;
    //   15: ldc -29
    //   17: iconst_1
    //   18: anewarray 165	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: getfield 230	com/android/emailcommon/provider/Mailbox:D	J
    //   27: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   30: aastore
    //   31: aconst_null
    //   32: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +51 -> 88
    //   40: aload_0
    //   41: invokeinterface 182 1 0
    //   46: ifeq +42 -> 88
    //   49: new 223	bbg
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 234	bbg:<init>	(Landroid/database/Cursor;)V
    //   57: astore_1
    //   58: aload_2
    //   59: aload_1
    //   60: getfield 236	bbg:d	Ljava/lang/String;
    //   63: aload_1
    //   64: invokevirtual 240	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: goto -32 -> 36
    //   71: astore_2
    //   72: aload_0
    //   73: astore_1
    //   74: aload_2
    //   75: astore_0
    //   76: aload_1
    //   77: ifnull +9 -> 86
    //   80: aload_1
    //   81: invokeinterface 205 1 0
    //   86: aload_0
    //   87: athrow
    //   88: aload_0
    //   89: ifnull +9 -> 98
    //   92: aload_0
    //   93: invokeinterface 205 1 0
    //   98: ldc 52
    //   100: ldc -14
    //   102: iconst_1
    //   103: anewarray 56	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_2
    //   109: invokevirtual 243	java/util/HashMap:size	()I
    //   112: invokestatic 82	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: invokestatic 85	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   119: pop
    //   120: aload_2
    //   121: areturn
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -49 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContentResolver	ContentResolver
    //   0	128	1	paramMailbox	Mailbox
    //   7	52	2	localHashMap	HashMap
    //   71	50	2	localHashMap1	HashMap<String, bbg>
    // Exception table:
    //   from	to	target	type
    //   40	68	71	finally
    //   8	36	122	finally
  }
  
  private static HashSet<String> a(ContentResolver paramContentResolver, long paramLong1, long paramLong2)
  {
    Object localObject2 = null;
    HashSet localHashSet = new HashSet();
    for (;;)
    {
      try
      {
        localObject1 = paramContentResolver.query(beb.a, bbf.a, "mailboxKey=?", new String[] { String.valueOf(paramLong1) }, null);
        if (localObject1 == null) {}
      }
      finally
      {
        Object localObject1 = null;
        continue;
      }
      try
      {
        if (((Cursor)localObject1).moveToNext()) {
          localHashSet.add(((Cursor)localObject1).getString(0));
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    localObject1 = localObject2;
    try
    {
      paramContentResolver = paramContentResolver.query(beb.e, bbf.a, "accountKey=?", new String[] { String.valueOf(paramLong2) }, null);
      while (paramContentResolver != null)
      {
        localObject1 = paramContentResolver;
        if (!paramContentResolver.moveToNext()) {
          break;
        }
        localObject1 = paramContentResolver;
        localHashSet.add(paramContentResolver.getString(0));
      }
      if (paramContentResolver == null) {
        break label187;
      }
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
    paramContentResolver.close();
    label187:
    cvm.a("Pop3Service", "Found %d local deleted messages", new Object[] { Integer.valueOf(localHashSet.size()) });
    return localHashSet;
  }
  
  private static void a(Context paramContext, Account paramAccount, HashMap<String, axk> paramHashMap, HashMap<String, bbg> paramHashMap1)
  {
    cvm.a("Pop3Service", "Processing remote deletes", new Object[0]);
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject = new HashSet(paramHashMap1.keySet());
    ((HashSet)localObject).removeAll(paramHashMap.keySet());
    cvm.a("Pop3Service", "Found %d messages to delete", new Object[] { Integer.valueOf(((HashSet)localObject).size()) });
    paramHashMap = ((HashSet)localObject).iterator();
    while (paramHashMap.hasNext())
    {
      localObject = (String)paramHashMap.next();
      cvm.a("Pop3Service", "Need to delete local message %s", new Object[] { localObject });
      localObject = (bbg)paramHashMap1.get(localObject);
      bgt.b(paramContext, D, b);
      localContentResolver.delete(ContentUris.withAppendedId(beb.a, b), null, null);
      localContentResolver.delete(ContentUris.withAppendedId(beb.e, b), null, null);
    }
  }
  
  private static void a(axi paramaxi, int paramInt1, int paramInt2, HashMap<String, bbg> paramHashMap, HashSet<String> paramHashSet, ArrayList<axk> paramArrayList, HashMap<String, axk> paramHashMap1)
  {
    cvm.a("Pop3Service", "findUnsyncedMessages", new Object[0]);
    paramaxi = paramaxi.b(paramInt2, paramInt2);
    cvm.a("Pop3Service", "Requested remoteMessageCount %d, found %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramaxi.length) });
    int k = 0;
    int j = 100;
    int i = paramaxi.length;
    paramInt2 = 0;
    Object localObject;
    while (paramInt2 < i)
    {
      localObject = paramaxi[paramInt2];
      paramHashMap1.put(f, localObject);
      paramInt2 += 1;
    }
    int m = paramaxi.length;
    i = 0;
    paramInt2 = k;
    for (;;)
    {
      bbg localbbg;
      if (i < m)
      {
        paramHashMap1 = paramaxi[i];
        localObject = f;
        localbbg = (bbg)paramHashMap.get(localObject);
        if (localbbg != null) {
          break label197;
        }
        paramInt2 += 1;
        if (!paramHashSet.contains(localObject)) {
          break label225;
        }
        cvm.a("Pop3Service", "Message %s deleted locally", new Object[] { localObject });
      }
      for (;;)
      {
        if (paramInt2 < j) {
          break label300;
        }
        cvm.a("Pop3Service", "loaded %d messages, stopping", new Object[] { Integer.valueOf(paramInt2) });
        return;
        label197:
        cvm.a("Pop3Service", "found a local message, need %d more remote messages", new Object[] { Integer.valueOf(paramInt1) });
        paramInt2 = 0;
        j = paramInt1;
        break;
        label225:
        if ((localbbg == null) || ((c != 1) && (!beb.a(c))))
        {
          cvm.a("Pop3Service", "Adding %s to unsyncedMessages", new Object[] { localObject });
          paramArrayList.add(paramHashMap1);
        }
        else
        {
          cvm.a("Pop3Service", "Message %s already present locally", new Object[] { localObject });
        }
      }
      label300:
      i += 1;
    }
  }
  
  private static void b(Context paramContext, Account paramAccount, Mailbox paramMailbox, int paramInt, bbk parambbk)
  {
    for (;;)
    {
      Object localObject1;
      bdk localbdk;
      HashMap localHashMap;
      Object localObject2;
      try
      {
        localObject1 = paramContext.getContentResolver();
        localbdk = new bdk();
        if (h != 0)
        {
          cvm.b("Pop3Service", "Account %d: Tried to sync non-inbox mailbox", new Object[] { Long.valueOf(D) });
          return;
        }
        localHashMap = a((ContentResolver)localObject1, paramMailbox);
        localObject1 = a((ContentResolver)localObject1, Mailbox.a(paramContext, g, 6), D);
        localObject2 = (axg)awr.a(paramAccount, paramContext);
        if (localObject2 == null)
        {
          cvm.b("Pop3Service", "Couldn't find Pop3Store syncing account %d", new Object[] { Long.valueOf(D) });
          continue;
        }
        localObject2 = (axi)((axg)localObject2).a(d);
      }
      finally {}
      ((axi)localObject2).a(bdf.a);
      cvm.a("Pop3Service", "processLocalDeletes", new Object[] { Long.valueOf(D) });
      label193:
      int i;
      long l1;
      if (paramAccount.d() == 0)
      {
        cvm.b("Pop3Service", "delete policy is NEVER, canceling", new Object[0]);
      }
      else
      {
        do
        {
          i = a;
          paramMailbox.a(paramContext, i);
          cvm.a("Pop3Service", "Account %d: %d total remote messages", new Object[] { Long.valueOf(D), Integer.valueOf(i) });
          if (i > 0) {
            break label519;
          }
          cvm.a("Pop3Service", "No messages to sync, early-out", new Object[0]);
          ((axi)localObject2).b();
          break;
          l1 = Mailbox.a(paramContext, D, 6);
          localObject3 = bed.a(paramContext, D);
        } while (localObject3 == null);
        localObject3 = ((List)localObject3).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label193;
        }
        localObject4 = (bed)((Iterator)localObject3).next();
        long l2 = j;
        if (l2 != l1) {
          break;
        }
        try
        {
          axk localaxk = (axk)((axi)localObject2).a(e);
          if (localaxk != null)
          {
            cvm.a("Pop3Service", "Deleting remote message %s", new Object[] { e });
            b.j[0] = localaxk;
            ((axi)localObject2).a(b.j, axg.i, true);
          }
          for (;;)
          {
            bed.a(paramContext.getContentResolver(), new long[] { d }, 1);
            break;
            cvm.a("Pop3Service", "Message %s not found on server while deleting", new Object[] { e });
            bed.b(paramContext.getContentResolver(), new long[] { d }, 1);
          }
        }
        catch (bdi localbdi)
        {
          cvm.a("Pop3Service", localbdi, "Caught exception while deleting message %s", new Object[] { e });
          bed.b(paramContext.getContentResolver(), new long[] { d }, 1);
        }
      }
      label519:
      Object localObject3 = new ArrayList();
      Object localObject4 = new HashMap();
      a((axi)localObject2, paramInt, i, localHashMap, (HashSet)localObject1, (ArrayList)localObject3, (HashMap)localObject4);
      localbdk.a(a(paramContext, paramAccount, paramMailbox, (axi)localObject2, (HashMap)localObject4));
      a(paramContext, paramAccount, (HashMap)localObject4, localHashMap);
      localbdk.a(a(paramContext, paramAccount, (axi)localObject2, (ArrayList)localObject3, paramMailbox));
      cvm.a("Pop3Service", "Account %d: sync done", new Object[] { Long.valueOf(D) });
      parambbk.a(D, false, false, i, localHashMap.size(), ((ArrayList)localObject3).size(), localbdk, null);
      ((axi)localObject2).b();
      if (h == 0) {
        cfg.b(paramContext, d).c(i);
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    a.a = this;
    return a;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.Pop3Service
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */