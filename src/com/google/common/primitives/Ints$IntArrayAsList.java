package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

class Ints$IntArrayAsList
  extends AbstractList<Integer>
  implements RandomAccess, Serializable
{
  private static final long serialVersionUID = 0L;
  final int[] array;
  final int end;
  final int start;
  
  Ints$IntArrayAsList(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    array = paramArrayOfInt;
    start = paramInt1;
    end = paramInt2;
  }
  
  public boolean contains(Object paramObject)
  {
    return ((paramObject instanceof Integer)) && (Ints.access$000(array, ((Integer)paramObject).intValue(), start, end) != -1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof IntArrayAsList)) {
        break;
      }
      paramObject = (IntArrayAsList)paramObject;
      int j = size();
      if (((IntArrayAsList)paramObject).size() != j) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        if (array[(start + i)] != array[(start + i)]) {
          return false;
        }
        i += 1;
      }
    }
    return super.equals(paramObject);
  }
  
  public Integer get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, size());
    return Integer.valueOf(array[(start + paramInt)]);
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = start;
    while (i < end)
    {
      j = j * 31 + Ints.hashCode(array[i]);
      i += 1;
    }
    return j;
  }
  
  public int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      int i = Ints.access$000(array, ((Integer)paramObject).intValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      int i = Ints.access$100(array, ((Integer)paramObject).intValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public Integer set(int paramInt, Integer paramInteger)
  {
    Preconditions.checkElementIndex(paramInt, size());
    int i = array[(start + paramInt)];
    array[(start + paramInt)] = ((Integer)Preconditions.checkNotNull(paramInteger)).intValue();
    return Integer.valueOf(i);
  }
  
  public int size()
  {
    return end - start;
  }
  
  public List<Integer> subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
    if (paramInt1 == paramInt2) {
      return Collections.emptyList();
    }
    return new IntArrayAsList(array, start + paramInt1, start + paramInt2);
  }
  
  int[] toIntArray()
  {
    int i = size();
    int[] arrayOfInt = new int[i];
    System.arraycopy(array, start, arrayOfInt, 0, i);
    return arrayOfInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(size() * 5);
    localStringBuilder.append('[').append(array[start]);
    int i = start + 1;
    while (i < end)
    {
      localStringBuilder.append(", ").append(array[i]);
      i += 1;
    }
    return ']';
  }
}

/* Location:
 * Qualified Name:     com.google.common.primitives.Ints.IntArrayAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */