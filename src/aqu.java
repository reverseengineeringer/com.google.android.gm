import java.io.InputStream;

public final class aqu
  extends InputStream
{
  public boolean a;
  public int b;
  private final InputStream c;
  
  public aqu(InputStream paramInputStream)
  {
    c = paramInputStream;
  }
  
  public final int read()
  {
    if (!a) {
      return c.read();
    }
    a = false;
    return b;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!a) {
      return c.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    paramArrayOfByte[0] = ((byte)b);
    a = false;
    paramInt1 = c.read(paramArrayOfByte, paramInt1 + 1, paramInt2 - 1);
    if (paramInt1 == -1) {
      return 1;
    }
    return paramInt1 + 1;
  }
  
  public final String toString()
  {
    return String.format("PeekableInputStream(in=%s, peeked=%b, peekedByte=%d)", new Object[] { c.toString(), Boolean.valueOf(a), Integer.valueOf(b) });
  }
}

/* Location:
 * Qualified Name:     aqu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */