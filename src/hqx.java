public final class hqx
  extends hln<hqx>
{
  public hqk a;
  public hqt b;
  
  public hqx()
  {
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hqx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */