import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class axt
  extends axy
{
  private byte[] f;
  
  axt(aqs paramaqs)
  {
    f = new byte[a];
    int i = 0;
    while (i < f.length)
    {
      int j = paramaqs.read(f, i, f.length - i);
      if (j < 0) {
        break;
      }
      i += j;
    }
    if (i != f.length) {
      cvm.d(bbw.a, "", new Object[0]);
    }
  }
  
  public final void c()
  {
    f = null;
    super.c();
  }
  
  public final String e()
  {
    byte[] arrayOfByte = f;
    return bhn.a(bhn.b, arrayOfByte);
  }
  
  public final InputStream f()
  {
    return new ByteArrayInputStream(f);
  }
  
  public final String toString()
  {
    return String.format("{%d byte literal(memory)}", new Object[] { Integer.valueOf(f.length) });
  }
}

/* Location:
 * Qualified Name:     axt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */