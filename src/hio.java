import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class hio
{
  static int a(Set<?> paramSet)
  {
    paramSet = paramSet.iterator();
    int i = 0;
    if (paramSet.hasNext())
    {
      Object localObject = paramSet.next();
      if (localObject != null) {}
      for (int j = localObject.hashCode();; j = 0)
      {
        i = i + j ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
        break;
      }
    }
    return i;
  }
  
  public static <E> HashSet<E> a(int paramInt)
  {
    return new HashSet(hhk.b(paramInt));
  }
  
  public static <E> HashSet<E> a(E... paramVarArgs)
  {
    HashSet localHashSet = a(paramVarArgs.length);
    Collections.addAll(localHashSet, paramVarArgs);
    return localHashSet;
  }
  
  public static <E> LinkedHashSet<E> a()
  {
    return new LinkedHashSet();
  }
  
  public static <E> LinkedHashSet<E> a(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new LinkedHashSet(hcx.a(paramIterable));
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    if ((paramIterable instanceof Collection)) {
      localLinkedHashSet.addAll(hcx.a(paramIterable));
    }
    for (;;)
    {
      return localLinkedHashSet;
      hfu.a(localLinkedHashSet, ((Iterable)hbe.a(paramIterable)).iterator());
    }
  }
  
  static boolean a(Set<?> paramSet, Object paramObject)
  {
    if (paramSet == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Set))
      {
        paramObject = (Set)paramObject;
        try
        {
          if (paramSet.size() == ((Set)paramObject).size())
          {
            boolean bool = paramSet.containsAll((Collection)paramObject);
            if (bool) {}
          }
          else
          {
            return false;
          }
        }
        catch (NullPointerException paramSet)
        {
          return false;
        }
        catch (ClassCastException paramSet)
        {
          return false;
        }
      }
    }
    return false;
  }
  
  static boolean a(Set<?> paramSet, Collection<?> paramCollection)
  {
    hbe.a(paramCollection);
    Object localObject = paramCollection;
    if ((paramCollection instanceof hhx)) {
      localObject = ((hhx)paramCollection).a();
    }
    if (((localObject instanceof Set)) && (((Collection)localObject).size() > paramSet.size())) {
      return hfu.a(paramSet.iterator(), (Collection)localObject);
    }
    return a(paramSet, ((Collection)localObject).iterator());
  }
  
  static boolean a(Set<?> paramSet, Iterator<?> paramIterator)
  {
    boolean bool = false;
    while (paramIterator.hasNext()) {
      bool |= paramSet.remove(paramIterator.next());
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     hio
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */