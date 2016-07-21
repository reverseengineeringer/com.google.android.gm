import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

public final class akn
  implements aht
{
  public akn(RecyclerView paramRecyclerView) {}
  
  public final int a()
  {
    return a.getChildCount();
  }
  
  public final int a(View paramView)
  {
    return a.indexOfChild(paramView);
  }
  
  public final void a(int paramInt)
  {
    View localView = a.getChildAt(paramInt);
    if (localView != null) {
      a.e(localView);
    }
    a.removeViewAt(paramInt);
  }
  
  public final void a(View paramView, int paramInt)
  {
    a.addView(paramView, paramInt);
    RecyclerView localRecyclerView = a;
    RecyclerView.b(paramView);
    if (r != null)
    {
      paramInt = r.size() - 1;
      while (paramInt >= 0)
      {
        r.get(paramInt);
        paramInt -= 1;
      }
    }
  }
  
  public final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    alj localalj = RecyclerView.b(paramView);
    if (localalj != null)
    {
      if ((!localalj.m()) && (!localalj.b())) {
        throw new IllegalArgumentException("Called attach on a child which is not detached: " + localalj);
      }
      localalj.h();
    }
    RecyclerView.a(a, paramView, paramInt, paramLayoutParams);
  }
  
  public final alj b(View paramView)
  {
    return RecyclerView.b(paramView);
  }
  
  public final View b(int paramInt)
  {
    return a.getChildAt(paramInt);
  }
  
  public final void b()
  {
    int j = a.getChildCount();
    int i = 0;
    while (i < j)
    {
      a.e(b(i));
      i += 1;
    }
    a.removeAllViews();
  }
  
  public final void c(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject != null)
    {
      localObject = RecyclerView.b((View)localObject);
      if (localObject != null)
      {
        if ((((alj)localObject).m()) && (!((alj)localObject).b())) {
          throw new IllegalArgumentException("called detach on an already detached child " + localObject);
        }
        ((alj)localObject).b(256);
      }
    }
    RecyclerView.a(a, paramInt);
  }
  
  public final void c(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    if (paramView != null)
    {
      n = rg.d(a);
      rg.c(a, 4);
    }
  }
  
  public final void d(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    if (paramView != null)
    {
      rg.c(a, n);
      n = 0;
    }
  }
}

/* Location:
 * Qualified Name:     akn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */