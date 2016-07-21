import java.util.Comparator;
import java.util.SortedSet;

final class hiu
{
  public static boolean a(Comparator<?> paramComparator, Iterable<?> paramIterable)
  {
    hbe.a(paramComparator);
    hbe.a(paramIterable);
    if ((paramIterable instanceof SortedSet))
    {
      Comparator localComparator = ((SortedSet)paramIterable).comparator();
      paramIterable = localComparator;
      if (localComparator != null) {}
    }
    for (paramIterable = hhy.a;; paramIterable = ((hit)paramIterable).comparator())
    {
      return paramComparator.equals(paramIterable);
      if (!(paramIterable instanceof hit)) {
        break;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     hiu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */