import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ieu
{
  private static final Pattern a = Pattern.compile("^([\\x21-\\x39\\x3b-\\x7e]+)[ \t]*:");
  private static final ies b = new ies();
  private final String c;
  private final String d;
  private final String e;
  
  protected ieu(String paramString1, String paramString2, String paramString3)
  {
    c = paramString1;
    d = paramString2;
    e = paramString3;
  }
  
  public static ieu a(String paramString)
  {
    Object localObject1 = paramString.replaceAll("\r|\n", "");
    Object localObject2 = a.matcher((CharSequence)localObject1);
    if (!((Matcher)localObject2).find()) {
      throw new IllegalArgumentException("Invalid field in string");
    }
    String str = ((Matcher)localObject2).group(1);
    localObject2 = ((String)localObject1).substring(((Matcher)localObject2).end());
    localObject1 = localObject2;
    if (((String)localObject2).length() > 0)
    {
      localObject1 = localObject2;
      if (((String)localObject2).charAt(0) == ' ') {
        localObject1 = ((String)localObject2).substring(1);
      }
    }
    return b.a(str, (String)localObject1, paramString);
  }
  
  public String toString()
  {
    return e;
  }
}

/* Location:
 * Qualified Name:     ieu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */