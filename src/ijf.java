import java.util.Collection;
import java.util.Iterator;

final class ijf
  implements ihe
{
  final hef<ihe> c;
  
  ijf(Collection<? extends ihe> paramCollection)
  {
    c = hef.a(paramCollection);
  }
  
  public final String apply(String paramString1, String paramString2, String paramString3)
  {
    hji localhji = c.a();
    while (localhji.hasNext())
    {
      ihe localihe = (ihe)localhji.next();
      if (paramString3 == null) {
        break;
      }
      paramString3 = localihe.apply(paramString1, paramString2, paramString3);
    }
    return paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (getClass() == paramObject.getClass()) && (c.equals(c));
  }
  
  public final int hashCode()
  {
    return c.hashCode();
  }
}

/* Location:
 * Qualified Name:     ijf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */