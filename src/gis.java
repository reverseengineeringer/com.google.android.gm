import android.net.Uri;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class gis
{
  public final Pattern a;
  
  gis(String paramString)
  {
    this(Pattern.compile(paramString));
  }
  
  gis(Pattern paramPattern)
  {
    a = ((Pattern)hbe.a(paramPattern));
  }
  
  public Matcher a(Uri paramUri, String paramString)
  {
    return a.matcher(paramString);
  }
  
  public boolean a(Matcher paramMatcher, Uri paramUri)
  {
    return (paramMatcher != null) && (paramMatcher.matches());
  }
  
  public abstract String b(Matcher paramMatcher, Uri paramUri);
  
  public String toString()
  {
    return String.format(Locale.US, "pattern=[%s]", new Object[] { a });
  }
}

/* Location:
 * Qualified Name:     gis
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */