import android.util.Base64OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class bcg
  implements bcu
{
  File a;
  
  public final OutputStream a()
  {
    a = File.createTempFile("body", null, bce.a());
    a.deleteOnExit();
    return new FileOutputStream(a);
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    InputStream localInputStream = g_();
    paramOutputStream = new Base64OutputStream(paramOutputStream, 20);
    idc.a(localInputStream, paramOutputStream);
    paramOutputStream.close();
    a.delete();
  }
  
  public final InputStream g_()
  {
    try
    {
      bch localbch = new bch(this, new FileInputStream(a));
      return localbch;
    }
    catch (IOException localIOException)
    {
      throw new bdi(1, "Unable to open body", localIOException);
    }
  }
}

/* Location:
 * Qualified Name:     bcg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */