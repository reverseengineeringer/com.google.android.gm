import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.android.emailcommon.EmailProviderConfiguration;
import com.android.emailcommon.provider.Credential;
import com.android.emailcommon.provider.HostAuth;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class awj
{
  private static final String a = cvm.a;
  private static awj b;
  private final Context c;
  private List<EmailProviderConfiguration> d;
  private List<bcb> e;
  
  private awj(Context paramContext)
  {
    c = paramContext.getApplicationContext();
  }
  
  public static awj a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new awj(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private final EmailProviderConfiguration a(XmlResourceParser paramXmlResourceParser, int paramInt)
  {
    EmailProviderConfiguration localEmailProviderConfiguration = new EmailProviderConfiguration(paramInt);
    b = a(paramXmlResourceParser, "id");
    c = a(paramXmlResourceParser, "label");
    d = a(paramXmlResourceParser, "domain").toLowerCase(Locale.ENGLISH);
    q = a(paramXmlResourceParser, "oauth");
    label232:
    do
    {
      for (;;)
      {
        paramInt = paramXmlResourceParser.next();
        if (paramInt == 1) {
          break label300;
        }
        switch (paramInt)
        {
        default: 
          break;
        case 2: 
          str1 = paramXmlResourceParser.getName();
          str2 = a(paramXmlResourceParser, "uri");
          String str3 = a(paramXmlResourceParser, "username");
          if ("incoming".equals(str1))
          {
            e = str2;
            f = str3;
          }
          else if ("outgoing".equals(str1))
          {
            g = str2;
            h = str3;
          }
          else if ("incoming-fallback".equals(str1))
          {
            i = str2;
            j = str3;
          }
          else
          {
            if (!"outgoing-fallback".equals(str1)) {
              break label232;
            }
            k = str2;
            l = str3;
          }
          break;
        }
      }
      String str2 = a;
      String str1 = String.valueOf(str1);
      if (str1.length() != 0) {}
      for (str1 = "Unexpected start tag inside provider. Tag name: ".concat(str1);; str1 = new String("Unexpected start tag inside provider. Tag name: "))
      {
        cvm.d(str2, str1, new Object[0]);
        break;
      }
    } while (!"provider".equals(paramXmlResourceParser.getName()));
    return localEmailProviderConfiguration;
    label300:
    throw new IllegalStateException("Unexpected end of document inside provider");
  }
  
  private final String a(XmlResourceParser paramXmlResourceParser, String paramString)
  {
    int i = paramXmlResourceParser.getAttributeResourceValue(null, paramString, 0);
    if (i == 0) {
      return paramXmlResourceParser.getAttributeValue(null, paramString);
    }
    return c.getString(i);
  }
  
  private final void a(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      try
      {
        throw new IllegalArgumentException(66 + "Can't figure out the correct provider file for origin: " + paramInt);
      }
      finally {}
    case 1: 
      i = arj.d;
    }
    for (;;)
    {
      try
      {
        XmlResourceParser localXmlResourceParser = c.getResources().getXml(i);
        i = localXmlResourceParser.next();
        if (i != 1)
        {
          if ((i == 2) && ("provider".equals(localXmlResourceParser.getName()))) {
            d.add(a(localXmlResourceParser, paramInt));
          }
        }
        else {
          i = arj.e;
        }
      }
      catch (Exception localException)
      {
        cvm.e(a, "Error loading providers.", new Object[] { localException });
        return;
      }
    }
  }
  
  /* Error */
  private final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 217	awj:e	Ljava/util/List;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new 219	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 220	java/util/ArrayList:<init>	()V
    //   22: putfield 217	awj:e	Ljava/util/List;
    //   25: aload_0
    //   26: getfield 35	awj:c	Landroid/content/Context;
    //   29: invokevirtual 194	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   32: getstatic 222	arj:c	I
    //   35: invokevirtual 200	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   38: astore_3
    //   39: aload_3
    //   40: invokeinterface 84 1 0
    //   45: istore_1
    //   46: iload_1
    //   47: iconst_1
    //   48: if_icmpeq -37 -> 11
    //   51: iload_1
    //   52: iconst_2
    //   53: if_icmpne -14 -> 39
    //   56: ldc -108
    //   58: aload_3
    //   59: invokeinterface 88 1 0
    //   64: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: istore_2
    //   68: iload_2
    //   69: ifeq -30 -> 39
    //   72: new 224	bcb
    //   75: dup
    //   76: invokespecial 225	bcb:<init>	()V
    //   79: astore 4
    //   81: aload 4
    //   83: aload_0
    //   84: aload_3
    //   85: ldc 48
    //   87: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   90: putfield 226	bcb:a	Ljava/lang/String;
    //   93: aload 4
    //   95: aload_0
    //   96: aload_3
    //   97: ldc 55
    //   99: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   102: putfield 227	bcb:b	Ljava/lang/String;
    //   105: aload 4
    //   107: aload_0
    //   108: aload_3
    //   109: ldc -27
    //   111: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 230	bcb:c	Ljava/lang/String;
    //   117: aload 4
    //   119: aload_0
    //   120: aload_3
    //   121: ldc -24
    //   123: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   126: putfield 233	bcb:d	Ljava/lang/String;
    //   129: aload 4
    //   131: aload_0
    //   132: aload_3
    //   133: ldc -21
    //   135: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   138: putfield 236	bcb:e	Ljava/lang/String;
    //   141: aload 4
    //   143: aload_0
    //   144: aload_3
    //   145: ldc -18
    //   147: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 239	bcb:f	Ljava/lang/String;
    //   153: aload 4
    //   155: aload_0
    //   156: aload_3
    //   157: ldc -15
    //   159: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   162: putfield 242	bcb:g	Ljava/lang/String;
    //   165: aload 4
    //   167: aload_0
    //   168: aload_3
    //   169: ldc -12
    //   171: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   174: putfield 245	bcb:h	Ljava/lang/String;
    //   177: aload 4
    //   179: aload_0
    //   180: aload_3
    //   181: ldc -9
    //   183: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   186: putfield 248	bcb:i	Ljava/lang/String;
    //   189: aload 4
    //   191: aload_0
    //   192: aload_3
    //   193: ldc -6
    //   195: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   198: putfield 251	bcb:l	Ljava/lang/String;
    //   201: aload 4
    //   203: aload_0
    //   204: aload_3
    //   205: ldc -3
    //   207: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   210: putfield 254	bcb:j	Ljava/lang/String;
    //   213: aload 4
    //   215: aload_0
    //   216: aload_3
    //   217: ldc_w 256
    //   220: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 257	bcb:k	Ljava/lang/String;
    //   226: aload 4
    //   228: aload_0
    //   229: aload_3
    //   230: ldc_w 259
    //   233: invokespecial 51	awj:a	(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/String;
    //   236: putfield 262	bcb:m	Ljava/lang/String;
    //   239: aload_0
    //   240: getfield 217	awj:e	Ljava/util/List;
    //   243: aload 4
    //   245: invokeinterface 209 2 0
    //   250: pop
    //   251: goto -212 -> 39
    //   254: astore 4
    //   256: getstatic 265	bbw:a	Ljava/lang/String;
    //   259: ldc_w 267
    //   262: iconst_1
    //   263: anewarray 4	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload_3
    //   269: invokeinterface 270 1 0
    //   274: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: aastore
    //   278: invokestatic 143	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   281: pop
    //   282: goto -243 -> 39
    //   285: astore_3
    //   286: getstatic 265	bbw:a	Ljava/lang/String;
    //   289: ldc_w 277
    //   292: iconst_1
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_3
    //   299: aastore
    //   300: invokestatic 213	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   303: pop
    //   304: goto -293 -> 11
    //   307: astore_3
    //   308: aload_0
    //   309: monitorexit
    //   310: aload_3
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	awj
    //   45	9	1	i	int
    //   67	2	2	bool	boolean
    //   6	263	3	localObject1	Object
    //   285	14	3	localException	Exception
    //   307	4	3	localObject2	Object
    //   79	165	4	localbcb	bcb
    //   254	1	4	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   72	251	254	java/lang/IllegalArgumentException
    //   25	39	285	java/lang/Exception
    //   39	46	285	java/lang/Exception
    //   56	68	285	java/lang/Exception
    //   72	251	285	java/lang/Exception
    //   256	282	285	java/lang/Exception
    //   2	7	307	finally
    //   14	25	307	finally
    //   25	39	307	finally
    //   39	46	307	finally
    //   56	68	307	finally
    //   72	251	307	finally
    //   256	282	307	finally
    //   286	304	307	finally
  }
  
  /* Error */
  private final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 202	awj:d	Ljava/util/List;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new 219	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 220	java/util/ArrayList:<init>	()V
    //   22: putfield 202	awj:d	Ljava/util/List;
    //   25: aload_0
    //   26: iconst_2
    //   27: invokespecial 279	awj:a	(I)V
    //   30: aload_0
    //   31: iconst_1
    //   32: invokespecial 279	awj:a	(I)V
    //   35: new 281	awg
    //   38: dup
    //   39: aload_0
    //   40: getfield 35	awj:c	Landroid/content/Context;
    //   43: invokespecial 282	awg:<init>	(Landroid/content/Context;)V
    //   46: astore_1
    //   47: aload_0
    //   48: getfield 202	awj:d	Ljava/util/List;
    //   51: aload_1
    //   52: invokevirtual 285	awg:a	()Ljava/util/List;
    //   55: invokeinterface 289 2 0
    //   60: pop
    //   61: goto -50 -> 11
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	awj
    //   6	46	1	localObject1	Object
    //   64	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	64	finally
    //   14	61	64	finally
  }
  
  public final EmailProviderConfiguration a(String paramString)
  {
    return b(cui.b(paramString));
  }
  
  public final void a(HostAuth paramHostAuth, Bundle paramBundle)
  {
    Credential localCredential = paramHostAuth.b(c);
    c = paramBundle.getString("provider");
    d = paramBundle.getString("accessToken");
    e = paramBundle.getString("refreshToken");
    f = (paramBundle.getLong("expiresInSeconds", 0L) * 1000L + System.currentTimeMillis());
    g = null;
  }
  
  public final boolean a()
  {
    b();
    return !e.isEmpty();
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    if (!a()) {}
    do
    {
      do
      {
        return false;
        cvm.b(a, "OAuth: supportsOAuth, protocol=%s, provider=%s", new Object[] { paramString1, paramString2 });
        if (paramString1 == null) {
          break;
        }
        paramString1 = bam.e(c, paramString1);
        cvm.b(a, "OAuth: supportsOAuth, serviceInfo=%s", new Object[] { paramString1 });
      } while ((paramString1 != null) && (!l));
    } while (c(paramString2) == null);
    return true;
  }
  
  public final EmailProviderConfiguration b(String paramString)
  {
    c();
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      EmailProviderConfiguration localEmailProviderConfiguration = (EmailProviderConfiguration)localIterator.next();
      Object localObject = d;
      String[] arrayOfString = paramString.split("\\.");
      localObject = ((String)localObject).split("\\.");
      int i;
      if (arrayOfString.length != localObject.length) {
        i = 0;
      }
      while (i != 0)
      {
        return localEmailProviderConfiguration;
        int j = 0;
        for (;;)
        {
          if (j >= arrayOfString.length) {
            break label215;
          }
          String str1 = arrayOfString[j].toLowerCase(Locale.ENGLISH);
          String str2 = localObject[j].toLowerCase(Locale.ENGLISH);
          if (!str2.equals("*"))
          {
            int k = str2.length();
            if (str1.length() != k) {
              i = 0;
            }
            for (;;)
            {
              if (i != 0) {
                break label208;
              }
              i = 0;
              break;
              i = 0;
              for (;;)
              {
                if (i >= k) {
                  break label203;
                }
                int m = str1.charAt(i);
                int n = str2.charAt(i);
                if ((m != n) && (n != 63))
                {
                  i = 0;
                  break;
                }
                i += 1;
              }
              label203:
              i = 1;
            }
          }
          label208:
          j += 1;
        }
        label215:
        i = 1;
      }
    }
    return null;
  }
  
  public final bcb c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        b();
        Iterator localIterator = e.iterator();
        bcb localbcb;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localbcb = (bcb)localIterator.next();
          cvm.b(cvm.a, "OAuth: findOAuthProviderById, provider=%s, query=%s", new Object[] { a, paramString });
        } while (!paramString.equals(a));
        return localbcb;
        if (paramString.equals("google"))
        {
          i = 0;
          continue;
          if (paramString.equals("mail.ru"))
          {
            i = 1;
            continue;
            if (paramString.equals("yandex")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    return null;
    return null;
    return null;
    return null;
  }
}

/* Location:
 * Qualified Name:     awj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */