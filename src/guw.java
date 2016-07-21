import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class guw
{
  public static final gux a = new guy("-_.*", true);
  public static final gux b = new guy("-_.!~*'()@:$&,;=", false);
  public static final gux c = new guy("-_.!~*'()@:$&,;=+/?", false);
  public static final gux d = new guy("-_.!~*'():$&,;=", false);
  public static final gux e = new guy("-_.!~*'()@:$,;/?:", false);
  
  public static String a(String paramString)
  {
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     guw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */