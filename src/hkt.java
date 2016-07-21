import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class hkt
  extends AbstractList<Integer>
  implements Serializable, RandomAccess
{
  private static final long serialVersionUID = 0L;
  final int[] a;
  final int b;
  final int c;
  
  public hkt(int[] paramArrayOfInt)
  {
    this(paramArrayOfInt, 0, paramArrayOfInt.length);
  }
  
  private hkt(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    a = paramArrayOfInt;
    b = paramInt1;
    c = paramInt2;
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      int[] arrayOfInt = a;
      int j = ((Integer)paramObject).intValue();
      int i = b;
      int k = c;
      if (i < k) {
        if (arrayOfInt[i] != j) {}
      }
      for (;;)
      {
        if (i == -1) {
          break label65;
        }
        return true;
        i += 1;
        break;
        i = -1;
      }
    }
    label65:
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof hkt)) {
        break;
      }
      paramObject = (hkt)paramObject;
      int j = size();
      if (((hkt)paramObject).size() != j) {
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
      j = j * 31 + a[i];
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    int k = -1;
    int j = k;
    int i;
    if ((paramObject instanceof Integer))
    {
      int[] arrayOfInt = a;
      j = ((Integer)paramObject).intValue();
      i = b;
      int m = c;
      if (i >= m) {
        break label75;
      }
      if (arrayOfInt[i] != j) {
        break label68;
      }
    }
    for (;;)
    {
      j = k;
      if (i >= 0) {
        j = i - b;
      }
      return j;
      label68:
      i += 1;
      break;
      label75:
      i = -1;
    }
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    int k = -1;
    int j = k;
    int i;
    if ((paramObject instanceof Integer))
    {
      int[] arrayOfInt = a;
      j = ((Integer)paramObject).intValue();
      int m = b;
      i = c - 1;
      if (i < m) {
        break label77;
      }
      if (arrayOfInt[i] != j) {
        break label70;
      }
    }
    for (;;)
    {
      j = k;
      if (i >= 0) {
        j = i - b;
      }
      return j;
      label70:
      i -= 1;
      break;
      label77:
      i = -1;
    }
  }
  
  public final int size()
  {
    return c - b;
  }
  
  public final List<Integer> subList(int paramInt1, int paramInt2)
  {
    hbe.a(paramInt1, paramInt2, size());
    if (paramInt1 == paramInt2) {
      return Collections.emptyList();
    }
    return new hkt(a, b + paramInt1, b + paramInt2);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(size() * 5);
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
 * Qualified Name:     hkt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */