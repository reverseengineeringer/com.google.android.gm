import java.util.Iterator;

public abstract class hdz<E>
{
  static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
    int i = (paramInt1 >> 1) + paramInt1 + 1;
    paramInt1 = i;
    if (i < paramInt2) {
      paramInt1 = Integer.highestOneBit(paramInt2 - 1) << 1;
    }
    paramInt2 = paramInt1;
    if (paramInt1 < 0) {
      paramInt2 = Integer.MAX_VALUE;
    }
    return paramInt2;
  }
  
  public hdz<E> a(Iterable<? extends E> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      b(paramIterable.next());
    }
    return this;
  }
  
  public hdz<E> a(Iterator<? extends E> paramIterator)
  {
    while (paramIterator.hasNext()) {
      b(paramIterator.next());
    }
    return this;
  }
  
  public hdz<E> a(E... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      b(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public abstract hdz<E> b(E paramE);
}

/* Location:
 * Qualified Name:     hdz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */