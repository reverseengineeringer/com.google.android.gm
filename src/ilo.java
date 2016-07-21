import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class ilo
  extends imw
{
  private static NumberFormat a;
  private static NumberFormat b;
  private static final long serialVersionUID = 9058224788126750409L;
  private long c;
  private long d;
  private long e;
  private long f;
  private long k;
  private long l;
  
  static
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    a = localDecimalFormat;
    localDecimalFormat.setMinimumIntegerDigits(2);
    localDecimalFormat = new DecimalFormat();
    b = localDecimalFormat;
    localDecimalFormat.setMinimumIntegerDigits(3);
  }
  
  private static int a(long paramLong)
  {
    int i = 0;
    while (paramLong > 9L)
    {
      i = (byte)(i + 1);
      paramLong /= 10L;
    }
    return (int)(i + (paramLong << 4));
  }
  
  private static long a(int paramInt)
  {
    long l1 = paramInt >> 4;
    int i = paramInt & 0xF;
    if (l1 <= 9L)
    {
      paramInt = i;
      if (i <= 9) {}
    }
    else
    {
      throw new iog("Invalid LOC Encoding");
    }
    while (paramInt > 0)
    {
      l1 *= 10L;
      paramInt -= 1;
    }
    return l1;
  }
  
  private static String a(long paramLong, char paramChar1, char paramChar2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramLong -= 2147483648L;
    if (paramLong < 0L) {
      paramLong = -paramLong;
    }
    for (;;)
    {
      localStringBuffer.append(paramLong / 3600000L);
      paramLong %= 3600000L;
      localStringBuffer.append(" ");
      localStringBuffer.append(paramLong / 60000L);
      localStringBuffer.append(" ");
      a(localStringBuffer, b, paramLong % 60000L, 1000L);
      localStringBuffer.append(" ");
      localStringBuffer.append(paramChar2);
      return localStringBuffer.toString();
      paramChar2 = paramChar1;
    }
  }
  
  private static void a(StringBuffer paramStringBuffer, NumberFormat paramNumberFormat, long paramLong1, long paramLong2)
  {
    paramStringBuffer.append(paramLong1 / paramLong2);
    paramLong1 %= paramLong2;
    if (paramLong1 != 0L)
    {
      paramStringBuffer.append(".");
      paramStringBuffer.append(paramNumberFormat.format(paramLong1));
    }
  }
  
  final imw a()
  {
    return new ilo();
  }
  
  final void a(ikr paramikr)
  {
    if (paramikr.b() != 0) {
      throw new iog("Invalid LOC version");
    }
    c = a(paramikr.b());
    d = a(paramikr.b());
    e = a(paramikr.b());
    f = paramikr.d();
    k = paramikr.d();
    l = paramikr.d();
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.a(0);
    paramikt.a(a(c));
    paramikt.a(a(d));
    paramikt.a(a(e));
    paramikt.a(f);
    paramikt.a(k);
    paramikt.a(l);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(f, 'N', 'S'));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(k, 'E', 'W'));
    localStringBuffer.append(" ");
    a(localStringBuffer, a, l - 10000000L, 100L);
    localStringBuffer.append("m ");
    a(localStringBuffer, a, c, 100L);
    localStringBuffer.append("m ");
    a(localStringBuffer, a, d, 100L);
    localStringBuffer.append("m ");
    a(localStringBuffer, a, e, 100L);
    localStringBuffer.append("m");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ilo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */