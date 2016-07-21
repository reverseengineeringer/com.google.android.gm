import android.net.Uri;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class giw
  extends gio
{
  giw(String paramString)
  {
    super(paramString, 4);
  }
  
  public final Matcher a(Uri paramUri, String paramString)
  {
    if ((paramString.equals("/")) && (paramUri.getFragment() != null)) {
      return a.matcher(paramUri.getFragment());
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     giw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */