import java.io.Serializable;

final class hdt
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final hdx<?> a;
  
  hdt(hdx<?> paramhdx)
  {
    a = paramhdx;
  }
  
  final Object readResolve()
  {
    return a.f();
  }
}

/* Location:
 * Qualified Name:     hdt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */