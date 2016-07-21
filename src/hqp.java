public final class hqp
  extends hln<hqp>
{
  public Boolean a = null;
  public hrf b;
  
  public hqp()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null)
    {
      a.booleanValue();
      i = j + (hll.b(1) + 1);
    }
    j = i;
    if (b != null) {
      j = i + hll.d(2, b);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.a(1, a.booleanValue());
    }
    if (b != null) {
      paramhll.b(2, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hqp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */