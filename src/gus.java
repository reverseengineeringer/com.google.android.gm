import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.TypeVariable<*>;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class gus
{
  public static Class<?> a(ParameterizedType paramParameterizedType)
  {
    return (Class)paramParameterizedType.getRawType();
  }
  
  public static Class<?> a(List<Type> paramList, Type paramType)
  {
    if ((paramType instanceof TypeVariable)) {
      paramType = a(paramList, (TypeVariable)paramType);
    }
    for (;;)
    {
      if ((paramType instanceof GenericArrayType)) {
        return Array.newInstance(a(paramList, b(paramType)), 0).getClass();
      }
      if ((paramType instanceof Class)) {
        return (Class)paramType;
      }
      if ((paramType instanceof ParameterizedType)) {
        return a((ParameterizedType)paramType);
      }
      if (paramType == null) {}
      for (boolean bool = true;; bool = false)
      {
        gun.a(bool, "wildcard type is not supported: %s", new Object[] { paramType });
        return Object.class;
      }
    }
  }
  
  private static IllegalArgumentException a(Exception paramException, Class<?> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder("unable to create new instance of class ").append(paramClass.getName());
    Object localObject = new ArrayList();
    int i;
    if (paramClass.isArray())
    {
      ((ArrayList)localObject).add("because it is an array");
      paramClass = ((ArrayList)localObject).iterator();
      i = 0;
      label49:
      if (!paramClass.hasNext()) {
        break label244;
      }
      localObject = (String)paramClass.next();
      if (i == 0) {
        break label239;
      }
      localStringBuilder.append(" and");
    }
    for (;;)
    {
      localStringBuilder.append(" ").append((String)localObject);
      break label49;
      if (paramClass.isPrimitive())
      {
        ((ArrayList)localObject).add("because it is primitive");
        break;
      }
      if (paramClass == Void.class)
      {
        ((ArrayList)localObject).add("because it is void");
        break;
      }
      if (Modifier.isInterface(paramClass.getModifiers())) {
        ((ArrayList)localObject).add("because it is an interface");
      }
      for (;;)
      {
        if ((paramClass.getEnclosingClass() != null) && (!Modifier.isStatic(paramClass.getModifiers()))) {
          ((ArrayList)localObject).add("because it is not static");
        }
        if (Modifier.isPublic(paramClass.getModifiers())) {
          break label215;
        }
        ((ArrayList)localObject).add("possibly because it is not public");
        break;
        if (Modifier.isAbstract(paramClass.getModifiers())) {
          ((ArrayList)localObject).add("because it is abstract");
        }
      }
      try
      {
        label215:
        paramClass.getConstructor(new Class[0]);
      }
      catch (NoSuchMethodException paramClass)
      {
        ((ArrayList)localObject).add("because it has no accessible default constructor");
      }
      break;
      label239:
      i = 1;
    }
    label244:
    return new IllegalArgumentException(localStringBuilder.toString(), paramException);
  }
  
  public static <T> Iterable<T> a(Object paramObject)
  {
    if ((paramObject instanceof Iterable)) {
      return (Iterable)paramObject;
    }
    Class localClass = paramObject.getClass();
    gun.a(localClass.isArray(), "not an array or Iterable: %s", new Object[] { localClass });
    if (!localClass.getComponentType().isPrimitive()) {
      return Arrays.asList((Object[])paramObject);
    }
    return new gut(paramObject);
  }
  
  public static <T> T a(Class<T> paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return (T)localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw a(localIllegalAccessException, paramClass);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw a(localInstantiationException, paramClass);
    }
  }
  
  public static Object a(Collection<?> paramCollection, Class<?> paramClass)
  {
    if (paramClass.isPrimitive())
    {
      paramClass = Array.newInstance(paramClass, paramCollection.size());
      int i = 0;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Array.set(paramClass, i, paramCollection.next());
        i += 1;
      }
      return paramClass;
    }
    return paramCollection.toArray((Object[])Array.newInstance(paramClass, paramCollection.size()));
  }
  
  private static ParameterizedType a(Type paramType, Class<?> paramClass)
  {
    if (((paramType instanceof Class)) || ((paramType instanceof ParameterizedType))) {
      if ((paramType != null) && (paramType != Object.class)) {
        if (!(paramType instanceof Class)) {}
      }
    }
    Class localClass;
    for (paramType = (Class)paramType;; paramType = localClass)
    {
      paramType = paramType.getGenericSuperclass();
      break;
      paramType = (ParameterizedType)paramType;
      localClass = a(paramType);
      if (localClass == paramClass) {
        return paramType;
      }
      if (paramClass.isInterface())
      {
        Type[] arrayOfType = localClass.getGenericInterfaces();
        int j = arrayOfType.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            Type localType = arrayOfType[i];
            if ((localType instanceof Class)) {}
            for (paramType = (Class)localType;; paramType = a((ParameterizedType)localType))
            {
              if (!paramClass.isAssignableFrom(paramType)) {
                break label134;
              }
              paramType = localType;
              break;
            }
            label134:
            i += 1;
            continue;
            return null;
          }
        }
      }
    }
  }
  
  public static Type a(Type paramType, Class<?> paramClass, int paramInt)
  {
    paramClass = a(paramType, paramClass);
    if (paramClass == null) {
      paramClass = null;
    }
    do
    {
      Type localType;
      do
      {
        return paramClass;
        localType = paramClass.getActualTypeArguments()[paramInt];
        paramClass = localType;
      } while (!(localType instanceof TypeVariable));
      paramType = a(Arrays.asList(new Type[] { paramType }), (TypeVariable)localType);
      paramClass = localType;
    } while (paramType == null);
    return paramType;
  }
  
  public static Type a(WildcardType paramWildcardType)
  {
    Type[] arrayOfType = paramWildcardType.getLowerBounds();
    if (arrayOfType.length != 0) {
      return arrayOfType[0];
    }
    return paramWildcardType.getUpperBounds()[0];
  }
  
  public static Type a(List<Type> paramList, TypeVariable<?> paramTypeVariable)
  {
    Object localObject2 = paramTypeVariable.getGenericDeclaration();
    if ((localObject2 instanceof Class))
    {
      Class localClass = (Class)localObject2;
      int i = paramList.size();
      for (Object localObject1 = null; localObject1 == null; localObject1 = a((Type)paramList.get(i), localClass))
      {
        i -= 1;
        if (i < 0) {
          break;
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((GenericDeclaration)localObject2).getTypeParameters();
        i = 0;
        while ((i < localObject2.length) && (!localObject2[i].equals(paramTypeVariable))) {
          i += 1;
        }
        localObject1 = localObject1.getActualTypeArguments()[i];
        paramTypeVariable = (TypeVariable<?>)localObject1;
        if ((localObject1 instanceof TypeVariable))
        {
          paramList = a(paramList, (TypeVariable)localObject1);
          paramTypeVariable = (TypeVariable<?>)localObject1;
          if (paramList != null) {
            paramTypeVariable = paramList;
          }
        }
        return paramTypeVariable;
      }
    }
    return null;
  }
  
  public static boolean a(Class<?> paramClass1, Class<?> paramClass2)
  {
    return (paramClass1.isAssignableFrom(paramClass2)) || (paramClass2.isAssignableFrom(paramClass1));
  }
  
  public static boolean a(Type paramType)
  {
    return ((paramType instanceof GenericArrayType)) || (((paramType instanceof Class)) && (((Class)paramType).isArray()));
  }
  
  public static Type b(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {
      return ((GenericArrayType)paramType).getGenericComponentType();
    }
    return ((Class)paramType).getComponentType();
  }
}

/* Location:
 * Qualified Name:     gus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */