import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class fmo
  implements Cloneable
{
  private fmm<?, ?> a;
  private Object b;
  private List<fms> c = new ArrayList();
  
  private final byte[] c()
  {
    byte[] arrayOfByte = new byte[a()];
    a(fmj.a(arrayOfByte, 0, arrayOfByte.length));
    return arrayOfByte;
  }
  
  final int a()
  {
    int i = 0;
    Object localObject2;
    int j;
    if (b != null)
    {
      localObject1 = a;
      localObject2 = b;
      if (d)
      {
        int m = Array.getLength(localObject2);
        j = 0;
        for (;;)
        {
          k = i;
          if (j >= m) {
            break;
          }
          k = i;
          if (Array.get(localObject2, j) != null) {
            k = i + ((fmm)localObject1).a(Array.get(localObject2, j));
          }
          j += 1;
          i = k;
        }
      }
      int k = ((fmm)localObject1).a(localObject2);
      return k;
    }
    Object localObject1 = c.iterator();
    for (i = 0; ((Iterator)localObject1).hasNext(); i = b.length + (j + 0) + i)
    {
      localObject2 = (fms)((Iterator)localObject1).next();
      j = fmj.d(a);
    }
    return i;
  }
  
  final void a(fmj paramfmj)
  {
    Object localObject1;
    Object localObject2;
    if (b != null)
    {
      localObject1 = a;
      localObject2 = b;
      if (d)
      {
        int j = Array.getLength(localObject2);
        int i = 0;
        while (i < j)
        {
          Object localObject3 = Array.get(localObject2, i);
          if (localObject3 != null) {
            ((fmm)localObject1).a(localObject3, paramfmj);
          }
          i += 1;
        }
      }
      ((fmm)localObject1).a(localObject2, paramfmj);
    }
    for (;;)
    {
      return;
      localObject1 = c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (fms)((Iterator)localObject1).next();
        paramfmj.c(a);
        paramfmj.b(b);
      }
    }
  }
  
  public final fmo b()
  {
    int i = 0;
    fmo localfmo = new fmo();
    try
    {
      a = a;
      if (c == null) {
        c = null;
      }
      for (;;)
      {
        if (b == null) {
          return localfmo;
        }
        if (!(b instanceof fmq)) {
          break;
        }
        b = ((fmq)b).c();
        return localfmo;
        c.addAll(c);
      }
      if (!(b instanceof byte[])) {
        break label116;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    b = ((byte[])b).clone();
    return localCloneNotSupportedException;
    label116:
    Object localObject1;
    Object localObject2;
    if ((b instanceof byte[][]))
    {
      localObject1 = (byte[][])b;
      localObject2 = new byte[localObject1.length][];
      b = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((b instanceof boolean[]))
    {
      b = ((boolean[])b).clone();
      return localCloneNotSupportedException;
    }
    if ((b instanceof int[]))
    {
      b = ((int[])b).clone();
      return localCloneNotSupportedException;
    }
    if ((b instanceof long[]))
    {
      b = ((long[])b).clone();
      return localCloneNotSupportedException;
    }
    if ((b instanceof float[]))
    {
      b = ((float[])b).clone();
      return localCloneNotSupportedException;
    }
    if ((b instanceof double[]))
    {
      b = ((double[])b).clone();
      return localCloneNotSupportedException;
    }
    if ((b instanceof fmq[]))
    {
      localObject1 = (fmq[])b;
      localObject2 = new fmq[localObject1.length];
      b = localObject2;
      while (i < localObject1.length)
      {
        localObject2[i] = localObject1[i].c();
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof fmo));
      paramObject = (fmo)paramObject;
      if ((b == null) || (b == null)) {
        break;
      }
      bool1 = bool2;
    } while (a != a);
    if (!a.b.isArray()) {
      return b.equals(b);
    }
    if ((b instanceof byte[])) {
      return Arrays.equals((byte[])b, (byte[])b);
    }
    if ((b instanceof int[])) {
      return Arrays.equals((int[])b, (int[])b);
    }
    if ((b instanceof long[])) {
      return Arrays.equals((long[])b, (long[])b);
    }
    if ((b instanceof float[])) {
      return Arrays.equals((float[])b, (float[])b);
    }
    if ((b instanceof double[])) {
      return Arrays.equals((double[])b, (double[])b);
    }
    if ((b instanceof boolean[])) {
      return Arrays.equals((boolean[])b, (boolean[])b);
    }
    return Arrays.deepEquals((Object[])b, (Object[])b);
    if ((c != null) && (c != null)) {
      return c.equals(c);
    }
    try
    {
      bool1 = Arrays.equals(c(), ((fmo)paramObject).c());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public final int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(c());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
}

/* Location:
 * Qualified Name:     fmo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */