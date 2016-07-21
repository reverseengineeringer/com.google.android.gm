import java.util.Comparator;
import java.util.SortedSet;

final class hcq
  extends hcl
  implements SortedSet<V>
{
  hcq(K paramK, SortedSet<V> paramSortedSet, hcl paramhcl)
  {
    super(paramK, paramSortedSet, paramhcl, localhcl);
  }
  
  public final Comparator<? super V> comparator()
  {
    return ((SortedSet)c).comparator();
  }
  
  public final V first()
  {
    a();
    return (V)((SortedSet)c).first();
  }
  
  public final SortedSet<V> headSet(V paramV)
  {
    a();
    hcc localhcc = a;
    Object localObject = b;
    SortedSet localSortedSet = ((SortedSet)c).headSet(paramV);
    if (d == null) {}
    for (paramV = this;; paramV = d) {
      return new hcq(localhcc, localObject, localSortedSet, paramV);
    }
  }
  
  public final V last()
  {
    a();
    return (V)((SortedSet)c).last();
  }
  
  public final SortedSet<V> subSet(V paramV1, V paramV2)
  {
    a();
    hcc localhcc = a;
    Object localObject = b;
    paramV2 = ((SortedSet)c).subSet(paramV1, paramV2);
    if (d == null) {}
    for (paramV1 = this;; paramV1 = d) {
      return new hcq(localhcc, localObject, paramV2, paramV1);
    }
  }
  
  public final SortedSet<V> tailSet(V paramV)
  {
    a();
    hcc localhcc = a;
    Object localObject = b;
    SortedSet localSortedSet = ((SortedSet)c).tailSet(paramV);
    if (d == null) {}
    for (paramV = this;; paramV = d) {
      return new hcq(localhcc, localObject, localSortedSet, paramV);
    }
  }
}

/* Location:
 * Qualified Name:     hcq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */