package com.google.common.collect;

public abstract class ImmutableCollection$Builder<E>
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

/* Location:
 * Qualified Name:     com.google.common.collect.ImmutableCollection.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */