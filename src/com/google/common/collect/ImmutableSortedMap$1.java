package com.google.common.collect;

import java.util.Comparator;
import java.util.Map.Entry;

final class ImmutableSortedMap$1
  implements Comparator<Map.Entry<K, V>>
{
  ImmutableSortedMap$1(Comparator paramComparator) {}
  
  public int compare(Map.Entry<K, V> paramEntry1, Map.Entry<K, V> paramEntry2)
  {
    return val$comparator.compare(paramEntry1.getKey(), paramEntry2.getKey());
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */