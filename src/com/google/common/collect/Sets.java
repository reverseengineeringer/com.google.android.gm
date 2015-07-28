package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public final class Sets
{
  static boolean equalsImpl(Set<?> paramSet, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramSet == paramObject) {
      bool1 = true;
    }
    while (!(paramObject instanceof Set)) {
      return bool1;
    }
    paramObject = (Set)paramObject;
    try
    {
      if (paramSet.size() == ((Set)paramObject).size())
      {
        bool1 = paramSet.containsAll((Collection)paramObject);
        if (!bool1) {}
      }
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
      return false;
    }
    catch (NullPointerException paramSet)
    {
      return false;
    }
    catch (ClassCastException paramSet) {}
  }
  
  static int hashCodeImpl(Set<?> paramSet)
  {
    int i = 0;
    paramSet = paramSet.iterator();
    if (paramSet.hasNext())
    {
      Object localObject = paramSet.next();
      if (localObject != null) {}
      for (int j = localObject.hashCode();; j = 0)
      {
        i += j;
        break;
      }
    }
    return i;
  }
  
  public static <E> HashSet<E> newHashSet()
  {
    return new HashSet();
  }
  
  public static <E> HashSet<E> newHashSet(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new HashSet(Collections2.cast(paramIterable));
    }
    return newHashSet(paramIterable.iterator());
  }
  
  public static <E> HashSet<E> newHashSet(Iterator<? extends E> paramIterator)
  {
    HashSet localHashSet = newHashSet();
    while (paramIterator.hasNext()) {
      localHashSet.add(paramIterator.next());
    }
    return localHashSet;
  }
  
  public static <E> HashSet<E> newHashSet(E... paramVarArgs)
  {
    HashSet localHashSet = newHashSetWithExpectedSize(paramVarArgs.length);
    Collections.addAll(localHashSet, paramVarArgs);
    return localHashSet;
  }
  
  public static <E> HashSet<E> newHashSetWithExpectedSize(int paramInt)
  {
    return new HashSet(Maps.capacity(paramInt));
  }
  
  public static <E extends Comparable> TreeSet<E> newTreeSet()
  {
    return new TreeSet();
  }
  
  public static <E> TreeSet<E> newTreeSet(Comparator<? super E> paramComparator)
  {
    return new TreeSet((Comparator)Preconditions.checkNotNull(paramComparator));
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.Sets
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */