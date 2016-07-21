import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EncodingUtils;

public final class ddn
  extends AbstractHttpEntity
{
  private static byte[] b = EncodingUtils.getAsciiBytes("-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
  public ddq[] a;
  private byte[] c;
  private HttpParams d;
  private boolean e = false;
  
  public ddn(ddq[] paramArrayOfddq)
  {
    setContentType("multipart/form-data");
    if (paramArrayOfddq == null) {
      throw new IllegalArgumentException("parts cannot be null");
    }
    a = paramArrayOfddq;
    d = null;
  }
  
  private final byte[] a()
  {
    Object localObject;
    if (c == null)
    {
      localObject = null;
      if (d != null) {
        localObject = (String)d.getParameter("http.method.multipart.boundary");
      }
      if (localObject == null) {
        break label48;
      }
    }
    label48:
    byte[] arrayOfByte;
    for (c = EncodingUtils.getAsciiBytes((String)localObject);; c = arrayOfByte)
    {
      return c;
      localObject = new Random();
      arrayOfByte = new byte[((Random)localObject).nextInt(11) + 30];
      int i = 0;
      while (i < arrayOfByte.length)
      {
        arrayOfByte[i] = b[localObject.nextInt(b.length)];
        i += 1;
      }
    }
  }
  
  public final InputStream getContent()
  {
    if ((!isRepeatable()) && (e)) {
      throw new IllegalStateException("Content has been consumed");
    }
    e = true;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ddq.a(localByteArrayOutputStream, a, c);
    return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
  }
  
  public final long getContentLength()
  {
    try
    {
      long l = ddq.a(a, a());
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public final Header getContentType()
  {
    StringBuffer localStringBuffer = new StringBuffer("multipart/form-data");
    localStringBuffer.append("; boundary=");
    localStringBuffer.append(EncodingUtils.getAsciiString(a()));
    return new BasicHeader("Content-Type", localStringBuffer.toString());
  }
  
  public final boolean isRepeatable()
  {
    int i = 0;
    while (i < a.length)
    {
      ddq.f();
      i += 1;
    }
    return true;
  }
  
  public final boolean isStreaming()
  {
    return false;
  }
  
  public final void writeTo(OutputStream paramOutputStream)
  {
    ddq.a(paramOutputStream, a, a());
  }
}

/* Location:
 * Qualified Name:     ddn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */