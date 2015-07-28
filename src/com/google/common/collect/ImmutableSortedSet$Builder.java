package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Comparator;

public final class ImmutableSortedSet$Builder<E>
  extends ImmutableSet.Builder<E>
{
  private final Comparator<? super E> comparator;
  
  public ImmutableSortedSet$Builder(Comparator<? super E> paramComparator)
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
    return ImmutableSortedSet.access$000(comparator, contents.iterator());
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedSet.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */