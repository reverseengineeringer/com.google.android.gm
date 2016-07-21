import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class cvn<K, V>
  extends LinkedHashMap<K, V>
{
  private static final long serialVersionUID = 1L;
  private final int a;
  
  public cvn(int paramInt)
  {
    this(paramInt, paramInt);
  }
  
  private cvn(int paramInt1, int paramInt2)
  {
    super(paramInt1, 0.75F, true);
    a = paramInt2;
  }
  
  public final void a(K paramK, V paramV)
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
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
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
  protected final boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 69	cvn:size	()I
    //   6: istore_2
    //   7: aload_0
    //   8: getfield 23	cvn:a	I
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
    //   0	36	0	this	cvn
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
 * Qualified Name:     cvn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */