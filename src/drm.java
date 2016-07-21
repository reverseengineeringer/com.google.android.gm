import java.util.Iterator;
import java.util.Set;

public final class drm
{
  final long a;
  final long b;
  final boolean c;
  private final Set<Long> d;
  private final Set<Long> e;
  
  public drm()
  {
    Object localObject1;
    a = localObject1;
    Object localObject2;
    b = localObject2;
    Set localSet1;
    d = localSet1;
    Set localSet2;
    e = localSet2;
    c = false;
  }
  
  public final boolean a(Set<Long> paramSet)
  {
    if (!paramSet.containsAll(d)) {
      return false;
    }
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      if (paramSet.contains((Long)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     drm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */