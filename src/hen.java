import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class hen<K, V>
{
  Comparator<? super V> a;
  her<K, V>[] b;
  int c;
  boolean d;
  
  public hen()
  {
    this(4);
  }
  
  hen(int paramInt)
  {
    b = new her[paramInt];
    c = 0;
    d = false;
  }
  
  private final void a(int paramInt)
  {
    if (paramInt > b.length)
    {
      b = ((her[])hhz.a(b, hdz.a(b.length, paramInt)));
      d = false;
    }
  }
  
  public hen<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable)
  {
    if ((paramIterable instanceof Collection))
    {
      int i = c;
      a(((Collection)paramIterable).size() + i);
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      a((Map.Entry)paramIterable.next());
    }
    return this;
  }
  
  public hen<K, V> a(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    return b(paramEntry.getKey(), paramEntry.getValue());
  }
  
  public hen<K, V> a(Map<? extends K, ? extends V> paramMap)
  {
    return a(paramMap.entrySet());
  }
  
  public hel<K, V> b()
  {
    switch (c)
    {
    default: 
      if (a != null)
      {
        if (d) {
          b = ((her[])hhz.a(b, c));
        }
        Arrays.sort(b, 0, c, hia.a(a).a(hhk.b()));
      }
      if (c != b.length) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return hij.a(c, b);
      return hid.b;
      return hdu.a(b[0].getKey(), b[0].getValue());
    }
  }
  
  public hen<K, V> b(K paramK, V paramV)
  {
    a(c + 1);
    paramK = hel.c(paramK, paramV);
    paramV = b;
    int i = c;
    c = (i + 1);
    paramV[i] = paramK;
    return this;
  }
}

/* Location:
 * Qualified Name:     hen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */