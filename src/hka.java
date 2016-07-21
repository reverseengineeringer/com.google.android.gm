import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class hka
{
  static final Logger a = Logger.getLogger(hka.class.getName());
  
  public static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      try
      {
        a.log(Level.WARNING, "IOException thrown while closing Closeable.", paramInputStream);
        return;
      }
      catch (IOException paramInputStream)
      {
        throw new AssertionError(paramInputStream);
      }
    }
  }
}

/* Location:
 * Qualified Name:     hka
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */