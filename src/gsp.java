import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

final class gsp
  extends FilterInputStream
{
  private long b = 0L;
  
  public gsp(gso paramgso, InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private final void a()
  {
    String str = a.a.getHeaderField("Content-Length");
    long l1;
    if (str == null)
    {
      l1 = -1L;
      if (l1 != -1L) {
        break label41;
      }
    }
    label41:
    while ((b == 0L) || (b >= l1))
    {
      return;
      l1 = Long.parseLong(str);
      break;
    }
    long l2 = b;
    throw new IOException(102 + "Connection closed prematurely: bytesRead = " + l2 + ", Content-Length = " + l1);
  }
  
  public final int read()
  {
    int i = in.read();
    if (i == -1)
    {
      a();
      return i;
    }
    b += 1L;
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 == -1)
    {
      a();
      return paramInt1;
    }
    b += paramInt1;
    return paramInt1;
  }
}

/* Location:
 * Qualified Name:     gsp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */