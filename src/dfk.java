import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class dfk
{
  public final Map<String, dfl> a = new HashMap();
  
  public final dfk a()
  {
    dfk localdfk = b();
    Iterator localIterator = a.entrySet().iterator();
    if (localIterator.hasNext())
    {
      dfl localdfl = (dfl)((Map.Entry)localIterator.next()).getValue();
      dqz localdqz = b;
      if (!a) {}
      for (boolean bool = true;; bool = false)
      {
        localdfk.a(localdqz, bool);
        break;
      }
    }
    return localdfk;
  }
  
  public final void a(dqz paramdqz, boolean paramBoolean)
  {
    dfl localdfl = new dfl(this, paramdqz, paramBoolean);
    a.put(paramdqz.b(), localdfl);
  }
  
  public final void a(String paramString)
  {
    a.remove(paramString);
  }
  
  public dfk b()
  {
    return new dfk();
  }
  
  public final boolean b(String paramString)
  {
    return a.containsKey(paramString);
  }
  
  public final List<dfl> c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((dfl)((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  public final boolean c(String paramString)
  {
    if (b(paramString)) {
      return !a.get(paramString)).a;
    }
    return false;
  }
  
  public boolean d()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     dfk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */