public final class hzb
  extends hsy
{
  public static final hzb b = new hzb("NEEDS-ACTION");
  public static final hzb c = new hzb("ACCEPTED");
  public static final hzb d = new hzb("DECLINED");
  public static final hzb e = new hzb("TENTATIVE");
  public static final hzb f = new hzb("DELEGATED");
  public static final hzb g = new hzb("COMPLETED");
  public static final hzb h = new hzb("IN-PROCESS");
  private static final long serialVersionUID = -7856347127343842441L;
  private String i;
  
  public hzb(String paramString)
  {
    super("PARTSTAT", hta.a);
    i = ico.a(paramString);
  }
  
  public final String a()
  {
    return i;
  }
}

/* Location:
 * Qualified Name:     hzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */