package com.google.common.collect;

class ImmutableCollection$ArrayImmutableCollection<E>
  extends ImmutableCollection<E>
{
  private final E[] elements;
  
  ImmutableCollection$ArrayImmutableCollection(E[] paramArrayOfE)
  {
    elements = paramArrayOfE;
  }
  
  ImmutableList<E> createAsList()
  {
    if (elements.length == 1) {
      return new SingletonImmutableList(elements[0]);
    }
    return new RegularImmutableList(elements);
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.forArray(elements);
  }
  
  public int size()
  {
    return elements.length;
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableCollection.ArrayImmutableCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */