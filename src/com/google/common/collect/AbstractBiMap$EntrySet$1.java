package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractBiMap$EntrySet$1
  implements Iterator<Map.Entry<K, V>>
{
  Map.Entry<K, V> entry;
  
  AbstractBiMap$EntrySet$1(AbstractBiMap.EntrySet paramEntrySet, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$iterator.hasNext();
  }
  
  public Map.Entry<K, V> next()
  {
    entry = ((Map.Entry)val$iterator.next());
    new ForwardingMapEntry()
    {
      protected Map.Entry<K, V> delegate()
      {
        return val$finalEntry;
      }
      
      public V setValue(V paramAnonymousV)
      {
        Preconditions.checkState(this$1.contains(this), "entry no longer in map");
        if (Objects.equal(paramAnonymousV, getValue())) {
          return paramAnonymousV;
        }
        if (!this$1.this$0.containsValue(paramAnonymousV)) {}
        for (boolean bool = true;; bool = false)
        {
          Preconditions.checkArgument(bool, "value already present: %s", new Object[] { paramAnonymousV });
          Object localObject = val$finalEntry.setValue(paramAnonymousV);
          Preconditions.checkState(Objects.equal(paramAnonymousV, this$1.this$0.get(getKey())), "entry no longer in map");
          AbstractBiMap.access$800(this$1.this$0, getKey(), true, localObject, paramAnonymousV);
          return (V)localObject;
        }
      }
    };
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
 * Qualified Name:     com.google.common.collect.AbstractBiMap.EntrySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */