final class eif
{
  private int a = 0;
  
  public final void a()
  {
    try
    {
      a += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b()
  {
    try
    {
      if (a == 0) {
        throw new RuntimeException("too many decrements");
      }
    }
    finally {}
    a -= 1;
    if (a == 0) {
      notifyAll();
    }
  }
}

/* Location:
 * Qualified Name:     eif
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */