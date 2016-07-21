public final class hqs
  extends hln<hqs>
{
  public Long a = null;
  public String b = null;
  
  public hqs()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null)
    {
      a.longValue();
      i = j + (hll.b(1) + 8);
    }
    j = i;
    if (b != null) {
      j = i + hll.b(2, b);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a.longValue());
    }
    if (b != null) {
      paramhll.a(2, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hqs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */