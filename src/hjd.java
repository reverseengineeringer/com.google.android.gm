import java.util.Comparator;
import java.util.List;

 enum hjd
{
  hjd() {}
  
  final <E> int a(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = i + paramInt >>> 1;
      if (paramComparator.compare(paramList.get(j), paramE) < 0) {
        i = j + 1;
      } else {
        paramInt = j;
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     hjd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */