import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class dtt
{
  final hkb a;
  int b = 0;
  
  public dtt(InputStream paramInputStream)
  {
    a = new hkb(new BufferedInputStream(paramInputStream));
  }
  
  private final int a(int paramInt)
  {
    int j;
    if ((paramInt & 0x80) == 0)
    {
      j = paramInt;
      return j;
    }
    int i = paramInt & 0x7F;
    paramInt = 7;
    for (;;)
    {
      j = paramInt;
      if (paramInt >= 32) {
        break label87;
      }
      int k = a.read();
      if (k == -1) {
        throw new IOException("Invalid Protocol Buffer");
      }
      i |= (k & 0x7F) << paramInt;
      j = i;
      if ((k & 0x80) == 0) {
        break;
      }
      paramInt += 7;
    }
    label87:
    do
    {
      j += 7;
      if (j >= 64) {
        break;
      }
      paramInt = a.read();
      if (paramInt == -1) {
        throw new IOException("Invalid Protocol Buffer");
      }
    } while ((paramInt & 0x80) != 0);
    return i;
    throw new IOException("Invalid Protocol Buffer");
  }
  
  public final gyh a()
  {
    a.mark(20);
    long l = a.a;
    int i = a.read();
    if (i == -1) {
      return null;
    }
    a(i);
    i = a.read();
    if (i == -1) {
      throw new IOException("Invalid Protocol Buffer");
    }
    i = a(i);
    int j = (int)(a.a - l);
    a.reset();
    i = j + i;
    byte[] arrayOfByte = new byte[i];
    hjy.a(a, arrayOfByte, i);
    return (gyh)hlt.a(new gyh(), arrayOfByte, arrayOfByte.length);
  }
}

/* Location:
 * Qualified Name:     dtt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */