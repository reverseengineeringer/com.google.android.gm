import android.os.Handler;
import java.util.concurrent.atomic.AtomicInteger;

public final class dgq
{
  private final Handler a = new Handler();
  private boolean b = true;
  private AtomicInteger c = new AtomicInteger(0);
  
  public final void a(boolean paramBoolean)
  {
    b = paramBoolean;
    if (!b)
    {
      int i = c.getAndSet(0);
      if (i > 0) {
        dri.e(dri.a, "Disable UiHandler. Dropping %d Runnables.", new Object[] { Integer.valueOf(i) });
      }
      a.removeCallbacksAndMessages(null);
    }
  }
}

/* Location:
 * Qualified Name:     dgq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */