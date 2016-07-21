import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class adj
{
  public final ArrayList<tg> a = new ArrayList();
  tw b;
  boolean c;
  private long d = -1L;
  private Interpolator e;
  private final tx f = new adk(this);
  
  public final adj a(Interpolator paramInterpolator)
  {
    if (!c) {
      e = paramInterpolator;
    }
    return this;
  }
  
  public final adj a(tg paramtg)
  {
    if (!c) {
      a.add(paramtg);
    }
    return this;
  }
  
  public final adj a(tw paramtw)
  {
    if (!c) {
      b = paramtw;
    }
    return this;
  }
  
  public final void a()
  {
    if (c) {
      return;
    }
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      tg localtg = (tg)localIterator.next();
      if (d >= 0L) {
        localtg.a(d);
      }
      if (e != null) {
        localtg.a(e);
      }
      if (b != null) {
        localtg.a(f);
      }
      localtg.b();
    }
    c = true;
  }
  
  public final void b()
  {
    if (!c) {
      return;
    }
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((tg)localIterator.next()).a();
    }
    c = false;
  }
  
  public final adj c()
  {
    if (!c) {
      d = 250L;
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     adj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */