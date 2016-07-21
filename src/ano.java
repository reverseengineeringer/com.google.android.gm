public final class ano
  extends ann
{
  private static ano e;
  
  private ano()
  {
    super(null, false);
  }
  
  public static ano f()
  {
    if (e == null) {
      e = new ano();
    }
    return e;
  }
  
  public final void a() {}
  
  public final int d()
  {
    return 0;
  }
  
  public final void e() {}
}

/* Location:
 * Qualified Name:     ano
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */