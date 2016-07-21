import java.io.Serializable;

final class hej
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Object[] a;
  
  hej(Object[] paramArrayOfObject)
  {
    a = paramArrayOfObject;
  }
  
  final Object readResolve()
  {
    return hef.a(a);
  }
}

/* Location:
 * Qualified Name:     hej
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */