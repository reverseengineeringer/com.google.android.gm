import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public final class dkr
  extends Exception
{
  public final int a;
  public final String b;
  
  public dkr(HttpResponse paramHttpResponse)
  {
    a = paramHttpResponse.getStatusLine().getStatusCode();
    paramHttpResponse = paramHttpResponse.getFirstHeader("X-Google-Backends");
    if (paramHttpResponse == null) {}
    for (paramHttpResponse = null;; paramHttpResponse = paramHttpResponse.getValue())
    {
      b = paramHttpResponse;
      return;
    }
  }
  
  public final String getMessage()
  {
    int i = a;
    String str;
    if (b == null) {
      str = "";
    }
    for (;;)
    {
      return String.valueOf(str).length() + 24 + "Status code: " + i + str;
      str = String.valueOf(b);
      if (str.length() != 0) {
        str = " with backend: ".concat(str);
      } else {
        str = new String(" with backend: ");
      }
    }
  }
}

/* Location:
 * Qualified Name:     dkr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */