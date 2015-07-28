package com.google.common.collect;

class TransformedImmutableList$1
  extends AbstractIndexedListIterator<E>
{
  TransformedImmutableList$1(TransformedImmutableList paramTransformedImmutableList, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected E get(int paramInt)
  {
    return (E)this$0.get(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.TransformedImmutableList.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */