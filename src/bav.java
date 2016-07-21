import java.util.Arrays;

final class bav
{
  final bdg a;
  final long b;
  
  bav(bdg parambdg, long paramLong)
  {
    a = parambdg;
    b = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof bav))
    {
      paramObject = (bav)paramObject;
      bool1 = bool2;
      if (b == b)
      {
        bool1 = bool2;
        if (hbc.a(a, a)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(b), a });
  }
  
  public final String toString()
  {
    String str = String.valueOf(super.toString());
    long l = b;
    return String.valueOf(str).length() + 25 + str + " uid=" + l;
  }
}

/* Location:
 * Qualified Name:     bav
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */