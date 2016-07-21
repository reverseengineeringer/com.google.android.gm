import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public final class gsw
  implements gum
{
  public final gsu a;
  public final Set<String> b;
  
  public gsw(gsx paramgsx)
  {
    a = a;
    b = new HashSet(b);
  }
  
  public final <T> T a(InputStream paramInputStream, Charset paramCharset, Class<T> paramClass)
  {
    int j = 0;
    paramInputStream = a.a(paramInputStream, paramCharset);
    if (!b.isEmpty())
    {
      int i = j;
      try
      {
        if (paramInputStream.a(b) != null)
        {
          i = j;
          if (paramInputStream.c() != gtd.d) {
            i = 1;
          }
        }
        paramCharset = b;
        if (i == 0) {
          throw new IllegalArgumentException(hbe.a("wrapper key(s) not found: %s", new Object[] { paramCharset }));
        }
      }
      finally
      {
        paramInputStream.a();
      }
    }
    return (T)paramInputStream.a(paramClass, true, null);
  }
}

/* Location:
 * Qualified Name:     gsw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */