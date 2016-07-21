import java.util.AbstractMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class gua
  extends AbstractMap<String, Object>
  implements Cloneable
{
  Map<String, Object> b = new gte();
  public final gtr c;
  
  public gua()
  {
    this(EnumSet.noneOf(gud.class));
  }
  
  public gua(EnumSet<gud> paramEnumSet)
  {
    c = gtr.a(getClass(), paramEnumSet.contains(gud.a));
  }
  
  public gua b()
  {
    try
    {
      gua localgua = (gua)super.clone();
      gtt.a(this, localgua);
      b = ((Map)gtt.c(b));
      return localgua;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new IllegalStateException(localCloneNotSupportedException);
    }
  }
  
  public gua b(String paramString, Object paramObject)
  {
    Object localObject = c.a(paramString);
    if (localObject != null)
    {
      ((gtz)localObject).a(this, paramObject);
      return this;
    }
    localObject = paramString;
    if (c.b) {
      localObject = paramString.toLowerCase();
    }
    b.put(localObject, paramObject);
    return this;
  }
  
  public final Object d(String paramString, Object paramObject)
  {
    Object localObject = c.a(paramString);
    if (localObject != null)
    {
      paramString = ((gtz)localObject).a(this);
      ((gtz)localObject).a(this, paramObject);
      return paramString;
    }
    localObject = paramString;
    if (c.b) {
      localObject = paramString.toLowerCase();
    }
    return b.put(localObject, paramObject);
  }
  
  public Set<Map.Entry<String, Object>> entrySet()
  {
    return new guc(this);
  }
  
  public final Object get(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return null;
    }
    String str = (String)paramObject;
    paramObject = c.a(str);
    if (paramObject != null) {
      return ((gtz)paramObject).a(this);
    }
    paramObject = str;
    if (c.b) {
      paramObject = str.toLowerCase();
    }
    return b.get(paramObject);
  }
  
  public final void putAll(Map<? extends String, ?> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      b((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final Object remove(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return null;
    }
    String str = (String)paramObject;
    if (c.a(str) != null) {
      throw new UnsupportedOperationException();
    }
    paramObject = str;
    if (c.b) {
      paramObject = str.toLowerCase();
    }
    return b.remove(paramObject);
  }
}

/* Location:
 * Qualified Name:     gua
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */