import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class aks
{
  private ArrayList<Object> a = new ArrayList();
  public akt h = null;
  long i = 120L;
  public long j = 120L;
  public long k = 250L;
  long l = 250L;
  
  public static int d(alj paramalj)
  {
    int i3 = i & 0xE;
    if (paramalj.i()) {
      return 4;
    }
    if ((i3 & 0x4) == 0)
    {
      int i4 = c;
      int m;
      if (o == null) {
        m = -1;
      }
      while ((i4 != -1) && (m != -1) && (i4 != m))
      {
        return i3 | 0x800;
        Object localObject = o;
        if ((paramalj.a(524)) || (!paramalj.k()))
        {
          m = -1;
        }
        else
        {
          localObject = d;
          int n = b;
          int i5 = a.size();
          int i2 = 0;
          label117:
          m = n;
          if (i2 < i5)
          {
            paramalj = (agd)a.get(i2);
            switch (a)
            {
            default: 
              m = n;
            }
            for (;;)
            {
              i2 += 1;
              n = m;
              break label117;
              m = n;
              if (b <= n)
              {
                m = n + d;
                continue;
                m = n;
                if (b <= n)
                {
                  if (b + d > n)
                  {
                    m = -1;
                    break;
                  }
                  m = n - d;
                  continue;
                  if (b == n)
                  {
                    m = d;
                  }
                  else
                  {
                    int i1 = n;
                    if (b < n) {
                      i1 = n - 1;
                    }
                    m = i1;
                    if (d <= i1) {
                      m = i1 + 1;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return i3;
  }
  
  public abstract void a();
  
  public abstract boolean a(alj paramalj, aku paramaku1, aku paramaku2);
  
  public abstract boolean a(alj paramalj1, alj paramalj2, aku paramaku1, aku paramaku2);
  
  public boolean a(alj paramalj, List<Object> paramList)
  {
    return f(paramalj);
  }
  
  public abstract boolean b();
  
  public abstract boolean b(alj paramalj, aku paramaku1, aku paramaku2);
  
  public abstract void c(alj paramalj);
  
  public abstract boolean c(alj paramalj, aku paramaku1, aku paramaku2);
  
  public abstract void d();
  
  public final void e()
  {
    int n = a.size();
    int m = 0;
    while (m < n)
    {
      a.get(m);
      m += 1;
    }
    a.clear();
  }
  
  public final void e(alj paramalj)
  {
    if (h != null) {
      h.a(paramalj);
    }
  }
  
  public boolean f(alj paramalj)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     aks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */