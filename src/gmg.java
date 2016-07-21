import android.app.Application;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class gmg
  implements gjs
{
  gmg(gmf paramgmf, Application paramApplication) {}
  
  public final void a()
  {
    gkb.a(a).b(this);
    Object localObject = b;
    if (a.getAndSet(true)) {
      Log.w("OneTimeMetrics", "firstActivityCreated() was called more than once.");
    }
    for (;;)
    {
      return;
      localObject = b.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
}

/* Location:
 * Qualified Name:     gmg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */