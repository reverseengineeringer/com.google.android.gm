package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;

final class ImmutableSortedAsList<E>
  extends ImmutableList<E>
  implements SortedIterable<E>
{
  private final transient ImmutableList<E> backingList;
  private final transient ImmutableSortedSet<E> backingSet;
  
  ImmutableSortedAsList(ImmutableSortedSet<E> paramImmutableSortedSet, ImmutableList<E> paramImmutableList)
  {
    backingSet = paramImmutableSortedSet;
    backingList = paramImmutableList;
  }
  
  public Comparator<? super E> comparator()
  {
    return backingSet.comparator();
  }
  
  public boolean contains(Object paramObject)
  {
    return backingSet.indexOf(paramObject) >= 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return backingList.equals(paramObject);
  }
  
  public E get(int paramInt)
  {
    return (E)backingList.get(paramInt);
  }
  
  public int hashCode()
  {
    return backingList.hashCode();
  }
  
  public int indexOf(Object paramObject)
  {
    return backingSet.indexOf(paramObject);
  }
  
  boolean isPartialView()
  {
    return backingList.isPartialView();
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return backingList.iterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return backingSet.indexOf(paramObject);
  }
  
  public UnmodifiableListIterator<E> listIterator()
  {
    return backingList.listIterator();
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt)
  {
    return backingList.listIterator(paramInt);
  }
  
  public int size()
  {
    return backingList.size();
  }
  
  public ImmutableList<E> subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
    if (paramInt1 == paramInt2) {
      return ImmutableList.of();
    }
    return new RegularImmutableSortedSet(backingList.subList(paramInt1, paramInt2), backingSet.comparator()).asList();
  }
  
  Object writeReplace()
  {
    return new ImmutableAsList.SerializedForm(backingSet);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */