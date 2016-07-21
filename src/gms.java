import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

final class gms
  implements gmt
{
  public final Reference<Object> a(Object paramObject, ReferenceQueue<Object> paramReferenceQueue)
  {
    return new PhantomReference(paramObject, paramReferenceQueue);
  }
}

/* Location:
 * Qualified Name:     gms
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */