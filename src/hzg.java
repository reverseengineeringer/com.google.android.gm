public final class hzg
  extends hsy
{
  public static final hzg b = new hzg("TRUE");
  public static final hzg c = new hzg("FALSE");
  private static final long serialVersionUID = -5381653882942018012L;
  private Boolean d;
  
  private hzg(Boolean paramBoolean)
  {
    super("RSVP", hta.a);
    d = paramBoolean;
  }
  
  public hzg(String paramString)
  {
    this(Boolean.valueOf(paramString));
  }
  
  public final String a()
  {
    if (d.booleanValue()) {
      return "TRUE";
    }
    return "FALSE";
  }
}

/* Location:
 * Qualified Name:     hzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */