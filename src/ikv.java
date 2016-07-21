import java.util.Arrays;

public abstract class ikv
{
  final int e;
  
  public ikv(int paramInt)
  {
    e = imw.a("code", paramInt);
  }
  
  private final byte[] b()
  {
    ikt localikt = new ikt((byte)0);
    a(localikt);
    return localikt.a();
  }
  
  abstract String a();
  
  abstract void a(ikr paramikr);
  
  abstract void a(ikt paramikt);
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof ikv))) {}
    do
    {
      return false;
      paramObject = (ikv)paramObject;
    } while (e != e);
    return Arrays.equals(b(), ((ikv)paramObject).b());
  }
  
  public int hashCode()
  {
    int i = 0;
    byte[] arrayOfByte = b();
    int j = 0;
    while (i < arrayOfByte.length)
    {
      j += (j << 3) + (arrayOfByte[i] & 0xFF);
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    int i = e;
    localStringBuffer.append(ikw.a.c(i));
    localStringBuffer.append(": ");
    localStringBuffer.append(a());
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ikv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */