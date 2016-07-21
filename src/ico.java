import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ico
{
  public static final Pattern a = Pattern.compile("[:;,]|[^\\p{ASCII}]");
  private static final Pattern b = Pattern.compile("([,;])");
  private static final Pattern c = Pattern.compile("\\\\([,;\"])");
  private static final Pattern d = Pattern.compile("\r?\n");
  private static final Pattern e = Pattern.compile("(?<!\\\\)\\\\n");
  private static final Pattern f = Pattern.compile("\\\\");
  private static final Pattern g = Pattern.compile("\\\\\\\\");
  
  public static String a(Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = String.valueOf(paramObject);
      return String.valueOf(paramObject).length() + 2 + "\"" + (String)paramObject + "\"";
    }
    return "\"\"";
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("\""))
      {
        str = paramString;
        if (paramString.endsWith("\"")) {
          str = paramString.substring(0, paramString.length() - 1).substring(1);
        }
      }
    }
    return str;
  }
  
  public static String b(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    return paramObject.toString();
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = f.matcher(paramString).replaceAll("\\\\\\\\");
    }
    str = d(str);
    paramString = str;
    if (str != null) {
      paramString = b.matcher(str).replaceAll("\\\\$1");
    }
    return paramString;
  }
  
  public static String c(String paramString)
  {
    if (paramString != null) {}
    for (String str = c.matcher(paramString).replaceAll("$1");; str = paramString)
    {
      paramString = str;
      if (str != null) {
        paramString = e.matcher(str).replaceAll("\n");
      }
      str = paramString;
      if (paramString != null) {
        str = g.matcher(paramString).replaceAll("\\\\");
      }
      return str;
    }
  }
  
  public static String d(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = d.matcher(paramString).replaceAll("\\\\n");
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     ico
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */