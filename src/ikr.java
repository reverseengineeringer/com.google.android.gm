public final class ikr
{
  byte[] a;
  int b;
  int c;
  int d;
  int e;
  
  public ikr(byte[] paramArrayOfByte)
  {
    a = paramArrayOfByte;
    b = 0;
    c = a.length;
    d = -1;
    e = -1;
  }
  
  private final void c(int paramInt)
  {
    if (paramInt > a()) {
      throw new iog("end of input");
    }
  }
  
  public final int a()
  {
    return c - b;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > a.length - b) {
      throw new IllegalArgumentException("cannot set active region past end of input");
    }
    c = (b + paramInt);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c(paramInt2);
    System.arraycopy(a, b, paramArrayOfByte, paramInt1, paramInt2);
    b += paramInt2;
  }
  
  public final int b()
  {
    c(1);
    byte[] arrayOfByte = a;
    int i = b;
    b = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public final byte[] b(int paramInt)
  {
    c(paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(a, b, arrayOfByte, 0, paramInt);
    b += paramInt;
    return arrayOfByte;
  }
  
  public final int c()
  {
    c(2);
    byte[] arrayOfByte = a;
    int i = b;
    b = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = a;
    int j = b;
    b = (j + 1);
    return ((i & 0xFF) << 8) + (arrayOfByte[j] & 0xFF);
  }
  
  public final long d()
  {
    c(4);
    byte[] arrayOfByte = a;
    int i = b;
    b = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = a;
    int j = b;
    b = (j + 1);
    j = arrayOfByte[j];
    arrayOfByte = a;
    int k = b;
    b = (k + 1);
    k = arrayOfByte[k];
    arrayOfByte = a;
    int m = b;
    b = (m + 1);
    m = arrayOfByte[m];
    long l = i & 0xFF;
    return ((j & 0xFF) << 16) + (l << 24) + ((k & 0xFF) << 8) + (m & 0xFF);
  }
  
  public final byte[] e()
  {
    int i = a();
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(a, b, arrayOfByte, 0, i);
    b = (i + b);
    return arrayOfByte;
  }
  
  public final byte[] f()
  {
    c(1);
    byte[] arrayOfByte = a;
    int i = b;
    b = (i + 1);
    return b(arrayOfByte[i] & 0xFF);
  }
}

/* Location:
 * Qualified Name:     ikr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */