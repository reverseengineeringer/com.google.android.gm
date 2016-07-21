import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.security.MessageDigest;
import java.util.Date;

public final class ink
  implements imz
{
  private static String h = "localhost";
  private static int i = 0;
  private InetSocketAddress a;
  private InetSocketAddress b;
  private boolean c;
  private boolean d;
  private iml e;
  private inq f;
  private long g = 10000L;
  
  public ink()
  {
    this(null);
  }
  
  public ink(String paramString)
  {
    String str = paramString;
    if (paramString == null)
    {
      paramString = ina.a();
      if (a != null) {
        break label68;
      }
      paramString = null;
      str = paramString;
      if (paramString == null) {
        str = h;
      }
    }
    if (str.equals("0")) {}
    for (paramString = InetAddress.getLocalHost();; paramString = InetAddress.getByName(str))
    {
      a = new InetSocketAddress(paramString, 53);
      return;
      label68:
      paramString = a[0];
      break;
    }
  }
  
  private static ilx a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new ilx(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (IOException localIOException)
    {
      if (imn.a("verbose")) {
        localIOException.printStackTrace();
      }
      paramArrayOfByte = localIOException;
      if (!(localIOException instanceof iog)) {
        paramArrayOfByte = new iog("Error parsing message");
      }
      throw ((iog)paramArrayOfByte);
    }
  }
  
  private static void a(ilx paramilx1, ilx paramilx2, byte[] paramArrayOfByte, inq paraminq)
  {
    if (paraminq == null) {
      return;
    }
    Object localObject = paramilx1.b();
    e = 4;
    ins localins = paramilx2.b();
    paramilx1 = new ion(j, k, l);
    int j;
    if (localins == null)
    {
      j = 1;
      label50:
      if (!imn.a("verbose")) {
        break label612;
      }
      paramilx2 = System.err;
      paramilx1 = String.valueOf(imv.b.c(j));
      if (paramilx1.length() == 0) {
        break label614;
      }
    }
    label453:
    label530:
    label539:
    label612:
    label614:
    for (paramilx1 = "TSIG verify: ".concat(paramilx1);; paramilx1 = new String("TSIG verify: "))
    {
      paramilx2.println(paramilx1);
      return;
      if ((!g.equals(h)) || (!a.equals(i)))
      {
        if (imn.a("verbose")) {
          System.err.println("BADKEY failure");
        }
        j = 17;
        break label50;
      }
      long l1 = System.currentTimeMillis();
      long l2 = b.getTime();
      long l3 = c;
      if (Math.abs(l1 - l2) > 1000L * l3)
      {
        if (imn.a("verbose")) {
          System.err.println("BADTIME failure");
        }
        j = 18;
        break label50;
      }
      if ((localObject != null) && (e != 17) && (e != 16))
      {
        ikt localikt = new ikt((byte)0);
        localikt.b(d.length);
        paramilx1.a(localikt.a());
        paramilx1.a(d);
      }
      a.e();
      localObject = a.a();
      a.c(3);
      paramilx1.a((byte[])localObject);
      j = d;
      int k = localObject.length;
      paramilx1.a(paramArrayOfByte, localObject.length, j - k);
      paramArrayOfByte = new ikt((byte)0);
      g.a(paramArrayOfByte);
      paramArrayOfByte.b(i);
      paramArrayOfByte.a(j);
      a.a(paramArrayOfByte);
      l1 = b.getTime() / 1000L;
      paramArrayOfByte.b((int)(l1 >> 32));
      paramArrayOfByte.a(l1 & 0xFFFFFFFF);
      paramArrayOfByte.b(c);
      paramArrayOfByte.b(e);
      if (f != null)
      {
        paramArrayOfByte.b(f.length);
        paramArrayOfByte.a(f);
        paramilx1.a(paramArrayOfByte.a());
        paramArrayOfByte = d;
        k = a.getDigestLength();
        if (!j.equals("md5")) {
          break label530;
        }
      }
      for (j = 10;; j = k / 2)
      {
        if (paramArrayOfByte.length <= k) {
          break label539;
        }
        if (imn.a("verbose")) {
          System.err.println("BADSIG: signature too long");
        }
        j = 16;
        break;
        paramArrayOfByte.b(0);
        break label453;
      }
      if (paramArrayOfByte.length < j)
      {
        if (imn.a("verbose")) {
          System.err.println("BADSIG: signature too short");
        }
        j = 16;
        break label50;
      }
      if (!paramilx1.a(paramArrayOfByte, true))
      {
        if (imn.a("verbose")) {
          System.err.println("BADSIG: signature verification");
        }
        j = 16;
        break label50;
      }
      e = 1;
      j = 0;
      break label50;
      break;
    }
  }
  
  private final void b(ilx paramilx)
  {
    if ((e == null) || (paramilx.d() != null)) {
      return;
    }
    paramilx.a(e, 3);
  }
  
  private static int c(ilx paramilx)
  {
    paramilx = paramilx.d();
    if (paramilx == null) {
      return 512;
    }
    return i;
  }
  
  /* Error */
  private final ilx d(ilx paramilx)
  {
    // Byte code:
    //   0: new 280	ioj
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 283	ilx:a	()Limw;
    //   8: getfield 160	imw:g	Limj;
    //   11: aload_0
    //   12: getfield 70	ink:a	Ljava/net/InetSocketAddress;
    //   15: aload_0
    //   16: getfield 285	ink:f	Linq;
    //   19: invokespecial 288	ioj:<init>	(Limj;Ljava/net/SocketAddress;Linq;)V
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 41	ink:g	J
    //   27: ldc2_w 194
    //   30: ldiv
    //   31: l2i
    //   32: istore_2
    //   33: iload_2
    //   34: ifge +14 -> 48
    //   37: new 290	java/lang/IllegalArgumentException
    //   40: dup
    //   41: ldc_w 292
    //   44: invokespecial 293	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: aload_3
    //   49: iload_2
    //   50: i2l
    //   51: ldc2_w 194
    //   54: lmul
    //   55: putfield 295	ioj:e	J
    //   58: aload_3
    //   59: aload_0
    //   60: getfield 297	ink:b	Ljava/net/InetSocketAddress;
    //   63: putfield 300	ioj:b	Ljava/net/SocketAddress;
    //   66: aload_3
    //   67: new 302	iok
    //   70: dup
    //   71: iconst_0
    //   72: invokespecial 303	iok:<init>	(B)V
    //   75: putfield 306	ioj:a	Liom;
    //   78: aload_3
    //   79: new 308	inn
    //   82: dup
    //   83: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   86: aload_3
    //   87: getfield 295	ioj:e	J
    //   90: ladd
    //   91: invokespecial 310	inn:<init>	(J)V
    //   94: putfield 313	ioj:d	Linn;
    //   97: aload_3
    //   98: getfield 300	ioj:b	Ljava/net/SocketAddress;
    //   101: ifnull +14 -> 115
    //   104: aload_3
    //   105: getfield 313	ioj:d	Linn;
    //   108: aload_3
    //   109: getfield 300	ioj:b	Ljava/net/SocketAddress;
    //   112: invokevirtual 316	inn:a	(Ljava/net/SocketAddress;)V
    //   115: aload_3
    //   116: getfield 313	ioj:d	Linn;
    //   119: aload_3
    //   120: getfield 318	ioj:c	Ljava/net/SocketAddress;
    //   123: invokevirtual 320	inn:b	(Ljava/net/SocketAddress;)V
    //   126: aload_3
    //   127: invokevirtual 322	ioj:b	()V
    //   130: aload_3
    //   131: invokevirtual 324	ioj:a	()V
    //   134: aload_3
    //   135: getfield 306	ioj:a	Liom;
    //   138: instanceof 302
    //   141: ifeq +109 -> 250
    //   144: aload_3
    //   145: getfield 306	ioj:a	Liom;
    //   148: checkcast 302	iok
    //   151: getfield 327	iok:a	Ljava/util/List;
    //   154: astore 4
    //   156: new 79	ilx
    //   159: dup
    //   160: aload_1
    //   161: getfield 216	ilx:a	Lilf;
    //   164: invokevirtual 329	ilf:b	()I
    //   167: invokespecial 331	ilx:<init>	(I)V
    //   170: astore_3
    //   171: aload_3
    //   172: getfield 216	ilx:a	Lilf;
    //   175: iconst_5
    //   176: invokevirtual 333	ilf:a	(I)V
    //   179: aload_3
    //   180: getfield 216	ilx:a	Lilf;
    //   183: iconst_0
    //   184: invokevirtual 333	ilf:a	(I)V
    //   187: aload_3
    //   188: aload_1
    //   189: invokevirtual 283	ilx:a	()Limw;
    //   192: iconst_0
    //   193: invokevirtual 271	ilx:a	(Limw;I)V
    //   196: aload 4
    //   198: invokeinterface 339 1 0
    //   203: astore_1
    //   204: aload_1
    //   205: invokeinterface 345 1 0
    //   210: ifeq +51 -> 261
    //   213: aload_3
    //   214: aload_1
    //   215: invokeinterface 349 1 0
    //   220: checkcast 157	imw
    //   223: iconst_1
    //   224: invokevirtual 271	ilx:a	(Limw;I)V
    //   227: goto -23 -> 204
    //   230: astore_1
    //   231: aload_3
    //   232: invokevirtual 324	ioj:a	()V
    //   235: aload_1
    //   236: athrow
    //   237: astore_1
    //   238: new 94	iog
    //   241: dup
    //   242: aload_1
    //   243: invokevirtual 353	ioi:getMessage	()Ljava/lang/String;
    //   246: invokespecial 97	iog:<init>	(Ljava/lang/String;)V
    //   249: athrow
    //   250: new 290	java/lang/IllegalArgumentException
    //   253: dup
    //   254: ldc_w 355
    //   257: invokespecial 293	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   260: athrow
    //   261: aload_3
    //   262: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	ink
    //   0	263	1	paramilx	ilx
    //   32	18	2	j	int
    //   22	240	3	localObject	Object
    //   154	43	4	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   78	115	230	finally
    //   115	130	230	finally
    //   66	78	237	ioi
    //   130	134	237	ioi
    //   231	237	237	ioi
  }
  
  public final ilx a(ilx paramilx)
  {
    if (imn.a("verbose"))
    {
      localObject1 = System.err;
      localObject2 = String.valueOf(a.getAddress().getHostAddress());
      j = a.getPort();
      ((PrintStream)localObject1).println(String.valueOf(localObject2).length() + 23 + "Sending to " + (String)localObject2 + ":" + j);
    }
    if (a.d() == 0)
    {
      localObject1 = paramilx.a();
      if ((localObject1 != null) && (h == 252)) {
        return d(paramilx);
      }
    }
    Object localObject1 = (ilx)paramilx.clone();
    b((ilx)localObject1);
    if (f != null) {
      f.apply((ilx)localObject1, null);
    }
    Object localObject2 = ((ilx)localObject1).f();
    int k = c((ilx)localObject1);
    long l = System.currentTimeMillis();
    l = g + l;
    int j = 0;
    if ((c) || (localObject2.length > k)) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      for (paramilx = inn.a(b, a, (byte[])localObject2, l); paramilx.length < 12; paramilx = iob.a(b, a, (byte[])localObject2, k, l)) {
        throw new iog("invalid DNS header - too short");
      }
      int m = ((paramilx[0] & 0xFF) << 8) + (paramilx[1] & 0xFF);
      int n = a.b();
      if (m != n)
      {
        paramilx = 60 + "invalid message id: expected " + n + "; got id " + m;
        if (j != 0) {
          throw new iog(paramilx);
        }
        if (!imn.a("verbose")) {
          break label409;
        }
        System.err.println(paramilx);
        break;
      }
      ilx localilx = a(paramilx);
      a((ilx)localObject1, localilx, paramilx, f);
      if ((j == 0) && (!d) && (a.b(6)))
      {
        j = 1;
        break;
      }
      return localilx;
      label409:
      break;
    }
  }
  
  public final Object a(ilx paramilx, inb paraminb)
  {
    for (;;)
    {
      try
      {
        int j = i;
        i = j + 1;
        Integer localInteger = new Integer(j);
        localObject = paramilx.a();
        if (localObject != null)
        {
          localObject = g.toString();
          String str = String.valueOf(getClass());
          localObject = String.valueOf(str).length() + 2 + String.valueOf(localObject).length() + str + ": " + (String)localObject;
          paramilx = new imy(this, paramilx, localInteger, paraminb);
          paramilx.setName((String)localObject);
          paramilx.setDaemon(true);
          paramilx.start();
          return localInteger;
        }
      }
      finally {}
      Object localObject = "(none)";
    }
  }
  
  public final void a()
  {
    a(5, 0);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    g = (paramInt1 * 1000L + paramInt2);
  }
}

/* Location:
 * Qualified Name:     ink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */