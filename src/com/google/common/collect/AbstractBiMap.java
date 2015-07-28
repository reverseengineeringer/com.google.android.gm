package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class AbstractBiMap<K, V>
  extends ForwardingMap<K, V>
  implements BiMap<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  private transient Map<K, V> delegate;
  private transient Set<Map.Entry<K, V>> entrySet;
  private transient AbstractBiMap<V, K> inverse;
  private transient Set<K> keySet;
  private transient Set<V> valueSet;
  
  private AbstractBiMap(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap)
  {
    delegate = paramMap;
    inverse = paramAbstractBiMap;
  }
  
  AbstractBiMap(Map<K, V> paramMap, Map<V, K> paramMap1)
  {
    setDelegates(paramMap, paramMap1);
  }
  
  private V putInBothMaps(K paramK, V paramV, boolean paramBoolean)
  {
    boolean bool = containsKey(paramK);
    if ((bool) && (Objects.equal(paramV, get(paramK)))) {
      return paramV;
    }
    if (paramBoolean)
    {
      inverse().remove(paramV);
      Object localObject = delegate.put(paramK, paramV);
      updateInverseMap(paramK, bool, localObject, paramV);
      return (V)localObject;
    }
    if (!containsValue(paramV)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Preconditions.checkArgument(paramBoolean, "value already present: %s", new Object[] { paramV });
      break;
    }
  }
  
  private V removeFromBothMaps(Object paramObject)
  {
    paramObject = delegate.remove(paramObject);
    removeFromInverseMap(paramObject);
    return (V)paramObject;
  }
  
  private void removeFromInverseMap(V paramV)
  {
    inverse.delegate.remove(paramV);
  }
  
  private void updateInverseMap(K paramK, boolean paramBoolean, V paramV1, V paramV2)
  {
    if (paramBoolean) {
      removeFromInverseMap(paramV1);
    }
    inverse.delegate.put(paramV2, paramK);
  }
  
  public void clear()
  {
    delegate.clear();
    inverse.delegate.clear();
  }
  
  public boolean containsValue(Object paramObject)
  {
    return inverse.containsKey(paramObject);
  }
  
  protected Map<K, V> delegate()
  {
    return delegate;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet = entrySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new EntrySet(null);
      entrySet = ((Set)localObject);
    }
    return (Set<Map.Entry<K, V>>)localObject;
  }
  
  public BiMap<V, K> inverse()
  {
    return inverse;
  }
  
  public Set<K> keySet()
  {
    Set localSet = keySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new KeySet(null);
      keySet = ((Set)localObject);
    }
    return (Set<K>)localObject;
  }
  
  public V put(K paramK, V paramV)
  {
    return (V)putInBothMaps(paramK, paramV, false);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public V remove(Object paramObject)
  {
    if (containsKey(paramObject)) {
      return (V)removeFromBothMaps(paramObject);
    }
    return null;
  }
  
  void setDelegates(Map<K, V> paramMap, Map<V, K> paramMap1)
  {
    boolean bool2 = true;
    if (delegate == null)
    {
      bool1 = true;
      Preconditions.checkState(bool1);
      if (inverse != null) {
        break label84;
      }
      bool1 = true;
      label25:
      Preconditions.checkState(bool1);
      Preconditions.checkArgument(paramMap.isEmpty());
      Preconditions.checkArgument(paramMap1.isEmpty());
      if (paramMap == paramMap1) {
        break label89;
      }
    }
    label84:
    label89:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      delegate = paramMap;
      inverse = new Inverse(paramMap1, this, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label25;
    }
  }
  
  void setInverse(AbstractBiMap<V, K> paramAbstractBiMap)
  {
    inverse = paramAbstractBiMap;
  }
  
  public Set<V> values()
  {
    Set localSet = valueSet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new ValueSet(null);
      valueSet = ((Set)localObject);
    }
    return (Set<V>)localObject;
  }
  
  private class EntrySet
    extends ForwardingSet<Map.Entry<K, V>>
  {
    final Set<Map.Entry<K, V>> esDelegate = delegate.entrySet();
    
    private EntrySet() {}
    
    public void clear()
    {
      AbstractBiMap.this.clear();
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
              if (!containsValue(paramAnonymous2V)) {}
              for (boolean bool = true;; bool = false)
              {
                Preconditions.checkArgument(bool, "value already present: %s", new Object[] { paramAnonymous2V });
                Object localObject = val$finalEntry.setValue(paramAnonymous2V);
                Preconditions.checkState(Objects.equal(paramAnonymous2V, get(getKey())), "entry no longer in map");
                AbstractBiMap.this.updateInverseMap(getKey(), true, localObject, paramAnonymous2V);
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
            AbstractBiMap.this.removeFromInverseMap(localObject);
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
      access$600delegate.remove(((Map.Entry)paramObject).getValue());
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
  
  private static class Inverse<K, V>
    extends AbstractBiMap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    private Inverse(Map<K, V> paramMap, AbstractBiMap<V, K> paramAbstractBiMap)
    {
      super(paramAbstractBiMap, null);
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      paramObjectInputStream.defaultReadObject();
      setInverse((AbstractBiMap)paramObjectInputStream.readObject());
    }
    
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.defaultWriteObject();
      paramObjectOutputStream.writeObject(inverse());
    }
    
    Object readResolve()
    {
      return inverse().inverse();
    }
  }
  
  private class KeySet
    extends ForwardingSet<K>
  {
    private KeySet() {}
    
    public void clear()
    {
      AbstractBiMap.this.clear();
    }
    
    protected Set<K> delegate()
    {
      return delegate.keySet();
    }
    
    public Iterator<K> iterator()
    {
      new Iterator()
      {
        Map.Entry<K, V> entry;
        
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
            AbstractBiMap.this.removeFromInverseMap(localObject);
            return;
          }
        }
      };
    }
    
    public boolean remove(Object paramObject)
    {
      if (!contains(paramObject)) {
        return false;
      }
      AbstractBiMap.this.removeFromBothMaps(paramObject);
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
  }
  
  private class ValueSet
    extends ForwardingSet<V>
  {
    final Set<V> valuesDelegate = inverse.keySet();
    
    private ValueSet() {}
    
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
          AbstractBiMap.this.removeFromInverseMap(valueToRemove);
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
}

/* Location:
 * Qualified Name:     com.google.common.collect.AbstractBiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */