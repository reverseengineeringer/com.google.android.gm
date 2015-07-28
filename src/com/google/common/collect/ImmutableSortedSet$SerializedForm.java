package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

class ImmutableSortedSet$SerializedForm<E>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Comparator<? super E> comparator;
  final Object[] elements;
  
  public ImmutableSortedSet$SerializedForm(Comparator<? super E> paramComparator, Object[] paramArrayOfObject)
  {
    comparator = paramComparator;
    elements = paramArrayOfObject;
  }
  
  Object readResolve()
  {
    return new ImmutableSortedSet.Builder(comparator).add((Object[])elements).build();
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedSet.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */