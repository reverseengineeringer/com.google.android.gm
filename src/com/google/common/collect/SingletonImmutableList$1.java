package com.google.common.collect;

import java.util.NoSuchElementException;

class SingletonImmutableList$1
  extends UnmodifiableListIterator<E>
{
  boolean hasNext;
  
  SingletonImmutableList$1(SingletonImmutableList paramSingletonImmutableList, int paramInt)
  {
    if (val$start == 0) {}
    for (boolean bool = true;; bool = false)
    {
      hasNext = bool;
      return;
    }
  }
  
  public boolean hasNext()
  {
    return hasNext;
  }
  
  public boolean hasPrevious()
  {
    return !hasNext;
  }
  
  public E next()
  {
    if (!hasNext) {
      throw new NoSuchElementException();
    }
    hasNext = false;
    return (E)this$0.element;
  }
  
  public int nextIndex()
  {
    if (hasNext) {
      return 0;
    }
    return 1;
  }
  
  public E previous()
  {
    if (hasNext) {
      throw new NoSuchElementException();
    }
    hasNext = true;
    return (E)this$0.element;
  }
  
  public int previousIndex()
  {
    if (hasNext) {
      return -1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.SingletonImmutableList.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */