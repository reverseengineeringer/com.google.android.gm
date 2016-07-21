import java.security.PrivilegedAction;
import sun.misc.Perf;

final class hqd
  implements PrivilegedAction
{
  hqd(hqf paramhqf) {}
  
  public final Object run()
  {
    return Perf.getPerf();
  }
}

/* Location:
 * Qualified Name:     hqd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */