import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class ion
{
  public MessageDigest a;
  public byte[] b;
  private int c;
  private byte[] d;
  
  public ion(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      a = MessageDigest.getInstance(paramString);
      c = paramInt;
      b(paramArrayOfByte);
      return;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {}
    }
    for (paramString = "unknown digest algorithm ".concat(paramString);; paramString = new String("unknown digest algorithm ")) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  private final void b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length > c)
    {
      arrayOfByte = a.digest(paramArrayOfByte);
      a.reset();
    }
    b = new byte[c];
    d = new byte[c];
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (i >= arrayOfByte.length) {
        break;
      }
      b[i] = ((byte)(arrayOfByte[i] ^ 0x36));
      d[i] = ((byte)(arrayOfByte[i] ^ 0x5C));
      i += 1;
    }
    while (j < c)
    {
      b[j] = 54;
      d[j] = 92;
      j += 1;
    }
    a.update(b);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    a.update(paramArrayOfByte);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Object localObject = a();
    if ((paramBoolean) && (paramArrayOfByte.length < localObject.length))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(localObject, 0, arrayOfByte, 0, arrayOfByte.length);
      localObject = arrayOfByte;
    }
    for (;;)
    {
      return Arrays.equals(paramArrayOfByte, (byte[])localObject);
    }
  }
  
  public final byte[] a()
  {
    byte[] arrayOfByte = a.digest();
    a.reset();
    a.update(d);
    return a.digest(arrayOfByte);
  }
}

/* Location:
 * Qualified Name:     ion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */