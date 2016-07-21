import java.net.InetAddress;

public final class ijx
{
  public final int a;
  public final boolean b;
  public final int c;
  public final Object d;
  
  private ijx(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2)
  {
    a = paramInt1;
    b = paramBoolean;
    d = paramObject;
    c = paramInt2;
    if (!ijw.a(paramInt1, paramInt2)) {
      throw new IllegalArgumentException("invalid prefix length");
    }
  }
  
  ijx(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, byte paramByte)
  {
    this(paramInt1, paramBoolean, paramObject, paramInt2);
  }
  
  public ijx(boolean paramBoolean, InetAddress paramInetAddress, int paramInt)
  {
    this(ijz.a(paramInetAddress), paramBoolean, paramInetAddress, paramInt);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof ijx))) {}
    do
    {
      return false;
      paramObject = (ijx)paramObject;
    } while ((a != a) || (b != b) || (c != c) || (!d.equals(d)));
    return true;
  }
  
  public final int hashCode()
  {
    int j = d.hashCode();
    int k = c;
    if (b) {}
    for (int i = 1;; i = 0) {
      return i + (k + j);
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (b) {
      localStringBuffer.append("!");
    }
    localStringBuffer.append(a);
    localStringBuffer.append(":");
    if ((a == 1) || (a == 2)) {
      localStringBuffer.append(((InetAddress)d).getHostAddress());
    }
    for (;;)
    {
      localStringBuffer.append("/");
      localStringBuffer.append(c);
      return localStringBuffer.toString();
      localStringBuffer.append(ioo.a((byte[])d));
    }
  }
}

/* Location:
 * Qualified Name:     ijx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */