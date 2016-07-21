public class iau
  extends hue
{
  public static final iau c = new iav("PUBLISH");
  public static final iau d = new iav("REQUEST");
  public static final iau e = new iav("REPLY");
  public static final iau f = new iav("ADD");
  public static final iau g = new iav("CANCEL");
  public static final iau h = new iav("REFRESH");
  public static final iau i = new iav("COUNTER");
  public static final iau j = new iav("DECLINE-COUNTER");
  private static final long serialVersionUID = 7220956532685378719L;
  private String k;
  
  public iau()
  {
    super("METHOD", hug.a);
  }
  
  public iau(hub paramhub, String paramString)
  {
    super("METHOD", paramhub, hug.a);
    k = paramString;
  }
  
  public final String a()
  {
    return k;
  }
  
  public void b(String paramString)
  {
    k = paramString;
  }
}

/* Location:
 * Qualified Name:     iau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */