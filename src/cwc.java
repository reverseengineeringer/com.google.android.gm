import java.util.Arrays;

final class cwc
{
  public long a;
  public String b;
  
  public cwc(long paramLong, String paramString)
  {
    a = paramLong;
    b = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof cwc))
    {
      paramObject = (cwc)paramObject;
      bool1 = bool2;
      if (a == a)
      {
        bool1 = bool2;
        if (b.equals(b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(a), b });
  }
}

/* Location:
 * Qualified Name:     cwc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */