import java.util.Arrays;

public final class hba
{
  private final String a;
  private final hbb b = new hbb();
  private hbb c = b;
  private boolean d = false;
  
  public hba(String paramString)
  {
    a = ((String)hbe.a(paramString));
  }
  
  public final hba a(String paramString, int paramInt)
  {
    return a(paramString, String.valueOf(paramInt));
  }
  
  public final hba a(String paramString, Object paramObject)
  {
    hbb localhbb = a();
    b = paramObject;
    a = ((String)hbe.a(paramString));
    return this;
  }
  
  public final hbb a()
  {
    hbb localhbb = new hbb();
    c.c = localhbb;
    c = localhbb;
    return localhbb;
  }
  
  public final String toString()
  {
    boolean bool = d;
    StringBuilder localStringBuilder = new StringBuilder(32).append(a).append('{');
    hbb localhbb = b.c;
    Object localObject1 = "";
    if (localhbb != null)
    {
      Object localObject3 = b;
      Object localObject2;
      if (bool)
      {
        localObject2 = localObject1;
        if (localObject3 == null) {}
      }
      else
      {
        localStringBuilder.append((String)localObject1);
        localObject2 = ", ";
        if (a != null) {
          localStringBuilder.append(a).append('=');
        }
        if ((localObject3 == null) || (!localObject3.getClass().isArray())) {
          break label148;
        }
        localObject1 = Arrays.deepToString(new Object[] { localObject3 });
        localStringBuilder.append((CharSequence)localObject1, 1, ((String)localObject1).length() - 1);
      }
      for (;;)
      {
        localhbb = c;
        localObject1 = localObject2;
        break;
        label148:
        localStringBuilder.append(localObject3);
      }
    }
    return '}';
  }
}

/* Location:
 * Qualified Name:     hba
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */