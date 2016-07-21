public final class hza
  extends hsy
{
  private static final long serialVersionUID = 287348849443687499L;
  private hsb b;
  
  private hza(hsb paramhsb)
  {
    super("MEMBER", hta.a);
    b = paramhsb;
  }
  
  public hza(String paramString)
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
 * Qualified Name:     hza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */