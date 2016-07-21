import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class dat
{
  static String a(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError("URL encoding failed for: " + paramString);
    }
  }
}

/* Location:
 * Qualified Name:     dat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */