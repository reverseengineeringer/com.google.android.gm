import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.apache.http.util.EncodingUtils;

public abstract class ddq
{
  @Deprecated
  public static final byte[] a;
  public static final byte[] b = EncodingUtils.getAsciiBytes("\r\n");
  public static final byte[] c = EncodingUtils.getAsciiBytes("\"");
  public static final byte[] d = EncodingUtils.getAsciiBytes("--");
  public static final byte[] e = EncodingUtils.getAsciiBytes("Content-Disposition: form-data; name=");
  public static final byte[] f = EncodingUtils.getAsciiBytes("Content-Type: ");
  public static final byte[] g = EncodingUtils.getAsciiBytes("; charset=");
  public static final byte[] h = EncodingUtils.getAsciiBytes("Content-Transfer-Encoding: ");
  private static final byte[] i;
  private byte[] j;
  
  static
  {
    byte[] arrayOfByte = EncodingUtils.getAsciiBytes("----------------314159265358979323846");
    a = arrayOfByte;
    i = arrayOfByte;
  }
  
  public static long a(ddq[] paramArrayOfddq, byte[] paramArrayOfByte)
  {
    if (paramArrayOfddq == null) {
      throw new IllegalArgumentException("Parts may not be null");
    }
    int k = 0;
    long l1 = 0L;
    while (k < paramArrayOfddq.length)
    {
      j = paramArrayOfByte;
      ddq localddq = paramArrayOfddq[k];
      if (localddq.a() < 0L) {}
      ByteArrayOutputStream localByteArrayOutputStream;
      for (long l2 = -1L; l2 < 0L; l2 = localByteArrayOutputStream.size() + localddq.a())
      {
        return -1L;
        localByteArrayOutputStream = new ByteArrayOutputStream();
        localddq.c(localByteArrayOutputStream);
        localddq.a(localByteArrayOutputStream);
        localddq.d(localByteArrayOutputStream);
        localddq.e(localByteArrayOutputStream);
        f(localByteArrayOutputStream);
        localByteArrayOutputStream.write(b);
      }
      l1 += l2;
      k += 1;
    }
    return d.length + l1 + paramArrayOfByte.length + d.length + b.length;
  }
  
  public static void a(OutputStream paramOutputStream, ddq[] paramArrayOfddq, byte[] paramArrayOfByte)
  {
    if (paramArrayOfddq == null) {
      throw new IllegalArgumentException("Parts may not be null");
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      throw new IllegalArgumentException("partBoundary may not be empty");
    }
    int k = 0;
    while (k < paramArrayOfddq.length)
    {
      j = paramArrayOfByte;
      ddq localddq = paramArrayOfddq[k];
      localddq.c(paramOutputStream);
      localddq.a(paramOutputStream);
      localddq.d(paramOutputStream);
      localddq.e(paramOutputStream);
      f(paramOutputStream);
      localddq.b(paramOutputStream);
      paramOutputStream.write(b);
      k += 1;
    }
    paramOutputStream.write(d);
    paramOutputStream.write(paramArrayOfByte);
    paramOutputStream.write(d);
    paramOutputStream.write(b);
  }
  
  private final void c(OutputStream paramOutputStream)
  {
    paramOutputStream.write(d);
    if (j == null) {}
    for (byte[] arrayOfByte = i;; arrayOfByte = j)
    {
      paramOutputStream.write(arrayOfByte);
      paramOutputStream.write(b);
      return;
    }
  }
  
  private final void d(OutputStream paramOutputStream)
  {
    String str = c();
    if (str != null)
    {
      paramOutputStream.write(b);
      paramOutputStream.write(f);
      paramOutputStream.write(EncodingUtils.getAsciiBytes(str));
      str = d();
      if (str != null)
      {
        paramOutputStream.write(g);
        paramOutputStream.write(EncodingUtils.getAsciiBytes(str));
      }
    }
  }
  
  private final void e(OutputStream paramOutputStream)
  {
    String str = e();
    if (str != null)
    {
      paramOutputStream.write(b);
      paramOutputStream.write(h);
      paramOutputStream.write(EncodingUtils.getAsciiBytes(str));
    }
  }
  
  private static void f(OutputStream paramOutputStream)
  {
    paramOutputStream.write(b);
    paramOutputStream.write(b);
  }
  
  public static boolean f()
  {
    return true;
  }
  
  protected abstract long a();
  
  protected void a(OutputStream paramOutputStream)
  {
    paramOutputStream.write(e);
    paramOutputStream.write(c);
    paramOutputStream.write(EncodingUtils.getAsciiBytes(b()));
    paramOutputStream.write(c);
  }
  
  public abstract String b();
  
  protected abstract void b(OutputStream paramOutputStream);
  
  public abstract String c();
  
  public abstract String d();
  
  public abstract String e();
  
  public String toString()
  {
    return b();
  }
}

/* Location:
 * Qualified Name:     ddq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */