import java.io.IOException;
import java.io.Reader;

public final class igo
{
  int a;
  int b;
  int c;
  public int d = -1;
  public int[] e;
  public int[] f;
  public int g = 0;
  public int h = 1;
  public boolean i = false;
  public boolean j = false;
  public Reader k;
  public char[] l;
  public int m = 0;
  public int n = 0;
  public int o = 8;
  
  public igo(Reader paramReader)
  {
    this(paramReader, 1, 1);
  }
  
  private igo(Reader paramReader, int paramInt1, int paramInt2)
  {
    k = paramReader;
    h = 1;
    g = 0;
    a = 4096;
    b = 4096;
    l = new char['က'];
    e = new int['က'];
    f = new int['က'];
  }
  
  private final void a(boolean paramBoolean)
  {
    char[] arrayOfChar = new char[a + 2048];
    int[] arrayOfInt1 = new int[a + 2048];
    int[] arrayOfInt2 = new int[a + 2048];
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        System.arraycopy(l, c, arrayOfChar, 0, a - c);
        System.arraycopy(l, 0, arrayOfChar, a - c, d);
        l = arrayOfChar;
        System.arraycopy(e, c, arrayOfInt1, 0, a - c);
        System.arraycopy(e, 0, arrayOfInt1, a - c, d);
        e = arrayOfInt1;
        System.arraycopy(f, c, arrayOfInt2, 0, a - c);
        System.arraycopy(f, 0, arrayOfInt2, a - c, d);
        f = arrayOfInt2;
        i1 = d + (a - c);
        d = i1;
        m = i1;
        a += 2048;
        b = a;
        c = 0;
        return;
      }
      catch (Throwable localThrowable)
      {
        int i1;
        throw new Error(localThrowable.getMessage());
      }
      System.arraycopy(l, c, arrayOfChar, 0, a - c);
      l = arrayOfChar;
      System.arraycopy(e, c, arrayOfInt1, 0, a - c);
      e = arrayOfInt1;
      System.arraycopy(f, c, arrayOfInt2, 0, a - c);
      f = arrayOfInt2;
      i1 = d - c;
      d = i1;
      m = i1;
    }
  }
  
  public final char a()
  {
    if (n > 0)
    {
      n -= 1;
      i1 = d + 1;
      d = i1;
      if (i1 == a) {
        d = 0;
      }
      return l[d];
    }
    int i1 = d + 1;
    d = i1;
    if (i1 >= m)
    {
      if (m == b)
      {
        if (b != a) {
          break label229;
        }
        if (c <= 2048) {
          break label201;
        }
        m = 0;
        d = 0;
        b = c;
      }
      for (;;)
      {
        try
        {
          i1 = k.read(l, m, b - m);
          if (i1 != -1) {
            break;
          }
          k.close();
          throw new IOException();
        }
        catch (IOException localIOException)
        {
          d -= 1;
          a(0);
          if (c == -1) {
            c = d;
          }
          throw localIOException;
        }
        label201:
        if (c < 0)
        {
          m = 0;
          d = 0;
        }
        else
        {
          a(false);
          continue;
          label229:
          if (b > c) {
            b = a;
          } else if (c - b < 2048) {
            a(true);
          } else {
            b = c;
          }
        }
      }
      m = (i1 + m);
    }
    char c1 = l[d];
    g += 1;
    if (j)
    {
      j = false;
      i1 = h;
      g = 1;
      h = (i1 + 1);
      switch (c1)
      {
      }
    }
    for (;;)
    {
      e[d] = h;
      f[d] = g;
      return c1;
      if (!i) {
        break;
      }
      i = false;
      if (c1 == '\n')
      {
        j = true;
        break;
      }
      i1 = h;
      g = 1;
      h = (i1 + 1);
      break;
      i = true;
      continue;
      j = true;
      continue;
      g -= 1;
      g += o - g % o;
    }
  }
  
  public final void a(int paramInt)
  {
    n += paramInt;
    paramInt = d - paramInt;
    d = paramInt;
    if (paramInt < 0) {
      d += a;
    }
  }
  
  public final int b()
  {
    return f[d];
  }
  
  public final char[] b(int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    if (d + 1 >= paramInt)
    {
      System.arraycopy(l, d - paramInt + 1, arrayOfChar, 0, paramInt);
      return arrayOfChar;
    }
    System.arraycopy(l, a - (paramInt - d - 1), arrayOfChar, 0, paramInt - d - 1);
    System.arraycopy(l, 0, arrayOfChar, paramInt - d - 1, d + 1);
    return arrayOfChar;
  }
  
  public final int c()
  {
    return e[d];
  }
  
  public final String d()
  {
    if (d >= c) {
      return new String(l, c, d - c + 1);
    }
    String str1 = String.valueOf(new String(l, c, a - c));
    String str2 = String.valueOf(new String(l, 0, d + 1));
    if (str2.length() != 0) {
      return str1.concat(str2);
    }
    return new String(str1);
  }
}

/* Location:
 * Qualified Name:     igo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */