import java.util.Map.Entry;

final class gtv
  implements Map.Entry<String, Object>
{
  private Object b;
  private final gtz c;
  
  gtv(gtu paramgtu, gtz paramgtz, Object paramObject)
  {
    c = paramgtz;
    b = hbe.a(paramObject);
  }
  
  private final String a()
  {
    String str2 = c.c;
    String str1 = str2;
    if (a.b.b) {
      str1 = str2.toLowerCase();
    }
    return str1;
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
    } while ((a().equals(((Map.Entry)paramObject).getKey())) && (getValue().equals(((Map.Entry)paramObject).getValue())));
    return false;
  }
  
  public final Object getValue()
  {
    return b;
  }
  
  public final int hashCode()
  {
    return a().hashCode() ^ getValue().hashCode();
  }
  
  public final Object setValue(Object paramObject)
  {
    Object localObject = b;
    b = hbe.a(paramObject);
    c.a(a.a, paramObject);
    return localObject;
  }
}

/* Location:
 * Qualified Name:     gtv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */