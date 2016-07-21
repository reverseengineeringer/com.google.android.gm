public final class hzc
  extends hsy
{
  public static final hzc b = new hzc("THISANDPRIOR");
  public static final hzc c = new hzc("THISANDFUTURE");
  private static final long serialVersionUID = -3057531444558393776L;
  private String d;
  
  public hzc(String paramString)
  {
    super("RANGE", hta.a);
    d = ico.a(paramString);
    if ((!icf.a("ical4j.compatibility.notes")) && (!"THISANDPRIOR".equals(d)) && (!"THISANDFUTURE".equals(d)))
    {
      paramString = d;
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 16 + "Invalid value [" + paramString + "]");
    }
  }
  
  public final String a()
  {
    return d;
  }
}

/* Location:
 * Qualified Name:     hzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */