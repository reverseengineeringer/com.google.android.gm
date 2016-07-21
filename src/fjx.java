public final class fjx
  extends fkb
{
  public long a = -1L;
  public long b = -1L;
  
  public fjx()
  {
    g = false;
  }
  
  public final void a()
  {
    super.a();
    if ((a == -1L) || (b == -1L)) {
      throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
    }
    if (a >= b) {
      throw new IllegalArgumentException("Window start must be shorter than window end.");
    }
  }
}

/* Location:
 * Qualified Name:     fjx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */