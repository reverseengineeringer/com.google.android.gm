import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

public abstract class hfd<E>
  extends hdx<E>
  implements Set<E>
{
  private transient hef<E> a;
  
  private static int a(int paramInt)
  {
    int j;
    if (paramInt < 751619276)
    {
      int i = Integer.highestOneBit(paramInt - 1) << 1;
      for (;;)
      {
        j = i;
        if (i * 0.7D >= paramInt) {
          break;
        }
        i <<= 1;
      }
    }
    if (paramInt < 1073741824) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool, "collection too large");
      j = 1073741824;
      return j;
    }
  }
  
  static <E> hfd<E> a(int paramInt, Object... paramVarArgs)
  {
    int j = paramInt;
    int n;
    Object[] arrayOfObject;
    int i1;
    int k;
    int i;
    label50:
    Object localObject1;
    int m;
    label81:
    Object localObject2;
    switch (j)
    {
    default: 
      n = a(j);
      arrayOfObject = new Object[n];
      i1 = n - 1;
      k = 0;
      paramInt = 0;
      i = 0;
      if (k < j)
      {
        localObject1 = hhz.a(paramVarArgs[k], k);
        int i2 = localObject1.hashCode();
        m = hdr.a(i2);
        int i3 = m & i1;
        localObject2 = arrayOfObject[i3];
        if (localObject2 == null)
        {
          m = paramInt + 1;
          paramVarArgs[paramInt] = localObject1;
          arrayOfObject[i3] = localObject1;
          i += i2;
          paramInt = m;
        }
      }
      break;
    }
    for (;;)
    {
      k += 1;
      break label50;
      return hik.a;
      return b(paramVarArgs[0]);
      if (!localObject2.equals(localObject1))
      {
        m += 1;
        break label81;
        Arrays.fill(paramVarArgs, paramInt, j, null);
        if (paramInt == 1) {
          return new his(paramVarArgs[0], i);
        }
        if (n != a(paramInt))
        {
          j = paramInt;
          break;
        }
        localObject1 = paramVarArgs;
        if (paramInt < paramVarArgs.length) {
          localObject1 = hhz.a(paramVarArgs, paramInt);
        }
        return new hik((Object[])localObject1, i, arrayOfObject, i1);
      }
    }
  }
  
  public static <E> hfd<E> a(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return a((Collection)paramIterable);
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return hik.a;
    }
    Object localObject = paramIterable.next();
    if (!paramIterable.hasNext()) {
      return b(localObject);
    }
    return new hfe().c(localObject).b(paramIterable).a();
  }
  
  public static <E> hfd<E> a(E paramE1, E paramE2)
  {
    return a(2, new Object[] { paramE1, paramE2 });
  }
  
  public static <E> hfd<E> a(E paramE1, E paramE2, E paramE3)
  {
    return a(3, new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> hfd<E> a(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return a(4, new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> hfd<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return a(5, new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  @SafeVarargs
  public static <E> hfd<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    Object[] arrayOfObject = new Object[paramVarArgs.length + 6];
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    arrayOfObject[5] = paramE6;
    System.arraycopy(paramVarArgs, 0, arrayOfObject, 6, paramVarArgs.length);
    return a(arrayOfObject.length, arrayOfObject);
  }
  
  public static <E> hfd<E> a(Collection<? extends E> paramCollection)
  {
    if (((paramCollection instanceof hfd)) && (!(paramCollection instanceof hfp)))
    {
      hfd localhfd = (hfd)paramCollection;
      if (!localhfd.e()) {
        return localhfd;
      }
    }
    else if ((paramCollection instanceof EnumSet))
    {
      paramCollection = EnumSet.copyOf((EnumSet)paramCollection);
      switch (paramCollection.size())
      {
      default: 
        return new hed(paramCollection);
      case 0: 
        return hik.a;
      }
      return b(hft.a(paramCollection));
    }
    paramCollection = paramCollection.toArray();
    return a(paramCollection.length, paramCollection);
  }
  
  public static <E> hfd<E> a(E[] paramArrayOfE)
  {
    switch (paramArrayOfE.length)
    {
    default: 
      return a(paramArrayOfE.length, (Object[])paramArrayOfE.clone());
    case 0: 
      return hik.a;
    }
    return b(paramArrayOfE[0]);
  }
  
  public static <E> hfd<E> b(E paramE)
  {
    return new his(paramE);
  }
  
  public static <E> hfd<E> g()
  {
    return hik.a;
  }
  
  public static <E> hfe<E> h()
  {
    return new hfe();
  }
  
  boolean I_()
  {
    return false;
  }
  
  public abstract hji<E> a();
  
  hef<E> d()
  {
    return new hic(this, toArray());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof hfd)) && (I_()) && (((hfd)paramObject).I_()) && (hashCode() != paramObject.hashCode())) {
      return false;
    }
    return hio.a(this, paramObject);
  }
  
  public final hef<E> f()
  {
    hef localhef2 = a;
    hef localhef1 = localhef2;
    if (localhef2 == null)
    {
      localhef1 = d();
      a = localhef1;
    }
    return localhef1;
  }
  
  public int hashCode()
  {
    return hio.a(this);
  }
  
  Object writeReplace()
  {
    return new hfh(toArray());
  }
}

/* Location:
 * Qualified Name:     hfd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */