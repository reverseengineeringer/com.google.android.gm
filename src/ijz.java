import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class ijz
{
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 4;
    }
    if (paramInt == 2) {
      return 16;
    }
    throw new IllegalArgumentException("unknown address family");
  }
  
  public static int a(InetAddress paramInetAddress)
  {
    if ((paramInetAddress instanceof Inet4Address)) {
      return 1;
    }
    if ((paramInetAddress instanceof Inet6Address)) {
      return 2;
    }
    throw new IllegalArgumentException("unknown address family");
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    int m = paramArrayOfByte[3];
    return 47 + (i & 0xFF) + "." + (j & 0xFF) + "." + (k & 0xFF) + "." + (m & 0xFF);
  }
  
  public static InetAddress a(InetAddress paramInetAddress, int paramInt)
  {
    int j = 0;
    int i = a(a(paramInetAddress)) * 8;
    if ((paramInt < 0) || (paramInt > i)) {
      throw new IllegalArgumentException("invalid mask length");
    }
    if (paramInt == i) {
      return paramInetAddress;
    }
    paramInetAddress = paramInetAddress.getAddress();
    i = paramInt / 8 + 1;
    while (i < paramInetAddress.length)
    {
      paramInetAddress[i] = 0;
      i += 1;
    }
    int k = 0;
    i = j;
    j = k;
    while (j < paramInt % 8)
    {
      i |= 1 << 7 - j;
      j += 1;
    }
    paramInt /= 8;
    paramInetAddress[paramInt] = ((byte)(i & paramInetAddress[paramInt]));
    try
    {
      paramInetAddress = InetAddress.getByAddress(paramInetAddress);
      return paramInetAddress;
    }
    catch (UnknownHostException paramInetAddress)
    {
      throw new IllegalArgumentException("invalid address");
    }
  }
}

/* Location:
 * Qualified Name:     ijz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */