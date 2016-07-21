import java.io.ByteArrayOutputStream;
import java.util.zip.Adler32;

public final class dpw
{
  final ByteArrayOutputStream a = new ByteArrayOutputStream();
  final Adler32 b = new Adler32();
  
  public final void a(byte[] paramArrayOfByte)
  {
    a.write(paramArrayOfByte, 0, paramArrayOfByte.length);
    b.update(paramArrayOfByte);
  }
}

/* Location:
 * Qualified Name:     dpw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */