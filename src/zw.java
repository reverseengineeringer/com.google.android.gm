import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class zw
  implements AbsListView.OnScrollListener
{
  zw(zs paramzs, View paramView1, View paramView2) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    View localView1 = a;
    View localView2 = b;
    if (localView1 != null)
    {
      if (rg.b(paramAbsListView, -1))
      {
        paramInt1 = 0;
        localView1.setVisibility(paramInt1);
      }
    }
    else if (localView2 != null) {
      if (!rg.b(paramAbsListView, 1)) {
        break label62;
      }
    }
    label62:
    for (paramInt1 = paramInt2;; paramInt1 = 4)
    {
      localView2.setVisibility(paramInt1);
      return;
      paramInt1 = 4;
      break;
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}

/* Location:
 * Qualified Name:     zw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */