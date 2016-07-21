import android.content.ContentResolver;
import android.content.Context;
import android.net.TrafficStats;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.EventLog;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class ddj
  implements HttpClient
{
  public final AndroidHttpClient a;
  final ThreadLocal<Boolean> b = new ThreadLocal();
  private final ContentResolver c;
  private final String d;
  private final ddx e;
  
  public ddj(Context paramContext, ddx paramddx, String paramString, boolean paramBoolean)
  {
    String str = String.valueOf(Build.DEVICE);
    Object localObject = String.valueOf(Build.ID);
    a = AndroidHttpClient.newInstance(String.valueOf(String.valueOf(paramString).length() + 4 + String.valueOf(str).length() + String.valueOf(localObject).length() + paramString + " (" + str + " " + (String)localObject + ")").concat("; gzip"), paramContext);
    c = paramContext.getContentResolver();
    e = paramddx;
    d = paramString;
    paramddx = getConnectionManager().getSchemeRegistry();
    paramString = paramddx.getSchemeNames().iterator();
    if (paramString.hasNext())
    {
      str = (String)paramString.next();
      localObject = paramddx.unregister(str);
      paramContext = ((Scheme)localObject).getSocketFactory();
      if ((paramContext instanceof LayeredSocketFactory)) {}
      for (paramContext = new ddl(this, (LayeredSocketFactory)paramContext);; paramContext = new ddm(this, paramContext))
      {
        paramddx.register(new Scheme(str, paramContext, ((Scheme)localObject).getDefaultPort()));
        break;
      }
    }
  }
  
  private final HttpResponse a(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
  {
    l1 = SystemClock.elapsedRealtime();
    for (;;)
    {
      try
      {
        b.set(null);
        if (!ghz.a(c, "http_stats", false)) {
          continue;
        }
        i = Process.myUid();
        l2 = TrafficStats.getUidTxBytes(i);
        long l3 = TrafficStats.getUidRxBytes(i);
        paramHttpContext = a.execute(paramHttpUriRequest, paramHttpContext);
        if (paramHttpContext != null) {
          continue;
        }
        paramHttpUriRequest = null;
        if (paramHttpUriRequest == null) {
          continue;
        }
        long l4 = SystemClock.elapsedRealtime();
        paramHttpContext.setEntity(new ddo(paramHttpUriRequest, d, i, l2, l3, l4 - l1, l4));
      }
      finally
      {
        try
        {
          int i;
          int j;
          long l2 = SystemClock.elapsedRealtime();
          if (b.get() == null) {}
          EventLog.writeEvent(203002, new Object[] { Long.valueOf(l2 - l1), Integer.valueOf(-1), d, Integer.valueOf(0) });
        }
        catch (Exception paramHttpContext)
        {
          Log.e("GoogleHttpClient", "Error recording stats", paramHttpContext);
          continue;
        }
        throw paramHttpUriRequest;
        paramHttpUriRequest = paramHttpContext;
        continue;
      }
      j = paramHttpUriRequest.getStatusLine().getStatusCode();
      try
      {
        l2 = SystemClock.elapsedRealtime();
        if ((b.get() == null) && (j >= 0))
        {
          i = 1;
          EventLog.writeEvent(203002, new Object[] { Long.valueOf(l2 - l1), Integer.valueOf(j), d, Integer.valueOf(i) });
          return paramHttpUriRequest;
          paramHttpUriRequest = paramHttpContext.getEntity();
          continue;
          paramHttpUriRequest = a.execute(paramHttpUriRequest, paramHttpContext);
          continue;
        }
        i = 0;
        continue;
        paramHttpUriRequest = finally;
      }
      catch (Exception paramHttpContext)
      {
        Log.e("GoogleHttpClient", "Error recording stats", paramHttpContext);
        return paramHttpUriRequest;
      }
    }
  }
  
  /* Error */
  private static RequestWrapper a(HttpUriRequest paramHttpUriRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 250
    //   4: ifeq +21 -> 25
    //   7: new 252	org/apache/http/impl/client/EntityEnclosingRequestWrapper
    //   10: dup
    //   11: aload_0
    //   12: checkcast 250	org/apache/http/HttpEntityEnclosingRequest
    //   15: invokespecial 255	org/apache/http/impl/client/EntityEnclosingRequestWrapper:<init>	(Lorg/apache/http/HttpEntityEnclosingRequest;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 260	org/apache/http/impl/client/RequestWrapper:resetHeaders	()V
    //   23: aload_0
    //   24: areturn
    //   25: new 257	org/apache/http/impl/client/RequestWrapper
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 263	org/apache/http/impl/client/RequestWrapper:<init>	(Lorg/apache/http/HttpRequest;)V
    //   33: astore_0
    //   34: goto -15 -> 19
    //   37: astore_0
    //   38: new 265	org/apache/http/client/ClientProtocolException
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 268	org/apache/http/client/ClientProtocolException:<init>	(Ljava/lang/Throwable;)V
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
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    return (T)a.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    return (T)a.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    return (T)a.execute(paramHttpUriRequest, paramResponseHandler);
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    return (T)a.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    return a.execute(paramHttpHost, paramHttpRequest);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    return a.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
  }
  
  public HttpResponse execute(HttpUriRequest paramHttpUriRequest)
  {
    return execute(paramHttpUriRequest, null);
  }
  
  public HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
  {
    String str1 = paramHttpUriRequest.getURI().toString();
    ddt localddt = e.a(c).a(str1);
    String str2 = localddt.apply(str1);
    if (str2 == null)
    {
      Log.w("GoogleHttpClient", String.format("Blocked by %s: %s", new Object[] { b, str1 }));
      throw new ddk(localddt);
    }
    if (str2.equals(str1)) {
      return a(paramHttpUriRequest, paramHttpContext);
    }
    try
    {
      URI localURI = new URI(str2);
      paramHttpUriRequest = a(paramHttpUriRequest);
      paramHttpUriRequest.setURI(localURI);
      if (Log.isLoggable("GoogleHttpClient", 2)) {
        String.format("Rule %s: %s -> %s", new Object[] { b, str1, str2 });
      }
      return a(paramHttpUriRequest, paramHttpContext);
    }
    catch (URISyntaxException paramHttpContext)
    {
      paramHttpUriRequest = String.valueOf(b);
      if (paramHttpUriRequest.length() == 0) {}
    }
    for (paramHttpUriRequest = "Bad URL from rule: ".concat(paramHttpUriRequest);; paramHttpUriRequest = new String("Bad URL from rule: ")) {
      throw new RuntimeException(paramHttpUriRequest, paramHttpContext);
    }
  }
  
  public ClientConnectionManager getConnectionManager()
  {
    return a.getConnectionManager();
  }
  
  public HttpParams getParams()
  {
    return a.getParams();
  }
}

/* Location:
 * Qualified Name:     ddj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */