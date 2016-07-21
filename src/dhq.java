import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.mail.providers.Account;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.GmailProvider;

final class dhq
  implements LoaderManager.LoaderCallbacks<ccy<Advertisement>>
{
  dhq(dhn paramdhn) {}
  
  public final Loader<ccy<Advertisement>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new ccz(a.j, GmailProvider.c(a.f.c, a.ad.e), dpy.o, Advertisement.O);
  }
  
  public final void onLoaderReset(Loader<ccy<Advertisement>> paramLoader)
  {
    a.ad = null;
  }
}

/* Location:
 * Qualified Name:     dhq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */