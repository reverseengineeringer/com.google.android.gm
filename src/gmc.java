import java.util.concurrent.Callable;

final class gmc
  implements Callable<V>
{
  gmc(gma paramgma, Callable paramCallable) {}
  
  public final V call()
  {
    try
    {
      Object localObject = a.call();
      return (V)localObject;
    }
    catch (Throwable localThrowable)
    {
      b.a.a(localThrowable);
      throw localThrowable;
    }
  }
}

/* Location:
 * Qualified Name:     gmc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */