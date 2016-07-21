import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import com.android.mail.providers.Folder;

final class cgp
  implements LoaderManager.LoaderCallbacks<ccy<Folder>>
{
  private final String[] b = chh.i;
  
  cgp(cgn paramcgn) {}
  
  public final Loader<ccy<Folder>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = Uri.parse(paramBundle.getString("FOLDER-URI"));
    return new ccz(a.b.g(), paramBundle, b, Folder.y);
  }
  
  public final void onLoaderReset(Loader<ccy<Folder>> paramLoader) {}
}

/* Location:
 * Qualified Name:     cgp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */