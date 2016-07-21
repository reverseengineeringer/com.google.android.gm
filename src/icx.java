public abstract class icx
  implements icr, ics
{
  private final int a = 3;
  @Deprecated
  public final byte b = 61;
  public final byte c;
  public final int d;
  private final int e = 4;
  private final int f;
  
  protected icx(int paramInt1, int paramInt2)
  {
    this(3, 4, paramInt1, paramInt2);
  }
  
  private icx(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 > 0) && (paramInt4 > 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        paramInt2 = paramInt3 / 4 * 4;
      }
      d = paramInt2;
      f = paramInt4;
      c = 61;
      return;
    }
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt, icy paramicy)
  {
    int i = 0;
    if (c != null) {
      if (c != null)
      {
        i = d - e;
        paramInt = Math.min(i, paramInt);
        System.arraycopy(c, e, paramArrayOfByte, 0, paramInt);
        e += paramInt;
        if (e >= d) {
          c = null;
        }
      }
    }
    do
    {
      return paramInt;
      i = 0;
      break;
      paramInt = i;
    } while (!f);
    return -1;
  }
  
  abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, icy paramicy);
  
  protected abstract boolean a(byte paramByte);
  
  protected final byte[] a(int paramInt, icy paramicy)
  {
    if ((c == null) || (c.length < d + paramInt))
    {
      if (c == null)
      {
        c = new byte[' '];
        d = 0;
        e = 0;
      }
      for (;;)
      {
        return c;
        byte[] arrayOfByte = new byte[c.length * 2];
        System.arraycopy(c, 0, arrayOfByte, 0, c.length);
        c = arrayOfByte;
      }
    }
    return c;
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    icy localicy = new icy();
    b(paramArrayOfByte, 0, paramArrayOfByte.length, localicy);
    b(paramArrayOfByte, 0, -1, localicy);
    paramArrayOfByte = new byte[d];
    a(paramArrayOfByte, paramArrayOfByte.length, localicy);
    return paramArrayOfByte;
  }
  
  abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, icy paramicy);
  
  public final byte[] b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    icy localicy = new icy();
    a(paramArrayOfByte, 0, paramArrayOfByte.length, localicy);
    a(paramArrayOfByte, 0, -1, localicy);
    paramArrayOfByte = new byte[d - e];
    a(paramArrayOfByte, paramArrayOfByte.length, localicy);
    return paramArrayOfByte;
  }
}

/* Location:
 * Qualified Name:     icx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */