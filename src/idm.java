public final class idm
  extends RuntimeException
{
  private static final long serialVersionUID = 8486587136871052495L;
  public Throwable a = null;
  
  public idm() {}
  
  public idm(String paramString, Throwable paramThrowable)
  {
    super(paramString + " (Caused by " + paramThrowable + ")");
    a = paramThrowable;
  }
  
  public idm(Throwable paramThrowable)
  {
    this(paramThrowable.toString(), paramThrowable);
  }
  
  public final Throwable getCause()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     idm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */