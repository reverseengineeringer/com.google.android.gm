import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

final class hiv
{
  public static <E> int a(List<? extends E> paramList, E paramE, Comparator<? super E> paramComparator, hja paramhja, hiw paramhiw)
  {
    hbe.a(paramComparator);
    hbe.a(paramList);
    hbe.a(paramhja);
    hbe.a(paramhiw);
    Object localObject = paramList;
    if (!(paramList instanceof RandomAccess)) {
      localObject = hgd.a(paramList);
    }
    int i = 0;
    int j = ((List)localObject).size() - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = paramComparator.compare(paramE, ((List)localObject).get(k));
      if (m < 0) {
        j = k - 1;
      } else if (m > 0) {
        i = k + 1;
      } else {
        return paramhja.a(paramComparator, paramE, ((List)localObject).subList(i, j + 1), k - i) + i;
      }
    }
    return paramhiw.a(i);
  }
}

/* Location:
 * Qualified Name:     hiv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */