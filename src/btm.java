import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.protocol.HttpContext;

public final class btm
  implements HttpResponseInterceptor
{
  private static byte[] a(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public final void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (Log.isLoggable("Exchange", 3))
    {
      paramHttpResponse.setEntity(new BufferedHttpEntity(paramHttpResponse.getEntity()));
      paramHttpContext = paramHttpResponse.getEntity();
      if (paramHttpContext.getContentLength() >= 1024L) {
        break label67;
      }
    }
    label67:
    for (int i = 1; i == 0; i = 0)
    {
      cvm.a("Exchange", "wbxml response: [TOO MUCH DATA TO INCLUDE]", new Object[0]);
      return;
    }
    paramHttpContext = paramHttpContext.getContentEncoding();
    if (paramHttpContext != null)
    {
      paramHttpContext = paramHttpContext.getValue();
      if (paramHttpContext != null) {
        if (!paramHttpContext.equals("gzip")) {
          break label152;
        }
      }
    }
    label152:
    for (paramHttpResponse = new GZIPInputStream(paramHttpResponse.getEntity().getContent());; paramHttpResponse = paramHttpResponse.getEntity().getContent())
    {
      cvm.a("Exchange", "wbxml response: echo '%s' | base64 -d | wbxml", new Object[] { Base64.encodeToString(a(paramHttpResponse), 2) });
      return;
      paramHttpContext = "UTF-8";
      break;
    }
  }
}

/* Location:
 * Qualified Name:     btm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */