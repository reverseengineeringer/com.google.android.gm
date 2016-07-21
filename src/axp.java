public abstract class axp
{
  public static final axp a = new axq();
  boolean b = false;
  
  public abstract boolean a();
  
  public abstract boolean b();
  
  public void c()
  {
    b = true;
  }
  
  protected final void d()
  {
    if (b) {
      throw new RuntimeException("Already destroyed");
    }
  }
}

/* Location:
 * Qualified Name:     axp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */