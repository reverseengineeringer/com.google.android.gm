import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class git<T>
{
  private static final Pattern a = Pattern.compile("/u/\\d+/");
  
  public static List<gis> a(Uri paramUri)
  {
    if (gim.b(paramUri)) {
      return giu.E;
    }
    if (gim.c(paramUri)) {
      return giu.D;
    }
    return Collections.emptyList();
  }
  
  public static String b(Uri paramUri)
  {
    String str = gim.a(paramUri);
    paramUri = str;
    if (str != null)
    {
      Matcher localMatcher = a.matcher(str);
      paramUri = str;
      if (localMatcher.find()) {
        paramUri = localMatcher.replaceFirst("/");
      }
    }
    return paramUri;
  }
  
  public abstract T a(String paramString);
}

/* Location:
 * Qualified Name:     git
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */