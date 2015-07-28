package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

final class SortedIterables
{
  public static boolean hasSameComparator(Comparator<?> paramComparator, Iterable<?> paramIterable)
  {
    Preconditions.checkNotNull(paramComparator);
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof SortedSet))
    {
      Comparator localComparator = ((SortedSet)paramIterable).comparator();
      paramIterable = localComparator;
      if (localComparator == null) {
        paramIterable = Ordering.natural();
      }
    }
    for (;;)
    {
      return paramComparator.equals(paramIterable);
      if ((paramIterable instanceof SortedIterable)) {
        paramIterable = ((SortedIterable)paramIterable).comparator();
      } else {
        paramIterable = null;
      }
    }
  }
  
  public static <E> Collection<E> sortedUnique(Comparator<? super E> paramComparator, Iterator<E> paramIterator)
  {
    paramComparator = Sets.newTreeSet(paramComparator);
    Iterators.addAll(paramComparator, paramIterator);
    return paramComparator;
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.SortedIterables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */