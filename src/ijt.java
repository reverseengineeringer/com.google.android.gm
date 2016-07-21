import java.net.InetAddress;

public final class ijt
  extends imw
{
  private static final long serialVersionUID = -8815026887337346789L;
  private int a;
  private InetAddress b;
  private imj c;
  
  final imw a()
  {
    return new ijt();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.b();
    int i = (128 - a + 7) / 8;
    if (a < 128)
    {
      byte[] arrayOfByte = new byte[16];
      paramikr.a(arrayOfByte, 16 - i, i);
      b = InetAddress.getByAddress(arrayOfByte);
    }
    if (a > 0) {
      c = new imj(paramikr);
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.a(a);
    if (b != null)
    {
      int i = (128 - a + 7) / 8;
      paramikt.a(b.getAddress(), 16 - i, i);
    }
    if (c != null) {
      c.a(paramikt, null, paramBoolean);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    if (b != null)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(b.getHostAddress());
    }
    if (c != null)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(c);
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ijt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */