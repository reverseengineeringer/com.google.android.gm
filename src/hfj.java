import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.NavigableMap;

public final class hfj<K, V>
  extends hfo<K, V>
  implements NavigableMap<K, V>
{
  private static final Comparator<Comparable> d = hhy.a;
  private static final hfj<Comparable, Object> e = new hfj(hfp.a(hhy.a), hii.a);
  private static final long serialVersionUID = 0L;
  final transient hil<K> b;
  final transient hef<V> c;
  private transient hfj<K, V> f;
  
  private hfj(hil<K> paramhil, hef<V> paramhef)
  {
    this(paramhil, paramhef, null);
  }
  
  private hfj(hil<K> paramhil, hef<V> paramhef, hfj<K, V> paramhfj)
  {
    b = paramhil;
    c = paramhef;
    f = paramhfj;
  }
  
  private final hfj<K, V> a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    if (paramInt1 == paramInt2) {
      return a(comparator());
    }
    return new hfj(b.a(paramInt1, paramInt2), c.a(paramInt1, paramInt2));
  }
  
  private final hfj<K, V> a(K paramK, boolean paramBoolean)
  {
    return a(0, b.e(hbe.a(paramK), paramBoolean));
  }
  
  private final hfj<K, V> a(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
  {
    hbe.a(paramK1);
    hbe.a(paramK2);
    if (comparator().compare(paramK1, paramK2) <= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalArgumentException(hbe.a("expected fromKey <= toKey but %s > %s", new Object[] { paramK1, paramK2 }));
    }
    return a(paramK2, paramBoolean2).b(paramK1, paramBoolean1);
  }
  
  static <K, V> hfj<K, V> a(Comparator<? super K> paramComparator)
  {
    if (hhy.a.equals(paramComparator)) {
      return e;
    }
    return new hfj(hfp.a(paramComparator), hii.a);
  }
  
  static <K, V> hfj<K, V> a(Comparator<? super K> paramComparator, K paramK, V paramV)
  {
    return new hfj(new hil(hef.a(paramK), (Comparator)hbe.a(paramComparator)), hef.a(paramV));
  }
  
  static <K, V> hfj<K, V> a(Comparator<? super K> paramComparator, boolean paramBoolean, Map.Entry<K, V>[] paramArrayOfEntry, int paramInt)
  {
    Object[] arrayOfObject1;
    Object[] arrayOfObject2;
    Object localObject1;
    int i;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      arrayOfObject1 = new Object[paramInt];
      arrayOfObject2 = new Object[paramInt];
      Arrays.sort(paramArrayOfEntry, 0, paramInt, hia.a(paramComparator).a(hhk.a()));
      localObject1 = paramArrayOfEntry[0].getKey();
      arrayOfObject1[0] = localObject1;
      arrayOfObject2[0] = paramArrayOfEntry[0].getValue();
      i = 1;
      if (i >= paramInt) {
        break label207;
      }
      localObject2 = paramArrayOfEntry[i].getKey();
      Object localObject3 = paramArrayOfEntry[i].getValue();
      hcw.a(localObject2, localObject3);
      arrayOfObject1[i] = localObject2;
      arrayOfObject2[i] = localObject3;
      if (paramComparator.compare(localObject1, localObject2) == 0) {
        break;
      }
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramBoolean, "key", paramArrayOfEntry[(i - 1)], paramArrayOfEntry[i]);
      i += 1;
      localObject1 = localObject2;
      break;
      return a(paramComparator);
      return a(paramComparator, paramArrayOfEntry[0].getKey(), paramArrayOfEntry[0].getValue());
    }
    label207:
    return new hfj(new hil(new hii(arrayOfObject1), paramComparator), new hii(arrayOfObject2));
  }
  
  private final hfj<K, V> b(K paramK, boolean paramBoolean)
  {
    return a(b.f(hbe.a(paramK), paramBoolean), size());
  }
  
  public final hdx<V> c()
  {
    return c;
  }
  
  public final Map.Entry<K, V> ceilingEntry(K paramK)
  {
    return b(paramK, true).firstEntry();
  }
  
  public final K ceilingKey(K paramK)
  {
    return (K)hhk.b(ceilingEntry(paramK));
  }
  
  public final Comparator<? super K> comparator()
  {
    return b.comparator();
  }
  
  final boolean d()
  {
    return (b.d.e()) || (c.e());
  }
  
  public final Map.Entry<K, V> firstEntry()
  {
    if (isEmpty()) {
      return null;
    }
    return (Map.Entry)super.g().f().get(0);
  }
  
  public final K firstKey()
  {
    return (K)b.first();
  }
  
  public final Map.Entry<K, V> floorEntry(K paramK)
  {
    return a(paramK, true).lastEntry();
  }
  
  public final K floorKey(K paramK)
  {
    return (K)hhk.b(floorEntry(paramK));
  }
  
  public final hfd<Map.Entry<K, V>> g()
  {
    return super.g();
  }
  
  public final V get(Object paramObject)
  {
    int i = b.a(paramObject);
    if (i == -1) {
      return null;
    }
    return (V)c.get(i);
  }
  
  final hfd<Map.Entry<K, V>> h()
  {
    if (isEmpty()) {
      return hik.a;
    }
    return new hfk(this);
  }
  
  public final Map.Entry<K, V> higherEntry(K paramK)
  {
    return b(paramK, false).firstEntry();
  }
  
  public final K higherKey(K paramK)
  {
    return (K)hhk.b(higherEntry(paramK));
  }
  
  public final Map.Entry<K, V> lastEntry()
  {
    if (isEmpty()) {
      return null;
    }
    return (Map.Entry)super.g().f().get(size() - 1);
  }
  
  public final K lastKey()
  {
    return (K)b.last();
  }
  
  public final Map.Entry<K, V> lowerEntry(K paramK)
  {
    return a(paramK, false).lastEntry();
  }
  
  public final K lowerKey(K paramK)
  {
    return (K)hhk.b(lowerEntry(paramK));
  }
  
  @Deprecated
  public final Map.Entry<K, V> pollFirstEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final Map.Entry<K, V> pollLastEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public final int size()
  {
    return c.size();
  }
  
  final Object writeReplace()
  {
    return new hfn(this);
  }
}

/* Location:
 * Qualified Name:     hfj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */