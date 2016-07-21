import java.io.InputStream;
import java.io.OutputStream;

public final class gue
{
  public static long a(guq paramguq)
  {
    gtn localgtn = new gtn();
    try
    {
      paramguq.a(localgtn);
      return a;
    }
    finally
    {
      localgtn.close();
    }
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
  {
    try
    {
      hbe.a(paramInputStream);
      hbe.a(paramOutputStream);
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      if (!paramBoolean) {
        return;
      }
    }
    finally
    {
      if (paramBoolean) {
        paramInputStream.close();
      }
    }
    paramInputStream.close();
  }
}

/* Location:
 * Qualified Name:     gue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */