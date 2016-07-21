public class ibm
  extends hue
{
  public static final ibm c = new ibn("TENTATIVE");
  public static final ibm d = new ibn("CONFIRMED");
  public static final ibm e = new ibn("CANCELLED");
  public static final ibm f = new ibn("NEEDS-ACTION");
  public static final ibm g = new ibn("COMPLETED");
  public static final ibm h = new ibn("IN-PROCESS");
  public static final ibm i = new ibn("CANCELLED");
  public static final ibm j = new ibn("DRAFT");
  public static final ibm k = new ibn("FINAL");
  public static final ibm l = new ibn("CANCELLED");
  private static final long serialVersionUID = 7401102230299289898L;
  private String m;
  
  public ibm()
  {
    super("STATUS", hug.a);
  }
  
  public ibm(hub paramhub, String paramString)
  {
    super("STATUS", paramhub, hug.a);
    m = paramString;
  }
  
  public final String a()
  {
    return m;
  }
  
  public void b(String paramString)
  {
    m = paramString;
  }
}

/* Location:
 * Qualified Name:     ibm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */