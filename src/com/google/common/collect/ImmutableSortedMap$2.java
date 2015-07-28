package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableSortedMap$2
  extends TransformedImmutableList<Map.Entry<K, V>, K>
{
  ImmutableSortedMap$2(ImmutableSortedMap paramImmutableSortedMap, ImmutableList paramImmutableList)
  {
    super(paramImmutableList);
  }
  
  K transform(Map.Entry<K, V> paramEntry)
  {
    return (K)paramEntry.getKey();
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */