package com.android.mail.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Deque;
import java.util.Map;

public class DequeMap<K, V>
{
  private final Map<K, Deque<V>> mMap = Maps.newHashMap();
  
  public void add(K paramK, V paramV)
  {
    Deque localDeque = (Deque)mMap.get(paramK);
    Object localObject = localDeque;
    if (localDeque == null)
    {
      localObject = Lists.newLinkedList();
      mMap.put(paramK, localObject);
    }
    ((Deque)localObject).add(paramV);
  }
  
  public V peek(K paramK)
  {
    paramK = (Deque)mMap.get(paramK);
    if (paramK == null) {
      return null;
    }
    return (V)paramK.peek();
  }
  
  public V poll(K paramK)
  {
    paramK = (Deque)mMap.get(paramK);
    if (paramK == null) {
      return null;
    }
    return (V)paramK.poll();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.DequeMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */