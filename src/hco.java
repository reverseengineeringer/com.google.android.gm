import java.util.List;
import java.util.ListIterator;

final class hco
  extends hcm
  implements ListIterator<V>
{
  hco(hcn paramhcn)
  {
    super(paramhcn);
  }
  
  public hco(hcn paramhcn, int paramInt)
  {
    super(paramhcn, ((List)c).listIterator(paramInt));
  }
  
  private final ListIterator<V> b()
  {
    a();
    return (ListIterator)a;
  }
  
  public final void add(V paramV)
  {
    boolean bool = d.isEmpty();
    b().add(paramV);
    hcc.b(d.g);
    if (bool) {
      d.c();
    }
  }
  
  public final boolean hasPrevious()
  {
    return b().hasPrevious();
  }
  
  public final int nextIndex()
  {
    return b().nextIndex();
  }
  
  public final V previous()
  {
    return (V)b().previous();
  }
  
  public final int previousIndex()
  {
    return b().previousIndex();
  }
  
  public final void set(V paramV)
  {
    b().set(paramV);
  }
}

/* Location:
 * Qualified Name:     hco
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */