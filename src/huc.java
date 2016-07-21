import java.text.ParseException;

public class huc
  extends hsp
  implements Comparable
{
  private static final long serialVersionUID = 7321090422911676490L;
  private hst c;
  
  public huc(String paramString)
  {
    super(a(paramString), a(paramString, true));
    try
    {
      a(paramString, false);
      if (a).a.a)
      {
        ((hsq)b).a(true);
        return;
      }
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        c = b(paramString);
      }
      ((hsq)b).a(a).b);
    }
  }
  
  private static hsq a(String paramString)
  {
    return new hsq(paramString.substring(0, paramString.indexOf('/')));
  }
  
  private static hsq a(String paramString, boolean paramBoolean)
  {
    try
    {
      hsq localhsq = new hsq(paramString.substring(paramString.indexOf('/') + 1));
      return localhsq;
    }
    catch (ParseException localParseException)
    {
      if (paramBoolean) {
        return new hsq(b(paramString).a(a(paramString)));
      }
      throw localParseException;
    }
  }
  
  private final hst a()
  {
    if (c == null) {
      return new hst((hsq)a, (hsq)b);
    }
    return c;
  }
  
  private static hst b(String paramString)
  {
    return new hst(paramString.substring(paramString.indexOf('/') + 1));
  }
  
  public final int compareTo(Object paramObject)
  {
    paramObject = (huc)paramObject;
    if (paramObject == null) {
      throw new ClassCastException("Cannot compare this object to null");
    }
    int i = ((hsq)a).compareTo((hsq)a);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      if (c != null) {
        break;
      }
      j = ((hsq)b).compareTo((hsq)b);
      i = j;
    } while (j != 0);
    return a().a(((huc)paramObject).a());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof huc)) {
      return false;
    }
    paramObject = (huc)paramObject;
    return idkaa, (hsq)a).a((hsq)b, (hsq)b).a;
  }
  
  public final int hashCode()
  {
    idl localidl = new idl().a((hsq)a);
    if (c == null) {}
    for (Object localObject = (hsq)b;; localObject = c) {
      return aa;
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((hsq)a);
    localStringBuffer.append('/');
    if (c == null) {
      localStringBuffer.append((hsq)b);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(c);
    }
  }
}

/* Location:
 * Qualified Name:     huc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */