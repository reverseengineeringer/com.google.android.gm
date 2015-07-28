package com.google.common.collect;

final class Iterators$12
  extends AbstractIndexedListIterator<T>
{
  Iterators$12(int paramInt1, Object[] paramArrayOfObject, int paramInt2)
  {
    super(paramInt1);
  }
  
  protected T get(int paramInt)
  {
    return (T)val$array[(val$offset + paramInt)];
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.Iterators.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */