import java.io.Serializable;
import java.util.EnumSet;

final class hee<E extends Enum<E>>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final EnumSet<E> a;
  
  hee(EnumSet<E> paramEnumSet)
  {
    a = paramEnumSet;
  }
  
  final Object readResolve()
  {
    return new hed(a.clone());
  }
}

/* Location:
 * Qualified Name:     hee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */