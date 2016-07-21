import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class hsy
  extends hsm
{
  private static final long serialVersionUID = -2058497904769713528L;
  String a;
  private final hsz b;
  
  public hsy(String paramString, hsz paramhsz)
  {
    a = paramString;
    b = paramhsz;
  }
  
  public boolean b()
  {
    return ico.a.matcher(ico.b(a())).find();
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hsy))
    {
      paramObject = (hsy)paramObject;
      return idkaa, a).a(a(), ((hsy)paramObject).a()).a;
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    return idlaa.toUpperCase()).a(a()).a;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append('=');
    if (b()) {
      localStringBuffer.append(ico.a(ico.b(a())));
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(ico.b(a()));
    }
  }
}

/* Location:
 * Qualified Name:     hsy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */