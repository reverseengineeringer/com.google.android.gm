import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public abstract class gsu
{
  public abstract gsv a(OutputStream paramOutputStream, Charset paramCharset);
  
  public abstract gsy a(InputStream paramInputStream);
  
  public abstract gsy a(InputStream paramInputStream, Charset paramCharset);
  
  public abstract gsy a(String paramString);
  
  final String a(Object paramObject, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    gsv localgsv = a(localByteArrayOutputStream, gtq.a);
    if (paramBoolean) {
      localgsv.g();
    }
    localgsv.a(false, paramObject);
    localgsv.a();
    return localByteArrayOutputStream.toString("UTF-8");
  }
}

/* Location:
 * Qualified Name:     gsu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */