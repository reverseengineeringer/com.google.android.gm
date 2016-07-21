import java.util.List;
import java.util.ListIterator;

final class iht
  implements iiw
{
  static final hfd<String> d = hfd.a("script", "style", "noscript", "nostyle", "noembed", "noframes", new String[] { "iframe", "object", "frame", "frameset", "title" });
  final hel<String, ihs> a;
  final hfd<String> b;
  transient boolean c = true;
  private final iix e;
  private final List<String> f = hgd.a();
  
  iht(iix paramiix, hel<String, ihs> paramhel, hfd<String> paramhfd)
  {
    e = paramiix;
    a = paramhel;
    b = paramhfd;
  }
  
  public final void a()
  {
    c = false;
    f.clear();
    e.a();
  }
  
  public final void a(String paramString)
  {
    if (!c) {
      e.a(paramString);
    }
  }
  
  public final void a(String paramString, List<String> paramList)
  {
    ihs localihs = (ihs)a.get(paramString);
    Object localObject;
    int n;
    int k;
    int i;
    int m;
    if (localihs != null)
    {
      localObject = paramList.listIterator();
      while (((ListIterator)localObject).hasNext())
      {
        String str = (String)((ListIterator)localObject).next();
        ihe localihe = (ihe)d.get(str);
        if (localihe == null)
        {
          ((ListIterator)localObject).remove();
          ((ListIterator)localObject).next();
          ((ListIterator)localObject).remove();
        }
        else
        {
          str = localihe.apply(paramString, str, (String)((ListIterator)localObject).next());
          if (str == null)
          {
            ((ListIterator)localObject).remove();
            ((ListIterator)localObject).previous();
            ((ListIterator)localObject).remove();
          }
          else
          {
            ((ListIterator)localObject).set(str);
          }
        }
      }
      n = paramList.size();
      k = 0;
      i = 0;
      int j = 0;
      if (k < n)
      {
        localObject = (String)paramList.get(k);
        if (((String)localObject).length() == 0) {
          break label514;
        }
        m = ((String)localObject).charAt(0) - 'a';
        if ((m >= 0) && (m <= 26))
        {
          m = 1 << m;
          if ((j & m) == 0)
          {
            j = m | j;
            label245:
            if (i != k)
            {
              paramList.set(i, localObject);
              paramList.set(i + 1, paramList.get(k + 1));
            }
            i += 2;
          }
        }
      }
    }
    label461:
    label511:
    label514:
    for (;;)
    {
      k += 2;
      break;
      m = i;
      for (;;)
      {
        m -= 1;
        if (m < 0) {
          break label511;
        }
        if (((String)paramList.get(m)).equals(localObject))
        {
          break;
          if (i != n) {
            paramList.subList(i, n).clear();
          }
          localObject = c.apply(paramString, paramList);
          if ((localObject != null) && ((!paramList.isEmpty()) || (!e)))
          {
            if (!b)
            {
              f.add(a);
              f.add(localObject);
              if (b.contains(localObject)) {
                break label461;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              c = bool;
              e.a((String)localObject, paramList);
              return;
              localObject = null;
              break;
            }
          }
          if (!ijc.d(paramString))
          {
            f.add(paramString);
            f.add(null);
          }
          c = d.contains(paramString);
          return;
        }
      }
      break label245;
    }
  }
  
  public final void b()
  {
    int i = f.size() - 1;
    while (i >= 0)
    {
      String str = (String)f.get(i);
      if (str != null) {
        e.b(str);
      }
      i -= 2;
    }
    f.clear();
    c = true;
    e.b();
  }
  
  public final void b(String paramString)
  {
    int j = f.size();
    int i = j;
    int k;
    if (i > 0)
    {
      k = i - 2;
      if (paramString.equals((String)f.get(k)))
      {
        i = j - 1;
        while (i > k)
        {
          paramString = (String)f.get(i);
          if (paramString != null) {
            e.b(paramString);
          }
          i -= 2;
        }
        f.subList(k, j).clear();
      }
    }
    else
    {
      c = false;
      i = f.size() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        paramString = (String)f.get(i);
        if (paramString == null) {
          break label176;
        }
        if (b.contains(paramString)) {
          break label170;
        }
      }
      label170:
      for (boolean bool = true;; bool = false)
      {
        c = bool;
        return;
        i = k;
        break;
      }
      label176:
      i -= 2;
    }
  }
}

/* Location:
 * Qualified Name:     iht
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */