import java.util.Iterator;
import java.util.List;

public final class gpd
  extends gpc
{
  public final gos a;
  public List<gpe> b;
  public final boolean c;
  final String d;
  final String e;
  
  private gpd(gos paramgos, List<gpe> paramList, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramgos != null) {}
    for (boolean bool = true;; bool = false)
    {
      hby.a(bool);
      a = paramgos;
      b = paramList;
      c = paramBoolean;
      d = paramString1;
      e = paramString2;
      return;
    }
  }
  
  public final gpe a(gor paramgor)
  {
    if (b != null)
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        gpe localgpe = (gpe)localIterator.next();
        if (a.equals(paramgor)) {
          return localgpe;
        }
      }
    }
    return null;
  }
  
  public final void a(gph paramgph)
  {
    paramgph.a(this);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Start Tag: ");
    localStringBuilder.append(a.a);
    if (b != null)
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        gpe localgpe = (gpe)localIterator.next();
        localStringBuilder.append(' ');
        localStringBuilder.append(localgpe.toString());
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     gpd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */