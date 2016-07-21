import android.database.Observable;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public final class cjd
  extends Observable<wm>
  implements cmz
{
  protected cjd(cht paramcht) {}
  
  public final void a(int paramInt)
  {
    Iterator localIterator = mObservers.iterator();
    while (localIterator.hasNext()) {
      ((wm)localIterator.next()).a(paramInt);
    }
  }
  
  public final void a(View paramView)
  {
    Iterator localIterator = mObservers.iterator();
    while (localIterator.hasNext()) {
      ((wm)localIterator.next()).a(paramView);
    }
  }
  
  public final void a(View paramView, float paramFloat)
  {
    Iterator localIterator = mObservers.iterator();
    while (localIterator.hasNext()) {
      ((wm)localIterator.next()).a(paramView, paramFloat);
    }
  }
  
  public final void a(wm paramwm)
  {
    registerObserver(paramwm);
  }
  
  public final boolean a()
  {
    return a.ah();
  }
  
  public final void b(View paramView)
  {
    Iterator localIterator = mObservers.iterator();
    while (localIterator.hasNext()) {
      ((wm)localIterator.next()).b(paramView);
    }
  }
  
  public final void b(wm paramwm)
  {
    unregisterObserver(paramwm);
  }
}

/* Location:
 * Qualified Name:     cjd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */