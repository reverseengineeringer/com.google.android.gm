import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class cyu
  extends CharsetProvider
{
  private static final String[] a = { "UNICODE-1-1-UTF-7", "CSUNICODE11UTF7", "X-RFC2152", "X-RFC-2152" };
  private static final String[] b = { "X-RFC2152-OPTIONAL", "X-RFC-2152-OPTIONAL" };
  private static final String[] c = { "X-IMAP-MODIFIED-UTF-7", "X-IMAP4-MODIFIED-UTF7", "X-IMAP4-MODIFIED-UTF-7", "X-RFC3501", "X-RFC-3501" };
  private Charset d = new cyw("UTF-7", a, false);
  private Charset e = new cyw("X-UTF-7-OPTIONAL", b, true);
  private Charset f = new cyv("X-MODIFIED-UTF-7", c);
  private List<Charset> g = Arrays.asList(new Charset[] { d, f, e });
  
  public final Charset charsetForName(String paramString)
  {
    paramString = paramString.toUpperCase();
    Iterator localIterator = g.iterator();
    Charset localCharset;
    while (localIterator.hasNext())
    {
      localCharset = (Charset)localIterator.next();
      if (localCharset.name().equals(paramString)) {
        return localCharset;
      }
    }
    localIterator = g.iterator();
    while (localIterator.hasNext())
    {
      localCharset = (Charset)localIterator.next();
      if (localCharset.aliases().contains(paramString)) {
        return localCharset;
      }
    }
    return null;
  }
  
  public final Iterator<Charset> charsets()
  {
    return g.iterator();
  }
}

/* Location:
 * Qualified Name:     cyu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */