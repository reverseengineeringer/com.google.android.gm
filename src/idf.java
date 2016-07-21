import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class idf
  extends OutputStream
{
  private static final byte[] a = new byte[0];
  private final List<byte[]> b = new ArrayList();
  private int c;
  private int d;
  private byte[] e;
  private int f;
  
  public idf()
  {
    this((byte)0);
  }
  
  private idf(byte paramByte)
  {
    try
    {
      a(1024);
      return;
    }
    finally {}
  }
  
  private final void a(int paramInt)
  {
    if (c < b.size() - 1)
    {
      d += e.length;
      c += 1;
      e = ((byte[])b.get(c));
      return;
    }
    if (e == null) {}
    for (d = 0;; d += e.length)
    {
      c += 1;
      e = new byte[paramInt];
      b.add(e);
      return;
      paramInt = Math.max(e.length << 1, paramInt - d);
    }
  }
  
  public final byte[] a()
  {
    for (;;)
    {
      try
      {
        int j = f;
        if (j == 0)
        {
          arrayOfByte1 = a;
          return arrayOfByte1;
        }
        byte[] arrayOfByte1 = new byte[j];
        Iterator localIterator = b.iterator();
        int i = 0;
        int k;
        if (localIterator.hasNext())
        {
          byte[] arrayOfByte2 = (byte[])localIterator.next();
          k = Math.min(arrayOfByte2.length, j);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, k);
          j -= k;
          if (j == 0) {}
        }
        else
        {
          i += k;
        }
      }
      finally {}
    }
  }
  
  public final void close() {}
  
  public final String toString()
  {
    return new String(a());
  }
  
  public final void write(int paramInt)
  {
    try
    {
      int j = f - d;
      int i = j;
      if (j == e.length)
      {
        a(f + 1);
        i = 0;
      }
      e[i] = ((byte)paramInt);
      f += 1;
      return;
    }
    finally {}
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length) || (paramInt1 + paramInt2 < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      return;
    }
    try
    {
      int m = f + paramInt2;
      int j = f - d;
      int i = paramInt2;
      while (i > 0)
      {
        int k = Math.min(i, e.length - j);
        System.arraycopy(paramArrayOfByte, paramInt1 + paramInt2 - i, e, j, k);
        k = i - k;
        i = k;
        if (k > 0)
        {
          a(m);
          j = 0;
          i = k;
        }
      }
      f = m;
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     idf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */