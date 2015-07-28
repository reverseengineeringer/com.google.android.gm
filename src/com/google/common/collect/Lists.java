package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Lists
{
  static int computeArrayListCapacity(int paramInt)
  {
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return Ints.saturatedCast(5L + paramInt + paramInt / 10);
    }
  }
  
  static boolean equalsImpl(List<?> paramList, Object paramObject)
  {
    if (paramObject == Preconditions.checkNotNull(paramList)) {}
    do
    {
      return true;
      if (!(paramObject instanceof List)) {
        return false;
      }
      paramObject = (List)paramObject;
    } while ((paramList.size() == ((List)paramObject).size()) && (Iterators.elementsEqual(paramList.iterator(), ((List)paramObject).iterator())));
    return false;
  }
  
  static int hashCodeImpl(List<?> paramList)
  {
    int i = 1;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject == null) {}
      for (int j = 0;; j = localObject.hashCode())
      {
        i = i * 31 + j;
        break;
      }
    }
    return i;
  }
  
  public static <E> ArrayList<E> newArrayList()
  {
    return new ArrayList();
  }
  
  public static <E> ArrayList<E> newArrayList(Iterable<? extends E> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof Collection)) {
      return new ArrayList(Collections2.cast(paramIterable));
    }
    return newArrayList(paramIterable.iterator());
  }
  
  public static <E> ArrayList<E> newArrayList(Iterator<? extends E> paramIterator)
  {
    Preconditions.checkNotNull(paramIterator);
    ArrayList localArrayList = newArrayList();
    while (paramIterator.hasNext()) {
      localArrayList.add(paramIterator.next());
    }
    return localArrayList;
  }
  
  public static <E> ArrayList<E> newArrayList(E... paramVarArgs)
  {
    Preconditions.checkNotNull(paramVarArgs);
    ArrayList localArrayList = new ArrayList(computeArrayListCapacity(paramVarArgs.length));
    Collections.addAll(localArrayList, paramVarArgs);
    return localArrayList;
  }
  
  public static <E> LinkedList<E> newLinkedList()
  {
    return new LinkedList();
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.Lists
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */