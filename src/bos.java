import com.android.emailcommon.provider.Attachment;
import com.android.exchange.adapter.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class bos
  extends Parser
{
  public int a = 0;
  private final OutputStream b;
  private final long c;
  private final bpv d;
  
  public bos(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong, bpv parambpv)
  {
    super(paramInputStream);
    b = paramOutputStream;
    c = paramLong;
    d = parambpv;
  }
  
  private final void a()
  {
    while (b(1294) != 3)
    {
      if (l == 1286) {
        while (b(1286) != 3) {
          if (l == 1291) {
            while (b(1291) != 3) {
              if (l == 1292) {
                a(new bny(j), b, c, d);
              } else {
                i();
              }
            }
          } else {
            i();
          }
        }
      }
      i();
    }
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong, bpv parambpv)
  {
    byte[] arrayOfByte = new byte['䀀'];
    int j = 0;
    long l1 = -1L;
    int i = 0;
    for (;;)
    {
      int k = paramInputStream.read(arrayOfByte, 0, 16384);
      if (k < 0) {
        break;
      }
      j += k;
      paramOutputStream.write(arrayOfByte, 0, k);
      k = i;
      long l2 = l1;
      if (paramLong > 0L)
      {
        int m = (int)(j * 100 / paramLong);
        k = i;
        l2 = l1;
        if (m > l1)
        {
          k = i;
          l2 = l1;
          if (j > i + 16384)
          {
            bpt.a(a, b.o, b.D, 1, m);
            l2 = m;
            k = j;
          }
        }
      }
      i = k;
      l1 = l2;
    }
  }
  
  public final boolean d()
  {
    if (b(0) != 1285) {
      throw new IOException();
    }
    while (b(0) != 1) {
      if (l == 1293) {
        a = h();
      } else if (l == 1294) {
        a();
      } else {
        i();
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bos
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */