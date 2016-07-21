import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

abstract class hhr<K, V>
  extends AbstractMap<K, V>
{
  abstract Iterator<Map.Entry<K, V>> c();
  
  public void clear()
  {
    hfu.c(c());
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return new hhs(this);
  }
}

/* Location:
 * Qualified Name:     hhr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */