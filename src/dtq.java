import java.util.Arrays;

public final class dtq
{
  public final long a;
  public final long b;
  
  public dtq(long paramLong1, long paramLong2)
  {
    a = paramLong1;
    b = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (dtq)paramObject;
      if (a != a) {
        return false;
      }
    } while (b == b);
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(a), Long.valueOf(b) });
  }
  
  public final String toString()
  {
    long l1 = a;
    long l2 = b;
    return 74 + "[ConversationInfo id: " + l1 + ", highest: " + l2 + "]";
  }
}

/* Location:
 * Qualified Name:     dtq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */