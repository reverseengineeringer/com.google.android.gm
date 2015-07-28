package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$KeyPresentBehavior$2
{
  SortedLists$KeyPresentBehavior$2()
  {
    super(paramString, paramInt, null);
  }
  
  <E> int resultIndex(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
  {
    int i = paramInt;
    paramInt = paramList.size() - 1;
    while (i < paramInt)
    {
      int j = i + paramInt + 1 >>> 1;
      if (paramComparator.compare(paramList.get(j), paramE) > 0) {
        paramInt = j - 1;
      } else {
        i = j;
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.SortedLists.KeyPresentBehavior.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */