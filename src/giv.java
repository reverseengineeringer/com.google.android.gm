import android.net.Uri;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class giv
  extends gis
{
  private final Pattern b = Pattern.compile("(?i)id|docid");
  
  giv(String paramString)
  {
    super(paramString);
  }
  
  private final String a(Uri paramUri)
  {
    paramUri = paramUri.getQueryParameterNames().iterator();
    while (paramUri.hasNext())
    {
      String str = (String)paramUri.next();
      if (b.matcher(str).matches()) {
        return str;
      }
    }
    return null;
  }
  
  public final boolean a(Matcher paramMatcher, Uri paramUri)
  {
    return (super.a(paramMatcher, paramUri)) && (a(paramUri) != null);
  }
  
  protected final String b(Matcher paramMatcher, Uri paramUri)
  {
    return paramUri.getQueryParameter(a(paramUri));
  }
}

/* Location:
 * Qualified Name:     giv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */