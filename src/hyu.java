public final class hyu
  extends hsy
{
  private static final long serialVersionUID = 567577003350648021L;
  private hsb b;
  
  private hyu(hsb paramhsb)
  {
    super("DELEGATED-TO", hta.a);
    b = paramhsb;
  }
  
  public hyu(String paramString)
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
 * Qualified Name:     hyu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */