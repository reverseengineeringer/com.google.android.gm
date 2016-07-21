public class icc
  extends hue
{
  public static final icc c = new icd("2.0");
  private static final long serialVersionUID = 8872508067309087704L;
  private String d;
  private String e;
  
  public icc()
  {
    super("VERSION", hug.a);
  }
  
  public icc(hub paramhub, String paramString)
  {
    super("VERSION", paramhub, hug.a);
    if (paramString.indexOf(';') >= 0)
    {
      d = paramString.substring(0, paramString.indexOf(';') - 1);
      e = paramString.substring(paramString.indexOf(';'));
      return;
    }
    e = paramString;
  }
  
  public final String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (d != null)
    {
      localStringBuffer.append(d);
      if (e != null) {
        localStringBuffer.append(';');
      }
    }
    if (e != null) {
      localStringBuffer.append(e);
    }
    return localStringBuffer.toString();
  }
  
  public void b(String paramString)
  {
    if (paramString.indexOf(';') >= 0)
    {
      d = paramString.substring(0, paramString.indexOf(';') - 1);
      e = paramString.substring(paramString.indexOf(';'));
      return;
    }
    e = paramString;
  }
}

/* Location:
 * Qualified Name:     icc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */