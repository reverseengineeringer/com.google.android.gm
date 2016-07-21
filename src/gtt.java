import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gtt
{
  public static final Boolean a = new Boolean(true);
  public static final String b = new String();
  public static final Character c = new Character('\000');
  public static final Byte d = new Byte((byte)0);
  public static final Short e = new Short((short)0);
  public static final Integer f = new Integer(0);
  public static final Float g = new Float(0.0F);
  public static final Long h = new Long(0L);
  public static final Double i = new Double(0.0D);
  public static final BigInteger j = new BigInteger("0");
  public static final BigDecimal k = new BigDecimal("0");
  public static final gty l = new gty();
  private static final ConcurrentHashMap<Class<?>, Object> m;
  
  static
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    m = localConcurrentHashMap;
    localConcurrentHashMap.put(Boolean.class, a);
    m.put(String.class, b);
    m.put(Character.class, c);
    m.put(Byte.class, d);
    m.put(Short.class, e);
    m.put(Integer.class, f);
    m.put(Float.class, g);
    m.put(Long.class, h);
    m.put(Double.class, i);
    m.put(BigInteger.class, j);
    m.put(BigDecimal.class, k);
    m.put(gty.class, l);
  }
  
  public static <T> T a(Class<?> paramClass)
  {
    int n = 0;
    Object localObject1 = m.get(paramClass);
    if (localObject1 == null) {
      for (;;)
      {
        synchronized (m)
        {
          Object localObject2 = m.get(paramClass);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (paramClass.isArray())
            {
              localObject1 = paramClass;
              localObject2 = ((Class)localObject1).getComponentType();
              int i1 = n + 1;
              localObject1 = localObject2;
              n = i1;
              if (((Class)localObject2).isArray()) {
                continue;
              }
              localObject1 = Array.newInstance((Class)localObject2, new int[i1]);
              m.put(paramClass, localObject1);
            }
          }
          else {
            return (T)localObject1;
          }
          if (!paramClass.isEnum()) {
            break label149;
          }
          localObject1 = gtr.a(paramClass).a(null);
          if (localObject1 == null) {
            throw new NullPointerException(hbe.a("enum missing constant with @NullValue annotation: %s", new Object[] { paramClass }));
          }
        }
        localObject1 = ((gtz)localObject1).b();
        continue;
        label149:
        localObject1 = gus.a(paramClass);
      }
    }
    return (T)localObject1;
  }
  
  public static Object a(Type paramType, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if ((paramType instanceof Class))
    {
      localObject1 = (Class)paramType;
      if ((paramType != null) && (localObject1 == null)) {
        break label798;
      }
      if (localObject1 != Void.class) {
        break label41;
      }
      localObject2 = null;
    }
    label41:
    do
    {
      do
      {
        do
        {
          return localObject2;
          localObject1 = null;
          break;
          localObject2 = paramString;
        } while (paramString == null);
        localObject2 = paramString;
      } while (localObject1 == null);
      localObject2 = paramString;
    } while (((Class)localObject1).isAssignableFrom(String.class));
    if ((localObject1 == Character.class) || (localObject1 == Character.TYPE))
    {
      if (paramString.length() != 1)
      {
        paramType = String.valueOf(localObject1);
        throw new IllegalArgumentException(String.valueOf(paramType).length() + 37 + "expected type Character/char but got " + paramType);
      }
      return Character.valueOf(paramString.charAt(0));
    }
    if ((localObject1 == Boolean.class) || (localObject1 == Boolean.TYPE)) {
      return Boolean.valueOf(paramString);
    }
    if ((localObject1 == Byte.class) || (localObject1 == Byte.TYPE)) {
      return Byte.valueOf(paramString);
    }
    if ((localObject1 == Short.class) || (localObject1 == Short.TYPE)) {
      return Short.valueOf(paramString);
    }
    if ((localObject1 == Integer.class) || (localObject1 == Integer.TYPE)) {
      return Integer.valueOf(paramString);
    }
    if ((localObject1 == Long.class) || (localObject1 == Long.TYPE)) {
      return Long.valueOf(paramString);
    }
    if ((localObject1 == Float.class) || (localObject1 == Float.TYPE)) {
      return Float.valueOf(paramString);
    }
    if ((localObject1 == Double.class) || (localObject1 == Double.TYPE)) {
      return Double.valueOf(paramString);
    }
    int i9;
    int i10;
    int i11;
    int i3;
    int i4;
    label406:
    int n;
    int i1;
    int i2;
    label458:
    label464:
    label478:
    int i8;
    if (localObject1 == gty.class)
    {
      paramType = gty.b.matcher(paramString);
      if (!paramType.matches())
      {
        paramType = String.valueOf(paramString);
        if (paramType.length() != 0) {}
        for (paramType = "Invalid date/time format: ".concat(paramType);; paramType = new String("Invalid date/time format: ")) {
          throw new NumberFormatException(paramType);
        }
      }
      i9 = Integer.parseInt(paramType.group(1));
      i10 = Integer.parseInt(paramType.group(2));
      i11 = Integer.parseInt(paramType.group(3));
      if (paramType.group(4) != null)
      {
        i3 = 1;
        localObject1 = paramType.group(9);
        if (localObject1 == null) {
          break label458;
        }
        i4 = 1;
        n = 0;
        i1 = 0;
        i2 = 0;
        if ((i4 == 0) || (i3 != 0)) {
          break label478;
        }
        paramType = String.valueOf(paramString);
        if (paramType.length() == 0) {
          break label464;
        }
      }
      for (paramType = "Invalid date/time format, cannot specify time zone shift without specifying time: ".concat(paramType);; paramType = new String("Invalid date/time format, cannot specify time zone shift without specifying time: "))
      {
        throw new NumberFormatException(paramType);
        i3 = 0;
        break;
        i4 = 0;
        break label406;
      }
      if (i3 == 0) {
        break label846;
      }
      int i5 = Integer.parseInt(paramType.group(5));
      int i6 = Integer.parseInt(paramType.group(6));
      int i7 = Integer.parseInt(paramType.group(7));
      n = i5;
      i1 = i6;
      i2 = i7;
      if (paramType.group(8) == null) {
        break label846;
      }
      n = Integer.parseInt(paramType.group(8).substring(1));
      i1 = paramType.group(8).substring(1).length();
      i8 = (int)(n / Math.pow(10.0D, i1 - 3));
      i2 = i7;
      i1 = i6;
      n = i5;
    }
    for (;;)
    {
      paramString = new GregorianCalendar(gty.a);
      paramString.set(i9, i10 - 1, i11, n, i1, i2);
      paramString.set(14, i8);
      long l1 = paramString.getTimeInMillis();
      if ((i3 != 0) && (i4 != 0)) {
        if (Character.toUpperCase(((String)localObject1).charAt(0)) == 'Z') {
          n = 0;
        }
      }
      for (paramType = Integer.valueOf(n);; paramType = null)
      {
        if (i3 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          return new gty(bool, l1, paramType);
          i1 = Integer.parseInt(paramType.group(11)) * 60 + Integer.parseInt(paramType.group(12));
          n = i1;
          if (paramType.group(10).charAt(0) == '-') {
            n = -i1;
          }
          l1 -= n * 60000L;
          break;
        }
        if (localObject1 == BigInteger.class) {
          return new BigInteger(paramString);
        }
        if (localObject1 == BigDecimal.class) {
          return new BigDecimal(paramString);
        }
        if (((Class)localObject1).isEnum()) {
          return gtr.a((Class)localObject1).a(paramString).b();
        }
        label798:
        paramType = String.valueOf(paramType);
        throw new IllegalArgumentException(String.valueOf(paramType).length() + 35 + "expected primitive class, but got: " + paramType);
      }
      label846:
      i8 = 0;
    }
  }
  
  public static Type a(List<Type> paramList, Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramType = gus.a((WildcardType)paramType);
    }
    for (;;)
    {
      if ((paramType instanceof TypeVariable))
      {
        Type localType = gus.a(paramList, (TypeVariable)paramType);
        if (localType == null) {
          break label64;
        }
        paramType = localType;
      }
      label64:
      for (;;)
      {
        if ((paramType instanceof TypeVariable))
        {
          paramType = ((TypeVariable)paramType).getBounds()[0];
          break;
          return paramType;
        }
        break;
      }
    }
  }
  
  public static void a(Object paramObject1, Object paramObject2)
  {
    boolean bool2 = true;
    int n = 0;
    int i1 = 0;
    Object localObject1 = paramObject1.getClass();
    if (localObject1 == paramObject2.getClass())
    {
      bool1 = true;
      hbe.a(bool1);
      if (!((Class)localObject1).isArray()) {
        break label112;
      }
      if (Array.getLength(paramObject1) != Array.getLength(paramObject2)) {
        break label106;
      }
    }
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hbe.a(bool1);
      paramObject1 = gus.a(paramObject1).iterator();
      n = i1;
      while (((Iterator)paramObject1).hasNext())
      {
        Array.set(paramObject2, n, c(((Iterator)paramObject1).next()));
        n += 1;
      }
      bool1 = false;
      break;
    }
    label112:
    if (Collection.class.isAssignableFrom((Class)localObject1))
    {
      paramObject1 = (Collection)paramObject1;
      if (ArrayList.class.isAssignableFrom((Class)localObject1)) {
        ((ArrayList)paramObject2).ensureCapacity(((Collection)paramObject1).size());
      }
      paramObject2 = (Collection)paramObject2;
      paramObject1 = ((Collection)paramObject1).iterator();
      while (((Iterator)paramObject1).hasNext()) {
        ((Collection)paramObject2).add(c(((Iterator)paramObject1).next()));
      }
    }
    bool1 = gua.class.isAssignableFrom((Class)localObject1);
    if ((bool1) || (!Map.class.isAssignableFrom((Class)localObject1)))
    {
      if (bool1) {}
      for (localObject1 = c;; localObject1 = gtr.a((Class)localObject1))
      {
        Iterator localIterator = d.iterator();
        while (localIterator.hasNext())
        {
          gtz localgtz = ((gtr)localObject1).a((String)localIterator.next());
          if ((!localgtz.a()) && ((!bool1) || (!a)))
          {
            Object localObject2 = localgtz.a(paramObject1);
            if (localObject2 != null) {
              localgtz.a(paramObject2, c(localObject2));
            }
          }
        }
      }
    }
    if (gte.class.isAssignableFrom((Class)localObject1))
    {
      paramObject2 = (gte)paramObject2;
      paramObject1 = (gte)paramObject1;
      i1 = ((gte)paramObject1).size();
      while (n < i1)
      {
        ((gte)paramObject2).a(n, c(((gte)paramObject1).a(n)));
        n += 1;
      }
    }
    paramObject2 = (Map)paramObject2;
    paramObject1 = ((Map)paramObject1).entrySet().iterator();
    while (((Iterator)paramObject1).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)paramObject1).next();
      ((Map)paramObject2).put((String)((Map.Entry)localObject1).getKey(), c(((Map.Entry)localObject1).getValue()));
    }
  }
  
  public static boolean a(Object paramObject)
  {
    return (paramObject != null) && (paramObject == m.get(paramObject.getClass()));
  }
  
  public static boolean a(Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramType = gus.a((WildcardType)paramType);
    }
    for (;;)
    {
      if (!(paramType instanceof Class)) {
        return false;
      }
      paramType = (Class)paramType;
      return (paramType.isPrimitive()) || (paramType == Character.class) || (paramType == String.class) || (paramType == Integer.class) || (paramType == Long.class) || (paramType == Short.class) || (paramType == Byte.class) || (paramType == Float.class) || (paramType == Double.class) || (paramType == BigInteger.class) || (paramType == BigDecimal.class) || (paramType == gty.class) || (paramType == Boolean.class);
    }
  }
  
  public static Collection<Object> b(Type paramType)
  {
    if ((paramType instanceof WildcardType)) {
      paramType = gus.a((WildcardType)paramType);
    }
    for (;;)
    {
      if ((paramType instanceof ParameterizedType)) {
        paramType = ((ParameterizedType)paramType).getRawType();
      }
      for (;;)
      {
        if ((paramType instanceof Class)) {}
        for (Class localClass = (Class)paramType; (paramType == null) || ((paramType instanceof GenericArrayType)) || ((localClass != null) && ((localClass.isArray()) || (localClass.isAssignableFrom(ArrayList.class)))); localClass = null) {
          return new ArrayList();
        }
        if (localClass == null)
        {
          paramType = String.valueOf(paramType);
          throw new IllegalArgumentException(String.valueOf(paramType).length() + 39 + "unable to create new instance of type: " + paramType);
        }
        if (localClass.isAssignableFrom(HashSet.class)) {
          return new HashSet();
        }
        if (localClass.isAssignableFrom(TreeSet.class)) {
          return new TreeSet();
        }
        return (Collection)gus.a(localClass);
      }
    }
  }
  
  public static Map<String, Object> b(Class<?> paramClass)
  {
    if ((paramClass == null) || (paramClass.isAssignableFrom(gte.class))) {
      return new gte();
    }
    if (paramClass.isAssignableFrom(TreeMap.class)) {
      return new TreeMap();
    }
    return (Map)gus.a(paramClass);
  }
  
  public static Map<String, Object> b(Object paramObject)
  {
    if ((paramObject == null) || (a(paramObject))) {
      return Collections.emptyMap();
    }
    if ((paramObject instanceof Map)) {
      return (Map)paramObject;
    }
    return new gtu(paramObject, false);
  }
  
  public static <T> T c(T paramT)
  {
    if ((paramT == null) || (a(paramT.getClass()))) {
      return paramT;
    }
    if ((paramT instanceof gua)) {
      return ((gua)paramT).b();
    }
    Object localObject = paramT.getClass();
    if (((Class)localObject).isArray()) {
      localObject = Array.newInstance(((Class)localObject).getComponentType(), Array.getLength(paramT));
    }
    for (;;)
    {
      a(paramT, localObject);
      return (T)localObject;
      if ((paramT instanceof gte))
      {
        localObject = ((gte)paramT).a();
      }
      else
      {
        if ("java.util.Arrays$ArrayList".equals(((Class)localObject).getName()))
        {
          paramT = ((List)paramT).toArray();
          a(paramT, paramT);
          return Arrays.asList(paramT);
        }
        localObject = gus.a((Class)localObject);
      }
    }
  }
  
  public static boolean d(Object paramObject)
  {
    return (paramObject == null) || (a(paramObject.getClass()));
  }
}

/* Location:
 * Qualified Name:     gtt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */