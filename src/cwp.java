public final class cwp
  implements Cloneable
{
  public int[] a = new int[10];
  public long[] b = new long[10];
  public int c = 0;
  
  public cwp()
  {
    this((byte)0);
  }
  
  private cwp(byte paramByte) {}
  
  public static int a(int[] paramArrayOfInt, int paramInt, long paramLong)
  {
    int j = -1;
    int i = paramInt + 0;
    while (i - j > 1)
    {
      int k = (i + j) / 2;
      if (paramArrayOfInt[k] < paramLong) {
        j = k;
      } else {
        i = k;
      }
    }
    if (i == paramInt + 0) {
      paramInt = paramInt + 0 ^ 0xFFFFFFFF;
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (paramArrayOfInt[i] == paramLong);
    return i ^ 0xFFFFFFFF;
  }
  
  private final cwp a()
  {
    try
    {
      cwp localcwp = (cwp)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        a = ((int[])a.clone());
        b = ((long[])b.clone());
        return localcwp;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public final void a(int paramInt)
  {
    paramInt = a(a, c, paramInt);
    if (paramInt >= 0)
    {
      System.arraycopy(a, paramInt + 1, a, paramInt, c - (paramInt + 1));
      System.arraycopy(b, paramInt + 1, b, paramInt, c - (paramInt + 1));
      c -= 1;
    }
  }
}

/* Location:
 * Qualified Name:     cwp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */