import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.WeakHashMap;

public final class gtz
{
  private static final Map<Field, gtz> d = new WeakHashMap();
  public final boolean a;
  public final Field b;
  public final String c;
  
  private gtz(Field paramField, String paramString)
  {
    b = paramField;
    if (paramString == null) {}
    for (paramField = null;; paramField = paramString.intern())
    {
      c = paramField;
      a = gtt.a(b.getType());
      return;
    }
  }
  
  public static gtz a(Enum<?> paramEnum)
  {
    gtz localgtz;
    for (int i = 1;; i = 0) {
      try
      {
        localgtz = a(paramEnum.getClass().getField(paramEnum.name()));
        if (localgtz != null)
        {
          if (i != 0) {
            break;
          }
          throw new IllegalArgumentException(hbe.a("enum constant missing @Value or @NullValue annotation: %s", new Object[] { paramEnum }));
        }
      }
      catch (NoSuchFieldException paramEnum)
      {
        throw new RuntimeException(paramEnum);
      }
    }
    return localgtz;
  }
  
  public static gtz a(Field paramField)
  {
    if (paramField == null) {
      return null;
    }
    label125:
    label147:
    label181:
    for (;;)
    {
      Object localObject;
      synchronized (d)
      {
        gtz localgtz = (gtz)d.get(paramField);
        boolean bool = paramField.isEnumConstant();
        localObject = localgtz;
        if (localgtz == null) {
          if (!bool)
          {
            localObject = localgtz;
            if (Modifier.isStatic(paramField.getModifiers())) {}
          }
          else
          {
            if (!bool) {
              break label147;
            }
            localObject = (guv)paramField.getAnnotation(guv.class);
            if (localObject == null) {
              break label125;
            }
            localObject = ((guv)localObject).a();
            if (!"##default".equals(localObject)) {
              break label181;
            }
            localObject = paramField.getName();
            localObject = new gtz(paramField, (String)localObject);
            d.put(paramField, localObject);
          }
        }
        return (gtz)localObject;
      }
      if ((gul)paramField.getAnnotation(gul.class) != null)
      {
        localObject = null;
      }
      else
      {
        return null;
        localObject = (gug)paramField.getAnnotation(gug.class);
        if (localObject == null) {
          return null;
        }
        localObject = ((gug)localObject).a();
        paramField.setAccessible(true);
      }
    }
  }
  
  private static Object a(Field paramField, Object paramObject)
  {
    try
    {
      paramField = paramField.get(paramObject);
      return paramField;
    }
    catch (IllegalAccessException paramField)
    {
      throw new IllegalArgumentException(paramField);
    }
  }
  
  public static void a(Field paramField, Object paramObject1, Object paramObject2)
  {
    if (Modifier.isFinal(paramField.getModifiers()))
    {
      Object localObject = a(paramField, paramObject1);
      if (paramObject2 == null)
      {
        if (localObject == null) {}
      }
      else {
        while (!paramObject2.equals(localObject))
        {
          localObject = String.valueOf(localObject);
          paramObject2 = String.valueOf(paramObject2);
          paramField = String.valueOf(paramField.getName());
          paramObject1 = String.valueOf(paramObject1.getClass().getName());
          throw new IllegalArgumentException(String.valueOf(localObject).length() + 48 + String.valueOf(paramObject2).length() + String.valueOf(paramField).length() + String.valueOf(paramObject1).length() + "expected final value <" + (String)localObject + "> but was <" + (String)paramObject2 + "> on " + paramField + " field in " + (String)paramObject1);
        }
      }
      return;
    }
    try
    {
      paramField.set(paramObject1, paramObject2);
      return;
    }
    catch (SecurityException paramField)
    {
      throw new IllegalArgumentException(paramField);
    }
    catch (IllegalAccessException paramField)
    {
      throw new IllegalArgumentException(paramField);
    }
  }
  
  public final Object a(Object paramObject)
  {
    return a(b, paramObject);
  }
  
  public final void a(Object paramObject1, Object paramObject2)
  {
    a(b, paramObject1, paramObject2);
  }
  
  public final boolean a()
  {
    return Modifier.isFinal(b.getModifiers());
  }
  
  public final <T extends Enum<T>> T b()
  {
    return Enum.valueOf(b.getDeclaringClass(), b.getName());
  }
}

/* Location:
 * Qualified Name:     gtz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */