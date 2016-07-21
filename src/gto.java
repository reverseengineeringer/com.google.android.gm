import java.io.InputStream;

public final class gto
{
  public static int a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    hbe.a(paramInputStream);
    hbe.a(paramArrayOfByte);
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException("len is negative");
    }
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     gto
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */