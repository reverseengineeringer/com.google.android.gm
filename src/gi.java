import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class gi
  implements ViewTreeObserver.OnPreDrawListener
{
  gi(View paramView1, Transition paramTransition1, ArrayList paramArrayList1, Transition paramTransition2, ArrayList paramArrayList2, Transition paramTransition3, ArrayList paramArrayList3, Map paramMap, ArrayList paramArrayList4, Transition paramTransition4, View paramView2) {}
  
  public final boolean onPreDraw()
  {
    a.getViewTreeObserver().removeOnPreDrawListener(this);
    if (b != null) {
      ge.a(b, c);
    }
    if (d != null) {
      ge.a(d, e);
    }
    if (f != null) {
      ge.a(f, g);
    }
    Iterator localIterator = h.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((View)localEntry.getValue()).setTransitionName((String)localEntry.getKey());
    }
    int n = i.size();
    int m = 0;
    while (m < n)
    {
      j.excludeTarget((View)i.get(m), false);
      m += 1;
    }
    j.excludeTarget(k, false);
    return true;
  }
}

/* Location:
 * Qualified Name:     gi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */