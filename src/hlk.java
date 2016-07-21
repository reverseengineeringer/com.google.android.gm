public final class hlk
{
  final byte[] a;
  int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g = Integer.MAX_VALUE;
  private int h;
  private int i = 64;
  private int j = 67108864;
  
  hlk(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a = paramArrayOfByte;
    b = 0;
    c = (paramInt2 + 0);
    e = 0;
  }
  
  private final void f(int paramInt)
  {
    if (paramInt < 0) {
      throw hls.b();
    }
    if (e + paramInt > g)
    {
      f(g - e);
      throw hls.a();
    }
    if (paramInt <= c - e)
    {
      e += paramInt;
      return;
    }
    throw hls.a();
  }
  
  private final void l()
  {
    c += d;
    int k = c;
    if (k > g)
    {
      d = (k - g);
      c -= d;
      return;
    }
    d = 0;
  }
  
  public final int a()
  {
    if (e == c) {}
    for (int k = 1; k != 0; k = 0)
    {
      f = 0;
      return 0;
    }
    f = f();
    if (f == 0) {
      throw new hls("Protocol message contained an invalid tag (zero).");
    }
    return f;
  }
  
  public final void a(int paramInt)
  {
    if (f != paramInt) {
      throw new hls("Protocol message end-group tag did not match expected tag.");
    }
  }
  
  public final void a(hlt paramhlt)
  {
    int k = f();
    if (h >= i) {
      throw hls.d();
    }
    k = c(k);
    h += 1;
    paramhlt.a(this);
    a(0);
    h -= 1;
    d(k);
  }
  
  public final void a(hlt paramhlt, int paramInt)
  {
    if (h >= i) {
      throw hls.d();
    }
    h += 1;
    paramhlt.a(this);
    a(paramInt << 3 | 0x4);
    h -= 1;
  }
  
  public final long b()
  {
    int k = 0;
    long l = 0L;
    while (k < 64)
    {
      int m = k();
      l |= (m & 0x7F) << k;
      if ((m & 0x80) == 0) {
        return l;
      }
      k += 7;
    }
    throw hls.c();
  }
  
  public final boolean b(int paramInt)
  {
    switch (paramInt & 0x7)
    {
    default: 
      throw new hls("Protocol message tag had invalid wire type.");
    case 0: 
      f();
      return true;
    case 1: 
      h();
      return true;
    case 2: 
      f(f());
      return true;
    case 3: 
      int k;
      do
      {
        k = a();
      } while ((k != 0) && (b(k)));
      a(paramInt >>> 3 << 3 | 0x4);
      return true;
    case 4: 
      return false;
    }
    g();
    return true;
  }
  
  public final int c(int paramInt)
  {
    if (paramInt < 0) {
      throw hls.b();
    }
    paramInt = e + paramInt;
    int k = g;
    if (paramInt > k) {
      throw hls.a();
    }
    g = paramInt;
    l();
    return k;
  }
  
  public final boolean c()
  {
    return f() != 0;
  }
  
  public final String d()
  {
    int k = f();
    if (k < 0) {
      throw hls.b();
    }
    if (k > c - e) {
      throw hls.a();
    }
    String str = new String(a, e, k, hlr.a);
    e = (k + e);
    return str;
  }
  
  public final void d(int paramInt)
  {
    g = paramInt;
    l();
  }
  
  public final void e(int paramInt)
  {
    if (paramInt > e - b)
    {
      int k = e;
      int m = b;
      throw new IllegalArgumentException(50 + "Position " + paramInt + " is beyond current " + (k - m));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException(24 + "Bad position " + paramInt);
    }
    e = (b + paramInt);
  }
  
  public final byte[] e()
  {
    int k = f();
    if (k < 0) {
      throw hls.b();
    }
    if (k == 0) {
      return hlw.h;
    }
    if (k > c - e) {
      throw hls.a();
    }
    byte[] arrayOfByte = new byte[k];
    System.arraycopy(a, e, arrayOfByte, 0, k);
    e = (k + e);
    return arrayOfByte;
  }
  
  public final int f()
  {
    int k = k();
    if (k >= 0) {}
    int n;
    do
    {
      return k;
      k &= 0x7F;
      m = k();
      if (m >= 0) {
        return k | m << 7;
      }
      k |= (m & 0x7F) << 7;
      m = k();
      if (m >= 0) {
        return k | m << 14;
      }
      k |= (m & 0x7F) << 14;
      n = k();
      if (n >= 0) {
        return k | n << 21;
      }
      m = k();
      n = k | (n & 0x7F) << 21 | m << 28;
      k = n;
    } while (m >= 0);
    int m = 0;
    for (;;)
    {
      if (m >= 5) {
        break label133;
      }
      k = n;
      if (k() >= 0) {
        break;
      }
      m += 1;
    }
    label133:
    throw hls.c();
  }
  
  public final int g()
  {
    return k() & 0xFF | (k() & 0xFF) << 8 | (k() & 0xFF) << 16 | (k() & 0xFF) << 24;
  }
  
  public final long h()
  {
    int k = k();
    int m = k();
    int n = k();
    int i1 = k();
    int i2 = k();
    int i3 = k();
    int i4 = k();
    int i5 = k();
    long l = k;
    return (m & 0xFF) << 8 | l & 0xFF | (n & 0xFF) << 16 | (i1 & 0xFF) << 24 | (i2 & 0xFF) << 32 | (i3 & 0xFF) << 40 | (i4 & 0xFF) << 48 | (i5 & 0xFF) << 56;
  }
  
  public final int i()
  {
    if (g == Integer.MAX_VALUE) {
      return -1;
    }
    int k = e;
    return g - k;
  }
  
  public final int j()
  {
    return e - b;
  }
  
  public final byte k()
  {
    if (e == c) {
      throw hls.a();
    }
    byte[] arrayOfByte = a;
    int k = e;
    e = (k + 1);
    return arrayOfByte[k];
  }
}

/* Location:
 * Qualified Name:     hlk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */