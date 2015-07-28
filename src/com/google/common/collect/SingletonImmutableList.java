package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.List;
import java.util.NoSuchElementException;

final class SingletonImmutableList<E>
  extends ImmutableList<E>
{
  final transient E element;
  
  SingletonImmutableList(E paramE)
  {
    element = Preconditions.checkNotNull(paramE);
  }
  
  public boolean contains(Object paramObject)
  {
    return element.equals(paramObject);
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
    } while ((((List)paramObject).size() == 1) && (element.equals(((List)paramObject).get(0))));
    return false;
    return false;
  }
  
  public E get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, 1);
    return (E)element;
  }
  
  public int hashCode()
  {
    return element.hashCode() + 31;
  }
  
  public int indexOf(Object paramObject)
  {
    if (element.equals(paramObject)) {
      return 0;
    }
    return -1;
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
    return Iterators.singletonIterator(element);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    if (element.equals(paramObject)) {
      return 0;
    }
    return -1;
  }
  
  public UnmodifiableListIterator<E> listIterator(final int paramInt)
  {
    Preconditions.checkPositionIndex(paramInt, 1);
    new UnmodifiableListIterator()
    {
      boolean hasNext;
      
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
        return (E)element;
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
        return (E)element;
      }
      
      public int previousIndex()
      {
        if (hasNext) {
          return -1;
        }
        return 0;
      }
    };
  }
  
  public int size()
  {
    return 1;
  }
  
  public ImmutableList<E> subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, 1);
    Object localObject = this;
    if (paramInt1 == paramInt2) {
      localObject = ImmutableList.of();
    }
    return (ImmutableList<E>)localObject;
  }
  
  public Object[] toArray()
  {
    return new Object[] { element };
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    Object localObject;
    if (paramArrayOfT.length == 0) {
      localObject = ObjectArrays.newArray(paramArrayOfT, 1);
    }
    for (;;)
    {
      localObject[0] = element;
      return (T[])localObject;
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > 1)
      {
        paramArrayOfT[1] = null;
        localObject = paramArrayOfT;
      }
    }
  }
  
  public String toString()
  {
    String str = element.toString();
    return str.length() + 2 + '[' + str + ']';
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.SingletonImmutableList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */