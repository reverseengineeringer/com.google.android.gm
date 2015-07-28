package com.google.common.collect;

import java.util.Set;

public abstract class ForwardingSet<E>
  extends ForwardingCollection<E>
  implements Set<E>
{
  protected abstract Set<E> delegate();
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (delegate().equals(paramObject));
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ForwardingSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */