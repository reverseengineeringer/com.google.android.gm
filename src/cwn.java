import java.util.Comparator;
import java.util.Map;

public final class cwn<T, K>
  implements Comparator<T>
{
  private final Map<K, Integer> a;
  private final hav<T, K> b;
  
  public cwn(K[] paramArrayOfK, hav<T, K> paramhav)
  {
    hen localhen = new hen();
    int i = 0;
    while (i < paramArrayOfK.length)
    {
      localhen.b(paramArrayOfK[i], Integer.valueOf(i));
      i += 1;
    }
    a = localhen.b();
    b = paramhav;
  }
  
  private final int a(T paramT)
  {
    paramT = b.apply(paramT);
    if (a.containsKey(paramT)) {
      return ((Integer)a.get(paramT)).intValue();
    }
    return Integer.MAX_VALUE;
  }
  
  public final int compare(T paramT1, T paramT2)
  {
    int i = a(paramT1);
    int j = a(paramT2);
    if (i < j) {
      return -1;
    }
    if (i == j) {
      return 0;
    }
    return 1;
  }
}

/* Location:
 * Qualified Name:     cwn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */