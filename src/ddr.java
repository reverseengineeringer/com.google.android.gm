public abstract class ddr
  extends ddq
{
  private String i;
  private String j;
  private String k;
  private String l;
  
  public ddr(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Name must not be null");
    }
    i = paramString1;
    j = paramString2;
    k = paramString3;
    l = paramString4;
  }
  
  public final String b()
  {
    return i;
  }
  
  public final String c()
  {
    return j;
  }
  
  public final String d()
  {
    return k;
  }
  
  public final String e()
  {
    return l;
  }
}

/* Location:
 * Qualified Name:     ddr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */