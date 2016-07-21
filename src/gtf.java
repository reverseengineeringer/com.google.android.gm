import java.util.Map.Entry;

final class gtf
  implements Map.Entry<K, V>
{
  private int b;
  
  gtf(gte paramgte, int paramInt)
  {
    b = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
    } while ((hbc.a(getKey(), ((Map.Entry)paramObject).getKey())) && (hbc.a(getValue(), ((Map.Entry)paramObject).getValue())));
    return false;
  }
  
  public final K getKey()
  {
    gte localgte = a;
    int i = b;
    if ((i < 0) || (i >= a)) {
      return null;
    }
    return (K)b[(i << 1)];
  }
  
  public final V getValue()
  {
    return (V)a.a(b);
  }
  
  public final int hashCode()
  {
    return getKey().hashCode() ^ getValue().hashCode();
  }
  
  public final V setValue(V paramV)
  {
    return (V)a.a(b, paramV);
  }
}

/* Location:
 * Qualified Name:     gtf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */