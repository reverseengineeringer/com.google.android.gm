import android.net.Uri;
import java.util.regex.Matcher;

final class gix
  extends giq
{
  gix(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  protected final String b(Matcher paramMatcher, Uri paramUri)
  {
    if ("explorer".equals(paramUri.getQueryParameter("pid"))) {
      return super.b(paramMatcher, paramUri);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     gix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */