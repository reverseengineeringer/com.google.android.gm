import java.util.Iterator;

public final class ibd
  extends iad
{
  private static final long serialVersionUID = -3320381650013860193L;
  private hud d = new hud(false, true);
  
  public ibd()
  {
    super("RDATE", hug.a);
  }
  
  public final String a()
  {
    if ((d != null) && ((!d.isEmpty()) || (!d.c))) {
      return ico.b(d);
    }
    return super.a();
  }
  
  public final void a(hwq paramhwq)
  {
    if ((d != null) && ((!d.isEmpty()) || (!d.c)))
    {
      hud localhud = d;
      Iterator localIterator = localhud.iterator();
      while (localIterator.hasNext())
      {
        huc localhuc = (huc)localIterator.next();
        ((hsq)a).a(false);
        ((hsq)a).a(paramhwq);
        ((hsq)b).a(false);
        ((hsq)b).a(paramhwq);
      }
      a = paramhwq;
      b = false;
      return;
    }
    super.a(paramhwq);
  }
  
  public final void b(String paramString)
  {
    if (hzm.j.equals(a("VALUE")))
    {
      d = new hud(paramString);
      return;
    }
    super.b(paramString);
  }
}

/* Location:
 * Qualified Name:     ibd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */