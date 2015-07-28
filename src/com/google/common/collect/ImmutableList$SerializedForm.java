package com.google.common.collect;

import java.io.Serializable;

class ImmutableList$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Object[] elements;
  
  ImmutableList$SerializedForm(Object[] paramArrayOfObject)
  {
    elements = paramArrayOfObject;
  }
  
  Object readResolve()
  {
    return ImmutableList.copyOf(elements);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableList.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */