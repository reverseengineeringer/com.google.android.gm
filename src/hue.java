import java.util.Iterator;
import java.util.List;

public abstract class hue
  extends hsm
{
  private static final long serialVersionUID = 7048785558435608687L;
  public String a;
  public hub b;
  private final huf c;
  
  public hue(String paramString, hub paramhub, huf paramhuf)
  {
    a = paramString;
    b = paramhub;
    c = paramhuf;
  }
  
  public hue(String paramString, huf paramhuf)
  {
    this(paramString, new hub(), paramhuf);
  }
  
  public final hsy a(String paramString)
  {
    Iterator localIterator = b.a.iterator();
    while (localIterator.hasNext())
    {
      hsy localhsy = (hsy)localIterator.next();
      if (paramString.equalsIgnoreCase(a)) {
        return localhsy;
      }
    }
    return null;
  }
  
  public abstract void b(String paramString);
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hue))
    {
      paramObject = (hue)paramObject;
      if (a.equals(a)) {
        return idkaaaab, b).a;
      }
      return false;
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return idlaa.toUpperCase()).a(a()).a(b).a;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    if (b != null) {
      localStringBuffer.append(b);
    }
    localStringBuffer.append(':');
    int i;
    if ((this instanceof ice))
    {
      hzm localhzm = (hzm)a("VALUE");
      if ((localhzm != null) && (!localhzm.equals(hzm.l))) {
        break label131;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        localStringBuffer.append(ico.b(ico.b(a())));
      }
      for (;;)
      {
        localStringBuffer.append("\r\n");
        return localStringBuffer.toString();
        if (!(this instanceof hsu)) {
          break label131;
        }
        i = 1;
        break;
        localStringBuffer.append(ico.b(a()));
      }
      label131:
      i = 0;
    }
  }
}

/* Location:
 * Qualified Name:     hue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */