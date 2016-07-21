import java.security.SecureRandom;

final class ioc
  implements Runnable
{
  public final void run()
  {
    iob.c.nextInt();
    iob.b();
  }
}

/* Location:
 * Qualified Name:     ioc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */