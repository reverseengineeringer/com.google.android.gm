public final class hys
  extends hsy
{
  public static final hys b = new hys("INDIVIDUAL");
  public static final hys c = new hys("GROUP");
  public static final hys d = new hys("RESOURCE");
  public static final hys e = new hys("ROOM");
  public static final hys f = new hys("UNKNOWN");
  private static final long serialVersionUID = -3134064324693983052L;
  private String g;
  
  public hys(String paramString)
  {
    super("CUTYPE", hta.a);
    g = ico.a(paramString);
  }
  
  public final String a()
  {
    return g;
  }
}

/* Location:
 * Qualified Name:     hys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */