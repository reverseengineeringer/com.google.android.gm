public final class ikt
{
  int a = 0;
  private byte[] b = new byte[32];
  private int c = -1;
  
  private ikt() {}
  
  public ikt(byte paramByte)
  {
    this();
  }
  
  private static void a(long paramLong, int paramInt)
  {
    if ((paramLong < 0L) || (paramLong > 1L << paramInt)) {
      throw new IllegalArgumentException(59 + paramLong + " out of range for " + paramInt + " bit value");
    }
  }
  
  private final void c(int paramInt)
  {
    if (b.length - a >= paramInt) {
      return;
    }
    int j = b.length * 2;
    int i = j;
    if (j < a + paramInt) {
      i = a + paramInt;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(b, 0, arrayOfByte, 0, a);
    b = arrayOfByte;
  }
  
  public final void a(int paramInt)
  {
    a(paramInt, 8);
    c(1);
    byte[] arrayOfByte = b;
    int i = a;
    a = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, 16);
    if (paramInt2 > a - 2) {
      throw new IllegalArgumentException("cannot write past end of data");
    }
    b[paramInt2] = ((byte)(paramInt1 >>> 8 & 0xFF));
    b[(paramInt2 + 1)] = ((byte)(paramInt1 & 0xFF));
  }
  
  public final void a(long paramLong)
  {
    a(paramLong, 32);
    c(4);
    byte[] arrayOfByte = b;
    int i = a;
    a = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    arrayOfByte = b;
    i = a;
    a = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    arrayOfByte = b;
    i = a;
    a = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte = b;
    i = a;
    a = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, b, a, paramInt2);
    a += paramInt2;
  }
  
  public final byte[] a()
  {
    byte[] arrayOfByte = new byte[a];
    System.arraycopy(b, 0, arrayOfByte, 0, a);
    return arrayOfByte;
  }
  
  public final void b(int paramInt)
  {
    a(paramInt, 16);
    c(2);
    byte[] arrayOfByte = b;
    int i = a;
    a = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte = b;
    i = a;
    a = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 255) {
      throw new IllegalArgumentException("Invalid counted string");
    }
    c(paramArrayOfByte.length + 1);
    byte[] arrayOfByte = b;
    int i = a;
    a = (i + 1);
    arrayOfByte[i] = ((byte)(paramArrayOfByte.length & 0xFF));
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}

/* Location:
 * Qualified Name:     ikt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */