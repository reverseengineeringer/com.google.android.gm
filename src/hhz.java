import java.lang.reflect.Array;

public final class hhz
{
  static final Object[] a = new Object[0];
  
  static Object a(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      throw new NullPointerException(20 + "at index " + paramInt);
    }
    return paramObject;
  }
  
  public static <T> T[] a(Class<T> paramClass, int paramInt)
  {
    return (Object[])Array.newInstance(paramClass, paramInt);
  }
  
  static <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt);
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, Math.min(paramArrayOfT.length, paramInt));
    return arrayOfObject;
  }
  
  public static Object[] b(Object[] paramArrayOfObject, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      a(paramArrayOfObject[i], i);
      i += 1;
    }
    return paramArrayOfObject;
  }
}

/* Location:
 * Qualified Name:     hhz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */