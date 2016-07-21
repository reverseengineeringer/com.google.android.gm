import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

final class iih
  implements iix
{
  String a;
  Set<String> b = new LinkedHashSet();
  private final iix c;
  
  iih(iix paramiix)
  {
    c = paramiix;
  }
  
  public final void a()
  {
    c.a();
  }
  
  public final void a(String paramString)
  {
    c.a(paramString);
  }
  
  public final void a(String paramString, List<String> paramList)
  {
    if (paramString.equals(a)) {
      a = null;
    }
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      b.remove(paramList.get(i));
      i += 2;
    }
    c.a(paramString, paramList);
  }
  
  public final void b()
  {
    c.b();
  }
  
  public final void b(String paramString)
  {
    c.b(paramString);
  }
}

/* Location:
 * Qualified Name:     iih
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */