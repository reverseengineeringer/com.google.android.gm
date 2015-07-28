package com.google.common.collect;

import java.io.Serializable;

class ImmutableSortedMap$ValuesSerializedForm<V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final ImmutableSortedMap<?, V> map;
  
  ImmutableSortedMap$ValuesSerializedForm(ImmutableSortedMap<?, V> paramImmutableSortedMap)
  {
    map = paramImmutableSortedMap;
  }
  
  Object readResolve()
  {
    return map.values();
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.ValuesSerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */