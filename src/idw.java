import java.io.InputStream;
import java.io.PushbackInputStream;

public final class idw
  extends InputStream
{
  private PushbackInputStream a = null;
  private int b = 0;
  private int c = 3;
  private int d = 0;
  private int e = 0;
  private int f;
  private int g;
  private idx h;
  
  public idw(InputStream paramInputStream)
  {
    a = new PushbackInputStream(paramInputStream, 2);
  }
  
  private final int a()
  {
    int i = a.read();
    if ((i != -1) && (h != null))
    {
      int j = e;
      e = (j + 1);
      if (j == f) {
        f += g;
      }
    }
    return i;
  }
  
  private final void a(int paramInt)
  {
    a.unread(paramInt);
    e -= 1;
  }
  
  public final void close()
  {
    a.close();
  }
  
  public final int read()
  {
    int j = a();
    if (j == -1)
    {
      e = d;
      return -1;
    }
    int i;
    if (((c & 0x1) != 0) && (j == 13))
    {
      int k = a();
      if (k != -1) {
        a(k);
      }
      i = j;
      if (k != 10)
      {
        a(10);
        i = j;
      }
    }
    for (;;)
    {
      b = i;
      return i;
      i = j;
      if ((c & 0x2) != 0)
      {
        i = j;
        if (j == 10)
        {
          i = j;
          if (b != 13)
          {
            a(10);
            i = 13;
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     idw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */