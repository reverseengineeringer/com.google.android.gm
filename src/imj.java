import java.io.PrintStream;
import java.io.Serializable;
import java.text.DecimalFormat;

public final class imj
  implements Serializable, Comparable
{
  public static final imj a;
  public static final imj b;
  private static final byte[] f = { 0 };
  private static final byte[] g = { 1, 42 };
  private static final DecimalFormat h = new DecimalFormat();
  private static final byte[] i = new byte['Ā'];
  private static final imj j;
  private static final long serialVersionUID = -7257019940971525644L;
  private byte[] c;
  private long d;
  private int e;
  
  static
  {
    h.setMinimumIntegerDigits(3);
    int k = 0;
    if (k < i.length)
    {
      if ((k < 65) || (k > 90)) {
        i[k] = ((byte)k);
      }
      for (;;)
      {
        k += 1;
        break;
        i[k] = ((byte)(k - 65 + 97));
      }
    }
    imj localimj = new imj();
    a = localimj;
    localimj.a(f);
    localimj = new imj();
    b = localimj;
    c = new byte[0];
    localimj = new imj();
    j = localimj;
    localimj.a(g);
  }
  
  private imj() {}
  
  public imj(ikr paramikr)
  {
    byte[] arrayOfByte = new byte[64];
    int m = 0;
    int k = 0;
    while (k == 0)
    {
      int n = paramikr.b();
      switch (n & 0xC0)
      {
      default: 
        throw new iog("bad label type");
      case 0: 
        if (a() >= 128) {
          throw new iog("too many labels");
        }
        if (n == 0)
        {
          a(f, 0, 1);
          k = 1;
        }
        else
        {
          arrayOfByte[0] = ((byte)n);
          paramikr.a(arrayOfByte, 1, n);
          a(arrayOfByte, 0, 1);
        }
        break;
      case 192: 
        int i1 = ((n & 0xFF3F) << 8) + paramikr.b();
        PrintStream localPrintStream;
        if (imn.a("verbosecompression"))
        {
          localPrintStream = System.err;
          n = b;
          localPrintStream.println(45 + "currently " + n + ", pointer to " + i1);
        }
        if (i1 >= b - 2) {
          throw new iog("bad compression");
        }
        n = m;
        if (m == 0)
        {
          d = b;
          e = c;
          n = 1;
        }
        if (i1 >= a.length) {
          throw new IllegalArgumentException("cannot jump past end of input");
        }
        b = i1;
        c = a.length;
        m = n;
        if (imn.a("verbosecompression"))
        {
          localPrintStream = System.err;
          String str = String.valueOf(this);
          localPrintStream.println(String.valueOf(str).length() + 39 + "current name '" + str + "', seeking to " + i1);
          m = n;
        }
        break;
      }
    }
    if (m != 0)
    {
      if (d < 0) {
        throw new IllegalStateException("no previous state");
      }
      b = d;
      c = e;
      d = -1;
      e = -1;
    }
  }
  
  public imj(imj paramimj, int paramInt)
  {
    int m = paramimj.a();
    if (paramInt > m) {
      throw new IllegalArgumentException("attempted to remove too many labels");
    }
    c = c;
    b(m - paramInt);
    int k = 0;
    while ((k < 7) && (k < m - paramInt))
    {
      a(k, paramimj.a(k + paramInt));
      k += 1;
    }
  }
  
  private imj(String paramString, imj paramimj)
  {
    if (paramString.equals("")) {
      throw a(paramString, "empty name");
    }
    if (paramString.equals("@"))
    {
      if (paramimj == null)
      {
        b(b, this);
        return;
      }
      b(paramimj, this);
      return;
    }
    if (paramString.equals("."))
    {
      b(a, this);
      return;
    }
    int i2 = -1;
    int i4 = 1;
    byte[] arrayOfByte = new byte[64];
    int i5 = 0;
    int n = 0;
    int m = 0;
    int i3 = 0;
    int k;
    int i1;
    if (i3 < paramString.length())
    {
      k = (byte)paramString.charAt(i3);
      if (i5 != 0) {
        if ((k >= 48) && (k <= 57) && (n < 3))
        {
          int i6 = n + 1;
          int i7 = m * 10 + (k - 48);
          if (i7 > 255) {
            throw a(paramString, "bad escape");
          }
          m = i7;
          n = i6;
          i1 = i4;
          if (i6 < 3) {
            break label242;
          }
          k = (byte)i7;
          n = i6;
          m = i7;
        }
      }
    }
    for (;;)
    {
      if (i4 > 63)
      {
        throw a(paramString, "label too long");
        if ((n > 0) && (n < 3)) {
          throw a(paramString, "bad escape");
        }
      }
      else
      {
        arrayOfByte[i4] = k;
        i5 = 0;
        i2 = i4;
        i1 = i4 + 1;
        for (;;)
        {
          label242:
          i3 += 1;
          i4 = i1;
          break;
          if (k == 92)
          {
            i5 = 1;
            n = 0;
            m = 0;
            i1 = i4;
          }
          else
          {
            if (k != 46) {
              break label323;
            }
            if (i2 == -1) {
              throw a(paramString, "invalid empty label");
            }
            arrayOfByte[0] = ((byte)(i4 - 1));
            a(paramString, arrayOfByte, 0, 1);
            i2 = -1;
            i1 = 1;
          }
        }
        label323:
        if (i2 == -1) {}
        for (i1 = i3;; i1 = i2)
        {
          if (i4 > 63) {
            throw a(paramString, "label too long");
          }
          arrayOfByte[i4] = k;
          i4 += 1;
          i2 = i1;
          i1 = i4;
          break label242;
          if ((n > 0) && (n < 3)) {
            throw a(paramString, "bad escape");
          }
          if (i5 != 0) {
            throw a(paramString, "bad escape");
          }
          if (i2 == -1) {
            a(paramString, f, 0, 1);
          }
          for (m = 1; (paramimj != null) && (m == 0); m = 0)
          {
            a(paramString, c, paramimj.a(0), paramimj.a());
            return;
            arrayOfByte[0] = ((byte)(i4 - 1));
            a(paramString, arrayOfByte, 0, 1);
          }
          break;
        }
      }
    }
  }
  
  private final int a(int paramInt)
  {
    int n;
    if ((paramInt == 0) && (a() == 0))
    {
      n = 0;
      return n;
    }
    if ((paramInt < 0) || (paramInt >= a())) {
      throw new IllegalArgumentException("label out of range");
    }
    if (paramInt < 7) {
      return (int)(d >>> (7 - paramInt) * 8) & 0xFF;
    }
    int k = a(6);
    int m = 6;
    for (;;)
    {
      n = k;
      if (m >= paramInt) {
        break;
      }
      n = c[k];
      m += 1;
      k = n + 1 + k;
    }
  }
  
  public static imj a(imj paramimj1, imj paramimj2)
  {
    if (paramimj1.b()) {
      return paramimj1;
    }
    imj localimj = new imj();
    b(paramimj1, localimj);
    localimj.a(c, paramimj2.a(0), paramimj2.a());
    return localimj;
  }
  
  public static imj a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static imj a(String paramString, imj paramimj)
  {
    if ((paramString.equals("@")) && (paramimj != null)) {
      return paramimj;
    }
    if (paramString.equals(".")) {
      return a;
    }
    return new imj(paramString, paramimj);
  }
  
  private static inw a(String paramString1, String paramString2)
  {
    return new inw(String.valueOf(paramString1).length() + 4 + String.valueOf(paramString2).length() + "'" + paramString1 + "': " + paramString2);
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int k = paramInt + 1;
    int m = paramArrayOfByte[paramInt];
    paramInt = k;
    if (paramInt < k + m)
    {
      int n = paramArrayOfByte[paramInt] & 0xFF;
      if ((n <= 32) || (n >= 127))
      {
        localStringBuffer.append('\\');
        localStringBuffer.append(h.format(n));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if ((n == 34) || (n == 40) || (n == 41) || (n == 46) || (n == 59) || (n == 92) || (n == 64) || (n == 36))
        {
          localStringBuffer.append('\\');
          localStringBuffer.append((char)n);
        }
        else
        {
          localStringBuffer.append((char)n);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 7) {
      return;
    }
    paramInt1 = (7 - paramInt1) * 8;
    d &= (255L << paramInt1 ^ 0xFFFFFFFFFFFFFFFF);
    long l = d;
    d = (paramInt2 << paramInt1 | l);
  }
  
  private final void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (imk paramArrayOfByte)
    {
      throw a(paramString, "Name too long");
    }
  }
  
  private final void a(byte[] paramArrayOfByte)
  {
    try
    {
      a(paramArrayOfByte, 0, 1);
      return;
    }
    catch (imk paramArrayOfByte) {}
  }
  
  private final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int k;
    int m;
    if (c == null)
    {
      k = 0;
      i1 = paramInt1;
      n = 0;
      m = 0;
    }
    for (;;)
    {
      if (n >= paramInt2) {
        break label96;
      }
      i3 = paramArrayOfByte[i1];
      if (i3 > 63)
      {
        throw new IllegalStateException("invalid label");
        k = c.length - a(0);
        break;
      }
      i3 += 1;
      i1 += i3;
      m += i3;
      n += 1;
    }
    label96:
    int i3 = k + m;
    if (i3 > 255) {
      throw new imk();
    }
    int n = a();
    int i1 = n + paramInt2;
    if (i1 > 128) {
      throw new IllegalStateException("too many labels");
    }
    byte[] arrayOfByte = new byte[i3];
    if (k != 0) {
      System.arraycopy(c, a(0), arrayOfByte, 0, k);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, k, m);
    c = arrayOfByte;
    paramInt1 = i2;
    while (paramInt1 < paramInt2)
    {
      a(n + paramInt1, k);
      k += arrayOfByte[k] + 1;
      paramInt1 += 1;
    }
    b(i1);
  }
  
  public static imj b(String paramString)
  {
    try
    {
      imj localimj = a(paramString, null);
      return localimj;
    }
    catch (inw localinw)
    {
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 15 + "Invalid name '" + paramString + "'");
    }
  }
  
  private final void b(int paramInt)
  {
    d &= 0xFFFFFFFFFFFFFF00;
    d |= paramInt;
  }
  
  private static final void b(imj paramimj1, imj paramimj2)
  {
    int k = 0;
    if (paramimj1.a(0) == 0)
    {
      c = c;
      d = d;
      return;
    }
    int m = paramimj1.a(0);
    int i1 = c.length - m;
    int n = paramimj1.a();
    c = new byte[i1];
    System.arraycopy(c, m, c, 0, i1);
    while ((k < n) && (k < 7))
    {
      paramimj2.a(k, paramimj1.a(k) - m);
      k += 1;
    }
    paramimj2.b(n);
  }
  
  private final boolean b(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = a();
    int n = a(0);
    int m = 0;
    int k = paramInt;
    paramInt = n;
    while (m < i1)
    {
      if (c[paramInt] != paramArrayOfByte[k]) {
        return false;
      }
      int i2 = c[paramInt];
      if (i2 > 63) {
        throw new IllegalStateException("invalid label");
      }
      k += 1;
      paramInt += 1;
      n = 0;
      for (;;)
      {
        if (n >= i2) {
          break label130;
        }
        if (i[(c[paramInt] & 0xFF)] != i[(paramArrayOfByte[k] & 0xFF)]) {
          break;
        }
        n += 1;
        k += 1;
        paramInt += 1;
      }
      label130:
      m += 1;
    }
    return true;
  }
  
  final int a()
  {
    return (int)(d & 0xFF);
  }
  
  public final imj a(ikq paramikq)
  {
    int m = 0;
    imj localimj = g;
    paramikq = a;
    if (!a(localimj))
    {
      paramikq = null;
      return paramikq;
    }
    int n = a() - localimj.a();
    int k = c() - localimj.c();
    int i2 = a(0);
    int i1 = paramikq.a();
    int i3 = paramikq.c();
    if (k + i3 > 255) {
      throw new imk();
    }
    localimj = new imj();
    localimj.b(n + i1);
    c = new byte[k + i3];
    System.arraycopy(c, i2, c, 0, k);
    System.arraycopy(c, 0, c, k, i3);
    k = 0;
    for (;;)
    {
      paramikq = localimj;
      if (k >= 7) {
        break;
      }
      paramikq = localimj;
      if (k >= n + i1) {
        break;
      }
      localimj.a(k, m);
      m += c[m] + 1;
      k += 1;
    }
  }
  
  public final String a(boolean paramBoolean)
  {
    int k = 0;
    int n = a();
    if (n == 0) {
      return "@";
    }
    if ((n == 1) && (c[a(0)] == 0)) {
      return ".";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int m = a(0);
    for (;;)
    {
      int i1;
      if (k < n)
      {
        i1 = c[m];
        if (i1 > 63) {
          throw new IllegalStateException("invalid label");
        }
        if (i1 != 0) {
          break label107;
        }
        if (!paramBoolean) {
          localStringBuffer.append('.');
        }
      }
      return localStringBuffer.toString();
      label107:
      if (k > 0) {
        localStringBuffer.append('.');
      }
      localStringBuffer.append(a(c, m));
      m += i1 + 1;
      k += 1;
    }
  }
  
  public final void a(ikt paramikt)
  {
    int i2 = a();
    Object localObject;
    if (i2 == 0)
    {
      localObject = new byte[0];
      paramikt.a((byte[])localObject);
      return;
    }
    byte[] arrayOfByte = new byte[c.length - a(0)];
    int k = a(0);
    int m = 0;
    int n = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (n >= i2) {
        break;
      }
      int i3 = c[k];
      if (i3 > 63) {
        throw new IllegalStateException("invalid label");
      }
      arrayOfByte[m] = c[k];
      k += 1;
      m += 1;
      int i1 = 0;
      while (i1 < i3)
      {
        arrayOfByte[m] = i[(c[k] & 0xFF)];
        i1 += 1;
        m += 1;
        k += 1;
      }
      n += 1;
    }
  }
  
  public final void a(ikt paramikt, ikk paramikk)
  {
    if (!b()) {
      throw new IllegalArgumentException("toWire() called on non-absolute name");
    }
    int n = a();
    int k = 0;
    while (k < n - 1)
    {
      if (k == 0) {}
      for (Object localObject1 = this;; localObject1 = new imj(this, k))
      {
        m = -1;
        if (paramikk != null) {
          m = paramikk.a((imj)localObject1);
        }
        if (m < 0) {
          break;
        }
        paramikt.b(m | 0xC000);
        return;
      }
      if (paramikk != null)
      {
        m = a;
        if (m <= 16383)
        {
          int i1 = (((imj)localObject1).hashCode() & 0x7FFFFFFF) % 17;
          Object localObject2 = new ikl((byte)0);
          a = ((imj)localObject1);
          b = m;
          c = a[i1];
          a[i1] = localObject2;
          if (b)
          {
            localObject2 = System.err;
            localObject1 = String.valueOf(localObject1);
            ((PrintStream)localObject2).println(String.valueOf(localObject1).length() + 22 + "Adding " + (String)localObject1 + " at " + m);
          }
        }
      }
      int m = a(k);
      paramikt.a(c, m, c[m] + 1);
      k += 1;
    }
    paramikt.a(0);
  }
  
  public final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramikt);
      return;
    }
    a(paramikt, paramikk);
  }
  
  public final boolean a(imj paramimj)
  {
    int k = a();
    int m = paramimj.a();
    if (m > k) {
      return false;
    }
    if (m == k) {
      return equals(paramimj);
    }
    return paramimj.b(c, a(k - m));
  }
  
  public final boolean b()
  {
    int k = a();
    if (k == 0) {}
    while (c[a(k - 1)] != 0) {
      return false;
    }
    return true;
  }
  
  public final short c()
  {
    if (a() == 0) {
      return 0;
    }
    return (short)(c.length - a(0));
  }
  
  public final int compareTo(Object paramObject)
  {
    paramObject = (imj)paramObject;
    if (this == paramObject) {
      return 0;
    }
    int i1 = a();
    int i2 = ((imj)paramObject).a();
    int k;
    int m;
    if (i1 > i2)
    {
      k = i2;
      m = 1;
    }
    for (;;)
    {
      if (m > k) {
        break label182;
      }
      int i3 = a(i1 - m);
      int i4 = ((imj)paramObject).a(i2 - m);
      int i5 = c[i3];
      int i6 = c[i4];
      int n = 0;
      for (;;)
      {
        if ((n >= i5) || (n >= i6)) {
          break label162;
        }
        int i7 = i[(c[(n + i3 + 1)] & 0xFF)] - i[(c[(n + i4 + 1)] & 0xFF)];
        if (i7 != 0)
        {
          return i7;
          k = i1;
          break;
        }
        n += 1;
      }
      label162:
      if (i5 != i6) {
        return i5 - i6;
      }
      m += 1;
    }
    label182:
    return i1 - i2;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (!(paramObject instanceof imj));
        paramObject = (imj)paramObject;
        if (e == 0) {
          ((imj)paramObject).hashCode();
        }
        if (e == 0) {
          hashCode();
        }
        bool1 = bool2;
      } while (e != e);
      bool1 = bool2;
    } while (((imj)paramObject).a() != a());
    return b(c, ((imj)paramObject).a(0));
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (e != 0) {
      return e;
    }
    int k = a(0);
    while (k < c.length)
    {
      m += (m << 3) + i[(c[k] & 0xFF)];
      k += 1;
    }
    e = m;
    return e;
  }
  
  public final String toString()
  {
    return a(false);
  }
}

/* Location:
 * Qualified Name:     imj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */