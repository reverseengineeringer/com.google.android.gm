import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;

public final class hjy
{
  private static final OutputStream a = new hjz();
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    hbe.a(paramInputStream);
    hbe.a(paramOutputStream);
    byte[] arrayOfByte = new byte[' '];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    return l;
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    hbe.a(paramInputStream);
    hbe.a(paramArrayOfByte);
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("len is negative");
    }
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(paramArrayOfByte, i + 0, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i != paramInt) {
      throw new EOFException(81 + "reached end of stream after reading " + i + " bytes; " + paramInt + " bytes expected");
    }
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(Math.max(32, paramInputStream.available()));
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}

/* Location:
 * Qualified Name:     hjy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */