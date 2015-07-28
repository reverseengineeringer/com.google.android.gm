package com.google.common.collect;

import java.util.Map;
import java.util.Set;

public abstract interface BiMap<K, V>
  extends Map<K, V>
{
  public abstract BiMap<V, K> inverse();
  
  public abstract V put(K paramK, V paramV);
  
  public abstract Set<V> values();
}

/* Location:
 * Qualified Name:     com.google.common.collect.BiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */