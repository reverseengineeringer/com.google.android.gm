import java.util.LinkedList;
import java.util.Set;

public final class iim
  extends ihd
{
  private static final Set<String> e = hfd.a("checked", "compact", "declare", "defer", "disabled", "ismap", new String[] { "multiple", "nohref", "noresize", "noshade", "nowrap", "readonly", "selected" });
  private final String a;
  private final iij b;
  private int c = iio.a;
  private final LinkedList<ijd> d = hgd.b();
  
  public iim(String paramString)
  {
    a = paramString;
    b = new iij(paramString);
  }
  
  private final ijd a(int paramInt)
  {
    while ((d.size() <= paramInt) && (b.a())) {
      d.add(b.b());
    }
    if (d.size() > paramInt) {
      return (ijd)d.get(paramInt);
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (paramString.indexOf(':') >= 0) {
      return paramString;
    }
    return ijj.a(paramString);
  }
  
  private final ijd d()
  {
    if (!d.isEmpty()) {
      return (ijd)d.remove();
    }
    if (b.a()) {
      return b.b();
    }
    return null;
  }
  
  protected final ijd c()
  {
    ijd localijd1 = d();
    if (localijd1 == null) {
      localObject = null;
    }
    label125:
    ijd localijd2;
    do
    {
      do
      {
        do
        {
          do
          {
            return (ijd)localObject;
            switch (iin.b[(c - 1)])
            {
            case 3: 
            default: 
              switch (iin.a[(c - 1)])
              {
              default: 
                return localijd1;
              case 1: 
                if (ije.j == c) {
                  break label125;
                }
                localObject = localijd1;
              }
              break;
            }
          } while (ije.f != c);
          localObject = localijd1;
          for (;;)
          {
            localijd2 = a(0);
            if ((localijd2 == null) || (c != c)) {
              break;
            }
            localObject = ijd.a(a, b, c);
            d();
          }
          c = iio.b;
          return localijd1;
          if ((c == iio.d) && (ije.i == c))
          {
            d.addFirst(localijd1);
            c = iio.b;
            return ijd.a(a, a, ije.b);
          }
          c = iio.a;
          return localijd1;
          return (ijd)localObject;
          localObject = localijd1;
        } while (ije.j != c);
        localObject = localijd1;
      } while (localijd1.a(a, "="));
      localijd1 = iij.a(localijd1, ije.a);
      c = iio.c;
      return localijd1;
      if (ije.j == c)
      {
        if (localijd1.a(a, "="))
        {
          c = iio.d;
          break;
        }
        return iij.a(localijd1, ije.a);
      }
      c = iio.b;
      return localijd1;
      if (ije.j == c) {
        break label392;
      }
      localObject = localijd1;
    } while (ije.g != c);
    label392:
    Object localObject = localijd1;
    int i;
    int j;
    if (ije.j == c)
    {
      i = 0;
      localObject = a(i);
      if (localObject != null) {
        if (c == ije.k)
        {
          localObject = a(i + 1);
          if ((localObject != null) && (c == ije.j))
          {
            localObject = a.substring(a, b);
            if (!e.contains(ijj.a((String)localObject)))
            {
              localijd2 = a(i + 2);
              localObject = localijd2;
              if (localijd2 != null)
              {
                localObject = localijd2;
                if (c == ije.k) {
                  localObject = a(i + 3);
                }
              }
              if ((localObject == null) || (((ijd)localObject).a(a, "="))) {}
            }
          }
        }
        else
        {
          while (c == ije.j)
          {
            i += 1;
            break;
          }
        }
      }
      j = i;
      if (i != 0) {
        break label601;
      }
    }
    label601:
    int k;
    for (localObject = localijd1;; localObject = ijd.a(a, k, ije.j))
    {
      localijd1 = iij.a((ijd)localObject, ije.b);
      c = iio.b;
      return localijd1;
      do
      {
        k = db;
        i = j - 1;
        j = i;
      } while (i > 0);
    }
  }
}

/* Location:
 * Qualified Name:     iim
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */