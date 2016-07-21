import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class bdm
{
  public HashMap<String, String> a;
  
  public bdm()
  {
    a = new HashMap();
  }
  
  public bdm(String paramString)
  {
    a = bdl.b(paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      a.remove(paramString1);
      return;
    }
    a.put(paramString1, paramString2);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append('\001');
      }
      localStringBuilder.append((String)localEntry.getValue());
      localStringBuilder.append('\002');
      localStringBuilder.append((String)localEntry.getKey());
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     bdm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */