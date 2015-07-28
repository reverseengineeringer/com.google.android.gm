package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

class RegularImmutableList<E>
  extends ImmutableList<E>
{
  private final transient Object[] array;
  private final transient int offset;
  private final transient int size;
  
  RegularImmutableList(Object[] paramArrayOfObject)
  {
    this(paramArrayOfObject, 0, paramArrayOfObject.length);
  }
  
  RegularImmutableList(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    offset = paramInt1;
    size = paramInt2;
    array = paramArrayOfObject;
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) != -1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof List)) {
        return false;
      }
      Object localObject = (List)paramObject;
      if (size() != ((List)localObject).size()) {
        return false;
      }
      int i = offset;
      if ((paramObject instanceof RegularImmutableList))
      {
        paramObject = (RegularImmutableList)paramObject;
        int j = offset;
        while (j < offset + size)
        {
          if (!array[i].equals(array[j])) {
            return false;
          }
          j += 1;
          i += 1;
        }
      }
      else
      {
        paramObject = ((List)localObject).iterator();
        while (((Iterator)paramObject).hasNext())
        {
          localObject = ((Iterator)paramObject).next();
          if (!array[i].equals(localObject)) {
            return false;
          }
          i += 1;
        }
      }
    }
  }
  
  public E get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, size);
    return (E)array[(offset + paramInt)];
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = offset;
    while (i < offset + size)
    {
      j = j * 31 + array[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public int indexOf(Object paramObject)
  {
    if (paramObject != null)
    {
      int i = offset;
      while (i < offset + size)
      {
        if (array[i].equals(paramObject)) {
          return i - offset;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  boolean isPartialView()
  {
    return (offset != 0) || (size != array.length);
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.forArray(array, offset, size);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    if (paramObject != null)
    {
      int i = offset + size - 1;
      while (i >= offset)
      {
        if (array[i].equals(paramObject)) {
          return i - offset;
        }
        i -= 1;
      }
    }
    return -1;
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt)
  {
    new AbstractIndexedListIterator(size, paramInt)
    {
      protected E get(int paramAnonymousInt)
      {
        return (E)array[(offset + paramAnonymousInt)];
      }
    };
  }
  
  public int size()
  {
    return size;
  }
  
  public ImmutableList<E> subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, size);
    if (paramInt1 == paramInt2) {
      return ImmutableList.of();
    }
    return new RegularImmutableList(array, offset + paramInt1, paramInt2 - paramInt1);
  }
  
  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[size()];
    System.arraycopy(array, offset, arrayOfObject, 0, size);
    return arrayOfObject;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    Object localObject;
    if (paramArrayOfT.length < size) {
      localObject = ObjectArrays.newArray(paramArrayOfT, size);
    }
    for (;;)
    {
      System.arraycopy(array, offset, localObject, 0, size);
      return (T[])localObject;
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > size)
      {
        paramArrayOfT[size] = null;
        localObject = paramArrayOfT;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = Collections2.newStringBuilderForCollection(size()).append('[').append(array[offset]);
    int i = offset + 1;
    while (i < offset + size)
    {
      localStringBuilder.append(", ").append(array[i]);
      i += 1;
    }
    return ']';
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.RegularImmutableList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */