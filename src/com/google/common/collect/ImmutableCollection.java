package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;

public abstract class ImmutableCollection<E>
  implements Collection<E>, Serializable
{
  static final ImmutableCollection<Object> EMPTY_IMMUTABLE_COLLECTION = new EmptyImmutableCollection(null);
  private transient ImmutableList<E> asList;
  
  public final boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> asList()
  {
    ImmutableList localImmutableList2 = asList;
    ImmutableList localImmutableList1 = localImmutableList2;
    if (localImmutableList2 == null)
    {
      localImmutableList1 = createAsList();
      asList = localImmutableList1;
    }
    return localImmutableList1;
  }
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean contains(Object paramObject)
  {
    return (paramObject != null) && (Iterators.contains(iterator(), paramObject));
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return Collections2.containsAllImpl(this, paramCollection);
  }
  
  ImmutableList<E> createAsList()
  {
    switch (size())
    {
    default: 
      return new ImmutableAsList(toArray(), this);
    case 0: 
      return ImmutableList.of();
    }
    return ImmutableList.of(iterator().next());
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  abstract boolean isPartialView();
  
  public abstract UnmodifiableIterator<E> iterator();
  
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object[] toArray()
  {
    return ObjectArrays.toArrayImpl(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return ObjectArrays.toArrayImpl(this, paramArrayOfT);
  }
  
  public String toString()
  {
    return Collections2.toStringImpl(this);
  }
  
  Object writeReplace()
  {
    return new SerializedForm(toArray());
  }
  
  private static class ArrayImmutableCollection<E>
    extends ImmutableCollection<E>
  {
    private final E[] elements;
    
    ArrayImmutableCollection(E[] paramArrayOfE)
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
  
  public static abstract class Builder<E>
  {
    public abstract Builder<E> add(E paramE);
    
    public Builder<E> add(E... paramVarArgs)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        add(paramVarArgs[i]);
        i += 1;
      }
      return this;
    }
  }
  
  private static class EmptyImmutableCollection
    extends ImmutableCollection<Object>
  {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    
    public boolean contains(Object paramObject)
    {
      return false;
    }
    
    ImmutableList<Object> createAsList()
    {
      return ImmutableList.of();
    }
    
    public boolean isEmpty()
    {
      return true;
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    public UnmodifiableIterator<Object> iterator()
    {
      return Iterators.EMPTY_ITERATOR;
    }
    
    public int size()
    {
      return 0;
    }
    
    public Object[] toArray()
    {
      return EMPTY_ARRAY;
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      if (paramArrayOfT.length > 0) {
        paramArrayOfT[0] = null;
      }
      return paramArrayOfT;
    }
  }
  
  private static class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Object[] elements;
    
    SerializedForm(Object[] paramArrayOfObject)
    {
      elements = paramArrayOfObject;
    }
    
    Object readResolve()
    {
      if (elements.length == 0) {
        return ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION;
      }
      return new ImmutableCollection.ArrayImmutableCollection(Platform.clone(elements));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */