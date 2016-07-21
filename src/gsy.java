import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class gsy
{
  private static WeakHashMap<Class<?>, Field> a = new WeakHashMap();
  private static final Lock b = new ReentrantLock();
  
  private final Object a(gss paramgss)
  {
    Field localField = null;
    boolean bool2 = true;
    int k = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    int j = 0;
    Object localObject3;
    Object localObject1;
    Type localType = gtt.a((List)localObject3, (Type)localObject1);
    Object localObject5;
    if ((localType instanceof Class))
    {
      localObject1 = (Class)localType;
      localObject5 = localObject1;
      if ((localType instanceof ParameterizedType)) {
        localObject5 = gus.a((ParameterizedType)localType);
      }
      if (localObject5 != Void.class) {
        break label83;
      }
      o();
      localObject4 = null;
    }
    label83:
    boolean bool1;
    int i;
    label313:
    Collection localCollection;
    Object localObject2;
    label435:
    label474:
    label492:
    label558:
    label579:
    label588:
    do
    {
      return localObject4;
      localObject1 = null;
      break;
      localObject1 = c();
      try
      {
        switch (gsz.a[c().ordinal()])
        {
        case 2: 
          localObject1 = String.valueOf(localObject1);
          throw new IllegalArgumentException(String.valueOf(localObject1).length() + 27 + "unexpected JSON node type: " + (String)localObject1);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject3 = new StringBuilder();
        localObject4 = b();
        if (localObject4 != null) {
          ((StringBuilder)localObject3).append("key ").append((String)localObject4);
        }
        if (paramgss != null)
        {
          if (localObject4 != null) {
            ((StringBuilder)localObject3).append(", ");
          }
          ((StringBuilder)localObject3).append("field ").append(paramgss);
        }
        throw new IllegalArgumentException(((StringBuilder)localObject3).toString(), localIllegalArgumentException);
      }
      bool1 = gus.a(localType);
      if ((localType == null) || (bool1)) {
        break label1380;
      }
      i = j;
      if (localObject5 != null)
      {
        i = j;
        if (gus.a((Class)localObject5, Collection.class)) {
          break label1380;
        }
      }
      if (i == 0) {
        throw new IllegalArgumentException(hbe.a("expected collection or array type but got %s", new Object[] { localType }));
      }
      localCollection = gtt.b(localType);
      if (bool1) {
        localObject2 = gus.b(localType);
      }
      for (;;)
      {
        localObject2 = gtt.a((List)localObject3, (Type)localObject2);
        a(paramgss, localCollection, (Type)localObject2, (ArrayList)localObject3, (gss)localObject4);
        if (!bool1) {
          break;
        }
        return gus.a(localCollection, gus.a((List)localObject3, (Type)localObject2));
        localObject2 = localField;
        if (localObject5 != null)
        {
          localObject2 = localField;
          if (Iterable.class.isAssignableFrom((Class)localObject5)) {
            localObject2 = gus.a(localType, Iterable.class, 0);
          }
        }
      }
      if (gus.a(localType)) {
        break label1389;
      }
      i = 1;
      if (i == 0) {
        throw new IllegalArgumentException(hbe.a("expected object or map type but got %s", new Object[] { localType }));
      }
      if (!bool1) {
        break label1395;
      }
      localField = b((Class)localObject5);
      if ((localObject5 == null) || (!gus.a((Class)localObject5, Map.class))) {
        break label1401;
      }
      i = 1;
      if (localField == null) {
        break label1407;
      }
      localObject2 = new gst();
      for (;;)
      {
        j = ((ArrayList)localObject3).size();
        if (localType != null) {
          ((ArrayList)localObject3).add(localType);
        }
        if ((i == 0) || (gua.class.isAssignableFrom((Class)localObject5))) {
          break;
        }
        if (!Map.class.isAssignableFrom((Class)localObject5)) {
          break label1420;
        }
        localObject5 = gus.a(localType, Map.class, 1);
        if (localObject5 == null) {
          break;
        }
        a(paramgss, (Map)localObject2, (Type)localObject5, (ArrayList)localObject3, (gss)localObject4);
        return localObject2;
        localObject2 = gtt.b((Class)localObject5);
        continue;
        localObject2 = gus.a((Class)localObject5);
      }
      a((ArrayList)localObject3, localObject2, (gss)localObject4);
      if (localType != null) {
        ((ArrayList)localObject3).remove(j);
      }
      localObject4 = localObject2;
    } while (localField == null);
    Object localObject4 = ((gst)localObject2).get(localField.getName());
    if (localObject4 != null)
    {
      bool1 = true;
      label647:
      hbe.a(bool1, "No value specified for @JsonPolymorphicTypeMap field");
      localObject5 = localObject4.toString();
      localObject4 = ((gta)localField.getAnnotation(gta.class)).a();
      j = localObject4.length;
      i = 0;
      label686:
      if (i < j)
      {
        localField = localObject4[i];
        if (!localField.a().equals(localObject5)) {
          break label1444;
        }
        localObject4 = localField.b();
        break label1426;
        label727:
        localObject5 = String.valueOf(localObject5);
        if (((String)localObject5).length() != 0) {}
        for (localObject5 = "No TypeDef annotation found with key: ".concat((String)localObject5);; localObject5 = new String("No TypeDef annotation found with key: "))
        {
          hbe.a(bool1, localObject5);
          localObject5 = d();
          localObject2 = ((gsu)localObject5).a(((gsu)localObject5).a(localObject2, false));
          ((gsy)localObject2).p();
          return ((gsy)localObject2).a(paramgss, (Type)localObject4, (ArrayList)localObject3, null, false);
        }
        if ((localType == null) || (localObject5 == Boolean.TYPE)) {
          break label1459;
        }
        i = k;
        if (localObject5 != null)
        {
          i = k;
          if (((Class)localObject5).isAssignableFrom(Boolean.class)) {
            break label1459;
          }
        }
        label846:
        if (i == 0) {
          throw new IllegalArgumentException(hbe.a("expected type Boolean or boolean but got %s", new Object[] { localType }));
        }
        if (localObject2 == gtd.i) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (paramgss == null) {
          break label1465;
        }
        bool1 = bool4;
        if (paramgss.getAnnotation(gtc.class) == null) {
          break label1465;
        }
        label909:
        hbe.a(bool1, "number type formatted as a JSON number cannot use @JsonString annotation");
        if ((localObject5 == null) || (((Class)localObject5).isAssignableFrom(BigDecimal.class))) {
          return j();
        }
        if (localObject5 == BigInteger.class) {
          return i();
        }
        if ((localObject5 == Double.class) || (localObject5 == Double.TYPE)) {
          return Double.valueOf(k());
        }
        if ((localObject5 == Long.class) || (localObject5 == Long.TYPE)) {
          return Long.valueOf(l());
        }
        if ((localObject5 == Float.class) || (localObject5 == Float.TYPE)) {
          return Float.valueOf(h());
        }
        if ((localObject5 == Integer.class) || (localObject5 == Integer.TYPE)) {
          return Integer.valueOf(g());
        }
        if ((localObject5 == Short.class) || (localObject5 == Short.TYPE)) {
          return Short.valueOf(f());
        }
        if ((localObject5 == Byte.class) || (localObject5 == Byte.TYPE)) {
          return Byte.valueOf(e());
        }
        localObject2 = String.valueOf(localType);
        throw new IllegalArgumentException(String.valueOf(localObject2).length() + 30 + "expected numeric type but got " + (String)localObject2);
        localObject2 = m().trim().toLowerCase(Locale.US);
        if (((localObject5 != Float.TYPE) && (localObject5 != Float.class) && (localObject5 != Double.TYPE) && (localObject5 != Double.class)) || ((!((String)localObject2).equals("nan")) && (!((String)localObject2).equals("infinity")) && (!((String)localObject2).equals("-infinity"))))
        {
          if ((localObject5 == null) || (!Number.class.isAssignableFrom((Class)localObject5))) {
            break label1471;
          }
          bool1 = bool3;
          if (paramgss != null)
          {
            bool1 = bool3;
            if (paramgss.getAnnotation(gtc.class) != null) {
              break label1471;
            }
          }
          label1256:
          hbe.a(bool1, "number field formatted as a JSON string must use the @JsonString annotation");
        }
        return gtt.a(localType, m());
        if (localObject5 == null) {
          break label1477;
        }
        if (((Class)localObject5).isPrimitive()) {
          break label1483;
        }
        break label1477;
      }
    }
    for (;;)
    {
      hbe.a(bool1, "primitive number field but found a JSON null");
      if ((localObject5 != null) && ((((Class)localObject5).getModifiers() & 0x600) != 0))
      {
        if (gus.a((Class)localObject5, Collection.class)) {
          return gtt.a(gtt.b(localType).getClass());
        }
        if (gus.a((Class)localObject5, Map.class)) {
          return gtt.a(gtt.b((Class)localObject5).getClass());
        }
      }
      localObject2 = gtt.a(gus.a((List)localObject3, localType));
      return localObject2;
      localObject4 = null;
      break label1426;
      break;
      label1380:
      i = 1;
      break label313;
      return localCollection;
      label1389:
      i = 0;
      break label435;
      label1395:
      localField = null;
      break label474;
      label1401:
      i = 0;
      break label492;
      label1407:
      if (i != 0) {
        break label579;
      }
      if (localObject5 != null) {
        break label588;
      }
      break label579;
      label1420:
      localObject5 = null;
      break label558;
      label1426:
      if (localObject4 != null)
      {
        bool1 = bool2;
        break label727;
        bool1 = false;
        break label647;
        label1444:
        i += 1;
        break label686;
      }
      bool1 = false;
      break label727;
      label1459:
      i = 1;
      break label846;
      label1465:
      bool1 = true;
      break label909;
      label1471:
      bool1 = true;
      break label1256;
      label1477:
      bool1 = true;
      continue;
      label1483:
      bool1 = false;
    }
  }
  
  private final <T> void a(Field paramField, Collection<T> paramCollection, Type paramType, ArrayList<Type> paramArrayList, gss paramgss)
  {
    for (gtd localgtd = q(); localgtd != gtd.b; localgtd = n()) {
      paramCollection.add(a(paramField, paramType, paramArrayList, paramgss, true));
    }
  }
  
  private final void a(Field paramField, Map<String, Object> paramMap, Type paramType, ArrayList<Type> paramArrayList, gss paramgss)
  {
    for (Object localObject = q(); localObject == gtd.e; localObject = n())
    {
      localObject = m();
      n();
      paramMap.put(localObject, a(paramField, paramType, paramArrayList, paramgss, true));
    }
  }
  
  private final void a(ArrayList<Type> paramArrayList, Object paramObject, gss paramgss)
  {
    if ((paramObject instanceof gst)) {
      a = d();
    }
    Object localObject2 = q();
    Class localClass = paramObject.getClass();
    gtr localgtr = gtr.a(localClass);
    boolean bool = gua.class.isAssignableFrom(localClass);
    Object localObject1 = localObject2;
    if (!bool)
    {
      localObject1 = localObject2;
      if (Map.class.isAssignableFrom(localClass))
      {
        a(null, (Map)paramObject, gus.a(localClass, Map.class, 1), paramArrayList, paramgss);
        return;
        label89:
        localObject2 = b;
        int i = paramArrayList.size();
        paramArrayList.add(((Field)localObject2).getGenericType());
        localObject2 = a((Field)localObject2, b.getGenericType(), paramArrayList, paramgss, true);
        paramArrayList.remove(i);
        ((gtz)localObject1).a(paramObject, localObject2);
      }
    }
    for (;;)
    {
      localObject1 = n();
      if (localObject1 != gtd.e) {
        break;
      }
      localObject2 = m();
      n();
      localObject1 = localgtr.a((String)localObject2);
      if (localObject1 != null)
      {
        if ((!((gtz)localObject1).a()) || (a)) {
          break label89;
        }
        throw new IllegalArgumentException("final array/object fields are not supported");
      }
      if (bool) {
        ((gua)paramObject).b((String)localObject2, a(null, null, paramArrayList, paramgss, true));
      } else {
        o();
      }
    }
  }
  
  private static Field b(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    b.lock();
    label159:
    label305:
    label345:
    for (;;)
    {
      Field localField;
      try
      {
        if (a.containsKey(paramClass))
        {
          paramClass = (Field)a.get(paramClass);
          return paramClass;
        }
        Iterator localIterator = Collections.unmodifiableCollection(ac.values()).iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label305;
        }
        localField = nextb;
        localObject2 = (gta)localField.getAnnotation(gta.class);
        if (localObject2 == null) {
          break label345;
        }
        if (localObject1 == null)
        {
          i = 1;
          if (i != 0) {
            break label159;
          }
          throw new IllegalArgumentException(hbe.a("Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", new Object[] { paramClass }));
        }
      }
      finally
      {
        b.unlock();
      }
      int i = 0;
      continue;
      boolean bool = gtt.a(localField.getType());
      Object localObject1 = localField.getType();
      if (!bool) {
        throw new IllegalArgumentException(hbe.a("Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", new Object[] { paramClass, localObject1 }));
      }
      localObject1 = ((gta)localObject2).a();
      Object localObject2 = new HashSet();
      int j;
      if (localObject1.length > 0)
      {
        bool = true;
        hbe.a(bool, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
        j = localObject1.length;
        i = 0;
      }
      for (;;)
      {
        if (i < j)
        {
          String str = localObject1[i];
          bool = ((HashSet)localObject2).add(str.a());
          str = str.a();
          if (!bool)
          {
            throw new IllegalArgumentException(hbe.a("Class contains two @TypeDef annotations with identical key: %s", new Object[] { str }));
            a.put(paramClass, localObject1);
            b.unlock();
            return (Field)localObject1;
          }
        }
        else
        {
          localObject1 = localField;
          break label345;
          bool = false;
          break;
        }
        i += 1;
      }
    }
  }
  
  private final gtd p()
  {
    gtd localgtd = c();
    if (localgtd == null) {
      localgtd = n();
    }
    for (;;)
    {
      if (localgtd != null) {}
      for (boolean bool = true;; bool = false)
      {
        hbe.a(bool, "no JSON input found");
        return localgtd;
      }
    }
  }
  
  private final gtd q()
  {
    gtd localgtd = p();
    switch (gsz.a[localgtd.ordinal()])
    {
    default: 
      return localgtd;
    case 1: 
      localgtd = n();
      if ((localgtd == gtd.e) || (localgtd == gtd.d)) {}
      for (boolean bool = true;; bool = false)
      {
        hbe.a(bool, localgtd);
        return localgtd;
      }
    }
    return n();
  }
  
  public final <T> T a()
  {
    try
    {
      Object localObject1 = a((Type)localObject1, false, null);
      return (T)localObject1;
    }
    finally
    {
      a();
    }
  }
  
  public final Object a(Type paramType, boolean paramBoolean, gss paramgss)
  {
    try
    {
      if (!Void.class.equals(paramType)) {
        p();
      }
      paramType = a(null, paramType, new ArrayList(), null, true);
      return paramType;
    }
    finally
    {
      if (paramBoolean) {
        a();
      }
    }
  }
  
  public final String a(Set<String> paramSet)
  {
    for (Object localObject = q(); localObject == gtd.e; localObject = n())
    {
      localObject = m();
      n();
      if (paramSet.contains(localObject)) {
        return (String)localObject;
      }
      o();
    }
    return null;
  }
  
  public abstract void a();
  
  public abstract String b();
  
  public abstract gtd c();
  
  public abstract gsu d();
  
  public abstract byte e();
  
  public abstract short f();
  
  public abstract int g();
  
  public abstract float h();
  
  public abstract BigInteger i();
  
  public abstract BigDecimal j();
  
  public abstract double k();
  
  public abstract long l();
  
  public abstract String m();
  
  public abstract gtd n();
  
  public abstract gsy o();
}

/* Location:
 * Qualified Name:     gsy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */