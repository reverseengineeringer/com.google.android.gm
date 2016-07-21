public final class hzd
  extends hsy
{
  public static final hzd b = new hzd("PARENT");
  public static final hzd c = new hzd("CHILD");
  public static final hzd d = new hzd("SIBLING");
  private static final long serialVersionUID = 5346030888832899016L;
  private String e;
  
  public hzd(String paramString)
  {
    super("RELTYPE", hta.a);
    e = ico.a(paramString);
  }
  
  public final String a()
  {
    return e;
  }
}

/* Location:
 * Qualified Name:     hzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */