public class icb
  extends iae
{
  private static final long serialVersionUID = 4850079486497487938L;
  
  public icb(String paramString, huf paramhuf)
  {
    super(paramString, paramhuf);
    a(new hsq((byte)0));
  }
  
  public void a(hsq paramhsq)
  {
    if (paramhsq != null)
    {
      paramhsq = new hsq(paramhsq);
      paramhsq.a(true);
      a(paramhsq);
      return;
    }
    a(paramhsq);
  }
  
  public final void a(hwq paramhwq)
  {
    throw new UnsupportedOperationException("Cannot set timezone for UTC properties");
  }
}

/* Location:
 * Qualified Name:     icb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */