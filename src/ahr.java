import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public final class ahr
{
  public final aht a;
  public final ahs b;
  public final List<View> c;
  
  public ahr(aht paramaht)
  {
    a = paramaht;
    b = new ahs();
    c = new ArrayList();
  }
  
  public final int a()
  {
    return a.a() - c.size();
  }
  
  final int a(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = a.a();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - b.e(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!b.c(i)) {
            break;
          }
          i += 1;
        }
      }
      i += k;
    }
    label72:
    return -1;
  }
  
  public final void a(View paramView)
  {
    c.add(paramView);
    a.c(paramView);
  }
  
  public final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = a.a();; paramInt = a(paramInt))
    {
      b.a(paramInt, paramBoolean);
      if (paramBoolean) {
        a(paramView);
      }
      a.a(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = a.a();; paramInt = a(paramInt))
    {
      b.a(paramInt, paramBoolean);
      if (paramBoolean) {
        a(paramView);
      }
      a.a(paramView, paramInt);
      return;
    }
  }
  
  public final int b()
  {
    return a.a();
  }
  
  public final View b(int paramInt)
  {
    paramInt = a(paramInt);
    return a.b(paramInt);
  }
  
  final boolean b(View paramView)
  {
    if (c.remove(paramView))
    {
      a.d(paramView);
      return true;
    }
    return false;
  }
  
  final int c(View paramView)
  {
    int i = a.a(paramView);
    if (i == -1) {}
    while (b.c(i)) {
      return -1;
    }
    return i - b.e(i);
  }
  
  public final View c(int paramInt)
  {
    return a.b(paramInt);
  }
  
  final void d(int paramInt)
  {
    paramInt = a(paramInt);
    b.d(paramInt);
    a.c(paramInt);
  }
  
  public final boolean d(View paramView)
  {
    return c.contains(paramView);
  }
  
  public final String toString()
  {
    return b.toString() + ", hidden list:" + c.size();
  }
}

/* Location:
 * Qualified Name:     ahr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */