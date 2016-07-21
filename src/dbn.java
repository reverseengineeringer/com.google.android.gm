import java.util.HashMap;
import java.util.Map;

final class dbn
{
  private Map<String, String> a = new HashMap();
  private Map<String, String> b = new HashMap();
  
  public final void a()
  {
    try
    {
      a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      a.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public final void a(Map<String, String> paramMap, Boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokevirtual 37	java/lang/Boolean:booleanValue	()Z
    //   6: ifeq +16 -> 22
    //   9: aload_0
    //   10: getfield 17	dbn:a	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 41 2 0
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 19	dbn:b	Ljava/util/Map;
    //   26: aload_1
    //   27: invokeinterface 41 2 0
    //   32: goto -13 -> 19
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	dbn
    //   0	40	1	paramMap	Map<String, String>
    //   0	40	2	paramBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	35	finally
    //   22	32	35	finally
  }
  
  public final Map<String, String> b()
  {
    try
    {
      HashMap localHashMap = new HashMap(b);
      localHashMap.putAll(a);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    try
    {
      b.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}

/* Location:
 * Qualified Name:     dbn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */