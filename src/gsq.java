import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class gsq
  extends gsa
{
  private static final String[] b;
  private final gsl c = new gsm();
  private final SSLSocketFactory d = null;
  private final HostnameVerifier e = null;
  
  static
  {
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "DELETE";
    arrayOfString[1] = "GET";
    arrayOfString[2] = "HEAD";
    arrayOfString[3] = "OPTIONS";
    arrayOfString[4] = "POST";
    arrayOfString[5] = "PUT";
    arrayOfString[6] = "TRACE";
    b = arrayOfString;
    Arrays.sort(arrayOfString);
  }
  
  public gsq()
  {
    this((byte)0);
  }
  
  private gsq(byte paramByte) {}
  
  public final boolean a(String paramString)
  {
    return Arrays.binarySearch(b, paramString) >= 0;
  }
}

/* Location:
 * Qualified Name:     gsq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */