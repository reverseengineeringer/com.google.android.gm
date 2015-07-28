package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Comparator;

public class ImmutableSortedMap$Builder<K, V>
  extends ImmutableMap.Builder<K, V>
{
  private final Comparator<? super K> comparator;
  
  public ImmutableSortedMap$Builder(Comparator<? super K> paramComparator)
  {
    comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
  }
  
  public ImmutableSortedMap<K, V> build()
  {
    ImmutableSortedMap.access$000(entries, comparator);
    ImmutableSortedMap.access$100(entries, comparator);
    return new ImmutableSortedMap(ImmutableList.copyOf(entries), comparator);
  }
  
  public Builder<K, V> put(K paramK, V paramV)
  {
    entries.add(ImmutableMap.entryOf(paramK, paramV));
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */