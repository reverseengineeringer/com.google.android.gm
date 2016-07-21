import java.io.InputStream;

public final class ief
  extends InputStream
{
  private static byte[] g = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private final InputStream a;
  private int b = 0;
  private int c = 0;
  private final int[] d = new int[3];
  private final byte[] e = new byte[4];
  private boolean f = false;
  
  public ief(InputStream paramInputStream)
  {
    a = paramInputStream;
  }
  
  private final void a(int paramInt)
  {
    int i = e[0] << 18 | 0x0 | e[1] << 12 | e[2] << 6 | e[3];
    if (paramInt == 4)
    {
      d[0] = (i >> 16 & 0xFF);
      d[1] = (i >> 8 & 0xFF);
      d[2] = (i & 0xFF);
      b = 3;
      return;
    }
    if (paramInt == 3)
    {
      d[0] = (i >> 16 & 0xFF);
      d[1] = (i >> 8 & 0xFF);
      b = 2;
      return;
    }
    d[0] = (i >> 16 & 0xFF);
    b = 1;
  }
  
  public final void close()
  {
    a.close();
  }
  
  public final int read()
  {
    int j = 0;
    if (c == b)
    {
      b = 0;
      c = 0;
      for (;;)
      {
        int k;
        if (!f)
        {
          k = a.read();
          switch (k)
          {
          default: 
            int i = g[k];
            if (i < 0) {
              continue;
            }
            localObject = e;
            k = j + 1;
            localObject[j] = i;
            if (k != 4) {
              break label125;
            }
            a(k);
          }
        }
        else
        {
          while (c == b)
          {
            return -1;
            f = true;
            a(j);
          }
          label125:
          j = k;
        }
      }
    }
    Object localObject = d;
    j = c;
    c = (j + 1);
    return localObject[j];
  }
}

/* Location:
 * Qualified Name:     ief
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */