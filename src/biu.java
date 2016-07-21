import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class biu
{
  private static final Pattern a = Pattern.compile("(\\+[0-9]+[\\- \\.]*)?(1?[ ]*\\([0-9]+\\)[\\- \\.]*)?([0-9][0-9\\- \\.][0-9\\- \\.]+[0-9])");
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return a.matcher(paramString).matches();
  }
}

/* Location:
 * Qualified Name:     biu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */