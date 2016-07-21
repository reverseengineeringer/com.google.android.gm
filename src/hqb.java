import java.io.PrintStream;
import java.lang.reflect.Array;
import java.security.AccessController;
import java.util.Collection;
import java.util.Iterator;

public final class hqb
{
  @Deprecated
  private static final hqa b;
  
  static
  {
    localObject1 = null;
    try
    {
      localObject2 = (String)AccessController.doPrivileged(new hqc());
      if (localObject2 == null) {
        break label86;
      }
      localObject2 = (hqa)Class.forName((String)localObject2).newInstance();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = new hqf();
          localObject1 = localObject2;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new hqe();
          }
          b = (hqa)localObject2;
          return;
        }
        catch (Throwable localThrowable) {}
        localException = localException;
        System.err.println("WARNING: unable to load the system-property-defined nanotime provider; switching to the default");
        localException.printStackTrace();
        continue;
        continue;
        localObject1 = null;
      }
    }
    if (localObject1 != null) {}
  }
  
  static long a(long paramLong1, long paramLong2)
  {
    long l;
    for (;;)
    {
      l = paramLong1;
      if (paramLong2 <= 0L) {
        break;
      }
      paramLong1 = paramLong2;
      paramLong2 = l % paramLong2;
    }
    return l;
  }
  
  public static Object[] a(Collection paramCollection)
  {
    int i = paramCollection.size();
    Object localObject = new Object[i];
    Iterator localIterator = paramCollection.iterator();
    int j = 0;
    paramCollection = (Collection)localObject;
    while ((j < i) && (localIterator.hasNext()))
    {
      paramCollection[j] = localIterator.next();
      j += 1;
    }
    if (!localIterator.hasNext())
    {
      if (j == i) {
        return paramCollection;
      }
      if (a == null)
      {
        localObject = a("[Ljava.lang.Object;");
        a = (Class)localObject;
      }
      for (;;)
      {
        return hpk.a(paramCollection, j, (Class)localObject);
        localObject = a;
      }
    }
    int k = (paramCollection.length / 2 + 1) * 3;
    i = k;
    if (k < paramCollection.length)
    {
      if (paramCollection.length < Integer.MAX_VALUE) {
        i = Integer.MAX_VALUE;
      }
    }
    else
    {
      if (a != null) {
        break label175;
      }
      localObject = a("[Ljava.lang.Object;");
      a = (Class)localObject;
    }
    for (;;)
    {
      paramCollection = hpk.a(paramCollection, i, (Class)localObject);
      break;
      throw new OutOfMemoryError("required array size too large");
      label175:
      localObject = a;
    }
  }
  
  public static Object[] a(Collection paramCollection, Object[] paramArrayOfObject)
  {
    Class localClass = paramArrayOfObject.getClass();
    int i = paramCollection.size();
    Object[] arrayOfObject;
    int j;
    if (paramArrayOfObject.length >= i)
    {
      arrayOfObject = paramArrayOfObject;
      paramCollection = paramCollection.iterator();
      j = 0;
    }
    for (;;)
    {
      if ((j < i) && (paramCollection.hasNext()))
      {
        arrayOfObject[j] = paramCollection.next();
        j += 1;
        continue;
        arrayOfObject = (Object[])Array.newInstance(localClass.getComponentType(), i);
        break;
      }
      if (!paramCollection.hasNext())
      {
        if (j == i) {
          return arrayOfObject;
        }
        if (arrayOfObject == paramArrayOfObject)
        {
          paramArrayOfObject[j] = null;
          return paramArrayOfObject;
        }
        return hpk.a(arrayOfObject, j, localClass);
      }
      int k = (arrayOfObject.length / 2 + 1) * 3;
      i = k;
      if (k < arrayOfObject.length)
      {
        if (arrayOfObject.length >= Integer.MAX_VALUE) {
          break label163;
        }
        i = Integer.MAX_VALUE;
      }
      arrayOfObject = hpk.a(arrayOfObject, i, localClass);
    }
    label163:
    throw new OutOfMemoryError("required array size too large");
  }
}

/* Location:
 * Qualified Name:     hqb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */