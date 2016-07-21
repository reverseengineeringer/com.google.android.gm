import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import java.util.List;

public final class af
  implements ViewGroup.OnHierarchyChangeListener
{
  public af(CoordinatorLayout paramCoordinatorLayout) {}
  
  public final void onChildViewAdded(View paramView1, View paramView2)
  {
    if (a.l != null) {
      a.l.onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public final void onChildViewRemoved(View paramView1, View paramView2)
  {
    CoordinatorLayout localCoordinatorLayout = a;
    int k = g.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = (View)g.get(j);
      if (localView == paramView2) {
        i = 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (i != 0)
        {
          ag localag = (ag)localView.getLayoutParams();
          ad localad = a;
          if ((localad != null) && (localag.a(localCoordinatorLayout, localView, paramView2))) {
            localad.c(localCoordinatorLayout, localView, paramView2);
          }
        }
      }
    }
    if (a.l != null) {
      a.l.onChildViewRemoved(paramView1, paramView2);
    }
  }
}

/* Location:
 * Qualified Name:     af
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */