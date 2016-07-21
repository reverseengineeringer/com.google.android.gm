import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.google.android.gm.ads.AdTeaserView;
import com.google.android.gm.provider.Advertisement;

public final class dhj
  implements LoaderManager.LoaderCallbacks<ccy<Advertisement>>
{
  private boolean b = true;
  
  public dhj(AdTeaserView paramAdTeaserView) {}
  
  public final Loader<ccy<Advertisement>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    cvm.b("AdTeaserView", "Creating ads loader", new Object[0]);
    return new ccz(a.getContext(), a.f, dpy.m, Advertisement.O);
  }
  
  public final void onLoaderReset(Loader<ccy<Advertisement>> paramLoader) {}
}

/* Location:
 * Qualified Name:     dhj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */