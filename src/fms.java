import java.util.Arrays;

final class fms
{
  final int a;
  final byte[] b;
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof fms)) {
        return false;
      }
      paramObject = (fms)paramObject;
    } while ((a == a) && (Arrays.equals(b, b)));
    return false;
  }
  
  public final int hashCode()
  {
    return (a + 527) * 31 + Arrays.hashCode(b);
  }
}

/* Location:
 * Qualified Name:     fms
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */