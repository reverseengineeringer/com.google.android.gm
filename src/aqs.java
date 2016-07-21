import java.io.InputStream;

public final class aqs
  extends InputStream
{
  public final int a;
  public int b;
  private final InputStream c;
  
  public aqs(InputStream paramInputStream, int paramInt)
  {
    c = paramInputStream;
    a = paramInt;
  }
  
  public final int available()
  {
    return a - b;
  }
  
  public final int read()
  {
    if (b < a)
    {
      b += 1;
      return c.read();
    }
    return -1;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (b < a)
    {
      paramInt1 = c.read(paramArrayOfByte, paramInt1, Math.min(a - b, paramInt2));
      if (paramInt1 != -1) {}
    }
    else
    {
      return -1;
    }
    b += paramInt1;
    return paramInt1;
  }
  
  public final String toString()
  {
    return String.format("FixedLengthInputStream(in=%s, length=%d)", new Object[] { c.toString(), Integer.valueOf(a) });
  }
}

/* Location:
 * Qualified Name:     aqs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */