package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map.Entry;

class AbstractBiMap$EntrySet$1$1
  extends ForwardingMapEntry<K, V>
{
  AbstractBiMap$EntrySet$1$1(AbstractBiMap.EntrySet.1 param1, Map.Entry paramEntry) {}
  
  protected Map.Entry<K, V> delegate()
  {
    return val$finalEntry;
  }
  
  public V setValue(V paramV)
  {
    Preconditions.checkState(this$2.this$1.contains(this), "entry no longer in map");
    if (Objects.equal(paramV, getValue())) {
      return paramV;
    }
    if (!this$2.this$1.this$0.containsValue(paramV)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "value already present: %s", new Object[] { paramV });
      Object localObject = val$finalEntry.setValue(paramV);
      Preconditions.checkState(Objects.equal(paramV, this$2.this$1.this$0.get(getKey())), "entry no longer in map");
      AbstractBiMap.access$800(this$2.this$1.this$0, getKey(), true, localObject, paramV);
      return (V)localObject;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.AbstractBiMap.EntrySet.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */