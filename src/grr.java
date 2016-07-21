import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class grr
{
  private static final Pattern a = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
  private static final Pattern b = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
  private static final Pattern c = Pattern.compile(String.valueOf("[^\\s/=;\"]+").length() + 14 + String.valueOf("[^\\s/=;\"]+").length() + String.valueOf(";.*").length() + "\\s*(" + "[^\\s/=;\"]+" + ")/(" + "[^\\s/=;\"]+" + ")\\s*(" + ";.*" + ")?", 32);
  private static final Pattern d;
  private String e = "application";
  private String f = "octet-stream";
  private final SortedMap<String, String> g = new TreeMap();
  private String h;
  
  static
  {
    String str = String.valueOf("\"([^\"]*)\"").length() + 1 + String.valueOf("[^\\s;\"]*").length() + "\"([^\"]*)\"" + "|" + "[^\\s;\"]*";
    d = Pattern.compile(String.valueOf("[^\\s/=;\"]+").length() + 12 + String.valueOf(str).length() + "\\s*;\\s*(" + "[^\\s/=;\"]+" + ")=(" + str + ")");
  }
  
  public grr(String paramString)
  {
    c(paramString);
  }
  
  private final boolean a(grr paramgrr)
  {
    return (paramgrr != null) && (e.equalsIgnoreCase(e)) && (f.equalsIgnoreCase(f));
  }
  
  static boolean b(String paramString)
  {
    return b.matcher(paramString).matches();
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return (paramString2 != null) && (new grr(paramString1).a(new grr(paramString2)));
  }
  
  private final grr c(String paramString)
  {
    paramString = c.matcher(paramString);
    hbe.a(paramString.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
    String str1 = paramString.group(1);
    hbe.a(a.matcher(str1).matches(), "Type contains reserved characters");
    e = str1;
    h = null;
    str1 = paramString.group(2);
    hbe.a(a.matcher(str1).matches(), "Subtype contains reserved characters");
    f = str1;
    h = null;
    paramString = paramString.group(3);
    if (paramString != null)
    {
      Matcher localMatcher = d.matcher(paramString);
      while (localMatcher.find())
      {
        String str2 = localMatcher.group(1);
        str1 = localMatcher.group(3);
        paramString = str1;
        if (str1 == null) {
          paramString = localMatcher.group(2);
        }
        a(str2, paramString);
      }
    }
    return this;
  }
  
  public final grr a(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      h = null;
      g.remove(paramString1.toLowerCase());
      return this;
    }
    hbe.a(b.matcher(paramString1).matches(), "Name contains reserved characters");
    h = null;
    g.put(paramString1.toLowerCase(), paramString2);
    return this;
  }
  
  public final String a()
  {
    if (h != null) {
      return h;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append('/');
    localStringBuilder.append(f);
    if (g != null)
    {
      Iterator localIterator = g.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localStringBuilder.append("; ");
        localStringBuilder.append((String)((Map.Entry)localObject).getKey());
        localStringBuilder.append("=");
        localObject = str;
        if (!b(str))
        {
          localObject = str.replace("\\", "\\\\").replace("\"", "\\\"");
          localObject = String.valueOf(localObject).length() + 2 + "\"" + (String)localObject + "\"";
        }
        localStringBuilder.append((String)localObject);
      }
    }
    h = localStringBuilder.toString();
    return h;
  }
  
  public final String a(String paramString)
  {
    return (String)g.get(paramString.toLowerCase());
  }
  
  public final Charset b()
  {
    String str = a("charset");
    if (str == null) {
      return null;
    }
    return Charset.forName(str);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof grr)) {}
    do
    {
      return false;
      paramObject = (grr)paramObject;
    } while ((!a((grr)paramObject)) || (!g.equals(g)));
    return true;
  }
  
  public final int hashCode()
  {
    return a().hashCode();
  }
  
  public final String toString()
  {
    return a();
  }
}

/* Location:
 * Qualified Name:     grr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */