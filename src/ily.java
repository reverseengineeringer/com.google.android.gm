import java.util.HashMap;

public class ily
{
  private static Integer[] g = new Integer[64];
  HashMap a;
  HashMap b;
  String c;
  int d;
  int e;
  boolean f;
  private String h;
  
  static
  {
    int i = 0;
    while (i < g.length)
    {
      g[i] = new Integer(i);
      i += 1;
    }
  }
  
  public ily(String paramString, int paramInt)
  {
    c = paramString;
    d = paramInt;
    a = new HashMap();
    b = new HashMap();
    e = Integer.MAX_VALUE;
  }
  
  public static Integer b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < g.length)) {
      return g[paramInt];
    }
    return new Integer(paramInt);
  }
  
  private final String b(String paramString)
  {
    String str;
    if (d == 2) {
      str = paramString.toUpperCase();
    }
    do
    {
      return str;
      str = paramString;
    } while (d != 3);
    return paramString.toLowerCase();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > e))
    {
      String str = c;
      throw new IllegalArgumentException(String.valueOf(str).length() + 27 + str + " " + paramInt + "is out of range");
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    a(paramInt);
    Integer localInteger = b(paramInt);
    paramString = b(paramString);
    a.put(paramString, localInteger);
    b.put(localInteger, paramString);
  }
  
  public final void a(String paramString)
  {
    h = b(paramString);
  }
  
  public final void b(int paramInt, String paramString)
  {
    a(paramInt);
    Integer localInteger = b(paramInt);
    paramString = b(paramString);
    a.put(paramString, localInteger);
  }
  
  public final String c(int paramInt)
  {
    a(paramInt);
    Object localObject = (String)b.get(b(paramInt));
    if (localObject != null) {}
    do
    {
      return (String)localObject;
      str = Integer.toString(paramInt);
      localObject = str;
    } while (h == null);
    localObject = String.valueOf(h);
    String str = String.valueOf(str);
    if (str.length() != 0) {
      return ((String)localObject).concat(str);
    }
    return new String((String)localObject);
  }
}

/* Location:
 * Qualified Name:     ily
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */