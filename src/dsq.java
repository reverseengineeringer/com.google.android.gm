import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

abstract interface dsq
{
  public abstract HttpResponse a(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext);
}

/* Location:
 * Qualified Name:     dsq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */