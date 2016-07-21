import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class hud
  implements Serializable, Set
{
  private static final long serialVersionUID = -2317587285790834492L;
  public hwq a;
  public boolean b;
  public final boolean c;
  private final Set d;
  
  public hud()
  {
    this((byte)0);
  }
  
  private hud(byte paramByte)
  {
    this(true, false);
  }
  
  public hud(String paramString)
  {
    this();
    paramString = new StringTokenizer(paramString, ",");
    while (paramString.hasMoreTokens()) {
      add(new huc(paramString.nextToken()));
    }
  }
  
  public hud(boolean paramBoolean1, boolean paramBoolean2)
  {
    b = paramBoolean1;
    c = paramBoolean2;
    if (paramBoolean2)
    {
      d = Collections.EMPTY_SET;
      return;
    }
    d = new TreeSet();
  }
  
  public final boolean add(Object paramObject)
  {
    if (!(paramObject instanceof huc))
    {
      paramObject = String.valueOf(huc.class.getName());
      if (((String)paramObject).length() != 0) {}
      for (paramObject = "Argument not a ".concat((String)paramObject);; paramObject = new String("Argument not a ")) {
        throw new IllegalArgumentException((String)paramObject);
      }
    }
    return d.add(paramObject);
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      add(paramCollection.next());
    }
    return true;
  }
  
  public final void clear()
  {
    d.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return d.contains(paramObject);
  }
  
  public final boolean containsAll(Collection paramCollection)
  {
    return d.containsAll(paramCollection);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!getClass().isAssignableFrom(paramObject.getClass())) {
      return false;
    }
    paramObject = (hud)paramObject;
    return idkad, d).a(a, a).a(b, b).a;
  }
  
  public final int hashCode()
  {
    return idlad).a(a).a(b).a;
  }
  
  public final boolean isEmpty()
  {
    return d.isEmpty();
  }
  
  public final Iterator iterator()
  {
    return d.iterator();
  }
  
  public final boolean remove(Object paramObject)
  {
    return d.remove(paramObject);
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    return d.removeAll(paramCollection);
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    return d.retainAll(paramCollection);
  }
  
  public final int size()
  {
    return d.size();
  }
  
  public final Object[] toArray()
  {
    return d.toArray();
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    return d.toArray(paramArrayOfObject);
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(localIterator.next().toString());
      if (localIterator.hasNext()) {
        localStringBuffer.append(',');
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hud
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */