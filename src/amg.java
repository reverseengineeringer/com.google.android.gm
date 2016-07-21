import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup;
import android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem;
import android.view.View;
import java.util.ArrayList;

public final class amg
{
  public ArrayList<View> a;
  public int b;
  public int c;
  public int d;
  public final int e;
  
  private final void f()
  {
    Object localObject = (View)a.get(0);
    amd localamd = (amd)((View)localObject).getLayoutParams();
    b = f.a.a((View)localObject);
    if (f)
    {
      localObject = f.g.d(a.c());
      if ((localObject != null) && (b == -1)) {
        b -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).a(e);
      }
    }
  }
  
  private final void g()
  {
    Object localObject = (View)a.get(a.size() - 1);
    amd localamd = (amd)((View)localObject).getLayoutParams();
    c = f.a.b((View)localObject);
    if (f)
    {
      localObject = f.g.d(a.c());
      if ((localObject != null) && (b == 1))
      {
        int i = c;
        c = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).a(e) + i);
      }
    }
  }
  
  public final int a()
  {
    if (b != Integer.MIN_VALUE) {
      return b;
    }
    f();
    return b;
  }
  
  public final int a(int paramInt)
  {
    if (b != Integer.MIN_VALUE) {
      paramInt = b;
    }
    while (a.size() == 0) {
      return paramInt;
    }
    f();
    return b;
  }
  
  public final View a(int paramInt1, int paramInt2)
  {
    View localView2 = null;
    View localView1 = null;
    int i;
    if (paramInt2 == -1)
    {
      i = a.size();
      paramInt2 = 0;
      if (paramInt2 < i)
      {
        localView2 = (View)a.get(paramInt2);
        if (localView2.isFocusable())
        {
          if (StaggeredGridLayoutManager.a(localView2) > paramInt1) {}
          for (int k = 1;; k = 0)
          {
            if (k != f.c) {
              break label88;
            }
            paramInt2 += 1;
            localView1 = localView2;
            break;
          }
        }
      }
      label88:
      return localView1;
    }
    paramInt2 = a.size() - 1;
    localView1 = localView2;
    if (paramInt2 >= 0)
    {
      localView2 = (View)a.get(paramInt2);
      if (localView2.isFocusable())
      {
        if (StaggeredGridLayoutManager.a(localView2) > paramInt1)
        {
          i = 1;
          label141:
          if (f.c) {
            break label176;
          }
        }
        label176:
        for (int j = 1;; j = 0)
        {
          if (i != j) {
            break label182;
          }
          paramInt2 -= 1;
          localView1 = localView2;
          break;
          i = 0;
          break label141;
        }
      }
    }
    label182:
    return localView1;
  }
  
  public final void a(View paramView)
  {
    amd localamd = (amd)paramView.getLayoutParams();
    e = this;
    a.add(0, paramView);
    b = Integer.MIN_VALUE;
    if (a.size() == 1) {
      c = Integer.MIN_VALUE;
    }
    if ((a.l()) || (a.r())) {
      d += f.a.c(paramView);
    }
  }
  
  public final int b()
  {
    if (c != Integer.MIN_VALUE) {
      return c;
    }
    g();
    return c;
  }
  
  public final int b(int paramInt)
  {
    if (c != Integer.MIN_VALUE) {
      paramInt = c;
    }
    while (a.size() == 0) {
      return paramInt;
    }
    g();
    return c;
  }
  
  public final void b(View paramView)
  {
    amd localamd = (amd)paramView.getLayoutParams();
    e = this;
    a.add(paramView);
    c = Integer.MIN_VALUE;
    if (a.size() == 1) {
      b = Integer.MIN_VALUE;
    }
    if ((a.l()) || (a.r())) {
      d += f.a.c(paramView);
    }
  }
  
  public final void c()
  {
    a.clear();
    b = Integer.MIN_VALUE;
    c = Integer.MIN_VALUE;
    d = 0;
  }
  
  public final void c(int paramInt)
  {
    b = paramInt;
    c = paramInt;
  }
  
  public final void d()
  {
    int i = a.size();
    View localView = (View)a.remove(i - 1);
    amd localamd = (amd)localView.getLayoutParams();
    e = null;
    if ((a.l()) || (a.r())) {
      d -= f.a.c(localView);
    }
    if (i == 1) {
      b = Integer.MIN_VALUE;
    }
    c = Integer.MIN_VALUE;
  }
  
  public final void d(int paramInt)
  {
    if (b != Integer.MIN_VALUE) {
      b += paramInt;
    }
    if (c != Integer.MIN_VALUE) {
      c += paramInt;
    }
  }
  
  public final void e()
  {
    View localView = (View)a.remove(0);
    amd localamd = (amd)localView.getLayoutParams();
    e = null;
    if (a.size() == 0) {
      c = Integer.MIN_VALUE;
    }
    if ((a.l()) || (a.r())) {
      d -= f.a.c(localView);
    }
    b = Integer.MIN_VALUE;
  }
}

/* Location:
 * Qualified Name:     amg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */