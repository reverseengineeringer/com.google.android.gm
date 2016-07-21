import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class adp
  implements aej
{
  public Context a;
  public Context b;
  public adu c;
  public LayoutInflater d;
  public LayoutInflater e;
  public aek f;
  public ael g;
  public int h;
  private int i;
  private int j;
  
  public adp(Context paramContext, int paramInt1, int paramInt2)
  {
    a = paramContext;
    d = LayoutInflater.from(paramContext);
    i = paramInt1;
    j = paramInt2;
  }
  
  public ael a(ViewGroup paramViewGroup)
  {
    if (g == null)
    {
      g = ((ael)d.inflate(i, paramViewGroup, false));
      g.a(c);
      b(true);
    }
    return g;
  }
  
  public View a(ady paramady, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof aem)) {}
    for (paramView = (aem)paramView;; paramView = (aem)d.inflate(j, paramViewGroup, false))
    {
      a(paramady, paramView);
      return (View)paramView;
    }
  }
  
  public void a(adu paramadu, boolean paramBoolean)
  {
    if (f != null) {
      f.a(paramadu, paramBoolean);
    }
  }
  
  public abstract void a(ady paramady, aem paramaem);
  
  public void a(Context paramContext, adu paramadu)
  {
    b = paramContext;
    e = LayoutInflater.from(b);
    c = paramadu;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(ady paramady)
  {
    return true;
  }
  
  public boolean a(aep paramaep)
  {
    if (f != null) {
      return f.a_(paramaep);
    }
    return false;
  }
  
  public boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public final int b()
  {
    return h;
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)g;
    if (localViewGroup == null) {}
    label230:
    label236:
    for (;;)
    {
      return;
      int m;
      if (c != null)
      {
        c.i();
        ArrayList localArrayList = c.h();
        int i1 = localArrayList.size();
        int n = 0;
        int k = 0;
        m = k;
        if (n < i1)
        {
          ady localady = (ady)localArrayList.get(n);
          if (!a(localady)) {
            break label230;
          }
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof aem)) {}
          for (Object localObject = ((aem)localView1).a();; localObject = null)
          {
            View localView2 = a(localady, localView1, localViewGroup);
            if (localady != localObject)
            {
              localView2.setPressed(false);
              rg.a.A(localView2);
            }
            if (localView2 != localView1)
            {
              localObject = (ViewGroup)localView2.getParent();
              if (localObject != null) {
                ((ViewGroup)localObject).removeView(localView2);
              }
              ((ViewGroup)g).addView(localView2, k);
            }
            k += 1;
            n += 1;
            break;
          }
        }
      }
      for (;;)
      {
        if (m >= localViewGroup.getChildCount()) {
          break label236;
        }
        if (!a(localViewGroup, m))
        {
          m += 1;
          continue;
          break;
          m = 0;
        }
      }
    }
  }
  
  public final boolean b(ady paramady)
  {
    return false;
  }
  
  public final boolean c(ady paramady)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     adp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */