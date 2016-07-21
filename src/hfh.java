import java.io.Serializable;

final class hfh
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Object[] a;
  
  hfh(Object[] paramArrayOfObject)
  {
    a = paramArrayOfObject;
  }
  
  final Object readResolve()
  {
    return hfd.a(a);
  }
}

/* Location:
 * Qualified Name:     hfh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */