import android.net.Uri;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class gio
  extends gis
{
  private final int b;
  
  gio(String paramString, int paramInt)
  {
    this(Pattern.compile(paramString), paramInt);
  }
  
  private gio(Pattern paramPattern, int paramInt)
  {
    super(paramPattern);
    b = paramInt;
  }
  
  final boolean a(Matcher paramMatcher, Uri paramUri)
  {
    return (super.a(paramMatcher, paramUri)) && (paramMatcher.groupCount() >= b);
  }
  
  final String b(Matcher paramMatcher, Uri paramUri)
  {
    return paramMatcher.group(b);
  }
  
  public String toString()
  {
    return String.format(Locale.US, "groupIndex=[%d] %s", new Object[] { Integer.valueOf(b), super.toString() });
  }
}

/* Location:
 * Qualified Name:     gio
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */