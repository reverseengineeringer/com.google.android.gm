import java.security.PrivilegedAction;

final class hqc
  implements PrivilegedAction
{
  public final Object run()
  {
    return System.getProperty("edu.emory.mathcs.backport.java.util.concurrent.NanoTimerProvider");
  }
}

/* Location:
 * Qualified Name:     hqc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */