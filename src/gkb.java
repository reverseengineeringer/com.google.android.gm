import android.app.Application;
import java.util.List;

public final class gkb
{
  private static volatile gkb a;
  private final Application b;
  private final gkc c = new gkc();
  private final gkd d;
  private int e;
  private int f;
  
  private gkb(Application paramApplication)
  {
    b = ((Application)gol.a(paramApplication));
    d = new gkd(paramApplication);
  }
  
  public static gkb a(Application paramApplication)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new gkb(paramApplication);
      }
      return a;
    }
    finally {}
  }
  
  public final void a(gjr paramgjr)
  {
    for (;;)
    {
      try
      {
        gol.a(paramgjr);
        if (!(paramgjr instanceof gjs)) {
          break label338;
        }
        k = c.a.add((gjs)paramgjr) | false;
        int i = k;
        if ((paramgjr instanceof gjx)) {
          i = k | c.b.add((gjx)paramgjr);
        }
        k = i;
        if ((paramgjr instanceof gjv)) {
          k = i | c.c.add((gjv)paramgjr);
        }
        i = k;
        if ((paramgjr instanceof gju)) {
          i = k | c.d.add((gju)paramgjr);
        }
        k = i;
        if ((paramgjr instanceof gjy)) {
          k = i | c.e.add((gjy)paramgjr);
        }
        i = k;
        if ((paramgjr instanceof gjw)) {
          i = k | c.f.add((gjw)paramgjr);
        }
        k = i;
        if ((paramgjr instanceof gjt)) {
          k = i | c.g.add((gjt)paramgjr);
        }
        if ((paramgjr instanceof gka))
        {
          i = d.a.add((gka)paramgjr) | k;
          k = 1;
          boolean bool = i;
          if ((paramgjr instanceof gjz))
          {
            bool = i | d.b.add((gjz)paramgjr);
            k = 1;
          }
          if (k != 0)
          {
            j = f + 1;
            f = j;
            if (j == 1) {
              a(d);
            }
          }
          if (bool)
          {
            j = e + 1;
            e = j;
            if (j == 1) {
              b.registerActivityLifecycleCallbacks(c);
            }
          }
          return;
        }
      }
      finally {}
      int j = k;
      int k = 0;
      continue;
      label338:
      k = 0;
    }
  }
  
  public final void b(gjr paramgjr)
  {
    int i2 = 0;
    int i1 = 1;
    for (;;)
    {
      int n;
      try
      {
        gol.a(paramgjr);
        if (!(paramgjr instanceof gjs)) {
          break label329;
        }
        int k = c.a.remove(paramgjr) | false;
        int i = k;
        if ((paramgjr instanceof gjx)) {
          i = k | c.b.remove(paramgjr);
        }
        k = i;
        if ((paramgjr instanceof gjv)) {
          k = i | c.c.remove(paramgjr);
        }
        i = k;
        if ((paramgjr instanceof gju)) {
          i = k | c.d.remove(paramgjr);
        }
        k = i;
        if ((paramgjr instanceof gjy)) {
          k = i | c.e.remove(paramgjr);
        }
        i = k;
        if ((paramgjr instanceof gjw)) {
          i = k | c.f.remove(paramgjr);
        }
        k = i;
        if ((paramgjr instanceof gjt)) {
          k = i | c.g.remove(paramgjr);
        }
        n = k;
        i = i2;
        if ((paramgjr instanceof gka))
        {
          n = k;
          i = i2;
          if (d.a.remove(paramgjr))
          {
            n = 1;
            i = 1;
          }
        }
        if (((paramgjr instanceof gjz)) && (d.b.remove(paramgjr)))
        {
          k = 1;
          i = i1;
          if (k != 0)
          {
            m = f - 1;
            f = m;
            if (m == 0) {
              b(d);
            }
          }
          if (i != 0)
          {
            j = e - 1;
            e = j;
            if (j == 0) {
              b.unregisterActivityLifecycleCallbacks(c);
            }
          }
          return;
        }
      }
      finally {}
      int m = j;
      int j = n;
      continue;
      label329:
      m = 0;
    }
  }
}

/* Location:
 * Qualified Name:     gkb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */