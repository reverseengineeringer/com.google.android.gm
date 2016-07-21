import java.io.UnsupportedEncodingException;

public final class eck
{
  int a = 0;
  int b = 0;
  final int[] c;
  final byte[] d;
  
  public eck(int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    c = paramArrayOfInt;
    d = paramArrayOfByte;
  }
  
  public final String a(int paramInt)
  {
    if (paramInt < a)
    {
      a = 0;
      b = 0;
    }
    while (a < paramInt)
    {
      b += c[a];
      a += 1;
    }
    try
    {
      String str = new String(d, b, c[a], "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     eck
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */