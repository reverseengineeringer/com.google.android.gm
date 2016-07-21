import android.os.ParcelFileDescriptor;
import java.io.Closeable;
import java.io.IOException;

public final class eow
{
  public static void a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null) {}
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (IOException paramParcelFileDescriptor) {}
  }
  
  public static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
}

/* Location:
 * Qualified Name:     eow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */