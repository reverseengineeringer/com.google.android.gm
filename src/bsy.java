final class bsy
{
  int a;
  int b;
  int c;
  int d;
  int e;
  
  bsy(int paramInt1, int paramInt2)
  {
    a = 2;
    d = paramInt1;
    e = paramInt2;
  }
  
  bsy(int paramInt1, int paramInt2, int paramInt3)
  {
    a = 1;
    d = paramInt1;
    b = paramInt2;
    c = paramInt3;
  }
  
  public final String toString()
  {
    if (a == 1)
    {
      i = d;
      j = c;
      String str = String.valueOf(bsx.c[(b - 1)]);
      return String.valueOf(str).length() + 49 + "FREQ=YEARLY;BYMONTH=" + i + ";BYDAY=" + j + str;
    }
    int i = d;
    int j = e;
    return 54 + "FREQ=YEARLY;BYMONTH=" + i + ";BYMONTHDAY=" + j;
  }
}

/* Location:
 * Qualified Name:     bsy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */