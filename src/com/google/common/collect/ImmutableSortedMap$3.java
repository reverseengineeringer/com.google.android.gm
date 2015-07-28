package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableSortedMap$3
  extends UnmodifiableIterator<V>
{
  ImmutableSortedMap$3(ImmutableSortedMap paramImmutableSortedMap, UnmodifiableIterator paramUnmodifiableIterator) {}
  
  public boolean hasNext()
  {
    return val$entryIterator.hasNext();
  }
  
  public V next()
  {
    return (V)((Map.Entry)val$entryIterator.next()).getValue();
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */