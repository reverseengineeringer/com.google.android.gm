import java.util.Arrays;

public final class fnk
{
  public final int a;
  public final int b;
  
  public fnk(int paramInt1, int paramInt2)
  {
    a = paramInt1;
    b = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof fnk)) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
      paramObject = (fnk)paramObject;
    } while ((a != a) || (b != b));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(a), Integer.valueOf(b) });
  }
}

/* Location:
 * Qualified Name:     fnk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */