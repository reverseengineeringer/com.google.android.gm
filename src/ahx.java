import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ahx
  extends ama
{
  ArrayList<ArrayList<alj>> a = new ArrayList();
  ArrayList<ArrayList<aih>> b = new ArrayList();
  ArrayList<ArrayList<aig>> c = new ArrayList();
  ArrayList<alj> d = new ArrayList();
  ArrayList<alj> e = new ArrayList();
  ArrayList<alj> f = new ArrayList();
  ArrayList<alj> g = new ArrayList();
  private ArrayList<alj> n = new ArrayList();
  private ArrayList<alj> o = new ArrayList();
  private ArrayList<aih> p = new ArrayList();
  private ArrayList<aig> q = new ArrayList();
  
  private final void a(aig paramaig)
  {
    if (a != null) {
      a(paramaig, a);
    }
    if (b != null) {
      a(paramaig, b);
    }
  }
  
  private static void a(List<alj> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      rg.q(geta).a();
      i -= 1;
    }
  }
  
  private final void a(List<aig> paramList, alj paramalj)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      aig localaig = (aig)paramList.get(i);
      if ((a(localaig, paramalj)) && (a == null) && (b == null)) {
        paramList.remove(localaig);
      }
      i -= 1;
    }
  }
  
  private final boolean a(aig paramaig, alj paramalj)
  {
    if (b == paramalj) {
      b = null;
    }
    for (;;)
    {
      rg.c(a, 1.0F);
      rg.a(a, 0.0F);
      rg.b(a, 0.0F);
      e(paramalj);
      return true;
      if (a != paramalj) {
        break;
      }
      a = null;
    }
    return false;
  }
  
  private final void g(alj paramalj)
  {
    View localView = a;
    ej.a.a(localView);
    c(paramalj);
  }
  
  public final void a()
  {
    int i;
    int j;
    label24:
    int k;
    if (!n.isEmpty())
    {
      i = 1;
      if (p.isEmpty()) {
        break label72;
      }
      j = 1;
      if (q.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (o.isEmpty()) {
        break label82;
      }
    }
    label72:
    label77:
    label82:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label88;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label24;
      k = 0;
      break label36;
    }
    label88:
    Object localObject1 = n.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (alj)((Iterator)localObject1).next();
      tg localtg = rg.q(a);
      f.add(localObject2);
      localtg.a(this.j).a(0.0F).a(new aib(this, (alj)localObject2, localtg)).b();
    }
    n.clear();
    label260:
    label340:
    long l1;
    label415:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(p);
      b.add(localObject1);
      p.clear();
      localObject2 = new ahy(this, (ArrayList)localObject1);
      if (i != 0) {
        rg.a(get0a.a, (Runnable)localObject2, this.j);
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(q);
        c.add(localObject1);
        q.clear();
        localObject2 = new ahz(this, (ArrayList)localObject1);
        if (i == 0) {
          break label477;
        }
        rg.a(get0a.a, (Runnable)localObject2, this.j);
      }
      if (m == 0) {
        break label485;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(o);
      a.add(localObject1);
      o.clear();
      localObject2 = new aia(this, (ArrayList)localObject1);
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label505;
      }
      if (i == 0) {
        break label487;
      }
      l1 = this.j;
      if (j == 0) {
        break label493;
      }
      l2 = this.k;
      label425:
      if (k == 0) {
        break label499;
      }
    }
    label477:
    label485:
    label487:
    label493:
    label499:
    for (long l3 = l;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      rg.a(get0a, (Runnable)localObject2, l1 + l2);
      return;
      ((Runnable)localObject2).run();
      break label260;
      ((Runnable)localObject2).run();
      break label340;
      break;
      l1 = 0L;
      break label415;
      l2 = 0L;
      break label425;
    }
    label505:
    ((Runnable)localObject2).run();
  }
  
  public final boolean a(alj paramalj)
  {
    g(paramalj);
    n.add(paramalj);
    return true;
  }
  
  public final boolean a(alj paramalj, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = a;
    paramInt1 = (int)(paramInt1 + rg.m(a));
    paramInt2 = (int)(paramInt2 + rg.n(a));
    g(paramalj);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      e(paramalj);
      return false;
    }
    if (i != 0) {
      rg.a(localView, -i);
    }
    if (j != 0) {
      rg.b(localView, -j);
    }
    p.add(new aih(paramalj, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public final boolean a(alj paramalj1, alj paramalj2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramalj1 == paramalj2) {
      return a(paramalj1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = rg.m(a);
    float f2 = rg.n(a);
    float f3 = rg.e(a);
    g(paramalj1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    rg.a(a, f1);
    rg.b(a, f2);
    rg.c(a, f3);
    if (paramalj2 != null)
    {
      g(paramalj2);
      rg.a(a, -i);
      rg.b(a, -j);
      rg.c(a, 0.0F);
    }
    q.add(new aig(paramalj1, paramalj2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public final boolean a(alj paramalj, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramalj, paramList));
  }
  
  public final boolean b()
  {
    return (!o.isEmpty()) || (!q.isEmpty()) || (!p.isEmpty()) || (!n.isEmpty()) || (!e.isEmpty()) || (!f.isEmpty()) || (!d.isEmpty()) || (!g.isEmpty()) || (!b.isEmpty()) || (!a.isEmpty()) || (!c.isEmpty());
  }
  
  public final boolean b(alj paramalj)
  {
    g(paramalj);
    rg.c(a, 0.0F);
    o.add(paramalj);
    return true;
  }
  
  final void c()
  {
    if (!b()) {
      e();
    }
  }
  
  public final void c(alj paramalj)
  {
    View localView = a;
    rg.q(localView).a();
    int i = p.size() - 1;
    while (i >= 0)
    {
      if (p.get(i)).a == paramalj)
      {
        rg.b(localView, 0.0F);
        rg.a(localView, 0.0F);
        e(paramalj);
        p.remove(i);
      }
      i -= 1;
    }
    a(q, paramalj);
    if (n.remove(paramalj))
    {
      rg.c(localView, 1.0F);
      e(paramalj);
    }
    if (o.remove(paramalj))
    {
      rg.c(localView, 1.0F);
      e(paramalj);
    }
    i = c.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)c.get(i);
      a(localArrayList, paramalj);
      if (localArrayList.isEmpty()) {
        c.remove(i);
      }
      i -= 1;
    }
    i = b.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)b.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (geta != paramalj) {
            break label293;
          }
          rg.b(localView, 0.0F);
          rg.a(localView, 0.0F);
          e(paramalj);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            b.remove(i);
          }
        }
        i -= 1;
        break;
        label293:
        j -= 1;
      }
    }
    i = a.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)a.get(i);
      if (localArrayList.remove(paramalj))
      {
        rg.c(localView, 1.0F);
        e(paramalj);
        if (localArrayList.isEmpty()) {
          a.remove(i);
        }
      }
      i -= 1;
    }
    f.remove(paramalj);
    d.remove(paramalj);
    g.remove(paramalj);
    e.remove(paramalj);
    c();
  }
  
  public final void d()
  {
    int i = p.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (aih)p.get(i);
      localObject2 = a.a;
      rg.b((View)localObject2, 0.0F);
      rg.a((View)localObject2, 0.0F);
      e(a);
      p.remove(i);
      i -= 1;
    }
    i = n.size() - 1;
    while (i >= 0)
    {
      e((alj)n.get(i));
      n.remove(i);
      i -= 1;
    }
    i = o.size() - 1;
    while (i >= 0)
    {
      localObject1 = (alj)o.get(i);
      rg.c(a, 1.0F);
      e((alj)localObject1);
      o.remove(i);
      i -= 1;
    }
    i = q.size() - 1;
    while (i >= 0)
    {
      a((aig)q.get(i));
      i -= 1;
    }
    q.clear();
    if (!b()) {
      return;
    }
    i = b.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)b.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (aih)((ArrayList)localObject1).get(j);
        View localView = a.a;
        rg.b(localView, 0.0F);
        rg.a(localView, 0.0F);
        e(a);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          b.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = a.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)a.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (alj)((ArrayList)localObject1).get(j);
        rg.c(a, 1.0F);
        e((alj)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          a.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = c.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)c.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((aig)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          c.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    a(f);
    a(e);
    a(d);
    a(g);
    e();
  }
}

/* Location:
 * Qualified Name:     ahx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */