public final class hzm
  extends hsy
{
  public static final hzm b = new hzm("BINARY");
  public static final hzm c = new hzm("BOOLEAN");
  public static final hzm d = new hzm("CAL-ADDRESS");
  public static final hzm e = new hzm("DATE");
  public static final hzm f = new hzm("DATE-TIME");
  public static final hzm g = new hzm("DURATION");
  public static final hzm h = new hzm("FLOAT");
  public static final hzm i = new hzm("INTEGER");
  public static final hzm j = new hzm("PERIOD");
  public static final hzm k = new hzm("RECUR");
  public static final hzm l = new hzm("TEXT");
  public static final hzm m = new hzm("TIME");
  public static final hzm n = new hzm("URI");
  public static final hzm o = new hzm("UTC-OFFSET");
  private static final long serialVersionUID = -7238642734500301768L;
  private String p;
  
  public hzm(String paramString)
  {
    super("VALUE", hta.a);
    p = ico.a(paramString);
  }
  
  public final String a()
  {
    return p;
  }
}

/* Location:
 * Qualified Name:     hzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */