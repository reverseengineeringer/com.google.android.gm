public final class fka
  extends fkb
{
  public long a = -1L;
  public long b = -1L;
  
  public fka()
  {
    g = true;
  }
  
  public final void a()
  {
    super.a();
    if (a == -1L) {
      throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
    }
    if (b == -1L) {
      b = (((float)a * 0.1F));
    }
  }
}

/* Location:
 * Qualified Name:     fka
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */