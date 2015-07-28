package com.google.common.collect;

class RegularImmutableList$1
  extends AbstractIndexedListIterator<E>
{
  RegularImmutableList$1(RegularImmutableList paramRegularImmutableList, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected E get(int paramInt)
  {
    return (E)RegularImmutableList.access$000(this$0)[(RegularImmutableList.access$100(this$0) + paramInt)];
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.RegularImmutableList.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */