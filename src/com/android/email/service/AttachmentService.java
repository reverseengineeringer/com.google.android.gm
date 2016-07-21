package com.android.email.service;

import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import aqj;
import aqk;
import bac;
import bae;
import bag;
import bah;
import bam;
import bbx;
import bbz;
import bdv;
import beb;
import ber;
import bgt;
import bhn;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Attachment;
import ctl;
import cvm;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AttachmentService
  extends Service
  implements Runnable
{
  public static volatile AttachmentService b = null;
  private static final Queue<long[]> l = new ConcurrentLinkedQueue();
  final bah a = new bah(this);
  public volatile boolean c = false;
  public aqk d;
  final AttachmentService.AttachmentWatchdog e = new AttachmentService.AttachmentWatchdog();
  public final ConcurrentHashMap<Long, bag> f = new ConcurrentHashMap();
  bac g;
  private final Object h = new Object();
  private final ConcurrentHashMap<Long, Long> i = new ConcurrentHashMap();
  private final ConcurrentHashMap<Long, Integer> j = new ConcurrentHashMap();
  private final bae k = new bae();
  
  private final int a(long paramLong)
  {
    int m = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = f.values().iterator();
        if (localIterator.hasNext())
        {
          long l1 = nexte;
          if (l1 == paramLong) {
            m += 1;
          }
        }
        else
        {
          return m;
        }
      }
      finally {}
    }
  }
  
  public static int a(Attachment paramAttachment)
  {
    int m = -1;
    int n = s;
    if ((n & 0x4) != 0) {
      m = 1;
    }
    while ((n & 0x2) == 0) {
      return m;
    }
    return 0;
  }
  
  public static void a(Context paramContext, long paramLong, int paramInt)
  {
    cvm.b("AttachmentService", "Attachment with id: %d will potentially be queued for download", new Object[] { Long.valueOf(paramLong) });
    Intent localIntent = new Intent(paramContext, AttachmentService.class);
    localIntent.putExtra("com.android.email.AttachmentService.attachment_id", paramLong);
    localIntent.putExtra("com.android.email.AttachmentService.attachment_flags", paramInt);
    paramContext.startService(localIntent);
  }
  
  private final void a(Context paramContext, Attachment paramAttachment)
  {
    for (;;)
    {
      bag localbag2;
      try
      {
        long l1 = D;
        localbag2 = k.a(D);
        if (a(paramAttachment) == -1L)
        {
          cvm.b("AttachmentService", "Attachment #%d has no priority and will not be downloaded", new Object[] { Long.valueOf(D) });
          if (localbag2 != null) {
            k.b(localbag2);
          }
          b();
          return;
        }
        if (f.containsKey(Long.valueOf(D)))
        {
          l1 = D;
          continue;
        }
        localbag1 = localbag2;
      }
      finally {}
      bag localbag1;
      if (localbag2 == null)
      {
        cvm.b("AttachmentService", "Attachment #%d is a new download request", new Object[] { Long.valueOf(D) });
        localbag1 = new bag(paramContext, paramAttachment);
        paramContext = new aqj(paramContext, paramAttachment);
        if (!paramContext.a())
        {
          cvm.d("AttachmentService", "Attachment #%d is not eligible for download, flags %d", new Object[] { Long.valueOf(D), Integer.valueOf(k) });
          if (((s & 0x2) != 0) || ((s & 0x200) != 0))
          {
            cvm.d("AttachmentService", "Attachment #%d cannot be downloaded ever", new Object[] { Long.valueOf(D) });
            paramContext = new ContentValues();
            int m = s & 0xFFFFFFF9;
            s = m;
            paramContext.put("flags", Integer.valueOf(m));
            paramContext.put("uiState", Integer.valueOf(1));
            paramAttachment.a(this, paramContext);
            continue;
          }
        }
        k.a(localbag1);
      }
      else
      {
        cvm.b("AttachmentService", "Attachment #%d queued for download, priority: %d, created time: %d", new Object[] { Long.valueOf(D), Integer.valueOf(a), Long.valueOf(b) });
      }
    }
  }
  
  private final void b()
  {
    synchronized (h)
    {
      h.notify();
      return;
    }
  }
  
  /* Error */
  private final boolean b(bag parambag)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: getfield 104	bag:e	J
    //   9: invokestatic 225	bam:a	(Landroid/content/Context;J)Lber;
    //   12: astore 8
    //   14: aload_0
    //   15: getfield 73	com/android/email/service/AttachmentService:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   18: aload_1
    //   19: getfield 227	bag:c	J
    //   22: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: invokevirtual 231	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: ifnull +21 -> 49
    //   31: iconst_1
    //   32: istore_2
    //   33: iload_2
    //   34: ifeq +20 -> 54
    //   37: aload_1
    //   38: getfield 227	bag:c	J
    //   41: lstore 4
    //   43: iconst_0
    //   44: istore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: iload_3
    //   48: ireturn
    //   49: iconst_0
    //   50: istore_2
    //   51: goto -18 -> 33
    //   54: ldc 114
    //   56: ldc -23
    //   58: iconst_1
    //   59: anewarray 61	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: getfield 227	bag:c	J
    //   68: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   71: aastore
    //   72: invokestatic 127	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   75: pop
    //   76: aload_1
    //   77: invokestatic 239	java/lang/System:currentTimeMillis	()J
    //   80: putfield 241	bag:j	J
    //   83: aload_1
    //   84: iconst_1
    //   85: putfield 243	bag:f	Z
    //   88: aload_0
    //   89: getfield 73	com/android/email/service/AttachmentService:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   92: aload_1
    //   93: getfield 227	bag:c	J
    //   96: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   99: aload_1
    //   100: invokevirtual 246	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: aload_0
    //   105: getfield 52	com/android/email/service/AttachmentService:a	Lbah;
    //   108: astore 9
    //   110: aload_1
    //   111: getfield 104	bag:e	J
    //   114: lstore 4
    //   116: aload_1
    //   117: getfield 227	bag:c	J
    //   120: lstore 6
    //   122: aload_1
    //   123: getfield 213	bag:a	I
    //   126: ifeq +5 -> 131
    //   129: iconst_1
    //   130: istore_3
    //   131: aload 8
    //   133: aload 9
    //   135: lload 4
    //   137: lload 6
    //   139: iload_3
    //   140: invokeinterface 251 7 0
    //   145: aload_0
    //   146: getfield 59	com/android/email/service/AttachmentService:e	Lcom/android/email/service/AttachmentService$AttachmentWatchdog;
    //   149: aload_0
    //   150: invokevirtual 254	com/android/email/service/AttachmentService$AttachmentWatchdog:a	(Landroid/content/Context;)V
    //   153: iconst_1
    //   154: istore_3
    //   155: goto -110 -> 45
    //   158: astore 8
    //   160: aload_0
    //   161: aload_1
    //   162: invokevirtual 257	com/android/email/service/AttachmentService:a	(Lbag;)V
    //   165: goto -12 -> 153
    //   168: astore_1
    //   169: aload_0
    //   170: monitorexit
    //   171: aload_1
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	AttachmentService
    //   0	173	1	parambag	bag
    //   32	19	2	m	int
    //   1	154	3	bool	boolean
    //   41	95	4	l1	long
    //   120	18	6	l2	long
    //   12	120	8	localber	ber
    //   158	1	8	localRemoteException	RemoteException
    //   108	26	9	localbah	bah
    // Exception table:
    //   from	to	target	type
    //   54	122	158	android/os/RemoteException
    //   122	129	158	android/os/RemoteException
    //   131	153	158	android/os/RemoteException
    //   4	31	168	finally
    //   37	43	168	finally
    //   54	122	168	finally
    //   122	129	168	finally
    //   131	153	168	finally
    //   160	165	168	finally
  }
  
  private static void c()
  {
    cvm.b("AttachmentService", "Advanced logging not configured.", new Object[0]);
  }
  
  public final void a()
  {
    long l1;
    long l2;
    try
    {
      l.size();
      Object localObject1 = (long[])l.poll();
      if (localObject1 != null)
      {
        l1 = localObject1[0];
        l2 = localObject1[1];
        localObject1 = Attachment.a(this, l1);
        if (localObject1 == null) {
          cvm.d("AttachmentService", "Could not restore attachment #%d", new Object[] { Long.valueOf(l1) });
        }
        for (;;)
        {
          localObject1 = (long[])l.poll();
          break;
          s = ((int)l2);
          a(this, (Attachment)localObject1);
        }
      }
      k.b();
    }
    finally {}
    while (f.size() < 2)
    {
      localObject3 = k.a();
      if (localObject3 == null) {
        break;
      }
      if (a(e) > 0)
      {
        cvm.d("AttachmentService", "Skipping #%d; maxed for acct %d", new Object[] { Long.valueOf(c), Long.valueOf(e) });
      }
      else if (Attachment.a(this, c) == null)
      {
        cvm.e("AttachmentService", "Could not load attachment: #%d", new Object[] { Long.valueOf(c) });
      }
      else if (!f)
      {
        l1 = SystemClock.elapsedRealtime();
        if ((k > 0L) && (l > l1))
        {
          l1 = c;
          e.a(this, 10000L);
        }
        else
        {
          b((bag)localObject3);
        }
      }
    }
    Object localObject3 = d;
    int m;
    if ((localObject3 != null) && (ContentResolver.getMasterSyncAutomatically()))
    {
      localObject3 = d.getActiveNetworkInfo();
      if (localObject3 == null)
      {
        m = -1;
        break label904;
      }
    }
    else
    {
      cvm.b("AttachmentService", "Skipping opportunistic downloads since WIFI is not available", new Object[0]);
    }
    for (;;)
    {
      label347:
      return;
      m = ((NetworkInfo)localObject3).getType();
      break label904;
      label359:
      m = 2 - f.size();
      if (m > 0) {
        break;
      }
      cvm.b("AttachmentService", "Skipping opportunistic downloads, %d threads available", new Object[] { Integer.valueOf(m) });
      c();
    }
    localObject3 = bdv.a(Attachment.a, 25);
    Cursor localCursor = getContentResolver().query((Uri)localObject3, Attachment.h, "contentUri isnull AND flags=0 AND messageKey IN (SELECT _id FROM Message WHERE mailboxKey IN (SELECT _id FROM Mailbox WHERE type = 0) AND flagLoaded IN (2,1,5, 6))", null, "_id DESC");
    File localFile = getCacheDir();
    label831:
    label852:
    label867:
    label877:
    label904:
    label912:
    label919:
    label922:
    for (;;)
    {
      Attachment localAttachment;
      Account localAccount;
      try
      {
        if (!localCursor.moveToNext()) {
          break label867;
        }
        localAttachment = new Attachment();
        localAttachment.a(localCursor);
        localAccount = Account.a(this, u);
        if (localAccount == null)
        {
          l1 = D;
          bdv.a(this, Attachment.a, D);
          continue;
        }
        if (!new aqj(this, localAttachment).a()) {
          break label877;
        }
      }
      finally
      {
        localCursor.close();
      }
      Object localObject5;
      if (l == null)
      {
        if (localAccount == null)
        {
          m = 0;
          break label912;
        }
      }
      else
      {
        localObject5 = (Integer)j.get(Long.valueOf(D));
        if ((localObject5 == null) || (((Integer)localObject5).intValue() <= 5)) {
          break label852;
        }
        cvm.d("AttachmentService", "Too many failed attempts for attachment #%d ", new Object[] { Long.valueOf(D) });
        continue;
      }
      if ((j & 0x100) == 0)
      {
        l1 = D;
        m = 0;
      }
      else
      {
        l1 = localFile.getTotalSpace();
        if (localFile.getUsableSpace() < ((float)l1 * 0.25F))
        {
          m = 0;
        }
        else
        {
          localObject5 = g;
          if (a != null) {}
          Object localObject6;
          for (m = ctl.c(a);; m = b)
          {
            l1 = ((float)l1 * 0.25F / m);
            localObject5 = (Long)i.get(Long.valueOf(D));
            if (localObject5 != null)
            {
              localObject6 = localObject5;
              if (((Long)localObject5).longValue() <= l1) {
                break label831;
              }
            }
            localObject5 = Long.valueOf(0L);
            File[] arrayOfFile = localFile.listFiles();
            localObject6 = localObject5;
            if (arrayOfFile == null) {
              break;
            }
            int n = arrayOfFile.length;
            m = 0;
            for (;;)
            {
              localObject6 = localObject5;
              if (m >= n) {
                break;
              }
              localObject6 = arrayOfFile[m];
              l2 = ((Long)localObject5).longValue();
              long l3 = ((File)localObject6).length();
              m += 1;
              localObject5 = Long.valueOf(l2 + l3);
            }
          }
          i.put(Long.valueOf(D), localObject6);
          if (((Long)localObject6).longValue() < l1) {
            break label919;
          }
          l1 = D;
          m = 0;
          break label912;
          b(new bag(this, localAttachment));
          localCursor.close();
          break label347;
          cvm.d("AttachmentService", "Skipping attachment #%d, it is ineligible", new Object[] { Long.valueOf(D) });
          continue;
          if (m == 1) {
            break label359;
          }
          break;
        }
      }
      for (;;)
      {
        if (m == 0) {
          break label922;
        }
        break;
        m = 1;
      }
    }
  }
  
  public final void a(long paramLong, int paramInt)
  {
    Object localObject4;
    int m;
    bag localbag;
    for (;;)
    {
      try
      {
        cvm.b("AttachmentService", "Finishing download #%d", new Object[] { Long.valueOf(paramLong) });
        f.remove(Long.valueOf(paramLong));
        localObject4 = (Integer)j.remove(Long.valueOf(paramLong));
        if (paramInt != 0)
        {
          Object localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = Integer.valueOf(0);
          }
          m = ((Integer)localObject1).intValue();
          cvm.d("AttachmentService", "This attachment failed, adding #%d to failure map", new Object[] { Long.valueOf(paramLong) });
          j.put(Long.valueOf(paramLong), Integer.valueOf(m + 1));
        }
        localbag = k.a(paramLong);
        if (paramInt != 32) {
          break;
        }
        if (localbag != null)
        {
          k += 1L;
          if (k > 10L)
          {
            cvm.d("AttachmentService", "Too many tried for connection errors, giving up #%d", new Object[] { Long.valueOf(paramLong) });
            k.b(localbag);
          }
        }
        else
        {
          return;
        }
        if (k > 5L)
        {
          cvm.d("AttachmentService", "ConnectionError #%d, retried %d times, adding delay", new Object[] { Long.valueOf(paramLong), Long.valueOf(k) });
          f = false;
          l = (SystemClock.elapsedRealtime() + 10000L);
          e.a(this, 10000L);
          continue;
        }
      }
      finally {}
      tmp284_281[0] = Long.valueOf(paramLong);
      Object[] tmp291_284 = tmp284_281;
      tmp291_284[1] = Long.valueOf(k);
      cvm.d("AttachmentService", "ConnectionError for #%d, retried %d times, adding delay", tmp291_284);
      f = false;
      l = 0L;
      b();
    }
    if (localbag != null) {
      k.b(localbag);
    }
    Attachment localAttachment = Attachment.a(this, paramLong);
    long l1;
    Object localObject3;
    int n;
    if (localAttachment != null)
    {
      l1 = u;
      localObject4 = (Long)i.get(Long.valueOf(l1));
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = Long.valueOf(0L);
      }
      i.put(Long.valueOf(l1), Long.valueOf(((Long)localObject3).longValue() + k));
      n = 0;
      m = 0;
      if ((s & 0x4) != 0)
      {
        if (paramInt == 17)
        {
          bdv.a(this, Attachment.a, D);
          localObject3 = bbz.a(this);
          if (localObject3 != null) {
            ((bbx)localObject3).a(localAttachment);
          }
          m = 1;
          cvm.d("AttachmentService", "Deleting forwarded attachment #%d for message #%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(o) });
        }
        n = m;
        if (localbag != null)
        {
          n = m;
          if (!bhn.a(this, o))
          {
            paramLong = d;
            localObject3 = bam.a(this, l1);
          }
        }
      }
    }
    try
    {
      ((ber)localObject3).c(l1);
      n = m;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        cvm.e("AttachmentService", "RemoteException while trying to send message: #%d, %s", new Object[] { Long.valueOf(d), localRemoteException.toString() });
        n = m;
      }
      cvm.d("AttachmentService", "Retrying attachment #%d with associated message #%d", new Object[] { Long.valueOf(D), Long.valueOf(o) });
      b();
    }
    if (paramInt == 16) {
      if (beb.a(this, o) == null)
      {
        cvm.d("AttachmentService", "Deleting attachment #%d with no associated message #%d", new Object[] { Long.valueOf(D), Long.valueOf(o) });
        bdv.a(this, Attachment.a, D);
      }
    }
    for (;;)
    {
      b();
      break;
      break;
      if (n == 0)
      {
        cvm.b("AttachmentService", "Attachment #%d successfully downloaded!", new Object[] { Long.valueOf(D) });
        ContentValues localContentValues = new ContentValues();
        paramInt = s & 0xFFFFFFF9;
        s = paramInt;
        localContentValues.put("flags", Integer.valueOf(paramInt));
        localContentValues.put("uiState", Integer.valueOf(3));
        localAttachment.a(this, localContentValues);
      }
    }
  }
  
  /* Error */
  public final void a(bag parambag)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 114
    //   4: ldc_w 494
    //   7: iconst_1
    //   8: anewarray 61	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_1
    //   14: getfield 227	bag:c	J
    //   17: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: invokestatic 127	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   24: pop
    //   25: aload_1
    //   26: iconst_0
    //   27: putfield 243	bag:f	Z
    //   30: aload_0
    //   31: getfield 73	com/android/email/service/AttachmentService:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   34: aload_1
    //   35: getfield 227	bag:c	J
    //   38: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   41: invokevirtual 437	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_0
    //   46: getfield 78	com/android/email/service/AttachmentService:k	Lbae;
    //   49: aload_1
    //   50: invokevirtual 165	bae:b	(Lbag;)Z
    //   53: pop
    //   54: aload_1
    //   55: aload_1
    //   56: getfield 298	bag:k	J
    //   59: lconst_1
    //   60: ladd
    //   61: putfield 298	bag:k	J
    //   64: aload_1
    //   65: getfield 298	bag:k	J
    //   68: ldc2_w 440
    //   71: lcmp
    //   72: ifle +29 -> 101
    //   75: ldc 114
    //   77: ldc_w 496
    //   80: iconst_1
    //   81: anewarray 61	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_1
    //   87: getfield 227	bag:c	J
    //   90: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   93: aastore
    //   94: invokestatic 191	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   97: pop
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: aload_1
    //   102: getfield 227	bag:c	J
    //   105: lstore_2
    //   106: new 101	bag
    //   109: dup
    //   110: aload_1
    //   111: invokestatic 296	android/os/SystemClock:elapsedRealtime	()J
    //   114: invokespecial 499	bag:<init>	(Lbag;J)V
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 78	com/android/email/service/AttachmentService:k	Lbae;
    //   122: aload_1
    //   123: invokevirtual 209	bae:a	(Lbag;)Z
    //   126: pop
    //   127: goto -29 -> 98
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	AttachmentService
    //   0	135	1	parambag	bag
    //   105	1	2	l1	long
    // Exception table:
    //   from	to	target	type
    //   2	98	130	finally
    //   101	127	130	finally
  }
  
  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] arg3)
  {
    paramPrintWriter.println("AttachmentService");
    long l1 = System.currentTimeMillis();
    long l2;
    Attachment localAttachment;
    do
    {
      for (;;)
      {
        synchronized (k)
        {
          m = k.b();
          paramPrintWriter.println(28 + "  Queue, " + m + " entries");
          Iterator localIterator = k.b.values().iterator();
          if (!localIterator.hasNext()) {
            break label689;
          }
          bag localbag = (bag)localIterator.next();
          l2 = e;
          long l3 = c;
          paramPrintWriter.println(67 + "    Account: " + l2 + ", Attachment: " + l3);
          m = a;
          l2 = b;
          if (f)
          {
            paramFileDescriptor = " [In progress]";
            paramPrintWriter.println(String.valueOf(paramFileDescriptor).length() + 55 + "      Priority: " + m + ", Time: " + l2 + paramFileDescriptor);
            localAttachment = Attachment.a(this, c);
            if (localAttachment != null) {
              break;
            }
            paramPrintWriter.println("      Attachment not in database?");
            if (!f) {
              continue;
            }
            m = g;
            int n = h;
            paramPrintWriter.println(48 + "      Status: " + m + ", Progress: " + n);
            l2 = j;
            l3 = i;
            paramPrintWriter.println(67 + "      Started: " + l2 + ", Callback: " + l3);
            l2 = (l1 - j) / 1000L;
            paramPrintWriter.println(36 + "      Elapsed: " + l2 + "s");
            if (i <= 0L) {
              continue;
            }
            l2 = (l1 - i) / 1000L;
            paramPrintWriter.println(31 + "      CB: " + l2 + "s");
          }
        }
        paramFileDescriptor = "";
      }
    } while (i == null);
    String str = i;
    int m = str.lastIndexOf('.');
    if (m >= 0) {}
    for (paramFileDescriptor = str.substring(m);; paramFileDescriptor = "[none]")
    {
      paramFileDescriptor = String.valueOf(paramFileDescriptor);
      if (paramFileDescriptor.length() != 0)
      {
        paramFileDescriptor = "      Suffix: ".concat(paramFileDescriptor);
        label538:
        paramPrintWriter.print(paramFileDescriptor);
        if (localAttachment.d() != null)
        {
          paramFileDescriptor = String.valueOf(localAttachment.d());
          if (paramFileDescriptor.length() == 0) {
            break label655;
          }
          paramFileDescriptor = " ContentUri: ".concat(paramFileDescriptor);
          label575:
          paramPrintWriter.print(paramFileDescriptor);
        }
        paramPrintWriter.print(" Mime: ");
        if (j == null) {
          break label669;
        }
        paramPrintWriter.print(j);
      }
      for (;;)
      {
        l2 = k;
        paramPrintWriter.println(27 + " Size: " + l2);
        break;
        paramFileDescriptor = new String("      Suffix: ");
        break label538;
        label655:
        paramFileDescriptor = new String(" ContentUri: ");
        break label575;
        label669:
        paramPrintWriter.print(bgt.a(str, null));
        paramPrintWriter.print(" [inferred]");
      }
      label689:
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    new Thread(this, "AttachmentService").start();
  }
  
  public void onDestroy()
  {
    c();
    c = true;
    if (b != null)
    {
      b();
      b = null;
    }
    if (d != null)
    {
      d.a();
      Object localObject = d;
      e = true;
      localObject = f;
      if (localObject != null) {
        ((Thread)localObject).interrupt();
      }
      d = null;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (b == null) {
      b = this;
    }
    if (paramIntent != null)
    {
      long l1 = paramIntent.getLongExtra("com.android.email.AttachmentService.attachment_id", -1L);
      paramInt1 = paramIntent.getIntExtra("com.android.email.AttachmentService.attachment_flags", -1);
      if ((l1 >= 0L) && (paramInt1 >= 0))
      {
        l.add(new long[] { l1, paramInt1 });
        b();
      }
    }
    else
    {
      return 1;
    }
    return 1;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 315	aqk
    //   4: dup
    //   5: aload_0
    //   6: ldc 114
    //   8: invokespecial 654	aqk:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   11: putfield 308	com/android/email/service/AttachmentService:d	Laqk;
    //   14: aload_0
    //   15: new 409	bac
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 656	bac:<init>	(Landroid/content/Context;)V
    //   23: putfield 407	com/android/email/service/AttachmentService:g	Lbac;
    //   26: aload_0
    //   27: invokevirtual 347	com/android/email/service/AttachmentService:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 338	com/android/emailcommon/provider/Attachment:a	Landroid/net/Uri;
    //   33: getstatic 659	bdv:B	[Ljava/lang/String;
    //   36: ldc_w 661
    //   39: iconst_1
    //   40: anewarray 537	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: bipush 6
    //   47: invokestatic 663	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   50: aastore
    //   51: aconst_null
    //   52: invokevirtual 358	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore 5
    //   57: ldc 114
    //   59: ldc_w 665
    //   62: iconst_1
    //   63: anewarray 61	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload 5
    //   70: invokeinterface 668 1 0
    //   75: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: aastore
    //   79: invokestatic 127	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   82: pop
    //   83: aload 5
    //   85: invokeinterface 367 1 0
    //   90: ifeq +89 -> 179
    //   93: aload_0
    //   94: aload 5
    //   96: iconst_0
    //   97: invokeinterface 672 2 0
    //   102: invokestatic 273	com/android/emailcommon/provider/Attachment:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Attachment;
    //   105: astore 6
    //   107: aload 6
    //   109: ifnull -26 -> 83
    //   112: aload 6
    //   114: getfield 153	com/android/emailcommon/provider/Attachment:D	J
    //   117: lstore_3
    //   118: aload_0
    //   119: aload_0
    //   120: aload 6
    //   122: invokespecial 277	com/android/email/service/AttachmentService:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Attachment;)V
    //   125: goto -42 -> 83
    //   128: astore 6
    //   130: aload 6
    //   132: invokevirtual 675	java/lang/Exception:printStackTrace	()V
    //   135: aload 5
    //   137: invokeinterface 385 1 0
    //   142: aload_0
    //   143: getfield 54	com/android/email/service/AttachmentService:c	Z
    //   146: ifne +166 -> 312
    //   149: aload_0
    //   150: getfield 308	com/android/email/service/AttachmentService:d	Laqk;
    //   153: astore 5
    //   155: aload 5
    //   157: ifnull +135 -> 292
    //   160: aload 5
    //   162: getfield 677	aqk:g	Z
    //   165: ifne +36 -> 201
    //   168: new 679	java/lang/IllegalStateException
    //   171: dup
    //   172: ldc_w 681
    //   175: invokespecial 682	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   178: athrow
    //   179: aload 5
    //   181: invokeinterface 385 1 0
    //   186: goto -44 -> 142
    //   189: astore 6
    //   191: aload 5
    //   193: invokeinterface 385 1 0
    //   198: aload 6
    //   200: athrow
    //   201: aload 5
    //   203: invokestatic 686	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   206: putfield 630	aqk:f	Ljava/lang/Thread;
    //   209: aload 5
    //   211: getfield 689	aqk:c	Landroid/os/PowerManager$WakeLock;
    //   214: invokevirtual 694	android/os/PowerManager$WakeLock:acquire	()V
    //   217: iconst_0
    //   218: istore_1
    //   219: aload 5
    //   221: getfield 627	aqk:e	Z
    //   224: ifne +221 -> 445
    //   227: aload 5
    //   229: getfield 318	aqk:d	Landroid/net/ConnectivityManager;
    //   232: invokevirtual 324	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   235: ifnull +94 -> 329
    //   238: iload_1
    //   239: ifeq +28 -> 267
    //   242: ldc_w 696
    //   245: aload 5
    //   247: getfield 698	aqk:a	Ljava/lang/String;
    //   250: invokestatic 540	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   253: ldc_w 700
    //   256: invokevirtual 587	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   259: iconst_0
    //   260: anewarray 61	java/lang/Object
    //   263: invokestatic 702	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   266: pop
    //   267: aload 5
    //   269: getfield 689	aqk:c	Landroid/os/PowerManager$WakeLock;
    //   272: invokevirtual 705	android/os/PowerManager$WakeLock:isHeld	()Z
    //   275: ifeq +11 -> 286
    //   278: aload 5
    //   280: getfield 689	aqk:c	Landroid/os/PowerManager$WakeLock;
    //   283: invokevirtual 708	android/os/PowerManager$WakeLock:release	()V
    //   286: aload 5
    //   288: aconst_null
    //   289: putfield 630	aqk:f	Ljava/lang/Thread;
    //   292: aload_0
    //   293: getfield 54	com/android/email/service/AttachmentService:c	Z
    //   296: ifeq +177 -> 473
    //   299: ldc 114
    //   301: ldc_w 710
    //   304: iconst_0
    //   305: anewarray 61	java/lang/Object
    //   308: invokestatic 127	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   311: pop
    //   312: aload_0
    //   313: getfield 308	com/android/email/service/AttachmentService:d	Laqk;
    //   316: astore 5
    //   318: aload 5
    //   320: ifnull +8 -> 328
    //   323: aload 5
    //   325: invokevirtual 625	aqk:a	()V
    //   328: return
    //   329: iload_1
    //   330: istore_2
    //   331: iload_1
    //   332: ifne +30 -> 362
    //   335: ldc_w 696
    //   338: aload 5
    //   340: getfield 698	aqk:a	Ljava/lang/String;
    //   343: invokestatic 540	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   346: ldc_w 712
    //   349: invokevirtual 587	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   352: iconst_0
    //   353: anewarray 61	java/lang/Object
    //   356: invokestatic 702	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   359: pop
    //   360: iconst_1
    //   361: istore_2
    //   362: aload 5
    //   364: getfield 714	aqk:b	Ljava/lang/Object;
    //   367: astore 6
    //   369: aload 6
    //   371: monitorenter
    //   372: aload 5
    //   374: getfield 689	aqk:c	Landroid/os/PowerManager$WakeLock;
    //   377: invokevirtual 708	android/os/PowerManager$WakeLock:release	()V
    //   380: aload 5
    //   382: getfield 714	aqk:b	Ljava/lang/Object;
    //   385: ldc2_w 715
    //   388: invokevirtual 719	java/lang/Object:wait	(J)V
    //   391: aload 5
    //   393: getfield 689	aqk:c	Landroid/os/PowerManager$WakeLock;
    //   396: invokevirtual 694	android/os/PowerManager$WakeLock:acquire	()V
    //   399: aload 6
    //   401: monitorexit
    //   402: iload_2
    //   403: istore_1
    //   404: goto -185 -> 219
    //   407: astore 7
    //   409: aload 6
    //   411: monitorexit
    //   412: aload 7
    //   414: athrow
    //   415: astore 6
    //   417: aload 5
    //   419: getfield 689	aqk:c	Landroid/os/PowerManager$WakeLock;
    //   422: invokevirtual 705	android/os/PowerManager$WakeLock:isHeld	()Z
    //   425: ifeq +11 -> 436
    //   428: aload 5
    //   430: getfield 689	aqk:c	Landroid/os/PowerManager$WakeLock;
    //   433: invokevirtual 708	android/os/PowerManager$WakeLock:release	()V
    //   436: aload 5
    //   438: aconst_null
    //   439: putfield 630	aqk:f	Ljava/lang/Thread;
    //   442: aload 6
    //   444: athrow
    //   445: aload 5
    //   447: getfield 689	aqk:c	Landroid/os/PowerManager$WakeLock;
    //   450: invokevirtual 705	android/os/PowerManager$WakeLock:isHeld	()Z
    //   453: ifeq +11 -> 464
    //   456: aload 5
    //   458: getfield 689	aqk:c	Landroid/os/PowerManager$WakeLock;
    //   461: invokevirtual 708	android/os/PowerManager$WakeLock:release	()V
    //   464: aload 5
    //   466: aconst_null
    //   467: putfield 630	aqk:f	Ljava/lang/Thread;
    //   470: goto -178 -> 292
    //   473: invokestatic 335	com/android/email/service/AttachmentService:c	()V
    //   476: aload_0
    //   477: invokevirtual 720	com/android/email/service/AttachmentService:a	()V
    //   480: invokestatic 335	com/android/email/service/AttachmentService:c	()V
    //   483: aload_0
    //   484: getfield 78	com/android/email/service/AttachmentService:k	Lbae;
    //   487: invokevirtual 722	bae:c	()Z
    //   490: ifeq +33 -> 523
    //   493: aload_0
    //   494: getfield 73	com/android/email/service/AttachmentService:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   497: invokevirtual 280	java/util/concurrent/ConcurrentHashMap:size	()I
    //   500: ifgt +23 -> 523
    //   503: ldc 114
    //   505: ldc_w 724
    //   508: iconst_0
    //   509: anewarray 61	java/lang/Object
    //   512: invokestatic 127	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   515: pop
    //   516: aload_0
    //   517: invokevirtual 727	com/android/email/service/AttachmentService:stopSelf	()V
    //   520: goto -208 -> 312
    //   523: aload_0
    //   524: getfield 64	com/android/email/service/AttachmentService:h	Ljava/lang/Object;
    //   527: astore 5
    //   529: aload 5
    //   531: monitorenter
    //   532: aload_0
    //   533: getfield 64	com/android/email/service/AttachmentService:h	Ljava/lang/Object;
    //   536: ldc2_w 728
    //   539: invokevirtual 719	java/lang/Object:wait	(J)V
    //   542: aload 5
    //   544: monitorexit
    //   545: goto -403 -> 142
    //   548: astore 6
    //   550: aload 5
    //   552: monitorexit
    //   553: aload 6
    //   555: athrow
    //   556: astore 6
    //   558: goto -16 -> 542
    //   561: astore 7
    //   563: goto -172 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	AttachmentService
    //   218	186	1	m	int
    //   330	73	2	n	int
    //   117	1	3	l1	long
    //   105	16	6	localAttachment	Attachment
    //   128	3	6	localException	Exception
    //   189	10	6	localObject2	Object
    //   415	28	6	localObject4	Object
    //   548	6	6	localObject5	Object
    //   556	1	6	localInterruptedException1	InterruptedException
    //   407	6	7	localObject6	Object
    //   561	1	7	localInterruptedException2	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   57	83	128	java/lang/Exception
    //   83	107	128	java/lang/Exception
    //   112	125	128	java/lang/Exception
    //   57	83	189	finally
    //   83	107	189	finally
    //   112	125	189	finally
    //   130	135	189	finally
    //   372	380	407	finally
    //   380	391	407	finally
    //   391	402	407	finally
    //   409	412	407	finally
    //   219	238	415	finally
    //   242	267	415	finally
    //   335	360	415	finally
    //   362	372	415	finally
    //   412	415	415	finally
    //   532	542	548	finally
    //   542	545	548	finally
    //   550	553	548	finally
    //   532	542	556	java/lang/InterruptedException
    //   380	391	561	java/lang/InterruptedException
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.AttachmentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */