import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class hlq
  implements Cloneable
{
  List<hlv> a = new ArrayList();
  private hlo<?, ?> b;
  private Object c;
  
  private final byte[] c()
  {
    byte[] arrayOfByte = new byte[a()];
    a(hll.a(arrayOfByte, 0, arrayOfByte.length));
    return arrayOfByte;
  }
  
  final int a()
  {
    int i = 0;
    Object localObject2;
    int j;
    if (c != null)
    {
      localObject1 = b;
      localObject2 = c;
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
            k = i + ((hlo)localObject1).a(Array.get(localObject2, j));
          }
          j += 1;
          i = k;
        }
      }
      int k = ((hlo)localObject1).a(localObject2);
      return k;
    }
    Object localObject1 = a.iterator();
    for (i = 0; ((Iterator)localObject1).hasNext(); i = b.length + (j + 0) + i)
    {
      localObject2 = (hlv)((Iterator)localObject1).next();
      j = hll.d(a);
    }
    return i;
  }
  
  final void a(hll paramhll)
  {
    Object localObject1;
    Object localObject2;
    if (c != null)
    {
      localObject1 = b;
      localObject2 = c;
      if (d)
      {
        int j = Array.getLength(localObject2);
        int i = 0;
        while (i < j)
        {
          Object localObject3 = Array.get(localObject2, i);
          if (localObject3 != null) {
            ((hlo)localObject1).a(localObject3, paramhll);
          }
          i += 1;
        }
      }
      ((hlo)localObject1).a(localObject2, paramhll);
    }
    for (;;)
    {
      return;
      localObject1 = a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (hlv)((Iterator)localObject1).next();
        paramhll.c(a);
        paramhll.b(b);
      }
    }
  }
  
  public final hlq b()
  {
    int i = 0;
    hlq localhlq = new hlq();
    try
    {
      b = b;
      if (a == null) {
        a = null;
      }
      for (;;)
      {
        if (c == null) {
          return localhlq;
        }
        if (!(c instanceof hlt)) {
          break;
        }
        c = ((hlt)c).c();
        return localhlq;
        a.addAll(a);
      }
      if (!(c instanceof byte[])) {
        break label116;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    c = ((byte[])c).clone();
    return localCloneNotSupportedException;
    label116:
    Object localObject1;
    Object localObject2;
    if ((c instanceof byte[][]))
    {
      localObject1 = (byte[][])c;
      localObject2 = new byte[localObject1.length][];
      c = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((c instanceof boolean[]))
    {
      c = ((boolean[])c).clone();
      return localCloneNotSupportedException;
    }
    if ((c instanceof int[]))
    {
      c = ((int[])c).clone();
      return localCloneNotSupportedException;
    }
    if ((c instanceof long[]))
    {
      c = ((long[])c).clone();
      return localCloneNotSupportedException;
    }
    if ((c instanceof float[]))
    {
      c = ((float[])c).clone();
      return localCloneNotSupportedException;
    }
    if ((c instanceof double[]))
    {
      c = ((double[])c).clone();
      return localCloneNotSupportedException;
    }
    if ((c instanceof hlt[]))
    {
      localObject1 = (hlt[])c;
      localObject2 = new hlt[localObject1.length];
      c = localObject2;
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
      } while (!(paramObject instanceof hlq));
      paramObject = (hlq)paramObject;
      if ((c == null) || (c == null)) {
        break;
      }
      bool1 = bool2;
    } while (b != b);
    if (!b.b.isArray()) {
      return c.equals(c);
    }
    if ((c instanceof byte[])) {
      return Arrays.equals((byte[])c, (byte[])c);
    }
    if ((c instanceof int[])) {
      return Arrays.equals((int[])c, (int[])c);
    }
    if ((c instanceof long[])) {
      return Arrays.equals((long[])c, (long[])c);
    }
    if ((c instanceof float[])) {
      return Arrays.equals((float[])c, (float[])c);
    }
    if ((c instanceof double[])) {
      return Arrays.equals((double[])c, (double[])c);
    }
    if ((c instanceof boolean[])) {
      return Arrays.equals((boolean[])c, (boolean[])c);
    }
    return Arrays.deepEquals((Object[])c, (Object[])c);
    if ((a != null) && (a != null)) {
      return a.equals(a);
    }
    try
    {
      bool1 = Arrays.equals(c(), ((hlq)paramObject).c());
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
 * Qualified Name:     hlq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */