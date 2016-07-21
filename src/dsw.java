import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class dsw
  extends dsz
{
  final long a;
  boolean b = false;
  
  dsw(drp paramdrp, long paramLong)
  {
    super(paramdrp);
    a = paramLong;
  }
  
  public final int a(long paramLong, dsy paramdsy, boolean paramBoolean)
  {
    int i = 0;
    ??? = Long.toString(q);
    b = true;
    if (DatabaseUtils.longForQuery(c.p, "SELECT COUNT(*) FROM conversations WHERE _id=?", new String[] { Long.toString(paramLong) }) <= 0L)
    {
      dri.e(drp.b, "Didn't find conversation entry for this conversation", new Object[0]);
      i = 1;
    }
    do
    {
      return i;
      if (paramBoolean) {
        if (DatabaseUtils.longForQuery(c.p, "SELECT COUNT(*) FROM messages WHERE conversation=? AND queryId=?", new String[] { Long.toString(paramLong), ??? }) > 0L) {
          return 2;
        }
      }
    } while (DatabaseUtils.longForQuery(c.p, "SELECT COUNT(*) FROM messages WHERE conversation=? AND queryId=0", new String[] { Long.toString(paramLong) }) != 0L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryId NOT IN (0");
    synchronized (c.ae)
    {
      Iterator localIterator = c.ad.keySet().iterator();
      if (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        localStringBuilder.append(", ");
        localStringBuilder.append(c.ad.get(localLong)).q);
      }
    }
    localStringBuilder.append(")");
    if (c.p.delete("messages", localStringBuilder.toString(), null) != 0) {
      paramdsy.requery();
    }
    if (l()) {
      return 12;
    }
    return 4;
  }
  
  public final Bundle a(Bundle arg1)
  {
    for (;;)
    {
      try
      {
        String str = ???.getString("command");
        Bundle localBundle = new Bundle();
        if ("setVisible".equals(str))
        {
          if (!???.getBoolean("visible")) {}
          synchronized (c.ae)
          {
            c.ad.remove(Long.valueOf(a));
            localBundle.putString("commandResponse", "ok");
            ??? = localBundle;
            return (Bundle)???;
          }
        }
        ??? = super.a(???);
      }
      finally {}
    }
  }
  
  /* Error */
  public final void h()
  {
    // Byte code:
    //   0: new 178	dtq
    //   3: dup
    //   4: aload_0
    //   5: getfield 21	dsw:a	J
    //   8: lconst_0
    //   9: invokespecial 181	dtq:<init>	(JJ)V
    //   12: astore 11
    //   14: getstatic 51	drp:b	Ljava/lang/String;
    //   17: ldc -73
    //   19: iconst_1
    //   20: anewarray 55	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 21	dsw:a	J
    //   29: invokestatic 162	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   32: aastore
    //   33: invokestatic 185	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   36: pop
    //   37: aload_0
    //   38: getfield 14	dsw:c	Ldrp;
    //   41: getfield 188	drp:l	Landroid/accounts/Account;
    //   44: getfield 193	android/accounts/Account:name	Ljava/lang/String;
    //   47: invokestatic 198	ddh:a	(Ljava/lang/String;)I
    //   50: ldc -57
    //   52: ior
    //   53: invokestatic 205	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   56: aload_0
    //   57: getfield 14	dsw:c	Ldrp;
    //   60: getfield 209	drp:m	Ldtn;
    //   63: astore 9
    //   65: new 211	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 212	java/util/ArrayList:<init>	()V
    //   72: astore 10
    //   74: aload 10
    //   76: aload 11
    //   78: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: aload 9
    //   84: ldc -39
    //   86: invokevirtual 222	dtn:a	(Ljava/lang/String;)J
    //   89: lstore_1
    //   90: aload 9
    //   92: ldc -32
    //   94: invokevirtual 222	dtn:a	(Ljava/lang/String;)J
    //   97: lstore_3
    //   98: aload 9
    //   100: ldc -30
    //   102: invokevirtual 222	dtn:a	(Ljava/lang/String;)J
    //   105: lstore 5
    //   107: new 211	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 212	java/util/ArrayList:<init>	()V
    //   114: astore 11
    //   116: invokestatic 231	dmv:a	()Ldmv;
    //   119: aload 9
    //   121: getfield 235	dtn:k	Landroid/content/Context;
    //   124: aload 9
    //   126: getfield 238	dtn:h	Ldth;
    //   129: invokeinterface 242 1 0
    //   134: invokevirtual 246	dmv:g	(Landroid/content/Context;Ljava/lang/String;)Z
    //   137: istore 7
    //   139: aload 9
    //   141: getfield 235	dtn:k	Landroid/content/Context;
    //   144: aload 9
    //   146: getfield 238	dtn:h	Ldth;
    //   149: invokeinterface 242 1 0
    //   154: invokestatic 250	dyb:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   157: istore 8
    //   159: aload 9
    //   161: getfield 254	dtn:i	Ldvd;
    //   164: aload 9
    //   166: getfield 257	dtn:l	Landroid/content/ContentResolver;
    //   169: lload_3
    //   170: lload 5
    //   172: aload 9
    //   174: ldc_w 259
    //   177: invokevirtual 222	dtn:a	(Ljava/lang/String;)J
    //   180: aload 10
    //   182: aload 11
    //   184: aload 9
    //   186: invokevirtual 263	dtn:f	()Ljava/util/ArrayList;
    //   189: iload 7
    //   191: iload 8
    //   193: new 265	dtd
    //   196: dup
    //   197: invokespecial 266	dtd:<init>	()V
    //   200: aconst_null
    //   201: aload 9
    //   203: getfield 235	dtn:k	Landroid/content/Context;
    //   206: aload 9
    //   208: getfield 238	dtn:h	Ldth;
    //   211: invokeinterface 242 1 0
    //   216: invokestatic 271	dnr:a	(Landroid/content/Context;Ljava/lang/String;)Ldnr;
    //   219: invokevirtual 276	dvd:a	(Landroid/content/ContentResolver;JJJLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;ZZLdtd;Ldqu;Ldnr;)Lgww;
    //   222: astore 10
    //   224: aload 9
    //   226: getfield 254	dtn:i	Ldvd;
    //   229: aload 9
    //   231: getfield 257	dtn:l	Landroid/content/ContentResolver;
    //   234: aload 9
    //   236: invokevirtual 279	dtn:b	()I
    //   239: lload_1
    //   240: aload 10
    //   242: iconst_1
    //   243: invokevirtual 282	dvd:a	(Landroid/content/ContentResolver;IJLgww;Z)Lorg/apache/http/client/methods/HttpPost;
    //   246: astore 9
    //   248: aload_0
    //   249: getfield 14	dsw:c	Ldrp;
    //   252: aload 9
    //   254: invokevirtual 285	drp:a	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   257: astore 9
    //   259: aload_0
    //   260: getfield 14	dsw:c	Ldrp;
    //   263: getfield 209	drp:m	Ldtn;
    //   266: aload 9
    //   268: aconst_null
    //   269: aload_0
    //   270: getfield 26	dsw:q	J
    //   273: new 265	dtd
    //   276: dup
    //   277: invokespecial 266	dtd:<init>	()V
    //   280: aconst_null
    //   281: invokevirtual 288	dtn:a	(Lorg/apache/http/HttpResponse;Ldua;JLdtd;Ldqu;)Lduw;
    //   284: pop
    //   285: aload 9
    //   287: invokestatic 291	drp:a	(Lorg/apache/http/HttpResponse;)V
    //   290: getstatic 51	drp:b	Ljava/lang/String;
    //   293: ldc_w 293
    //   296: iconst_0
    //   297: anewarray 55	java/lang/Object
    //   300: invokestatic 185	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   303: pop
    //   304: aload_0
    //   305: getfield 14	dsw:c	Ldrp;
    //   308: iconst_0
    //   309: invokevirtual 296	drp:b	(Z)V
    //   312: ldc -57
    //   314: iconst_1
    //   315: invokestatic 300	android/net/TrafficStats:incrementOperationCount	(II)V
    //   318: invokestatic 303	android/net/TrafficStats:clearThreadStatsTag	()V
    //   321: return
    //   322: astore 10
    //   324: aload 9
    //   326: invokestatic 291	drp:a	(Lorg/apache/http/HttpResponse;)V
    //   329: aload 10
    //   331: athrow
    //   332: astore 9
    //   334: ldc -57
    //   336: iconst_1
    //   337: invokestatic 300	android/net/TrafficStats:incrementOperationCount	(II)V
    //   340: invokestatic 303	android/net/TrafficStats:clearThreadStatsTag	()V
    //   343: aload 9
    //   345: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	dsw
    //   89	151	1	l1	long
    //   97	73	3	l2	long
    //   105	66	5	l3	long
    //   137	53	7	bool1	boolean
    //   157	35	8	bool2	boolean
    //   63	262	9	localObject1	Object
    //   332	12	9	localObject2	Object
    //   72	169	10	localObject3	Object
    //   322	8	10	localObject4	Object
    //   12	171	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   259	285	322	finally
    //   56	259	332	finally
    //   285	312	332	finally
    //   324	332	332	finally
  }
}

/* Location:
 * Qualified Name:     dsw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */