import java.util.Map;

public abstract class hjk
  extends hjm
{
  private final char[][] a;
  private final int b;
  private final char c;
  private final char d;
  
  private hjk(hjl paramhjl, char paramChar1, char paramChar2)
  {
    hbe.a(paramhjl);
    a = a;
    b = a.length;
    int i = paramChar1;
    char c1 = paramChar2;
    if (paramChar2 < paramChar1)
    {
      c1 = '\000';
      i = 65535;
    }
    c = i;
    d = c1;
  }
  
  protected hjk(Map<Character, String> paramMap, char paramChar1, char paramChar2)
  {
    this(new hjl(hjl.a(paramMap)), paramChar1, paramChar2);
  }
  
  public final String a(String paramString)
  {
    hbe.a(paramString);
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < paramString.length())
      {
        int j = paramString.charAt(i);
        if (((j < b) && (a[j] != null)) || (j > d) || (j < c)) {
          str = a(paramString, i);
        }
      }
      else
      {
        return str;
      }
      i += 1;
    }
  }
  
  protected abstract char[] a();
  
  protected final char[] a(char paramChar)
  {
    if (paramChar < b)
    {
      char[] arrayOfChar = a[paramChar];
      if (arrayOfChar != null) {
        return arrayOfChar;
      }
    }
    if ((paramChar >= c) && (paramChar <= d)) {
      return null;
    }
    return a();
  }
}

/* Location:
 * Qualified Name:     hjk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */