import android.content.ContentQueryMap;
import android.content.ContentValues;
import android.database.Cursor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

public final class dqc
  extends Observable
{
  private static final ContentValues c = new ContentValues(0);
  private long A;
  private long B;
  private long C;
  private long D;
  private Boolean E = null;
  ContentQueryMap a;
  boolean b = false;
  private Map<String, Long> d = new HashMap();
  private long e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private long o;
  private long p;
  private long q;
  private long r;
  private long s;
  private long t;
  private long u;
  private long v;
  private long w;
  private long x;
  private long y;
  private long z;
  
  public dqc(Cursor paramCursor)
  {
    a = new dqe(paramCursor, "_id");
    d.clear();
    a.addObserver(new dqd(this));
  }
  
  private final void r()
  {
    if (!a()) {
      throw new IllegalStateException("LabelMap not initialized");
    }
  }
  
  public final int a(long paramLong)
  {
    Integer localInteger = c(paramLong).getAsInteger("numUnreadConversations");
    if ((localInteger == null) || (localInteger.intValue() < 0)) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  @Deprecated
  public final long a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (b(paramString))
        {
          long l1 = ((Long)d.get(paramString)).longValue();
          return l1;
        }
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0)
        {
          paramString = "Unknown canonical name: ".concat(paramString);
          throw new IllegalArgumentException(paramString);
        }
      }
      finally {}
      paramString = new String("Unknown canonical name: ");
    }
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	dqc:E	Ljava/lang/Boolean;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 63	dqc:E	Ljava/lang/Boolean;
    //   13: invokevirtual 159	java/lang/Boolean:booleanValue	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	dqc
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public final String b(long paramLong)
  {
    return c(paramLong).getAsString("canonicalName");
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	dqc:E	Ljava/lang/Boolean;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	dqc
    //   12	7	1	bool	boolean
    //   6	2	2	localBoolean	Boolean
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final boolean b(String paramString)
  {
    try
    {
      boolean bool = d.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final ContentValues c(long paramLong)
  {
    if (b) {}
    for (ContentValues localContentValues = a.getValues(Long.toString(paramLong)); localContentValues != null; localContentValues = null) {
      return localContentValues;
    }
    return c;
  }
  
  final void c()
  {
    for (;;)
    {
      Object localObject2;
      long l1;
      boolean bool;
      try
      {
        b = true;
        d.clear();
        Iterator localIterator = a.getRows().entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        if (str == null) {
          continue;
        }
        l1 = Long.valueOf(str).longValue();
        localObject2 = ((ContentValues)((Map.Entry)localObject2).getValue()).getAsString("canonicalName");
        d.put(localObject2, Long.valueOf(l1));
        if ("^f".equals(localObject2))
        {
          e = l1;
          if ((e == 0L) || (f == 0L) || (g == 0L) || (h == 0L) || (i == 0L) || (j == 0L) || (k == 0L) || (l == 0L) || (m == 0L)) {
            break label701;
          }
          bool = true;
          E = Boolean.valueOf(bool);
          continue;
        }
        if (!"^i".equals(localObject2)) {
          break label250;
        }
      }
      finally {}
      f = l1;
      continue;
      label250:
      if ("^r".equals(localObject2))
      {
        g = l1;
      }
      else if ("^u".equals(localObject2))
      {
        h = l1;
      }
      else if ("^k".equals(localObject2))
      {
        i = l1;
      }
      else if ("^s".equals(localObject2))
      {
        j = l1;
      }
      else if ("^t".equals(localObject2))
      {
        k = l1;
      }
      else if ("^b".equals(localObject2))
      {
        l = l1;
      }
      else if ("^g".equals(localObject2))
      {
        m = l1;
      }
      else if ("^^cached".equals(localObject2))
      {
        n = l1;
      }
      else if ("^^out".equals(localObject2))
      {
        o = l1;
      }
      else if ("^io_im".equals(localObject2))
      {
        p = l1;
      }
      else if ("^^important".equals(localObject2))
      {
        q = l1;
      }
      else if ("^^unimportant".equals(localObject2))
      {
        r = l1;
      }
      else if ("^^sending".equals(localObject2))
      {
        s = l1;
      }
      else if ("^^failed".equals(localObject2))
      {
        t = l1;
      }
      else if ("^p_mtunsub".equals(localObject2))
      {
        u = l1;
      }
      else if ("^p_aunsub".equals(localObject2))
      {
        v = l1;
      }
      else if ("^punsub".equals(localObject2))
      {
        w = l1;
      }
      else if ("^p_abs".equals(localObject2))
      {
        x = l1;
      }
      else if ("^p_bs".equals(localObject2))
      {
        y = l1;
      }
      else if ("^sua".equals(localObject2))
      {
        z = l1;
      }
      else if ("^p_ag".equals(localObject2))
      {
        A = l1;
      }
      else if ("^p".equals(localObject2))
      {
        B = l1;
      }
      else if ("^sps".equals(localObject2))
      {
        C = l1;
      }
      else if ("^lcs".equals(localObject2))
      {
        D = l1;
        continue;
        label701:
        bool = false;
      }
    }
  }
  
  public final long d()
  {
    try
    {
      r();
      long l1 = e;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long e()
  {
    try
    {
      r();
      long l1 = f;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long f()
  {
    try
    {
      r();
      long l1 = g;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long g()
  {
    try
    {
      r();
      long l1 = h;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long h()
  {
    try
    {
      r();
      long l1 = i;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long i()
  {
    try
    {
      r();
      long l1 = j;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long j()
  {
    try
    {
      r();
      long l1 = k;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long k()
  {
    try
    {
      r();
      long l1 = m;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long l()
  {
    try
    {
      r();
      long l1 = n;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long m()
  {
    try
    {
      r();
      long l1 = o;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long n()
  {
    try
    {
      r();
      long l1 = p;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long o()
  {
    try
    {
      r();
      long l1 = s;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long p()
  {
    try
    {
      r();
      long l1 = t;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long q()
  {
    try
    {
      r();
      long l1 = z;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     dqc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */