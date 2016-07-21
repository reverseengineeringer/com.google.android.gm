import java.io.ByteArrayOutputStream;

public final class ioo
{
  public static String a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = (short)(paramArrayOfByte[i] & 0xFF);
      int j = (byte)(k >> 4);
      k = (byte)(k & 0xF);
      localByteArrayOutputStream.write("0123456789ABCDEF".charAt(j));
      localByteArrayOutputStream.write("0123456789ABCDEF".charAt(k));
      i += 1;
    }
    return new String(localByteArrayOutputStream.toByteArray());
  }
}

/* Location:
 * Qualified Name:     ioo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */