public final class bhb
{
  private static boolean a = false;
  
  public static void a()
  {
    try
    {
      cvm.b(cvm.a, "migration started", new Object[0]);
      a = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void b()
  {
    try
    {
      cvm.b(cvm.a, "migration finished", new Object[0]);
      a = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     bhb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */