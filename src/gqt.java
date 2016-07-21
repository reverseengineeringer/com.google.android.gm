import java.util.logging.Logger;

public class gqt
{
  static final Logger a = Logger.getLogger(gqt.class.getName());
  final grt b;
  final String c;
  final String d;
  final String e;
  private final gqx f;
  private final gum g;
  private boolean h;
  private boolean i;
  
  public gqt(gqu paramgqu)
  {
    f = b;
    c = a(e);
    d = b(f);
    if (hbw.b(g)) {
      a.warning("Application name is not set. Call Builder#setApplicationName.");
    }
    e = g;
    if (c == null) {}
    for (grt localgrt = a.a(null);; localgrt = a.a(c))
    {
      b = localgrt;
      g = d;
      h = h;
      i = i;
      return;
    }
  }
  
  static String a(String paramString)
  {
    hbe.a(paramString, "root URL cannot be null.");
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = String.valueOf(paramString).concat("/");
    }
    return str;
  }
  
  static String b(String paramString)
  {
    hbe.a(paramString, "service path cannot be null");
    Object localObject;
    if (paramString.length() == 1)
    {
      hbe.a("/".equals(paramString), "service path must equal \"/\" if it is of length 1.");
      localObject = "";
    }
    String str;
    do
    {
      do
      {
        return (String)localObject;
        localObject = paramString;
      } while (paramString.length() <= 0);
      str = paramString;
      if (!paramString.endsWith("/")) {
        str = String.valueOf(paramString).concat("/");
      }
      localObject = str;
    } while (!str.startsWith("/"));
    return str.substring(1);
  }
  
  public gum a()
  {
    return g;
  }
}

/* Location:
 * Qualified Name:     gqt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */