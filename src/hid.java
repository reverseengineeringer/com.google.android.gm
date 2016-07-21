import java.util.Map.Entry;

public final class hid<K, V>
  extends hdu<K, V>
{
  public static final hid<Object, Object> b = new hid(null, null, hel.a, 0, 0);
  final transient her<K, V>[] c;
  final transient Map.Entry<K, V>[] d;
  final transient int e;
  final transient int f;
  private final transient her<K, V>[] g;
  private transient hdu<V, K> h;
  
  private hid(her<K, V>[] paramArrayOfher1, her<K, V>[] paramArrayOfher2, Map.Entry<K, V>[] paramArrayOfEntry, int paramInt1, int paramInt2)
  {
    g = paramArrayOfher1;
    c = paramArrayOfher2;
    d = paramArrayOfEntry;
    e = paramInt1;
    f = paramInt2;
  }
  
  static <K, V> hid<K, V> a(int paramInt, Map.Entry<K, V>[] paramArrayOfEntry)
  {
    hbe.b(paramInt, paramArrayOfEntry.length);
    int i = hdr.a(paramInt, 1.2D);
    int m = i - 1;
    her[] arrayOfher1 = new her[i];
    her[] arrayOfher2 = new her[i];
    Object localObject2;
    int j;
    Map.Entry<K, V> localEntry;
    Object localObject3;
    Object localObject4;
    int n;
    int i1;
    int i2;
    int i3;
    her localher2;
    her localher1;
    Object localObject1;
    if (paramInt == paramArrayOfEntry.length)
    {
      localObject2 = paramArrayOfEntry;
      j = 0;
      i = 0;
      if (i >= paramInt) {
        break label319;
      }
      localEntry = paramArrayOfEntry[i];
      localObject3 = localEntry.getKey();
      localObject4 = localEntry.getValue();
      hcw.a(localObject3, localObject4);
      n = localObject3.hashCode();
      i1 = localObject4.hashCode();
      i2 = hdr.a(n) & m;
      i3 = hdr.a(i1) & m;
      localher2 = arrayOfher1[i2];
      hij.a(localObject3, localEntry, localher2);
      localher1 = arrayOfher2[i3];
      localObject1 = localher1;
      label141:
      if (localObject1 == null) {
        break label198;
      }
      if (localObject4.equals(((her)localObject1).getValue())) {
        break label192;
      }
    }
    label192:
    for (boolean bool = true;; bool = false)
    {
      a(bool, "value", localEntry, (Map.Entry)localObject1);
      localObject1 = ((her)localObject1).b();
      break label141;
      localObject2 = new her[paramInt];
      break;
    }
    label198:
    int k;
    if ((localher1 == null) && (localher2 == null)) {
      if (((localEntry instanceof her)) && (((her)localEntry).c()))
      {
        k = 1;
        label230:
        if (k == 0) {
          break label283;
        }
        localObject1 = (her)localEntry;
      }
    }
    for (;;)
    {
      arrayOfher1[i2] = localObject1;
      arrayOfher2[i3] = localObject1;
      localObject2[i] = localObject1;
      j += (n ^ i1);
      i += 1;
      break;
      k = 0;
      break label230;
      label283:
      localObject1 = new her(localObject3, localObject4);
      continue;
      localObject1 = new hes(localObject3, localObject4, localher2, localher1);
    }
    label319:
    return new hid(arrayOfher1, arrayOfher2, (Map.Entry[])localObject2, m, j);
  }
  
  public final hdu<V, K> b()
  {
    if (isEmpty()) {
      localObject = b;
    }
    hdu localhdu;
    do
    {
      return (hdu<V, K>)localObject;
      localhdu = h;
      localObject = localhdu;
    } while (localhdu != null);
    Object localObject = new hie(this);
    h = ((hdu)localObject);
    return (hdu<V, K>)localObject;
  }
  
  final boolean d()
  {
    return false;
  }
  
  public final V get(Object paramObject)
  {
    if (g == null) {
      return null;
    }
    return (V)hij.a(paramObject, g, e);
  }
  
  final hfd<Map.Entry<K, V>> h()
  {
    if (isEmpty()) {
      return hik.a;
    }
    return new hew(this, d);
  }
  
  public final int hashCode()
  {
    return f;
  }
  
  final boolean k()
  {
    return true;
  }
  
  public final int size()
  {
    return d.length;
  }
}

/* Location:
 * Qualified Name:     hid
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */