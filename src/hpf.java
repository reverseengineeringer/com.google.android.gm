import java.util.AbstractMap;
import java.util.Set;

public abstract class hpf
  extends AbstractMap
{
  @Deprecated
  transient Set a;
  
  public Set keySet()
  {
    if (a == null) {
      a = new hpg(this);
    }
    return a;
  }
}

/* Location:
 * Qualified Name:     hpf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */