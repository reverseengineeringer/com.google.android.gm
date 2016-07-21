import java.util.Arrays;
import java.util.Comparator;

public final class hfq<E>
  extends hfe<E>
{
  private final Comparator<? super E> c;
  
  public hfq(Comparator<? super E> paramComparator)
  {
    c = ((Comparator)hbe.a(paramComparator));
  }
  
  public final hfp<E> b()
  {
    Object localObject1 = a;
    Comparator localComparator = c;
    int m = b;
    if (m == 0)
    {
      localObject1 = hfp.a(localComparator);
      b = ((hfp)localObject1).size();
      return (hfp<E>)localObject1;
    }
    hhz.b((Object[])localObject1, m);
    Arrays.sort((Object[])localObject1, 0, m, localComparator);
    int j = 1;
    int i = 1;
    label64:
    if (j < m)
    {
      Object localObject2 = localObject1[j];
      if (localComparator.compare(localObject2, localObject1[(i - 1)]) == 0) {
        break label142;
      }
      int k = i + 1;
      localObject1[i] = localObject2;
      i = k;
    }
    label142:
    for (;;)
    {
      j += 1;
      break label64;
      Arrays.fill((Object[])localObject1, i, m, null);
      localObject1 = new hil(hef.b((Object[])localObject1, i), localComparator);
      break;
    }
  }
  
  public final hfq<E> c(E... paramVarArgs)
  {
    super.b(paramVarArgs);
    return this;
  }
  
  public final hfq<E> d(E paramE)
  {
    super.c(paramE);
    return this;
  }
}

/* Location:
 * Qualified Name:     hfq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */