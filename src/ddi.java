import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.EncodingUtils;

public final class ddi
  extends ddr
{
  private static final byte[] i = EncodingUtils.getAsciiBytes("; filename=");
  private dds j;
  
  public ddi(String paramString1, dds paramdds, String paramString2)
  {
    super(paramString1, str, "ISO-8859-1", "binary");
    j = paramdds;
  }
  
  protected final long a()
  {
    return j.a();
  }
  
  protected final void a(OutputStream paramOutputStream)
  {
    super.a(paramOutputStream);
    String str = j.b();
    if (str != null)
    {
      paramOutputStream.write(i);
      paramOutputStream.write(c);
      paramOutputStream.write(EncodingUtils.getAsciiBytes(str));
      paramOutputStream.write(c);
    }
  }
  
  protected final void b(OutputStream paramOutputStream)
  {
    if (a() == 0L) {
      return;
    }
    byte[] arrayOfByte = new byte['က'];
    InputStream localInputStream = j.c();
    try
    {
      for (;;)
      {
        int k = localInputStream.read(arrayOfByte);
        if (k < 0) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, k);
      }
    }
    finally
    {
      localInputStream.close();
    }
  }
}

/* Location:
 * Qualified Name:     ddi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */