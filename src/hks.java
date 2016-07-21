import java.util.Collection;

public final class hks
{
  public static int a(long paramLong)
  {
    if (paramLong > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    if (paramLong < -2147483648L) {
      return Integer.MIN_VALUE;
    }
    return (int)paramLong;
  }
  
  public static int[] a(Collection<? extends Number> paramCollection)
  {
    int i = 0;
    if ((paramCollection instanceof hkt))
    {
      paramCollection = (hkt)paramCollection;
      i = paramCollection.size();
      arrayOfInt = new int[i];
      System.arraycopy(a, b, arrayOfInt, 0, i);
      return arrayOfInt;
    }
    paramCollection = paramCollection.toArray();
    int j = paramCollection.length;
    int[] arrayOfInt = new int[j];
    while (i < j)
    {
      arrayOfInt[i] = ((Number)hbe.a(paramCollection[i])).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static int[] a(int[]... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    int[] arrayOfInt1 = new int[j];
    k = paramVarArgs.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      int[] arrayOfInt2 = paramVarArgs[i];
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, j, arrayOfInt2.length);
      j += arrayOfInt2.length;
      i += 1;
    }
    return arrayOfInt1;
  }
}

/* Location:
 * Qualified Name:     hks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */