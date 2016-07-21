import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class bcq
  implements bcu
{
  final String a;
  
  public bcq(String paramString)
  {
    a = paramString;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream.write(Base64.encode(a.getBytes("UTF-8"), 4));
  }
  
  public final InputStream g_()
  {
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(a.getBytes("UTF-8"));
      return localByteArrayInputStream;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     bcq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */