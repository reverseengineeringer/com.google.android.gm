public class iad
  extends hue
{
  private static final long serialVersionUID = 5233773091972759919L;
  public hso c;
  private hwq d;
  
  private iad(String paramString, hso paramhso, huf paramhuf)
  {
    this(paramString, new hub(), paramhso, paramhuf);
  }
  
  private iad(String paramString, hub paramhub, hso paramhso, huf paramhuf)
  {
    super(paramString, paramhub, paramhuf);
    c = paramhso;
    if ((paramhso != null) && (!hzm.f.equals(a))) {
      b.b(a);
    }
  }
  
  public iad(String paramString, huf paramhuf)
  {
    this(paramString, new hso(hzm.f), paramhuf);
  }
  
  public String a()
  {
    return ico.b(c);
  }
  
  public void a(hwq paramhwq)
  {
    if (c == null) {
      throw new UnsupportedOperationException("TimeZone is not applicable to current value");
    }
    d = paramhwq;
    if (paramhwq != null)
    {
      if (!hzm.f.equals(c.a)) {
        throw new UnsupportedOperationException("TimeZone is not applicable to current value");
      }
      c.a(paramhwq);
      b.c(a("TZID"));
      paramhwq = new hzl(paramhwq.getID());
      b.b(paramhwq);
      return;
    }
    if ((c == null) || (!hzm.f.equals(c.a))) {
      throw new UnsupportedOperationException("TimeZone is not applicable to current value");
    }
    c.a(false);
    b.c(a("TZID"));
  }
  
  public void b(String paramString)
  {
    c = new hso(paramString, (hzm)a("VALUE"), d);
  }
}

/* Location:
 * Qualified Name:     iad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */