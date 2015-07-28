package com.google.common.collect;

import java.util.Map.Entry;

public abstract class ForwardingMapEntry<K, V>
  extends ForwardingObject
  implements Map.Entry<K, V>
{
  protected abstract Map.Entry<K, V> delegate();
  
  public boolean equals(Object paramObject)
  {
    return delegate().equals(paramObject);
  }
  
  public K getKey()
  {
    return (K)delegate().getKey();
  }
  
  public V getValue()
  {
    return (V)delegate().getValue();
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public V setValue(V paramV)
  {
    return (V)delegate().setValue(paramV);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ForwardingMapEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */