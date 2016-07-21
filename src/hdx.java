import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public abstract class hdx<E>
  extends AbstractCollection<E>
  implements Serializable
{
  int a(Object[] paramArrayOfObject, int paramInt)
  {
    hji localhji = a();
    while (localhji.hasNext())
    {
      paramArrayOfObject[paramInt] = localhji.next();
      paramInt += 1;
    }
    return paramInt;
  }
  
  public abstract hji<E> a();
  
  @Deprecated
  public final boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean contains(Object paramObject);
  
  abstract boolean e();
  
  public hef<E> f()
  {
    switch (size())
    {
    default: 
      return new hic(this, toArray());
    case 0: 
      return hii.a;
    }
    return hef.a(a().next());
  }
  
  @Deprecated
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray()
  {
    int i = size();
    if (i == 0) {
      return hhz.a;
    }
    Object[] arrayOfObject = new Object[i];
    a(arrayOfObject, 0);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    hbe.a(paramArrayOfT);
    int i = size();
    Object localObject;
    if (paramArrayOfT.length < i) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    }
    for (;;)
    {
      a((Object[])localObject, 0);
      return (T[])localObject;
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > i)
      {
        paramArrayOfT[i] = null;
        localObject = paramArrayOfT;
      }
    }
  }
  
  Object writeReplace()
  {
    return new hej(toArray());
  }
}

/* Location:
 * Qualified Name:     hdx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */