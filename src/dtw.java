import java.io.ByteArrayInputStream;
import java.io.InputStream;

final class dtw
  implements dds
{
  long a;
  InputStream b;
  private final String d;
  private final byte[] e;
  
  public dtw(dtn paramdtn, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    d = paramString;
    e = paramArrayOfByte;
    a = paramLong;
    b = d();
  }
  
  private final InputStream d()
  {
    return new ByteArrayInputStream(e);
  }
  
  public final long a()
  {
    return a;
  }
  
  public final String b()
  {
    return d;
  }
  
  public final InputStream c()
  {
    if (b != null)
    {
      InputStream localInputStream = b;
      b = null;
      return localInputStream;
    }
    return d();
  }
}

/* Location:
 * Qualified Name:     dtw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */