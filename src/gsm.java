import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public final class gsm
  implements gsl
{
  private final Proxy a = null;
  
  public gsm()
  {
    this((byte)0);
  }
  
  private gsm(byte paramByte) {}
  
  public final HttpURLConnection a(URL paramURL)
  {
    if (a == null) {}
    for (paramURL = paramURL.openConnection();; paramURL = paramURL.openConnection(a)) {
      return (HttpURLConnection)paramURL;
    }
  }
}

/* Location:
 * Qualified Name:     gsm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */