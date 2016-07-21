public final class hyt
  extends hsy
{
  private static final long serialVersionUID = -795956139235258568L;
  private hsb b;
  
  private hyt(hsb paramhsb)
  {
    super("DELEGATED-FROM", hta.a);
    b = paramhsb;
  }
  
  public hyt(String paramString)
  {
    this(new hsb(ico.a(paramString)));
  }
  
  public final String a()
  {
    return b.toString();
  }
  
  protected final boolean b()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     hyt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */