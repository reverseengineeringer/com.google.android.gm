import java.util.Random;

public final class ilf
  implements Cloneable
{
  private static Random d = new Random();
  int a;
  int[] b;
  private int c;
  
  public ilf()
  {
    f();
  }
  
  public ilf(int paramInt)
  {
    f();
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException(42 + "DNS message ID " + paramInt + " is out of range");
    }
    c = paramInt;
  }
  
  ilf(ikr paramikr)
  {
    this(paramikr.c());
    a = paramikr.c();
    int i = 0;
    while (i < b.length)
    {
      b[i] = paramikr.c();
      i += 1;
    }
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    f(paramInt2);
    return 1 << 15 - paramInt2 | paramInt1;
  }
  
  private static boolean e(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 15))
    {
      ila.a.a(paramInt);
      if (((paramInt > 0) && (paramInt <= 4)) || (paramInt >= 12)) {}
      for (paramInt = 0; paramInt != 0; paramInt = 1) {
        return true;
      }
    }
    return false;
  }
  
  private final void f()
  {
    b = new int[4];
    a = 0;
    c = -1;
  }
  
  private static void f(int paramInt)
  {
    if (!e(paramInt)) {
      throw new IllegalArgumentException(28 + "invalid flag bit " + paramInt);
    }
  }
  
  private final String g()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 16)
    {
      if ((e(i)) && (b(i)))
      {
        localStringBuffer.append(ila.a.c(i));
        localStringBuffer.append(" ");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final void a(int paramInt)
  {
    f(paramInt);
    a = a(a, paramInt);
  }
  
  final void a(ikt paramikt)
  {
    paramikt.b(b());
    paramikt.b(a);
    int i = 0;
    while (i < b.length)
    {
      paramikt.b(b[i]);
      i += 1;
    }
  }
  
  public final byte[] a()
  {
    ikt localikt = new ikt((byte)0);
    a(localikt);
    return localikt.a();
  }
  
  public final int b()
  {
    if (c >= 0) {
      return c;
    }
    try
    {
      if (c < 0) {
        c = d.nextInt(65535);
      }
      int i = c;
      return i;
    }
    finally {}
  }
  
  public final boolean b(int paramInt)
  {
    f(paramInt);
    return (a & 1 << 15 - paramInt) != 0;
  }
  
  public final void c()
  {
    a &= 0x87FF;
    a |= 0x0;
  }
  
  final void c(int paramInt)
  {
    if (b[paramInt] == 65535) {
      throw new IllegalStateException("DNS section count cannot be incremented");
    }
    int[] arrayOfInt = b;
    arrayOfInt[paramInt] += 1;
  }
  
  public final Object clone()
  {
    ilf localilf = new ilf();
    c = c;
    a = a;
    System.arraycopy(b, 0, b, 0, b.length);
    return localilf;
  }
  
  public final int d()
  {
    return a >> 11 & 0xF;
  }
  
  final String d(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(";; ->>HEADER<<- ");
    int i = d();
    String str = String.valueOf(imm.a.c(i));
    if (str.length() != 0)
    {
      str = "opcode: ".concat(str);
      localStringBuffer.append(str);
      str = String.valueOf(imv.a.c(paramInt));
      if (str.length() == 0) {
        break label249;
      }
      str = ", status: ".concat(str);
      label79:
      localStringBuffer.append(str);
      paramInt = b();
      localStringBuffer.append(17 + ", id: " + paramInt);
      localStringBuffer.append("\n");
      str = String.valueOf(g());
      if (str.length() == 0) {
        break label262;
      }
    }
    label249:
    label262:
    for (str = ";; flags: ".concat(str);; str = new String(";; flags: "))
    {
      localStringBuffer.append(str);
      localStringBuffer.append("; ");
      paramInt = 0;
      while (paramInt < 4)
      {
        str = ini.a.c(paramInt);
        i = b[paramInt];
        localStringBuffer.append(String.valueOf(str).length() + 14 + str + ": " + i + " ");
        paramInt += 1;
      }
      str = new String("opcode: ");
      break;
      str = new String(", status: ");
      break label79;
    }
    return localStringBuffer.toString();
  }
  
  final void e()
  {
    if (b[3] == 0) {
      throw new IllegalStateException("DNS section count cannot be decremented");
    }
    int[] arrayOfInt = b;
    arrayOfInt[3] -= 1;
  }
  
  public final String toString()
  {
    return d(a & 0xF);
  }
}

/* Location:
 * Qualified Name:     ilf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */