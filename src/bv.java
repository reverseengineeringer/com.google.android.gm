import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public final class bv
{
  private static bv d;
  public final Object a = new Object();
  public by b;
  public by c;
  private final Handler e = new Handler(Looper.getMainLooper(), new bw(this));
  
  public static bv a()
  {
    if (d == null) {
      d = new bv();
    }
    return d;
  }
  
  public final void a(bx parambx)
  {
    synchronized (a)
    {
      if (d(parambx)) {
        e.removeCallbacksAndMessages(b);
      }
      return;
    }
  }
  
  final boolean a(by paramby)
  {
    if ((bx)a.get() != null)
    {
      e.removeCallbacksAndMessages(paramby);
      return true;
    }
    return false;
  }
  
  public final void b(bx parambx)
  {
    synchronized (a)
    {
      if (d(parambx)) {
        b(b);
      }
      return;
    }
  }
  
  public final void b(by paramby)
  {
    if (b == -2) {
      return;
    }
    int i = 2750;
    if (b > 0) {
      i = b;
    }
    for (;;)
    {
      e.removeCallbacksAndMessages(paramby);
      e.sendMessageDelayed(Message.obtain(e, 0, paramby), i);
      return;
      if (b == -1) {
        i = 1500;
      }
    }
  }
  
  public final boolean c(bx parambx)
  {
    for (;;)
    {
      synchronized (a)
      {
        if (!d(parambx))
        {
          if (!e(parambx)) {
            break label40;
          }
          break label35;
          return bool;
        }
      }
      label35:
      boolean bool = true;
      continue;
      label40:
      bool = false;
    }
  }
  
  public final boolean d(bx parambx)
  {
    return (b != null) && (b.a(parambx));
  }
  
  final boolean e(bx parambx)
  {
    return (c != null) && (c.a(parambx));
  }
}

/* Location:
 * Qualified Name:     bv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */