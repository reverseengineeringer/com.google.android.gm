public final class hyx
  extends hsy
{
  public static final hyx b = new hyx("FREE");
  public static final hyx c = new hyx("BUSY");
  public static final hyx d = new hyx("BUSY-UNAVAILABLE");
  public static final hyx e = new hyx("BUSY-TENTATIVE");
  private static final long serialVersionUID = -2217689716824679375L;
  private String f;
  
  public hyx(String paramString)
  {
    super("FBTYPE", hta.a);
    f = ico.a(paramString);
  }
  
  public final String a()
  {
    return f;
  }
}

/* Location:
 * Qualified Name:     hyx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */