import android.text.Spanned;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public final class cvb
{
  static final String a = cvl.a;
  static final Map<String, Integer> b;
  private static final gps c = new cvc();
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put("darkgray", Integer.valueOf(-5658199));
    b.put("gray", Integer.valueOf(-8355712));
    b.put("lightgray", Integer.valueOf(-2894893));
    b.put("darkgrey", Integer.valueOf(-5658199));
    b.put("grey", Integer.valueOf(-8355712));
    b.put("lightgrey", Integer.valueOf(-2894893));
    b.put("green", Integer.valueOf(-16744448));
  }
  
  public static Spanned a(String paramString, gps paramgps)
  {
    buq.b.a("compose_html_to_span");
    gpo localgpo = cxa.c(paramString);
    localgpo.a(paramgps);
    if (c == null)
    {
      if (c == null) {}
      for (boolean bool = true;; bool = false)
      {
        hby.a(bool);
        int j = a.size();
        paramgps = d.a();
        int i = 0;
        while (i < j)
        {
          paramgps.a((gpc)a.get(i), i, ((Integer)b.get(i)).intValue());
          i += 1;
        }
      }
      c = ((Spanned)paramgps.b());
    }
    paramgps = c;
    buq.b.a("compose_html_to_span", true, "compose", "html_to_span");
    cvm.c(a, "htmlToSpan completed, input: %d, result: %d", new Object[] { Integer.valueOf(paramString.length()), Integer.valueOf(paramgps.length()) });
    return paramgps;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = cxa.c(paramString);
    paramString.a(c);
    return paramString.a();
  }
  
  public static Spanned b(String paramString)
  {
    return a(paramString, new cvd());
  }
}

/* Location:
 * Qualified Name:     cvb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */