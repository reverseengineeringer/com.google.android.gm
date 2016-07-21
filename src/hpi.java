import java.util.Map.Entry;

public class hpi
  implements Map.Entry
{
  @Deprecated
  private final Object a;
  @Deprecated
  private Object b;
  
  public hpi(Object paramObject1, Object paramObject2)
  {
    a = paramObject1;
    b = paramObject2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    label38:
    label83:
    label85:
    label90:
    label97:
    for (;;)
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      Object localObject1 = a;
      Object localObject2 = ((Map.Entry)paramObject).getKey();
      boolean bool;
      if (localObject1 == null) {
        if (localObject2 == null)
        {
          bool = true;
          if (!bool) {
            break label83;
          }
          localObject1 = b;
          paramObject = ((Map.Entry)paramObject).getValue();
          if (localObject1 != null) {
            break label90;
          }
          if (paramObject != null) {
            break label85;
          }
          bool = true;
        }
      }
      for (;;)
      {
        if (!bool) {
          break label97;
        }
        return true;
        bool = false;
        break label38;
        bool = localObject1.equals(localObject2);
        break label38;
        break;
        bool = false;
        continue;
        bool = localObject1.equals(paramObject);
      }
    }
  }
  
  public Object getKey()
  {
    return a;
  }
  
  public Object getValue()
  {
    return b;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (a == null)
    {
      i = 0;
      if (b != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = a.hashCode();
      break;
      label33:
      j = b.hashCode();
    }
  }
  
  public Object setValue(Object paramObject)
  {
    Object localObject = b;
    b = paramObject;
    return localObject;
  }
  
  public String toString()
  {
    return a + "=" + b;
  }
}

/* Location:
 * Qualified Name:     hpi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */