package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public abstract class ImmutableSortedSet<E>
  extends ImmutableSortedSetFauxverideShim<E>
  implements SortedSet<E>, SortedIterable<E>
{
  private static final ImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new EmptyImmutableSortedSet(NATURAL_ORDER);
  private static final Comparator<Comparable> NATURAL_ORDER = ;
  final transient Comparator<? super E> comparator;
  
  ImmutableSortedSet(Comparator<? super E> paramComparator)
  {
    comparator = paramComparator;
  }
  
  private static <E> ImmutableSortedSet<E> copyOfInternal(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator)
  {
    paramIterator = ImmutableList.copyOf(SortedIterables.sortedUnique(paramComparator, paramIterator));
    if (paramIterator.isEmpty()) {
      return emptySet(paramComparator);
    }
    return new RegularImmutableSortedSet(paramIterator, paramComparator);
  }
  
  private static <E> ImmutableSortedSet<E> emptySet()
  {
    return NATURAL_EMPTY_SET;
  }
  
  static <E> ImmutableSortedSet<E> emptySet(Comparator<? super E> paramComparator)
  {
    if (NATURAL_ORDER.equals(paramComparator)) {
      return emptySet();
    }
    return new EmptyImmutableSortedSet(paramComparator);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  static int unsafeCompare(Comparator<?> paramComparator, Object paramObject1, Object paramObject2)
  {
    return paramComparator.compare(paramObject1, paramObject2);
  }
  
  public Comparator<? super E> comparator()
  {
    return comparator;
  }
  
  public ImmutableSortedSet<E> headSet(E paramE)
  {
    return headSet(paramE, false);
  }
  
  ImmutableSortedSet<E> headSet(E paramE, boolean paramBoolean)
  {
    return headSetImpl(Preconditions.checkNotNull(paramE), paramBoolean);
  }
  
  abstract ImmutableSortedSet<E> headSetImpl(E paramE, boolean paramBoolean);
  
  abstract int indexOf(Object paramObject);
  
  public abstract UnmodifiableIterator<E> iterator();
  
  public ImmutableSortedSet<E> subSet(E paramE1, E paramE2)
  {
    return subSet(paramE1, true, paramE2, false);
  }
  
  ImmutableSortedSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramE1);
    Preconditions.checkNotNull(paramE2);
    if (comparator.compare(paramE1, paramE2) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return subSetImpl(paramE1, paramBoolean1, paramE2, paramBoolean2);
    }
  }
  
  abstract ImmutableSortedSet<E> subSetImpl(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2);
  
  public ImmutableSortedSet<E> tailSet(E paramE)
  {
    return tailSet(paramE, true);
  }
  
  ImmutableSortedSet<E> tailSet(E paramE, boolean paramBoolean)
  {
    return tailSetImpl(Preconditions.checkNotNull(paramE), paramBoolean);
  }
  
  abstract ImmutableSortedSet<E> tailSetImpl(E paramE, boolean paramBoolean);
  
  int unsafeCompare(Object paramObject1, Object paramObject2)
  {
    return unsafeCompare(comparator, paramObject1, paramObject2);
  }
  
  Object writeReplace()
  {
    return new SerializedForm(comparator, toArray());
  }
  
  public static final class Builder<E>
    extends ImmutableSet.Builder<E>
  {
    private final Comparator<? super E> comparator;
    
    public Builder(Comparator<? super E> paramComparator)
    {
      comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
    }
    
    public Builder<E> add(E paramE)
    {
      super.add(paramE);
      return this;
    }
    
    public Builder<E> add(E... paramVarArgs)
    {
      super.add(paramVarArgs);
      return this;
    }
    
    public ImmutableSortedSet<E> build()
    {
      return ImmutableSortedSet.copyOfInternal(comparator, contents.iterator());
    }
  }
  
  private static class SerializedForm<E>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Comparator<? super E> comparator;
    final Object[] elements;
    
    public SerializedForm(Comparator<? super E> paramComparator, Object[] paramArrayOfObject)
    {
      comparator = paramComparator;
      elements = paramArrayOfObject;
    }
    
    Object readResolve()
    {
      return new ImmutableSortedSet.Builder(comparator).add((Object[])elements).build();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */