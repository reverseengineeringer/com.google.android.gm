import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public final class hso
  implements Serializable, List
{
  private static final long serialVersionUID = -3700862452550012357L;
  public final hzm a;
  public hwq b;
  public boolean c;
  private final List d;
  
  public hso()
  {
    this((byte)0);
  }
  
  private hso(byte paramByte)
  {
    a = hzm.f;
    d = new ArrayList();
  }
  
  public hso(hzm paramhzm)
  {
    this(paramhzm, null);
  }
  
  private hso(hzm paramhzm, hwq paramhwq)
  {
    if (paramhzm == null) {}
    for (a = hzm.f;; a = paramhzm)
    {
      b = paramhwq;
      d = new ArrayList();
      return;
    }
  }
  
  public hso(String paramString, hzm paramhzm, hwq paramhwq)
  {
    this(paramhzm, paramhwq);
    paramString = new StringTokenizer(paramString, ",");
    while (paramString.hasMoreTokens()) {
      if (hzm.e.equals(a)) {
        add(new hsn(paramString.nextToken()));
      } else {
        add(new hsq(paramString.nextToken(), paramhwq));
      }
    }
  }
  
  public final void a(hwq paramhwq)
  {
    if (!hzm.e.equals(a))
    {
      Iterator localIterator = iterator();
      while (localIterator.hasNext()) {
        ((hsq)localIterator.next()).a(paramhwq);
      }
    }
    b = paramhwq;
    c = false;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!hzm.e.equals(a))
    {
      Iterator localIterator = iterator();
      while (localIterator.hasNext()) {
        ((hsq)localIterator.next()).a(paramBoolean);
      }
    }
    b = null;
    c = paramBoolean;
  }
  
  public final boolean a(hsn paramhsn)
  {
    if ((paramhsn instanceof hsq)) {
      if (c) {
        ((hsq)paramhsn).a(true);
      }
    }
    while (hzm.e.equals(a)) {
      for (;;)
      {
        return add(paramhsn);
        if (b != null) {
          ((hsq)paramhsn).a(b);
        }
      }
    }
    paramhsn = new hsq(paramhsn);
    paramhsn.a(b);
    return add(paramhsn);
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    d.add(paramInt, paramObject);
  }
  
  public final boolean add(Object paramObject)
  {
    if (!(paramObject instanceof hsn))
    {
      paramObject = String.valueOf(hsn.class.getName());
      if (((String)paramObject).length() != 0) {}
      for (paramObject = "Argument not a ".concat((String)paramObject);; paramObject = new String("Argument not a ")) {
        throw new IllegalArgumentException((String)paramObject);
      }
    }
    return d.add(paramObject);
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    return d.addAll(paramInt, paramCollection);
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    return d.addAll(paramCollection);
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
    paramObject = (hso)paramObject;
    return idkad, d).a(a, a).a(b, b).a(c, c).a;
  }
  
  public final Object get(int paramInt)
  {
    return d.get(paramInt);
  }
  
  public final int hashCode()
  {
    return idlad).a(a).a(b).a(c).a;
  }
  
  public final int indexOf(Object paramObject)
  {
    return d.indexOf(paramObject);
  }
  
  public final boolean isEmpty()
  {
    return d.isEmpty();
  }
  
  public final Iterator iterator()
  {
    return d.iterator();
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    return d.lastIndexOf(paramObject);
  }
  
  public final ListIterator listIterator()
  {
    return d.listIterator();
  }
  
  public final ListIterator listIterator(int paramInt)
  {
    return d.listIterator(paramInt);
  }
  
  public final Object remove(int paramInt)
  {
    return d.remove(paramInt);
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
  
  public final Object set(int paramInt, Object paramObject)
  {
    return d.set(paramInt, paramObject);
  }
  
  public final int size()
  {
    return d.size();
  }
  
  public final List subList(int paramInt1, int paramInt2)
  {
    return d.subList(paramInt1, paramInt2);
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
      localStringBuffer.append(localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuffer.append(',');
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hso
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */