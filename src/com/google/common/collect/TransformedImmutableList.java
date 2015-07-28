package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

abstract class TransformedImmutableList<D, E>
  extends ImmutableList<E>
{
  private final transient ImmutableList<D> backingList;
  
  TransformedImmutableList(ImmutableList<D> paramImmutableList)
  {
    backingList = ((ImmutableList)Preconditions.checkNotNull(paramImmutableList));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof List)) {
        break;
      }
      paramObject = (List)paramObject;
    } while ((size() == ((List)paramObject).size()) && (Iterators.elementsEqual(iterator(), ((List)paramObject).iterator())));
    return false;
    return false;
  }
  
  public E get(int paramInt)
  {
    return (E)transform(backingList.get(paramInt));
  }
  
  public int hashCode()
  {
    int i = 1;
    Iterator localIterator = iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject == null) {}
      for (int j = 0;; j = localObject.hashCode())
      {
        i = i * 31 + j;
        break;
      }
    }
    return i;
  }
  
  public int indexOf(Object paramObject)
  {
    int j;
    if (paramObject == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= size()) {
        break label39;
      }
      j = i;
      if (get(i).equals(paramObject)) {
        break;
      }
      i += 1;
    }
    label39:
    return -1;
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public int lastIndexOf(Object paramObject)
  {
    int j;
    if (paramObject == null)
    {
      j = -1;
      return j;
    }
    int i = size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label40;
      }
      j = i;
      if (get(i).equals(paramObject)) {
        break;
      }
      i -= 1;
    }
    label40:
    return -1;
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt)
  {
    new AbstractIndexedListIterator(size(), paramInt)
    {
      protected E get(int paramAnonymousInt)
      {
        return (E)TransformedImmutableList.this.get(paramAnonymousInt);
      }
    };
  }
  
  public int size()
  {
    return backingList.size();
  }
  
  public ImmutableList<E> subList(int paramInt1, int paramInt2)
  {
    return new TransformedView(backingList.subList(paramInt1, paramInt2));
  }
  
  public Object[] toArray()
  {
    return ObjectArrays.toArrayImpl(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return ObjectArrays.toArrayImpl(this, paramArrayOfT);
  }
  
  abstract E transform(D paramD);
  
  private class TransformedView
    extends TransformedImmutableList<D, E>
  {
    TransformedView()
    {
      super();
    }
    
    E transform(D paramD)
    {
      return (E)TransformedImmutableList.this.transform(paramD);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.TransformedImmutableList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */