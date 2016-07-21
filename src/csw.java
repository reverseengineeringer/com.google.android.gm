import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;

final class csw
  implements LoaderManager.LoaderCallbacks<ccy<Folder>>
{
  csw(csu paramcsu) {}
  
  public final Loader<ccy<Folder>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new ccz(a.getContext(), a.d.i, chh.i, Folder.y);
  }
  
  public final void onLoaderReset(Loader<ccy<Folder>> paramLoader) {}
}

/* Location:
 * Qualified Name:     csw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */