import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;

public final class ako
  implements agc
{
  public ako(RecyclerView paramRecyclerView) {}
  
  private final void c(agd paramagd)
  {
    switch (a)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      a.j.c(b, d);
      return;
    case 2: 
      a.j.d(b, d);
      return;
    case 4: 
      a.j.e(b, d);
      return;
    }
    a.j.f(b, d);
  }
  
  public final alj a(int paramInt)
  {
    RecyclerView localRecyclerView = a;
    int j = e.b();
    int i = 0;
    alj localalj;
    if (i < j)
    {
      localalj = RecyclerView.b(e.c(i));
      if ((localalj != null) && (!localalj.l()) && (b == paramInt)) {
        label58:
        if (localalj != null) {
          break label78;
        }
      }
    }
    label78:
    while (a.e.d(a))
    {
      return null;
      i += 1;
      break;
      localalj = null;
      break label58;
    }
    return localalj;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    a.a(paramInt1, paramInt2, true);
    a.B = true;
    alg localalg = a.A;
    e += paramInt2;
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = a;
    int j = e.b();
    int i = 0;
    while (i < j)
    {
      View localView = e.c(i);
      alj localalj = RecyclerView.b(localView);
      if ((localalj != null) && (!localalj.b()) && (b >= paramInt1) && (b < paramInt1 + paramInt2))
      {
        localalj.b(2);
        localalj.a(paramObject);
        getLayoutParamsc = true;
      }
      i += 1;
    }
    paramObject = c;
    i = c.size() - 1;
    while (i >= 0)
    {
      localObject = (alj)c.get(i);
      if (localObject != null)
      {
        j = ((alj)localObject).c();
        if ((j >= paramInt1) && (j < paramInt1 + paramInt2))
        {
          ((alj)localObject).b(2);
          ((ala)paramObject).a(i);
        }
      }
      i -= 1;
    }
    a.C = true;
  }
  
  public final void a(agd paramagd)
  {
    c(paramagd);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    a.a(paramInt1, paramInt2, false);
    a.B = true;
  }
  
  public final void b(agd paramagd)
  {
    c(paramagd);
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = a;
    int j = e.b();
    int i = 0;
    while (i < j)
    {
      localObject = RecyclerView.b(e.c(i));
      if ((localObject != null) && (!((alj)localObject).b()) && (b >= paramInt1))
      {
        ((alj)localObject).a(paramInt2, false);
        A.f = true;
      }
      i += 1;
    }
    Object localObject = c;
    j = c.size();
    i = 0;
    while (i < j)
    {
      alj localalj = (alj)c.get(i);
      if ((localalj != null) && (b >= paramInt1)) {
        localalj.a(paramInt2, true);
      }
      i += 1;
    }
    localRecyclerView.requestLayout();
    a.B = true;
  }
  
  public final void d(int paramInt1, int paramInt2)
  {
    int n = -1;
    RecyclerView localRecyclerView = a;
    int i1 = e.b();
    int i;
    int j;
    int k;
    int m;
    if (paramInt1 < paramInt2)
    {
      i = -1;
      j = paramInt2;
      k = paramInt1;
      m = 0;
      label35:
      if (m >= i1) {
        break label139;
      }
      localObject = RecyclerView.b(e.c(m));
      if ((localObject != null) && (b >= k) && (b <= j))
      {
        if (b != paramInt1) {
          break label129;
        }
        ((alj)localObject).a(paramInt2 - paramInt1, false);
      }
    }
    for (;;)
    {
      A.f = true;
      m += 1;
      break label35;
      i = 1;
      j = paramInt1;
      k = paramInt2;
      break;
      label129:
      ((alj)localObject).a(i, false);
    }
    label139:
    Object localObject = c;
    label173:
    alj localalj;
    if (paramInt1 < paramInt2)
    {
      j = paramInt2;
      k = paramInt1;
      i = n;
      n = c.size();
      m = 0;
      if (m >= n) {
        break label268;
      }
      localalj = (alj)c.get(m);
      if ((localalj != null) && (b >= k) && (b <= j))
      {
        if (b != paramInt1) {
          break label258;
        }
        localalj.a(paramInt2 - paramInt1, false);
      }
    }
    for (;;)
    {
      m += 1;
      break label173;
      i = 1;
      j = paramInt1;
      k = paramInt2;
      break;
      label258:
      localalj.a(i, false);
    }
    label268:
    localRecyclerView.requestLayout();
    a.B = true;
  }
}

/* Location:
 * Qualified Name:     ako
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */