import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class hpw
  implements Serializable, Cloneable, List, RandomAccess
{
  @Deprecated
  private static final long serialVersionUID = 8673264195747942595L;
  @Deprecated
  volatile transient Object[] a = new Object[0];
  
  static int a(Object[] paramArrayOfObject, Object paramObject, int paramInt1, int paramInt2)
  {
    if (paramObject == null) {
      while (paramInt1 < paramInt2)
      {
        if (paramArrayOfObject[paramInt1] == null) {
          return paramInt1;
        }
        paramInt1 += 1;
        continue;
        paramInt1 += 1;
      }
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        if (!paramObject.equals(paramArrayOfObject[paramInt1])) {
          break;
        }
        return paramInt1;
      }
      return -1;
    }
  }
  
  static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  static int b(Object[] paramArrayOfObject, Object paramObject, int paramInt1, int paramInt2)
  {
    int i;
    if (paramObject == null)
    {
      paramInt2 -= 1;
      while (paramInt2 >= paramInt1)
      {
        if (paramArrayOfObject[paramInt2] == null)
        {
          i = paramInt2;
          return i;
        }
        paramInt2 -= 1;
      }
    }
    paramInt2 -= 1;
    for (;;)
    {
      if (paramInt2 < paramInt1) {
        break label61;
      }
      i = paramInt2;
      if (paramObject.equals(paramArrayOfObject[paramInt2])) {
        break;
      }
      paramInt2 -= 1;
    }
    label61:
    return -1;
  }
  
  private final void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    int j = paramObjectInputStream.readInt();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = paramObjectInputStream.readObject();
      i += 1;
    }
    a = arrayOfObject;
  }
  
  private final void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    Object[] arrayOfObject = a;
    int j = arrayOfObject.length;
    paramObjectOutputStream.writeInt(j);
    int i = 0;
    while (i < j)
    {
      paramObjectOutputStream.writeObject(arrayOfObject[i]);
      i += 1;
    }
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    Object[] arrayOfObject1;
    int i;
    try
    {
      arrayOfObject1 = a;
      i = arrayOfObject1.length;
      if ((paramInt < 0) || (paramInt > i)) {
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + i);
      }
    }
    finally {}
    Object[] arrayOfObject2 = new Object[i + 1];
    i -= paramInt;
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, paramInt);
    arrayOfObject2[paramInt] = paramObject;
    if (i > 0) {
      System.arraycopy(arrayOfObject1, paramInt, arrayOfObject2, paramInt + 1, i);
    }
    a = arrayOfObject2;
  }
  
  public final boolean add(Object paramObject)
  {
    try
    {
      Object[] arrayOfObject1 = a;
      int i = arrayOfObject1.length;
      Object[] arrayOfObject2 = new Object[i + 1];
      System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      arrayOfObject2[i] = paramObject;
      a = arrayOfObject2;
      return true;
    }
    finally {}
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    paramCollection = paramCollection.toArray();
    Object[] arrayOfObject1;
    int i;
    try
    {
      arrayOfObject1 = a;
      i = arrayOfObject1.length;
      if ((paramInt < 0) || (paramInt > i)) {
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + i);
      }
    }
    finally {}
    if (paramCollection.length == 0) {
      return false;
    }
    Object[] arrayOfObject2 = new Object[paramCollection.length + i];
    i -= paramInt;
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, paramInt);
    System.arraycopy(paramCollection, 0, arrayOfObject2, paramInt, paramCollection.length);
    if (i > 0) {
      System.arraycopy(arrayOfObject1, paramInt, arrayOfObject2, paramCollection.length + paramInt, i);
    }
    a = arrayOfObject2;
    return true;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    paramCollection = paramCollection.toArray();
    if (paramCollection.length == 0) {
      return false;
    }
    try
    {
      Object[] arrayOfObject1 = a;
      int i = arrayOfObject1.length;
      Object[] arrayOfObject2 = new Object[paramCollection.length + i];
      System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      System.arraycopy(paramCollection, 0, arrayOfObject2, i, paramCollection.length);
      a = arrayOfObject2;
      return true;
    }
    finally {}
  }
  
  public final void clear()
  {
    a = new Object[0];
  }
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError();
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    boolean bool = false;
    Object[] arrayOfObject = a;
    if (a(arrayOfObject, paramObject, 0, arrayOfObject.length) >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean containsAll(Collection paramCollection)
  {
    Object[] arrayOfObject = a;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (a(arrayOfObject, paramCollection.next(), 0, arrayOfObject.length) < 0) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    int j;
    int i;
    do
    {
      return true;
      if (!(paramObject instanceof List)) {
        return false;
      }
      paramObject = ((List)paramObject).listIterator();
      Object[] arrayOfObject = a;
      j = arrayOfObject.length;
      i = 0;
      while ((i < j) && (((ListIterator)paramObject).hasNext()))
      {
        if (!a(arrayOfObject[i], ((ListIterator)paramObject).next())) {
          return false;
        }
        i += 1;
      }
    } while ((i == j) && (!((ListIterator)paramObject).hasNext()));
    return false;
  }
  
  public final Object get(int paramInt)
  {
    return a[paramInt];
  }
  
  public final int hashCode()
  {
    int i = 1;
    Object[] arrayOfObject = a;
    int m = arrayOfObject.length;
    int j = 0;
    if (j < m)
    {
      Object localObject = arrayOfObject[j];
      if (localObject == null) {}
      for (int k = 0;; k = localObject.hashCode())
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
    Object[] arrayOfObject = a;
    return a(arrayOfObject, paramObject, 0, arrayOfObject.length);
  }
  
  public final boolean isEmpty()
  {
    return a.length == 0;
  }
  
  public final Iterator iterator()
  {
    return new hpx(a, 0);
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    Object[] arrayOfObject = a;
    return b(arrayOfObject, paramObject, 0, arrayOfObject.length);
  }
  
  public final ListIterator listIterator()
  {
    return new hpx(a, 0);
  }
  
  public final ListIterator listIterator(int paramInt)
  {
    Object[] arrayOfObject = a;
    if ((paramInt < 0) || (paramInt > arrayOfObject.length)) {
      throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + arrayOfObject.length);
    }
    return new hpx(arrayOfObject, paramInt);
  }
  
  public final Object remove(int paramInt)
  {
    try
    {
      Object[] arrayOfObject1 = a;
      i = arrayOfObject1.length;
      if ((paramInt < 0) || (paramInt >= i)) {
        throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + i);
      }
    }
    finally {}
    Object localObject2 = localObject1[paramInt];
    Object[] arrayOfObject2 = new Object[i - 1];
    int i = i - paramInt - 1;
    if (paramInt > 0) {
      System.arraycopy(localObject1, 0, arrayOfObject2, 0, paramInt);
    }
    if (i > 0) {
      System.arraycopy(localObject1, paramInt + 1, arrayOfObject2, paramInt, i);
    }
    a = arrayOfObject2;
    return localObject2;
  }
  
  public final boolean remove(Object paramObject)
  {
    try
    {
      Object[] arrayOfObject = a;
      int j = arrayOfObject.length;
      int i = a(arrayOfObject, paramObject, 0, j);
      if (i < 0) {
        return false;
      }
      paramObject = new Object[j - 1];
      j = j - i - 1;
      if (i > 0) {
        System.arraycopy(arrayOfObject, 0, paramObject, 0, i);
      }
      if (j > 0) {
        System.arraycopy(arrayOfObject, i + 1, paramObject, i, j);
      }
      a = ((Object[])paramObject);
      return true;
    }
    finally {}
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return false;
    }
    for (;;)
    {
      int j;
      try
      {
        Object[] arrayOfObject2 = a;
        int m = arrayOfObject2.length;
        Object[] arrayOfObject1 = new Object[m];
        j = 0;
        int i = 0;
        if (j < m)
        {
          Object localObject = arrayOfObject2[j];
          if (!paramCollection.contains(localObject))
          {
            int k = i + 1;
            arrayOfObject1[i] = localObject;
            i = k;
          }
        }
        else
        {
          if (i == m) {
            return false;
          }
          paramCollection = new Object[i];
          System.arraycopy(arrayOfObject1, 0, paramCollection, 0, i);
          a = paramCollection;
          return true;
        }
      }
      finally {}
      j += 1;
    }
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    for (;;)
    {
      int j;
      try
      {
        Object[] arrayOfObject2 = a;
        int m = arrayOfObject2.length;
        Object[] arrayOfObject1 = new Object[m];
        j = 0;
        int i = 0;
        if (j < m)
        {
          Object localObject = arrayOfObject2[j];
          if (paramCollection.contains(localObject))
          {
            int k = i + 1;
            arrayOfObject1[i] = localObject;
            i = k;
          }
        }
        else
        {
          if (i == m) {
            return false;
          }
          paramCollection = new Object[i];
          System.arraycopy(arrayOfObject1, 0, paramCollection, 0, i);
          a = paramCollection;
          return true;
        }
      }
      finally {}
      j += 1;
    }
  }
  
  /* Error */
  public final Object set(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	hpw:a	[Ljava/lang/Object;
    //   6: astore 4
    //   8: aload 4
    //   10: arraylength
    //   11: istore_3
    //   12: aload 4
    //   14: iload_1
    //   15: aaload
    //   16: astore 5
    //   18: aload 5
    //   20: aload_2
    //   21: if_acmpne +14 -> 35
    //   24: aload_0
    //   25: aload 4
    //   27: putfield 27	hpw:a	[Ljava/lang/Object;
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 5
    //   34: areturn
    //   35: iload_3
    //   36: anewarray 4	java/lang/Object
    //   39: astore 6
    //   41: aload 4
    //   43: iconst_0
    //   44: aload 6
    //   46: iconst_0
    //   47: iload_3
    //   48: invokestatic 108	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   51: aload 6
    //   53: iload_1
    //   54: aload_2
    //   55: aastore
    //   56: aload_0
    //   57: aload 6
    //   59: putfield 27	hpw:a	[Ljava/lang/Object;
    //   62: goto -32 -> 30
    //   65: astore_2
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	hpw
    //   0	70	1	paramInt	int
    //   0	70	2	paramObject	Object
    //   11	37	3	i	int
    //   6	36	4	arrayOfObject1	Object[]
    //   16	17	5	localObject	Object
    //   39	19	6	arrayOfObject2	Object[]
    // Exception table:
    //   from	to	target	type
    //   2	12	65	finally
    //   24	30	65	finally
    //   30	32	65	finally
    //   35	51	65	finally
    //   56	62	65	finally
    //   66	68	65	finally
  }
  
  public final int size()
  {
    return a.length;
  }
  
  public final List subList(int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject = a;
    if ((paramInt1 < 0) || (paramInt2 > arrayOfObject.length) || (paramInt1 > paramInt2)) {
      throw new IndexOutOfBoundsException();
    }
    return new hpz(this, paramInt1, paramInt2 - paramInt1);
  }
  
  public final Object[] toArray()
  {
    Object[] arrayOfObject = a;
    int i = arrayOfObject.length;
    Class localClass;
    if (b == null)
    {
      localClass = a("[Ljava.lang.Object;");
      b = localClass;
    }
    for (;;)
    {
      return hpk.a(arrayOfObject, i, localClass);
      localClass = b;
    }
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = a;
    int i = arrayOfObject.length;
    if (paramArrayOfObject.length < i) {
      arrayOfObject = hpk.a(arrayOfObject, i, paramArrayOfObject.getClass());
    }
    do
    {
      return arrayOfObject;
      System.arraycopy(arrayOfObject, 0, paramArrayOfObject, 0, i);
      arrayOfObject = paramArrayOfObject;
    } while (paramArrayOfObject.length <= i);
    paramArrayOfObject[i] = null;
    return paramArrayOfObject;
  }
  
  public final String toString()
  {
    Object[] arrayOfObject = a;
    int j = arrayOfObject.length;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('[');
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(arrayOfObject[i]);
      i += 1;
    }
    localStringBuffer.append(']');
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hpw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */