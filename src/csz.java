import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.mail.providers.Folder;
import com.android.mail.ui.teasers.NestedFolderTeaserView;

public final class csz
  implements LoaderManager.LoaderCallbacks<ccy<Folder>>
{
  public csz(NestedFolderTeaserView paramNestedFolderTeaserView) {}
  
  public final Loader<ccy<Folder>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = new ccz(a.getContext(), a.b, chh.j, Folder.y);
    paramBundle.setUpdateThrottle(a.h);
    return paramBundle;
  }
  
  public final void onLoaderReset(Loader<ccy<Folder>> paramLoader) {}
}

/* Location:
 * Qualified Name:     csz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */