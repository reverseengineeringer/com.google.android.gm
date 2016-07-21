final class gmb
  implements Runnable
{
  gmb(gma paramgma, Runnable paramRunnable) {}
  
  public final void run()
  {
    try
    {
      a.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.a(localThrowable);
      throw localThrowable;
    }
  }
}

/* Location:
 * Qualified Name:     gmb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */