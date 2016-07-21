import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

final class hpz
  implements Serializable, List
{
  @Deprecated
  private static final long serialVersionUID = -8660955369431018984L;
  @Deprecated
  final int a;
  @Deprecated
  int b;
  @Deprecated
  transient Object[] c;
  
  hpz(hpw paramhpw, int paramInt1, int paramInt2)
  {
    a = paramInt1;
    b = paramInt2;
    c = a;
  }
  
  private final void readObject(ObjectInputStream arg1)
  {
    ???.defaultReadObject();
    synchronized (d)
    {
      c = d.a;
      return;
    }
  }
  
  private final void writeObject(ObjectOutputStream arg1)
  {
    synchronized (d)
    {
      if (d.a != c) {
        throw new ConcurrentModificationException();
      }
    }
    ???.defaultWriteObject();
    synchronized (d)
    {
      if (d.a != c) {
        throw new ConcurrentModificationException();
      }
    }
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    hpw localhpw = d;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt > b) {
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + b);
      }
    }
    finally
    {
      throw ((Throwable)paramObject);
      Object[] arrayOfObject1 = d.a;
      if (arrayOfObject1 != c) {
        throw new ConcurrentModificationException();
      }
      int i = arrayOfObject1.length;
      Object[] arrayOfObject2 = new Object[i + 1];
      paramInt = a + paramInt;
      i -= paramInt;
      System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, paramInt);
      arrayOfObject2[paramInt] = paramObject;
      if (i > 0) {
        System.arraycopy(arrayOfObject1, paramInt, arrayOfObject2, paramInt + 1, i);
      }
      d.a = arrayOfObject2;
      c = arrayOfObject2;
    }
  }
  
  public final boolean add(Object paramObject)
  {
    add(b, paramObject);
    return true;
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    int j = paramCollection.size();
    hpw localhpw = d;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt >= b) {
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + b);
      }
    }
    finally
    {
      throw paramCollection;
      Object[] arrayOfObject1 = d.a;
      if (arrayOfObject1 != c) {
        throw new ConcurrentModificationException();
      }
      if (j == 0) {
        return false;
      }
      int k = arrayOfObject1.length;
      Object[] arrayOfObject2 = new Object[k + j];
      int i = a + paramInt;
      System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      k -= i;
      paramCollection = paramCollection.iterator();
      paramInt = i;
      while (paramCollection.hasNext())
      {
        arrayOfObject2[paramInt] = paramCollection.next();
        paramInt += 1;
      }
      if (k > 0) {
        System.arraycopy(arrayOfObject1, i, arrayOfObject2, paramInt, k);
      }
      d.a = arrayOfObject2;
      c = arrayOfObject2;
    }
    return true;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    return addAll(b, paramCollection);
  }
  
  public final void clear()
  {
    synchronized (d)
    {
      Object[] arrayOfObject1 = d.a;
      if (arrayOfObject1 != c) {
        throw new ConcurrentModificationException();
      }
    }
    int i = localObject.length;
    Object[] arrayOfObject2 = new Object[i - b];
    i = i - a - b;
    if (a > 0) {
      System.arraycopy(localObject, 0, arrayOfObject2, 0, a);
    }
    if (i > 0) {
      System.arraycopy(localObject, a + b, arrayOfObject2, a, i);
    }
    d.a = arrayOfObject2;
    c = arrayOfObject2;
    b = 0;
  }
  
  public final boolean contains(Object paramObject)
  {
    return hpw.a(d.a, paramObject, a, a + b) >= 0;
  }
  
  public final boolean containsAll(Collection paramCollection)
  {
    Object[] arrayOfObject = d.a;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (hpw.a(arrayOfObject, paramCollection.next(), a, b) < 0) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    int i;
    int j;
    do
    {
      return true;
      if (!(paramObject instanceof List)) {
        return false;
      }
      Object[] arrayOfObject;
      synchronized (d)
      {
        arrayOfObject = d.a;
        if (arrayOfObject != c) {
          throw new ConcurrentModificationException();
        }
      }
      i = a + b;
      paramObject = ((List)paramObject).listIterator();
      j = a;
      while ((j < i) && (((ListIterator)paramObject).hasNext())) {
        if (!hpw.a(arrayOfObject[j], ((ListIterator)paramObject).next())) {
          return false;
        }
      }
    } while ((j == i) && (!((ListIterator)paramObject).hasNext()));
    return false;
  }
  
  public final Object get(int paramInt)
  {
    return d.a[(a + paramInt)];
  }
  
  public final int hashCode()
  {
    synchronized (d)
    {
      Object[] arrayOfObject = d.a;
      if (arrayOfObject != c) {
        throw new ConcurrentModificationException();
      }
    }
    int m = a;
    int n = b;
    int j = a;
    int i = 1;
    if (j < n + m)
    {
      ??? = localObject[j];
      if (??? == null) {}
      for (int k = 0;; k = ???.hashCode())
      {
        j += 1;
        i = i * 31 + k;
        break;
      }
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    int i = hpw.a(d.a, paramObject, a, a + b);
    if (i >= 0) {
      return i - a;
    }
    return -1;
  }
  
  public final boolean isEmpty()
  {
    return b == 0;
  }
  
  public final Iterator iterator()
  {
    return listIterator();
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    int i = hpw.b(d.a, paramObject, a, a + b) - a;
    if (i >= 0) {
      return i - a;
    }
    return -1;
  }
  
  public final ListIterator listIterator()
  {
    synchronized (d)
    {
      Object[] arrayOfObject1 = d.a;
      if (arrayOfObject1 != c) {
        throw new ConcurrentModificationException();
      }
    }
    hpy localhpy = new hpy(arrayOfObject2, a, a + b, a);
    return localhpy;
  }
  
  public final ListIterator listIterator(int paramInt)
  {
    hpw localhpw = d;
    if (paramInt >= 0) {}
    Object localObject2;
    try
    {
      if (paramInt >= b) {
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + b);
      }
    }
    finally
    {
      throw ((Throwable)localObject1);
      localObject2 = d.a;
      if (localObject2 != c) {
        throw new ConcurrentModificationException();
      }
    }
    return (ListIterator)localObject2;
  }
  
  public final Object remove(int paramInt)
  {
    hpw localhpw = d;
    if (paramInt >= 0) {}
    Object localObject2;
    try
    {
      if (paramInt >= b) {
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + b);
      }
    }
    finally
    {
      throw ((Throwable)localObject1);
      Object[] arrayOfObject1 = d.a;
      if (arrayOfObject1 != c) {
        throw new ConcurrentModificationException();
      }
      int j = arrayOfObject1.length;
      int i = a + paramInt;
      localObject2 = arrayOfObject1[i];
      Object[] arrayOfObject2 = new Object[j - 1];
      j = j - i - 1;
      if (paramInt > 0) {
        System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      }
      if (j > 0) {
        System.arraycopy(arrayOfObject1, i + 1, arrayOfObject2, i, j);
      }
      d.a = arrayOfObject2;
      c = arrayOfObject2;
    }
    return localObject2;
  }
  
  public final boolean remove(Object paramObject)
  {
    Object[] arrayOfObject;
    synchronized (d)
    {
      arrayOfObject = d.a;
      if (arrayOfObject != c) {
        throw new ConcurrentModificationException();
      }
    }
    int j = arrayOfObject.length;
    int i = hpw.a(arrayOfObject, paramObject, a, b);
    if (i < 0) {
      return false;
    }
    paramObject = new Object[j - 1];
    j = b - i - 1;
    if (i > 0) {
      System.arraycopy(arrayOfObject, 0, paramObject, 0, i);
    }
    if (j > 0) {
      System.arraycopy(arrayOfObject, i + 1, paramObject, i, j);
    }
    d.a = ((Object[])paramObject);
    c = ((Object[])paramObject);
    b -= 1;
    return true;
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return false;
    }
    Object[] arrayOfObject1;
    synchronized (d)
    {
      arrayOfObject1 = d.a;
      if (arrayOfObject1 != c) {
        throw new ConcurrentModificationException();
      }
    }
    int m = arrayOfObject1.length;
    Object[] arrayOfObject2 = new Object[b];
    int j = a;
    int i = 0;
    for (;;)
    {
      if (j < a + b)
      {
        Object localObject = arrayOfObject1[j];
        if (!paramCollection.contains(localObject))
        {
          int k = i + 1;
          arrayOfObject2[i] = localObject;
          i = k;
        }
      }
      else
      {
        if (i == b) {
          return false;
        }
        paramCollection = new Object[m + i - b];
        j = m - a - b;
        if (a > 0) {
          System.arraycopy(arrayOfObject1, 0, paramCollection, 0, a);
        }
        if (i > 0) {
          System.arraycopy(arrayOfObject2, 0, paramCollection, a, i);
        }
        if (j > 0) {
          System.arraycopy(arrayOfObject1, a + b, paramCollection, a + i, j);
        }
        d.a = paramCollection;
        c = paramCollection;
        b = i;
        return true;
      }
      j += 1;
    }
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    Object[] arrayOfObject1;
    synchronized (d)
    {
      arrayOfObject1 = d.a;
      if (arrayOfObject1 != c) {
        throw new ConcurrentModificationException();
      }
    }
    int m = arrayOfObject1.length;
    Object[] arrayOfObject2 = new Object[b];
    int j = a;
    int i = 0;
    for (;;)
    {
      if (j < a + b)
      {
        Object localObject = arrayOfObject1[j];
        if (paramCollection.contains(localObject))
        {
          int k = i + 1;
          arrayOfObject2[i] = localObject;
          i = k;
        }
      }
      else
      {
        if (i == b) {
          return false;
        }
        paramCollection = new Object[m + i - b];
        j = m - a - b;
        if (a > 0) {
          System.arraycopy(arrayOfObject1, 0, paramCollection, 0, a);
        }
        if (i > 0) {
          System.arraycopy(arrayOfObject2, 0, paramCollection, a, i);
        }
        if (j > 0) {
          System.arraycopy(arrayOfObject1, a + b, paramCollection, a + i, j);
        }
        d.a = paramCollection;
        c = paramCollection;
        b = i;
        return true;
      }
      j += 1;
    }
  }
  
  public final Object set(int paramInt, Object paramObject)
  {
    hpw localhpw = d;
    if (paramInt >= 0) {}
    Object[] arrayOfObject2;
    try
    {
      if (paramInt >= b) {
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + b);
      }
    }
    finally
    {
      throw ((Throwable)paramObject);
      Object[] arrayOfObject1 = d.a;
      if (arrayOfObject1 != c) {
        throw new ConcurrentModificationException();
      }
      int i = arrayOfObject1.length;
      Object localObject = arrayOfObject1[(a + paramInt)];
      if (localObject == paramObject)
      {
        d.a = arrayOfObject1;
        return localObject;
      }
      arrayOfObject2 = new Object[i];
      System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      arrayOfObject2[(a + paramInt)] = paramObject;
      d.a = arrayOfObject2;
    }
  }
  
  public final int size()
  {
    return b;
  }
  
  public final List subList(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 > b) || (paramInt1 > paramInt2)) {
      throw new IndexOutOfBoundsException();
    }
    return new hpz(d, a + paramInt1, paramInt2 - paramInt1);
  }
  
  public final Object[] toArray()
  {
    Object[] arrayOfObject1 = d.a;
    Object[] arrayOfObject2 = new Object[b];
    System.arraycopy(arrayOfObject1, a, arrayOfObject2, 0, b);
    return arrayOfObject2;
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject2 = d.a;
    Object[] arrayOfObject1;
    if (paramArrayOfObject.length < b)
    {
      arrayOfObject1 = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), b);
      System.arraycopy(arrayOfObject2, a, arrayOfObject1, 0, b);
    }
    do
    {
      return arrayOfObject1;
      System.arraycopy(arrayOfObject2, a, paramArrayOfObject, 0, b);
      arrayOfObject1 = paramArrayOfObject;
    } while (paramArrayOfObject.length <= b);
    paramArrayOfObject[b] = null;
    return paramArrayOfObject;
  }
  
  public final String toString()
  {
    synchronized (d)
    {
      Object[] arrayOfObject = d.a;
      if (arrayOfObject != c) {
        throw new ConcurrentModificationException();
      }
    }
    int j = a;
    int k = b;
    ??? = new StringBuffer();
    ((StringBuffer)???).append('[');
    int i = a;
    while (i < k + j)
    {
      if (i > a) {
        ((StringBuffer)???).append(", ");
      }
      ((StringBuffer)???).append(localObject2[i]);
      i += 1;
    }
    ((StringBuffer)???).append(']');
    return ((StringBuffer)???).toString();
  }
}

/* Location:
 * Qualified Name:     hpz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */