import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class aya
  extends axy
{
  final File f;
  private final int g;
  
  aya(aqs paramaqs)
  {
    g = a;
    f = File.createTempFile("imap", ".tmp", bce.a());
    FileOutputStream localFileOutputStream = new FileOutputStream(f);
    idc.a(paramaqs, localFileOutputStream);
    localFileOutputStream.close();
  }
  
  public final void c()
  {
    String str2;
    try
    {
      if ((!b) && (f.exists())) {
        f.delete();
      }
      super.c();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      str2 = bbw.a;
      str1 = String.valueOf(localRuntimeException.getMessage());
      if (str1.length() == 0) {}
    }
    for (String str1 = "Failed to remove temp file: ".concat(str1);; str1 = new String("Failed to remove temp file: "))
    {
      cvm.d(str2, str1, new Object[0]);
      break;
    }
  }
  
  public final String e()
  {
    d();
    try
    {
      byte[] arrayOfByte = idc.b(f());
      if (arrayOfByte.length > 2097152) {
        throw new IOException();
      }
    }
    catch (IOException localIOException)
    {
      cvm.d(bbw.a, "ImapTempFileLiteral: Error while reading temp file", new Object[] { localIOException });
      return "";
    }
    String str = bhn.a(bhn.b, localIOException);
    return str;
  }
  
  public final InputStream f()
  {
    d();
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(f);
      return localFileInputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      cvm.d(bbw.a, "ImapTempFileLiteral: Temp file not found", new Object[0]);
    }
    return new ByteArrayInputStream(new byte[0]);
  }
  
  protected final void finalize()
  {
    try
    {
      c();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final String toString()
  {
    return String.format("{%d byte literal(file)}", new Object[] { Integer.valueOf(g) });
  }
}

/* Location:
 * Qualified Name:     aya
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */