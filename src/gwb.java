public final class gwb
  extends hln<gwb>
{
  public gwd a = null;
  public gwf b = null;
  public gwc c = null;
  public gwe d = null;
  
  public gwb()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.d(1, a);
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
    if (d != null) {
      j = i + hll.d(4, d);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if (b != null) {
      paramhll.b(2, b);
    }
    if (c != null) {
      paramhll.b(3, c);
    }
    if (d != null) {
      paramhll.b(4, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */