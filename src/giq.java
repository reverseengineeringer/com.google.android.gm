import android.net.Uri;
import java.util.regex.Matcher;

class giq
  extends gis
{
  private final String b;
  
  giq(String paramString1, String paramString2)
  {
    super(paramString1);
    b = ((String)hbe.a(paramString2));
  }
  
  final boolean a(Matcher paramMatcher, Uri paramUri)
  {
    return (super.a(paramMatcher, paramUri)) && (paramUri.getQueryParameter(b) != null);
  }
  
  String b(Matcher paramMatcher, Uri paramUri)
  {
    return paramUri.getQueryParameter(b);
  }
}

/* Location:
 * Qualified Name:     giq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */