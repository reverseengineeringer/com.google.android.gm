import java.util.List;

public final class gnh
  implements gna
{
  final Object a = new Object();
  gng b = new gng(1000);
  gna c;
  boolean d;
  gne e;
  
  public gnh(int paramInt, gne paramgne)
  {
    e = paramgne;
  }
  
  final void a()
  {
    synchronized (a)
    {
      d = true;
      b = null;
      return;
    }
  }
  
  public final void a(hri paramhri)
  {
    synchronized (a)
    {
      if (d) {
        return;
      }
      if (c != null)
      {
        c.a(paramhri);
        return;
      }
    }
    gng localgng = b;
    if (a.size() < b) {
      a.add(paramhri);
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        a();
        if (e != null) {
          e.a();
        }
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     gnh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */