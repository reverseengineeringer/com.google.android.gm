import java.util.Collection;
import java.util.Set;

final class hcp
  extends hcl
  implements Set<V>
{
  hcp(K paramK, Set<V> paramSet)
  {
    super(paramK, paramSet, localCollection, null);
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
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
      bool2 = hio.a((Set)c, paramCollection);
      bool1 = bool2;
    } while (!bool2);
    int j = c.size();
    a.b = (j - i + a.b);
    b();
    return bool2;
  }
}

/* Location:
 * Qualified Name:     hcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */