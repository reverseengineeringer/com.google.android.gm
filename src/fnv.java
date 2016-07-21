import java.util.Map;

public class fnv<K, V>
{
  static Object[] b;
  static int c;
  static Object[] d;
  static int e;
  int[] f = fnn.a;
  Object[] g = fnn.c;
  int h = 0;
  
  static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (e < 10)
        {
          paramArrayOfObject[0] = d;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label117;
          d = paramArrayOfObject;
          e += 1;
        }
        return;
      }
      finally {}
    }
    if (paramArrayOfInt.length == 4) {}
    for (;;)
    {
      try
      {
        if (c < 10)
        {
          paramArrayOfObject[0] = b;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          b = paramArrayOfObject;
          c += 1;
        }
        return;
      }
      finally {}
      label117:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      return;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private final K c(int paramInt)
  {
    return (K)g[(paramInt << 1)];
  }
  
  private final V d(int paramInt)
  {
    return (V)g[((paramInt << 1) + 1)];
  }
  
  final int a()
  {
    int m = h;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = fnn.a(f, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (g[(j << 1)] == null);
    int k = j + 1;
    while ((k < m) && (f[k] == 0))
    {
      if (g[(k << 1)] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (f[j] != 0)) {
        break label121;
      }
      i = j;
      if (g[(j << 1)] == null) {
        break;
      }
      j -= 1;
    }
    label121:
    return k ^ 0xFFFFFFFF;
  }
  
  final int a(Object paramObject)
  {
    int i = 1;
    int j = 1;
    int k = h * 2;
    Object[] arrayOfObject = g;
    if (paramObject == null)
    {
      i = j;
      while (i < k)
      {
        if (arrayOfObject[i] == null) {
          return i >> 1;
        }
        i += 2;
      }
    }
    do
    {
      i += 2;
      if (i >= k) {
        break;
      }
    } while (!paramObject.equals(arrayOfObject[i]));
    return i >> 1;
    return -1;
  }
  
  final int a(Object paramObject, int paramInt)
  {
    int m = h;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = fnn.a(f, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(g[(j << 1)]));
    int k = j + 1;
    while ((k < m) && (f[k] == paramInt))
    {
      if (paramObject.equals(g[(k << 1)])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (f[j] != paramInt)) {
        break label156;
      }
      i = j;
      if (paramObject.equals(g[(j << 1)])) {
        break;
      }
      j -= 1;
    }
    label156:
    return k ^ 0xFFFFFFFF;
  }
  
  final void a(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (d != null)
        {
          Object[] arrayOfObject1 = d;
          g = arrayOfObject1;
          d = (Object[])arrayOfObject1[0];
          f = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          e -= 1;
          return;
        }
        f = new int[paramInt];
        g = new Object[paramInt << 1];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (b != null)
          {
            Object[] arrayOfObject2 = b;
            g = arrayOfObject2;
            b = (Object[])arrayOfObject2[0];
            f = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            c -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  public final V b(int paramInt)
  {
    int i = 8;
    Object localObject = g[((paramInt << 1) + 1)];
    if (h <= 1)
    {
      a(f, g, h);
      f = fnn.a;
      g = fnn.c;
      h = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return (V)localObject;
      if ((f.length <= 8) || (h >= f.length / 3)) {
        break;
      }
      if (h > 8) {
        i = h + (h >> 1);
      }
      arrayOfInt = f;
      arrayOfObject = g;
      a(i);
      h -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, f, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, g, 0, paramInt << 1);
      }
    } while (paramInt >= h);
    System.arraycopy(arrayOfInt, paramInt + 1, f, paramInt, h - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1 << 1, g, paramInt << 1, h - paramInt << 1);
    return (V)localObject;
    h -= 1;
    if (paramInt < h)
    {
      System.arraycopy(f, paramInt + 1, f, paramInt, h - paramInt);
      System.arraycopy(g, paramInt + 1 << 1, g, paramInt << 1, h - paramInt << 1);
    }
    g[(h << 1)] = null;
    g[((h << 1) + 1)] = null;
    return (V)localObject;
  }
  
  public void clear()
  {
    if (h != 0)
    {
      a(f, g, h);
      f = fnn.a;
      g = fnn.c;
      h = 0;
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    if (paramObject == null) {
      if (a() < 0) {}
    }
    while (a(paramObject, paramObject.hashCode()) >= 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return a(paramObject) >= 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Map))
      {
        paramObject = (Map)paramObject;
        if (size() != ((Map)paramObject).size()) {
          return false;
        }
        int i = 0;
        try
        {
          while (i < h)
          {
            Object localObject1 = c(i);
            Object localObject2 = d(i);
            Object localObject3 = ((Map)paramObject).get(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null) {
                break label121;
              }
              if (!((Map)paramObject).containsKey(localObject1)) {
                break label121;
              }
            }
            else
            {
              boolean bool = localObject2.equals(localObject3);
              if (!bool) {
                return false;
              }
            }
            i += 1;
          }
          return false;
        }
        catch (NullPointerException paramObject)
        {
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
      }
    }
    label121:
    return false;
  }
  
  public V get(Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = a(); i >= 0; i = a(paramObject, paramObject.hashCode())) {
      return (V)g[((i << 1) + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = f;
    Object[] arrayOfObject = g;
    int n = h;
    int i = 1;
    int j = 0;
    int k = 0;
    if (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      if (localObject == null) {}
      for (int m = 0;; m = localObject.hashCode())
      {
        k += (m ^ i1);
        j += 1;
        i += 2;
        break;
      }
    }
    return k;
  }
  
  public boolean isEmpty()
  {
    return h <= 0;
  }
  
  public V put(K paramK, V paramV)
  {
    int k = 8;
    int i;
    int j;
    if (paramK == null)
    {
      i = a();
      j = 0;
    }
    while (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = g[i];
      g[i] = paramV;
      return paramK;
      j = paramK.hashCode();
      i = a(paramK, j);
    }
    int m = i ^ 0xFFFFFFFF;
    if (h >= f.length)
    {
      if (h < 8) {
        break label267;
      }
      i = h + (h >> 1);
    }
    for (;;)
    {
      int[] arrayOfInt = f;
      Object[] arrayOfObject = g;
      a(i);
      if (f.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, f, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, g, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, h);
      if (m < h)
      {
        System.arraycopy(f, m, f, m + 1, h - m);
        System.arraycopy(g, m << 1, g, m + 1 << 1, h - m << 1);
      }
      f[m] = j;
      g[(m << 1)] = paramK;
      g[((m << 1) + 1)] = paramV;
      h += 1;
      return null;
      label267:
      i = k;
      if (h < 4) {
        i = 4;
      }
    }
  }
  
  public V remove(Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = a(); i >= 0; i = a(paramObject, paramObject.hashCode())) {
      return (V)b(i);
    }
    return null;
  }
  
  public int size()
  {
    return h;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(h * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < h)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = c(i);
      if (localObject != this)
      {
        localStringBuilder.append(localObject);
        label70:
        localStringBuilder.append('=');
        localObject = d(i);
        if (localObject == this) {
          break label111;
        }
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
        break label70;
        label111:
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     fnv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */