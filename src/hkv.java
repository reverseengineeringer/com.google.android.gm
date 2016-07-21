import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

final class hkv
  extends AbstractList<Long>
  implements Serializable, RandomAccess
{
  private static final long serialVersionUID = 0L;
  final long[] a;
  final int b;
  final int c;
  
  hkv(long[] paramArrayOfLong)
  {
    this(paramArrayOfLong, 0, paramArrayOfLong.length);
  }
  
  private hkv(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    a = paramArrayOfLong;
    b = paramInt1;
    c = paramInt2;
  }
  
  public final boolean contains(Object paramObject)
  {
    return ((paramObject instanceof Long)) && (hku.b(a, ((Long)paramObject).longValue(), b, c) != -1);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof hkv)) {
        break;
      }
      paramObject = (hkv)paramObject;
      int j = size();
      if (((hkv)paramObject).size() != j) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        if (a[(b + i)] != a[(b + i)]) {
          return false;
        }
        i += 1;
      }
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = b;
    while (i < c)
    {
      j = j * 31 + hku.a(a[i]);
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Long))
    {
      int i = hku.b(a, ((Long)paramObject).longValue(), b, c);
      if (i >= 0) {
        return i - b;
      }
    }
    return -1;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Long))
    {
      int i = hku.a(a, ((Long)paramObject).longValue(), b, c);
      if (i >= 0) {
        return i - b;
      }
    }
    return -1;
  }
  
  public final int size()
  {
    return c - b;
  }
  
  public final List<Long> subList(int paramInt1, int paramInt2)
  {
    hbe.a(paramInt1, paramInt2, size());
    if (paramInt1 == paramInt2) {
      return Collections.emptyList();
    }
    return new hkv(a, b + paramInt1, b + paramInt2);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(size() * 10);
    localStringBuilder.append('[').append(a[b]);
    int i = b + 1;
    while (i < c)
    {
      localStringBuilder.append(", ").append(a[i]);
      i += 1;
    }
    return ']';
  }
}

/* Location:
 * Qualified Name:     hkv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */