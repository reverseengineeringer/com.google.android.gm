package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.SortedMap;

public class ImmutableSortedMap<K, V>
  extends ImmutableSortedMapFauxverideShim<K, V>
  implements SortedMap<K, V>
{
  private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableList.of(), NATURAL_ORDER);
  private static final Comparator<Comparable> NATURAL_ORDER = ;
  private static final long serialVersionUID = 0L;
  private final transient Comparator<? super K> comparator;
  final transient ImmutableList<Map.Entry<K, V>> entries;
  private transient ImmutableSet<Map.Entry<K, V>> entrySet;
  private transient ImmutableSortedSet<K> keySet;
  private transient ImmutableCollection<V> values;
  
  ImmutableSortedMap(ImmutableList<Map.Entry<K, V>> paramImmutableList, Comparator<? super K> paramComparator)
  {
    entries = paramImmutableList;
    comparator = paramComparator;
  }
  
  private ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    if (isEmpty()) {
      return ImmutableSet.of();
    }
    return new EntrySet(this);
  }
  
  private ImmutableSortedSet<K> createKeySet()
  {
    if (isEmpty()) {
      return ImmutableSortedSet.emptySet(comparator);
    }
    new RegularImmutableSortedSet(new TransformedImmutableList(entries)
    {
      K transform(Map.Entry<K, V> paramAnonymousEntry)
      {
        return (K)paramAnonymousEntry.getKey();
      }
    }, comparator);
  }
  
  private ImmutableSortedMap<K, V> createSubmap(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return new ImmutableSortedMap(entries.subList(paramInt1, paramInt2), comparator);
    }
    return emptyMap(comparator);
  }
  
  private static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> paramComparator)
  {
    if (NATURAL_ORDER.equals(paramComparator)) {
      return NATURAL_EMPTY_MAP;
    }
    return new ImmutableSortedMap(ImmutableList.of(), paramComparator);
  }
  
  private int index(Object paramObject, SortedLists.KeyPresentBehavior paramKeyPresentBehavior, SortedLists.KeyAbsentBehavior paramKeyAbsentBehavior)
  {
    return SortedLists.binarySearch(keyList(), Preconditions.checkNotNull(paramObject), unsafeComparator(), paramKeyPresentBehavior, paramKeyAbsentBehavior);
  }
  
  private ImmutableList<K> keyList()
  {
    new TransformedImmutableList(entries)
    {
      K transform(Map.Entry<K, V> paramAnonymousEntry)
      {
        return (K)paramAnonymousEntry.getKey();
      }
    };
  }
  
  private static <K, V> void sortEntries(List<Map.Entry<K, V>> paramList, Comparator<? super K> paramComparator)
  {
    Collections.sort(paramList, new Comparator()
    {
      public int compare(Map.Entry<K, V> paramAnonymousEntry1, Map.Entry<K, V> paramAnonymousEntry2)
      {
        return val$comparator.compare(paramAnonymousEntry1.getKey(), paramAnonymousEntry2.getKey());
      }
    });
  }
  
  private static <K, V> void validateEntries(List<Map.Entry<K, V>> paramList, Comparator<? super K> paramComparator)
  {
    int i = 1;
    while (i < paramList.size())
    {
      if (paramComparator.compare(((Map.Entry)paramList.get(i - 1)).getKey(), ((Map.Entry)paramList.get(i)).getKey()) == 0) {
        throw new IllegalArgumentException("Duplicate keys in mappings " + paramList.get(i - 1) + " and " + paramList.get(i));
      }
      i += 1;
    }
  }
  
  public Comparator<? super K> comparator()
  {
    return comparator;
  }
  
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    return Iterators.contains(valueIterator(), paramObject);
  }
  
  public ImmutableSet<Map.Entry<K, V>> entrySet()
  {
    ImmutableSet localImmutableSet2 = entrySet;
    ImmutableSet localImmutableSet1 = localImmutableSet2;
    if (localImmutableSet2 == null)
    {
      localImmutableSet1 = createEntrySet();
      entrySet = localImmutableSet1;
    }
    return localImmutableSet1;
  }
  
  public K firstKey()
  {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return (K)((Map.Entry)entries.get(0)).getKey();
  }
  
  public V get(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        int i = index(paramObject, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
        if (i >= 0) {
          return (V)((Map.Entry)entries.get(i)).getValue();
        }
      }
      catch (ClassCastException paramObject) {}
    }
    return null;
  }
  
  public ImmutableSortedMap<K, V> headMap(K paramK)
  {
    return headMap(paramK, false);
  }
  
  ImmutableSortedMap<K, V> headMap(K paramK, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = index(paramK, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER) + 1;; i = index(paramK, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER)) {
      return createSubmap(0, i);
    }
  }
  
  boolean isPartialView()
  {
    return entries.isPartialView();
  }
  
  public ImmutableSortedSet<K> keySet()
  {
    ImmutableSortedSet localImmutableSortedSet2 = keySet;
    ImmutableSortedSet localImmutableSortedSet1 = localImmutableSortedSet2;
    if (localImmutableSortedSet2 == null)
    {
      localImmutableSortedSet1 = createKeySet();
      keySet = localImmutableSortedSet1;
    }
    return localImmutableSortedSet1;
  }
  
  public K lastKey()
  {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return (K)((Map.Entry)entries.get(size() - 1)).getKey();
  }
  
  public int size()
  {
    return entries.size();
  }
  
  public ImmutableSortedMap<K, V> subMap(K paramK1, K paramK2)
  {
    return subMap(paramK1, true, paramK2, false);
  }
  
  ImmutableSortedMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramK1);
    Preconditions.checkNotNull(paramK2);
    if (comparator.compare(paramK1, paramK2) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return tailMap(paramK1, paramBoolean1).headMap(paramK2, paramBoolean2);
    }
  }
  
  public ImmutableSortedMap<K, V> tailMap(K paramK)
  {
    return tailMap(paramK, true);
  }
  
  ImmutableSortedMap<K, V> tailMap(K paramK, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = index(paramK, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);; i = index(paramK, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER) + 1) {
      return createSubmap(i, size());
    }
  }
  
  Comparator<Object> unsafeComparator()
  {
    return comparator;
  }
  
  UnmodifiableIterator<V> valueIterator()
  {
    new UnmodifiableIterator()
    {
      public boolean hasNext()
      {
        return val$entryIterator.hasNext();
      }
      
      public V next()
      {
        return (V)((Map.Entry)val$entryIterator.next()).getValue();
      }
    };
  }
  
  public ImmutableCollection<V> values()
  {
    ImmutableCollection localImmutableCollection = values;
    Object localObject = localImmutableCollection;
    if (localImmutableCollection == null)
    {
      localObject = new Values(this);
      values = ((ImmutableCollection)localObject);
    }
    return (ImmutableCollection<V>)localObject;
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this);
  }
  
  public static class Builder<K, V>
    extends ImmutableMap.Builder<K, V>
  {
    private final Comparator<? super K> comparator;
    
    public Builder(Comparator<? super K> paramComparator)
    {
      comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
    }
    
    public ImmutableSortedMap<K, V> build()
    {
      ImmutableSortedMap.sortEntries(entries, comparator);
      ImmutableSortedMap.validateEntries(entries, comparator);
      return new ImmutableSortedMap(ImmutableList.copyOf(entries), comparator);
    }
    
    public Builder<K, V> put(K paramK, V paramV)
    {
      entries.add(ImmutableMap.entryOf(paramK, paramV));
      return this;
    }
  }
  
  private static class EntrySet<K, V>
    extends ImmutableSet<Map.Entry<K, V>>
  {
    final transient ImmutableSortedMap<K, V> map;
    
    EntrySet(ImmutableSortedMap<K, V> paramImmutableSortedMap)
    {
      map = paramImmutableSortedMap;
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        Object localObject = map.get(((Map.Entry)paramObject).getKey());
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (localObject.equals(((Map.Entry)paramObject).getValue())) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    boolean isPartialView()
    {
      return map.isPartialView();
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> iterator()
    {
      return map.entries.iterator();
    }
    
    public int size()
    {
      return map.size();
    }
    
    Object writeReplace()
    {
      return new ImmutableSortedMap.EntrySetSerializedForm(map);
    }
  }
  
  private static class EntrySetSerializedForm<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableSortedMap<K, V> map;
    
    EntrySetSerializedForm(ImmutableSortedMap<K, V> paramImmutableSortedMap)
    {
      map = paramImmutableSortedMap;
    }
    
    Object readResolve()
    {
      return map.entrySet();
    }
  }
  
  private static class SerializedForm
    extends ImmutableMap.SerializedForm
  {
    private static final long serialVersionUID = 0L;
    private final Comparator<Object> comparator;
    
    SerializedForm(ImmutableSortedMap<?, ?> paramImmutableSortedMap)
    {
      super();
      comparator = paramImmutableSortedMap.comparator();
    }
    
    Object readResolve()
    {
      return createMap(new ImmutableSortedMap.Builder(comparator));
    }
  }
  
  private static class Values<V>
    extends ImmutableCollection<V>
  {
    private final ImmutableSortedMap<?, V> map;
    
    Values(ImmutableSortedMap<?, V> paramImmutableSortedMap)
    {
      map = paramImmutableSortedMap;
    }
    
    public boolean contains(Object paramObject)
    {
      return map.containsValue(paramObject);
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public UnmodifiableIterator<V> iterator()
    {
      return map.valueIterator();
    }
    
    public int size()
    {
      return map.size();
    }
    
    Object writeReplace()
    {
      return new ImmutableSortedMap.ValuesSerializedForm(map);
    }
  }
  
  private static class ValuesSerializedForm<V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableSortedMap<?, V> map;
    
    ValuesSerializedForm(ImmutableSortedMap<?, V> paramImmutableSortedMap)
    {
      map = paramImmutableSortedMap;
    }
    
    Object readResolve()
    {
      return map.values();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */