import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class gh
  extends Transition.EpicenterCallback
{
  private Rect b;
  
  gh(gj paramgj) {}
  
  public final Rect onGetEpicenter(Transition paramTransition)
  {
    if ((b == null) && (a.a != null)) {
      b = ge.a(a.a);
    }
    return b;
  }
}

/* Location:
 * Qualified Name:     gh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */