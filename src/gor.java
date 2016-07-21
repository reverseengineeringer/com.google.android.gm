import java.util.Set;

public final class gor
{
  final String a;
  private final int b;
  private final Set<String> c;
  
  public gor(String paramString)
  {
    this(paramString, 0, null);
  }
  
  public gor(String paramString, int paramInt, Set<String> paramSet)
  {
    hbe.a(paramString, "Attribute name can not be null");
    int i;
    if (paramSet == null)
    {
      i = 1;
      if (paramInt != 3) {
        break label58;
      }
    }
    for (;;)
    {
      hbe.a(j ^ i, "Only ENUM_TYPE can have values != null");
      a = paramString;
      b = paramInt;
      c = paramSet;
      return;
      i = 0;
      break;
      label58:
      j = 0;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof gor))
    {
      paramObject = (gor)paramObject;
      return a.equals(a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return a.hashCode();
  }
  
  public final String toString()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     gor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */