package com.google.android.common.http;

import android.content.ContentResolver;
import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class GoogleHttpClient
  implements HttpClient
{
  private final String mAppName;
  private final AndroidHttpClient mClient;
  private final ThreadLocal<Boolean> mConnectionAllocated = new ThreadLocal();
  private final ContentResolver mResolver;
  private final String mUserAgent;
  
  public GoogleHttpClient(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str = paramString + " (" + Build.DEVICE + " " + Build.ID + ")";
    Object localObject = str;
    if (paramBoolean) {
      localObject = str + "; gzip";
    }
    mClient = AndroidHttpClient.newInstance((String)localObject, paramContext);
    mResolver = paramContext.getContentResolver();
    mAppName = paramString;
    mUserAgent = ((String)localObject);
    paramString = getConnectionManager().getSchemeRegistry();
    localObject = paramString.getSchemeNames().iterator();
    if (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      Scheme localScheme = paramString.unregister(str);
      paramContext = localScheme.getSocketFactory();
      if ((paramContext instanceof LayeredSocketFactory)) {}
      for (paramContext = new WrappedLayeredSocketFactory((LayeredSocketFactory)paramContext, null);; paramContext = new WrappedSocketFactory(paramContext, null))
      {
        paramString.register(new Scheme(str, paramContext, localScheme.getDefaultPort()));
        break;
      }
    }
  }
  
  /* Error */
  private static RequestWrapper wrapRequest(HttpUriRequest paramHttpUriRequest)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 158
    //   4: ifeq +21 -> 25
    //   7: new 160	org/apache/http/impl/client/EntityEnclosingRequestWrapper
    //   10: dup
    //   11: aload_0
    //   12: checkcast 158	org/apache/http/HttpEntityEnclosingRequest
    //   15: invokespecial 163	org/apache/http/impl/client/EntityEnclosingRequestWrapper:<init>	(Lorg/apache/http/HttpEntityEnclosingRequest;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 168	org/apache/http/impl/client/RequestWrapper:resetHeaders	()V
    //   23: aload_0
    //   24: areturn
    //   25: new 165	org/apache/http/impl/client/RequestWrapper
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 171	org/apache/http/impl/client/RequestWrapper:<init>	(Lorg/apache/http/HttpRequest;)V
    //   33: astore_0
    //   34: goto -15 -> 19
    //   37: astore_0
    //   38: new 173	org/apache/http/client/ClientProtocolException
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 176	org/apache/http/client/ClientProtocolException:<init>	(Ljava/lang/Throwable;)V
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	paramHttpUriRequest	HttpUriRequest
    // Exception table:
    //   from	to	target	type
    //   0	19	37	org/apache/http/ProtocolException
    //   19	23	37	org/apache/http/ProtocolException
    //   25	34	37	org/apache/http/ProtocolException
  }
  
  public void close()
  {
    mClient.close();
  }
  
  public void enableCurlLogging(String paramString, int paramInt)
  {
    mClient.enableCurlLogging(paramString, paramInt);
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
    throws IOException, ClientProtocolException
  {
    return (T)mClient.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
    throws IOException, ClientProtocolException
  {
    return (T)mClient.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
    throws IOException, ClientProtocolException
  {
    return (T)mClient.execute(paramHttpUriRequest, paramResponseHandler);
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
    throws IOException, ClientProtocolException
  {
    return (T)mClient.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
    throws IOException
  {
    return mClient.execute(paramHttpHost, paramHttpRequest);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws IOException
  {
    return mClient.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
  }
  
  public HttpResponse execute(HttpUriRequest paramHttpUriRequest)
    throws IOException
  {
    return execute(paramHttpUriRequest, (HttpContext)null);
  }
  
  public HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
    throws IOException
  {
    Object localObject = paramHttpUriRequest.getURI().toString();
    UrlRules.Rule localRule = UrlRules.getRules(mResolver).matchRule((String)localObject);
    String str = localRule.apply((String)localObject);
    if (str == null)
    {
      Log.w("GoogleHttpClient", "Blocked by " + mName + ": " + (String)localObject);
      throw new BlockedRequestException(localRule);
    }
    if (str == localObject) {
      return executeWithoutRewriting(paramHttpUriRequest, paramHttpContext);
    }
    try
    {
      localObject = new URI(str);
      paramHttpUriRequest = wrapRequest(paramHttpUriRequest);
      paramHttpUriRequest.setURI((URI)localObject);
      return executeWithoutRewriting(paramHttpUriRequest, paramHttpContext);
    }
    catch (URISyntaxException paramHttpUriRequest)
    {
      throw new RuntimeException("Bad URL from rule: " + mName, paramHttpUriRequest);
    }
  }
  
  /* Error */
  public HttpResponse executeWithoutRewriting(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 286	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: getfield 37	com/google/android/common/http/GoogleHttpClient:mConnectionAllocated	Ljava/lang/ThreadLocal;
    //   9: aconst_null
    //   10: invokevirtual 290	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   13: aload_0
    //   14: getfield 80	com/google/android/common/http/GoogleHttpClient:mResolver	Landroid/content/ContentResolver;
    //   17: ldc_w 292
    //   20: iconst_0
    //   21: invokestatic 298	com/google/android/gsf/Gservices:getBoolean	(Landroid/content/ContentResolver;Ljava/lang/String;Z)Z
    //   24: ifeq +175 -> 199
    //   27: invokestatic 303	android/os/Process:myUid	()I
    //   30: istore_3
    //   31: iload_3
    //   32: invokestatic 309	android/net/TrafficStats:getUidTxBytes	(I)J
    //   35: lstore 7
    //   37: iload_3
    //   38: invokestatic 312	android/net/TrafficStats:getUidRxBytes	(I)J
    //   41: lstore 9
    //   43: aload_0
    //   44: getfield 72	com/google/android/common/http/GoogleHttpClient:mClient	Landroid/net/http/AndroidHttpClient;
    //   47: aload_1
    //   48: aload_2
    //   49: invokevirtual 313	android/net/http/AndroidHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   52: astore 13
    //   54: aload 13
    //   56: ifnonnull +132 -> 188
    //   59: aconst_null
    //   60: astore_2
    //   61: aload 13
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +42 -> 107
    //   68: invokestatic 286	android/os/SystemClock:elapsedRealtime	()J
    //   71: lstore 11
    //   73: aload 13
    //   75: new 315	com/google/android/common/http/NetworkStatsEntity
    //   78: dup
    //   79: aload_2
    //   80: aload_0
    //   81: getfield 82	com/google/android/common/http/GoogleHttpClient:mAppName	Ljava/lang/String;
    //   84: iload_3
    //   85: lload 7
    //   87: lload 9
    //   89: lload 11
    //   91: lload 5
    //   93: lsub
    //   94: lload 11
    //   96: invokespecial 318	com/google/android/common/http/NetworkStatsEntity:<init>	(Lorg/apache/http/HttpEntity;Ljava/lang/String;IJJJJ)V
    //   99: invokeinterface 324 2 0
    //   104: aload 13
    //   106: astore_1
    //   107: aload_1
    //   108: invokeinterface 328 1 0
    //   113: invokeinterface 333 1 0
    //   118: istore 4
    //   120: invokestatic 286	android/os/SystemClock:elapsedRealtime	()J
    //   123: lstore 7
    //   125: aload_0
    //   126: getfield 37	com/google/android/common/http/GoogleHttpClient:mConnectionAllocated	Ljava/lang/ThreadLocal;
    //   129: invokevirtual 336	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   132: ifnonnull +80 -> 212
    //   135: iload 4
    //   137: iflt +75 -> 212
    //   140: iconst_1
    //   141: istore_3
    //   142: ldc_w 337
    //   145: iconst_4
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: lload 7
    //   153: lload 5
    //   155: lsub
    //   156: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: iload 4
    //   164: invokestatic 348	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: aastore
    //   168: dup
    //   169: iconst_2
    //   170: aload_0
    //   171: getfield 82	com/google/android/common/http/GoogleHttpClient:mAppName	Ljava/lang/String;
    //   174: aastore
    //   175: dup
    //   176: iconst_3
    //   177: iload_3
    //   178: invokestatic 348	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: aastore
    //   182: invokestatic 354	android/util/EventLog:writeEvent	(I[Ljava/lang/Object;)I
    //   185: pop
    //   186: aload_1
    //   187: areturn
    //   188: aload 13
    //   190: invokeinterface 358 1 0
    //   195: astore_2
    //   196: goto -135 -> 61
    //   199: aload_0
    //   200: getfield 72	com/google/android/common/http/GoogleHttpClient:mClient	Landroid/net/http/AndroidHttpClient;
    //   203: aload_1
    //   204: aload_2
    //   205: invokevirtual 313	android/net/http/AndroidHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   208: astore_1
    //   209: goto -102 -> 107
    //   212: iconst_0
    //   213: istore_3
    //   214: goto -72 -> 142
    //   217: astore_2
    //   218: ldc -13
    //   220: ldc_w 360
    //   223: aload_2
    //   224: invokestatic 364	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   227: pop
    //   228: aload_1
    //   229: areturn
    //   230: astore_1
    //   231: invokestatic 286	android/os/SystemClock:elapsedRealtime	()J
    //   234: lstore 7
    //   236: aload_0
    //   237: getfield 37	com/google/android/common/http/GoogleHttpClient:mConnectionAllocated	Ljava/lang/ThreadLocal;
    //   240: invokevirtual 336	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   243: ifnonnull +54 -> 297
    //   246: iconst_m1
    //   247: iflt +50 -> 297
    //   250: iconst_1
    //   251: istore_3
    //   252: ldc_w 337
    //   255: iconst_4
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: lload 7
    //   263: lload 5
    //   265: lsub
    //   266: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: aastore
    //   270: dup
    //   271: iconst_1
    //   272: iconst_m1
    //   273: invokestatic 348	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: dup
    //   278: iconst_2
    //   279: aload_0
    //   280: getfield 82	com/google/android/common/http/GoogleHttpClient:mAppName	Ljava/lang/String;
    //   283: aastore
    //   284: dup
    //   285: iconst_3
    //   286: iload_3
    //   287: invokestatic 348	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: aastore
    //   291: invokestatic 354	android/util/EventLog:writeEvent	(I[Ljava/lang/Object;)I
    //   294: pop
    //   295: aload_1
    //   296: athrow
    //   297: iconst_0
    //   298: istore_3
    //   299: goto -47 -> 252
    //   302: astore_2
    //   303: ldc -13
    //   305: ldc_w 360
    //   308: aload_2
    //   309: invokestatic 364	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   312: pop
    //   313: goto -18 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	GoogleHttpClient
    //   0	316	1	paramHttpUriRequest	HttpUriRequest
    //   0	316	2	paramHttpContext	HttpContext
    //   30	269	3	i	int
    //   118	45	4	j	int
    //   3	261	5	l1	long
    //   35	227	7	l2	long
    //   41	47	9	l3	long
    //   71	24	11	l4	long
    //   52	137	13	localHttpResponse	HttpResponse
    // Exception table:
    //   from	to	target	type
    //   120	135	217	java/lang/Exception
    //   142	186	217	java/lang/Exception
    //   5	54	230	finally
    //   68	104	230	finally
    //   107	120	230	finally
    //   188	196	230	finally
    //   199	209	230	finally
    //   231	246	302	java/lang/Exception
    //   252	295	302	java/lang/Exception
  }
  
  public ClientConnectionManager getConnectionManager()
  {
    return mClient.getConnectionManager();
  }
  
  public HttpParams getParams()
  {
    return mClient.getParams();
  }
  
  public static class BlockedRequestException
    extends IOException
  {
    private final UrlRules.Rule mRule;
    
    BlockedRequestException(UrlRules.Rule paramRule)
    {
      super();
      mRule = paramRule;
    }
  }
  
  private class WrappedLayeredSocketFactory
    extends GoogleHttpClient.WrappedSocketFactory
    implements LayeredSocketFactory
  {
    private LayeredSocketFactory mDelegate;
    
    private WrappedLayeredSocketFactory(LayeredSocketFactory paramLayeredSocketFactory)
    {
      super(paramLayeredSocketFactory, null);
      mDelegate = paramLayeredSocketFactory;
    }
    
    public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
      throws IOException
    {
      return mDelegate.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    }
  }
  
  private class WrappedSocketFactory
    implements SocketFactory
  {
    private SocketFactory mDelegate;
    
    private WrappedSocketFactory(SocketFactory paramSocketFactory)
    {
      mDelegate = paramSocketFactory;
    }
    
    public final Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
      throws IOException
    {
      mConnectionAllocated.set(Boolean.TRUE);
      return mDelegate.connectSocket(paramSocket, paramString, paramInt1, paramInetAddress, paramInt2, paramHttpParams);
    }
    
    public final Socket createSocket()
      throws IOException
    {
      return mDelegate.createSocket();
    }
    
    public final boolean isSecure(Socket paramSocket)
    {
      return mDelegate.isSecure(paramSocket);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.GoogleHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */