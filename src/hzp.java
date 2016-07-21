public class hzp
  extends hue
{
  public static final hzp c = new hzq("AUDIO");
  public static final hzp d = new hzq("DISPLAY");
  public static final hzp e = new hzq("EMAIL");
  public static final hzp f = new hzq("PROCEDURE");
  private static final long serialVersionUID = -2353353838411753712L;
  private String g;
  
  public hzp()
  {
    super("ACTION", hug.a);
  }
  
  public hzp(hub paramhub, String paramString)
  {
    super("ACTION", paramhub, hug.a);
    g = paramString;
  }
  
  public final String a()
  {
    return g;
  }
  
  public void b(String paramString)
  {
    g = paramString;
  }
}

/* Location:
 * Qualified Name:     hzp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */