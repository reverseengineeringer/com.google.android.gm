import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.android.emailcommon.service.SearchParams;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public final class axi
  extends bdb
{
  public int a;
  private final HashMap<String, axk> c = new HashMap();
  private final HashMap<Integer, axk> d = new HashMap();
  private final HashMap<String, Integer> e = new HashMap();
  private final String f;
  private axh g;
  
  public axi(axg paramaxg, String paramString)
  {
    if (paramString.equalsIgnoreCase("INBOX"))
    {
      f = "INBOX";
      return;
    }
    f = paramString;
  }
  
  private final String a(String paramString1, String paramString2)
  {
    a(bdf.a);
    if (paramString1 != null) {
      b.d.a(paramString1, paramString2);
    }
    paramString1 = b.d.a(true);
    if ((paramString1.length() > 1) && (paramString1.charAt(0) == '-'))
    {
      if (paramString1.startsWith("-ERR Exceeded the login limit")) {
        throw new bdi(23, paramString1);
      }
      throw new bdi(25, paramString1);
    }
    return paramString1;
  }
  
  private final void a(int paramInt, axk paramaxk)
  {
    d.put(Integer.valueOf(paramInt), paramaxk);
    c.put(f, paramaxk);
    e.put(f, Integer.valueOf(paramInt));
  }
  
  private final void b(int paramInt)
  {
    if (!d.isEmpty()) {}
    axj localaxj;
    int i;
    for (;;)
    {
      return;
      localaxj = new axj(this);
      if (!axg.g) {
        break;
      }
      i = 1;
      while (i <= paramInt)
      {
        if ((axk)d.get(Integer.valueOf(i)) == null)
        {
          if (!localaxj.a(a(16 + "UIDL " + i, null))) {
            throw new IOException();
          }
          a(i, new axk(b, this));
        }
        i += 1;
      }
    }
    a("UIDL", null);
    for (;;)
    {
      String str = b.d.a(false);
      if (str == null) {
        break;
      }
      if (!localaxj.b(str)) {
        throw new IOException();
      }
      if (c) {
        break;
      }
      i = a;
      if ((i > 0) && (i <= paramInt) && ((axk)d.get(Integer.valueOf(i)) == null)) {
        a(i, new axk(b, this));
      }
    }
  }
  
  private final axh j()
  {
    localaxh = new axh(b);
    try
    {
      a("CAPA", null);
      for (;;)
      {
        String str = b.d.a(true);
        if ((str == null) || (str.equals("."))) {
          break;
        }
        if (str.equalsIgnoreCase("STLS")) {
          a = true;
        }
      }
      return localaxh;
    }
    catch (bdi localbdi) {}
  }
  
  public final int a()
  {
    return bdf.a;
  }
  
  public final bdg a(String paramString)
  {
    if (e.size() == 0) {}
    try
    {
      b(a);
      return (bdg)c.get(paramString);
    }
    catch (IOException paramString)
    {
      b.d.f();
      cvm.d(bbw.a, paramString, "Unable to index during getMessage", new Object[0]);
      throw new bdi(1, "getMessages", paramString);
    }
  }
  
  public final bdk a(axk paramaxk, int paramInt)
  {
    int k = 0;
    int j = 0;
    int i1 = ((Integer)e.get(f)).intValue();
    long l1 = SystemClock.elapsedRealtime();
    int i;
    long l2;
    if (paramInt == -1)
    {
      localObject = String.format(Locale.US, "RETR %d", new Object[] { Integer.valueOf(i1) });
      i = 1;
      j = ((String)localObject).length() + 0;
      localObject = a((String)localObject, null);
      l2 = 0L + (SystemClock.elapsedRealtime() - l1);
      if (localObject == null) {
        break label594;
      }
      k = ((String)localObject).length() + 0;
      l1 = l2;
    }
    for (;;)
    {
      try
      {
        m = ((String)localObject).indexOf("OK");
        if (m > 0)
        {
          m += 3;
          l1 = l2;
        }
      }
      catch (bdi paramaxk)
      {
        int m;
        axl localaxl;
        long l3;
        long l4;
        if (paramInt != -1) {
          continue;
        }
        throw paramaxk;
      }
      try
      {
        if (m <= ((String)localObject).length()) {
          continue;
        }
        l1 = l2;
        cvm.e(bbw.a, "No body length supplied", new Object[0]);
        l1 = l2;
        c = 0;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    l1 = l2;
    Object localObject = b.d.c;
    l1 = l2;
    if (axg.h)
    {
      l1 = l2;
      localObject = new bha((InputStream)localObject);
      label206:
      l1 = l2;
      localObject = new idd((InputStream)localObject);
      l1 = l2;
      localaxl = new axl(b, (InputStream)localObject);
      l1 = l2;
      l3 = SystemClock.elapsedRealtime();
      l1 = l2;
      paramaxk.a(localaxl);
      l1 = l2;
      l2 += SystemClock.elapsedRealtime() - l3;
      l3 = k;
      l1 = l2;
      l4 = ((idd)localObject).a();
      k = (int)(l4 + l3);
    }
    for (l1 = l2;; l1 = l2)
    {
      return new bdk(i, j, k, l1);
      i = j;
      try
      {
        localObject = String.format(Locale.US, "TOP %d %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt) });
        m = 1;
        i = j;
        k = m;
        j = ((String)localObject).length() + 0;
        i = j;
        k = m;
        localObject = a((String)localObject, null);
        i = 1;
      }
      catch (bdi localbdi1)
      {
        j = i;
        m = k;
        try
        {
          String str1 = String.format(Locale.US, "RETR %d", new Object[] { Integer.valueOf(i1) });
          n = k + 1;
          j = i;
          m = n;
          k = i + str1.length();
          j = k;
          m = n;
          str1 = a(str1, null);
          i = n;
          j = k;
        }
        catch (bdi localbdi2)
        {
          cvm.d(bbw.a, 30 + "Can't read message " + i1, new Object[0]);
          i = m;
          str2 = null;
        }
      }
      break;
      l1 = l2;
      int n = str2.indexOf(" ", m);
      if (n > 0) {
        l1 = l2;
      }
      for (String str2 = str2.substring(m, n);; str2 = str2.substring(m))
      {
        l1 = l2;
        c = Integer.parseInt(str2);
        break;
        l1 = l2;
      }
      break label206;
      label594:
      k = 0;
    }
  }
  
  /* Error */
  public final void a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 23	axi:b	Laxg;
    //   9: getfield 59	axg:d	Layd;
    //   12: invokevirtual 289	ayd:e	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifeq +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 45	axi:f	Ljava/lang/String;
    //   27: ldc 37
    //   29: invokevirtual 43	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   32: ifne +21 -> 53
    //   35: new 82	bdi
    //   38: dup
    //   39: bipush 25
    //   41: ldc_w 291
    //   44: invokespecial 85	bdi:<init>	(ILjava/lang/String;)V
    //   47: athrow
    //   48: astore_3
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_3
    //   52: athrow
    //   53: aload_0
    //   54: getfield 23	axi:b	Laxg;
    //   57: getfield 59	axg:d	Layd;
    //   60: invokevirtual 293	ayd:c	()V
    //   63: aload_0
    //   64: aconst_null
    //   65: aconst_null
    //   66: invokespecial 136	axi:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: pop
    //   70: aload_0
    //   71: aload_0
    //   72: invokespecial 295	axi:j	()Laxh;
    //   75: putfield 297	axi:g	Laxh;
    //   78: aload_0
    //   79: getfield 23	axi:b	Laxg;
    //   82: getfield 59	axg:d	Layd;
    //   85: invokevirtual 299	ayd:b	()Z
    //   88: ifeq +31 -> 119
    //   91: aload_0
    //   92: getfield 297	axi:g	Laxh;
    //   95: getfield 174	axh:a	Z
    //   98: ifeq +163 -> 261
    //   101: aload_0
    //   102: ldc -84
    //   104: aconst_null
    //   105: invokespecial 136	axi:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: pop
    //   109: aload_0
    //   110: getfield 23	axi:b	Laxg;
    //   113: getfield 59	axg:d	Layd;
    //   116: invokevirtual 301	ayd:d	()V
    //   119: aload_0
    //   120: getfield 23	axi:b	Laxg;
    //   123: getfield 303	axg:e	Ljava/lang/String;
    //   126: invokestatic 306	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: astore_3
    //   130: aload_3
    //   131: invokevirtual 71	java/lang/String:length	()I
    //   134: ifeq +190 -> 324
    //   137: ldc_w 308
    //   140: aload_3
    //   141: invokevirtual 312	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_3
    //   145: aload_0
    //   146: aload_3
    //   147: ldc_w 314
    //   150: invokespecial 136	axi:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   153: pop
    //   154: aload_0
    //   155: getfield 23	axi:b	Laxg;
    //   158: getfield 315	axg:f	Ljava/lang/String;
    //   161: invokestatic 306	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   164: astore_3
    //   165: aload_3
    //   166: invokevirtual 71	java/lang/String:length	()I
    //   169: ifeq +195 -> 364
    //   172: ldc_w 317
    //   175: aload_3
    //   176: invokevirtual 312	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore_3
    //   180: aload_0
    //   181: aload_3
    //   182: ldc_w 319
    //   185: invokespecial 136	axi:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   188: pop
    //   189: aload_0
    //   190: ldc_w 321
    //   193: aconst_null
    //   194: invokespecial 136	axi:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   197: ldc_w 274
    //   200: invokevirtual 325	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   203: astore_3
    //   204: aload_3
    //   205: arraylength
    //   206: iconst_2
    //   207: if_icmpge +171 -> 378
    //   210: new 140	java/io/IOException
    //   213: dup
    //   214: invokespecial 141	java/io/IOException:<init>	()V
    //   217: astore_3
    //   218: aload_3
    //   219: ifnull +179 -> 398
    //   222: aload_0
    //   223: getfield 23	axi:b	Laxg;
    //   226: getfield 59	axg:d	Layd;
    //   229: invokevirtual 183	ayd:f	()V
    //   232: getstatic 187	bbw:a	Ljava/lang/String;
    //   235: aload_3
    //   236: ldc_w 327
    //   239: iconst_0
    //   240: anewarray 191	java/lang/Object
    //   243: invokestatic 196	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   246: pop
    //   247: new 82	bdi
    //   250: dup
    //   251: bipush 25
    //   253: ldc_w 329
    //   256: aload_3
    //   257: invokespecial 201	bdi:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: athrow
    //   261: getstatic 187	bbw:a	Ljava/lang/String;
    //   264: ldc_w 331
    //   267: iconst_0
    //   268: anewarray 191	java/lang/Object
    //   271: invokestatic 236	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   274: pop
    //   275: new 82	bdi
    //   278: dup
    //   279: iconst_2
    //   280: invokespecial 332	bdi:<init>	(I)V
    //   283: athrow
    //   284: astore_3
    //   285: aload_0
    //   286: getfield 23	axi:b	Laxg;
    //   289: getfield 59	axg:d	Layd;
    //   292: invokevirtual 183	ayd:f	()V
    //   295: getstatic 187	bbw:a	Ljava/lang/String;
    //   298: aload_3
    //   299: ldc_w 334
    //   302: iconst_0
    //   303: anewarray 191	java/lang/Object
    //   306: invokestatic 196	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   309: pop
    //   310: new 82	bdi
    //   313: dup
    //   314: iconst_1
    //   315: aload_3
    //   316: invokevirtual 335	java/io/IOException:toString	()Ljava/lang/String;
    //   319: aload_3
    //   320: invokespecial 201	bdi:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   323: athrow
    //   324: new 39	java/lang/String
    //   327: dup
    //   328: ldc_w 308
    //   331: invokespecial 338	java/lang/String:<init>	(Ljava/lang/String;)V
    //   334: astore_3
    //   335: goto -190 -> 145
    //   338: astore_3
    //   339: getstatic 187	bbw:a	Ljava/lang/String;
    //   342: aload_3
    //   343: ldc_w 340
    //   346: iconst_0
    //   347: anewarray 191	java/lang/Object
    //   350: invokestatic 196	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   353: pop
    //   354: new 342	bcs
    //   357: dup
    //   358: aconst_null
    //   359: aload_3
    //   360: invokespecial 345	bcs:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   363: athrow
    //   364: new 39	java/lang/String
    //   367: dup
    //   368: ldc_w 317
    //   371: invokespecial 338	java/lang/String:<init>	(Ljava/lang/String;)V
    //   374: astore_3
    //   375: goto -195 -> 180
    //   378: aload_0
    //   379: aload_3
    //   380: iconst_1
    //   381: aaload
    //   382: invokestatic 284	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   385: putfield 179	axi:a	I
    //   388: aload 4
    //   390: astore_3
    //   391: goto -173 -> 218
    //   394: astore_3
    //   395: goto -177 -> 218
    //   398: aload_0
    //   399: getfield 31	axi:c	Ljava/util/HashMap;
    //   402: invokevirtual 348	java/util/HashMap:clear	()V
    //   405: aload_0
    //   406: getfield 33	axi:d	Ljava/util/HashMap;
    //   409: invokevirtual 348	java/util/HashMap:clear	()V
    //   412: aload_0
    //   413: getfield 35	axi:e	Ljava/util/HashMap;
    //   416: invokevirtual 348	java/util/HashMap:clear	()V
    //   419: goto -399 -> 20
    //   422: astore_3
    //   423: goto -205 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	axi
    //   0	426	1	paramInt	int
    //   15	2	2	bool	boolean
    //   48	4	3	localObject1	Object
    //   129	128	3	localObject2	Object
    //   284	36	3	localIOException1	IOException
    //   334	1	3	str	String
    //   338	22	3	localbdi	bdi
    //   374	17	3	localObject3	Object
    //   394	1	3	localIOException2	IOException
    //   422	1	3	localNumberFormatException	NumberFormatException
    //   1	388	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   5	16	48	finally
    //   23	48	48	finally
    //   53	119	48	finally
    //   119	145	48	finally
    //   145	180	48	finally
    //   180	189	48	finally
    //   189	218	48	finally
    //   222	261	48	finally
    //   261	284	48	finally
    //   285	324	48	finally
    //   324	335	48	finally
    //   339	364	48	finally
    //   364	375	48	finally
    //   378	388	48	finally
    //   398	419	48	finally
    //   53	119	284	java/io/IOException
    //   119	145	284	java/io/IOException
    //   145	180	284	java/io/IOException
    //   180	189	284	java/io/IOException
    //   261	284	284	java/io/IOException
    //   324	335	284	java/io/IOException
    //   339	364	284	java/io/IOException
    //   364	375	284	java/io/IOException
    //   119	145	338	bdi
    //   145	180	338	bdi
    //   180	189	338	bdi
    //   324	335	338	bdi
    //   364	375	338	bdi
    //   189	218	394	java/io/IOException
    //   378	388	394	java/io/IOException
    //   189	218	422	java/lang/NumberFormatException
    //   378	388	422	java/lang/NumberFormatException
  }
  
  public final void a(Context paramContext, bdg parambdg, boolean paramBoolean) {}
  
  public final void a(bdg[] paramArrayOfbdg, bcx parambcx, bdd parambdd)
  {
    throw new UnsupportedOperationException("Pop3Folder.fetch(Message[], FetchProfile, MessageRetrievalListener)");
  }
  
  public final void a(bdg[] paramArrayOfbdg, bdb parambdb, bde parambde)
  {
    throw new UnsupportedOperationException("copyMessages is not supported in POP3");
  }
  
  /* Error */
  public final void a(bdg[] paramArrayOfbdg, bda[] paramArrayOfbda, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifeq +13 -> 14
    //   4: aload_2
    //   5: getstatic 364	bda:a	Lbda;
    //   8: invokestatic 369	bhn:a	([Ljava/lang/Object;Ljava/lang/Object;)Z
    //   11: ifne +4 -> 15
    //   14: return
    //   15: aload_1
    //   16: arraylength
    //   17: istore 5
    //   19: iconst_0
    //   20: istore 4
    //   22: iload 4
    //   24: iload 5
    //   26: if_icmpge -12 -> 14
    //   29: aload_1
    //   30: iload 4
    //   32: aaload
    //   33: astore_2
    //   34: aload_2
    //   35: getfield 99	bdg:f	Ljava/lang/String;
    //   38: astore_2
    //   39: aload_0
    //   40: getfield 35	axi:e	Ljava/util/HashMap;
    //   43: aload_2
    //   44: invokevirtual 115	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 88	java/lang/Integer
    //   50: invokevirtual 207	java/lang/Integer:intValue	()I
    //   53: istore 6
    //   55: aload_0
    //   56: getstatic 219	java/util/Locale:US	Ljava/util/Locale;
    //   59: ldc_w 371
    //   62: iconst_1
    //   63: anewarray 191	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: iload 6
    //   70: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: aastore
    //   74: invokestatic 225	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: aconst_null
    //   78: invokespecial 136	axi:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: pop
    //   82: aload_0
    //   83: getfield 33	axi:d	Ljava/util/HashMap;
    //   86: iload 6
    //   88: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: invokevirtual 374	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload_0
    //   96: getfield 35	axi:e	Ljava/util/HashMap;
    //   99: aload_2
    //   100: invokevirtual 374	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: iload 4
    //   106: iconst_1
    //   107: iadd
    //   108: istore 4
    //   110: goto -88 -> 22
    //   113: astore_1
    //   114: aload_0
    //   115: getfield 23	axi:b	Laxg;
    //   118: getfield 59	axg:d	Layd;
    //   121: invokevirtual 183	ayd:f	()V
    //   124: getstatic 187	bbw:a	Ljava/lang/String;
    //   127: aload_1
    //   128: ldc_w 376
    //   131: iconst_0
    //   132: anewarray 191	java/lang/Object
    //   135: invokestatic 378	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   138: pop
    //   139: new 82	bdi
    //   142: dup
    //   143: iconst_1
    //   144: ldc_w 380
    //   147: aload_1
    //   148: invokespecial 201	bdi:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   151: athrow
    //   152: astore_2
    //   153: goto -49 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	axi
    //   0	156	1	paramArrayOfbdg	bdg[]
    //   0	156	2	paramArrayOfbda	bda[]
    //   0	156	3	paramBoolean	boolean
    //   20	89	4	i	int
    //   17	10	5	j	int
    //   53	34	6	k	int
    // Exception table:
    //   from	to	target	type
    //   15	19	113	java/io/IOException
    //   34	104	113	java/io/IOException
    //   34	104	152	bdi
  }
  
  public final bdg[] a(SearchParams paramSearchParams)
  {
    return null;
  }
  
  public final bdg b(String paramString)
  {
    return new axk(paramString, this);
  }
  
  public final void b()
  {
    try
    {
      a("QUIT", null);
      b.d.f();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public final axk[] b(int paramInt1, int paramInt2)
  {
    try
    {
      b(paramInt1);
      ArrayList localArrayList = new ArrayList();
      while ((paramInt1 > 0) && (localArrayList.size() < paramInt2))
      {
        axk localaxk = (axk)d.get(Integer.valueOf(paramInt1));
        if (localaxk != null) {
          localArrayList.add(localaxk);
        }
        paramInt1 -= 1;
      }
      return (axk[])localIOException.toArray(new axk[localIOException.size()]);
    }
    catch (IOException localIOException)
    {
      b.d.f();
      cvm.d(bbw.a, localIOException, "exception in getMessages", new Object[0]);
      throw new bdi(1, "getMessages", localIOException);
    }
  }
  
  public final String c()
  {
    return f;
  }
  
  public final boolean d()
  {
    return f.equalsIgnoreCase("INBOX");
  }
  
  public final boolean e()
  {
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof axi)) {
      return f.equals(f);
    }
    return super.equals(paramObject);
  }
  
  public final int f()
  {
    return a;
  }
  
  public final bdg[] g()
  {
    return null;
  }
  
  public final bdk h()
  {
    return null;
  }
  
  public final int hashCode()
  {
    return f.hashCode();
  }
  
  public final Bundle i()
  {
    localBundle = new Bundle();
    int j = -1;
    try
    {
      axj localaxj = new axj(this);
      a("UIDL", null);
      boolean bool;
      do
      {
        String str = b.d.a(false);
        i = j;
        if (str == null) {
          break;
        }
        localaxj.b(str);
        bool = c;
      } while (!bool);
      i = j;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        b.d.f();
        int i = 1;
        localBundle.putString("validate_error_message", localIOException.getMessage());
      }
    }
    localBundle.putInt("validate_result_code", i);
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     axi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */