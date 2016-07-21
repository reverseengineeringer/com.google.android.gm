import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public final class cmw
  extends InputStream
{
  private static final String a = cvl.a;
  private final String b;
  private final String c;
  private URLConnection d;
  
  public cmw(String paramString1, String paramString2)
  {
    b = paramString1;
    c = paramString2;
  }
  
  /* Error */
  private final URLConnection a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	cmw:d	Ljava/net/URLConnection;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +72 -> 80
    //   11: aload_0
    //   12: new 33	java/net/URL
    //   15: dup
    //   16: aload_0
    //   17: getfield 24	cmw:b	Ljava/lang/String;
    //   20: invokespecial 36	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 39	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   26: putfield 31	cmw:d	Ljava/net/URLConnection;
    //   29: aload_0
    //   30: getfield 31	cmw:d	Ljava/net/URLConnection;
    //   33: ldc 41
    //   35: aload_0
    //   36: getfield 26	cmw:c	Ljava/lang/String;
    //   39: invokestatic 46	cwh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 51	java/net/URLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 31	cmw:d	Ljava/net/URLConnection;
    //   49: sipush 10000
    //   52: invokevirtual 55	java/net/URLConnection:setConnectTimeout	(I)V
    //   55: aload_0
    //   56: getfield 31	cmw:d	Ljava/net/URLConnection;
    //   59: sipush 10000
    //   62: invokevirtual 58	java/net/URLConnection:setReadTimeout	(I)V
    //   65: invokestatic 63	buo:a	()Lbut;
    //   68: ldc 65
    //   70: ldc 67
    //   72: ldc 69
    //   74: lconst_0
    //   75: invokeinterface 74 6 0
    //   80: aload_0
    //   81: getfield 31	cmw:d	Ljava/net/URLConnection;
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: areturn
    //   89: astore_1
    //   90: getstatic 17	cmw:a	Ljava/lang/String;
    //   93: aload_1
    //   94: ldc 76
    //   96: iconst_1
    //   97: anewarray 78	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_0
    //   103: getfield 24	cmw:b	Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 84	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   110: pop
    //   111: invokestatic 63	buo:a	()Lbut;
    //   114: ldc 65
    //   116: ldc 67
    //   118: ldc 86
    //   120: lconst_0
    //   121: invokeinterface 74 6 0
    //   126: goto -46 -> 80
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	cmw
    //   6	82	1	localURLConnection	URLConnection
    //   89	5	1	localSocketTimeoutException	java.net.SocketTimeoutException
    //   129	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	80	89	java/net/SocketTimeoutException
    //   2	7	129	finally
    //   11	80	129	finally
    //   80	85	129	finally
    //   90	126	129	finally
  }
  
  private final void a(IOException paramIOException, String paramString)
  {
    cvm.e(a, paramIOException, "Exception happened while processing %s", new Object[] { b });
    but localbut = buo.a();
    paramIOException = String.valueOf(paramString);
    if (paramIOException.length() != 0) {}
    for (paramIOException = "exception_".concat(paramIOException);; paramIOException = new String("exception_"))
    {
      localbut.a("gmail_auth", "url_connection", paramIOException, 0L);
      return;
    }
  }
  
  public final int available()
  {
    try
    {
      int i = a().getInputStream().available();
      return i;
    }
    catch (IOException localIOException)
    {
      a(localIOException, "available");
    }
    return 0;
  }
  
  public final void close()
  {
    try
    {
      super.close();
      a().getInputStream().close();
      if ((a() instanceof HttpsURLConnection)) {
        ((HttpsURLConnection)a()).disconnect();
      }
      buo.a().a("gmail_auth", "url_connection", "close", 0L);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        a(localIOException, "close");
      }
    }
    finally {}
  }
  
  public final int read()
  {
    try
    {
      int i = a().getInputStream().read();
      return i;
    }
    catch (IOException localIOException)
    {
      a(localIOException, "read");
    }
    return -1;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    try
    {
      int i = a().getInputStream().read(paramArrayOfByte);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte, "read_buffer");
    }
    return -1;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = a().getInputStream().read(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte, "read_buffer_limited");
    }
    return -1;
  }
  
  public final void reset()
  {
    try
    {
      a().getInputStream().reset();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException, "reset");
      throw localIOException;
    }
    finally {}
  }
  
  public final long skip(long paramLong)
  {
    try
    {
      paramLong = a().getInputStream().skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      a(localIOException, "skip");
      throw localIOException;
    }
  }
}

/* Location:
 * Qualified Name:     cmw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */