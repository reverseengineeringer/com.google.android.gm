import java.util.Collection;
import java.util.EnumSet;

final class hed<E extends Enum<E>>
  extends hfd<E>
{
  private final transient EnumSet<E> a;
  private transient int b;
  
  hed(EnumSet<E> paramEnumSet)
  {
    a = paramEnumSet;
  }
  
  final boolean I_()
  {
    return true;
  }
  
  public final hji<E> a()
  {
    return hfu.a(a.iterator());
  }
  
  public final boolean contains(Object paramObject)
  {
    return a.contains(paramObject);
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    Object localObject = paramCollection;
    if ((paramCollection instanceof hed)) {
      localObject = a;
    }
    return a.containsAll((Collection)localObject);
  }
  
  final boolean e()
  {
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    Object localObject = paramObject;
    if ((paramObject instanceof hed)) {
      localObject = a;
    }
    return a.equals(localObject);
  }
  
  public final int hashCode()
  {
    int j = b;
    int i = j;
    if (j == 0)
    {
      i = a.hashCode();
      b = i;
    }
    return i;
  }
  
  public final boolean isEmpty()
  {
    return a.isEmpty();
  }
  
  public final int size()
  {
    return a.size();
  }
  
  public final String toString()
  {
    return a.toString();
  }
  
  final Object writeReplace()
  {
    return new hee(a);
  }
}

/* Location:
 * Qualified Name:     hed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */