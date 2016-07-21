import java.util.Map.Entry;

abstract class heu<K, V>
  extends hfd<Map.Entry<K, V>>
{
  boolean I_()
  {
    return c().k();
  }
  
  abstract hel<K, V> c();
  
  public boolean contains(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      Object localObject = c().get(((Map.Entry)paramObject).getKey());
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localObject.equals(((Map.Entry)paramObject).getValue())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  final boolean e()
  {
    return c().d();
  }
  
  public int hashCode()
  {
    return c().hashCode();
  }
  
  public int size()
  {
    return c().size();
  }
  
  Object writeReplace()
  {
    return new hev(c());
  }
}

/* Location:
 * Qualified Name:     heu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */