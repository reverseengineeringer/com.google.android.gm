import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.text.Spanned;
import com.google.android.gm.provider.Promotion;
import com.google.android.gm.ui.teasers.PromoTeaserView;

public final class dyh
  implements LoaderManager.LoaderCallbacks<Spanned>
{
  public dyh(PromoTeaserView paramPromoTeaserView) {}
  
  public final Loader<Spanned> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new dyg(a.a, a.q.g);
  }
  
  public final void onLoaderReset(Loader<Spanned> paramLoader) {}
}

/* Location:
 * Qualified Name:     dyh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */