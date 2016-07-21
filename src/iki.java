import java.net.InetAddress;
import java.net.UnknownHostException;

public final class iki
  extends ikv
{
  private int a;
  private int b;
  private int c;
  private InetAddress d;
  
  iki()
  {
    super(8);
  }
  
  final String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(d.getHostAddress());
    localStringBuffer.append("/");
    localStringBuffer.append(b);
    localStringBuffer.append(", scope netmask ");
    localStringBuffer.append(c);
    return localStringBuffer.toString();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.c();
    if ((a != 1) && (a != 2)) {
      throw new iog("unknown address family");
    }
    b = paramikr.b();
    if (b > ijz.a(a) * 8) {
      throw new iog("invalid source netmask");
    }
    c = paramikr.b();
    if (c > ijz.a(a) * 8) {
      throw new iog("invalid scope netmask");
    }
    paramikr = paramikr.e();
    if (paramikr.length != (b + 7) / 8) {
      throw new iog("invalid address");
    }
    byte[] arrayOfByte = new byte[ijz.a(a)];
    System.arraycopy(paramikr, 0, arrayOfByte, 0, paramikr.length);
    try
    {
      d = InetAddress.getByAddress(arrayOfByte);
      if (!ijz.a(d, b).equals(d)) {
        throw new iog("invalid padding");
      }
    }
    catch (UnknownHostException paramikr)
    {
      throw new iog("invalid address", paramikr);
    }
  }
  
  final void a(ikt paramikt)
  {
    paramikt.b(a);
    paramikt.a(b);
    paramikt.a(c);
    paramikt.a(d.getAddress(), 0, (b + 7) / 8);
  }
}

/* Location:
 * Qualified Name:     iki
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */