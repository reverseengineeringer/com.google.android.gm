package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class NaturalOrdering
  extends Ordering<Comparable>
  implements Serializable
{
  static final NaturalOrdering INSTANCE = new NaturalOrdering();
  private static final long serialVersionUID = 0L;
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public int compare(Comparable paramComparable1, Comparable paramComparable2)
  {
    Preconditions.checkNotNull(paramComparable1);
    Preconditions.checkNotNull(paramComparable2);
    if (paramComparable1 == paramComparable2) {
      return 0;
    }
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public String toString()
  {
    return "Ordering.natural()";
  }
}

/* Location:
 * Qualified Name:     com.google.common.collect.NaturalOrdering
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */