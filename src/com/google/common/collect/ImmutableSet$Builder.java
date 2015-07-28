package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;

public class ImmutableSet$Builder<E>
  extends ImmutableCollection.Builder<E>
{
  final ArrayList<E> contents = Lists.newArrayList();
  
  public Builder<E> add(E paramE)
  {
    contents.add(Preconditions.checkNotNull(paramE));
    return this;
  }
  
  public Builder<E> add(E... paramVarArgs)
  {
    contents.ensureCapacity(contents.size() + paramVarArgs.length);
    super.add(paramVarArgs);
    return this;
  }
  
  public ImmutableSet<E> build()
  {
    return ImmutableSet.copyOf(contents);
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableSet.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */