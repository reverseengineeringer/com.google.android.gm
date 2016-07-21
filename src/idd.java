import java.io.InputStream;

public final class idd
  extends ide
{
  private long a;
  
  public idd(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public final long a()
  {
    try
    {
      long l = a;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected final void a(int paramInt)
  {
    if (paramInt != -1) {}
    try
    {
      a += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long skip(long paramLong)
  {
    try
    {
      paramLong = super.skip(paramLong);
      a += paramLong;
      return paramLong;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     idd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */