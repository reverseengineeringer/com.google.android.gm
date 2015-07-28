package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractBiMap$KeySet$1
  implements Iterator<K>
{
  Map.Entry<K, V> entry;
  
  AbstractBiMap$KeySet$1(AbstractBiMap.KeySet paramKeySet, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$iterator.hasNext();
  }
  
  public K next()
  {
    entry = ((Map.Entry)val$iterator.next());
    return (K)entry.getKey();
  }
  
  public void remove()
  {
    if (entry != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      Object localObject = entry.getValue();
      val$iterator.remove();
      AbstractBiMap.access$400(this$1.this$0, localObject);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.AbstractBiMap.KeySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */