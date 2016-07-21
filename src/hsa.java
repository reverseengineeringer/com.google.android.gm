import java.util.HashMap;
import java.util.Map;

public class hsa
{
  private final Map a = new HashMap();
  private final Map b = new HashMap();
  
  protected final void a(String paramString, Object paramObject)
  {
    a.put(paramString, paramObject);
  }
  
  protected final Object a_(String paramString)
  {
    Object localObject2 = a.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = b.get(paramString);
    }
    return localObject1;
  }
}

/* Location:
 * Qualified Name:     hsa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */