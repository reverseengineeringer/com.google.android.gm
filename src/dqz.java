import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class dqz
{
  private static final String a = cvl.a;
  private static final Map<String, Integer> p = new hen().b("^f", Integer.valueOf(dge.dY)).b("^^out", Integer.valueOf(dge.dX)).b("^i", Integer.valueOf(dge.dD)).b("^r", Integer.valueOf(dge.dA)).b("^b", Integer.valueOf(dge.dy)).b("^all", Integer.valueOf(dge.dx)).b("^u", Integer.valueOf(dge.ed)).b("^k", Integer.valueOf(dge.ec)).b("^s", Integer.valueOf(dge.ea)).b("^t", Integer.valueOf(dge.eb)).b("^g", Integer.valueOf(dge.dB)).b("^io_im", Integer.valueOf(dge.dC)).b("^iim", Integer.valueOf(dge.dJ)).b("^sq_ig_i_personal", Integer.valueOf(dge.dG)).b("^sq_ig_i_social", Integer.valueOf(dge.dI)).b("^sq_ig_i_promo", Integer.valueOf(dge.dH)).b("^sq_ig_i_notification", Integer.valueOf(dge.dF)).b("^sq_ig_i_group", Integer.valueOf(dge.dE)).b();
  private static final Pattern r = Pattern.compile("\\^\\*\\^");
  private final String b;
  private final long c;
  private String d;
  private String e;
  private String f;
  private int g;
  private int h;
  private boolean i;
  private final Map<String, CharSequence> j;
  private final boolean k;
  private int l = 0;
  private int m = 0;
  private String n;
  private boolean o;
  private long q;
  
  dqz(Context paramContext, String paramString1, long paramLong1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, long paramLong2, Map<String, CharSequence> paramMap)
  {
    b = paramString1;
    c = paramLong1;
    k = paramBoolean;
    j = paramMap;
    if (!paramString2.equals(d))
    {
      d = paramString2;
      i = dpy.f(d);
      n = null;
    }
    if (!hbc.a(paramString4, f))
    {
      f = paramString4;
      n = null;
    }
    paramString1 = paramString3;
    if (i) {
      if (paramString3 != null)
      {
        paramString1 = paramString3;
        if (!d.equals(paramString3)) {}
      }
      else
      {
        paramString1 = b(paramContext);
      }
    }
    if (!hbc.a(paramString1, e))
    {
      e = paramString1;
      n = null;
    }
    g = paramInt1;
    h = paramInt2;
    o = true;
    l = paramInt3;
    m = paramInt4;
    q = paramLong2;
  }
  
  private dqz(String paramString)
  {
    b = paramString;
    Object localObject;
    c = localObject;
    String str1;
    d = str1;
    i = dpy.f(str1);
    j = null;
    String str2;
    if ((i) && (str2.equals(d))) {}
    for (e = b(null);; e = str2)
    {
      String str3;
      f = str3;
      o = false;
      boolean bool;
      k = bool;
      return;
    }
  }
  
  public static int a(String paramString)
  {
    int i1 = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        return dfx.o;
        if (paramString.equals("^sq_ig_i_personal"))
        {
          i1 = 0;
          continue;
          if (paramString.equals("^sq_ig_i_social"))
          {
            i1 = 1;
            continue;
            if (paramString.equals("^sq_ig_i_promo"))
            {
              i1 = 2;
              continue;
              if (paramString.equals("^sq_ig_i_notification"))
              {
                i1 = 3;
                continue;
                if (paramString.equals("^sq_ig_i_group"))
                {
                  i1 = 4;
                  continue;
                  if (paramString.equals("^f"))
                  {
                    i1 = 5;
                    continue;
                    if (paramString.equals("^i"))
                    {
                      i1 = 6;
                      continue;
                      if (paramString.equals("^iim"))
                      {
                        i1 = 7;
                        continue;
                        if (paramString.equals("^r"))
                        {
                          i1 = 8;
                          continue;
                          if (paramString.equals("^u"))
                          {
                            i1 = 9;
                            continue;
                            if (paramString.equals("^k"))
                            {
                              i1 = 10;
                              continue;
                              if (paramString.equals("^s"))
                              {
                                i1 = 11;
                                continue;
                                if (paramString.equals("^t"))
                                {
                                  i1 = 12;
                                  continue;
                                  if (paramString.equals("^all"))
                                  {
                                    i1 = 13;
                                    continue;
                                    if (paramString.equals("^^out"))
                                    {
                                      i1 = 14;
                                      continue;
                                      if (paramString.equals("^im"))
                                      {
                                        i1 = 15;
                                        continue;
                                        if (paramString.equals("^io_im")) {
                                          i1 = 16;
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return dfx.m;
    return dfx.t;
    return dfx.r;
    return dfx.x;
    return dfx.k;
    return dfx.s;
    return dfx.m;
    return dfx.q;
    return dfx.j;
    return dfx.w;
    return dfx.v;
    return dfx.n;
    return dfx.u;
    return dfx.i;
    return dfx.p;
    return dfx.l;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = dpy.f(paramString2);
    if (paramString2.equals("^g")) {}
    for (paramString1 = dyx.f;; paramString1 = dyx.a(a(bool, paramString3), paramString1))
    {
      return paramString1[0];
      if (dpy.g(paramString2))
      {
        paramString1 = drp.a(paramString1);
        if (paramString1 != null)
        {
          paramString1 = (drn)o.g().get(paramString2);
          if (paramString1 != null) {
            return c;
          }
        }
        return dyx.a();
      }
    }
  }
  
  static Uri a(String paramString, Long paramLong)
  {
    return Uri.withAppendedPath(dpy.c(paramString), paramLong.toString());
  }
  
  /* Error */
  static dqz a(Map<String, CharSequence> paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_1
    //   7: ldc_w 319
    //   10: invokevirtual 322	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_m1
    //   16: if_icmpeq +42 -> 58
    //   19: aload_1
    //   20: iconst_0
    //   21: iload_3
    //   22: invokevirtual 326	java/lang/String:substring	(II)Ljava/lang/String;
    //   25: astore 8
    //   27: aload_2
    //   28: ifnull +50 -> 78
    //   31: aload_2
    //   32: aload 8
    //   34: invokeinterface 329 2 0
    //   39: ifeq +39 -> 78
    //   42: aload_2
    //   43: aload 8
    //   45: invokeinterface 286 2 0
    //   50: checkcast 2	dqz
    //   53: astore 7
    //   55: aload 7
    //   57: areturn
    //   58: getstatic 37	dqz:a	Ljava/lang/String;
    //   61: ldc_w 331
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: invokestatic 336	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   75: pop
    //   76: aconst_null
    //   77: areturn
    //   78: aload_1
    //   79: getstatic 158	dqz:r	Ljava/util/regex/Pattern;
    //   82: invokestatic 342	android/text/TextUtils:split	(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;
    //   85: astore 9
    //   87: aload 9
    //   89: arraylength
    //   90: iconst_5
    //   91: if_icmplt -36 -> 55
    //   94: aload 8
    //   96: invokestatic 345	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   99: invokevirtual 349	java/lang/Long:longValue	()J
    //   102: lstore 5
    //   104: aload 9
    //   106: iconst_1
    //   107: aaload
    //   108: astore 7
    //   110: aload 9
    //   112: iconst_2
    //   113: aaload
    //   114: astore 10
    //   116: aload 9
    //   118: iconst_3
    //   119: aaload
    //   120: astore 11
    //   122: aload 9
    //   124: iconst_4
    //   125: aaload
    //   126: invokestatic 352	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   129: invokevirtual 355	java/lang/Integer:intValue	()I
    //   132: istore_3
    //   133: iload_3
    //   134: ifle +67 -> 201
    //   137: new 2	dqz
    //   140: dup
    //   141: aload_0
    //   142: lload 5
    //   144: aload 7
    //   146: aload 10
    //   148: aload 11
    //   150: iload 4
    //   152: aconst_null
    //   153: invokespecial 357	dqz:<init>	(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V
    //   156: astore_0
    //   157: aload_2
    //   158: ifnull +13 -> 171
    //   161: aload_2
    //   162: aload 8
    //   164: aload_0
    //   165: invokeinterface 361 3 0
    //   170: pop
    //   171: aload_0
    //   172: areturn
    //   173: astore_0
    //   174: getstatic 37	dqz:a	Ljava/lang/String;
    //   177: ldc_w 363
    //   180: iconst_2
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_0
    //   187: invokevirtual 366	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: aload_1
    //   194: aastore
    //   195: invokestatic 336	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   198: pop
    //   199: aconst_null
    //   200: areturn
    //   201: iconst_0
    //   202: istore 4
    //   204: goto -67 -> 137
    //   207: astore_0
    //   208: getstatic 37	dqz:a	Ljava/lang/String;
    //   211: ldc_w 368
    //   214: iconst_2
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: aload_0
    //   221: invokevirtual 366	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: aload_1
    //   228: aastore
    //   229: invokestatic 336	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   232: pop
    //   233: aconst_null
    //   234: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramMap	Map<String, CharSequence>
    //   6	222	1	str1	String
    //   27	135	2	localObject	Object
    //   13	121	3	i1	int
    //   4	199	4	bool	boolean
    //   102	41	5	l1	long
    //   1	144	7	localdqz	dqz
    //   25	138	8	str2	String
    //   85	38	9	arrayOfString	String[]
    //   114	33	10	str3	String
    //   120	29	11	str4	String
    // Exception table:
    //   from	to	target	type
    //   94	104	173	java/lang/NumberFormatException
    //   122	133	207	java/lang/NumberFormatException
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = (Integer)p.get(paramString);
    if (paramString != null) {
      return paramContext.getString(paramString.intValue());
    }
    return null;
  }
  
  private static String a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      paramString = "2147483647";
    }
    return paramString;
  }
  
  public static Map<String, CharSequence> a(Context paramContext)
  {
    HashMap localHashMap = null;
    if (paramContext != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("^f", paramContext.getString(dge.dY));
      localHashMap.put("^^out", paramContext.getString(dge.dX));
      localHashMap.put("^i", paramContext.getString(dge.dD));
      localHashMap.put("^r", paramContext.getString(dge.dA));
      localHashMap.put("^b", paramContext.getString(dge.dy));
      localHashMap.put("^all", paramContext.getString(dge.dx));
      localHashMap.put("^u", paramContext.getString(dge.ed));
      localHashMap.put("^k", paramContext.getString(dge.ec));
      localHashMap.put("^s", paramContext.getString(dge.ea));
      localHashMap.put("^t", paramContext.getString(dge.eb));
      localHashMap.put("^g", paramContext.getString(dge.dB));
      localHashMap.put("^io_im", paramContext.getString(dge.dC));
      localHashMap.put("^iim", paramContext.getString(dge.dJ));
      localHashMap.put("^sq_ig_i_personal", paramContext.getString(dge.dG));
      localHashMap.put("^sq_ig_i_social", paramContext.getString(dge.dI));
      localHashMap.put("^sq_ig_i_promo", paramContext.getString(dge.dH));
      localHashMap.put("^sq_ig_i_notification", paramContext.getString(dge.dF));
      localHashMap.put("^sq_ig_i_group", paramContext.getString(dge.dE));
    }
    return localHashMap;
  }
  
  public static int b(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = dpy.f(paramString2);
    if (paramString2.equals("^g")) {}
    for (paramString1 = dyx.f;; paramString1 = dyx.a(a(bool, paramString3), paramString1)) {
      return paramString1[1];
    }
  }
  
  private final String b(Context paramContext)
  {
    Object localObject = null;
    if (j != null) {
      localObject = (CharSequence)j.get(d);
    }
    while (localObject == null)
    {
      return d;
      if (paramContext != null) {
        localObject = a(paramContext, d);
      }
    }
    return ((CharSequence)localObject).toString();
  }
  
  public final long a()
  {
    try
    {
      long l1 = c;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String b()
  {
    try
    {
      String str = d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String c()
  {
    try
    {
      String str = e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int d()
  {
    try
    {
      int i1 = a(b, d, f);
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int e()
  {
    try
    {
      int i1 = b(b, d, f);
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 165	dqz:m	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_3
    //   9: if_icmpne +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	dqz
    //   6	4	1	i1	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public final String toString()
  {
    return d;
  }
}

/* Location:
 * Qualified Name:     dqz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */