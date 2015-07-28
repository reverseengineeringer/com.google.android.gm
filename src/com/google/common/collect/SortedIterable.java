package com.google.common.collect;

import java.util.Comparator;

abstract interface SortedIterable<T>
  extends Iterable<T>
{
  public abstract Comparator<? super T> comparator();
}

/* Location:
 * Qualified Name:     com.google.common.collect.SortedIterable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */