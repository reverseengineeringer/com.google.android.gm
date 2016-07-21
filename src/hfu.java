import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public final class hfu
{
  static final hjj<Object> a = new hfv();
  static final Iterator<Object> b = new hfy();
  
  public static <T> hji<T> a(T paramT)
  {
    return new hfx(paramT);
  }
  
  public static <T> hji<T> a(Iterator<? extends T> paramIterator)
  {
    hbe.a(paramIterator);
    if ((paramIterator instanceof hji)) {
      return (hji)paramIterator;
    }
    return new hfz(paramIterator);
  }
  
  @SafeVarargs
  public static <T> hji<T> a(T... paramVarArgs)
  {
    return a(paramVarArgs, 0, paramVarArgs.length, 0);
  }
  
  static <T> hjj<T> a(T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool);
      hbe.a(paramInt1, paramInt1 + paramInt2, paramArrayOfT.length);
      hbe.b(paramInt3, paramInt2);
      if (paramInt2 != 0) {
        break;
      }
      return a;
    }
    return new hfw(paramInt2, paramInt3, paramArrayOfT, paramInt1);
  }
  
  public static <F, T> Iterator<T> a(Iterator<F> paramIterator, hav<? super F, ? extends T> paramhav)
  {
    hbe.a(paramhav);
    return new hga(paramIterator, paramhav);
  }
  
  public static <T> boolean a(Collection<T> paramCollection, Iterator<? extends T> paramIterator)
  {
    hbe.a(paramCollection);
    hbe.a(paramIterator);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      bool |= paramCollection.add(paramIterator.next());
    }
    return bool;
  }
  
  public static boolean a(Iterator<?> paramIterator, Object paramObject)
  {
    boolean bool = false;
    paramObject = hbg.a(paramObject);
    hbe.a(paramObject, "predicate");
    int i = 0;
    if (paramIterator.hasNext()) {
      if (!((hbf)paramObject).apply(paramIterator.next())) {}
    }
    for (;;)
    {
      if (i != -1) {
        bool = true;
      }
      return bool;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static boolean a(Iterator<?> paramIterator, Collection<?> paramCollection)
  {
    paramCollection = hbg.a(paramCollection);
    hbe.a(paramCollection);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      if (paramCollection.apply(paramIterator.next()))
      {
        paramIterator.remove();
        bool = true;
      }
    }
    return bool;
  }
  
  public static boolean a(Iterator<?> paramIterator1, Iterator<?> paramIterator2)
  {
    if (paramIterator1.hasNext()) {
      if (paramIterator2.hasNext()) {}
    }
    while (paramIterator2.hasNext())
    {
      return false;
      if (hbc.a(paramIterator1.next(), paramIterator2.next())) {
        break;
      }
      return false;
    }
    return true;
  }
  
  public static <T> T b(Iterator<T> paramIterator)
  {
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return (T)localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = String.valueOf(localObject);
    localStringBuilder.append(String.valueOf(localObject).length() + 31 + "expected one element but was: <" + (String)localObject);
    int i = 0;
    while ((i < 4) && (paramIterator.hasNext()))
    {
      localObject = String.valueOf(paramIterator.next());
      localStringBuilder.append(String.valueOf(localObject).length() + 2 + ", " + (String)localObject);
      i += 1;
    }
    if (paramIterator.hasNext()) {
      localStringBuilder.append(", ...");
    }
    localStringBuilder.append('>');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static <T> T b(Iterator<? extends T> paramIterator, T paramT)
  {
    if (paramIterator.hasNext()) {
      return (T)paramIterator.next();
    }
    return null;
  }
  
  static void c(Iterator<?> paramIterator)
  {
    hbe.a(paramIterator);
    while (paramIterator.hasNext())
    {
      paramIterator.next();
      paramIterator.remove();
    }
  }
  
  public static <T> hib<T> d(Iterator<? extends T> paramIterator)
  {
    if ((paramIterator instanceof hgb)) {
      return (hgb)paramIterator;
    }
    return new hgb(paramIterator);
  }
  
  static <T> ListIterator<T> e(Iterator<T> paramIterator)
  {
    return (ListIterator)paramIterator;
  }
}

/* Location:
 * Qualified Name:     hfu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */