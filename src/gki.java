import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class gki
  implements gmo
{
  private final gku a;
  private final Map<String, gkh> b = new HashMap();
  
  gki(gku paramgku)
  {
    a = ((gku)gol.a(paramgku));
  }
  
  public final void a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = b.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (gkh)((Map.Entry)localObject2).getValue();
      if ((b > 0) || (a > 0))
      {
        hrc localhrc = new hrc();
        a = str;
        c = Integer.valueOf(b);
        b = Integer.valueOf(a);
        localArrayList.add(localhrc);
        b = 0;
        a = 0;
      }
    }
    if (!localArrayList.isEmpty())
    {
      localObject1 = new hri();
      m = new hqw();
      m.a = ((hrc[])localArrayList.toArray(new hrc[localArrayList.size()]));
      if (a.a()) {
        a.a((hri)localObject1);
      }
    }
  }
  
  public final void a(String paramString)
  {
    gkh localgkh2 = (gkh)b.get(paramString);
    gkh localgkh1 = localgkh2;
    if (localgkh2 == null)
    {
      localgkh1 = new gkh();
      b.put(paramString, localgkh1);
    }
    a += 1;
  }
  
  public final void b(String paramString)
  {
    gkh localgkh2 = (gkh)b.get(paramString);
    gkh localgkh1 = localgkh2;
    if (localgkh2 == null)
    {
      localgkh1 = new gkh();
      b.put(paramString, localgkh1);
    }
    b += 1;
  }
}

/* Location:
 * Qualified Name:     gki
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */