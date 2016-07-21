import java.io.Serializable;

public final class hat
  extends has<Object>
  implements Serializable
{
  public static final hat a = new hat();
  private static final long serialVersionUID = 1L;
  
  private final Object readResolve()
  {
    return a;
  }
  
  protected final int a(Object paramObject)
  {
    return paramObject.hashCode();
  }
  
  protected final boolean b(Object paramObject1, Object paramObject2)
  {
    return paramObject1.equals(paramObject2);
  }
}

/* Location:
 * Qualified Name:     hat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */