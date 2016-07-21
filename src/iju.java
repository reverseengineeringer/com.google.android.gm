import java.net.InetAddress;
import java.net.UnknownHostException;

public final class iju
  extends imw
{
  private static final long serialVersionUID = -4588601512069748050L;
  private byte[] a;
  
  final imw a()
  {
    return new iju();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.b(16);
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.a(a);
  }
  
  final String b()
  {
    try
    {
      Object localObject = InetAddress.getByAddress(null, a);
      if (((InetAddress)localObject).getAddress().length == 4)
      {
        localObject = new StringBuffer("0:0:0:0:0:ffff:");
        int i = a[12];
        int j = a[13];
        int k = a[14];
        int m = a[15];
        ((StringBuffer)localObject).append(Integer.toHexString(((i & 0xFF) << 8) + (j & 0xFF)));
        ((StringBuffer)localObject).append(':');
        ((StringBuffer)localObject).append(Integer.toHexString(((k & 0xFF) << 8) + (m & 0xFF)));
        return ((StringBuffer)localObject).toString();
      }
      return ((InetAddress)localObject).getHostAddress();
    }
    catch (UnknownHostException localUnknownHostException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     iju
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */