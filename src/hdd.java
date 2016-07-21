import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class hdd<K, V>
  extends hhr<K, V>
  implements hcu<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  transient hdg<K, V> a;
  transient int b;
  transient int c;
  private transient hdg<K, V>[] d;
  private transient hdg<K, V>[] e;
  private transient hdg<K, V> f;
  private transient int g;
  private transient hcu<V, K> h;
  
  public hdd(int paramInt)
  {
    a(16);
  }
  
  private final void a(int paramInt)
  {
    hcw.a(paramInt, "expectedSize");
    paramInt = hdr.a(paramInt, 1.0D);
    d = new hdg[paramInt];
    e = new hdg[paramInt];
    a = null;
    f = null;
    b = 0;
    g = (paramInt - 1);
    c = 0;
  }
  
  private final void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    a(16);
    int j = paramObjectInputStream.readInt();
    int i = 0;
    while (i < j)
    {
      put(paramObjectInputStream.readObject(), paramObjectInputStream.readObject());
      i += 1;
    }
  }
  
  private final void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(size());
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
  
  public final hcu<V, K> a()
  {
    if (h == null)
    {
      hdh localhdh = new hdh(this);
      h = localhdh;
      return localhdh;
    }
    return h;
  }
  
  final hdg<K, V> a(Object paramObject, int paramInt)
  {
    for (hdg localhdg = d[(g & paramInt)]; localhdg != null; localhdg = c) {
      if ((paramInt == a) && (hbc.a(paramObject, g))) {
        return localhdg;
      }
    }
    return null;
  }
  
  final void a(hdg<K, V> paramhdg)
  {
    hdg localhdg1 = null;
    int i = a & g;
    Object localObject1 = d[i];
    Object localObject2 = null;
    if (localObject1 == paramhdg) {
      if (localObject2 == null)
      {
        d[i] = c;
        label43:
        i = b;
        i = g & i;
        localObject1 = e[i];
        localObject2 = localhdg1;
        label66:
        if (localObject1 != paramhdg) {
          break label176;
        }
        if (localObject2 != null) {
          break label164;
        }
        e[i] = d;
        label86:
        if (f != null) {
          break label191;
        }
        a = e;
        label101:
        if (e != null) {
          break label205;
        }
        f = f;
      }
    }
    for (;;)
    {
      b -= 1;
      c += 1;
      return;
      c = c;
      break label43;
      hdg localhdg2 = c;
      localObject2 = localObject1;
      localObject1 = localhdg2;
      break;
      label164:
      d = d;
      break label86;
      label176:
      localhdg1 = d;
      localObject2 = localObject1;
      localObject1 = localhdg1;
      break label66;
      label191:
      f.e = e;
      break label101;
      label205:
      e.f = f;
    }
  }
  
  final void a(hdg<K, V> paramhdg1, hdg<K, V> paramhdg2)
  {
    int i = a & g;
    c = d[i];
    d[i] = paramhdg1;
    i = b & g;
    d = e[i];
    e[i] = paramhdg1;
    if (paramhdg2 == null)
    {
      f = f;
      e = null;
      if (f == null)
      {
        a = paramhdg1;
        f = paramhdg1;
      }
    }
    for (;;)
    {
      b += 1;
      c += 1;
      return;
      f.e = paramhdg1;
      break;
      f = f;
      if (f == null) {
        a = paramhdg1;
      }
      for (;;)
      {
        e = e;
        if (e != null) {
          break label174;
        }
        f = paramhdg1;
        break;
        f.e = paramhdg1;
      }
      label174:
      e.f = paramhdg1;
    }
  }
  
  final hdg<K, V> b(Object paramObject, int paramInt)
  {
    for (hdg localhdg = e[(g & paramInt)]; localhdg != null; localhdg = d) {
      if ((paramInt == b) && (hbc.a(paramObject, h))) {
        return localhdg;
      }
    }
    return null;
  }
  
  final void b()
  {
    Object localObject = d;
    int i = b;
    int j = localObject.length;
    if ((i > 1.0D * j) && (j < 1073741824)) {
      i = 1;
    }
    while (i != 0)
    {
      i = localObject.length * 2;
      d = new hdg[i];
      e = new hdg[i];
      g = (i - 1);
      b = 0;
      localObject = a;
      for (;;)
      {
        if (localObject != null)
        {
          a((hdg)localObject, (hdg)localObject);
          localObject = e;
          continue;
          i = 0;
          break;
        }
      }
      c += 1;
    }
  }
  
  final Iterator<Map.Entry<K, V>> c()
  {
    return new hde(this);
  }
  
  public final void clear()
  {
    b = 0;
    Arrays.fill(d, null);
    Arrays.fill(e, null);
    a = null;
    f = null;
    c += 1;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return a(paramObject, hdr.a(paramObject)) != null;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    return b(paramObject, hdr.a(paramObject)) != null;
  }
  
  public final V get(Object paramObject)
  {
    return (V)hhk.c(a(paramObject, hdr.a(paramObject)));
  }
  
  public final Set<K> keySet()
  {
    return new hdp(this);
  }
  
  public final V put(K paramK, V paramV)
  {
    int i = hdr.a(paramK);
    int j = hdr.a(paramV);
    hdg localhdg = a(paramK, i);
    if ((localhdg != null) && (j == b) && (hbc.a(paramV, h))) {
      return paramV;
    }
    if (b(paramV, j) != null)
    {
      paramK = String.valueOf(paramV);
      throw new IllegalArgumentException(String.valueOf(paramK).length() + 23 + "value already present: " + paramK);
    }
    paramK = new hdg(paramK, i, paramV, j);
    if (localhdg != null)
    {
      a(localhdg);
      a(paramK, localhdg);
      f = null;
      e = null;
      b();
      return (V)h;
    }
    a(paramK, null);
    b();
    return null;
  }
  
  public final V remove(Object paramObject)
  {
    paramObject = a(paramObject, hdr.a(paramObject));
    if (paramObject == null) {
      return null;
    }
    a((hdg)paramObject);
    f = null;
    e = null;
    return (V)h;
  }
  
  public final int size()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     hdd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */