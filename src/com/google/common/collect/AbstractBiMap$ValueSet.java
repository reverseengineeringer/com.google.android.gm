package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class AbstractBiMap$ValueSet
  extends ForwardingSet<V>
{
  final Set<V> valuesDelegate = AbstractBiMap.access$600(this$0).keySet();
  
  private AbstractBiMap$ValueSet(AbstractBiMap paramAbstractBiMap) {}
  
  protected Set<V> delegate()
  {
    return valuesDelegate;
  }
  
  public Iterator<V> iterator()
  {
    new Iterator()
    {
      V valueToRemove;
      
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
        AbstractBiMap.access$400(this$0, valueToRemove);
      }
    };
  }
  
  public Object[] toArray()
  {
    return standardToArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return standardToArray(paramArrayOfT);
  }
  
  public String toString()
  {
    return standardToString();
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.AbstractBiMap.ValueSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */