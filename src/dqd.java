import java.util.Observable;
import java.util.Observer;

final class dqd
  implements Observer
{
  dqd(dqc paramdqc) {}
  
  public final void update(Observable paramObservable, Object paramObject)
  {
    a.c();
    dqc.a(a);
    a.notifyObservers();
  }
}

/* Location:
 * Qualified Name:     dqd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */