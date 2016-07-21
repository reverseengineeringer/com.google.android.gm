import java.util.Arrays;

final class hlv
{
  final int a;
  final byte[] b;
  
  hlv(int paramInt, byte[] paramArrayOfByte)
  {
    a = paramInt;
    b = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof hlv)) {
        return false;
      }
      paramObject = (hlv)paramObject;
    } while ((a == a) && (Arrays.equals(b, b)));
    return false;
  }
  
  public final int hashCode()
  {
    return (a + 527) * 31 + Arrays.hashCode(b);
  }
}

/* Location:
 * Qualified Name:     hlv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */