import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public final class alk
  extends ol
{
  final RecyclerView a;
  public final ol c = new all(this);
  
  public alk(RecyclerView paramRecyclerView)
  {
    a = paramRecyclerView;
  }
  
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!a()))
    {
      paramView = (RecyclerView)paramView;
      if (j != null) {
        j.a(paramAccessibilityEvent);
      }
    }
  }
  
  public final void a(View paramView, uk paramuk)
  {
    super.a(paramView, paramuk);
    paramuk.b(RecyclerView.class.getName());
    if ((!a()) && (a.j != null))
    {
      paramView = a.j;
      ala localala = i.c;
      alg localalg = i.A;
      if ((rg.b(i, -1)) || (rg.a(i, -1)))
      {
        paramuk.a(8192);
        paramuk.h(true);
      }
      if ((rg.b(i, 1)) || (rg.a(i, 1)))
      {
        paramuk.a(4096);
        paramuk.h(true);
      }
      int i = paramView.b(localala, localalg);
      int j = paramView.c(localala, localalg);
      paramView = new uv(uk.a.a(i, j, false, 0));
      uk.a.c(b, a);
    }
  }
  
  final boolean a()
  {
    RecyclerView localRecyclerView = a;
    return (!o) || (s) || (d.c());
  }
  
  public final boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (super.a(paramView, paramInt, paramBundle)) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (a());
          bool1 = bool2;
        } while (a.j == null);
        paramView = a.j;
        paramBundle = i.c;
        paramBundle = i.A;
        bool1 = bool2;
      } while (i == null);
      switch (paramInt)
      {
      default: 
        paramInt = 0;
        i = 0;
        if (i != 0) {
          break label126;
        }
        bool1 = bool2;
      }
    } while (paramInt == 0);
    label126:
    i.scrollBy(paramInt, i);
    return true;
    if (rg.b(i, -1)) {}
    for (paramInt = -(r - paramView.k() - paramView.m());; paramInt = 0)
    {
      i = paramInt;
      int j;
      if (rg.a(i, -1))
      {
        j = -(q - paramView.j() - paramView.l());
        i = paramInt;
        paramInt = j;
        break;
        if (!rg.b(i, 1)) {
          break label283;
        }
      }
      label283:
      for (paramInt = r - paramView.k() - paramView.m();; paramInt = 0)
      {
        i = paramInt;
        if (rg.a(i, 1))
        {
          j = q;
          int k = paramView.j();
          int m = paramView.l();
          i = paramInt;
          paramInt = j - k - m;
          break;
        }
        paramInt = 0;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     alk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */