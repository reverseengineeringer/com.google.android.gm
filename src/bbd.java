import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.Bundle;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import com.android.emailcommon.service.SearchParams;

public class bbd
  extends bfn
{
  private static final String a = cvl.a;
  private static final String[] m = { "_id", "serverId", "type" };
  public Context b;
  
  public bbd(Context paramContext, Intent paramIntent)
  {
    super(paramContext, paramIntent);
    b = paramContext;
  }
  
  public bbd(Context paramContext, Class<?> paramClass)
  {
    super(paramContext, paramClass);
    b = paramContext;
  }
  
  private final long a(long paramLong, awr paramawr)
  {
    long l1 = -1L;
    int[] arrayOfInt = Mailbox.T;
    int j = arrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfInt[i];
      long l2 = a(paramLong, paramawr, k);
      if (k != 0) {
        break label63;
      }
      l1 = l2;
    }
    label63:
    for (;;)
    {
      i += 1;
      break;
      return l1;
    }
  }
  
  private final long a(long paramLong, awr paramawr, int paramInt)
  {
    long l2 = Mailbox.a(b, paramLong, paramInt);
    long l1 = l2;
    if (l2 == -1L)
    {
      Mailbox localMailbox = Mailbox.a(paramLong, paramInt);
      if (paramawr.a(paramInt)) {
        r = 8;
      }
      localMailbox.h(b);
      l1 = D;
    }
    return l1;
  }
  
  public Bundle a(long paramLong1, SearchParams paramSearchParams, long paramLong2)
  {
    return bes.a(0, 0);
  }
  
  /* Error */
  public final void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	bbd:b	Landroid/content/Context;
    //   6: lload_1
    //   7: invokestatic 88	com/android/emailcommon/provider/Account:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Account;
    //   10: astore 14
    //   12: aload 14
    //   14: ifnonnull +26 -> 40
    //   17: getstatic 17	bbd:a	Ljava/lang/String;
    //   20: ldc 90
    //   22: iconst_1
    //   23: anewarray 92	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: lload_1
    //   29: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   32: aastore
    //   33: invokestatic 104	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: getfield 34	bbd:b	Landroid/content/Context;
    //   44: lload_1
    //   45: iconst_0
    //   46: invokestatic 54	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;JI)J
    //   49: lstore 7
    //   51: aload 14
    //   53: invokestatic 109	bcf:a	(Lcom/android/emailcommon/provider/Account;)I
    //   56: invokestatic 115	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   59: aconst_null
    //   60: astore 13
    //   62: aconst_null
    //   63: astore 11
    //   65: aload 14
    //   67: aload_0
    //   68: getfield 34	bbd:b	Landroid/content/Context;
    //   71: invokestatic 118	awr:a	(Lcom/android/emailcommon/provider/Account;Landroid/content/Context;)Lawr;
    //   74: astore 12
    //   76: aload 12
    //   78: astore 11
    //   80: lload 7
    //   82: ldc2_w 41
    //   85: lcmp
    //   86: ifne +517 -> 603
    //   89: aload_0
    //   90: lload_1
    //   91: aload 11
    //   93: iconst_0
    //   94: invokespecial 51	bbd:a	(JLawr;I)J
    //   97: lstore 5
    //   99: aload 11
    //   101: invokevirtual 121	awr:b	()[Lbdb;
    //   104: astore 12
    //   106: new 123	java/util/HashSet
    //   109: dup
    //   110: aload 12
    //   112: arraylength
    //   113: invokespecial 125	java/util/HashSet:<init>	(I)V
    //   116: astore 15
    //   118: aload 12
    //   120: arraylength
    //   121: istore 4
    //   123: iconst_0
    //   124: istore_3
    //   125: iload_3
    //   126: iload 4
    //   128: if_icmpge +23 -> 151
    //   131: aload 15
    //   133: aload 12
    //   135: iload_3
    //   136: aaload
    //   137: invokevirtual 131	bdb:c	()Ljava/lang/String;
    //   140: invokevirtual 135	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: iload_3
    //   145: iconst_1
    //   146: iadd
    //   147: istore_3
    //   148: goto -23 -> 125
    //   151: aload_0
    //   152: lload_1
    //   153: aload 11
    //   155: invokespecial 137	bbd:a	(JLawr;)J
    //   158: pop2
    //   159: aload_0
    //   160: getfield 34	bbd:b	Landroid/content/Context;
    //   163: invokevirtual 143	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   166: getstatic 146	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   169: getstatic 27	bbd:m	[Ljava/lang/String;
    //   172: ldc -108
    //   174: iconst_1
    //   175: anewarray 19	java/lang/String
    //   178: dup
    //   179: iconst_0
    //   180: aload 14
    //   182: getfield 149	com/android/emailcommon/provider/Account:D	J
    //   185: invokestatic 152	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   188: aastore
    //   189: aconst_null
    //   190: invokevirtual 158	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   193: astore 12
    //   195: aload 12
    //   197: ifnull +223 -> 420
    //   200: aload 12
    //   202: invokeinterface 164 1 0
    //   207: ifeq +213 -> 420
    //   210: aload 15
    //   212: aload 12
    //   214: iconst_1
    //   215: invokeinterface 168 2 0
    //   220: invokeinterface 173 2 0
    //   225: ifne -30 -> 195
    //   228: aload 12
    //   230: iconst_2
    //   231: invokeinterface 177 2 0
    //   236: istore_3
    //   237: aload 12
    //   239: iconst_0
    //   240: invokeinterface 181 2 0
    //   245: lstore 9
    //   247: iload_3
    //   248: tableswitch	default:+363->611, 0:+-53->195, 1:+52->300, 2:+52->300, 3:+-53->195, 4:+-53->195, 5:+-53->195, 6:+-53->195, 7:+52->300, 8:+-53->195
    //   300: aload_0
    //   301: getfield 34	bbd:b	Landroid/content/Context;
    //   304: lload_1
    //   305: lload 9
    //   307: invokestatic 186	bgt:c	(Landroid/content/Context;JJ)V
    //   310: getstatic 146	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   313: lload 9
    //   315: invokestatic 192	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   318: astore 13
    //   320: aload_0
    //   321: getfield 34	bbd:b	Landroid/content/Context;
    //   324: invokevirtual 143	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   327: aload 13
    //   329: aconst_null
    //   330: aconst_null
    //   331: invokevirtual 196	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   334: pop
    //   335: goto -140 -> 195
    //   338: astore 13
    //   340: lload 5
    //   342: lstore_1
    //   343: getstatic 199	bbw:a	Ljava/lang/String;
    //   346: aload 13
    //   348: ldc -55
    //   350: iconst_1
    //   351: anewarray 92	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: aload 13
    //   358: aastore
    //   359: invokestatic 204	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   362: pop
    //   363: aload 12
    //   365: ifnull +10 -> 375
    //   368: aload 12
    //   370: invokeinterface 207 1 0
    //   375: aload 11
    //   377: ifnull +8 -> 385
    //   380: aload 11
    //   382: invokevirtual 209	awr:e	()V
    //   385: lload 7
    //   387: ldc2_w 41
    //   390: lcmp
    //   391: ifne -354 -> 37
    //   394: lload_1
    //   395: ldc2_w 41
    //   398: lcmp
    //   399: ifeq -362 -> 37
    //   402: aload_0
    //   403: getfield 34	bbd:b	Landroid/content/Context;
    //   406: lload_1
    //   407: invokestatic 214	bam:c	(Landroid/content/Context;J)V
    //   410: goto -373 -> 37
    //   413: astore 11
    //   415: aload_0
    //   416: monitorexit
    //   417: aload 11
    //   419: athrow
    //   420: aload 12
    //   422: ifnull +10 -> 432
    //   425: aload 12
    //   427: invokeinterface 207 1 0
    //   432: aload 11
    //   434: ifnull +8 -> 442
    //   437: aload 11
    //   439: invokevirtual 209	awr:e	()V
    //   442: lload 7
    //   444: ldc2_w 41
    //   447: lcmp
    //   448: ifne -411 -> 37
    //   451: lload 5
    //   453: ldc2_w 41
    //   456: lcmp
    //   457: ifeq -420 -> 37
    //   460: aload_0
    //   461: getfield 34	bbd:b	Landroid/content/Context;
    //   464: lload 5
    //   466: invokestatic 214	bam:c	(Landroid/content/Context;J)V
    //   469: goto -432 -> 37
    //   472: aload 13
    //   474: ifnull +10 -> 484
    //   477: aload 13
    //   479: invokeinterface 207 1 0
    //   484: aload 11
    //   486: ifnull +8 -> 494
    //   489: aload 11
    //   491: invokevirtual 209	awr:e	()V
    //   494: lload 7
    //   496: ldc2_w 41
    //   499: lcmp
    //   500: ifne +21 -> 521
    //   503: lload 5
    //   505: ldc2_w 41
    //   508: lcmp
    //   509: ifeq +12 -> 521
    //   512: aload_0
    //   513: getfield 34	bbd:b	Landroid/content/Context;
    //   516: lload 5
    //   518: invokestatic 214	bam:c	(Landroid/content/Context;J)V
    //   521: aload 12
    //   523: athrow
    //   524: astore 12
    //   526: ldc2_w 41
    //   529: lstore 5
    //   531: goto -59 -> 472
    //   534: astore 12
    //   536: goto -64 -> 472
    //   539: astore 14
    //   541: aload 12
    //   543: astore 13
    //   545: aload 14
    //   547: astore 12
    //   549: goto -77 -> 472
    //   552: astore 14
    //   554: aload 12
    //   556: astore 13
    //   558: aload 14
    //   560: astore 12
    //   562: lload_1
    //   563: lstore 5
    //   565: goto -93 -> 472
    //   568: astore 13
    //   570: ldc2_w 41
    //   573: lstore_1
    //   574: aconst_null
    //   575: astore 12
    //   577: goto -234 -> 343
    //   580: astore 13
    //   582: ldc2_w 41
    //   585: lstore_1
    //   586: aconst_null
    //   587: astore 12
    //   589: goto -246 -> 343
    //   592: astore 13
    //   594: aconst_null
    //   595: astore 12
    //   597: lload 5
    //   599: lstore_1
    //   600: goto -257 -> 343
    //   603: ldc2_w 41
    //   606: lstore 5
    //   608: goto -509 -> 99
    //   611: goto -311 -> 300
    //   614: astore 12
    //   616: aconst_null
    //   617: astore 11
    //   619: ldc2_w 41
    //   622: lstore 5
    //   624: goto -152 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	bbd
    //   0	627	1	paramLong	long
    //   124	124	3	i	int
    //   121	8	4	j	int
    //   97	526	5	l1	long
    //   49	446	7	l2	long
    //   245	69	9	l3	long
    //   63	318	11	localObject1	Object
    //   413	77	11	localObject2	Object
    //   617	1	11	localObject3	Object
    //   74	448	12	localObject4	Object
    //   524	1	12	localObject5	Object
    //   534	8	12	localObject6	Object
    //   547	49	12	localObject7	Object
    //   614	1	12	localObject8	Object
    //   60	268	13	localUri	android.net.Uri
    //   338	140	13	localbdi1	bdi
    //   543	14	13	localObject9	Object
    //   568	1	13	localbdi2	bdi
    //   580	1	13	localbdi3	bdi
    //   592	1	13	localbdi4	bdi
    //   10	171	14	localAccount	Account
    //   539	7	14	localObject10	Object
    //   552	7	14	localObject11	Object
    //   116	95	15	localHashSet	java.util.HashSet
    // Exception table:
    //   from	to	target	type
    //   200	247	338	bdi
    //   300	335	338	bdi
    //   2	12	413	finally
    //   17	37	413	finally
    //   40	59	413	finally
    //   368	375	413	finally
    //   380	385	413	finally
    //   402	410	413	finally
    //   425	432	413	finally
    //   437	442	413	finally
    //   460	469	413	finally
    //   477	484	413	finally
    //   489	494	413	finally
    //   512	521	413	finally
    //   521	524	413	finally
    //   89	99	524	finally
    //   99	123	534	finally
    //   131	144	534	finally
    //   151	195	534	finally
    //   200	247	539	finally
    //   300	335	539	finally
    //   343	363	552	finally
    //   65	76	568	bdi
    //   89	99	580	bdi
    //   99	123	592	bdi
    //   131	144	592	bdi
    //   151	195	592	bdi
    //   65	76	614	finally
  }
  
  public final void c(long paramLong)
  {
    try
    {
      TrafficStats.setThreadStatsTag(bcf.a(paramLong));
      Object localObject = Account.a(b, paramLong);
      if (localObject == null) {
        cvm.e(a, "account %d not found in sendMailImpl", new Object[] { Long.valueOf(paramLong) });
      }
      for (localObject = null;; localObject = new aye(b, (Account)localObject))
      {
        ((aye)localObject).a(false);
        return;
      }
      return;
    }
    catch (bdi localbdi)
    {
      cvm.b(cvm.a, localbdi, "IOError while sending message via EmailService call", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     bbd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */