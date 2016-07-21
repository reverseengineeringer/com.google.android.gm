import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class hef<E>
  extends hdx<E>
  implements List<E>, RandomAccess
{
  public static <E> hef<E> a(E paramE)
  {
    return new hir(paramE);
  }
  
  public static <E> hef<E> a(E paramE1, E paramE2)
  {
    paramE1 = hhz.b(new Object[] { paramE1, paramE2 }, 2);
    return b(paramE1, paramE1.length);
  }
  
  public static <E> hef<E> a(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    paramE1 = hhz.b(new Object[] { paramE1, paramE2, paramE3, paramE4 }, 4);
    return b(paramE1, paramE1.length);
  }
  
  public static <E> hef<E> a(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof hdx))
    {
      hef localhef = ((hdx)paramCollection).f();
      paramCollection = localhef;
      if (localhef.e())
      {
        paramCollection = localhef.toArray();
        paramCollection = b(paramCollection, paramCollection.length);
      }
      return paramCollection;
    }
    paramCollection = paramCollection.toArray();
    paramCollection = hhz.b(paramCollection, paramCollection.length);
    return b(paramCollection, paramCollection.length);
  }
  
  public static <E> hef<E> a(E[] paramArrayOfE)
  {
    switch (paramArrayOfE.length)
    {
    default: 
      paramArrayOfE = (Object[])paramArrayOfE.clone();
      return new hii(hhz.b(paramArrayOfE, paramArrayOfE.length));
    case 0: 
      return hii.a;
    }
    return new hir(paramArrayOfE[0]);
  }
  
  public static <E> hef<E> b(Object[] paramArrayOfObject, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Object[] arrayOfObject = paramArrayOfObject;
      if (paramInt < paramArrayOfObject.length) {
        arrayOfObject = hhz.a(paramArrayOfObject, paramInt);
      }
      return new hii(arrayOfObject);
    case 0: 
      return hii.a;
    }
    return new hir(paramArrayOfObject[0]);
  }
  
  public static <E> heh<E> d()
  {
    return new heh();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  int a(Object[] paramArrayOfObject, int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      paramArrayOfObject[(paramInt + i)] = get(i);
      i += 1;
    }
    return paramInt + j;
  }
  
  public hef<E> a(int paramInt1, int paramInt2)
  {
    hbe.a(paramInt1, paramInt2, size());
    int i = paramInt2 - paramInt1;
    if (i == size()) {
      return this;
    }
    switch (i)
    {
    default: 
      return b(paramInt1, paramInt2);
    case 0: 
      return hii.a;
    }
    return a(get(paramInt1));
  }
  
  public hji<E> a()
  {
    return a(0);
  }
  
  public hjj<E> a(int paramInt)
  {
    return new heg(this, size(), paramInt);
  }
  
  @Deprecated
  public final void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  hef<E> b(int paramInt1, int paramInt2)
  {
    return new hek(this, paramInt1, paramInt2 - paramInt1);
  }
  
  public hef<E> c()
  {
    if (size() <= 1) {
      return this;
    }
    return new hei(this);
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == hbe.a(this)) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof List)) {
        return false;
      }
      paramObject = (List)paramObject;
      int j = size();
      if (j != ((List)paramObject).size()) {
        return false;
      }
      if ((!(this instanceof RandomAccess)) || (!(paramObject instanceof RandomAccess))) {
        break;
      }
      int i = 0;
      while (i < j)
      {
        if (!hbc.a(get(i), ((List)paramObject).get(i))) {
          return false;
        }
        i += 1;
      }
    }
    return hfu.a(iterator(), ((List)paramObject).iterator());
  }
  
  public final hef<E> f()
  {
    return this;
  }
  
  public int hashCode()
  {
    int j = 1;
    int k = size();
    int i = 0;
    while (i < k)
    {
      j = j * 31 + get(i).hashCode() ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
      i += 1;
    }
    return j;
  }
  
  public int indexOf(Object paramObject)
  {
    int i = 0;
    int j = 0;
    if (paramObject != null)
    {
      if ((this instanceof RandomAccess))
      {
        int k = size();
        if (paramObject == null)
        {
          i = j;
          while (i < k)
          {
            if (get(i) == null) {
              return i;
            }
            i += 1;
          }
        }
        do
        {
          i += 1;
          if (i >= k) {
            break;
          }
        } while (!paramObject.equals(get(i)));
        return i;
        return -1;
      }
      ListIterator localListIterator = listIterator();
      while (localListIterator.hasNext()) {
        if (hbc.a(paramObject, localListIterator.next())) {
          return localListIterator.previousIndex();
        }
      }
    }
    return -1;
  }
  
  public int lastIndexOf(Object paramObject)
  {
    if (paramObject != null)
    {
      if ((this instanceof RandomAccess))
      {
        int j;
        if (paramObject == null)
        {
          i = size() - 1;
          while (i >= 0)
          {
            if (get(i) == null)
            {
              j = i;
              return j;
            }
            i -= 1;
          }
        }
        int i = size() - 1;
        for (;;)
        {
          if (i < 0) {
            break label85;
          }
          j = i;
          if (paramObject.equals(get(i))) {
            break;
          }
          i -= 1;
        }
        label85:
        return -1;
      }
      ListIterator localListIterator = listIterator(size());
      while (localListIterator.hasPrevious()) {
        if (hbc.a(paramObject, localListIterator.previous())) {
          return localListIterator.nextIndex();
        }
      }
    }
    return -1;
  }
  
  @Deprecated
  public final E remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  Object writeReplace()
  {
    return new hej(toArray());
  }
}

/* Location:
 * Qualified Name:     hef
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */