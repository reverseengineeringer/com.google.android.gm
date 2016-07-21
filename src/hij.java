import java.util.Map.Entry;

final class hij<K, V>
  extends hel<K, V>
{
  private static final long serialVersionUID = 0L;
  private final transient Map.Entry<K, V>[] b;
  private final transient her<K, V>[] c;
  private final transient int d;
  
  private hij(Map.Entry<K, V>[] paramArrayOfEntry, her<K, V>[] paramArrayOfher, int paramInt)
  {
    b = paramArrayOfEntry;
    c = paramArrayOfher;
    d = paramInt;
  }
  
  static <K, V> hij<K, V> a(int paramInt, Map.Entry<K, V>[] paramArrayOfEntry)
  {
    hbe.b(paramInt, paramArrayOfEntry.length);
    Object localObject2;
    int i;
    her[] arrayOfher;
    int k;
    label37:
    Object localObject1;
    Object localObject3;
    Object localObject4;
    int m;
    her localher;
    int j;
    if (paramInt == paramArrayOfEntry.length)
    {
      localObject2 = paramArrayOfEntry;
      i = hdr.a(paramInt, 1.2D);
      arrayOfher = new her[i];
      k = i - 1;
      i = 0;
      if (i >= paramInt) {
        break label206;
      }
      localObject1 = paramArrayOfEntry[i];
      localObject3 = ((Map.Entry)localObject1).getKey();
      localObject4 = ((Map.Entry)localObject1).getValue();
      hcw.a(localObject3, localObject4);
      m = hdr.a(localObject3.hashCode()) & k;
      localher = arrayOfher[m];
      if (localher != null) {
        break label188;
      }
      if ((!(localObject1 instanceof her)) || (!((her)localObject1).c())) {
        break label167;
      }
      j = 1;
      label118:
      if (j == 0) {
        break label172;
      }
      localObject1 = (her)localObject1;
    }
    for (;;)
    {
      arrayOfher[m] = localObject1;
      localObject2[i] = localObject1;
      a(localObject3, (Map.Entry)localObject1, localher);
      i += 1;
      break label37;
      localObject2 = new her[paramInt];
      break;
      label167:
      j = 0;
      break label118;
      label172:
      localObject1 = new her(localObject3, localObject4);
      continue;
      label188:
      localObject1 = new het(localObject3, localObject4, localher);
    }
    label206:
    return new hij((Map.Entry[])localObject2, arrayOfher, k);
  }
  
  static <V> V a(Object paramObject, her<?, V>[] paramArrayOfher, int paramInt)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return null;
      for (paramArrayOfher = paramArrayOfher[(hdr.a(paramObject.hashCode()) & paramInt)]; paramArrayOfher != null; paramArrayOfher = paramArrayOfher.a()) {
        if (paramObject.equals(paramArrayOfher.getKey())) {
          return (V)paramArrayOfher.getValue();
        }
      }
    }
  }
  
  static void a(Object paramObject, Map.Entry<?, ?> paramEntry, her<?, ?> paramher)
  {
    if (paramher != null)
    {
      if (!paramObject.equals(paramher.getKey())) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool, "key", paramEntry, paramher);
        paramher = paramher.a();
        break;
      }
    }
  }
  
  final boolean d()
  {
    return false;
  }
  
  public final V get(Object paramObject)
  {
    return (V)a(paramObject, c, d);
  }
  
  final hfd<Map.Entry<K, V>> h()
  {
    return new hew(this, b);
  }
  
  public final int size()
  {
    return b.length;
  }
}

/* Location:
 * Qualified Name:     hij
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */