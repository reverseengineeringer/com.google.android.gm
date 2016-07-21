import java.io.Serializable;

public final class hau
  extends has<Object>
  implements Serializable
{
  public static final hau a = new hau();
  private static final long serialVersionUID = 1L;
  
  private final Object readResolve()
  {
    return a;
  }
  
  protected final int a(Object paramObject)
  {
    return System.identityHashCode(paramObject);
  }
  
  protected final boolean b(Object paramObject1, Object paramObject2)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     hau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */