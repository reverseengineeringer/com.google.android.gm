package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableSortedMap$EntrySet<K, V>
  extends ImmutableSet<Map.Entry<K, V>>
{
  final transient ImmutableSortedMap<K, V> map;
  
  ImmutableSortedMap$EntrySet(ImmutableSortedMap<K, V> paramImmutableSortedMap)
  {
    map = paramImmutableSortedMap;
  }
  
  public boolean contains(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      Object localObject = map.get(((Map.Entry)paramObject).getKey());
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localObject.equals(((Map.Entry)paramObject).getValue())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  boolean isPartialView()
  {
    return map.isPartialView();
  }
  
  public UnmodifiableIterator<Map.Entry<K, V>> iterator()
  {
    return map.entries.iterator();
  }
  
  public int size()
  {
    return map.size();
  }
  
  Object writeReplace()
  {
    return new ImmutableSortedMap.EntrySetSerializedForm(map);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */