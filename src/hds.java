import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

abstract class hds<E>
  extends hef<E>
{
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  abstract hdx<E> b();
  
  public boolean contains(Object paramObject)
  {
    return b().contains(paramObject);
  }
  
  final boolean e()
  {
    return b().e();
  }
  
  public boolean isEmpty()
  {
    return b().isEmpty();
  }
  
  public int size()
  {
    return b().size();
  }
  
  Object writeReplace()
  {
    return new hdt(b());
  }
}

/* Location:
 * Qualified Name:     hds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */