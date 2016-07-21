import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class gre
  extends grc
{
  private final byte[] c;
  private final int d;
  private final int e;
  
  public gre(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramString);
    c = ((byte[])hbe.a(paramArrayOfByte));
    if ((paramInt >= 0) && (paramInt + 0 <= paramArrayOfByte.length)) {}
    for (int i = 1;; i = 0)
    {
      int j = paramArrayOfByte.length;
      if (i != 0) {
        break;
      }
      throw new IllegalArgumentException(hbe.a("offset %s, length %s, array length %s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(j) }));
    }
    d = 0;
    e = paramInt;
  }
  
  public final long a()
  {
    return e;
  }
  
  public final InputStream b()
  {
    return new ByteArrayInputStream(c, d, e);
  }
  
  public final boolean d()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     gre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */