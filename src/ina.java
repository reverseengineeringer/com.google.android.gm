import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class ina
{
  static Class d;
  static Class e;
  private static ina f;
  String[] a = null;
  imj[] b = null;
  int c = -1;
  
  static
  {
    ina localina = new ina();
    if (d == null)
    {
      localClass = c("ina");
      d = localClass;
    }
    for (;;)
    {
      try
      {
        f = localina;
        return;
      }
      finally {}
      localClass = d;
    }
  }
  
  public ina()
  {
    if (b()) {}
    while ((c()) || ((a != null) && (b != null))) {
      return;
    }
    Object localObject1 = System.getProperty("os.name");
    Object localObject2 = System.getProperty("java.vendor");
    if ((((String)localObject1).indexOf("Windows") == -1) || ((((String)localObject1).indexOf("95") != -1) || (((String)localObject1).indexOf("98") != -1) || (((String)localObject1).indexOf("ME") != -1))) {}
    try
    {
      localObject2 = Runtime.getRuntime();
      localObject1 = String.valueOf("winipcfg.out");
      if (((String)localObject1).length() != 0) {}
      for (localObject1 = "winipcfg /all /batch ".concat((String)localObject1);; localObject1 = new String("winipcfg /all /batch "))
      {
        ((Runtime)localObject2).exec((String)localObject1).waitFor();
        a(new FileInputStream(new File("winipcfg.out")));
        new File("winipcfg.out").delete();
        return;
      }
      try
      {
        localObject1 = Runtime.getRuntime().exec("ipconfig /all");
        a(((Process)localObject1).getInputStream());
        ((Process)localObject1).destroy();
        return;
      }
      catch (Exception localException1)
      {
        return;
      }
      if (localException1.indexOf("NetWare") != -1)
      {
        b("sys:/etc/resolv.cfg");
        return;
      }
      if (((String)localObject2).indexOf("Android") != -1)
      {
        d();
        return;
      }
      b("/etc/resolv.conf");
      return;
    }
    catch (Exception localException2) {}
  }
  
  private static int a(String paramString)
  {
    paramString = paramString.substring(6);
    try
    {
      int j = Integer.parseInt(paramString);
      int i;
      if (j >= 0)
      {
        i = j;
        if (!imn.a("verbose")) {
          return i;
        }
        PrintStream localPrintStream = System.out;
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {}
        for (paramString = "setting ndots ".concat(paramString);; paramString = new String("setting ndots "))
        {
          localPrintStream.println(paramString);
          return j;
        }
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      i = -1;
    }
  }
  
  public static ina a()
  {
    try
    {
      ina localina = f;
      return localina;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private final void a(InputStream paramInputStream)
  {
    int i = Integer.getInteger("org.xbill.DNS2.windows.parse.buffer", 8192).intValue();
    paramInputStream = new BufferedInputStream(paramInputStream, i);
    paramInputStream.mark(i);
    a(paramInputStream, null);
    if (a == null) {}
    try
    {
      paramInputStream.reset();
      a(paramInputStream, new Locale("", ""));
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  /* Error */
  private final void a(InputStream paramInputStream, Locale paramLocale)
  {
    // Byte code:
    //   0: getstatic 22	ina:d	Ljava/lang/Class;
    //   3: ifnonnull +159 -> 162
    //   6: ldc 23
    //   8: invokestatic 26	ina:c	(Ljava/lang/String;)Ljava/lang/Class;
    //   11: astore 7
    //   13: aload 7
    //   15: putstatic 22	ina:d	Ljava/lang/Class;
    //   18: aload 7
    //   20: invokevirtual 206	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   23: invokevirtual 212	java/lang/Package:getName	()Ljava/lang/String;
    //   26: invokestatic 79	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   29: ldc -42
    //   31: invokevirtual 88	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore 7
    //   36: aload_2
    //   37: ifnull +133 -> 170
    //   40: aload 7
    //   42: aload_2
    //   43: invokestatic 220	java/util/ResourceBundle:getBundle	(Ljava/lang/String;Ljava/util/Locale;)Ljava/util/ResourceBundle;
    //   46: astore_2
    //   47: aload_2
    //   48: ldc -34
    //   50: invokevirtual 225	java/util/ResourceBundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 7
    //   55: aload_2
    //   56: ldc -29
    //   58: invokevirtual 225	java/util/ResourceBundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 8
    //   63: aload_2
    //   64: ldc -27
    //   66: invokevirtual 225	java/util/ResourceBundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 9
    //   71: aload_2
    //   72: ldc -25
    //   74: invokevirtual 225	java/util/ResourceBundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 10
    //   79: new 233	java/io/BufferedReader
    //   82: dup
    //   83: new 235	java/io/InputStreamReader
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 237	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   91: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   94: astore 11
    //   96: new 242	java/util/ArrayList
    //   99: dup
    //   100: invokespecial 243	java/util/ArrayList:<init>	()V
    //   103: astore 12
    //   105: new 242	java/util/ArrayList
    //   108: dup
    //   109: invokespecial 243	java/util/ArrayList:<init>	()V
    //   112: astore 13
    //   114: iconst_0
    //   115: istore 4
    //   117: iconst_0
    //   118: istore_3
    //   119: aload 11
    //   121: invokevirtual 246	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   124: astore 15
    //   126: aload 15
    //   128: ifnull +309 -> 437
    //   131: new 248	java/util/StringTokenizer
    //   134: dup
    //   135: aload 15
    //   137: invokespecial 249	java/util/StringTokenizer:<init>	(Ljava/lang/String;)V
    //   140: astore 14
    //   142: aload 14
    //   144: invokevirtual 252	java/util/StringTokenizer:hasMoreTokens	()Z
    //   147: istore 6
    //   149: iload 6
    //   151: ifne +28 -> 179
    //   154: iconst_0
    //   155: istore 4
    //   157: iconst_0
    //   158: istore_3
    //   159: goto -40 -> 119
    //   162: getstatic 22	ina:d	Ljava/lang/Class;
    //   165: astore 7
    //   167: goto -149 -> 18
    //   170: aload 7
    //   172: invokestatic 255	java/util/ResourceBundle:getBundle	(Ljava/lang/String;)Ljava/util/ResourceBundle;
    //   175: astore_2
    //   176: goto -129 -> 47
    //   179: aload 14
    //   181: invokevirtual 258	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   184: astore_1
    //   185: aload 15
    //   187: ldc_w 260
    //   190: invokevirtual 61	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   193: iconst_m1
    //   194: if_icmpeq +267 -> 461
    //   197: iconst_0
    //   198: istore_3
    //   199: iconst_0
    //   200: istore 4
    //   202: aload 15
    //   204: aload 7
    //   206: invokevirtual 61	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   209: iconst_m1
    //   210: if_icmpeq +53 -> 263
    //   213: aload 14
    //   215: invokevirtual 252	java/util/StringTokenizer:hasMoreTokens	()Z
    //   218: ifeq +12 -> 230
    //   221: aload 14
    //   223: invokevirtual 258	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   226: astore_1
    //   227: goto -14 -> 213
    //   230: aload_1
    //   231: aconst_null
    //   232: invokestatic 265	imj:a	(Ljava/lang/String;Limj;)Limj;
    //   235: astore_2
    //   236: aload_2
    //   237: invokevirtual 267	imj:a	()I
    //   240: iconst_1
    //   241: if_icmpeq +207 -> 448
    //   244: aload_1
    //   245: aload 13
    //   247: invokestatic 270	ina:b	(Ljava/lang/String;Ljava/util/List;)V
    //   250: iload_3
    //   251: istore 5
    //   253: iload 4
    //   255: istore_3
    //   256: iload 5
    //   258: istore 4
    //   260: goto -141 -> 119
    //   263: aload 15
    //   265: aload 8
    //   267: invokevirtual 61	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   270: iconst_m1
    //   271: if_icmpeq +44 -> 315
    //   274: aload 14
    //   276: invokevirtual 252	java/util/StringTokenizer:hasMoreTokens	()Z
    //   279: ifeq +12 -> 291
    //   282: aload 14
    //   284: invokevirtual 258	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   287: astore_1
    //   288: goto -14 -> 274
    //   291: aload_1
    //   292: ldc_w 260
    //   295: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   298: ifne +150 -> 448
    //   301: aload_1
    //   302: aload 13
    //   304: invokestatic 270	ina:b	(Ljava/lang/String;Ljava/util/List;)V
    //   307: iload_3
    //   308: istore 4
    //   310: iconst_1
    //   311: istore_3
    //   312: goto -193 -> 119
    //   315: aload_1
    //   316: astore_2
    //   317: iload 4
    //   319: ifne +16 -> 335
    //   322: aload 15
    //   324: aload 9
    //   326: invokevirtual 61	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   329: iconst_m1
    //   330: if_icmpeq +46 -> 376
    //   333: aload_1
    //   334: astore_2
    //   335: aload 14
    //   337: invokevirtual 252	java/util/StringTokenizer:hasMoreTokens	()Z
    //   340: ifeq +12 -> 352
    //   343: aload 14
    //   345: invokevirtual 258	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   348: astore_2
    //   349: goto -14 -> 335
    //   352: aload_2
    //   353: ldc_w 260
    //   356: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   359: ifne +89 -> 448
    //   362: aload_2
    //   363: aload 13
    //   365: invokestatic 270	ina:b	(Ljava/lang/String;Ljava/util/List;)V
    //   368: iload_3
    //   369: istore 4
    //   371: iconst_1
    //   372: istore_3
    //   373: goto -254 -> 119
    //   376: aload_1
    //   377: astore_2
    //   378: iload_3
    //   379: ifne +19 -> 398
    //   382: iload_3
    //   383: istore 5
    //   385: aload 15
    //   387: aload 10
    //   389: invokevirtual 61	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   392: iconst_m1
    //   393: if_icmpeq +95 -> 488
    //   396: aload_1
    //   397: astore_2
    //   398: aload 14
    //   400: invokevirtual 252	java/util/StringTokenizer:hasMoreTokens	()Z
    //   403: ifeq +12 -> 415
    //   406: aload 14
    //   408: invokevirtual 258	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   411: astore_2
    //   412: goto -14 -> 398
    //   415: aload_2
    //   416: ldc_w 260
    //   419: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   422: ifne +26 -> 448
    //   425: aload_2
    //   426: aload 12
    //   428: invokestatic 276	ina:a	(Ljava/lang/String;Ljava/util/List;)V
    //   431: iconst_1
    //   432: istore 5
    //   434: goto +54 -> 488
    //   437: aload_0
    //   438: aload 12
    //   440: aload 13
    //   442: invokespecial 279	ina:a	(Ljava/util/List;Ljava/util/List;)V
    //   445: return
    //   446: astore_1
    //   447: return
    //   448: iload_3
    //   449: istore 5
    //   451: iload 4
    //   453: istore_3
    //   454: iload 5
    //   456: istore 4
    //   458: goto -339 -> 119
    //   461: iload_3
    //   462: istore 5
    //   464: iload 4
    //   466: istore_3
    //   467: iload 5
    //   469: istore 4
    //   471: goto -269 -> 202
    //   474: astore_1
    //   475: iload_3
    //   476: istore 5
    //   478: iload 4
    //   480: istore_3
    //   481: iload 5
    //   483: istore 4
    //   485: goto -366 -> 119
    //   488: iload 4
    //   490: istore_3
    //   491: iload 5
    //   493: istore 4
    //   495: goto -376 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	this	ina
    //   0	498	1	paramInputStream	InputStream
    //   0	498	2	paramLocale	Locale
    //   118	373	3	i	int
    //   115	379	4	j	int
    //   251	241	5	k	int
    //   147	3	6	bool	boolean
    //   11	194	7	localObject	Object
    //   61	205	8	str1	String
    //   69	256	9	str2	String
    //   77	311	10	str3	String
    //   94	26	11	localBufferedReader	BufferedReader
    //   103	336	12	localArrayList1	ArrayList
    //   112	329	13	localArrayList2	ArrayList
    //   140	267	14	localStringTokenizer	StringTokenizer
    //   124	262	15	str4	String
    // Exception table:
    //   from	to	target	type
    //   96	114	446	java/io/IOException
    //   119	126	446	java/io/IOException
    //   131	149	446	java/io/IOException
    //   179	197	446	java/io/IOException
    //   202	213	446	java/io/IOException
    //   213	227	446	java/io/IOException
    //   230	236	446	java/io/IOException
    //   236	250	446	java/io/IOException
    //   263	274	446	java/io/IOException
    //   274	288	446	java/io/IOException
    //   291	307	446	java/io/IOException
    //   322	333	446	java/io/IOException
    //   335	349	446	java/io/IOException
    //   352	368	446	java/io/IOException
    //   385	396	446	java/io/IOException
    //   398	412	446	java/io/IOException
    //   415	431	446	java/io/IOException
    //   437	445	446	java/io/IOException
    //   230	236	474	inw
  }
  
  private static void a(String paramString, List paramList)
  {
    if (paramList.contains(paramString)) {
      return;
    }
    PrintStream localPrintStream;
    if (imn.a("verbose"))
    {
      localPrintStream = System.out;
      str = String.valueOf(paramString);
      if (str.length() == 0) {
        break label57;
      }
    }
    label57:
    for (String str = "adding server ".concat(str);; str = new String("adding server "))
    {
      localPrintStream.println(str);
      paramList.add(paramString);
      return;
    }
  }
  
  private final void a(List paramList1, List paramList2)
  {
    if ((a == null) && (paramList1.size() > 0)) {
      a = ((String[])paramList1.toArray(new String[0]));
    }
    if ((b == null) && (paramList2.size() > 0)) {
      b = ((imj[])paramList2.toArray(new imj[0]));
    }
  }
  
  private final void b(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramString));
      paramString = new ArrayList(0);
      ArrayList localArrayList = new ArrayList(0);
      int i = -1;
      int j = i;
      for (;;)
      {
        try
        {
          localObject = localBufferedReader.readLine();
          if (localObject == null) {
            break label376;
          }
          j = i;
          if (((String)localObject).startsWith("nameserver"))
          {
            j = i;
            localObject = new StringTokenizer((String)localObject);
            j = i;
            ((StringTokenizer)localObject).nextToken();
            j = i;
            a(((StringTokenizer)localObject).nextToken(), paramString);
          }
        }
        catch (IOException localIOException)
        {
          i = j;
          a(paramString, localArrayList);
          if ((c < 0) && (i > 0)) {
            c = i;
          }
          return;
        }
        j = i;
        if (((String)localObject).startsWith("domain"))
        {
          j = i;
          localObject = new StringTokenizer((String)localObject);
          j = i;
          ((StringTokenizer)localObject).nextToken();
          j = i;
          if (!((StringTokenizer)localObject).hasMoreTokens()) {
            break;
          }
          j = i;
          if (!localArrayList.isEmpty()) {
            break;
          }
          j = i;
          b(((StringTokenizer)localObject).nextToken(), localArrayList);
          break;
        }
        j = i;
        if (((String)localObject).startsWith("search"))
        {
          j = i;
          if (!localArrayList.isEmpty())
          {
            j = i;
            localArrayList.clear();
          }
          j = i;
          localObject = new StringTokenizer((String)localObject);
          j = i;
          ((StringTokenizer)localObject).nextToken();
          for (;;)
          {
            j = i;
            if (!((StringTokenizer)localObject).hasMoreTokens()) {
              break;
            }
            j = i;
            b(((StringTokenizer)localObject).nextToken(), localArrayList);
          }
        }
        j = i;
        if (!((String)localObject).startsWith("options")) {
          break;
        }
        j = i;
        Object localObject = new StringTokenizer((String)localObject);
        j = i;
        ((StringTokenizer)localObject).nextToken();
        int k = i;
        for (;;)
        {
          i = k;
          j = k;
          if (!((StringTokenizer)localObject).hasMoreTokens()) {
            break;
          }
          j = k;
          String str = ((StringTokenizer)localObject).nextToken();
          j = k;
          if (str.startsWith("ndots:"))
          {
            j = k;
            k = a(str);
          }
        }
        label376:
        j = i;
        localIOException.close();
      }
      return;
    }
    catch (FileNotFoundException paramString) {}
  }
  
  private static void b(String paramString, List paramList)
  {
    PrintStream localPrintStream;
    String str;
    if (imn.a("verbose"))
    {
      localPrintStream = System.out;
      str = String.valueOf(paramString);
      if (str.length() == 0) {
        break label56;
      }
      str = "adding search ".concat(str);
    }
    for (;;)
    {
      localPrintStream.println(str);
      try
      {
        paramString = imj.a(paramString, imj.a);
        if (paramList.contains(paramString))
        {
          return;
          label56:
          str = new String("adding search ");
        }
        else
        {
          paramList.add(paramString);
          return;
        }
      }
      catch (inw paramString) {}
    }
  }
  
  private final boolean b()
  {
    boolean bool2 = false;
    ArrayList localArrayList1 = new ArrayList(0);
    ArrayList localArrayList2 = new ArrayList(0);
    Object localObject = System.getProperty("dns.server");
    if (localObject != null)
    {
      localObject = new StringTokenizer((String)localObject, ",");
      while (((StringTokenizer)localObject).hasMoreTokens()) {
        a(((StringTokenizer)localObject).nextToken(), localArrayList1);
      }
    }
    localObject = System.getProperty("dns.search");
    if (localObject != null)
    {
      localObject = new StringTokenizer((String)localObject, ",");
      while (((StringTokenizer)localObject).hasMoreTokens()) {
        b(((StringTokenizer)localObject).nextToken(), localArrayList2);
      }
    }
    a(localArrayList1, localArrayList2);
    boolean bool1 = bool2;
    if (a != null)
    {
      bool1 = bool2;
      if (b != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static Class c(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError().initCause(paramString);
    }
  }
  
  private final boolean c()
  {
    ArrayList localArrayList1 = new ArrayList(0);
    ArrayList localArrayList2 = new ArrayList(0);
    Object localObject2;
    Object localObject1;
    try
    {
      localObject2 = new Class[0];
      Object[] arrayOfObject = new Object[0];
      Class localClass = Class.forName("sun.net.dns.ResolverConfiguration");
      Object localObject3 = localClass.getDeclaredMethod("open", (Class[])localObject2).invoke(null, arrayOfObject);
      localObject1 = (List)localClass.getMethod("nameservers", (Class[])localObject2).invoke(localObject3, arrayOfObject);
      localObject2 = (List)localClass.getMethod("searchlist", (Class[])localObject2).invoke(localObject3, arrayOfObject);
      if (((List)localObject1).size() == 0) {
        return false;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((String)((Iterator)localObject1).next(), localException);
      }
    }
    if (((List)localObject2).size() > 0)
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        b((String)((Iterator)localObject1).next(), localArrayList2);
      }
    }
    a(localException, localArrayList2);
    return true;
  }
  
  private final void d()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    label175:
    for (;;)
    {
      try
      {
        Object localObject2 = Class.forName("android.os.SystemProperties");
        Object localObject1;
        int i;
        if (e == null)
        {
          localObject1 = c("java.lang.String");
          e = (Class)localObject1;
          localObject1 = ((Class)localObject2).getMethod("get", new Class[] { localObject1 });
          i = 0;
          if (i < 4)
          {
            localObject2 = (String)((Method)localObject1).invoke(null, new Object[] { new String[] { "net.dns1", "net.dns2", "net.dns3", "net.dns4" }[i] });
            if ((localObject2 == null) || ((!((String)localObject2).matches("^\\d+(\\.\\d+){3}$")) && (!((String)localObject2).matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$"))) || (localArrayList1.contains(localObject2))) {
              break label175;
            }
            localArrayList1.add(localObject2);
            break label175;
          }
        }
        else
        {
          localObject1 = e;
          continue;
        }
        i += 1;
      }
      catch (Exception localException)
      {
        a(localArrayList1, localArrayList2);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     ina
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */