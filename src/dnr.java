import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class dnr
  extends cfr
{
  private static final String a = cvm.a;
  private static final Map<String, dnr> g = new HashMap();
  
  private dnr(Context paramContext, String paramString)
  {
    super(paramContext, String.format(Locale.ENGLISH, "%s-%s", new Object[] { "Impressions", paramString }));
  }
  
  public static dnr a(Context paramContext, String paramString)
  {
    try
    {
      String str = deg.a(paramContext).a(paramString);
      dnr localdnr = (dnr)g.get(str);
      paramString = localdnr;
      if (localdnr == null)
      {
        paramString = new dnr(paramContext, str);
        g.put(str, paramString);
      }
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  private final List<dns> d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 77	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 78	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 81	cfr:d	Landroid/content/SharedPreferences;
    //   14: invokeinterface 87 1 0
    //   19: astore 4
    //   21: aload 4
    //   23: ldc 89
    //   25: invokeinterface 60 2 0
    //   30: checkcast 91	java/lang/Integer
    //   33: astore 5
    //   35: aload 5
    //   37: ifnonnull +11 -> 48
    //   40: invokestatic 96	java/util/Collections:emptyList	()Ljava/util/List;
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: areturn
    //   48: iconst_0
    //   49: istore_1
    //   50: iload_1
    //   51: aload 5
    //   53: invokevirtual 100	java/lang/Integer:intValue	()I
    //   56: if_icmpge +239 -> 295
    //   59: aload 4
    //   61: iload_1
    //   62: invokestatic 104	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   65: invokeinterface 60 2 0
    //   70: checkcast 47	java/lang/String
    //   73: astore 6
    //   75: aload 6
    //   77: ifnonnull +23 -> 100
    //   80: getstatic 16	dnr:a	Ljava/lang/String;
    //   83: ldc 106
    //   85: iconst_1
    //   86: anewarray 43	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: iload_1
    //   92: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: invokestatic 113	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   99: pop
    //   100: new 115	android/text/TextUtils$SimpleStringSplitter
    //   103: dup
    //   104: bipush 61
    //   106: invokespecial 118	android/text/TextUtils$SimpleStringSplitter:<init>	(C)V
    //   109: astore_2
    //   110: aload_2
    //   111: aload 6
    //   113: invokevirtual 122	android/text/TextUtils$SimpleStringSplitter:setString	(Ljava/lang/String;)V
    //   116: aload_2
    //   117: invokevirtual 126	android/text/TextUtils$SimpleStringSplitter:next	()Ljava/lang/String;
    //   120: ldc -128
    //   122: invokestatic 134	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 7
    //   127: aload_2
    //   128: invokevirtual 138	android/text/TextUtils$SimpleStringSplitter:hasNext	()Z
    //   131: ifne +24 -> 155
    //   134: new 140	dns
    //   137: dup
    //   138: aload 7
    //   140: invokespecial 142	dns:<init>	(Ljava/lang/String;)V
    //   143: astore_2
    //   144: aload_3
    //   145: aload_2
    //   146: invokeinterface 148 2 0
    //   151: pop
    //   152: goto +148 -> 300
    //   155: aload_2
    //   156: invokevirtual 126	android/text/TextUtils$SimpleStringSplitter:next	()Ljava/lang/String;
    //   159: astore 8
    //   161: aload_2
    //   162: invokevirtual 138	android/text/TextUtils$SimpleStringSplitter:hasNext	()Z
    //   165: ifne +52 -> 217
    //   168: new 140	dns
    //   171: dup
    //   172: aload 7
    //   174: aload 8
    //   176: invokestatic 152	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   179: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: invokespecial 155	dns:<init>	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   185: astore_2
    //   186: goto -42 -> 144
    //   189: astore_2
    //   190: getstatic 16	dnr:a	Ljava/lang/String;
    //   193: aload_2
    //   194: ldc -99
    //   196: iconst_1
    //   197: anewarray 43	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload 6
    //   204: aastore
    //   205: invokestatic 160	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   208: pop
    //   209: goto +91 -> 300
    //   212: astore_2
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_2
    //   216: athrow
    //   217: aload_2
    //   218: invokevirtual 126	android/text/TextUtils$SimpleStringSplitter:next	()Ljava/lang/String;
    //   221: ldc -128
    //   223: invokestatic 134	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 9
    //   228: aload_2
    //   229: invokevirtual 138	android/text/TextUtils$SimpleStringSplitter:hasNext	()Z
    //   232: ifeq +13 -> 245
    //   235: new 69	java/lang/IllegalStateException
    //   238: dup
    //   239: ldc -94
    //   241: invokespecial 163	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   244: athrow
    //   245: aload 8
    //   247: invokevirtual 166	java/lang/String:isEmpty	()Z
    //   250: ifeq +18 -> 268
    //   253: new 140	dns
    //   256: dup
    //   257: aload 7
    //   259: aload 9
    //   261: invokespecial 169	dns:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: astore_2
    //   265: goto -121 -> 144
    //   268: new 140	dns
    //   271: dup
    //   272: aload 7
    //   274: aload 8
    //   276: invokestatic 152	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   279: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: aload 9
    //   284: invokespecial 172	dns:<init>	(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V
    //   287: astore_2
    //   288: goto -144 -> 144
    //   291: astore_2
    //   292: goto -102 -> 190
    //   295: aload_3
    //   296: astore_2
    //   297: goto -253 -> 44
    //   300: iload_1
    //   301: iconst_1
    //   302: iadd
    //   303: istore_1
    //   304: goto -254 -> 50
    //   307: astore_2
    //   308: goto -118 -> 190
    //   311: astore_2
    //   312: goto -122 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	dnr
    //   49	255	1	i	int
    //   43	143	2	localObject1	Object
    //   189	5	2	localIllegalStateException	IllegalStateException
    //   212	17	2	localObject2	Object
    //   264	24	2	localdns	dns
    //   291	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
    //   296	1	2	localArrayList1	java.util.ArrayList
    //   307	1	2	localIndexOutOfBoundsException	IndexOutOfBoundsException
    //   311	1	2	localNumberFormatException	NumberFormatException
    //   9	287	3	localArrayList2	java.util.ArrayList
    //   19	41	4	localMap	Map
    //   33	19	5	localInteger	Integer
    //   73	130	6	str1	String
    //   125	148	7	str2	String
    //   159	116	8	str3	String
    //   226	57	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   100	144	189	java/lang/IllegalStateException
    //   144	152	189	java/lang/IllegalStateException
    //   155	186	189	java/lang/IllegalStateException
    //   217	245	189	java/lang/IllegalStateException
    //   245	265	189	java/lang/IllegalStateException
    //   268	288	189	java/lang/IllegalStateException
    //   2	35	212	finally
    //   40	44	212	finally
    //   50	75	212	finally
    //   80	100	212	finally
    //   100	144	212	finally
    //   144	152	212	finally
    //   155	186	212	finally
    //   190	209	212	finally
    //   217	245	212	finally
    //   245	265	212	finally
    //   268	288	212	finally
    //   100	144	291	java/io/UnsupportedEncodingException
    //   144	152	291	java/io/UnsupportedEncodingException
    //   155	186	291	java/io/UnsupportedEncodingException
    //   217	245	291	java/io/UnsupportedEncodingException
    //   245	265	291	java/io/UnsupportedEncodingException
    //   268	288	291	java/io/UnsupportedEncodingException
    //   100	144	307	java/lang/IndexOutOfBoundsException
    //   144	152	307	java/lang/IndexOutOfBoundsException
    //   155	186	307	java/lang/IndexOutOfBoundsException
    //   217	245	307	java/lang/IndexOutOfBoundsException
    //   245	265	307	java/lang/IndexOutOfBoundsException
    //   268	288	307	java/lang/IndexOutOfBoundsException
    //   100	144	311	java/lang/NumberFormatException
    //   144	152	311	java/lang/NumberFormatException
    //   155	186	311	java/lang/NumberFormatException
    //   217	245	311	java/lang/NumberFormatException
    //   245	265	311	java/lang/NumberFormatException
    //   268	288	311	java/lang/NumberFormatException
  }
  
  protected final void a(int paramInt)
  {
    if (paramInt > 4) {
      throw new IllegalStateException("It appears that app is downgraded. Please clear app data.");
    }
  }
  
  public final void a(dns paramdns)
  {
    for (;;)
    {
      try
      {
        int i = d.getInt("count", 0);
        try
        {
          SharedPreferences.Editor localEditor = e;
          if ((b != null) || (c != null)) {
            continue;
          }
          str1 = URLEncoder.encode(a, "utf-8");
          localEditor.putString(String.valueOf(i), str1).putInt("count", i + 1).apply();
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          String str1;
          Locale localLocale;
          String str2;
          cvm.e(a, localUnsupportedEncodingException, "Error encoding impression: %s", new Object[] { paramdns });
          continue;
        }
        return;
      }
      finally {}
      if (c != null) {
        continue;
      }
      str1 = String.format(Locale.ENGLISH, "%s%c%d", new Object[] { URLEncoder.encode(a, "utf-8"), Character.valueOf('='), b });
    }
    localLocale = Locale.ENGLISH;
    str2 = URLEncoder.encode(a, "utf-8");
    if (b != null) {}
    for (str1 = Integer.toString(b.intValue());; str1 = "")
    {
      str1 = String.format(localLocale, "%s%c%s%c%s", new Object[] { str2, Character.valueOf('='), str1, Character.valueOf('='), URLEncoder.encode(c, "utf-8") });
      break;
    }
  }
  
  protected final boolean a(String paramString)
  {
    return false;
  }
  
  public final List<dns> c()
  {
    try
    {
      List localList = d();
      e.clear().apply();
      return localList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     dnr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */