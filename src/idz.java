import java.io.InputStream;
import java.io.PushbackInputStream;

public final class idz
  extends InputStream
{
  boolean a = false;
  boolean b = true;
  private PushbackInputStream c = null;
  private byte[] d = null;
  private boolean e = true;
  private boolean f = false;
  
  public idz(InputStream paramInputStream, String paramString)
  {
    c = new PushbackInputStream(paramInputStream, paramString.length() + 4);
    paramInputStream = String.valueOf(paramString);
    if (paramInputStream.length() != 0) {}
    for (paramInputStream = "--".concat(paramInputStream);; paramInputStream = new String("--"))
    {
      d = new byte[paramInputStream.length()];
      while (i < d.length)
      {
        d[i] = ((byte)paramInputStream.charAt(i));
        i += 1;
      }
    }
    i = read();
    if (i != -1) {
      c.unread(i);
    }
  }
  
  private final boolean b()
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    while (i < d.length)
    {
      j = c.read();
      if (j != d[i])
      {
        if (j != -1) {
          c.unread(j);
        }
        i -= 1;
        for (;;)
        {
          bool1 = bool2;
          if (i < 0) {
            break;
          }
          c.unread(d[i]);
          i -= 1;
        }
      }
      i += 1;
    }
    int j = c.read();
    i = c.read();
    if ((j != 45) || (i != 45))
    {
      bool1 = true;
      b = bool1;
    }
    for (;;)
    {
      int k;
      if (i == 10)
      {
        k = i;
        if (j == 13) {}
      }
      else
      {
        k = c.read();
        if (k != -1) {
          break label180;
        }
      }
      if (k == -1)
      {
        b = false;
        a = true;
      }
      f = true;
      bool1 = true;
      return bool1;
      bool1 = false;
      break;
      label180:
      j = i;
      i = k;
    }
  }
  
  public final void a()
  {
    while (read() != -1) {}
  }
  
  public final void close()
  {
    c.close();
  }
  
  public final int read()
  {
    boolean bool = false;
    if (f) {
      return -1;
    }
    if (e)
    {
      e = false;
      if (b()) {
        return -1;
      }
    }
    int i = c.read();
    int j = c.read();
    if ((i == 13) && (j == 10) && (b())) {
      return -1;
    }
    if (j != -1) {
      c.unread(j);
    }
    if (i == -1) {
      bool = true;
    }
    a = bool;
    f = a;
    return i;
  }
}

/* Location:
 * Qualified Name:     idz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */