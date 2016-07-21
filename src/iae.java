public class iae
  extends hue
{
  private static final long serialVersionUID = 3160883132732961321L;
  public hsn c;
  private hwq d;
  
  public iae(String paramString, huf paramhuf)
  {
    super(paramString, paramhuf);
  }
  
  private final void b(hwq paramhwq)
  {
    d = paramhwq;
    if (paramhwq != null)
    {
      if ((c != null) && (!(c instanceof hsq))) {
        throw new UnsupportedOperationException("TimeZone is not applicable to current value");
      }
      if (c != null) {
        ((hsq)c).a(paramhwq);
      }
      b.b(new hzl(paramhwq.getID()));
      return;
    }
    a(b());
  }
  
  public String a()
  {
    return ico.b(c);
  }
  
  public final void a(hsn paramhsn)
  {
    c = paramhsn;
    if ((paramhsn instanceof hsq))
    {
      if (hzm.e.equals(a("VALUE"))) {
        b.b(hzm.f);
      }
      b(b);
      return;
    }
    if (paramhsn != null) {
      b.b(hzm.e);
    }
    b(null);
  }
  
  public void a(hwq paramhwq)
  {
    b(paramhwq);
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((c != null) && ((c instanceof hsq))) {
      ((hsq)c).a(paramBoolean);
    }
    b.c(a("TZID"));
  }
  
  public void b(String paramString)
  {
    paramString = paramString.trim();
    if (paramString.length() == 8) {}
    for (int i = 1; (i != 0) || (hzm.e.equals(a("VALUE"))); i = 0)
    {
      b(null);
      c = new hsn(paramString);
      return;
    }
    c = new hsq(paramString, d);
  }
  
  public final boolean b()
  {
    if ((c instanceof hsq)) {
      return c).a.a;
    }
    return false;
  }
  
  public int hashCode()
  {
    return c.hashCode();
  }
}

/* Location:
 * Qualified Name:     iae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */