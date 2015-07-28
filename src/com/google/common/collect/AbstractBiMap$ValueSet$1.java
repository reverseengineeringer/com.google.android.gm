package com.google.common.collect;

import java.util.Iterator;

class AbstractBiMap$ValueSet$1
  implements Iterator<V>
{
  V valueToRemove;
  
  AbstractBiMap$ValueSet$1(AbstractBiMap.ValueSet paramValueSet, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$iterator.hasNext();
  }
  
  public V next()
  {
    Object localObject = val$iterator.next();
    valueToRemove = localObject;
    return (V)localObject;
  }
  
  public void remove()
  {
    val$iterator.remove();
    AbstractBiMap.access$400(this$1.this$0, valueToRemove);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.AbstractBiMap.ValueSet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */