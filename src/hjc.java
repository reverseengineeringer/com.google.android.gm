import java.util.Comparator;
import java.util.List;

 enum hjc
{
  hjc() {}
  
  final <E> int a(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
  {
    int i = paramList.size() - 1;
    while (paramInt < i)
    {
      int j = paramInt + i + 1 >>> 1;
      if (paramComparator.compare(paramList.get(j), paramE) > 0) {
        i = j - 1;
      } else {
        paramInt = j;
      }
    }
    return paramInt;
  }
}

/* Location:
 * Qualified Name:     hjc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */