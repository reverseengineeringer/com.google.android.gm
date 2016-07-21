import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.google.android.gm.ui.teasers.SectionedInboxTeaserView;

public final class dyl
  implements LoaderManager.LoaderCallbacks<ccy<Folder>>
{
  public dyl(SectionedInboxTeaserView paramSectionedInboxTeaserView) {}
  
  private final void a(int paramInt)
  {
    cvm.b(SectionedInboxTeaserView.d, "SectionedInboxTeaserView: Initializing section loader %d", new Object[] { Integer.valueOf(paramInt) });
    a.i.restartLoader(paramInt, null, a.l);
  }
  
  public final Loader<ccy<Folder>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = new ccz(a.getContext(), a.g.i, chh.i, Folder.y);
    paramBundle.setUpdateThrottle(a.k);
    return paramBundle;
  }
  
  public final void onLoaderReset(Loader<ccy<Folder>> paramLoader) {}
}

/* Location:
 * Qualified Name:     dyl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */