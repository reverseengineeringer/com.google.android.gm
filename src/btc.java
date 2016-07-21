import android.os.Build;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.protocol.HttpContext;

public final class btc
  implements HttpRequestInterceptor
{
  private static String a(HttpUriRequest paramHttpUriRequest, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("curl ");
    Object localObject = paramHttpUriRequest.getAllHeaders();
    int j = localObject.length;
    int i = 0;
    HttpRequest localHttpRequest;
    if (i < j)
    {
      localHttpRequest = localObject[i];
      localStringBuilder.append("--header \"");
      if ((!paramBoolean) && ((localHttpRequest.getName().equals("Authorization")) || (localHttpRequest.getName().equals("Cookie")))) {
        localStringBuilder.append(localHttpRequest.getName()).append(": ${token}");
      }
      for (;;)
      {
        localStringBuilder.append("\" ");
        i += 1;
        break;
        localStringBuilder.append(localHttpRequest.toString().trim());
      }
    }
    localObject = paramHttpUriRequest.getURI();
    if ((paramHttpUriRequest instanceof RequestWrapper))
    {
      localHttpRequest = ((RequestWrapper)paramHttpUriRequest).getOriginal();
      if ((localHttpRequest instanceof HttpUriRequest)) {
        localObject = ((HttpUriRequest)localHttpRequest).getURI();
      }
    }
    for (;;)
    {
      localStringBuilder.append("\"");
      localStringBuilder.append(localObject);
      localStringBuilder.append("\"");
      if ((paramHttpUriRequest instanceof HttpEntityEnclosingRequest))
      {
        paramHttpUriRequest = ((HttpEntityEnclosingRequest)paramHttpUriRequest).getEntity();
        if ((paramHttpUriRequest != null) && (paramHttpUriRequest.isRepeatable()))
        {
          if (paramHttpUriRequest.getContentLength() >= 1024L) {
            break label327;
          }
          localObject = new ByteArrayOutputStream();
          paramHttpUriRequest.writeTo((OutputStream)localObject);
          paramHttpUriRequest = Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 2);
          localStringBuilder.insert(0, String.valueOf(paramHttpUriRequest).length() + 35 + "echo '" + paramHttpUriRequest + "' | base64 -d > /tmp/$$.bin; ");
          localStringBuilder.append(" --data-binary @/tmp/$$.bin");
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        label327:
        localStringBuilder.append(" [TOO MUCH DATA TO INCLUDE]");
      }
    }
  }
  
  public final void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (((paramHttpRequest instanceof HttpUriRequest)) && (Log.isLoggable("Exchange", 2)))
    {
      if ((Build.TYPE.equals("userdebug")) || (Build.TYPE.equals("eng"))) {
        a((HttpUriRequest)paramHttpRequest, true);
      }
    }
    else {
      return;
    }
    a((HttpUriRequest)paramHttpRequest, false);
  }
}

/* Location:
 * Qualified Name:     btc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */