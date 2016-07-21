import android.content.Context;
import android.text.TextUtils;
import android.util.Base64DataException;
import com.android.email.service.ImapService;
import com.android.emailcommon.provider.Mailbox;
import com.android.emailcommon.service.SearchParams;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

final class axc
  extends bdb
{
  Mailbox a;
  Object[] b;
  private final axd c;
  private final String d;
  private int e = -1;
  private axb f;
  private int g;
  private boolean h;
  
  axc(axd paramaxd, String paramString)
  {
    c = paramaxd;
    d = paramString;
  }
  
  private static bcu a(InputStream paramInputStream, String paramString, int paramInt, bdd parambdd)
  {
    int i = 0;
    paramInputStream = bco.a(paramInputStream, paramString);
    bcg localbcg = new bcg();
    paramString = localbcg.a();
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = new byte['䀀'];
        j = paramInputStream.read(arrayOfByte);
        if (-1 != j)
        {
          paramString.write(arrayOfByte, 0, j);
          j = i + j;
          i = j;
          if (parambdd == null) {
            continue;
          }
          if (paramInt == 0)
          {
            parambdd.a((int)Math.ceil(100.0D * (1.0D - 1.0D / j)));
            i = j;
            continue;
          }
        }
      }
      catch (Base64DataException paramInputStream)
      {
        int j;
        if (ImapService.a != null) {
          break label179;
        }
        paramInputStream = "";
        paramInputStream = String.valueOf(paramInputStream);
        if (paramInputStream.length() == 0) {
          break label186;
        }
        paramInputStream = "\n\n".concat(paramInputStream);
        paramString.write(paramInputStream.getBytes());
        return localbcg;
        parambdd.a(j * 100 / paramInt);
        i = j;
        continue;
      }
      finally
      {
        paramString.close();
      }
      paramString.close();
      return localbcg;
      label179:
      paramInputStream = ImapService.a;
      continue;
      label186:
      paramInputStream = new String("\n\n");
    }
  }
  
  private final bdi a(axb paramaxb, IOException paramIOException)
  {
    cvm.d(bbw.a, paramIOException, "IO Exception in ImapFolder", new Object[0]);
    paramaxb.b();
    if (paramaxb == f)
    {
      f = null;
      b();
    }
    return new bdi(1, paramIOException.toString(), paramIOException);
  }
  
  private static String a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject = new SimpleDateFormat("dd-LLL-yyyy", Locale.US);
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    String str = ((SimpleDateFormat)localObject).format(Long.valueOf(paramLong2));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1:* ");
    if (0L != 0L)
    {
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(0L));
      if (0L < paramLong2) {
        throw new bdi(26, String.format("Invalid date range: %s - %s", new Object[] { str, localObject }));
      }
      localStringBuilder.append("BEFORE ");
      if (paramBoolean) {
        localStringBuilder.append('"');
      }
      localStringBuilder.append((String)localObject);
      if (paramBoolean) {
        localStringBuilder.append('"');
      }
      localStringBuilder.append(" ");
    }
    localStringBuilder.append("SINCE ");
    if (paramBoolean) {
      localStringBuilder.append('"');
    }
    localStringBuilder.append(str);
    if (paramBoolean) {
      localStringBuilder.append('"');
    }
    return localStringBuilder.toString();
  }
  
  private static void a(axr paramaxr, bdn parambdn, String paramString)
  {
    if (paramaxr.a(0).a())
    {
      localObject1 = new bcn();
      i = 0;
      j = d.size();
      if (i < j)
      {
        localObject2 = paramaxr.a(i);
        if (((axp)localObject2).a())
        {
          localObject2 = new bci();
          if (paramString.equals("TEXT")) {
            a(paramaxr.b(i), (bdn)localObject2, Integer.toString(i + 1));
          }
          for (;;)
          {
            ((bcn)localObject1).a((bcv)localObject2);
            i += 1;
            break;
            a(paramaxr.b(i), (bdn)localObject2, String.valueOf(paramString).length() + 12 + paramString + "." + (i + 1));
          }
        }
        if (((axp)localObject2).b()) {
          ((bcn)localObject1).a(paramaxr.c(i).e().toLowerCase(Locale.US));
        }
      }
      parambdn.a((bcu)localObject1);
      return;
    }
    Object localObject3 = paramaxr.c(0);
    Object localObject2 = paramaxr.c(1);
    Object localObject1 = String.valueOf(((axy)localObject3).e());
    localObject2 = String.valueOf(((axy)localObject2).e());
    Object localObject5 = (String.valueOf(localObject1).length() + 1 + String.valueOf(localObject2).length() + (String)localObject1 + "/" + (String)localObject2).toLowerCase(Locale.US);
    Object localObject4 = paramaxr.b(2);
    localObject1 = paramaxr.c(3);
    localObject2 = paramaxr.c(5);
    int j = paramaxr.c(6).h();
    if (bco.b((String)localObject5, "message/rfc822")) {
      throw new bdi(26, "BODYSTRUCTURE message/rfc822 not yet supported.");
    }
    localObject5 = new StringBuilder((String)localObject5);
    int i = 1;
    int k = d.size();
    while (i < k)
    {
      ((StringBuilder)localObject5).append(String.format(";\n %s=\"%s\"", new Object[] { ((axr)localObject4).c(i - 1).e(), ((axr)localObject4).c(i).e() }));
      i += 2;
    }
    parambdn.b("Content-Type", ((StringBuilder)localObject5).toString());
    if ((((axy)localObject3).a("TEXT")) && (paramaxr.a(9).a())) {}
    for (paramaxr = paramaxr.b(9);; paramaxr = paramaxr.b(8))
    {
      localObject3 = new StringBuilder();
      if (d.size() <= 0) {
        break;
      }
      localObject4 = paramaxr.c(0).e().toLowerCase(Locale.US);
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        ((StringBuilder)localObject3).append((String)localObject4);
      }
      paramaxr = paramaxr.b(1);
      if (paramaxr.e()) {
        break;
      }
      i = 1;
      k = d.size();
      while (i < k)
      {
        ((StringBuilder)localObject3).append(String.format(Locale.US, ";\n %s=\"%s\"", new Object[] { paramaxr.c(i - 1).e().toLowerCase(Locale.US), paramaxr.c(i).e() }));
        i += 2;
      }
    }
    if ((j > 0) && (bco.a(((StringBuilder)localObject3).toString(), "size") == null)) {
      ((StringBuilder)localObject3).append(String.format(Locale.US, ";\n size=%d", new Object[] { Integer.valueOf(j) }));
    }
    if (((StringBuilder)localObject3).length() > 0) {
      parambdn.b("Content-Disposition", ((StringBuilder)localObject3).toString());
    }
    if (!((axy)localObject2).g()) {
      parambdn.b("Content-Transfer-Encoding", ((axy)localObject2).e());
    }
    if (!((axy)localObject1).g()) {
      parambdn.b("Content-ID", ((axy)localObject1).e());
    }
    if (j > 0)
    {
      if (!(parambdn instanceof axf)) {
        break label739;
      }
      c = j;
    }
    for (;;)
    {
      parambdn.b("X-Android-Attachment-StoreData", paramString);
      return;
      label739:
      if (!(parambdn instanceof bci)) {
        break;
      }
      c = j;
    }
    paramaxr = String.valueOf(parambdn.toString());
    if (paramaxr.length() != 0) {}
    for (paramaxr = "Unknown part type ".concat(paramaxr);; paramaxr = new String("Unknown part type ")) {
      throw new bdi(26, paramaxr);
    }
  }
  
  private final void a(axu paramaxu)
  {
    if (paramaxu.a(1, "EXISTS")) {
      e = paramaxu.c(0).h();
    }
  }
  
  private final bdg[] a(String[] paramArrayOfString, bdd parambdd)
  {
    parambdd = new ArrayList(paramArrayOfString.length);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      parambdd.add(new axf(paramArrayOfString[i], this));
      i += 1;
    }
    return (bdg[])parambdd.toArray(new bdg[parambdd.size()]);
  }
  
  /* Error */
  private final String[] a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 360	axc:l	()V
    //   4: ldc_w 362
    //   7: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   10: astore 4
    //   12: aload_1
    //   13: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   16: astore 5
    //   18: aload 5
    //   20: invokevirtual 86	java/lang/String:length	()I
    //   23: ifeq +93 -> 116
    //   26: aload 4
    //   28: aload 5
    //   30: invokevirtual 92	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 4
    //   35: aload_0
    //   36: getfield 124	axc:f	Laxb;
    //   39: aload 4
    //   41: iconst_0
    //   42: invokevirtual 365	axb:b	(Ljava/lang/String;Z)Ljava/util/List;
    //   45: invokestatic 368	axc:a	(Ljava/util/List;)[Ljava/lang/String;
    //   48: astore 4
    //   50: getstatic 109	bbw:a	Ljava/lang/String;
    //   53: astore 5
    //   55: aload 4
    //   57: arraylength
    //   58: istore_3
    //   59: aload 5
    //   61: new 172	java/lang/StringBuilder
    //   64: dup
    //   65: aload_1
    //   66: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   69: invokevirtual 86	java/lang/String:length	()I
    //   72: bipush 37
    //   74: iadd
    //   75: invokespecial 243	java/lang/StringBuilder:<init>	(I)V
    //   78: ldc_w 370
    //   81: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc_w 372
    //   91: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: iload_3
    //   95: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: iconst_0
    //   102: anewarray 113	java/lang/Object
    //   105: invokestatic 375	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   108: pop
    //   109: aload_0
    //   110: invokespecial 378	axc:i	()V
    //   113: aload 4
    //   115: areturn
    //   116: new 78	java/lang/String
    //   119: dup
    //   120: aload 4
    //   122: invokespecial 105	java/lang/String:<init>	(Ljava/lang/String;)V
    //   125: astore 4
    //   127: goto -92 -> 35
    //   130: astore 4
    //   132: getstatic 109	bbw:a	Ljava/lang/String;
    //   135: astore 5
    //   137: aload_1
    //   138: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 86	java/lang/String:length	()I
    //   146: ifeq +38 -> 184
    //   149: ldc_w 380
    //   152: aload_1
    //   153: invokevirtual 92	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore_1
    //   157: aload 5
    //   159: aload 4
    //   161: aload_1
    //   162: iconst_0
    //   163: anewarray 113	java/lang/Object
    //   166: invokestatic 382	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   169: pop
    //   170: iload_2
    //   171: ifeq +34 -> 205
    //   174: getstatic 387	bhn:c	[Ljava/lang/String;
    //   177: astore_1
    //   178: aload_0
    //   179: invokespecial 378	axc:i	()V
    //   182: aload_1
    //   183: areturn
    //   184: new 78	java/lang/String
    //   187: dup
    //   188: ldc_w 380
    //   191: invokespecial 105	java/lang/String:<init>	(Ljava/lang/String;)V
    //   194: astore_1
    //   195: goto -38 -> 157
    //   198: astore_1
    //   199: aload_0
    //   200: invokespecial 378	axc:i	()V
    //   203: aload_1
    //   204: athrow
    //   205: aload 4
    //   207: athrow
    //   208: astore 4
    //   210: getstatic 109	bbw:a	Ljava/lang/String;
    //   213: astore 5
    //   215: aload_1
    //   216: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 86	java/lang/String:length	()I
    //   224: ifeq +35 -> 259
    //   227: ldc_w 389
    //   230: aload_1
    //   231: invokevirtual 92	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   234: astore_1
    //   235: aload 5
    //   237: aload 4
    //   239: aload_1
    //   240: iconst_0
    //   241: anewarray 113	java/lang/Object
    //   244: invokestatic 382	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   247: pop
    //   248: aload_0
    //   249: aload_0
    //   250: getfield 124	axc:f	Laxb;
    //   253: aload 4
    //   255: invokespecial 391	axc:a	(Laxb;Ljava/io/IOException;)Lbdi;
    //   258: athrow
    //   259: new 78	java/lang/String
    //   262: dup
    //   263: ldc_w 389
    //   266: invokespecial 105	java/lang/String:<init>	(Ljava/lang/String;)V
    //   269: astore_1
    //   270: goto -35 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	axc
    //   0	273	1	paramString	String
    //   0	273	2	paramBoolean	boolean
    //   58	37	3	i	int
    //   10	116	4	localObject	Object
    //   130	76	4	localaxe	axe
    //   208	46	4	localIOException	IOException
    //   16	220	5	str	String
    // Exception table:
    //   from	to	target	type
    //   4	35	130	axe
    //   35	109	130	axe
    //   116	127	130	axe
    //   4	35	198	finally
    //   35	109	198	finally
    //   116	127	198	finally
    //   132	157	198	finally
    //   157	170	198	finally
    //   174	178	198	finally
    //   184	195	198	finally
    //   205	208	198	finally
    //   210	235	198	finally
    //   235	259	198	finally
    //   259	270	198	finally
    //   4	35	208	java/io/IOException
    //   35	109	208	java/io/IOException
    //   116	127	208	java/io/IOException
  }
  
  private static String[] a(List<axu> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      axu localaxu = (axu)paramList.next();
      if (localaxu.a(0, "SEARCH"))
      {
        int i = 1;
        while (i < d.size())
        {
          localArrayList.add(localaxu.c(i).e());
          i += 1;
        }
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  private final String[] b(List<String> paramList)
  {
    l();
    try
    {
      axb localaxb = f;
      localaxb.a(paramList, false);
      paramList = a(localaxb.e());
      return paramList;
    }
    catch (axe paramList)
    {
      paramList = bhn.c;
      return paramList;
    }
    catch (IOException paramList)
    {
      throw a(f, paramList);
    }
    finally
    {
      i();
    }
  }
  
  private static boolean c(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (paramString.charAt(i) >= '') {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private final void i()
  {
    if (f != null) {
      f.c();
    }
  }
  
  private final boolean j()
  {
    return (h) && (f != null);
  }
  
  private final void k()
  {
    Object localObject1 = f.b(String.format(Locale.US, "SELECT \"%s\"", new Object[] { axd.b(d, c.h) }), false);
    g = bdf.a;
    localObject1 = ((List)localObject1).iterator();
    int i = -1;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (axu)((Iterator)localObject1).next();
      if (((axu)localObject2).a(1, "EXISTS"))
      {
        i = ((axu)localObject2).c(0).h();
      }
      else if (((axr)localObject2).a(0, "OK", false))
      {
        localObject2 = ((axu)localObject2).h();
        if (((axy)localObject2).a("READ-ONLY")) {
          g = bdf.b;
        } else if (((axy)localObject2).a("READ-WRITE")) {
          g = bdf.a;
        }
      }
      else if (((axu)localObject2).f())
      {
        localObject1 = String.valueOf(((axu)localObject2).j());
        throw new bdi(26, String.valueOf(localObject1).length() + 20 + "Can't open mailbox: " + (String)localObject1);
      }
    }
    if (i == -1) {
      throw new bdi(26, "Did not find message count during select");
    }
    e = i;
    h = true;
  }
  
  private final void l()
  {
    if (!j())
    {
      String str = d;
      throw new bdi(26, String.valueOf(str).length() + 20 + "Folder " + str + " is not open.");
    }
  }
  
  public final int a()
  {
    return g;
  }
  
  public final bdg a(String paramString)
  {
    l();
    Object localObject = String.valueOf("UID ");
    String str = String.valueOf(paramString);
    int j;
    int i;
    if (str.length() != 0)
    {
      localObject = ((String)localObject).concat(str);
      localObject = a((String)localObject, true);
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label97;
      }
      if (localObject[i].equals(paramString))
      {
        return new axf(paramString, this);
        localObject = new String((String)localObject);
        break;
      }
      i += 1;
    }
    label97:
    return null;
  }
  
  /* Error */
  public final void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 467	axc:j	()Z
    //   4: ifeq +52 -> 56
    //   7: aload_0
    //   8: getfield 443	axc:g	I
    //   11: istore_2
    //   12: iload_2
    //   13: iload_1
    //   14: if_icmpne +104 -> 118
    //   17: aload_0
    //   18: getfield 124	axc:f	Laxb;
    //   21: ldc_w 480
    //   24: iconst_0
    //   25: invokevirtual 365	axb:b	(Ljava/lang/String;Z)Ljava/util/List;
    //   28: pop
    //   29: aload_0
    //   30: getfield 124	axc:f	Laxb;
    //   33: invokevirtual 482	axb:g	()V
    //   36: aload_0
    //   37: invokespecial 378	axc:i	()V
    //   40: return
    //   41: astore_3
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 124	axc:f	Laxb;
    //   47: aload_3
    //   48: invokespecial 391	axc:a	(Laxb;Ljava/io/IOException;)Lbdi;
    //   51: pop
    //   52: aload_0
    //   53: invokespecial 378	axc:i	()V
    //   56: aload_0
    //   57: monitorenter
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 28	axc:c	Laxd;
    //   63: invokevirtual 485	axd:g	()Laxb;
    //   66: putfield 124	axc:f	Laxb;
    //   69: aload_0
    //   70: getfield 124	axc:f	Laxb;
    //   73: invokevirtual 482	axb:g	()V
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: invokespecial 487	axc:k	()V
    //   82: aload_0
    //   83: invokespecial 378	axc:i	()V
    //   86: return
    //   87: astore_3
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 124	axc:f	Laxb;
    //   93: aload_0
    //   94: invokevirtual 125	axc:b	()V
    //   97: aload_3
    //   98: athrow
    //   99: astore_3
    //   100: aload_0
    //   101: invokespecial 378	axc:i	()V
    //   104: aload_3
    //   105: athrow
    //   106: astore_3
    //   107: aload_0
    //   108: iconst_0
    //   109: putfield 428	axc:h	Z
    //   112: aload_0
    //   113: invokevirtual 125	axc:b	()V
    //   116: aload_3
    //   117: athrow
    //   118: aload_0
    //   119: invokevirtual 125	axc:b	()V
    //   122: goto -66 -> 56
    //   125: astore_3
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_3
    //   129: athrow
    //   130: astore_3
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 124	axc:f	Laxb;
    //   136: aload_3
    //   137: invokespecial 391	axc:a	(Laxb;Ljava/io/IOException;)Lbdi;
    //   140: athrow
    //   141: astore_3
    //   142: aload_0
    //   143: invokespecial 378	axc:i	()V
    //   146: aload_3
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	axc
    //   0	148	1	paramInt	int
    //   11	4	2	i	int
    //   41	7	3	localIOException1	IOException
    //   87	11	3	localbcs	bcs
    //   99	6	3	localObject1	Object
    //   106	11	3	localbdi	bdi
    //   125	4	3	localObject2	Object
    //   130	7	3	localIOException2	IOException
    //   141	6	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	36	41	java/io/IOException
    //   0	12	87	bcs
    //   36	40	87	bcs
    //   52	56	87	bcs
    //   56	58	87	bcs
    //   82	86	87	bcs
    //   100	106	87	bcs
    //   118	122	87	bcs
    //   128	130	87	bcs
    //   142	148	87	bcs
    //   17	36	99	finally
    //   42	52	99	finally
    //   0	12	106	bdi
    //   36	40	106	bdi
    //   52	56	106	bdi
    //   56	58	106	bdi
    //   82	86	106	bdi
    //   100	106	106	bdi
    //   118	122	106	bdi
    //   128	130	106	bdi
    //   142	148	106	bdi
    //   58	78	125	finally
    //   126	128	125	finally
    //   78	82	130	java/io/IOException
    //   78	82	141	finally
    //   131	141	141	finally
  }
  
  public final void a(Context paramContext, bdg parambdg, boolean paramBoolean)
  {
    int i = 0;
    l();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      StringBuilder localStringBuilder;
      Object localObject3;
      try
      {
        localObject1 = File.createTempFile("IMAPupsync", ".eml", paramContext.getExternalCacheDir());
        if (!((File)localObject1).delete()) {
          cvm.d(cvm.a, "Could not delete temp file %s", new Object[] { ((File)localObject1).getAbsolutePath() });
        }
        localObject2 = new bgw(new FileOutputStream((File)localObject1));
        paramContext = new bgx((OutputStream)localObject2);
        parambdg.a(paramContext);
        paramContext.flush();
        paramContext = (bda[])parambdg.o().toArray(new bda[0]);
        if (paramContext.length <= 0) {
          break label600;
        }
        localStringBuilder = new StringBuilder();
        int j = paramContext.length;
        if (i >= j) {
          break label233;
        }
        localObject3 = paramContext[i];
        if (localObject3 == bda.b) {
          localStringBuilder.append(" \\SEEN");
        } else if (localObject3 == bda.d) {
          localStringBuilder.append(" \\FLAGGED");
        }
      }
      catch (IOException paramContext)
      {
        throw a(f, paramContext);
      }
      finally
      {
        i();
      }
      if (localObject3 == bda.c)
      {
        localStringBuilder.append(" \\ANSWERED");
      }
      else if (localObject3 == bda.g)
      {
        localStringBuilder.append(" $Forwarded");
        break label606;
        label233:
        if (localStringBuilder.length() > 0) {}
        label497:
        label600:
        for (paramContext = localStringBuilder.substring(1);; paramContext = "")
        {
          f.a(String.format(Locale.US, "APPEND \"%s\" (%s) {%d}", new Object[] { axd.b(d, c.h), paramContext, Long.valueOf(a) }), false);
          for (;;)
          {
            i = f.a.b.getSoTimeout();
            if (paramBoolean) {}
            try
            {
              f.a.a(0);
              paramContext = f.d();
              if (e)
              {
                localObject2 = f.a.d;
                idc.b(new FileInputStream((File)localObject1), (OutputStream)localObject2);
                ((OutputStream)localObject2).write(13);
                ((OutputStream)localObject2).write(10);
                ((OutputStream)localObject2).flush();
              }
              for (;;)
              {
                f.a.a(i);
                if (!paramContext.f()) {
                  break;
                }
                paramContext = paramContext.b(1);
                if ((d.size() < 3) || (!paramContext.a(0, "APPENDUID", false))) {
                  break label497;
                }
                paramContext = paramContext.c(2).e();
                if (TextUtils.isEmpty(paramContext)) {
                  break label497;
                }
                f = paramContext;
                i();
                return;
                if (!paramContext.f()) {
                  a(paramContext);
                }
              }
              paramContext = parambdg.k();
            }
            finally
            {
              f.a.a(i);
            }
          }
          if (paramContext != null)
          {
            i = paramContext.length();
            if (i != 0) {}
          }
          else
          {
            i();
            return;
          }
          localObject1 = a(String.format(Locale.US, "HEADER MESSAGE-ID %s", new Object[] { paramContext }), true);
          if (localObject1.length > 0) {
            f = localObject1[0];
          }
          paramContext = a(String.format(Locale.US, "(HEADER MESSAGE-ID %s)", new Object[] { paramContext }), true);
          if (paramContext.length > 0) {
            f = paramContext[0];
          }
          i();
          return;
        }
      }
      label606:
      i += 1;
    }
  }
  
  /* Error */
  public final void a(bdg[] paramArrayOfbdg, bcx parambcx, bdd parambdd)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: ifeq +374 -> 376
    //   5: aload_0
    //   6: invokespecial 360	axc:l	()V
    //   9: new 625	java/util/HashMap
    //   12: dup
    //   13: invokespecial 626	java/util/HashMap:<init>	()V
    //   16: astore 7
    //   18: aload_1
    //   19: arraylength
    //   20: istore 5
    //   22: iconst_0
    //   23: istore 4
    //   25: iload 4
    //   27: iload 5
    //   29: if_icmpge +31 -> 60
    //   32: aload_1
    //   33: iload 4
    //   35: aaload
    //   36: astore 8
    //   38: aload 7
    //   40: aload 8
    //   42: getfield 610	bdg:f	Ljava/lang/String;
    //   45: aload 8
    //   47: invokevirtual 630	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: iload 4
    //   53: iconst_1
    //   54: iadd
    //   55: istore 4
    //   57: goto -32 -> 25
    //   60: new 632	java/util/LinkedHashSet
    //   63: dup
    //   64: invokespecial 633	java/util/LinkedHashSet:<init>	()V
    //   67: astore 9
    //   69: aload 9
    //   71: ldc_w 635
    //   74: invokevirtual 636	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload_2
    //   79: getstatic 641	bcy:a	Lbcy;
    //   82: invokevirtual 646	bcx:contains	(Ljava/lang/Object;)Z
    //   85: ifeq +12 -> 97
    //   88: aload 9
    //   90: ldc_w 648
    //   93: invokevirtual 636	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   96: pop
    //   97: aload_2
    //   98: getstatic 650	bcy:b	Lbcy;
    //   101: invokevirtual 646	bcx:contains	(Ljava/lang/Object;)Z
    //   104: ifeq +30 -> 134
    //   107: aload 9
    //   109: ldc_w 652
    //   112: invokevirtual 636	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   115: pop
    //   116: aload 9
    //   118: ldc_w 654
    //   121: invokevirtual 636	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload 9
    //   127: ldc_w 656
    //   130: invokevirtual 636	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: aload_2
    //   135: getstatic 658	bcy:c	Lbcy;
    //   138: invokevirtual 646	bcx:contains	(Ljava/lang/Object;)Z
    //   141: ifeq +12 -> 153
    //   144: aload 9
    //   146: ldc_w 660
    //   149: invokevirtual 636	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   152: pop
    //   153: aload_2
    //   154: getstatic 662	bcy:d	Lbcy;
    //   157: invokevirtual 646	bcx:contains	(Ljava/lang/Object;)Z
    //   160: ifeq +12 -> 172
    //   163: aload 9
    //   165: getstatic 665	axo:a	Ljava/lang/String;
    //   168: invokevirtual 636	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   171: pop
    //   172: aload_2
    //   173: getstatic 667	bcy:e	Lbcy;
    //   176: invokevirtual 646	bcx:contains	(Ljava/lang/Object;)Z
    //   179: ifeq +12 -> 191
    //   182: aload 9
    //   184: ldc_w 669
    //   187: invokevirtual 636	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   190: pop
    //   191: aload_2
    //   192: invokevirtual 672	bcx:a	()Lbdn;
    //   195: astore 8
    //   197: aload 8
    //   199: ifnull +88 -> 287
    //   202: aload 8
    //   204: ldc_w 325
    //   207: invokeinterface 675 2 0
    //   212: astore 11
    //   214: aload 11
    //   216: ifnull +71 -> 287
    //   219: ldc_w 677
    //   222: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   225: astore 10
    //   227: aload 11
    //   229: iconst_0
    //   230: aaload
    //   231: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   234: astore 11
    //   236: aload 9
    //   238: new 172	java/lang/StringBuilder
    //   241: dup
    //   242: aload 10
    //   244: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   247: invokevirtual 86	java/lang/String:length	()I
    //   250: iconst_1
    //   251: iadd
    //   252: aload 11
    //   254: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   257: invokevirtual 86	java/lang/String:length	()I
    //   260: iadd
    //   261: invokespecial 243	java/lang/StringBuilder:<init>	(I)V
    //   264: aload 10
    //   266: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 11
    //   271: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 679
    //   277: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokevirtual 636	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   286: pop
    //   287: aload_0
    //   288: getfield 124	axc:f	Laxb;
    //   291: getstatic 147	java/util/Locale:US	Ljava/util/Locale;
    //   294: ldc_w 681
    //   297: iconst_2
    //   298: anewarray 113	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: aload_1
    //   304: invokestatic 684	axd:a	([Lbdg;)Ljava/lang/String;
    //   307: aastore
    //   308: dup
    //   309: iconst_1
    //   310: aload 9
    //   312: aload 9
    //   314: invokevirtual 685	java/util/LinkedHashSet:size	()I
    //   317: anewarray 78	java/lang/String
    //   320: invokevirtual 686	java/util/LinkedHashSet:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   323: invokestatic 689	bhn:a	([Ljava/lang/Object;)Ljava/lang/String;
    //   326: aastore
    //   327: invokestatic 301	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   330: iconst_0
    //   331: invokevirtual 572	axb:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   334: pop
    //   335: aload_0
    //   336: getfield 124	axc:f	Laxb;
    //   339: invokevirtual 589	axb:d	()Laxu;
    //   342: astore 9
    //   344: aload 9
    //   346: iconst_1
    //   347: ldc_w 691
    //   350: invokevirtual 337	axu:a	(ILjava/lang/String;)Z
    //   353: istore 6
    //   355: iload 6
    //   357: ifne +20 -> 377
    //   360: aload_0
    //   361: invokespecial 378	axc:i	()V
    //   364: aload 9
    //   366: invokevirtual 459	axu:f	()Z
    //   369: istore 6
    //   371: iload 6
    //   373: ifeq -38 -> 335
    //   376: return
    //   377: aload 9
    //   379: iconst_2
    //   380: invokevirtual 606	axu:b	(I)Laxr;
    //   383: astore 11
    //   385: aload 11
    //   387: ldc_w 635
    //   390: iconst_0
    //   391: invokevirtual 694	axr:b	(Ljava/lang/String;Z)Laxy;
    //   394: invokevirtual 257	axy:e	()Ljava/lang/String;
    //   397: astore_1
    //   398: aload_1
    //   399: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   402: istore 6
    //   404: iload 6
    //   406: ifeq +53 -> 459
    //   409: aload_0
    //   410: invokespecial 378	axc:i	()V
    //   413: goto -49 -> 364
    //   416: astore_1
    //   417: aload_0
    //   418: aload_0
    //   419: getfield 124	axc:f	Laxb;
    //   422: aload_1
    //   423: invokespecial 391	axc:a	(Laxb;Ljava/io/IOException;)Lbdi;
    //   426: athrow
    //   427: astore_1
    //   428: getstatic 109	bbw:a	Ljava/lang/String;
    //   431: aload_1
    //   432: ldc_w 696
    //   435: iconst_0
    //   436: anewarray 113	java/lang/Object
    //   439: invokestatic 118	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   442: pop
    //   443: aload_0
    //   444: getfield 124	axc:f	Laxb;
    //   447: ifnull +10 -> 457
    //   450: aload_0
    //   451: getfield 124	axc:f	Laxb;
    //   454: invokevirtual 698	axb:f	()V
    //   457: aload_1
    //   458: athrow
    //   459: aload 7
    //   461: aload_1
    //   462: invokevirtual 702	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   465: checkcast 321	axf
    //   468: astore 10
    //   470: aload 10
    //   472: ifnonnull +10 -> 482
    //   475: aload_0
    //   476: invokespecial 378	axc:i	()V
    //   479: goto -115 -> 364
    //   482: aload_2
    //   483: getstatic 641	bcy:a	Lbcy;
    //   486: invokevirtual 646	bcx:contains	(Ljava/lang/Object;)Z
    //   489: ifeq +173 -> 662
    //   492: aload 11
    //   494: ldc_w 648
    //   497: iconst_0
    //   498: invokevirtual 705	axr:a	(Ljava/lang/String;Z)Laxp;
    //   501: astore_1
    //   502: aload_1
    //   503: ifnull +57 -> 560
    //   506: aload_1
    //   507: checkcast 200	axr
    //   510: astore_1
    //   511: aload_1
    //   512: getfield 214	axr:d	Ljava/util/ArrayList;
    //   515: invokevirtual 219	java/util/ArrayList:size	()I
    //   518: istore 5
    //   520: iconst_0
    //   521: istore 4
    //   523: iload 4
    //   525: iload 5
    //   527: if_icmpge +135 -> 662
    //   530: aload_1
    //   531: iload 4
    //   533: invokevirtual 253	axr:c	(I)Laxy;
    //   536: astore 12
    //   538: aload 12
    //   540: ldc_w 707
    //   543: invokevirtual 290	axy:a	(Ljava/lang/String;)Z
    //   546: ifeq +21 -> 567
    //   549: aload 10
    //   551: getstatic 709	bda:a	Lbda;
    //   554: invokevirtual 712	axf:a	(Lbda;)V
    //   557: goto +421 -> 978
    //   560: getstatic 715	axr:c	Laxr;
    //   563: astore_1
    //   564: goto -53 -> 511
    //   567: aload 12
    //   569: ldc_w 717
    //   572: invokevirtual 290	axy:a	(Ljava/lang/String;)Z
    //   575: ifeq +21 -> 596
    //   578: aload 10
    //   580: getstatic 555	bda:c	Lbda;
    //   583: invokevirtual 712	axf:a	(Lbda;)V
    //   586: goto +392 -> 978
    //   589: astore_1
    //   590: aload_0
    //   591: invokespecial 378	axc:i	()V
    //   594: aload_1
    //   595: athrow
    //   596: aload 12
    //   598: ldc_w 719
    //   601: invokevirtual 290	axy:a	(Ljava/lang/String;)Z
    //   604: ifeq +14 -> 618
    //   607: aload 10
    //   609: getstatic 547	bda:b	Lbda;
    //   612: invokevirtual 712	axf:a	(Lbda;)V
    //   615: goto +363 -> 978
    //   618: aload 12
    //   620: ldc_w 721
    //   623: invokevirtual 290	axy:a	(Ljava/lang/String;)Z
    //   626: ifeq +14 -> 640
    //   629: aload 10
    //   631: getstatic 551	bda:d	Lbda;
    //   634: invokevirtual 712	axf:a	(Lbda;)V
    //   637: goto +341 -> 978
    //   640: aload 12
    //   642: ldc_w 723
    //   645: invokevirtual 290	axy:a	(Ljava/lang/String;)Z
    //   648: ifeq +330 -> 978
    //   651: aload 10
    //   653: getstatic 559	bda:g	Lbda;
    //   656: invokevirtual 712	axf:a	(Lbda;)V
    //   659: goto +319 -> 978
    //   662: aload_2
    //   663: getstatic 650	bcy:b	Lbcy;
    //   666: invokevirtual 646	bcx:contains	(Ljava/lang/Object;)Z
    //   669: ifeq +73 -> 742
    //   672: aload 11
    //   674: ldc_w 652
    //   677: iconst_0
    //   678: invokevirtual 694	axr:b	(Ljava/lang/String;Z)Laxy;
    //   681: astore_1
    //   682: aload_1
    //   683: invokevirtual 725	axy:i	()Z
    //   686: ifne +224 -> 910
    //   689: aconst_null
    //   690: astore_1
    //   691: aload 11
    //   693: ldc_w 654
    //   696: iconst_0
    //   697: invokevirtual 694	axr:b	(Ljava/lang/String;Z)Laxy;
    //   700: invokevirtual 272	axy:h	()I
    //   703: istore 4
    //   705: aload 11
    //   707: ldc_w 727
    //   710: iconst_1
    //   711: invokevirtual 694	axr:b	(Ljava/lang/String;Z)Laxy;
    //   714: invokevirtual 257	axy:e	()Ljava/lang/String;
    //   717: astore 12
    //   719: aload 10
    //   721: aload_1
    //   722: putfield 730	bdg:g	Ljava/util/Date;
    //   725: aload 10
    //   727: iload 4
    //   729: putfield 323	axf:c	I
    //   732: aload 10
    //   734: aload 12
    //   736: invokestatic 733	bhn:e	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   739: invokevirtual 736	axf:a	(Ljava/io/InputStream;)V
    //   742: aload_2
    //   743: getstatic 658	bcy:c	Lbcy;
    //   746: invokevirtual 646	bcx:contains	(Ljava/lang/Object;)Z
    //   749: ifeq +41 -> 790
    //   752: aload 11
    //   754: ldc_w 660
    //   757: iconst_0
    //   758: invokevirtual 705	axr:a	(Ljava/lang/String;Z)Laxp;
    //   761: astore_1
    //   762: aload_1
    //   763: ifnull +155 -> 918
    //   766: aload_1
    //   767: checkcast 200	axr
    //   770: astore_1
    //   771: aload_1
    //   772: invokevirtual 298	axr:e	()Z
    //   775: istore 6
    //   777: iload 6
    //   779: ifne +11 -> 790
    //   782: aload_1
    //   783: aload 10
    //   785: ldc -32
    //   787: invokestatic 238	axc:a	(Laxr;Lbdn;Ljava/lang/String;)V
    //   790: aload_2
    //   791: getstatic 667	bcy:e	Lbcy;
    //   794: invokevirtual 646	bcx:contains	(Ljava/lang/Object;)Z
    //   797: ifne +13 -> 810
    //   800: aload_2
    //   801: getstatic 662	bcy:d	Lbcy;
    //   804: invokevirtual 646	bcx:contains	(Ljava/lang/Object;)Z
    //   807: ifeq +20 -> 827
    //   810: aload 10
    //   812: aload 11
    //   814: ldc_w 738
    //   817: iconst_1
    //   818: invokevirtual 694	axr:b	(Ljava/lang/String;Z)Laxy;
    //   821: invokevirtual 741	axy:f	()Ljava/io/InputStream;
    //   824: invokevirtual 736	axf:a	(Ljava/io/InputStream;)V
    //   827: aload 8
    //   829: ifnull +62 -> 891
    //   832: aload 11
    //   834: ldc_w 743
    //   837: iconst_1
    //   838: invokevirtual 694	axr:b	(Ljava/lang/String;Z)Laxy;
    //   841: invokevirtual 741	axy:f	()Ljava/io/InputStream;
    //   844: astore 11
    //   846: aload 8
    //   848: ldc_w 317
    //   851: invokeinterface 675 2 0
    //   856: astore_1
    //   857: aload_1
    //   858: ifnull +129 -> 987
    //   861: aload_1
    //   862: arraylength
    //   863: ifle +124 -> 987
    //   866: aload_1
    //   867: iconst_0
    //   868: aaload
    //   869: astore_1
    //   870: aload 8
    //   872: aload 11
    //   874: aload_1
    //   875: aload 8
    //   877: invokeinterface 745 1 0
    //   882: aload_3
    //   883: invokestatic 747	axc:a	(Ljava/io/InputStream;Ljava/lang/String;ILbdd;)Lbcu;
    //   886: invokeinterface 268 2 0
    //   891: aload_3
    //   892: ifnull +11 -> 903
    //   895: aload_3
    //   896: aload 10
    //   898: invokeinterface 750 2 0
    //   903: aload_0
    //   904: invokespecial 378	axc:i	()V
    //   907: goto -543 -> 364
    //   910: aload_1
    //   911: getfield 752	axy:e	Ljava/util/Date;
    //   914: astore_1
    //   915: goto -224 -> 691
    //   918: getstatic 715	axr:c	Laxr;
    //   921: astore_1
    //   922: goto -151 -> 771
    //   925: astore_1
    //   926: getstatic 754	bbw:b	Z
    //   929: ifeq +18 -> 947
    //   932: getstatic 109	bbw:a	Ljava/lang/String;
    //   935: aload_1
    //   936: ldc_w 756
    //   939: iconst_0
    //   940: anewarray 113	java/lang/Object
    //   943: invokestatic 758	cvm:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   946: pop
    //   947: aload 10
    //   949: aconst_null
    //   950: invokevirtual 759	axf:a	(Lbcu;)V
    //   953: goto -163 -> 790
    //   956: astore_1
    //   957: getstatic 109	bbw:a	Ljava/lang/String;
    //   960: ldc_w 761
    //   963: iconst_1
    //   964: anewarray 113	java/lang/Object
    //   967: dup
    //   968: iconst_0
    //   969: aload_1
    //   970: aastore
    //   971: invokestatic 763	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   974: pop
    //   975: goto -84 -> 891
    //   978: iload 4
    //   980: iconst_1
    //   981: iadd
    //   982: istore 4
    //   984: goto -461 -> 523
    //   987: ldc_w 765
    //   990: astore_1
    //   991: goto -121 -> 870
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	994	0	this	axc
    //   0	994	1	paramArrayOfbdg	bdg[]
    //   0	994	2	parambcx	bcx
    //   0	994	3	parambdd	bdd
    //   23	960	4	i	int
    //   20	508	5	j	int
    //   353	425	6	bool	boolean
    //   16	444	7	localHashMap	HashMap
    //   36	840	8	localObject1	Object
    //   67	311	9	localObject2	Object
    //   225	723	10	localObject3	Object
    //   212	661	11	localObject4	Object
    //   536	199	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   287	335	416	java/io/IOException
    //   360	364	416	java/io/IOException
    //   364	371	416	java/io/IOException
    //   409	413	416	java/io/IOException
    //   475	479	416	java/io/IOException
    //   590	596	416	java/io/IOException
    //   903	907	416	java/io/IOException
    //   0	22	427	java/lang/RuntimeException
    //   38	51	427	java/lang/RuntimeException
    //   60	97	427	java/lang/RuntimeException
    //   97	134	427	java/lang/RuntimeException
    //   134	153	427	java/lang/RuntimeException
    //   153	172	427	java/lang/RuntimeException
    //   172	191	427	java/lang/RuntimeException
    //   191	197	427	java/lang/RuntimeException
    //   202	214	427	java/lang/RuntimeException
    //   219	287	427	java/lang/RuntimeException
    //   287	335	427	java/lang/RuntimeException
    //   360	364	427	java/lang/RuntimeException
    //   364	371	427	java/lang/RuntimeException
    //   409	413	427	java/lang/RuntimeException
    //   417	427	427	java/lang/RuntimeException
    //   475	479	427	java/lang/RuntimeException
    //   590	596	427	java/lang/RuntimeException
    //   903	907	427	java/lang/RuntimeException
    //   335	355	589	finally
    //   377	404	589	finally
    //   459	470	589	finally
    //   482	502	589	finally
    //   506	511	589	finally
    //   511	520	589	finally
    //   530	557	589	finally
    //   560	564	589	finally
    //   567	586	589	finally
    //   596	615	589	finally
    //   618	637	589	finally
    //   640	659	589	finally
    //   662	689	589	finally
    //   691	742	589	finally
    //   742	762	589	finally
    //   766	771	589	finally
    //   771	777	589	finally
    //   782	790	589	finally
    //   790	810	589	finally
    //   810	827	589	finally
    //   832	857	589	finally
    //   861	866	589	finally
    //   870	891	589	finally
    //   895	903	589	finally
    //   910	915	589	finally
    //   918	922	589	finally
    //   926	947	589	finally
    //   947	953	589	finally
    //   957	975	589	finally
    //   782	790	925	bdi
    //   870	891	956	java/lang/Exception
  }
  
  public final void a(bdg[] paramArrayOfbdg, bdb parambdb, bde parambde)
  {
    l();
    label391:
    label554:
    label560:
    label572:
    for (;;)
    {
      Object localObject1;
      int j;
      int i;
      Object localObject3;
      try
      {
        Object localObject2 = f.b(String.format(Locale.US, "UID COPY %s \"%s\"", new Object[] { axd.a(paramArrayOfbdg), axd.b(parambdb.c(), c.h) }), false);
        localObject1 = new HashMap();
        j = paramArrayOfbdg.length;
        i = 0;
        if (i < j)
        {
          localObject3 = paramArrayOfbdg[i];
          ((HashMap)localObject1).put(f, localObject3);
          i += 1;
          continue;
        }
        localObject2 = ((List)localObject2).iterator();
        i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break label391;
        }
        localObject3 = (axu)((Iterator)localObject2).next();
        if ((((axr)localObject3).a(0, "BAD", false)) || ((((axr)localObject3).a(0, "NO", false)) && (((axu)localObject3).f()))) {
          throw new bdi(26, ((axu)localObject3).j().e());
        }
      }
      catch (IOException paramArrayOfbdg)
      {
        throw a(f, paramArrayOfbdg);
      }
      finally
      {
        i();
      }
      if (((axu)localObject3).f())
      {
        Object localObject4 = ((axu)localObject3).b(1);
        String[] arrayOfString1;
        String[] arrayOfString2;
        if ("COPYUID".equals(((axr)localObject4).c(0).e()))
        {
          localObject3 = ((axr)localObject4).c(2).e();
          localObject4 = ((axr)localObject4).c(3).e();
          arrayOfString1 = ayb.a((String)localObject3);
          arrayOfString2 = ayb.a((String)localObject4);
          if (arrayOfString1.length == arrayOfString2.length) {
            break label554;
          }
          throw new bdi(28, String.valueOf(localObject3).length() + 45 + String.valueOf(localObject4).length() + "Set length mis-match; orig IDs \"" + (String)localObject3 + "\"  new IDs \"" + (String)localObject4 + "\"");
        }
        while (i < arrayOfString1.length)
        {
          if ((bdg)((HashMap)localObject1).get(arrayOfString1[i]) != null)
          {
            parambde.a(arrayOfString2[i]);
            break label560;
            if (i == 0) {
              parambdb = (axc)parambdb;
            }
            try
            {
              parambdb.a(bdf.a);
              j = paramArrayOfbdg.length;
              i = 0;
              while (i < j)
              {
                localObject1 = String.valueOf(paramArrayOfbdg[i].k());
                localObject1 = parambdb.a(String.valueOf(localObject1).length() + 20 + "HEADER Message-Id \"" + (String)localObject1 + "\"", true);
                if (localObject1.length == 1) {
                  parambde.a(localObject1[0]);
                }
                i += 1;
              }
            }
            catch (bdi paramArrayOfbdg)
            {
              for (;;)
              {
                cvm.b(bbw.a, "Failed to find message", new Object[] { paramArrayOfbdg });
                parambdb.b();
              }
            }
            finally
            {
              parambdb.b();
            }
            k();
            i();
            return;
            break label572;
            i = 0;
            continue;
          }
          i += 1;
        }
        i = 1;
      }
    }
  }
  
  public final void a(bdg[] paramArrayOfbdg, bda[] paramArrayOfbda, boolean paramBoolean)
  {
    l();
    Object localObject1;
    Object localObject2;
    if (paramArrayOfbda.length > 0)
    {
      localObject1 = new StringBuilder();
      int j = paramArrayOfbda.length;
      int i = 0;
      if (i < j)
      {
        localObject2 = paramArrayOfbda[i];
        if (localObject2 == bda.b) {
          ((StringBuilder)localObject1).append(" \\SEEN");
        }
        for (;;)
        {
          i += 1;
          break;
          if (localObject2 == bda.a) {
            ((StringBuilder)localObject1).append(" \\DELETED");
          } else if (localObject2 == bda.d) {
            ((StringBuilder)localObject1).append(" \\FLAGGED");
          } else if (localObject2 == bda.c) {
            ((StringBuilder)localObject1).append(" \\ANSWERED");
          } else if (localObject2 == bda.g) {
            ((StringBuilder)localObject1).append(" $Forwarded");
          }
        }
      }
      paramArrayOfbda = ((StringBuilder)localObject1).substring(1);
    }
    for (;;)
    {
      try
      {
        localObject1 = f;
        localObject2 = Locale.US;
        String str = axd.a(paramArrayOfbdg);
        if (paramBoolean)
        {
          paramArrayOfbdg = "+";
          ((axb)localObject1).b(String.format((Locale)localObject2, "UID STORE %s %sFLAGS.SILENT (%s)", new Object[] { str, paramArrayOfbdg, paramArrayOfbda }), false);
          return;
        }
        paramArrayOfbdg = "-";
        continue;
        paramArrayOfbda = "";
      }
      catch (IOException paramArrayOfbdg)
      {
        throw a(f, paramArrayOfbdg);
      }
      finally
      {
        i();
      }
    }
  }
  
  public final bdg[] a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt2 < paramInt1)) {
      throw new bdi(26, String.format("Invalid range: %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    cvm.b(bbw.a, 44 + "getMessages number " + paramInt1 + " - " + paramInt2, new Object[0]);
    return a(a(String.format(Locale.US, "%d:%d NOT DELETED", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), true), null);
  }
  
  public final bdg[] a(long paramLong)
  {
    String str = a(0L, paramLong, false);
    cvm.b(bbw.a, "getMessages dateRange %s", new Object[] { str });
    try
    {
      String[] arrayOfString1 = a(str, false);
      return a(arrayOfString1, null);
    }
    catch (axe localaxe1)
    {
      for (;;)
      {
        cvm.b(bbw.a, localaxe1, "query failed %s, trying alternate", new Object[] { str });
        str = a(0L, paramLong, true);
        try
        {
          String[] arrayOfString2 = a(str, true);
        }
        catch (axe localaxe2)
        {
          cvm.d(bbw.a, localaxe2, "query failed %s, fatal", new Object[] { str });
          Object localObject = null;
        }
      }
    }
  }
  
  public final bdg[] a(SearchParams paramSearchParams)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = c;
    paramSearchParams = "US-ASCII";
    if (!c(str1)) {
      paramSearchParams = "UTF-8";
    }
    int i = str1.getBytes().length;
    String str2 = 13 + "{" + i + "}";
    String str3 = String.valueOf("UID SEARCH CHARSET ");
    localArrayList.add(String.valueOf(str3).length() + 9 + String.valueOf(paramSearchParams).length() + String.valueOf(str2).length() + str3 + paramSearchParams + " OR FROM " + str2);
    localArrayList.add(String.valueOf(str1).length() + 8 + String.valueOf(str2).length() + str1 + " (OR TO " + str2);
    localArrayList.add(String.valueOf(str1).length() + 8 + String.valueOf(str2).length() + str1 + " (OR CC " + str2);
    localArrayList.add(String.valueOf(str1).length() + 13 + String.valueOf(str2).length() + str1 + " (OR SUBJECT " + str2);
    localArrayList.add(String.valueOf(str1).length() + 6 + String.valueOf(str2).length() + str1 + " BODY " + str2);
    localArrayList.add(String.valueOf(str1).concat(")))"));
    return a(b(localArrayList), null);
  }
  
  public final bdg b(String paramString)
  {
    return new axf(paramString, this);
  }
  
  public final void b()
  {
    e = -1;
    try
    {
      c.a(f);
      f = null;
      return;
    }
    finally {}
  }
  
  public final String c()
  {
    return d;
  }
  
  /* Error */
  public final boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 428	axc:h	Z
    //   4: ifeq +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 124	axc:f	Laxb;
    //   15: ifnonnull +75 -> 90
    //   18: aload_0
    //   19: getfield 28	axc:c	Laxd;
    //   22: invokevirtual 485	axd:g	()Laxb;
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: getstatic 147	java/util/Locale:US	Ljava/util/Locale;
    //   32: ldc_w 859
    //   35: iconst_1
    //   36: anewarray 113	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_0
    //   42: getfield 30	axc:d	Ljava/lang/String;
    //   45: aload_0
    //   46: getfield 28	axc:c	Laxd;
    //   49: getfield 435	axd:h	Ljava/lang/String;
    //   52: invokestatic 437	axd:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   55: aastore
    //   56: invokestatic 301	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   59: iconst_0
    //   60: invokevirtual 365	axb:b	(Ljava/lang/String;Z)Ljava/util/List;
    //   63: pop
    //   64: aload_0
    //   65: iconst_1
    //   66: putfield 428	axc:h	Z
    //   69: aload_1
    //   70: invokevirtual 425	axb:c	()V
    //   73: aload_0
    //   74: getfield 124	axc:f	Laxb;
    //   77: ifnonnull -70 -> 7
    //   80: aload_0
    //   81: getfield 28	axc:c	Laxd;
    //   84: aload_1
    //   85: invokevirtual 857	axd:a	(Laxb;)V
    //   88: iconst_1
    //   89: ireturn
    //   90: aload_0
    //   91: getfield 124	axc:f	Laxb;
    //   94: astore_1
    //   95: goto -69 -> 26
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_2
    //   104: aload_2
    //   105: getfield 861	bdi:d	I
    //   108: iconst_1
    //   109: if_icmpne +27 -> 136
    //   112: aload_2
    //   113: athrow
    //   114: astore_2
    //   115: aload_1
    //   116: invokevirtual 425	axb:c	()V
    //   119: aload_0
    //   120: getfield 124	axc:f	Laxb;
    //   123: ifnonnull +11 -> 134
    //   126: aload_0
    //   127: getfield 28	axc:c	Laxd;
    //   130: aload_1
    //   131: invokevirtual 857	axd:a	(Laxb;)V
    //   134: aload_2
    //   135: athrow
    //   136: aload_1
    //   137: invokevirtual 425	axb:c	()V
    //   140: aload_0
    //   141: getfield 124	axc:f	Laxb;
    //   144: ifnonnull +11 -> 155
    //   147: aload_0
    //   148: getfield 28	axc:c	Laxd;
    //   151: aload_1
    //   152: invokevirtual 857	axd:a	(Laxb;)V
    //   155: iconst_0
    //   156: ireturn
    //   157: astore_2
    //   158: aload_0
    //   159: aload_1
    //   160: aload_2
    //   161: invokespecial 391	axc:a	(Laxb;Ljava/io/IOException;)Lbdi;
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	axc
    //   25	70	1	localaxb1	axb
    //   98	62	1	localaxb2	axb
    //   103	10	2	localbdi	bdi
    //   114	21	2	localObject	Object
    //   157	4	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   11	26	98	finally
    //   26	28	98	finally
    //   90	95	98	finally
    //   99	101	98	finally
    //   28	69	103	bdi
    //   28	69	114	finally
    //   104	114	114	finally
    //   158	165	114	finally
    //   28	69	157	java/io/IOException
  }
  
  public final boolean e()
  {
    for (;;)
    {
      try
      {
        if (f == null) {
          localaxb1 = c.g();
        }
      }
      finally {}
      try
      {
        localaxb1.b(String.format(Locale.US, "CREATE \"%s\"", new Object[] { axd.b(d, c.h) }), false);
        return true;
      }
      catch (bdi localbdi)
      {
        g.b();
        cvm.d(cvm.a, localbdi, "MessagingException in ImapFolder.create", new Object[0]);
        return false;
      }
      catch (IOException localIOException)
      {
        g.b();
        cvm.d(cvm.a, localIOException, "IOException in ImapFolder.create", new Object[0]);
        throw a(localaxb2, localIOException);
      }
      finally
      {
        localaxb2.c();
        if (f != null) {
          break;
        }
        c.a(localaxb2);
      }
      axb localaxb1 = f;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof axc)) {
      return d.equals(d);
    }
    return super.equals(paramObject);
  }
  
  public final int f()
  {
    return e;
  }
  
  public final bdg[] g()
  {
    l();
    try
    {
      Iterator localIterator = f.b("EXPUNGE", false).iterator();
      while (localIterator.hasNext()) {
        a((axu)localIterator.next());
      }
    }
    catch (IOException localIOException)
    {
      throw a(f, localIOException);
    }
    finally
    {
      i();
    }
    return null;
  }
  
  public final bdk h()
  {
    if (f != null) {
      return new bdk(f.e, f.c, f.d, f.f);
    }
    return new bdk(-1, -1, -1, -1L);
  }
  
  public final int hashCode()
  {
    return d.hashCode();
  }
}

/* Location:
 * Qualified Name:     axc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */