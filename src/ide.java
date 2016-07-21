import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ide
  extends FilterInputStream
{
  public ide(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  protected void a(int paramInt) {}
  
  public int available()
  {
    try
    {
      int i = super.available();
      return i;
    }
    catch (IOException localIOException)
    {
      throw localIOException;
    }
  }
  
  public void close()
  {
    try
    {
      in.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw localIOException;
    }
  }
  
  public void mark(int paramInt)
  {
    try
    {
      in.mark(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean markSupported()
  {
    return in.markSupported();
  }
  
  public int read()
  {
    int i = -1;
    try
    {
      int j = in.read();
      if (j != -1) {
        i = 1;
      }
      a(i);
      return j;
    }
    catch (IOException localIOException)
    {
      throw localIOException;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    try
    {
      int i = in.read(paramArrayOfByte);
      a(i);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = in.read(paramArrayOfByte, paramInt1, paramInt2);
      a(paramInt1);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public void reset()
  {
    try
    {
      in.reset();
      return;
    }
    catch (IOException localIOException)
    {
      throw localIOException;
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    try
    {
      paramLong = in.skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      throw localIOException;
    }
  }
}

/* Location:
 * Qualified Name:     ide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */