import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import java.io.FileNotFoundException;

final class mu
  extends AsyncTask<Uri, Boolean, Bitmap>
{
  mu(mt parammt, CancellationSignal paramCancellationSignal, PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback) {}
  
  private final Bitmap a()
  {
    try
    {
      Bitmap localBitmap = e.g.a(e.d, 3500);
      return localBitmap;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return null;
  }
  
  protected final void onPreExecute()
  {
    a.setOnCancelListener(new mv(this));
  }
}

/* Location:
 * Qualified Name:     mu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */