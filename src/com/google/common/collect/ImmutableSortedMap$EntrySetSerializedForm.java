package com.google.common.collect;

import java.io.Serializable;

class ImmutableSortedMap$EntrySetSerializedForm<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final ImmutableSortedMap<K, V> map;
  
  ImmutableSortedMap$EntrySetSerializedForm(ImmutableSortedMap<K, V> paramImmutableSortedMap)
  {
    map = paramImmutableSortedMap;
  }
  
  Object readResolve()
  {
    return map.entrySet();
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.EntrySetSerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */