package com.google.common.collect;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class Maps
{
  static final Joiner.MapJoiner STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
  
  static int capacity(int paramInt)
  {
    if (paramInt < 3)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        return paramInt + 1;
      }
    }
    if (paramInt < 1073741824) {
      return paramInt / 3 + paramInt;
    }
    return Integer.MAX_VALUE;
  }
  
  static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> paramCollection, Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    return paramCollection.contains(unmodifiableEntry((Map.Entry)paramObject));
  }
  
  public static <K, V> Map.Entry<K, V> immutableEntry(K paramK, V paramV)
  {
    return new ImmutableEntry(paramK, paramV);
  }
  
  public static <K, V> HashMap<K, V> newHashMap()
  {
    return new HashMap();
  }
  
  public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> paramMap)
  {
    return new HashMap(paramMap);
  }
  
  public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int paramInt)
  {
    return new HashMap(capacity(paramInt));
  }
  
  public static <K, V> LinkedHashMap<K, V> newLinkedHashMap()
  {
    return new LinkedHashMap();
  }
  
  static String toStringImpl(Map<?, ?> paramMap)
  {
    StringBuilder localStringBuilder = Collections2.newStringBuilderForCollection(paramMap.size()).append('{');
    STANDARD_JOINER.appendTo(localStringBuilder, paramMap);
    return '}';
  }
  
  static <K, V> Map.Entry<K, V> unmodifiableEntry(Map.Entry<K, V> paramEntry)
  {
    Preconditions.checkNotNull(paramEntry);
    new AbstractMapEntry()
    {
      public K getKey()
      {
        return (K)val$entry.getKey();
      }
      
      public V getValue()
      {
        return (V)val$entry.getValue();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.Maps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */