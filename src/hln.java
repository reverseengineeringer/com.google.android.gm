import java.util.List;

public abstract class hln<M extends hln<M>>
  extends hlt
{
  public hlp q;
  
  private final M b()
  {
    hln localhln = (hln)super.c();
    hlr.a(this, localhln);
    return localhln;
  }
  
  public int a()
  {
    int j = 0;
    if (q != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= q.b()) {
          break;
        }
        i += q.a(j).a();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public void a(hll paramhll)
  {
    if (q == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < q.b())
      {
        q.a(i).a(paramhll);
        i += 1;
      }
    }
  }
  
  public final boolean a(hlk paramhlk, int paramInt)
  {
    int i = paramhlk.j();
    if (!paramhlk.b(paramInt)) {
      return false;
    }
    int j = paramInt >>> 3;
    int k = paramhlk.j() - i;
    hlv localhlv;
    label68:
    Object localObject;
    if (k == 0)
    {
      paramhlk = hlw.h;
      localhlv = new hlv(paramInt, paramhlk);
      if (q != null) {
        break label161;
      }
      q = new hlp();
      paramhlk = null;
      localObject = paramhlk;
      if (paramhlk == null)
      {
        paramhlk = new hlq();
        localObject = q;
        paramInt = ((hlp)localObject).c(j);
        if (paramInt < 0) {
          break label204;
        }
        d[paramInt] = paramhlk;
        localObject = paramhlk;
      }
    }
    for (;;)
    {
      a.add(localhlv);
      return true;
      localObject = new byte[k];
      int m = b;
      System.arraycopy(a, i + m, localObject, 0, k);
      paramhlk = (hlk)localObject;
      break;
      label161:
      paramhlk = q;
      paramInt = paramhlk.c(j);
      if ((paramInt < 0) || (d[paramInt] == hlp.a))
      {
        paramhlk = null;
        break label68;
      }
      paramhlk = d[paramInt];
      break label68;
      label204:
      i = paramInt ^ 0xFFFFFFFF;
      if ((i < e) && (d[i] == hlp.a))
      {
        c[i] = j;
        d[i] = paramhlk;
        localObject = paramhlk;
      }
      else
      {
        paramInt = i;
        if (b)
        {
          paramInt = i;
          if (e >= c.length)
          {
            ((hlp)localObject).a();
            paramInt = ((hlp)localObject).c(j) ^ 0xFFFFFFFF;
          }
        }
        if (e >= c.length)
        {
          i = hlp.b(e + 1);
          int[] arrayOfInt = new int[i];
          hlq[] arrayOfhlq = new hlq[i];
          System.arraycopy(c, 0, arrayOfInt, 0, c.length);
          System.arraycopy(d, 0, arrayOfhlq, 0, d.length);
          c = arrayOfInt;
          d = arrayOfhlq;
        }
        if (e - paramInt != 0)
        {
          System.arraycopy(c, paramInt, c, paramInt + 1, e - paramInt);
          System.arraycopy(d, paramInt, d, paramInt + 1, e - paramInt);
        }
        c[paramInt] = j;
        d[paramInt] = paramhlk;
        e += 1;
        localObject = paramhlk;
      }
    }
  }
}

/* Location:
 * Qualified Name:     hln
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */