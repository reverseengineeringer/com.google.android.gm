public final class hql
  extends hln<hql>
{
  public Long a = null;
  public Boolean b = null;
  public Integer c = null;
  public String d = null;
  
  public hql()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.c(1, a.longValue());
    }
    j = i;
    if (b != null)
    {
      b.booleanValue();
      j = i + (hll.b(2) + 1);
    }
    i = j;
    if (c != null) {
      i = j + hll.c(3, c.intValue());
    }
    j = i;
    if (d != null) {
      j = i + hll.b(4, d);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.a(1, a.longValue());
    }
    if (b != null) {
      paramhll.a(2, b.booleanValue());
    }
    if (c != null) {
      paramhll.a(3, c.intValue());
    }
    if (d != null) {
      paramhll.a(4, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hql
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */