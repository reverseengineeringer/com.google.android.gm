import java.math.BigDecimal;

public final class iap
  extends hue
{
  private static final long serialVersionUID = -902100715801867636L;
  private BigDecimal c = BigDecimal.valueOf(0L);
  private BigDecimal d = BigDecimal.valueOf(0L);
  
  public iap()
  {
    super("GEO", hug.a);
  }
  
  public final String a()
  {
    String str1 = String.valueOf(String.valueOf(c));
    String str2 = String.valueOf(String.valueOf(d));
    return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + ";" + str2;
  }
  
  public final void b(String paramString)
  {
    String str = paramString.substring(0, paramString.indexOf(';'));
    if (idj.a(str)) {}
    for (c = new BigDecimal(str);; c = BigDecimal.valueOf(0L))
    {
      paramString = paramString.substring(paramString.indexOf(';') + 1);
      if (!idj.a(paramString)) {
        break;
      }
      d = new BigDecimal(paramString);
      return;
    }
    d = BigDecimal.valueOf(0L);
  }
}

/* Location:
 * Qualified Name:     iap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */