import android.net.Uri;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gim
{
  static final Pattern a = Pattern.compile("^((/(corp|prod|scary))?/drive)(/.*)");
  static final Pattern b = Pattern.compile("^(/a/([a-zA-Z0-9.-]+))(/.*)");
  private static final Pattern c = Pattern.compile("(?:docs[0-9]*|drive)\\.google\\.com");
  private static final Pattern d = Pattern.compile("drive\\.google\\.com");
  private static final Pattern e = Pattern.compile("spreadsheets[0-9]*\\.google\\.com");
  private static final Pattern f = Pattern.compile(".*\\.google(\\.co(m?))?(\\.\\w{2})?");
  
  public static String a(Uri paramUri)
  {
    gil.a("DasherUriHelper", "in getPathSuffixWithoutDomainInstanceIdentifier for uri=%s", new Object[] { paramUri });
    Object localObject2 = paramUri.getPath();
    if (localObject2 == null)
    {
      gil.a("DasherUriHelper", "no path found", new Object[0]);
      return null;
    }
    Object localObject1 = paramUri.getPath();
    gin[] arrayOfgin = gin.values();
    int j = arrayOfgin.length;
    int i = 0;
    gin localgin;
    Matcher localMatcher;
    if (i < j)
    {
      localgin = arrayOfgin[i];
      localMatcher = c.matcher((CharSequence)localObject1);
      if (!localMatcher.find()) {}
    }
    for (localObject1 = new hbd(localgin, localMatcher);; localObject1 = null)
    {
      if (localObject1 == null) {
        break label167;
      }
      localObject2 = (gin)a;
      localObject1 = ((Matcher)b).group(e);
      gil.a("DasherUriHelper", "Found through %s Non Dasher path [%s] for uri=%s", new Object[] { localObject2, localObject1, paramUri });
      return (String)localObject1;
      i += 1;
      break;
    }
    label167:
    return (String)localObject2;
  }
  
  public static boolean b(Uri paramUri)
  {
    gil.a("DasherUriHelper", "isHostGoogleDocsOrDrive uri=%s", new Object[] { paramUri });
    Pattern localPattern = c;
    String str = paramUri.getHost();
    if (paramUri.getHost() == null) {
      return false;
    }
    boolean bool = localPattern.matcher(str).matches();
    gil.a("DasherUriHelper", "isHostMatched returns %b for hostUri=%s", new Object[] { Boolean.valueOf(bool), str });
    return bool;
  }
  
  public static boolean c(Uri paramUri)
  {
    if (paramUri.getHost() == null) {
      return false;
    }
    return e.matcher(paramUri.getHost()).matches();
  }
}

/* Location:
 * Qualified Name:     gim
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */