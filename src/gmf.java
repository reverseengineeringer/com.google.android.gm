import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class gmf
{
  final AtomicBoolean a = new AtomicBoolean(false);
  final List<gme> b;
  private final AtomicBoolean c = new AtomicBoolean(false);
  
  gmf(List<gme> paramList)
  {
    gol.a(paramList);
    b = new ArrayList(paramList);
  }
  
  final void a()
  {
    if (c.getAndSet(true)) {
      Log.w("OneTimeMetrics", "primesInitialized() was called more than once.");
    }
    for (;;)
    {
      return;
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        ((gme)localIterator.next()).b();
      }
    }
  }
}

/* Location:
 * Qualified Name:     gmf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */