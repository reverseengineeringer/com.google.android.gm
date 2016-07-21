import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public final class bns
{
  public final int a;
  public final int b;
  public final boolean c;
  private final HttpResponse d;
  private final HttpEntity e;
  private InputStream f;
  private boolean g;
  
  public bns(HttpResponse paramHttpResponse, bgy parambgy, long paramLong)
  {
    d = paramHttpResponse;
    HttpEntity localHttpEntity;
    label43:
    int j;
    label75:
    boolean bool;
    if (paramHttpResponse == null)
    {
      localHttpEntity = null;
      e = localHttpEntity;
      if (e == null) {
        break label135;
      }
      a = ((int)e.getContentLength());
      j = paramHttpResponse.getStatusLine().getStatusCode();
      if ((j != 401) && (j != 403)) {
        break label143;
      }
      i = 1;
      if ((i == 0) || (!parambgy.a(paramLong))) {
        break label149;
      }
      bool = true;
      label91:
      c = bool;
      if (!c) {
        break label155;
      }
      g = true;
    }
    label135:
    label143:
    label149:
    label155:
    for (int i = 401;; i = j)
    {
      b = i;
      return;
      localHttpEntity = d.getEntity();
      break;
      a = 0;
      break label43;
      i = 0;
      break label75;
      bool = false;
      break label91;
    }
  }
  
  public final Header a(String paramString)
  {
    if (d == null) {
      return null;
    }
    return d.getFirstHeader(paramString);
  }
  
  public final boolean a()
  {
    return b == 403;
  }
  
  public final boolean b()
  {
    return b == 401;
  }
  
  public final boolean c()
  {
    return (b == 302) || (b == 301);
  }
  
  /* Error */
  public final InputStream d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 73	bns:f	Ljava/io/InputStream;
    //   4: ifnonnull +10 -> 14
    //   7: aload_0
    //   8: getfield 54	bns:g	Z
    //   11: ifeq +13 -> 24
    //   14: new 69	java/lang/IllegalStateException
    //   17: dup
    //   18: ldc 75
    //   20: invokespecial 78	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: aload_0
    //   25: getfield 25	bns:e	Lorg/apache/http/HttpEntity;
    //   28: ifnonnull +13 -> 41
    //   31: new 69	java/lang/IllegalStateException
    //   34: dup
    //   35: ldc 80
    //   37: invokespecial 78	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    //   41: aload_0
    //   42: getfield 25	bns:e	Lorg/apache/http/HttpEntity;
    //   45: invokeinterface 83 1 0
    //   50: astore_1
    //   51: aload_0
    //   52: getfield 23	bns:d	Lorg/apache/http/HttpResponse;
    //   55: ldc 85
    //   57: invokeinterface 65 2 0
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +58 -> 122
    //   67: aload_2
    //   68: invokeinterface 91 1 0
    //   73: invokevirtual 96	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   76: ldc 98
    //   78: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +41 -> 122
    //   84: new 104	java/util/zip/GZIPInputStream
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 107	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore_2
    //   93: aload_2
    //   94: astore_1
    //   95: aload_0
    //   96: aload_1
    //   97: putfield 73	bns:f	Ljava/io/InputStream;
    //   100: aload_1
    //   101: areturn
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_1
    //   105: goto -10 -> 95
    //   108: astore_2
    //   109: goto -14 -> 95
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_1
    //   115: goto -20 -> 95
    //   118: astore_2
    //   119: goto -24 -> 95
    //   122: goto -27 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	bns
    //   50	51	1	localObject1	Object
    //   102	1	1	localIllegalStateException1	IllegalStateException
    //   104	1	1	localObject2	Object
    //   112	1	1	localIOException1	IOException
    //   114	1	1	localObject3	Object
    //   62	32	2	localObject4	Object
    //   108	1	2	localIllegalStateException2	IllegalStateException
    //   118	1	2	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   41	51	102	java/lang/IllegalStateException
    //   51	63	108	java/lang/IllegalStateException
    //   67	93	108	java/lang/IllegalStateException
    //   41	51	112	java/io/IOException
    //   51	63	118	java/io/IOException
    //   67	93	118	java/io/IOException
  }
  
  public final boolean e()
  {
    return a == 0;
  }
  
  public final void f()
  {
    if ((g) || (e != null)) {}
    try
    {
      e.consumeContent();
      if ((f instanceof GZIPInputStream)) {}
      try
      {
        f.close();
        g = true;
        return;
      }
      catch (IOException localIOException1)
      {
        for (;;) {}
      }
    }
    catch (IOException localIOException2)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     bns
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */