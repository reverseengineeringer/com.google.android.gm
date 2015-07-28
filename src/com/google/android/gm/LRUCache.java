package com.google.android.gm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LRUCache<K, V>
  extends LinkedHashMap<K, V>
{
  private static final long serialVersionUID = 1L;
  private final int maxCapacity;
  
  public LRUCache(int paramInt)
  {
    this(paramInt, paramInt);
  }
  
  public LRUCache(int paramInt1, int paramInt2)
  {
    super(paramInt1, 0.75F, true);
    maxCapacity = paramInt2;
  }
  
  public void addElement(K paramK, V paramV)
  {
    try
    {
      put(paramK, paramV);
      return;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public int getCapacity()
  {
    return maxCapacity;
  }
  
  public V getElement(K paramK)
  {
    try
    {
      paramK = get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        put(localEntry.getKey(), localEntry.getValue());
      }
    }
    finally {}
  }
  
  /* Error */
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 77	com/google/android/gm/LRUCache:size	()I
    //   6: istore_2
    //   7: aload_0
    //   8: getfield 23	com/google/android/gm/LRUCache:maxCapacity	I
    //   11: istore_3
    //   12: iload_2
    //   13: iload_3
    //   14: if_icmple +11 -> 25
    //   17: iconst_1
    //   18: istore 4
    //   20: aload_0
    //   21: monitorexit
    //   22: iload 4
    //   24: ireturn
    //   25: iconst_0
    //   26: istore 4
    //   28: goto -8 -> 20
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	LRUCache
    //   0	36	1	paramEntry	Map.Entry<K, V>
    //   6	9	2	i	int
    //   11	4	3	j	int
    //   18	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	31	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LRUCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */