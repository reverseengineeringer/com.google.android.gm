package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

final class ImmutableAsList<E>
  extends RegularImmutableList<E>
{
  private final transient ImmutableCollection<E> collection;
  
  ImmutableAsList(Object[] paramArrayOfObject, ImmutableCollection<E> paramImmutableCollection)
  {
    super(paramArrayOfObject, 0, paramArrayOfObject.length);
    collection = paramImmutableCollection;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  public boolean contains(Object paramObject)
  {
    return collection.contains(paramObject);
  }
  
  Object writeReplace()
  {
    return new SerializedForm(collection);
  }
  
  static class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableCollection<?> collection;
    
    SerializedForm(ImmutableCollection<?> paramImmutableCollection)
    {
      collection = paramImmutableCollection;
    }
    
    Object readResolve()
    {
      return collection.asList();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */