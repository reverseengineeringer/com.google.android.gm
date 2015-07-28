package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

final class RegularImmutableSortedSet<E>
  extends ImmutableSortedSet<E>
{
  private final transient ImmutableList<E> elements;
  
  RegularImmutableSortedSet(ImmutableList<E> paramImmutableList, Comparator<? super E> paramComparator)
  {
    super(paramComparator);
    elements = paramImmutableList;
    if (!paramImmutableList.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }
  
  private int binarySearch(Object paramObject)
  {
    Comparator localComparator = comparator;
    return Collections.binarySearch(elements, paramObject, localComparator);
  }
  
  private ImmutableSortedSet<E> createSubset(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    if (paramInt1 < paramInt2) {
      return new RegularImmutableSortedSet(elements.subList(paramInt1, paramInt2), comparator);
    }
    return emptySet(comparator);
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        int i = binarySearch(paramObject);
        if (i >= 0) {
          return true;
        }
      }
      catch (ClassCastException paramObject) {}
    }
    return false;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!SortedIterables.hasSameComparator(comparator(), paramCollection)) || (paramCollection.size() <= 1)) {
      bool1 = super.containsAll(paramCollection);
    }
    for (;;)
    {
      return bool1;
      UnmodifiableIterator localUnmodifiableIterator = iterator();
      Iterator localIterator = paramCollection.iterator();
      paramCollection = localIterator.next();
      try
      {
        for (;;)
        {
          if (localUnmodifiableIterator.hasNext())
          {
            int i = unsafeCompare(localUnmodifiableIterator.next(), paramCollection);
            if (i == 0)
            {
              bool1 = bool2;
              if (!localIterator.hasNext()) {
                break;
              }
              paramCollection = localIterator.next();
              continue;
            }
            if (i > 0) {
              return false;
            }
          }
        }
      }
      catch (NullPointerException paramCollection)
      {
        return false;
      }
      catch (ClassCastException paramCollection)
      {
        return false;
      }
    }
    return false;
  }
  
  ImmutableList<E> createAsList()
  {
    return new ImmutableSortedAsList(this, elements);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof Set)) {
        return false;
      }
      paramObject = (Set)paramObject;
      if (size() != ((Set)paramObject).size()) {
        return false;
      }
      if (SortedIterables.hasSameComparator(comparator, (Iterable)paramObject))
      {
        paramObject = ((Set)paramObject).iterator();
        try
        {
          UnmodifiableIterator localUnmodifiableIterator = iterator();
          int i;
          do
          {
            if (!localUnmodifiableIterator.hasNext()) {
              break;
            }
            Object localObject1 = localUnmodifiableIterator.next();
            Object localObject2 = ((Iterator)paramObject).next();
            if (localObject2 == null) {
              break label102;
            }
            i = unsafeCompare(localObject1, localObject2);
          } while (i == 0);
          label102:
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
        catch (NoSuchElementException paramObject)
        {
          return false;
        }
      }
    }
    return containsAll((Collection)paramObject);
  }
  
  public E first()
  {
    return (E)elements.get(0);
  }
  
  ImmutableSortedSet<E> headSetImpl(E paramE, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = SortedLists.binarySearch(elements, Preconditions.checkNotNull(paramE), comparator(), SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);; i = SortedLists.binarySearch(elements, Preconditions.checkNotNull(paramE), comparator(), SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER)) {
      return createSubset(0, i);
    }
  }
  
  int indexOf(Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    for (;;)
    {
      try
      {
        i = SortedLists.binarySearch(elements, paramObject, comparator(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
        if ((i >= 0) && (elements.get(i).equals(paramObject))) {
          return i;
        }
      }
      catch (ClassCastException paramObject)
      {
        return -1;
      }
      int i = -1;
    }
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  boolean isPartialView()
  {
    return elements.isPartialView();
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return elements.iterator();
  }
  
  public E last()
  {
    return (E)elements.get(size() - 1);
  }
  
  public int size()
  {
    return elements.size();
  }
  
  ImmutableSortedSet<E> subSetImpl(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return tailSetImpl(paramE1, paramBoolean1).headSetImpl(paramE2, paramBoolean2);
  }
  
  ImmutableSortedSet<E> tailSetImpl(E paramE, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = SortedLists.binarySearch(elements, Preconditions.checkNotNull(paramE), comparator(), SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);; i = SortedLists.binarySearch(elements, Preconditions.checkNotNull(paramE), comparator(), SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER)) {
      return createSubset(i, size());
    }
  }
  
  public Object[] toArray()
  {
    return elements.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return elements.toArray(paramArrayOfT);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.RegularImmutableSortedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */