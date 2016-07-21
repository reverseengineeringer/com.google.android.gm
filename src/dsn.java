import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gm.provider.GmailProvider;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;

final class dsn
  extends dsz
  implements dtr
{
  private boolean A = false;
  private String[] B;
  boolean a;
  long b;
  final String c;
  final drk d;
  final dqr e;
  final String f;
  int g;
  final boolean h;
  boolean i = false;
  boolean j = false;
  long k = 0L;
  private volatile long t;
  private final boolean u;
  private boolean v = false;
  private final int w = ghz.a(l.k.getContentResolver(), "gmail_live_max_results", 22);
  private final int x = ghz.a(l.k.getContentResolver(), "gmail_live_threshold_step", 10);
  private final int y = ghz.a(l.k.getContentResolver(), "gmail_live_threshold_max", 100);
  private volatile int z = 0;
  
  public dsn(drp paramdrp, String paramString1, String paramString2, boolean paramBoolean1, Integer paramInteger, bgr parambgr, boolean paramBoolean2)
  {
    super(paramdrp);
    a = paramBoolean1;
    h = paramBoolean2;
    if (paramBoolean1)
    {
      j = true;
      if (o.a("^i") != null)
      {
        Y = paramString1;
        Z = paramString2;
        aa = this;
      }
    }
    c = paramString1;
    paramString2 = o;
    paramString1 = c;
    if (paramString1.startsWith("label:")) {}
    for (paramString1 = paramString1.substring(6);; paramString1 = null)
    {
      d = paramString2.a(paramString1);
      b = m.a(d);
      t = b;
      if (d == null) {
        break;
      }
      e = null;
      u = false;
      paramdrp = "conversation_labels.conversation_id IN (SELECT DISTINCT conversation_labels.conversation_id FROM conversation_labels WHERE conversation_labels.labels_id=? ORDER BY conversation_labels.sortMessageId DESC LIMIT ?) AND conversation_labels.labels_id=? AND (((conversations.maxMessageId>=? OR conversations.maxMessageId=0) AND conversation_labels.queryId=0) OR (conversations.maxMessageId<? AND conversation_labels.queryId=?))";
      a(paramInteger);
      a();
      paramString1 = String.valueOf("SELECT conversation_labels.*, conversations.*, conversations.queryId = 0 AS synced, (SELECT group_concat((labels._id || '^*^' || labels.canonicalName || '^*^' || \n(CASE labels.canonicalName  WHEN '^f' THEN ?  WHEN '^^out' THEN ?  WHEN '^i' THEN ?  WHEN '^r' THEN ?  WHEN '^b' THEN ?  WHEN '^all' THEN ?  WHEN '^u' THEN ?  WHEN '^k' THEN ?  WHEN '^s' THEN ?  WHEN '^t' THEN ?  WHEN '^g' THEN ?  WHEN '^io_im' THEN ?  WHEN '^iim' THEN ?  WHEN '^sq_ig_i_personal' THEN ?  WHEN '^sq_ig_i_social' THEN ?  WHEN '^sq_ig_i_promo' THEN ?  WHEN '^sq_ig_i_notification' THEN ?  WHEN '^sq_ig_i_group' THEN ?  ELSE labels.name END)  || '^*^' || labels.color || '^*^' || labels.hidden), '^**^') FROM labels JOIN conversation_labels  ON conversation_labels.labels_id=labels._id  AND conversation_labels.conversation_id=conversations._id AND conversation_labels.isZombie=0) AS conversationLabels, (CASE WHEN unsubscribed_senders.senderIdentifier IS NULL THEN 0 ELSE 1 END) AS isSenderUnsubscribed FROM conversation_labels LEFT OUTER JOIN conversations ON conversation_labels.conversation_id=conversations._id AND conversation_labels.queryId = conversations.queryId LEFT OUTER JOIN unsubscribed_senders ON conversations.unsubscribeSenderIdentifier = unsubscribed_senders.senderIdentifier\n WHERE\n (");
      f = (String.valueOf(paramString1).length() + 25 + String.valueOf(paramdrp).length() + String.valueOf(" GROUP BY conversations._id ORDER BY conversation_labels.sortMessageId DESC").length() + paramString1 + paramdrp + ") AND isZombie=0\n" + " GROUP BY conversations._id ORDER BY conversation_labels.sortMessageId DESC" + " LIMIT ?");
      return;
    }
    u = true;
    if (parambgr != null)
    {
      e = new dqs(o, l.name, c, parambgr);
      label359:
      paramdrp = e.a();
      if (TextUtils.isEmpty(paramdrp)) {
        break label445;
      }
    }
    label445:
    for (paramdrp = String.valueOf(paramdrp).length() + 72 + " conversation_labels.queryId=? OR (conversation_labels.queryId=0 AND (" + paramdrp + "))";; paramdrp = " conversation_labels.queryId=?")
    {
      break;
      e = new dqr(o, l.name, c, paramdrp.u());
      break label359;
    }
  }
  
  final int a(int paramInt, dsy paramdsy)
  {
    if (!c()) {}
    do
    {
      int m;
      do
      {
        return 0;
        m = paramdsy.getCount();
        if ((dri.a("CursorLogic", 3)) && (Thread.currentThread() != Looper.getMainLooper().getThread())) {
          dri.b("CursorLogic", new Error(), "IN cursor maybeFetch, count=%s label=%s pos=%s threshold=%s worker=%s thisThread=%s", new Object[] { Integer.valueOf(m), d, Integer.valueOf(paramInt), Integer.valueOf(z), this.m, Thread.currentThread() });
        }
      } while ((o) || ((paramInt + 1 < m - z) && ((!u) || (v))) || (m >= 1500) || (t <= 0L) || (this.m != null));
      if (y > 0) {
        dri.a(drp.b, "Prefetching live mail: maxResults: %d pos: %d count: %d threshold: %d", new Object[] { Integer.valueOf(w), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(z) });
      }
    } while (!l());
    dri.b("CursorLogic", "IN cursor maybeFetch starting thread. label=%s worker=%s", new Object[] { d, this.m });
    return 8;
  }
  
  public final Bundle a(int paramInt)
  {
    Bundle localBundle = super.a(paramInt);
    if ((u) && (!v))
    {
      paramInt = localBundle.getInt("status");
      if ((paramInt == 1) || (paramInt == 0)) {
        localBundle.putInt("status", 4);
      }
    }
    localBundle.putBoolean("active_network_query", c());
    if (d != null) {
      localBundle.putString("label_canonical_name", d.b);
    }
    return localBundle;
  }
  
  public final Bundle a(Bundle paramBundle)
  {
    try
    {
      A = paramBundle.getBoolean("force_refresh", false);
      if (A) {
        t = -1L;
      }
      paramBundle = super.a(paramBundle);
      return paramBundle;
    }
    finally {}
  }
  
  final void a()
  {
    r = a(l.k, d, b, q, g);
  }
  
  public final void a(long paramLong)
  {
    k = paramLong;
  }
  
  public final void a(dtp paramdtp)
  {
    t = (l.a(paramdtp, q, d) - 1L);
  }
  
  final void a(Integer paramInteger)
  {
    if (paramInteger != null) {}
    for (int m = paramInteger.intValue();; m = 1500)
    {
      g = m;
      return;
    }
  }
  
  public final void a(String... paramVarArgs)
  {
    B = paramVarArgs;
  }
  
  final String[] a(Context paramContext, drk paramdrk, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramdrk != null) {
      return duo.a(paramContext, new String[] { Long.toString(a), Integer.toString(paramInt), Long.toString(a), Long.toString(paramLong1), Long.toString(paramLong1), Long.toString(paramLong2), Integer.toString(paramInt) });
    }
    paramdrk = hgd.a(new String[] { Long.toString(paramLong2) });
    paramdrk.addAll(e.b());
    paramdrk.add(Integer.toString(paramInt));
    return duo.a(paramContext, (String[])paramdrk.toArray(new String[paramdrk.size()]));
  }
  
  public final String[] b()
  {
    if (i) {
      return duo.a(l.getContext(), new String[0]);
    }
    return super.b();
  }
  
  public final boolean c()
  {
    return (a) && (TextUtils.equals(c, l.Y));
  }
  
  public final boolean d()
  {
    return t == 0L;
  }
  
  protected final int e()
  {
    int m = 0;
    if ((l.K == null) && (this.m == null) && (!l.P)) {
      synchronized (l.J)
      {
        if (l.K == null)
        {
          l.K = new Thread(new dte(l), "CCL SyncThread");
          l.K.start();
          m = 8;
        }
        return m;
      }
    }
    return 0;
  }
  
  public final void f()
  {
    l.r.a(l.A);
    try
    {
      l.r.b();
      return;
    }
    catch (Exception localException)
    {
      dri.e(drp.b, localException, "Exception while attempting to suppress notifications", new Object[0]);
      l.r.d();
      throw new IllegalStateException("Exception while attempting to suppress notifications", localException);
    }
  }
  
  public final void g()
  {
    l.r.c();
    l.r.d();
  }
  
  protected final void h()
  {
    TrafficStats.setThreadStatsTag(ddh.a(l.l.name) | 0x200000);
    for (;;)
    {
      Object localObject7;
      long l1;
      int m;
      try
      {
        l.a(2, true);
        if (d == null) {
          break label295;
        }
        localObject7 = d.b;
        if (!l.o.a("bx_pie", false)) {
          break label893;
        }
        localObject1 = (drn)l.o.g().get(localObject7);
        if (localObject1 == null) {
          break label893;
        }
        localObject1 = b;
      }
      finally
      {
        Object localObject1;
        l.a(2, false);
        TrafficStats.incrementOperationCount(2097152, 1);
        TrafficStats.clearThreadStatsTag();
      }
      Object localObject9 = l.m;
      label119:
      boolean bool;
      Object localObject8;
      int n;
      gxg localgxg;
      if (t < 0L)
      {
        l1 = 0L;
        m = w;
        bool = dyb.a(k, h.p());
        localObject7 = i;
        localObject8 = l;
        n = ((dtn)localObject9).b();
        localObject9 = dvd.a();
        i = new gxg();
        localgxg = i;
        if (localObject1 != null) {
          break label312;
        }
        throw new NullPointerException();
      }
      label295:
      label312:
      label768:
      label843:
      String str;
      label893:
      do
      {
        if ("^k".equals(localObject7))
        {
          localObject3 = new StringBuilder(c);
          ((StringBuilder)localObject3).append(" !label:");
          ((StringBuilder)localObject3).append("^s");
          ((StringBuilder)localObject3).append(" !label:");
          ((StringBuilder)localObject3).append("^fa");
          localObject3 = ((StringBuilder)localObject3).toString();
          break;
        }
        Object localObject3 = c;
        break;
        l1 = t;
        break label119;
        b = ((String)localObject3);
        a |= 0x1;
        c = l1;
        a |= 0x2;
        d = m;
        a |= 0x4;
        e = 5;
        a |= 0x8;
        if (bool)
        {
          f = true;
          a |= 0x10;
        }
        cvm.b("Gmail", "getConversationListUrl: query: %s, highestMessageId: %d, maxResults = %d, maxSenders %d", new Object[] { localObject3, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(5) });
        localObject3 = ((dvd)localObject7).a((ContentResolver)localObject8, n, 0L, (gww)localObject9, true);
        z = Math.min(z + x, y);
        dri.b("CursorLogic", "CCL.init fetchThreshold=%s thread=%s", new Object[] { Integer.valueOf(z), Thread.currentThread() });
        localObject7 = l.a((HttpUriRequest)localObject3);
        try
        {
          try
          {
            if (A) {
              l.r.a();
            }
            try
            {
              localObject3 = new String[1];
              localObject3[0] = Long.toString(q);
              l.p.delete("conversations", "queryId = ?", (String[])localObject3);
              l.p.delete("conversation_labels", "queryId = ?", (String[])localObject3);
              A = false;
              l.r.c();
              l.r.d();
              localObject3 = l.m;
              localObject8 = ((HttpResponse)localObject7).getFirstHeader("Content-Type").getValue();
              if (!((String)localObject8).startsWith("application/vnd.google-x-gms-proto")) {
                break label768;
              }
              t = ((dtn)localObject3).a((HttpResponse)localObject7, this);
              v = true;
              localObject3 = ((HttpResponse)localObject7).getEntity();
              if (localObject3 != null) {
                ((HttpEntity)localObject3).consumeContent();
              }
              l.a(2, false);
              TrafficStats.incrementOperationCount(2097152, 1);
              TrafficStats.clearThreadStatsTag();
              return;
            }
            finally
            {
              l.r.d();
            }
            localObject6 = finally;
          }
          finally {}
          if (!((String)localObject8).startsWith("text/html")) {
            break label843;
          }
        }
        finally
        {
          if (localObject7 != null) {
            ((HttpEntity)localObject7).consumeContent();
          }
        }
        m = ((HttpResponse)localObject7).getStatusLine().getStatusCode();
        if (dri.a(dtn.g, 2)) {
          dtn.a((HttpResponse)localObject7);
        }
        throw new dty(79 + "Server returned unhandled response content type (text/html status: " + m + ")");
        str = String.valueOf(localObject8);
        if (str.length() != 0) {}
        for (str = "Unknown response content type: ".concat(str);; str = new String("Unknown response content type: ")) {
          throw new dty(str);
        }
        str = null;
      } while (str == null);
    }
  }
  
  final void i()
  {
    boolean bool = false;
    l.b(false);
    GmailProvider.c(l.k, l.l.name);
    if (d != null) {}
    for (String str = d.b;; str = null)
    {
      if (d == null) {
        bool = true;
      }
      GmailProvider.a(l.k, l.l.name, bool, str);
      return;
    }
  }
  
  final void j()
  {
    if (d != null)
    {
      drp localdrp = l;
      drk localdrk1 = d;
      drk localdrk2 = localdrp.a(localdrk1);
      if (localdrk2 != null)
      {
        int m = X.a(a);
        dri.b(drp.b, "MailEngine.clearNewUnreadMailForNotificationLabelIfNeeded() Count: %d, label: %s", new Object[] { Integer.valueOf(m), localdrk2 });
        if (m > 0) {
          localdrp.a(localdrk1, localdrk2);
        }
      }
    }
  }
  
  public final boolean k()
  {
    return true;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: bipush 10
    //   4: invokestatic 682	android/os/Process:setThreadPriority	(I)V
    //   7: aload_0
    //   8: getfield 39	dsn:l	Ldrp;
    //   11: astore 8
    //   13: aload 8
    //   15: getfield 684	drp:B	Z
    //   18: ifeq +28 -> 46
    //   21: getstatic 267	drp:b	Ljava/lang/String;
    //   24: ldc_w 686
    //   27: iconst_0
    //   28: anewarray 252	java/lang/Object
    //   31: invokestatic 278	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   34: pop
    //   35: aload 8
    //   37: iconst_1
    //   38: putfield 689	drp:F	Z
    //   41: aload 8
    //   43: invokevirtual 691	drp:k	()V
    //   46: getstatic 267	drp:b	Ljava/lang/String;
    //   49: iconst_3
    //   50: invokestatic 229	dri:a	(Ljava/lang/String;I)Z
    //   53: ifeq +609 -> 662
    //   56: invokestatic 697	android/os/SystemClock:elapsedRealtime	()J
    //   59: lstore 6
    //   61: aload_0
    //   62: getfield 39	dsn:l	Ldrp;
    //   65: getfield 395	drp:K	Ljava/lang/Thread;
    //   68: ifnull +261 -> 329
    //   71: iconst_1
    //   72: istore_1
    //   73: iload_1
    //   74: istore_3
    //   75: lload 6
    //   77: lstore 4
    //   79: aload_0
    //   80: getfield 260	dsn:m	Ljava/lang/Thread;
    //   83: ifnull +11 -> 94
    //   86: iconst_1
    //   87: istore_2
    //   88: lload 6
    //   90: lstore 4
    //   92: iload_1
    //   93: istore_3
    //   94: aload_0
    //   95: getfield 39	dsn:l	Ldrp;
    //   98: getfield 700	drp:G	Ljava/lang/Object;
    //   101: astore 8
    //   103: aload 8
    //   105: monitorenter
    //   106: getstatic 267	drp:b	Ljava/lang/String;
    //   109: iconst_3
    //   110: invokestatic 229	dri:a	(Ljava/lang/String;I)Z
    //   113: ifeq +56 -> 169
    //   116: invokestatic 697	android/os/SystemClock:elapsedRealtime	()J
    //   119: lload 4
    //   121: lsub
    //   122: lstore 6
    //   124: lload 6
    //   126: ldc2_w 701
    //   129: lcmp
    //   130: ifle +39 -> 169
    //   133: getstatic 267	drp:b	Ljava/lang/String;
    //   136: ldc_w 704
    //   139: iconst_3
    //   140: anewarray 252	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: lload 6
    //   147: invokestatic 545	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: iload_3
    //   154: invokestatic 709	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   157: aastore
    //   158: dup
    //   159: iconst_2
    //   160: iload_2
    //   161: invokestatic 709	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   164: aastore
    //   165: invokestatic 278	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   168: pop
    //   169: aload_0
    //   170: getfield 39	dsn:l	Ldrp;
    //   173: iconst_0
    //   174: putfield 689	drp:F	Z
    //   177: new 711	dtd
    //   180: dup
    //   181: invokespecial 712	dtd:<init>	()V
    //   184: astore 9
    //   186: aload 9
    //   188: iconst_1
    //   189: putfield 714	dtd:b	Z
    //   192: aload_0
    //   193: getfield 122	dsn:d	Ldrk;
    //   196: ifnull +18 -> 214
    //   199: aload 9
    //   201: aload_0
    //   202: getfield 122	dsn:d	Ldrk;
    //   205: getfield 343	drk:a	J
    //   208: invokestatic 545	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   211: putfield 717	dtd:d	Ljava/lang/Long;
    //   214: aload_0
    //   215: getfield 39	dsn:l	Ldrp;
    //   218: aload 9
    //   220: invokestatic 720	drp:a	(Ldrp;Ldtd;)Z
    //   223: pop
    //   224: aload 8
    //   226: monitorexit
    //   227: getstatic 267	drp:b	Ljava/lang/String;
    //   230: iconst_3
    //   231: invokestatic 229	dri:a	(Ljava/lang/String;I)Z
    //   234: ifeq +42 -> 276
    //   237: invokestatic 697	android/os/SystemClock:elapsedRealtime	()J
    //   240: lload 4
    //   242: lsub
    //   243: lstore 4
    //   245: lload 4
    //   247: ldc2_w 701
    //   250: lcmp
    //   251: ifle +25 -> 276
    //   254: getstatic 267	drp:b	Ljava/lang/String;
    //   257: ldc_w 722
    //   260: iconst_1
    //   261: anewarray 252	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: lload 4
    //   268: invokestatic 545	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   271: aastore
    //   272: invokestatic 278	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   275: pop
    //   276: aload_0
    //   277: invokevirtual 724	dsn:h	()V
    //   280: aload_0
    //   281: iconst_0
    //   282: putfield 725	dsn:o	Z
    //   285: aload_0
    //   286: iconst_0
    //   287: putfield 727	dsn:p	I
    //   290: aload_0
    //   291: getfield 39	dsn:l	Ldrp;
    //   294: iconst_0
    //   295: iconst_0
    //   296: invokevirtual 729	drp:a	(II)V
    //   299: aload_0
    //   300: getfield 39	dsn:l	Ldrp;
    //   303: iconst_1
    //   304: putfield 732	drp:af	Z
    //   307: aload_0
    //   308: invokevirtual 734	dsn:i	()V
    //   311: aload_0
    //   312: getfield 737	dsn:n	Ljava/lang/Object;
    //   315: astore 8
    //   317: aload 8
    //   319: monitorenter
    //   320: aload_0
    //   321: aconst_null
    //   322: putfield 260	dsn:m	Ljava/lang/Thread;
    //   325: aload 8
    //   327: monitorexit
    //   328: return
    //   329: iconst_0
    //   330: istore_1
    //   331: goto -258 -> 73
    //   334: astore 9
    //   336: aload 8
    //   338: monitorexit
    //   339: aload 9
    //   341: athrow
    //   342: astore 8
    //   344: getstatic 267	drp:b	Ljava/lang/String;
    //   347: ldc_w 739
    //   350: iconst_1
    //   351: anewarray 252	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: aload 8
    //   358: invokevirtual 742	java/io/IOException:getMessage	()Ljava/lang/String;
    //   361: aastore
    //   362: invokestatic 744	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   365: pop
    //   366: aload_0
    //   367: iconst_1
    //   368: putfield 725	dsn:o	Z
    //   371: aload_0
    //   372: iconst_1
    //   373: putfield 727	dsn:p	I
    //   376: aload_0
    //   377: getfield 39	dsn:l	Ldrp;
    //   380: iconst_1
    //   381: iconst_0
    //   382: invokevirtual 729	drp:a	(II)V
    //   385: aload_0
    //   386: getfield 39	dsn:l	Ldrp;
    //   389: iconst_1
    //   390: putfield 732	drp:af	Z
    //   393: goto -86 -> 307
    //   396: astore 8
    //   398: getstatic 267	drp:b	Ljava/lang/String;
    //   401: ldc_w 746
    //   404: iconst_1
    //   405: anewarray 252	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: aload 8
    //   412: invokevirtual 747	dsj:getMessage	()Ljava/lang/String;
    //   415: aastore
    //   416: invokestatic 744	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   419: pop
    //   420: aload_0
    //   421: iconst_1
    //   422: putfield 725	dsn:o	Z
    //   425: aload_0
    //   426: iconst_2
    //   427: putfield 727	dsn:p	I
    //   430: aload_0
    //   431: getfield 39	dsn:l	Ldrp;
    //   434: iconst_2
    //   435: iconst_0
    //   436: invokevirtual 729	drp:a	(II)V
    //   439: aload_0
    //   440: getfield 39	dsn:l	Ldrp;
    //   443: iconst_1
    //   444: putfield 732	drp:af	Z
    //   447: goto -140 -> 307
    //   450: astore 8
    //   452: getstatic 267	drp:b	Ljava/lang/String;
    //   455: ldc_w 749
    //   458: iconst_1
    //   459: anewarray 252	java/lang/Object
    //   462: dup
    //   463: iconst_0
    //   464: aload 8
    //   466: invokevirtual 750	dty:getMessage	()Ljava/lang/String;
    //   469: aastore
    //   470: invokestatic 744	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   473: pop
    //   474: aload_0
    //   475: iconst_1
    //   476: putfield 725	dsn:o	Z
    //   479: aload_0
    //   480: iconst_3
    //   481: putfield 727	dsn:p	I
    //   484: aload_0
    //   485: getfield 39	dsn:l	Ldrp;
    //   488: bipush 7
    //   490: iconst_4
    //   491: invokevirtual 729	drp:a	(II)V
    //   494: aload_0
    //   495: getfield 39	dsn:l	Ldrp;
    //   498: iconst_1
    //   499: putfield 732	drp:af	Z
    //   502: goto -195 -> 307
    //   505: astore 8
    //   507: getstatic 267	drp:b	Ljava/lang/String;
    //   510: ldc_w 752
    //   513: iconst_1
    //   514: anewarray 252	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: aload 8
    //   521: invokevirtual 753	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   524: aastore
    //   525: invokestatic 744	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   528: pop
    //   529: aload_0
    //   530: iconst_1
    //   531: putfield 725	dsn:o	Z
    //   534: aload_0
    //   535: iconst_4
    //   536: putfield 727	dsn:p	I
    //   539: aload_0
    //   540: getfield 39	dsn:l	Ldrp;
    //   543: bipush 9
    //   545: iconst_0
    //   546: invokevirtual 729	drp:a	(II)V
    //   549: aload_0
    //   550: getfield 39	dsn:l	Ldrp;
    //   553: iconst_1
    //   554: putfield 732	drp:af	Z
    //   557: goto -250 -> 307
    //   560: astore 8
    //   562: getstatic 267	drp:b	Ljava/lang/String;
    //   565: aload 8
    //   567: ldc_w 755
    //   570: iconst_0
    //   571: anewarray 252	java/lang/Object
    //   574: invokestatic 757	dri:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   577: pop
    //   578: aload_0
    //   579: iconst_1
    //   580: putfield 725	dsn:o	Z
    //   583: aload_0
    //   584: iconst_5
    //   585: putfield 727	dsn:p	I
    //   588: aload_0
    //   589: getfield 39	dsn:l	Ldrp;
    //   592: iconst_3
    //   593: iconst_0
    //   594: invokevirtual 729	drp:a	(II)V
    //   597: aload_0
    //   598: getfield 39	dsn:l	Ldrp;
    //   601: iconst_1
    //   602: putfield 732	drp:af	Z
    //   605: goto -298 -> 307
    //   608: astore 8
    //   610: aload_0
    //   611: iconst_1
    //   612: putfield 725	dsn:o	Z
    //   615: aload_0
    //   616: iconst_0
    //   617: putfield 727	dsn:p	I
    //   620: aload_0
    //   621: getfield 39	dsn:l	Ldrp;
    //   624: bipush 16
    //   626: iconst_0
    //   627: invokevirtual 729	drp:a	(II)V
    //   630: aload_0
    //   631: getfield 39	dsn:l	Ldrp;
    //   634: iconst_1
    //   635: putfield 732	drp:af	Z
    //   638: goto -331 -> 307
    //   641: astore 8
    //   643: aload_0
    //   644: getfield 39	dsn:l	Ldrp;
    //   647: iconst_1
    //   648: putfield 732	drp:af	Z
    //   651: aload 8
    //   653: athrow
    //   654: astore 9
    //   656: aload 8
    //   658: monitorexit
    //   659: aload 9
    //   661: athrow
    //   662: lconst_0
    //   663: lstore 4
    //   665: iconst_0
    //   666: istore_3
    //   667: goto -573 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	this	dsn
    //   72	259	1	bool1	boolean
    //   1	160	2	bool2	boolean
    //   74	593	3	bool3	boolean
    //   77	587	4	l1	long
    //   59	87	6	l2	long
    //   342	15	8	localIOException	java.io.IOException
    //   396	15	8	localdsj	dsj
    //   450	15	8	localdty	dty
    //   505	15	8	localSQLiteException	android.database.sqlite.SQLiteException
    //   560	6	8	localdsl	dsl
    //   608	1	8	localdtf	dtf
    //   641	16	8	localObject2	Object
    //   184	35	9	localdtd	dtd
    //   334	6	9	localObject3	Object
    //   654	6	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   106	124	334	finally
    //   133	169	334	finally
    //   169	214	334	finally
    //   214	227	334	finally
    //   336	339	334	finally
    //   7	46	342	java/io/IOException
    //   46	71	342	java/io/IOException
    //   79	86	342	java/io/IOException
    //   94	106	342	java/io/IOException
    //   227	245	342	java/io/IOException
    //   254	276	342	java/io/IOException
    //   276	299	342	java/io/IOException
    //   339	342	342	java/io/IOException
    //   7	46	396	dsj
    //   46	71	396	dsj
    //   79	86	396	dsj
    //   94	106	396	dsj
    //   227	245	396	dsj
    //   254	276	396	dsj
    //   276	299	396	dsj
    //   339	342	396	dsj
    //   7	46	450	dty
    //   46	71	450	dty
    //   79	86	450	dty
    //   94	106	450	dty
    //   227	245	450	dty
    //   254	276	450	dty
    //   276	299	450	dty
    //   339	342	450	dty
    //   7	46	505	android/database/sqlite/SQLiteException
    //   46	71	505	android/database/sqlite/SQLiteException
    //   79	86	505	android/database/sqlite/SQLiteException
    //   94	106	505	android/database/sqlite/SQLiteException
    //   227	245	505	android/database/sqlite/SQLiteException
    //   254	276	505	android/database/sqlite/SQLiteException
    //   276	299	505	android/database/sqlite/SQLiteException
    //   339	342	505	android/database/sqlite/SQLiteException
    //   7	46	560	dsl
    //   46	71	560	dsl
    //   79	86	560	dsl
    //   94	106	560	dsl
    //   227	245	560	dsl
    //   254	276	560	dsl
    //   276	299	560	dsl
    //   339	342	560	dsl
    //   7	46	608	dtf
    //   46	71	608	dtf
    //   79	86	608	dtf
    //   94	106	608	dtf
    //   227	245	608	dtf
    //   254	276	608	dtf
    //   276	299	608	dtf
    //   339	342	608	dtf
    //   7	46	641	finally
    //   46	71	641	finally
    //   79	86	641	finally
    //   94	106	641	finally
    //   227	245	641	finally
    //   254	276	641	finally
    //   276	299	641	finally
    //   339	342	641	finally
    //   344	385	641	finally
    //   398	439	641	finally
    //   452	494	641	finally
    //   507	549	641	finally
    //   562	597	641	finally
    //   610	630	641	finally
    //   320	328	654	finally
    //   656	659	654	finally
  }
}

/* Location:
 * Qualified Name:     dsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */