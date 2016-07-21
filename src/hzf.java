public final class hzf
  extends hsy
{
  public static final hzf b = new hzf("CHAIR");
  public static final hzf c = new hzf("REQ-PARTICIPANT");
  public static final hzf d = new hzf("OPT-PARTICIPANT");
  public static final hzf e = new hzf("NON-PARTICIPANT");
  private static final long serialVersionUID = 1438225631470825963L;
  private String f;
  
  public hzf(String paramString)
  {
    super("ROLE", hta.a);
    f = ico.a(paramString);
  }
  
  public final String a()
  {
    return f;
  }
}

/* Location:
 * Qualified Name:     hzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */