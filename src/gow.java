import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

public final class gow
{
  private final List<gpc> a;
  
  public gow(List<gpc> paramList)
  {
    a = paramList;
  }
  
  public static gpa a(gos paramgos, String paramString)
  {
    return new gpa(paramgos, paramString);
  }
  
  public static gpd a(gos paramgos, List<gpe> paramList, String paramString1, String paramString2)
  {
    return new gpd(paramgos, paramList, false, paramString1, paramString2, (byte)0);
  }
  
  public static gpe a(gor paramgor, String paramString1, String paramString2)
  {
    if (paramgor != null) {}
    for (boolean bool = true;; bool = false)
    {
      hby.a(bool);
      return new gpe(paramgor, paramString1, paramString2);
    }
  }
  
  public static gpf a(String paramString1, String paramString2)
  {
    return new gpg(paramString1, paramString2);
  }
  
  public static gpd b(gos paramgos, List<gpe> paramList, String paramString1, String paramString2)
  {
    return new gpd(paramgos, paramList, true, paramString1, paramString2, (byte)0);
  }
  
  public static gpf b(String paramString1, String paramString2)
  {
    return new gpb(paramString1, paramString2);
  }
  
  public final void a(gph paramgph)
  {
    paramgph.a();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((gpc)localIterator.next()).a(paramgph);
    }
    paramgph.b();
  }
  
  public final String toString()
  {
    StringWriter localStringWriter = new StringWriter();
    a(new goz(new PrintWriter(localStringWriter)));
    return localStringWriter.toString();
  }
}

/* Location:
 * Qualified Name:     gow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */