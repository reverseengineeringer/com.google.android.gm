import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class hcn
  extends hcl
  implements List<V>
{
  hcn(K paramK, List<V> paramList, hcl paramhcl)
  {
    super(paramK, paramList, paramhcl, localhcl);
  }
  
  public void add(int paramInt, V paramV)
  {
    a();
    boolean bool = c.isEmpty();
    ((List)c).add(paramInt, paramV);
    hcc.b(g);
    if (bool) {
      c();
    }
  }
  
  public boolean addAll(int paramInt, Collection<? extends V> paramCollection)
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
        bool2 = ((List)c).addAll(paramInt, paramCollection);
        bool1 = bool2;
      } while (!bool2);
      paramInt = c.size();
      g.b = (paramInt - i + g.b);
      bool1 = bool2;
    } while (i != 0);
    c();
    return bool2;
  }
  
  public V get(int paramInt)
  {
    a();
    return (V)((List)c).get(paramInt);
  }
  
  public int indexOf(Object paramObject)
  {
    a();
    return ((List)c).indexOf(paramObject);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    a();
    return ((List)c).lastIndexOf(paramObject);
  }
  
  public ListIterator<V> listIterator()
  {
    a();
    return new hco(this);
  }
  
  public ListIterator<V> listIterator(int paramInt)
  {
    a();
    return new hco(this, paramInt);
  }
  
  public V remove(int paramInt)
  {
    a();
    Object localObject = ((List)c).remove(paramInt);
    hcc.a(g);
    b();
    return (V)localObject;
  }
  
  public V set(int paramInt, V paramV)
  {
    a();
    return (V)((List)c).set(paramInt, paramV);
  }
  
  public List<V> subList(int paramInt1, int paramInt2)
  {
    a();
    hcc localhcc = g;
    Object localObject2 = b;
    List localList = ((List)c).subList(paramInt1, paramInt2);
    if (d == null) {}
    for (Object localObject1 = this;; localObject1 = d) {
      return localhcc.a(localObject2, localList, (hcl)localObject1);
    }
  }
}

/* Location:
 * Qualified Name:     hcn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */