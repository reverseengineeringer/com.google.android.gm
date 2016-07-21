import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class duq
{
  public final List<dur> a = new ArrayList();
  int b = 0;
  public int c = 0;
  int d;
  private final Set<String> e = new HashSet();
  private final Set<String> f = new HashSet();
  private final Set<String> g = new HashSet();
  private int h = 0;
  
  public final void a()
  {
    a.clear();
    e.clear();
    f.clear();
    g.clear();
    h = 0;
    c = 0;
    b = 0;
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2)
  {
    if (paramBoolean1) {
      c += 1;
    }
    dur localdur;
    do
    {
      return;
      localdur = new dur();
      if (paramBoolean3) {
        paramString1 = "";
      }
      a = paramString1;
      c = paramBoolean2;
      d = 2;
      e = paramInt1;
      b = paramString2;
      f = paramInt2;
      a.add(localdur);
    } while (!c);
    g.add(a);
  }
  
  public final void b()
  {
    for (;;)
    {
      int i;
      if ((a.size() > 0) && (h < a.size() + 2 - 1))
      {
        i = 1;
        label34:
        if ((i == 0) || (b >= 5)) {
          break;
        }
        switch (h)
        {
        default: 
          i = a.size() - 1 - (h - 2);
          h += 1;
        }
      }
      for (;;)
      {
        localObject = (dur)a.get(i);
        if (d == 0) {
          break;
        }
        if ((e.contains(a)) && ((!c) || (f.contains(a)))) {
          break label324;
        }
        e.add(a);
        if (c) {
          f.add(a);
        }
        d = 0;
        e = b;
        b += 1;
        break;
        i = 0;
        break label34;
        if ((a.get(0)).c) || (g.size() == 0)) {}
        for (i = 2;; i = 1)
        {
          h = i;
          i = 0;
          break;
        }
        i = 1;
        while ((i < a.size()) && (!a.get(i)).c)) {
          i += 1;
        }
        h = 2;
      }
      label324:
      d = 1;
    }
    Object localObject = a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      dur localdur = (dur)((Iterator)localObject).next();
      if ((d == 2) && (e.contains(a))) {
        d = 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     duq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */