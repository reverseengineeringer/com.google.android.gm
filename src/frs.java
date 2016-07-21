import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import java.io.FileInputStream;

public final class frs
{
  public static Bitmap a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null) {
      return null;
    }
    paramParcelFileDescriptor = new FileInputStream(paramParcelFileDescriptor.getFileDescriptor());
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(paramParcelFileDescriptor);
      return localBitmap;
    }
    finally
    {
      eow.a(paramParcelFileDescriptor);
    }
  }
}

/* Location:
 * Qualified Name:     frs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */