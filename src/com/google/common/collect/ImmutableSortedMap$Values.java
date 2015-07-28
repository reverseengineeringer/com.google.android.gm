package com.google.common.collect;

class ImmutableSortedMap$Values<V>
  extends ImmutableCollection<V>
{
  private final ImmutableSortedMap<?, V> map;
  
  ImmutableSortedMap$Values(ImmutableSortedMap<?, V> paramImmutableSortedMap)
  {
    map = paramImmutableSortedMap;
  }
  
  public boolean contains(Object paramObject)
  {
    return map.containsValue(paramObject);
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public UnmodifiableIterator<V> iterator()
  {
    return map.valueIterator();
  }
  
  public int size()
  {
    return map.size();
  }
  
  Object writeReplace()
  {
    return new ImmutableSortedMap.ValuesSerializedForm(map);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.Values
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */