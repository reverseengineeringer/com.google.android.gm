import java.lang.reflect.Array;

public final class hpk
{
  public static Object[] a(Object[] paramArrayOfObject, int paramInt, Class paramClass)
  {
    Class localClass;
    if (a == null)
    {
      localClass = a("[Ljava.lang.Object;");
      a = localClass;
      if (paramClass != localClass) {
        break label58;
      }
    }
    label58:
    for (paramClass = new Object[paramInt];; paramClass = (Object[])Array.newInstance(paramClass.getComponentType(), paramInt))
    {
      int i = paramInt;
      if (paramArrayOfObject.length < paramInt) {
        i = paramArrayOfObject.length;
      }
      System.arraycopy(paramArrayOfObject, 0, paramClass, 0, i);
      return paramClass;
      localClass = a;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     hpk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */