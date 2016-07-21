import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

final class dbk
  implements czm
{
  private final String a;
  private final dau b;
  private final Context c;
  
  dbk(dau paramdau, Context paramContext)
  {
    this(paramdau, paramContext, (byte)0);
  }
  
  private dbk(dau paramdau, Context paramContext, byte paramByte)
  {
    c = paramContext.getApplicationContext();
    a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { "GoogleAnalytics", "2.0", Build.VERSION.RELEASE, dbp.a(Locale.getDefault()), Build.MODEL, Build.ID });
    b = paramdau;
  }
  
  private static URL a(das paramdas)
  {
    if (TextUtils.isEmpty(d)) {
      return null;
    }
    try
    {
      paramdas = new URL(d);
      return paramdas;
    }
    catch (MalformedURLException paramdas)
    {
      try
      {
        paramdas = new URL("http://www.google-analytics.com/collect");
        return paramdas;
      }
      catch (MalformedURLException paramdas) {}
    }
    return null;
  }
  
  private final HttpEntityEnclosingRequest a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      dav.f("Empty hit, discarding.");
      return null;
    }
    String str = paramString2 + "?" + paramString1;
    if (str.length() < 2036) {
      paramString1 = new BasicHttpEntityEnclosingRequest("GET", str);
    }
    for (;;)
    {
      paramString1.addHeader("User-Agent", a);
      return paramString1;
      paramString2 = new BasicHttpEntityEnclosingRequest("POST", paramString2);
      try
      {
        paramString2.setEntity(new StringEntity(paramString1));
        paramString1 = paramString2;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        dav.f("Encoding error, discarding hit");
      }
    }
    return null;
  }
  
  private static void a(boolean paramBoolean, HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    StringBuffer localStringBuffer;
    Object localObject;
    int i;
    if (paramBoolean)
    {
      localStringBuffer = new StringBuffer();
      localObject = paramHttpEntityEnclosingRequest.getAllHeaders();
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        localStringBuffer.append(localObject[i].toString()).append("\n");
        i += 1;
      }
      localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
      if (paramHttpEntityEnclosingRequest.getEntity() == null) {}
    }
    try
    {
      paramHttpEntityEnclosingRequest = paramHttpEntityEnclosingRequest.getEntity().getContent();
      if (paramHttpEntityEnclosingRequest != null)
      {
        i = paramHttpEntityEnclosingRequest.available();
        if (i > 0)
        {
          localObject = new byte[i];
          paramHttpEntityEnclosingRequest.read((byte[])localObject);
          localStringBuffer.append("POST:\n");
          localStringBuffer.append(new String((byte[])localObject)).append("\n");
        }
      }
    }
    catch (IOException paramHttpEntityEnclosingRequest)
    {
      for (;;)
      {
        dav.f("Error Writing hit to log...");
      }
    }
    dav.c(localStringBuffer.toString());
  }
  
  public final int a(List<das> paramList)
  {
    int k = Math.min(paramList.size(), 40);
    int j = 0;
    int i = 0;
    if (j < k)
    {
      HttpClient localHttpClient = b.a();
      Object localObject1 = (das)paramList.get(j);
      Object localObject2 = a((das)localObject1);
      if (localObject2 == null)
      {
        if (dav.a) {
          dav.f("No destination: discarding hit: " + a);
        }
        for (;;)
        {
          i += 1;
          j += 1;
          break;
          dav.f("No destination: discarding hit.");
        }
      }
      HttpHost localHttpHost = new HttpHost(((URL)localObject2).getHost(), ((URL)localObject2).getPort(), ((URL)localObject2).getProtocol());
      localObject2 = ((URL)localObject2).getPath();
      if (TextUtils.isEmpty(a)) {}
      StringBuilder localStringBuilder;
      for (localObject1 = "";; localObject1 = localStringBuilder.toString())
      {
        localObject2 = a((String)localObject1, (String)localObject2);
        if (localObject2 != null) {
          break label293;
        }
        i += 1;
        break;
        long l = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(a);
        if (c > 0L)
        {
          l -= c;
          if (l >= 0L) {
            localStringBuilder.append("&").append("qt").append("=").append(l);
          }
        }
        localStringBuilder.append("&").append("z").append("=").append(b);
      }
      label293:
      ((HttpEntityEnclosingRequest)localObject2).addHeader("Host", localHttpHost.toHostString());
      a(dav.a, (HttpEntityEnclosingRequest)localObject2);
      if (((String)localObject1).length() > 8192) {
        dav.f("Hit too long (> 8192 bytes)--not sent");
      }
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localObject1 = localHttpClient.execute(localHttpHost, (HttpRequest)localObject2);
          if (((HttpResponse)localObject1).getStatusLine().getStatusCode() != 200)
          {
            dav.f("Bad response: " + ((HttpResponse)localObject1).getStatusLine().getStatusCode());
            return i;
          }
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          dav.f("ClientProtocolException sending hit; discarding hit...");
        }
        catch (IOException paramList)
        {
          dav.f("Exception sending hit: " + paramList.getClass().getSimpleName());
          dav.f(paramList.getMessage());
          return i;
        }
      }
    }
    return i;
  }
  
  public final boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)c.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      dav.e("...no network connectivity");
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     dbk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */