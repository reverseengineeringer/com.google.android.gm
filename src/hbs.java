final class hbs
  extends hbu
{
  hbs(hbr paramhbr, hbo paramhbo, CharSequence paramCharSequence)
  {
    super(paramhbo, paramCharSequence);
  }
  
  public final int a(int paramInt)
  {
    int k = b.a.length();
    int m = c.length();
    while (paramInt <= m - k)
    {
      int i = 0;
      for (;;)
      {
        j = paramInt;
        if (i >= k) {
          return j;
        }
        if (c.charAt(i + paramInt) != b.a.charAt(i)) {
          break;
        }
        i += 1;
      }
      paramInt += 1;
    }
    int j = -1;
    return j;
  }
  
  public final int b(int paramInt)
  {
    return b.a.length() + paramInt;
  }
}

/* Location:
 * Qualified Name:     hbs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */