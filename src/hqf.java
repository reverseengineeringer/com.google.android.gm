import java.security.AccessController;
import sun.misc.Perf;

final class hqf
  implements hqa
{
  @Deprecated
  final Perf a = (Perf)AccessController.doPrivileged(new hqd(this));
  @Deprecated
  final long b;
  @Deprecated
  final long c;
  
  hqf()
  {
    long l1 = a.highResFrequency();
    long l2 = hqb.a(1000000000L, l1);
    b = (1000000000L / l2);
    c = (l1 / l2);
  }
}

/* Location:
 * Qualified Name:     hqf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */