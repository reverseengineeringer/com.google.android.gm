import java.io.InputStream;

public final class ieb
  extends InputStream
{
  int a = 1;
  private InputStream b = null;
  private int c = -1;
  private boolean d = false;
  
  public ieb(InputStream paramInputStream)
  {
    b = paramInputStream;
  }
  
  public final int read()
  {
    if (d) {
      return -1;
    }
    int i = b.read();
    if ((c == 13) && (i == 10)) {
      a += 1;
    }
    c = i;
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (d)
    {
      paramInt2 = -1;
      return paramInt2;
    }
    int j = b.read(paramArrayOfByte, paramInt1, paramInt2);
    int i = paramInt1;
    for (;;)
    {
      paramInt2 = j;
      if (i >= paramInt1 + j) {
        break;
      }
      if ((c == 13) && (paramArrayOfByte[i] == 10)) {
        a += 1;
      }
      c = paramArrayOfByte[i];
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     ieb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */