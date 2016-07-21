import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

public final class dvg
{
  static ByteArrayOutputStream a(Inflater paramInflater)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    int i;
    do
    {
      i = paramInflater.inflate(arrayOfByte);
      if (i != 0) {
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
    } while (i != 0);
    return localByteArrayOutputStream;
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    Inflater localInflater = new Inflater();
    try
    {
      localInflater.setInput(paramArrayOfByte, 1, paramInt);
      paramArrayOfByte = b(localInflater);
      return paramArrayOfByte;
    }
    finally
    {
      localInflater.end();
    }
  }
  
  private static String b(Inflater paramInflater)
  {
    return a(paramInflater).toString("UTF-8");
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream, new Deflater());
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte, 0, paramInt);
      localDeflaterOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramArrayOfByte)
    {
      throw new IllegalStateException("ByteArrayOutputStream threw ", paramArrayOfByte);
    }
  }
}

/* Location:
 * Qualified Name:     dvg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */