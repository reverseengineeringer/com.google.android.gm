import java.io.PushbackReader;
import java.io.Reader;
import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class hrz
  extends PushbackReader
{
  private static final char[] c = { 13, 10, 32 };
  private static final char[] d = { 13, 10, 9 };
  private static final char[] e = { 10, 32 };
  private static final char[] f = { 10, 9 };
  int a;
  private Log b = LogFactory.getLog(hrz.class);
  private char[][] g;
  private char[][] h;
  private int i = 0;
  
  public hrz(Reader paramReader)
  {
    this(paramReader, c.length, icf.a("ical4j.unfolding.relaxed"));
  }
  
  private hrz(Reader paramReader, int paramInt, boolean paramBoolean)
  {
    super(paramReader, paramInt);
    if (paramBoolean)
    {
      g = new char[4][];
      g[0] = c;
      g[1] = d;
      g[2] = e;
      g[3] = f;
    }
    for (;;)
    {
      h = new char[g.length][];
      paramInt = j;
      while (paramInt < g.length)
      {
        h[paramInt] = new char[g[paramInt].length];
        i = Math.max(i, g[paramInt].length);
        paramInt += 1;
      }
      g = new char[2][];
      g[0] = c;
      g[1] = d;
    }
  }
  
  private final void a()
  {
    int k;
    label111:
    do
    {
      int j = 0;
      k = 0;
      if (j < h.length)
      {
        int m = 0;
        while (m < h[j].length)
        {
          n = super.read(h[j], m, h[j].length - m);
          if (n < 0) {
            break;
          }
          m += n;
        }
        int n = k;
        if (m > 0)
        {
          if (Arrays.equals(g[j], h[j])) {
            break label111;
          }
          unread(h[j], 0, m);
        }
        for (n = k;; n = 1)
        {
          j += 1;
          k = n;
          break;
          if (b.isTraceEnabled()) {
            b.trace("Unfolding...");
          }
          a += 1;
        }
      }
    } while (k != 0);
  }
  
  public final int read()
  {
    int m = 0;
    int n = super.read();
    int j = 0;
    for (;;)
    {
      int k = m;
      if (j < g.length)
      {
        if (n == g[j][0]) {
          k = 1;
        }
      }
      else
      {
        if (k != 0) {
          break;
        }
        return n;
      }
      j += 1;
    }
    unread(n);
    a();
    return super.read();
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int k = 0;
    int m = super.read(paramArrayOfChar, paramInt1, paramInt2);
    paramInt2 = 0;
    for (;;)
    {
      int j = k;
      if (paramInt2 < g.length)
      {
        if ((m > 0) && (paramArrayOfChar[0] == g[paramInt2][0])) {
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        return m;
      }
      j = 0;
      while (j < m)
      {
        if (paramArrayOfChar[j] == g[paramInt2][0])
        {
          unread(paramArrayOfChar, j, m - j);
          return j;
        }
        j += 1;
      }
      paramInt2 += 1;
    }
    unread(paramArrayOfChar, paramInt1, m);
    a();
    return super.read(paramArrayOfChar, paramInt1, i);
  }
}

/* Location:
 * Qualified Name:     hrz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */