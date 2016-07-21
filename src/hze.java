public final class hze
  extends hsy
{
  public static final hze b = new hze("START");
  public static final hze c = new hze("END");
  private static final long serialVersionUID = 1570525804115869565L;
  private String d;
  
  public hze(String paramString)
  {
    super("RELATED", hta.a);
    d = ico.a(paramString);
    if ((!"START".equals(d)) && (!"END".equals(d)))
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
 * Qualified Name:     hze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */