import java.io.Closeable;
import java.io.IOException;

final class ijb
  extends iiy
  implements Closeable
{
  private final Closeable b;
  
  ijb(Appendable paramAppendable, iib<? super IOException> paramiib, iib<? super String> paramiib1)
  {
    super(paramAppendable, paramiib, paramiib1, (byte)0);
    b = ((Closeable)paramAppendable);
  }
  
  public final void close()
  {
    if (a) {
      b();
    }
    b.close();
  }
}

/* Location:
 * Qualified Name:     ijb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */