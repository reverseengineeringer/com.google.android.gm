import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import com.android.emailcommon.service.SearchParams;
import java.util.ArrayList;
import java.util.Iterator;

public final class bba
  extends bbd
{
  static final String a = cvl.a;
  private static final nx<bav[]> m = new nx();
  
  public bba(Context paramContext, Intent paramIntent)
  {
    super(paramContext, paramIntent);
    b = paramContext;
  }
  
  public bba(Context paramContext, Class<?> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  private static Bundle a(Context paramContext, long paramLong1, SearchParams paramSearchParams, long paramLong2)
  {
    Account localAccount = Account.a(paramContext, paramLong1);
    Object localObject2 = Mailbox.a(paramContext, a);
    Mailbox localMailbox = Mailbox.a(paramContext, paramLong2);
    if ((localAccount == null) || (localObject2 == null) || (localMailbox == null))
    {
      cvm.b(a, "Attempted search for %s but account or mailbox information was missing", new Object[] { paramSearchParams });
      return bes.a(34, 0);
    }
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("uiSyncStatus", Integer.valueOf(2));
    localMailbox.a(paramContext, localContentValues);
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localawr = awr.a(localAccount, paramContext);
      }
      finally
      {
        awr localawr;
        bdb localbdb;
        Object localObject3;
        int j;
        int k;
        int i;
        Object localObject4;
        continue;
        continue;
      }
      try
      {
        localbdb = localawr.a(d);
        localbdb.a(bdf.a);
        localObject1 = new bav[0];
        if (g == 0)
        {
          localObject3 = localbdb.a(paramSearchParams);
          if (localObject3.length <= 0) {
            continue;
          }
          localObject1 = bat.a((bdg[])localObject3);
          m.b(paramLong1, localObject1);
          continue;
          if (localObject1 == null)
          {
            cvm.b(a, "sortableMessages == null", new Object[0]);
            paramSearchParams = bes.a(0, 0);
            if (localawr != null) {
              localawr.e();
            }
            localContentValues.put("syncTime", Long.valueOf(System.currentTimeMillis()));
            localContentValues.put("uiSyncStatus", Integer.valueOf(0));
            localMailbox.a(paramContext, localContentValues);
            return paramSearchParams;
          }
        }
        else
        {
          localObject1 = (bav[])m.a(paramLong1, null);
          continue;
        }
        j = localObject1.length;
        k = Math.min(j - g, f);
        localMailbox.a(paramContext, j);
        if (k <= 0)
        {
          paramSearchParams = bes.a(0, 0);
          if (localawr != null) {
            localawr.e();
          }
          localContentValues.put("syncTime", Long.valueOf(System.currentTimeMillis()));
          localContentValues.put("uiSyncStatus", Integer.valueOf(0));
          localMailbox.a(paramContext, localContentValues);
          return paramSearchParams;
        }
        localObject3 = new ArrayList();
        i = g;
        if (i < g + k)
        {
          ((ArrayList)localObject3).add(a);
          i += 1;
          continue;
        }
        paramSearchParams = new bcx();
        paramSearchParams.add(bcy.a);
        paramSearchParams.add(bcy.b);
        localObject1 = (bdg[])((ArrayList)localObject3).toArray(new bdg[((ArrayList)localObject3).size()]);
        localbdb.a((bdg[])localObject1, paramSearchParams, new bbb(localAccount, (Mailbox)localObject2, paramLong2, paramContext));
        paramSearchParams.clear();
        paramSearchParams.add(bcy.c);
        localbdb.a((bdg[])localObject1, paramSearchParams, null);
        localObject2 = new bdg[1];
        k = localObject1.length;
        i = 0;
        if (i >= k) {
          continue;
        }
        localObject3 = localObject1[i];
        localObject4 = new ArrayList();
        bco.a((bdn)localObject3, (ArrayList)localObject4, new ArrayList());
        localObject2[0] = localObject3;
        localObject4 = ((ArrayList)localObject4).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          bdn localbdn = (bdn)((Iterator)localObject4).next();
          paramSearchParams.clear();
          paramSearchParams.add(localbdn);
          localbdb.a((bdg[])localObject2, paramSearchParams, null);
          continue;
        }
        baa.a(paramContext, (bdg)localObject3, localAccount, localMailbox, 1);
      }
      finally
      {
        localObject1 = localawr;
        if (localObject1 != null) {
          ((awr)localObject1).e();
        }
        localContentValues.put("syncTime", Long.valueOf(System.currentTimeMillis()));
        localContentValues.put("uiSyncStatus", Integer.valueOf(0));
        localMailbox.a(paramContext, localContentValues);
      }
      i += 1;
    }
    if (localawr != null) {
      localawr.e();
    }
    localContentValues.put("syncTime", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("uiSyncStatus", Integer.valueOf(0));
    localMailbox.a(paramContext, localContentValues);
    return bes.a(0, j);
  }
  
  public final Bundle a(long paramLong1, SearchParams paramSearchParams, long paramLong2)
  {
    try
    {
      paramSearchParams = a(b, paramLong1, paramSearchParams, paramLong2);
      return paramSearchParams;
    }
    catch (bdi paramSearchParams)
    {
      cvm.c(a, paramSearchParams, "Exception in ImapService.searchMessages", new Object[0]);
    }
    return bes.a(bam.a(paramSearchParams), 0);
  }
  
  /* Error */
  public final void a(bfb parambfb, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	bba:b	Landroid/content/Context;
    //   4: lload 4
    //   6: invokestatic 254	com/android/emailcommon/provider/Attachment:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Attachment;
    //   9: astore 11
    //   11: aload 11
    //   13: ifnonnull +16 -> 29
    //   16: aload_1
    //   17: lconst_0
    //   18: lload 4
    //   20: bipush 17
    //   22: iconst_0
    //   23: invokeinterface 259 7 0
    //   28: return
    //   29: aload 11
    //   31: getfield 262	com/android/emailcommon/provider/Attachment:o	J
    //   34: lstore_2
    //   35: aload_0
    //   36: getfield 31	bba:b	Landroid/content/Context;
    //   39: aload 11
    //   41: getfield 262	com/android/emailcommon/provider/Attachment:o	J
    //   44: invokestatic 267	beb:a	(Landroid/content/Context;J)Lbeb;
    //   47: astore 12
    //   49: aload 12
    //   51: ifnonnull +133 -> 184
    //   54: aload_1
    //   55: lload_2
    //   56: lload 4
    //   58: bipush 16
    //   60: iconst_0
    //   61: invokeinterface 259 7 0
    //   66: return
    //   67: astore 11
    //   69: aconst_null
    //   70: astore 10
    //   72: aload 10
    //   74: astore 9
    //   76: getstatic 16	bba:a	Ljava/lang/String;
    //   79: aload 11
    //   81: ldc_w 269
    //   84: iconst_0
    //   85: anewarray 56	java/lang/Object
    //   88: invokestatic 243	cvm:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   91: pop
    //   92: aload 10
    //   94: astore 9
    //   96: new 68	android/content/ContentValues
    //   99: dup
    //   100: iconst_1
    //   101: invokespecial 71	android/content/ContentValues:<init>	(I)V
    //   104: astore 11
    //   106: aload 10
    //   108: astore 9
    //   110: aload 11
    //   112: ldc_w 271
    //   115: iconst_1
    //   116: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokevirtual 83	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   122: aload 10
    //   124: astore 9
    //   126: getstatic 274	com/android/emailcommon/provider/Attachment:a	Landroid/net/Uri;
    //   129: lload 4
    //   131: invokestatic 280	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   134: astore 12
    //   136: aload 10
    //   138: astore 9
    //   140: aload_0
    //   141: getfield 31	bba:b	Landroid/content/Context;
    //   144: invokevirtual 286	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   147: aload 12
    //   149: aload 11
    //   151: aconst_null
    //   152: aconst_null
    //   153: invokevirtual 292	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   156: pop
    //   157: aload 10
    //   159: astore 9
    //   161: aload_1
    //   162: lconst_0
    //   163: lload 4
    //   165: bipush 32
    //   167: iconst_0
    //   168: invokeinterface 259 7 0
    //   173: aload 10
    //   175: ifnull +660 -> 835
    //   178: aload 10
    //   180: invokevirtual 294	bdb:b	()V
    //   183: return
    //   184: aload_0
    //   185: getfield 31	bba:b	Landroid/content/Context;
    //   188: aload 11
    //   190: invokestatic 299	bhn:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Attachment;)Z
    //   193: ifeq +40 -> 233
    //   196: aload 11
    //   198: getfield 302	com/android/emailcommon/provider/Attachment:v	I
    //   201: iconst_3
    //   202: if_icmpne +31 -> 233
    //   205: aload_1
    //   206: lload_2
    //   207: lload 4
    //   209: iconst_0
    //   210: iconst_0
    //   211: invokeinterface 259 7 0
    //   216: return
    //   217: astore_1
    //   218: aconst_null
    //   219: astore 9
    //   221: aload 9
    //   223: ifnull +8 -> 231
    //   226: aload 9
    //   228: invokevirtual 294	bdb:b	()V
    //   231: aload_1
    //   232: athrow
    //   233: aload_1
    //   234: lload_2
    //   235: lload 4
    //   237: iconst_1
    //   238: iconst_0
    //   239: invokeinterface 259 7 0
    //   244: aload_0
    //   245: getfield 31	bba:b	Landroid/content/Context;
    //   248: aload 12
    //   250: getfield 305	beb:V	J
    //   253: invokestatic 42	com/android/emailcommon/provider/Account:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Account;
    //   256: astore 13
    //   258: aload_0
    //   259: getfield 31	bba:b	Landroid/content/Context;
    //   262: aload 12
    //   264: getfield 308	beb:U	J
    //   267: invokestatic 52	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Mailbox;
    //   270: astore 10
    //   272: aload 10
    //   274: ifnonnull +15 -> 289
    //   277: aload_1
    //   278: lload_2
    //   279: lload 4
    //   281: iconst_0
    //   282: iconst_0
    //   283: invokeinterface 259 7 0
    //   288: return
    //   289: aload 10
    //   291: getfield 311	com/android/emailcommon/provider/Mailbox:h	I
    //   294: iconst_4
    //   295: if_icmpne +133 -> 428
    //   298: aload_0
    //   299: getfield 31	bba:b	Landroid/content/Context;
    //   302: astore 9
    //   304: getstatic 314	bds:a	Landroid/net/Uri;
    //   307: astore 14
    //   309: lload_2
    //   310: invokestatic 318	java/lang/Long:toString	(J)Ljava/lang/String;
    //   313: astore 15
    //   315: aload 9
    //   317: aload 14
    //   319: iconst_1
    //   320: anewarray 320	java/lang/String
    //   323: dup
    //   324: iconst_0
    //   325: ldc_w 322
    //   328: aastore
    //   329: ldc_w 324
    //   332: iconst_1
    //   333: anewarray 320	java/lang/String
    //   336: dup
    //   337: iconst_0
    //   338: aload 15
    //   340: aastore
    //   341: aconst_null
    //   342: ldc2_w 325
    //   345: invokestatic 140	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   348: invokestatic 329	bhn:a	(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;
    //   351: invokevirtual 332	java/lang/Long:longValue	()J
    //   354: lstore 7
    //   356: aload 10
    //   358: astore 9
    //   360: lload 7
    //   362: ldc2_w 325
    //   365: lcmp
    //   366: ifeq +470 -> 836
    //   369: aload_0
    //   370: getfield 31	bba:b	Landroid/content/Context;
    //   373: lload 7
    //   375: invokestatic 267	beb:a	(Landroid/content/Context;J)Lbeb;
    //   378: astore 14
    //   380: aload 10
    //   382: astore 9
    //   384: aload 14
    //   386: ifnull +450 -> 836
    //   389: aload_0
    //   390: getfield 31	bba:b	Landroid/content/Context;
    //   393: aload 14
    //   395: getfield 308	beb:U	J
    //   398: invokestatic 52	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Mailbox;
    //   401: astore 9
    //   403: aload 12
    //   405: aload 14
    //   407: getfield 335	beb:x	Ljava/lang/String;
    //   410: putfield 335	beb:x	Ljava/lang/String;
    //   413: goto +423 -> 836
    //   416: aload_1
    //   417: lload_2
    //   418: lload 4
    //   420: iconst_0
    //   421: iconst_0
    //   422: invokeinterface 259 7 0
    //   427: return
    //   428: aload 10
    //   430: astore 9
    //   432: aload 10
    //   434: getfield 311	com/android/emailcommon/provider/Mailbox:h	I
    //   437: bipush 8
    //   439: if_icmpne +397 -> 836
    //   442: aload 10
    //   444: astore 9
    //   446: aload 12
    //   448: getfield 338	beb:W	J
    //   451: lconst_0
    //   452: lcmp
    //   453: ifeq +383 -> 836
    //   456: aload_0
    //   457: getfield 31	bba:b	Landroid/content/Context;
    //   460: aload 12
    //   462: getfield 338	beb:W	J
    //   465: invokestatic 52	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Mailbox;
    //   468: astore 9
    //   470: goto +366 -> 836
    //   473: aload 13
    //   475: invokestatic 343	bcf:b	(Lcom/android/emailcommon/provider/Account;)I
    //   478: invokestatic 348	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   481: aload 13
    //   483: aload_0
    //   484: getfield 31	bba:b	Landroid/content/Context;
    //   487: invokestatic 91	awr:a	(Lcom/android/emailcommon/provider/Account;Landroid/content/Context;)Lawr;
    //   490: aload 9
    //   492: getfield 94	com/android/emailcommon/provider/Mailbox:d	Ljava/lang/String;
    //   495: invokevirtual 97	awr:a	(Ljava/lang/String;)Lbdb;
    //   498: astore 10
    //   500: aload 10
    //   502: astore 9
    //   504: aload 10
    //   506: getstatic 102	bdf:a	I
    //   509: invokevirtual 106	bdb:a	(I)V
    //   512: aload 10
    //   514: astore 9
    //   516: aload 10
    //   518: aload 12
    //   520: getfield 335	beb:x	Ljava/lang/String;
    //   523: invokevirtual 351	bdb:b	(Ljava/lang/String;)Lbdg;
    //   526: astore 12
    //   528: aload 10
    //   530: astore 9
    //   532: new 353	bci
    //   535: dup
    //   536: invokespecial 354	bci:<init>	()V
    //   539: astore 13
    //   541: aload 10
    //   543: astore 9
    //   545: aload 13
    //   547: aload 11
    //   549: getfield 357	com/android/emailcommon/provider/Attachment:k	J
    //   552: l2i
    //   553: putfield 359	bci:c	I
    //   556: aload 10
    //   558: astore 9
    //   560: aload 13
    //   562: ldc_w 361
    //   565: aload 11
    //   567: getfield 364	com/android/emailcommon/provider/Attachment:p	Ljava/lang/String;
    //   570: invokevirtual 367	bci:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: aload 10
    //   575: astore 9
    //   577: aload 13
    //   579: ldc_w 369
    //   582: ldc_w 371
    //   585: iconst_2
    //   586: anewarray 56	java/lang/Object
    //   589: dup
    //   590: iconst_0
    //   591: aload 11
    //   593: getfield 374	com/android/emailcommon/provider/Attachment:j	Ljava/lang/String;
    //   596: aastore
    //   597: dup
    //   598: iconst_1
    //   599: aload 11
    //   601: getfield 377	com/android/emailcommon/provider/Attachment:i	Ljava/lang/String;
    //   604: aastore
    //   605: invokestatic 381	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   608: invokevirtual 367	bci:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   611: aload 10
    //   613: astore 9
    //   615: aload 13
    //   617: ldc_w 383
    //   620: ldc_w 385
    //   623: invokevirtual 367	bci:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   626: aload 10
    //   628: astore 9
    //   630: new 387	bcn
    //   633: dup
    //   634: invokespecial 388	bcn:<init>	()V
    //   637: astore 14
    //   639: aload 10
    //   641: astore 9
    //   643: aload 14
    //   645: ldc_w 390
    //   648: invokevirtual 393	bcn:a	(Ljava/lang/String;)V
    //   651: aload 10
    //   653: astore 9
    //   655: aload 14
    //   657: aload 13
    //   659: invokevirtual 396	bcn:a	(Lbcv;)V
    //   662: aload 10
    //   664: astore 9
    //   666: aload 12
    //   668: ldc_w 369
    //   671: ldc_w 398
    //   674: invokevirtual 399	bdg:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: aload 10
    //   679: astore 9
    //   681: aload 12
    //   683: aload 14
    //   685: invokevirtual 402	bdg:a	(Lbcu;)V
    //   688: aload 10
    //   690: astore 9
    //   692: new 172	bcx
    //   695: dup
    //   696: invokespecial 173	bcx:<init>	()V
    //   699: astore 14
    //   701: aload 10
    //   703: astore 9
    //   705: aload 14
    //   707: aload 13
    //   709: invokevirtual 179	bcx:add	(Ljava/lang/Object;)Z
    //   712: pop
    //   713: aload 10
    //   715: astore 9
    //   717: new 404	bbc
    //   720: dup
    //   721: aload_0
    //   722: lload_2
    //   723: lload 4
    //   725: aload_1
    //   726: invokespecial 407	bbc:<init>	(Lbba;JJLbfb;)V
    //   729: astore 15
    //   731: aload 10
    //   733: astore 9
    //   735: aload 10
    //   737: iconst_1
    //   738: anewarray 187	bdg
    //   741: dup
    //   742: iconst_0
    //   743: aload 12
    //   745: aastore
    //   746: aload 14
    //   748: aload 15
    //   750: invokevirtual 201	bdb:a	([Lbdg;Lbcx;Lbdd;)V
    //   753: aload 10
    //   755: astore 9
    //   757: aload 13
    //   759: getfield 410	bci:b	Lbcu;
    //   762: ifnonnull +20 -> 782
    //   765: aload 10
    //   767: astore 9
    //   769: new 236	bdi
    //   772: dup
    //   773: bipush 28
    //   775: ldc_w 412
    //   778: invokespecial 415	bdi:<init>	(ILjava/lang/String;)V
    //   781: athrow
    //   782: aload 10
    //   784: astore 9
    //   786: aload_0
    //   787: getfield 31	bba:b	Landroid/content/Context;
    //   790: aload 13
    //   792: getfield 410	bci:b	Lbcu;
    //   795: invokeinterface 421 1 0
    //   800: aload 11
    //   802: invokestatic 426	bgt:a	(Landroid/content/Context;Ljava/io/InputStream;Lcom/android/emailcommon/provider/Attachment;)V
    //   805: aload 10
    //   807: astore 9
    //   809: aload_1
    //   810: lload_2
    //   811: lload 4
    //   813: iconst_0
    //   814: iconst_0
    //   815: invokeinterface 259 7 0
    //   820: aload 10
    //   822: ifnull +13 -> 835
    //   825: aload 10
    //   827: invokevirtual 294	bdb:b	()V
    //   830: return
    //   831: astore_1
    //   832: goto -611 -> 221
    //   835: return
    //   836: aload 13
    //   838: ifnull -422 -> 416
    //   841: aload 9
    //   843: ifnonnull -370 -> 473
    //   846: goto -430 -> 416
    //   849: astore 11
    //   851: goto -779 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	854	0	this	bba
    //   0	854	1	parambfb	bfb
    //   0	854	2	paramLong1	long
    //   0	854	4	paramLong2	long
    //   0	854	6	paramBoolean	boolean
    //   354	20	7	l	long
    //   74	768	9	localObject1	Object
    //   70	756	10	localObject2	Object
    //   9	31	11	localAttachment	com.android.emailcommon.provider.Attachment
    //   67	13	11	localbdi1	bdi
    //   104	697	11	localContentValues	ContentValues
    //   849	1	11	localbdi2	bdi
    //   47	697	12	localObject3	Object
    //   256	581	13	localObject4	Object
    //   307	440	14	localObject5	Object
    //   313	436	15	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   0	11	67	bdi
    //   16	28	67	bdi
    //   29	49	67	bdi
    //   54	66	67	bdi
    //   184	216	67	bdi
    //   233	272	67	bdi
    //   277	288	67	bdi
    //   289	356	67	bdi
    //   369	380	67	bdi
    //   389	413	67	bdi
    //   416	427	67	bdi
    //   432	442	67	bdi
    //   446	470	67	bdi
    //   473	500	67	bdi
    //   0	11	217	finally
    //   16	28	217	finally
    //   29	49	217	finally
    //   54	66	217	finally
    //   184	216	217	finally
    //   233	272	217	finally
    //   277	288	217	finally
    //   289	356	217	finally
    //   369	380	217	finally
    //   389	413	217	finally
    //   416	427	217	finally
    //   432	442	217	finally
    //   446	470	217	finally
    //   473	500	217	finally
    //   76	92	831	finally
    //   96	106	831	finally
    //   110	122	831	finally
    //   126	136	831	finally
    //   140	157	831	finally
    //   161	173	831	finally
    //   504	512	831	finally
    //   516	528	831	finally
    //   532	541	831	finally
    //   545	556	831	finally
    //   560	573	831	finally
    //   577	611	831	finally
    //   615	626	831	finally
    //   630	639	831	finally
    //   643	651	831	finally
    //   655	662	831	finally
    //   666	677	831	finally
    //   681	688	831	finally
    //   692	701	831	finally
    //   705	713	831	finally
    //   717	731	831	finally
    //   735	753	831	finally
    //   757	765	831	finally
    //   769	782	831	finally
    //   786	805	831	finally
    //   809	820	831	finally
    //   504	512	849	bdi
    //   516	528	849	bdi
    //   532	541	849	bdi
    //   545	556	849	bdi
    //   560	573	849	bdi
    //   577	611	849	bdi
    //   615	626	849	bdi
    //   630	639	849	bdi
    //   643	651	849	bdi
    //   655	662	849	bdi
    //   666	677	849	bdi
    //   681	688	849	bdi
    //   692	701	849	bdi
    //   705	713	849	bdi
    //   717	731	849	bdi
    //   735	753	849	bdi
    //   757	765	849	bdi
    //   769	782	849	bdi
    //   786	805	849	bdi
    //   809	820	849	bdi
  }
}

/* Location:
 * Qualified Name:     bba
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */