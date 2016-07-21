import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ala
{
  public final ArrayList<alj> a = new ArrayList();
  public ArrayList<alj> b = null;
  public final ArrayList<alj> c = new ArrayList();
  public final List<alj> d = Collections.unmodifiableList(a);
  public alh e;
  private int g = 2;
  private akz h;
  
  public ala(RecyclerView paramRecyclerView) {}
  
  private final void c(alj paramalj)
  {
    rg.a(a, null);
    if (f.k != null) {
      localObject = f.k;
    }
    if (f.i != null) {
      localObject = f.i;
    }
    if (f.A != null) {
      f.f.d(paramalj);
    }
    o = null;
    akz localakz = c();
    int i = e;
    ArrayList localArrayList = (ArrayList)a.get(i);
    Object localObject = localArrayList;
    if (localArrayList == null)
    {
      localArrayList = new ArrayList();
      a.put(i, localArrayList);
      localObject = localArrayList;
      if (b.indexOfKey(i) < 0)
      {
        b.put(i, 5);
        localObject = localArrayList;
      }
    }
    if (b.get(i) > ((ArrayList)localObject).size())
    {
      paramalj.p();
      ((ArrayList)localObject).add(paramalj);
    }
  }
  
  public final alj a(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    int k = a.size();
    int i = 0;
    Object localObject1;
    while (i < k)
    {
      localObject1 = (alj)a.get(i);
      if ((!((alj)localObject1).f()) && (((alj)localObject1).c() == paramInt) && (!((alj)localObject1).i()) && ((f.A.g) || (!((alj)localObject1).l())))
      {
        ((alj)localObject1).b(32);
        return (alj)localObject1;
      }
      i += 1;
    }
    Object localObject2 = f.e;
    k = c.size();
    i = 0;
    Object localObject3;
    if (i < k)
    {
      localObject1 = (View)c.get(i);
      localObject3 = a.b((View)localObject1);
      if ((((alj)localObject3).c() != paramInt) || (((alj)localObject3).i()) || (((alj)localObject3).l())) {}
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = RecyclerView.b((View)localObject1);
        localObject3 = f.e;
        paramInt = a.a((View)localObject1);
        if (paramInt < 0)
        {
          throw new IllegalArgumentException("view is not a child, cannot hide " + localObject1);
          i += 1;
          break;
          localObject1 = null;
          continue;
        }
        if (!b.c(paramInt)) {
          throw new RuntimeException("trying to unhide a view that was not hidden" + localObject1);
        }
        b.b(paramInt);
        ((ahr)localObject3).b((View)localObject1);
        paramInt = f.e.c((View)localObject1);
        if (paramInt == -1) {
          throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2);
        }
        f.e.d(paramInt);
        c((View)localObject1);
        ((alj)localObject2).b(8224);
        return (alj)localObject2;
      }
    }
    k = c.size();
    i = j;
    while (i < k)
    {
      localObject1 = (alj)c.get(i);
      if ((!((alj)localObject1).i()) && (((alj)localObject1).c() == paramInt))
      {
        c.remove(i);
        return (alj)localObject1;
      }
      i += 1;
    }
    return null;
  }
  
  public final alj a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int i = a.size() - 1;
    alj localalj;
    while (i >= 0)
    {
      localalj = (alj)a.get(i);
      if ((d == paramLong) && (!localalj.f()))
      {
        if (paramInt == e)
        {
          localalj.b(32);
          if ((localalj.l()) && (!f.A.g)) {
            localalj.a(2, 14);
          }
          return localalj;
        }
        a.remove(i);
        f.removeDetachedView(a, false);
        b(a);
      }
      i -= 1;
    }
    i = c.size() - 1;
    while (i >= 0)
    {
      localalj = (alj)c.get(i);
      if (d == paramLong)
      {
        if (paramInt == e)
        {
          c.remove(i);
          return localalj;
        }
        a(i);
      }
      i -= 1;
    }
    return null;
  }
  
  public final void a()
  {
    a.clear();
    b();
  }
  
  public final void a(int paramInt)
  {
    c((alj)c.get(paramInt));
    c.remove(paramInt);
  }
  
  public final void a(alj paramalj)
  {
    boolean bool = true;
    int k = 0;
    Object localObject;
    if ((paramalj.d()) || (a.getParent() != null))
    {
      localObject = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramalj.d()).append(" isAttached:");
      if (a.getParent() != null) {}
      for (;;)
      {
        throw new IllegalArgumentException(bool);
        bool = false;
      }
    }
    if (paramalj.m()) {
      throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramalj);
    }
    if (paramalj.b()) {
      throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
    }
    int j;
    int i;
    if (((i & 0x10) == 0) && (rg.b(a)))
    {
      j = 1;
      if ((f.i != null) && (j != 0)) {
        localObject = f.i;
      }
      if (!paramalj.q()) {
        break label291;
      }
      if (paramalj.a(14)) {
        break label286;
      }
      i = c.size();
      if ((i == g) && (i > 0)) {
        a(0);
      }
      if (i >= g) {
        break label286;
      }
      c.add(paramalj);
      i = 1;
      label236:
      if (i != 0) {
        break label283;
      }
      c(paramalj);
      k = 1;
    }
    for (;;)
    {
      f.f.d(paramalj);
      if ((i == 0) && (k == 0) && (j != 0)) {
        o = null;
      }
      return;
      j = 0;
      break;
      label283:
      continue;
      label286:
      i = 0;
      break label236;
      label291:
      i = 0;
    }
  }
  
  public final void a(View paramView)
  {
    alj localalj = RecyclerView.b(paramView);
    if (localalj.m()) {
      f.removeDetachedView(paramView, false);
    }
    if (localalj.d()) {
      localalj.e();
    }
    for (;;)
    {
      a(localalj);
      return;
      if (localalj.f()) {
        localalj.g();
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView, true);
      }
      i -= 1;
    }
    if (!paramBoolean) {
      return;
    }
    if (paramViewGroup.getVisibility() == 4)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setVisibility(4);
      return;
    }
    i = paramViewGroup.getVisibility();
    paramViewGroup.setVisibility(4);
    paramViewGroup.setVisibility(i);
  }
  
  public final alj b(int paramInt)
  {
    int j = 0;
    int k;
    if (b != null)
    {
      k = b.size();
      if (k != 0) {}
    }
    else
    {
      return null;
    }
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = (alj)b.get(i);
      if ((!((alj)localObject).f()) && (((alj)localObject).c() == paramInt))
      {
        ((alj)localObject).b(32);
        return (alj)localObject;
      }
      i += 1;
    }
    if (f.i.a)
    {
      paramInt = f.d.a(paramInt, 0);
      if ((paramInt > 0) && (paramInt < f.i.b()))
      {
        localObject = f.i;
        paramInt = j;
        while (paramInt < k)
        {
          localObject = (alj)b.get(paramInt);
          if ((!((alj)localObject).f()) && (d == -1L))
          {
            ((alj)localObject).b(32);
            return (alj)localObject;
          }
          paramInt += 1;
        }
      }
    }
    return null;
  }
  
  public final void b()
  {
    int i = c.size() - 1;
    while (i >= 0)
    {
      a(i);
      i -= 1;
    }
    c.clear();
  }
  
  public final void b(alj paramalj)
  {
    if (m) {
      b.remove(paramalj);
    }
    for (;;)
    {
      l = null;
      m = false;
      paramalj.g();
      return;
      a.remove(paramalj);
    }
  }
  
  final void b(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    l = null;
    m = false;
    paramView.g();
    a(paramView);
  }
  
  public final akz c()
  {
    if (h == null) {
      h = new akz();
    }
    return h;
  }
  
  final void c(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    int i;
    if ((!paramView.a(12)) && (paramView.r()))
    {
      RecyclerView localRecyclerView = f;
      if ((x != null) && (!x.a(paramView, paramView.o()))) {
        break label92;
      }
      i = 1;
    }
    while (i != 0) {
      if ((paramView.i()) && (!paramView.l()) && (!f.i.a))
      {
        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        label92:
        i = 0;
      }
      else
      {
        paramView.a(this, false);
        a.add(paramView);
        return;
      }
    }
    if (b == null) {
      b = new ArrayList();
    }
    paramView.a(this, true);
    b.add(paramView);
  }
}

/* Location:
 * Qualified Name:     ala
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */