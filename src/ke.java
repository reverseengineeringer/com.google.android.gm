import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

final class ke
  extends kk<Params, Result>
{
  ke(kc paramkc) {}
  
  public final Result call()
  {
    a.g.set(true);
    Process.setThreadPriority(10);
    return (Result)a.c(a.a());
  }
}

/* Location:
 * Qualified Name:     ke
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */