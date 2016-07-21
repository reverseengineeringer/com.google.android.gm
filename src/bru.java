import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;

final class bru
  extends DefaultHttpClient
{
  bru(brt parambrt, ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    super(paramClientConnectionManager, paramHttpParams);
  }
  
  protected final BasicHttpProcessor createHttpProcessor()
  {
    BasicHttpProcessor localBasicHttpProcessor = super.createHttpProcessor();
    localBasicHttpProcessor.addRequestInterceptor(new btc());
    localBasicHttpProcessor.addResponseInterceptor(new btm());
    return localBasicHttpProcessor;
  }
}

/* Location:
 * Qualified Name:     bru
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */