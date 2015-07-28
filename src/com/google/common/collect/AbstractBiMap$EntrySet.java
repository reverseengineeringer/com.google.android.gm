package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractBiMap$EntrySet
  extends ForwardingSet<Map.Entry<K, V>>
{
  final Set<Map.Entry<K, V>> esDelegate = AbstractBiMap.access$200(this$0).entrySet();
  
  private AbstractBiMap$EntrySet(AbstractBiMap paramAbstractBiMap) {}
  
  public void clear()
  {
    this$0.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return Maps.containsEntryImpl(delegate(), paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return standardContainsAll(paramCollection);
  }
  
  protected Set<Map.Entry<K, V>> delegate()
  {
    return esDelegate;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    new Iterator()
    {
      Map.Entry<K, V> entry;
      
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
          
          public V setValue(V paramAnonymous2V)
          {
            Preconditions.checkState(contains(this), "entry no longer in map");
            if (Objects.equal(paramAnonymous2V, getValue())) {
              return paramAnonymous2V;
            }
            if (!this$0.containsValue(paramAnonymous2V)) {}
            for (boolean bool = true;; bool = false)
            {
              Preconditions.checkArgument(bool, "value already present: %s", new Object[] { paramAnonymous2V });
              Object localObject = val$finalEntry.setValue(paramAnonymous2V);
              Preconditions.checkState(Objects.equal(paramAnonymous2V, this$0.get(getKey())), "entry no longer in map");
              AbstractBiMap.access$800(this$0, getKey(), true, localObject, paramAnonymous2V);
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
          AbstractBiMap.access$400(this$0, localObject);
          return;
        }
      }
    };
  }
  
  public boolean remove(Object paramObject)
  {
    if (!esDelegate.contains(paramObject)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    AbstractBiMap.access$200(AbstractBiMap.access$600(this$0)).remove(((Map.Entry)paramObject).getValue());
    esDelegate.remove(paramObject);
    return true;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return standardRemoveAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return standardRetainAll(paramCollection);
  }
  
  public Object[] toArray()
  {
    return standardToArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return standardToArray(paramArrayOfT);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.AbstractBiMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */