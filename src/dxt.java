import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dxt
{
  private static final Pattern a = Pattern.compile("(\\d+)(\\.\\d+)?");
  private static final Map<String, Iterable<String>> b = new HashMap();
  
  static Iterable<String> a(String paramString)
  {
    Object localObject2 = (Iterable)b.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramString.startsWith("^"))
      {
        localObject1 = hef.a(paramString);
        b.put(paramString, localObject1);
      }
    }
    else {
      return (Iterable<String>)localObject1;
    }
    if (gzx.d().b(paramString)) {}
    for (localObject1 = paramString;; localObject1 = ((StringBuffer)localObject2).toString())
    {
      localObject1 = hef.a(TextUtils.split((String)localObject1, "/"));
      break;
      localObject1 = a.matcher(paramString);
      localObject2 = new StringBuffer(paramString.length() + 20);
      while (((Matcher)localObject1).find())
      {
        ((Matcher)localObject1).appendReplacement((StringBuffer)localObject2, "0000000000".substring(Math.min(10, ((Matcher)localObject1).group(1).length())));
        ((StringBuffer)localObject2).append(((Matcher)localObject1).group(1));
        if (((Matcher)localObject1).group(2) != null) {
          ((StringBuffer)localObject2).append(((Matcher)localObject1).group(2));
        }
      }
      ((Matcher)localObject1).appendTail((StringBuffer)localObject2);
    }
  }
}

/* Location:
 * Qualified Name:     dxt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */