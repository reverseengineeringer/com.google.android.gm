import java.util.AbstractSet;
import java.util.Collection;

abstract class hip<E>
  extends AbstractSet<E>
{
  public boolean removeAll(Collection<?> paramCollection)
  {
    return hio.a(this, paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return super.retainAll((Collection)hbe.a(paramCollection));
  }
}

/* Location:
 * Qualified Name:     hip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */