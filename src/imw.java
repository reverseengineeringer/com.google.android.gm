import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

public abstract class imw
  implements Serializable, Cloneable, Comparable
{
  private static final DecimalFormat a;
  private static final long serialVersionUID = 2694906050116005466L;
  public imj g;
  public int h;
  public int i;
  public long j;
  
  static
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    a = localDecimalFormat;
    localDecimalFormat.setMinimumIntegerDigits(3);
  }
  
  protected imw() {}
  
  imw(imj paramimj, int paramInt1, int paramInt2, long paramLong)
  {
    if (!paramimj.b()) {
      throw new imx(paramimj);
    }
    inx.a(paramInt1);
    ikm.a(paramInt2);
    int.a(0L);
    g = paramimj;
    h = paramInt1;
    i = paramInt2;
    j = 0L;
  }
  
  static int a(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 47 + "\"" + paramString + "\" " + paramInt + " must be an unsigned 16 bit value");
    }
    return paramInt;
  }
  
  static long a(String paramString, long paramLong)
  {
    if ((paramLong < 0L) || (paramLong > 4294967295L)) {
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 56 + "\"" + paramString + "\" " + paramLong + " must be an unsigned 32 bit value");
    }
    return paramLong;
  }
  
  static imj a(imj paramimj)
  {
    if (!paramimj.b()) {
      throw new imx(paramimj);
    }
    return paramimj;
  }
  
  static imw a(ikr paramikr, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject = new imj(paramikr);
    int k = paramikr.c();
    int m = paramikr.c();
    if (paramInt == 0)
    {
      localObject = a((imj)localObject, k, m, 0L);
      return (imw)localObject;
    }
    long l = paramikr.d();
    int n = paramikr.c();
    if ((n == 0) && (paramBoolean) && ((paramInt == 1) || (paramInt == 2))) {
      return a((imj)localObject, k, m, l);
    }
    if (paramikr != null) {}
    imw localimw;
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localimw = a((imj)localObject, k, m, l, paramBoolean);
      localObject = localimw;
      if (paramikr == null) {
        break;
      }
      if (paramikr.a() >= n) {
        break label136;
      }
      throw new iog("truncated record");
    }
    label136:
    paramikr.a(n);
    localimw.a(paramikr);
    if (paramikr.a() > 0) {
      throw new iog("invalid record length");
    }
    c = a.length;
    return localimw;
  }
  
  public static imw a(imj paramimj, int paramInt1, int paramInt2)
  {
    return a(paramimj, paramInt1, paramInt2, 0L);
  }
  
  private static imw a(imj paramimj, int paramInt1, int paramInt2, long paramLong)
  {
    if (!paramimj.b()) {
      throw new imx(paramimj);
    }
    inx.a(paramInt1);
    ikm.a(paramInt2);
    int.a(paramLong);
    return a(paramimj, paramInt1, paramInt2, paramLong, false);
  }
  
  private static final imw a(imj paramimj, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = inx.a;
      inx.a(paramInt1);
      localObject = (imw)g.get(iny.b(paramInt1));
      if (localObject != null) {
        localObject = ((imw)localObject).a();
      }
    }
    for (;;)
    {
      g = paramimj;
      h = paramInt1;
      i = paramInt2;
      j = paramLong;
      return (imw)localObject;
      localObject = new iod();
      continue;
      localObject = new ikx();
    }
  }
  
  protected static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\\# ");
    localStringBuffer.append(paramArrayOfByte.length);
    localStringBuffer.append(" ");
    localStringBuffer.append(ioo.a(paramArrayOfByte));
    return localStringBuffer.toString();
  }
  
  protected static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBoolean) {
      localStringBuffer.append('"');
    }
    int k = 0;
    if (k < paramArrayOfByte.length)
    {
      int m = paramArrayOfByte[k] & 0xFF;
      if ((m < 32) || (m >= 127))
      {
        localStringBuffer.append('\\');
        localStringBuffer.append(a.format(m));
      }
      for (;;)
      {
        k += 1;
        break;
        if ((m == 34) || (m == 92))
        {
          localStringBuffer.append('\\');
          localStringBuffer.append((char)m);
        }
        else
        {
          localStringBuffer.append((char)m);
        }
      }
    }
    if (paramBoolean) {
      localStringBuffer.append('"');
    }
    return localStringBuffer.toString();
  }
  
  private final byte[] d()
  {
    ikt localikt = new ikt((byte)0);
    a(localikt, null, true);
    return localikt.a();
  }
  
  abstract imw a();
  
  abstract void a(ikr paramikr);
  
  final void a(ikt paramikt, int paramInt, ikk paramikk)
  {
    g.a(paramikt, paramikk);
    paramikt.b(h);
    paramikt.b(i);
    if (paramInt == 0) {
      return;
    }
    paramikt.a(j);
    paramInt = a;
    paramikt.b(0);
    a(paramikt, paramikk, false);
    paramikt.a(a - paramInt - 2, paramInt);
  }
  
  abstract void a(ikt paramikt, ikk paramikk, boolean paramBoolean);
  
  abstract String b();
  
  public imj c()
  {
    return null;
  }
  
  public int compareTo(Object paramObject)
  {
    int k = 0;
    Object localObject = (imw)paramObject;
    if (this == localObject) {
      return 0;
    }
    int m = g.compareTo(g);
    if (m != 0) {
      return m;
    }
    m = i - i;
    if (m != 0) {
      return m;
    }
    m = h - h;
    if (m != 0) {
      return m;
    }
    paramObject = d();
    localObject = ((imw)localObject).d();
    while ((k < paramObject.length) && (k < localObject.length))
    {
      m = (paramObject[k] & 0xFF) - (localObject[k] & 0xFF);
      if (m != 0) {
        return m;
      }
      k += 1;
    }
    return paramObject.length - localObject.length;
  }
  
  public final int e()
  {
    if (h == 46) {
      return a;
    }
    return h;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof imw))) {}
    do
    {
      return false;
      paramObject = (imw)paramObject;
    } while ((h != h) || (i != i) || (!g.equals(g)));
    return Arrays.equals(d(), ((imw)paramObject).d());
  }
  
  final imw f()
  {
    try
    {
      imw localimw = (imw)clone();
      return localimw;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new IllegalStateException();
    }
  }
  
  public int hashCode()
  {
    int k = 0;
    Object localObject = new ikt((byte)0);
    g.a((ikt)localObject);
    ((ikt)localObject).b(h);
    ((ikt)localObject).b(i);
    ((ikt)localObject).a(0L);
    int m = a;
    ((ikt)localObject).b(0);
    a((ikt)localObject, null, true);
    ((ikt)localObject).a(a - m - 2, m);
    localObject = ((ikt)localObject).a();
    m = 0;
    while (k < localObject.length)
    {
      m += (m << 3) + (localObject[k] & 0xFF);
      k += 1;
    }
    return m;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(g);
    if (localStringBuffer.length() < 8) {
      localStringBuffer.append("\t");
    }
    if (localStringBuffer.length() < 16) {
      localStringBuffer.append("\t");
    }
    localStringBuffer.append("\t");
    Object localObject;
    if (imn.a("BINDTTL"))
    {
      long l2 = j;
      int.a(l2);
      localObject = new StringBuffer();
      long l1 = l2 % 60L;
      long l3 = l2 / 60L;
      l2 = l3 % 60L;
      long l4 = l3 / 60L;
      l3 = l4 % 24L;
      long l5 = l4 / 24L;
      l4 = l5 % 7L;
      l5 /= 7L;
      if (l5 > 0L) {
        ((StringBuffer)localObject).append(21 + l5 + "W");
      }
      if (l4 > 0L) {
        ((StringBuffer)localObject).append(21 + l4 + "D");
      }
      if (l3 > 0L) {
        ((StringBuffer)localObject).append(21 + l3 + "H");
      }
      if (l2 > 0L) {
        ((StringBuffer)localObject).append(21 + l2 + "M");
      }
      if ((l1 > 0L) || ((l5 == 0L) && (l4 == 0L) && (l3 == 0L) && (l2 == 0L))) {
        ((StringBuffer)localObject).append(21 + l1 + "S");
      }
      localStringBuffer.append(((StringBuffer)localObject).toString());
    }
    for (;;)
    {
      localStringBuffer.append("\t");
      if ((i != 1) || (!imn.a("noPrintIN")))
      {
        k = i;
        localStringBuffer.append(ikm.a.c(k));
        localStringBuffer.append("\t");
      }
      int k = h;
      localStringBuffer.append(inx.a.c(k));
      localObject = b();
      if (!((String)localObject).equals(""))
      {
        localStringBuffer.append("\t");
        localStringBuffer.append((String)localObject);
      }
      return localStringBuffer.toString();
      localStringBuffer.append(j);
    }
  }
}

/* Location:
 * Qualified Name:     imw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */