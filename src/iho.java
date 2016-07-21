final class iho
{
  final int[] a;
  
  iho(int[] paramArrayOfInt)
  {
    a = paramArrayOfInt;
  }
  
  final int a(int paramInt)
  {
    int j = a.length;
    int i = 0;
    j >>= 1;
    while (i < j)
    {
      int k = (j - i >> 1) + i;
      int m = a[(k << 1)];
      if (m == paramInt) {
        return k;
      }
      if (m < paramInt) {
        i = k + 1;
      } else {
        j = k;
      }
    }
    return -1;
  }
}

/* Location:
 * Qualified Name:     iho
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */