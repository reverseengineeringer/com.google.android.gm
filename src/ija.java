import java.io.IOException;

final class ija
  extends iiy
  implements AutoCloseable
{
  private final AutoCloseable b;
  
  ija(Appendable paramAppendable, iib<? super IOException> paramiib, iib<? super String> paramiib1)
  {
    super(paramAppendable, paramiib, paramiib1, (byte)0);
    b = ((AutoCloseable)paramAppendable);
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
 * Qualified Name:     ija
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */