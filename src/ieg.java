public final class ieg
{
  iej a = new iej();
  private int b = -1;
  
  public final byte a()
  {
    iej localiej = a;
    if (localiej.a() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw new IllegalStateException("The buffer is already empty");
    }
    byte b1 = a[b];
    b += 1;
    if (b >= a.length) {
      b = 0;
    }
    return b1;
  }
  
  public final void a(byte paramByte)
  {
    iej localiej = a;
    if (localiej.a() + 1 >= a.length)
    {
      byte[] arrayOfByte = new byte[(a.length - 1) * 2 + 1];
      int i = b;
      int j = 0;
      while (i != c)
      {
        arrayOfByte[j] = a[i];
        a[i] = 0;
        int k = j + 1;
        int m = i + 1;
        i = m;
        j = k;
        if (m == a.length)
        {
          i = 0;
          j = k;
        }
      }
      a = arrayOfByte;
      b = 0;
      c = j;
    }
    a[c] = paramByte;
    c += 1;
    if (c >= a.length) {
      c = 0;
    }
  }
  
  public final void b()
  {
    if (b != -1)
    {
      a = new iej(b);
      return;
    }
    a = new iej();
  }
}

/* Location:
 * Qualified Name:     ieg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */