import java.io.IOException;

public final class hlo<M extends hln<M>, T>
{
  public final int a;
  public final Class<T> b;
  public final int c;
  public final boolean d;
  
  protected final int a(Object paramObject)
  {
    int i = c >>> 3;
    switch (a)
    {
    default: 
      i = a;
      throw new IllegalArgumentException(24 + "Unknown type " + i);
    case 10: 
      return hll.c(i, (hlt)paramObject);
    }
    return hll.d(i, (hlt)paramObject);
  }
  
  protected final void a(Object paramObject, hll paramhll)
  {
    for (;;)
    {
      try
      {
        paramhll.c(c);
        switch (a)
        {
        case 10: 
          i = a;
          throw new IllegalArgumentException(24 + "Unknown type " + i);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (hlt)paramObject;
      int i = c;
      ((hlt)paramObject).a(paramhll);
      paramhll.e(i >>> 3, 4);
      return;
      paramhll.a((hlt)paramObject);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof hlo)) {
        return false;
      }
      paramObject = (hlo)paramObject;
    } while ((a == a) && (b == b) && (c == c) && (d == d));
    return false;
  }
  
  public final int hashCode()
  {
    int j = a;
    int k = b.hashCode();
    int m = c;
    if (d) {}
    for (int i = 1;; i = 0) {
      return i + (((j + 1147) * 31 + k) * 31 + m) * 31;
    }
  }
}

/* Location:
 * Qualified Name:     hlo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */