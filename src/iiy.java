import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class iiy
  implements iix
{
  boolean a;
  private final Appendable b;
  private final iib<? super IOException> c;
  private final iib<? super String> d;
  private String e;
  private StringBuilder f;
  private ijc g = ijc.a;
  
  private iiy(Appendable paramAppendable, iib<? super IOException> paramiib, iib<? super String> paramiib1)
  {
    b = paramAppendable;
    c = paramiib;
    d = paramiib1;
  }
  
  private static int a(String paramString, StringBuilder paramStringBuilder)
  {
    int i = 0;
    int m = paramStringBuilder.length();
    int k = -1;
    if (i < m)
    {
      int j = k;
      switch (paramStringBuilder.charAt(i))
      {
      default: 
        j = k;
      }
      for (;;)
      {
        i += 1;
        k = j;
        break;
        if ((i + 3 < m) && ('!' == paramStringBuilder.charAt(i + 1)) && ('-' == paramStringBuilder.charAt(i + 2)) && ('-' == paramStringBuilder.charAt(i + 3)))
        {
          if (k == -1) {
            j = i;
          }
        }
        else
        {
          j = k;
          if (i + 1 + paramString.length() >= m) {
            continue;
          }
          j = k;
          if ('/' != paramStringBuilder.charAt(i + 1)) {
            continue;
          }
          j = k;
          if (!ijj.a(paramStringBuilder, i + 2, paramString, paramString.length())) {
            continue;
          }
          if (k >= 0) {
            break label176;
          }
        }
        return i;
        label176:
        j = k;
        if (!"script".equals(paramString))
        {
          return i;
          j = k;
          if (i >= 2)
          {
            j = k;
            if ('-' == paramStringBuilder.charAt(i - 1))
            {
              j = k;
              if ('-' == paramStringBuilder.charAt(i - 2))
              {
                if (k < 0) {
                  return i - 2;
                }
                j = -1;
              }
            }
          }
        }
      }
    }
    if (k >= 0) {
      return k;
    }
    return -1;
  }
  
  public static iiy a(Appendable paramAppendable, iib<? super IOException> paramiib, iib<? super String> paramiib1)
  {
    if ((paramAppendable instanceof Closeable)) {
      return new ijb(paramAppendable, paramiib, paramiib1);
    }
    if ((paramAppendable instanceof AutoCloseable)) {
      return new ija(paramAppendable, paramiib, paramiib1);
    }
    return new iiy(paramAppendable, paramiib, paramiib1);
  }
  
  private final void a(String paramString, CharSequence paramCharSequence)
  {
    if (d != iib.a) {
      d.a(paramString + " : " + paramCharSequence);
    }
  }
  
  private static boolean c(String paramString)
  {
    boolean bool2 = true;
    int m = paramString.length();
    boolean bool1;
    if (m == 0)
    {
      bool1 = false;
      return bool1;
    }
    if (m > 128) {
      return false;
    }
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      bool1 = bool2;
      if (i >= m) {
        break;
      }
      int n = paramString.charAt(i);
      switch (n)
      {
      default: 
        if (n <= 57)
        {
          if (i != 0)
          {
            k = j;
            if (n >= 48) {
              break label176;
            }
          }
          return false;
        }
        break;
      case 58: 
        if (j != 0) {
          return false;
        }
        if ((i != 0) && (i + 1 != m)) {
          break label174;
        }
        return false;
      case 45: 
        if (i != 0)
        {
          k = j;
          if (i + 1 != m) {
            break label176;
          }
        }
        return false;
      }
      if ((65 <= n) && (n <= 122))
      {
        k = j;
        if (90 < n)
        {
          k = j;
          if (n < 97) {
            return false;
          }
        }
      }
      else
      {
        return false;
        label174:
        k = 1;
      }
      label176:
      i += 1;
    }
  }
  
  private static String d(String paramString)
  {
    paramString = iim.a(paramString);
    switch (paramString.length())
    {
    }
    do
    {
      do
      {
        do
        {
          return paramString;
        } while (!"xmp".equals(paramString));
        return "pre";
      } while (!"listing".equals(paramString));
      return "pre";
    } while (!"plaintext".equals(paramString));
    return "pre";
  }
  
  public final void a()
  {
    if (a) {
      throw new IllegalStateException();
    }
    a = true;
  }
  
  public final void a(String paramString)
  {
    try
    {
      if (!a) {
        throw new IllegalStateException();
      }
    }
    catch (IOException paramString)
    {
      c.a(paramString);
      return;
    }
    if (f != null)
    {
      f.append(paramString);
      return;
    }
    if (g == ijc.d)
    {
      ihz.c(paramString, b);
      return;
    }
    ihz.b(paramString, b);
  }
  
  public final void a(String paramString, List<String> paramList)
  {
    try
    {
      if (!a) {
        throw new IllegalStateException();
      }
    }
    catch (IOException paramString)
    {
      c.a(paramString);
      return;
    }
    paramString = d(paramString);
    if (!c(paramString))
    {
      a("Invalid element name", paramString);
      return;
    }
    if (f != null)
    {
      a("Tag content cannot appear inside CDATA element", paramString);
      return;
    }
    g = ijc.a(paramString);
    switch (iiz.a[g.ordinal()])
    {
    }
    for (;;)
    {
      b.append('<').append(paramString);
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label286;
        }
        String str2 = (String)paramList.next();
        String str1 = (String)paramList.next();
        str2 = iim.a(str2);
        if (!c(str2))
        {
          a("Invalid attr name", str2);
          continue;
          e = paramString;
          f = new StringBuilder();
          break;
        }
        b.append(' ').append(str2).append('=').append('"');
        ihz.a(str1, b);
        if (str1.indexOf('`') != -1) {
          b.append(' ');
        }
        b.append('"');
      }
      label286:
      if (ijc.d(paramString)) {
        b.append(" /");
      }
      b.append('>');
      return;
    }
  }
  
  public final void b()
  {
    if (!a) {
      throw new IllegalStateException();
    }
    if (f != null) {
      b(e);
    }
    a = false;
    if ((b instanceof Flushable)) {}
    try
    {
      ((Flushable)b).flush();
      return;
    }
    catch (IOException localIOException)
    {
      c.a(localIOException);
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      paramString = d(paramString);
      if (!a) {
        throw new IllegalStateException();
      }
    }
    catch (IOException paramString)
    {
      c.a(paramString);
    }
    for (;;)
    {
      return;
      paramString = iim.a(paramString);
      if (!c(paramString))
      {
        a("Invalid element name", paramString);
        return;
      }
      StringBuilder localStringBuilder;
      int i;
      if (f != null)
      {
        if (!e.equals(paramString))
        {
          a("Tag content cannot appear inside CDATA element", paramString);
          return;
        }
        localStringBuilder = f;
        f = null;
        ihz.a(localStringBuilder);
        i = a(e, localStringBuilder);
        if (i != -1) {
          break label152;
        }
        b.append(localStringBuilder);
      }
      while (!"plaintext".equals(paramString))
      {
        b.append("</").append(paramString).append(">");
        return;
        label152:
        a("Invalid CDATA text content", localStringBuilder.subSequence(i, Math.min(i + 10, localStringBuilder.length())));
      }
    }
  }
}

/* Location:
 * Qualified Name:     iiy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */