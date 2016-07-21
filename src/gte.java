import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Set;

public class gte<K, V>
  extends AbstractMap<K, V>
  implements Cloneable
{
  int a;
  Object[] b;
  
  private final int a(Object paramObject)
  {
    int j = a;
    Object[] arrayOfObject = b;
    int i = 0;
    while (i < j << 1)
    {
      Object localObject = arrayOfObject[i];
      if (paramObject == null)
      {
        if (localObject != null) {}
      }
      else {
        while (paramObject.equals(localObject)) {
          return i;
        }
      }
      i += 2;
    }
    return -2;
  }
  
  private final void a(int paramInt, K paramK, V paramV)
  {
    Object[] arrayOfObject = b;
    arrayOfObject[paramInt] = paramK;
    arrayOfObject[(paramInt + 1)] = paramV;
  }
  
  private final V c(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    return (V)b[paramInt];
  }
  
  public final gte<K, V> a()
  {
    try
    {
      gte localgte = (gte)super.clone();
      Object[] arrayOfObject1 = b;
      if (arrayOfObject1 != null)
      {
        int i = arrayOfObject1.length;
        Object[] arrayOfObject2 = new Object[i];
        b = arrayOfObject2;
        System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      }
      return localgte;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public final V a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a)) {
      return null;
    }
    return (V)c((paramInt << 1) + 1);
  }
  
  public final V a(int paramInt, V paramV)
  {
    int i = a;
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IndexOutOfBoundsException();
    }
    paramInt = (paramInt << 1) + 1;
    Object localObject = c(paramInt);
    b[paramInt] = paramV;
    return (V)localObject;
  }
  
  final V b(int paramInt)
  {
    int i = a << 1;
    if ((paramInt < 0) || (paramInt >= i)) {
      return null;
    }
    Object localObject = c(paramInt + 1);
    Object[] arrayOfObject = b;
    int j = i - paramInt - 2;
    if (j != 0) {
      System.arraycopy(arrayOfObject, paramInt + 2, arrayOfObject, paramInt, j);
    }
    a -= 1;
    a(i - 2, null, null);
    return (V)localObject;
  }
  
  public void clear()
  {
    a = 0;
    b = null;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return -2 != a(paramObject);
  }
  
  public final boolean containsValue(Object paramObject)
  {
    int j = a;
    Object[] arrayOfObject = b;
    int i = 1;
    while (i < j << 1)
    {
      Object localObject = arrayOfObject[i];
      if (paramObject == null)
      {
        if (localObject != null) {}
      }
      else {
        while (paramObject.equals(localObject)) {
          return true;
        }
      }
      i += 2;
    }
    return false;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return new gth(this);
  }
  
  public final V get(Object paramObject)
  {
    return (V)c(a(paramObject) + 1);
  }
  
  public final V put(K paramK, V paramV)
  {
    int j = a(paramK) >> 1;
    if (j == -1) {
      j = a;
    }
    for (;;)
    {
      if (j < 0) {
        throw new IndexOutOfBoundsException();
      }
      int n = j + 1;
      if (n < 0) {
        throw new IndexOutOfBoundsException();
      }
      Object localObject = b;
      int k = n << 1;
      int i;
      if (localObject == null)
      {
        i = 0;
        if (k > i)
        {
          int m = i / 2 * 3 + 1;
          i = m;
          if (m % 2 != 0) {
            i = m + 1;
          }
          if (i >= k) {
            break label223;
          }
          i = k;
        }
      }
      label223:
      for (;;)
      {
        if (i == 0) {
          b = null;
        }
        for (;;)
        {
          i = j << 1;
          localObject = c(i + 1);
          a(i, paramK, paramV);
          if (n > a) {
            a = n;
          }
          return (V)localObject;
          i = localObject.length;
          break;
          k = a;
          localObject = b;
          if ((k == 0) || (i != localObject.length))
          {
            Object[] arrayOfObject = new Object[i];
            b = arrayOfObject;
            if (k != 0) {
              System.arraycopy(localObject, 0, arrayOfObject, 0, k << 1);
            }
          }
        }
      }
    }
  }
  
  public final V remove(Object paramObject)
  {
    return (V)b(a(paramObject));
  }
  
  public final int size()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     gte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */