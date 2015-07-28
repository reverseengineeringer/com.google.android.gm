package com.google.common.collect;

import java.io.Serializable;
import java.util.Set;

class Synchronized$SynchronizedBiMap<K, V>
  extends Synchronized.SynchronizedMap<K, V>
  implements BiMap<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  private transient BiMap<V, K> inverse;
  private transient Set<V> valueSet;
  
  private Synchronized$SynchronizedBiMap(BiMap<K, V> paramBiMap, Object paramObject, BiMap<V, K> paramBiMap1)
  {
    super(paramBiMap, paramObject);
    inverse = paramBiMap1;
  }
  
  BiMap<K, V> delegate()
  {
    return (BiMap)super.delegate();
  }
  
  public BiMap<V, K> inverse()
  {
    synchronized (mutex)
    {
      if (inverse == null) {
        inverse = new SynchronizedBiMap(delegate().inverse(), mutex, this);
      }
      BiMap localBiMap = inverse;
      return localBiMap;
    }
  }
  
  public Set<V> values()
  {
    synchronized (mutex)
    {
      if (valueSet == null) {
        valueSet = Synchronized.set(delegate().values(), mutex);
      }
      Set localSet = valueSet;
      return localSet;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedBiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */