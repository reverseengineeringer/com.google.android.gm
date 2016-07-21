public class hzw
  extends hue
{
  public static final hzw c = new hzx("PUBLIC");
  public static final hzw d = new hzx("PRIVATE");
  public static final hzw e = new hzx("CONFIDENTIAL");
  private static final long serialVersionUID = 4939943639175551481L;
  private String f;
  
  public hzw()
  {
    super("CLASS", hug.a);
  }
  
  public hzw(hub paramhub, String paramString)
  {
    super("CLASS", paramhub, hug.a);
    f = paramString;
  }
  
  public final String a()
  {
    return f;
  }
  
  public void b(String paramString)
  {
    f = paramString;
  }
}

/* Location:
 * Qualified Name:     hzw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */