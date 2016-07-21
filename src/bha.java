import java.io.FilterInputStream;
import java.io.InputStream;

public final class bha
  extends FilterInputStream
{
  private StringBuilder a;
  private boolean b;
  private final String c;
  
  public bha(InputStream paramInputStream)
  {
    this(paramInputStream, "RAW");
  }
  
  private bha(InputStream paramInputStream, String paramString)
  {
    super(paramInputStream);
    c = String.valueOf(paramString).concat(" ");
    b = false;
    a();
    cvm.b(bbw.a, String.valueOf(c).concat("dump start"), new Object[0]);
  }
  
  private final void a()
  {
    a = new StringBuilder(c);
  }
  
  private final void a(int paramInt)
  {
    if (paramInt != 13)
    {
      if (paramInt == 10) {
        b();
      }
    }
    else {
      return;
    }
    if ((32 <= paramInt) && (paramInt <= 126))
    {
      a.append((char)paramInt);
      return;
    }
    StringBuilder localStringBuilder = a;
    String str = String.valueOf(bhn.a(paramInt));
    if (str.length() != 0) {}
    for (str = "\\x".concat(str);; str = new String("\\x"))
    {
      localStringBuilder.append(str);
      return;
    }
  }
  
  private final void b()
  {
    if ((b) || (a.length() > c.length()))
    {
      cvm.b(bbw.a, a.toString(), new Object[0]);
      a();
    }
  }
  
  public final void close()
  {
    super.close();
    b();
  }
  
  public final int read()
  {
    int i = super.read();
    a(i);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
    paramInt2 = i;
    while (paramInt2 > 0)
    {
      a(paramArrayOfByte[paramInt1] & 0xFF);
      paramInt2 -= 1;
      paramInt1 += 1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     bha
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */