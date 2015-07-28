package com.google.common.collect;

class TransformedImmutableList$TransformedView
  extends TransformedImmutableList<D, E>
{
  TransformedImmutableList$TransformedView(ImmutableList<D> paramImmutableList)
  {
    super(localImmutableList);
  }
  
  E transform(D paramD)
  {
    return (E)this$0.transform(paramD);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.TransformedImmutableList.TransformedView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */