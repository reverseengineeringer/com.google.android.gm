import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

final class cyz
  extends CharsetEncoder
{
  static boolean a;
  private final cyx b;
  private final cyt c;
  private final byte d;
  private final byte e;
  private final boolean f;
  private boolean g;
  private int h;
  private int i;
  
  static
  {
    String str1 = System.getProperty("java.specification.version");
    String str2 = System.getProperty("java.vm.vendor");
    if (("1.4".equals(str1)) || ("1.5".equals(str1))) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      a = bool & "Sun Microsystems Inc.".equals(str2);
      return;
    }
  }
  
  cyz(cyx paramcyx, cyt paramcyt, boolean paramBoolean)
  {
    super(paramcyx, 1.5F, 5.0F);
    b = paramcyx;
    c = paramcyt;
    f = paramBoolean;
    d = paramcyx.a();
    e = paramcyx.b();
  }
  
  protected final CoderResult encodeLoop(CharBuffer paramCharBuffer, ByteBuffer paramByteBuffer)
  {
    while (paramCharBuffer.hasRemaining())
    {
      if (paramByteBuffer.remaining() < 4) {
        return CoderResult.OVERFLOW;
      }
      int j = paramCharBuffer.get();
      cyt localcyt;
      int k;
      if (b.a(j))
      {
        if (g)
        {
          if (h != 0)
          {
            localcyt = c;
            k = i;
            paramByteBuffer.put((byte)a[k]);
          }
          localcyt = c;
          if ((j >= 128) || (b[j] < 0)) {
            break label155;
          }
        }
        label155:
        for (k = 1;; k = 0)
        {
          if ((k != 0) || (j == e) || (f)) {
            paramByteBuffer.put(e);
          }
          g = false;
          i = 0;
          h = 0;
          paramByteBuffer.put((byte)j);
          break;
        }
      }
      if ((!g) && (j == d))
      {
        paramByteBuffer.put(d);
        paramByteBuffer.put(e);
      }
      else
      {
        if (!g) {
          paramByteBuffer.put(d);
        }
        g = true;
        h += 16;
        while (h >= 6)
        {
          h -= 6;
          i += (j >> h);
          i &= 0x3F;
          localcyt = c;
          k = i;
          paramByteBuffer.put((byte)a[k]);
          i = 0;
        }
        i = (j << 6 - h & 0x3F);
      }
    }
    if ((g) && (a) && (paramByteBuffer.limit() != 5.0F * paramCharBuffer.limit())) {
      return CoderResult.OVERFLOW;
    }
    return CoderResult.UNDERFLOW;
  }
  
  protected final CoderResult implFlush(ByteBuffer paramByteBuffer)
  {
    if (g)
    {
      if (paramByteBuffer.remaining() < 2) {
        return CoderResult.OVERFLOW;
      }
      if (h != 0)
      {
        cyt localcyt = c;
        int j = i;
        paramByteBuffer.put((byte)a[j]);
      }
      paramByteBuffer.put(e);
    }
    return CoderResult.UNDERFLOW;
  }
  
  protected final void implReset()
  {
    g = false;
    i = 0;
    h = 0;
  }
}

/* Location:
 * Qualified Name:     cyz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */