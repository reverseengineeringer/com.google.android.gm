import java.io.IOException;
import java.io.InputStream;

public final class idu
  extends InputStream
{
  private InputStream a;
  
  public idu(InputStream paramInputStream)
  {
    a = paramInputStream;
  }
  
  private final void a()
  {
    if (a == null) {
      throw new IOException("Stream is closed");
    }
  }
  
  public final int available()
  {
    a();
    return a.available();
  }
  
  public final void close()
  {
    a = null;
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      if (a != null) {
        a.mark(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean markSupported()
  {
    if (a == null) {
      return false;
    }
    return a.markSupported();
  }
  
  public final int read()
  {
    a();
    return a.read();
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    a();
    return a.read(paramArrayOfByte);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a();
    return a.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final void reset()
  {
    try
    {
      a();
      a.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long skip(long paramLong)
  {
    a();
    return a.skip(paramLong);
  }
}

/* Location:
 * Qualified Name:     idu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */