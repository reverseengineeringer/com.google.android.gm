import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class ikd
  extends LinkedHashMap
{
  private int a = -1;
  
  ikd()
  {
    super(16, 0.75F, true);
  }
  
  protected final boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return (a >= 0) && (size() > a);
  }
}

/* Location:
 * Qualified Name:     ikd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */