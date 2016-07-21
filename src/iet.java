import java.util.HashMap;
import java.util.Map;

public class iet
  implements iev
{
  private Map<String, iev> a = new HashMap();
  private iev b = new ifb();
  
  public final ieu a(String paramString1, String paramString2, String paramString3)
  {
    iev localiev2 = (iev)a.get(paramString1.toLowerCase());
    iev localiev1 = localiev2;
    if (localiev2 == null) {
      localiev1 = b;
    }
    return localiev1.a(paramString1, paramString2, paramString3);
  }
  
  public final void a(String paramString, iev paramiev)
  {
    a.put(paramString.toLowerCase(), paramiev);
  }
}

/* Location:
 * Qualified Name:     iet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */