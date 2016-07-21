import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public final class idc
{
  public static final char a = File.separatorChar;
  public static final String b;
  
  static
  {
    idg localidg = new idg((byte)0);
    PrintWriter localPrintWriter = new PrintWriter(localidg);
    localPrintWriter.println();
    b = localidg.toString();
    localPrintWriter.close();
  }
  
  public static int a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = b(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  private static long a(Reader paramReader, Writer paramWriter, char[] paramArrayOfChar)
  {
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramReader.read(paramArrayOfChar);
      if (-1 == i) {
        break;
      }
      paramWriter.write(paramArrayOfChar, 0, i);
    }
    return l;
  }
  
  public static String a(InputStream paramInputStream, String paramString)
  {
    return a(paramInputStream, idb.a(paramString));
  }
  
  private static String a(InputStream paramInputStream, Charset paramCharset)
  {
    idg localidg = new idg();
    a(new InputStreamReader(paramInputStream, idb.a(paramCharset)), localidg, new char['က']);
    return localidg.toString();
  }
  
  public static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  public static long b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte['က'];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    return l;
  }
  
  public static byte[] b(InputStream paramInputStream)
  {
    idf localidf = new idf();
    a(paramInputStream, localidf);
    return localidf.a();
  }
  
  public static String c(InputStream paramInputStream)
  {
    return a(paramInputStream, Charset.defaultCharset());
  }
}

/* Location:
 * Qualified Name:     idc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */