package com.google.common.collect;

import java.io.Serializable;

class ImmutableAsList$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final ImmutableCollection<?> collection;
  
  ImmutableAsList$SerializedForm(ImmutableCollection<?> paramImmutableCollection)
  {
    collection = paramImmutableCollection;
  }
  
  Object readResolve()
  {
    return collection.asList();
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableAsList.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */