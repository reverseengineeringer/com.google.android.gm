import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

final class cyy
  extends CharsetDecoder
{
  private final cyt a;
  private final byte b;
  private final byte c;
  private final boolean d;
  private boolean e;
  private int f;
  private int g;
  private boolean h;
  private boolean i;
  
  cyy(cyx paramcyx, cyt paramcyt, boolean paramBoolean)
  {
    super(paramcyx, 0.6F, 1.0F);
    a = paramcyt;
    d = paramBoolean;
    b = paramcyx.a();
    c = paramcyx.b();
  }
  
  private static CoderResult a(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.position(paramByteBuffer.position() - 1);
    return CoderResult.OVERFLOW;
  }
  
  private final boolean a()
  {
    return (g != 0) || (f >= 6);
  }
  
  private static CoderResult b(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.position(paramByteBuffer.position() - 1);
    return CoderResult.malformedForLength(1);
  }
  
  private final void b()
  {
    e = false;
    f = 0;
    g = 0;
  }
  
  protected final CoderResult decodeLoop(ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer)
  {
    while (paramByteBuffer.hasRemaining())
    {
      int k = paramByteBuffer.get();
      if (e)
      {
        if (k == c)
        {
          if (a()) {
            return b(paramByteBuffer);
          }
          if (h)
          {
            if (!paramCharBuffer.hasRemaining()) {
              return a(paramByteBuffer);
            }
            paramCharBuffer.put((char)b);
            label70:
            b();
          }
        }
        label190:
        label245:
        label291:
        for (;;)
        {
          h = false;
          break;
          i = true;
          break label70;
          if (!paramCharBuffer.hasRemaining()) {
            return a(paramByteBuffer);
          }
          Object localObject2 = null;
          Object localObject1 = null;
          cyt localcyt = a;
          int j;
          if (k >= 128)
          {
            j = -1;
            if (j < 0) {
              break label245;
            }
            f += 6;
            if (f >= 16) {
              break label190;
            }
            k = g;
            g = ((j << 16 - f) + k);
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label291;
            }
            return (CoderResult)localObject1;
            j = b[k];
            break;
            f -= 16;
            g += (j >> f);
            paramCharBuffer.put((char)g);
            g = (j << 16 - f & 0xFFFF);
            continue;
            if (d)
            {
              localObject1 = b(paramByteBuffer);
            }
            else
            {
              paramCharBuffer.put((char)k);
              localObject1 = localObject2;
              if (a()) {
                localObject1 = b(paramByteBuffer);
              }
              b();
            }
          }
        }
      }
      if (k == b)
      {
        e = true;
        if ((i) && (d)) {
          return b(paramByteBuffer);
        }
        h = true;
      }
      else
      {
        if (!paramCharBuffer.hasRemaining()) {
          return a(paramByteBuffer);
        }
        paramCharBuffer.put((char)k);
        i = false;
      }
    }
    return CoderResult.UNDERFLOW;
  }
  
  protected final CoderResult implFlush(CharBuffer paramCharBuffer)
  {
    if (((e) && (d)) || (a())) {
      return CoderResult.malformedForLength(1);
    }
    return CoderResult.UNDERFLOW;
  }
  
  protected final void implReset()
  {
    b();
    i = false;
  }
}

/* Location:
 * Qualified Name:     cyy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */