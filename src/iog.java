import java.io.IOException;

public class iog
  extends IOException
{
  public iog() {}
  
  public iog(String paramString)
  {
    super(paramString);
  }
  
  public iog(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    initCause(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     iog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */