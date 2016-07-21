import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;

class hcl
  extends AbstractCollection<V>
{
  final K b;
  Collection<V> c;
  final hcl d;
  final Collection<V> e;
  
  hcl(K paramK, Collection<V> paramCollection, hcl paramhcl)
  {
    b = paramCollection;
    c = paramhcl;
    hcl localhcl;
    d = localhcl;
    if (localhcl == null) {}
    for (paramK = null;; paramK = c)
    {
      e = paramK;
      return;
    }
  }
  
  final void a()
  {
    if (d != null)
    {
      d.a();
      if (d.c != e) {
        throw new ConcurrentModificationException();
      }
    }
    else if (c.isEmpty())
    {
      Collection localCollection = (Collection)f.a.get(b);
      if (localCollection != null) {
        c = localCollection;
      }
    }
  }
  
  public boolean add(V paramV)
  {
    a();
    boolean bool1 = c.isEmpty();
    boolean bool2 = c.add(paramV);
    if (bool2)
    {
      hcc.b(f);
      if (bool1) {
        c();
      }
    }
    return bool2;
  }
  
  public boolean addAll(Collection<? extends V> paramCollection)
  {
    boolean bool1;
    if (paramCollection.isEmpty()) {
      bool1 = false;
    }
    int i;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        i = size();
        bool2 = c.addAll(paramCollection);
        bool1 = bool2;
      } while (!bool2);
      int j = c.size();
      f.b = (j - i + f.b);
      bool1 = bool2;
    } while (i != 0);
    c();
    return bool2;
  }
  
  final void b()
  {
    for (hcl localhcl = this; d != null; localhcl = d) {}
    if (c.isEmpty()) {
      f.a.remove(b);
    }
  }
  
  final void c()
  {
    for (hcl localhcl = this; d != null; localhcl = d) {}
    f.a.put(b, c);
  }
  
  public void clear()
  {
    int i = size();
    if (i == 0) {
      return;
    }
    c.clear();
    f.b -= i;
    b();
  }
  
  public boolean contains(Object paramObject)
  {
    a();
    return c.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    a();
    return c.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    a();
    return c.equals(paramObject);
  }
  
  public int hashCode()
  {
    a();
    return c.hashCode();
  }
  
  public Iterator<V> iterator()
  {
    a();
    return new hcm(this);
  }
  
  public boolean remove(Object paramObject)
  {
    a();
    boolean bool = c.remove(paramObject);
    if (bool)
    {
      hcc.a(f);
      b();
    }
    return bool;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool1;
    if (paramCollection.isEmpty()) {
      bool1 = false;
    }
    int i;
    boolean bool2;
    do
    {
      return bool1;
      i = size();
      bool2 = c.removeAll(paramCollection);
      bool1 = bool2;
    } while (!bool2);
    int j = c.size();
    f.b = (j - i + f.b);
    b();
    return bool2;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    hbe.a(paramCollection);
    int i = size();
    boolean bool = c.retainAll(paramCollection);
    if (bool)
    {
      int j = c.size();
      f.b = (j - i + f.b);
      b();
    }
    return bool;
  }
  
  public int size()
  {
    a();
    return c.size();
  }
  
  public String toString()
  {
    a();
    return c.toString();
  }
}

/* Location:
 * Qualified Name:     hcl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */