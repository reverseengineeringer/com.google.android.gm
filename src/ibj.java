import java.util.StringTokenizer;

public final class ibj
  extends hue
{
  private static final long serialVersionUID = -3273944031884755345L;
  private String c;
  private String d;
  private String e;
  
  public ibj()
  {
    super("REQUEST-STATUS", hug.a);
  }
  
  public final String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (c != null) {
      localStringBuffer.append(c);
    }
    if (d != null)
    {
      localStringBuffer.append(';');
      localStringBuffer.append(d);
    }
    if (e != null)
    {
      localStringBuffer.append(';');
      localStringBuffer.append(e);
    }
    return localStringBuffer.toString();
  }
  
  public final void b(String paramString)
  {
    paramString = new StringTokenizer(paramString, ";");
    if (paramString.hasMoreTokens()) {
      c = paramString.nextToken();
    }
    if (paramString.hasMoreTokens()) {
      d = paramString.nextToken();
    }
    if (paramString.hasMoreTokens()) {
      e = paramString.nextToken();
    }
  }
}

/* Location:
 * Qualified Name:     ibj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */