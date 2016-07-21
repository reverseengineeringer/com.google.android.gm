import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class eki
  implements ekt
{
  private final ekj a;
  
  public eki(ekj paramekj)
  {
    a = paramekj;
  }
  
  public final <A extends eit, R extends ejk, T extends ejq<R, A>> T a(T paramT)
  {
    a.f.add(paramT);
    return paramT;
  }
  
  public final void a()
  {
    Iterator localIterator = a.m.values().iterator();
    while (localIterator.hasNext()) {
      ((eit)localIterator.next()).c();
    }
    a.o = Collections.emptySet();
  }
  
  public final void a(int paramInt) {}
  
  public final void a(Bundle paramBundle) {}
  
  public final void a(ConnectionResult paramConnectionResult, eip<?> parameip, int paramInt) {}
  
  public final <A extends eit, T extends ejq<? extends ejk, A>> T b(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final void b()
  {
    Iterator localIterator = a.f.iterator();
    while (localIterator.hasNext()) {
      ((eks)localIterator.next()).b();
    }
    a.f.clear();
    a.n.clear();
    a.g();
  }
  
  public final void c()
  {
    ekj localekj = a;
    a.lock();
    try
    {
      s = new eju(localekj, p, q, k, r, a, d);
      s.a();
      b.signalAll();
      return;
    }
    finally
    {
      a.unlock();
    }
  }
  
  public final String d()
  {
    return "DISCONNECTED";
  }
}

/* Location:
 * Qualified Name:     eki
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */