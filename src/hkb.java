import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class hkb
  extends FilterInputStream
{
  public long a;
  private long b = -1L;
  
  public hkb(InputStream paramInputStream)
  {
    super((InputStream)hbe.a(paramInputStream));
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      in.mark(paramInt);
      b = a;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int read()
  {
    int i = in.read();
    if (i != -1) {
      a += 1L;
    }
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      a += paramInt1;
    }
    return paramInt1;
  }
  
  public final void reset()
  {
    try
    {
      if (!in.markSupported()) {
        throw new IOException("Mark not supported");
      }
    }
    finally {}
    if (b == -1L) {
      throw new IOException("Mark not set");
    }
    in.reset();
    a = b;
  }
  
  public final long skip(long paramLong)
  {
    paramLong = in.skip(paramLong);
    a += paramLong;
    return paramLong;
  }
}

/* Location:
 * Qualified Name:     hkb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */