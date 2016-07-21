public final class gyd
  extends hlt
{
  public gwi[] a = gwi.b();
  public gwl b = null;
  public gwm c = null;
  public gwi[] d = gwi.b();
  public gwi[] e = gwi.b();
  public gwi[] f = gwi.b();
  public gwi[] g = gwi.b();
  
  public gyd()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int j = super.a();
    int i = j;
    gwi localgwi;
    if (a != null)
    {
      i = j;
      if (a.length > 0)
      {
        i = j;
        j = 0;
        while (j < a.length)
        {
          localgwi = a[j];
          k = i;
          if (localgwi != null) {
            k = i + hll.d(1, localgwi);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (b != null) {
      j = i + hll.d(2, b);
    }
    i = j;
    if (c != null) {
      i = j + hll.d(3, c);
    }
    j = i;
    if (d != null)
    {
      j = i;
      if (d.length > 0)
      {
        j = 0;
        while (j < d.length)
        {
          localgwi = d[j];
          k = i;
          if (localgwi != null) {
            k = i + hll.d(6, localgwi);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (e != null)
    {
      k = j;
      if (e.length > 0)
      {
        i = j;
        j = 0;
        while (j < e.length)
        {
          localgwi = e[j];
          k = i;
          if (localgwi != null) {
            k = i + hll.d(7, localgwi);
          }
          j += 1;
          i = k;
        }
        k = i;
      }
    }
    i = k;
    if (f != null)
    {
      i = k;
      if (f.length > 0)
      {
        i = k;
        j = 0;
        while (j < f.length)
        {
          localgwi = f[j];
          k = i;
          if (localgwi != null) {
            k = i + hll.d(8, localgwi);
          }
          j += 1;
          i = k;
        }
      }
    }
    k = i;
    if (g != null)
    {
      k = i;
      if (g.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= g.length) {
            break;
          }
          localgwi = g[j];
          k = i;
          if (localgwi != null) {
            k = i + hll.d(9, localgwi);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public final void a(hll paramhll)
  {
    int j = 0;
    int i;
    gwi localgwi;
    if ((a != null) && (a.length > 0))
    {
      i = 0;
      while (i < a.length)
      {
        localgwi = a[i];
        if (localgwi != null) {
          paramhll.b(1, localgwi);
        }
        i += 1;
      }
    }
    if (b != null) {
      paramhll.b(2, b);
    }
    if (c != null) {
      paramhll.b(3, c);
    }
    if ((d != null) && (d.length > 0))
    {
      i = 0;
      while (i < d.length)
      {
        localgwi = d[i];
        if (localgwi != null) {
          paramhll.b(6, localgwi);
        }
        i += 1;
      }
    }
    if ((e != null) && (e.length > 0))
    {
      i = 0;
      while (i < e.length)
      {
        localgwi = e[i];
        if (localgwi != null) {
          paramhll.b(7, localgwi);
        }
        i += 1;
      }
    }
    if ((f != null) && (f.length > 0))
    {
      i = 0;
      while (i < f.length)
      {
        localgwi = f[i];
        if (localgwi != null) {
          paramhll.b(8, localgwi);
        }
        i += 1;
      }
    }
    if ((g != null) && (g.length > 0))
    {
      i = j;
      while (i < g.length)
      {
        localgwi = g[i];
        if (localgwi != null) {
          paramhll.b(9, localgwi);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gyd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */