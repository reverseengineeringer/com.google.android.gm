import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.google.android.gm.welcome.ChangeAddressActivity;

public final class eag
  implements LoaderManager.LoaderCallbacks<String>
{
  public eag(ChangeAddressActivity paramChangeAddressActivity) {}
  
  private final String a()
  {
    String str = Uri.parse(a.d).buildUpon().appendQueryParameter("continue", a.e).build().toString();
    dri.b(ChangeAddressActivity.a, "Loading Account Central / SFE from %s", new Object[] { str });
    return str;
  }
  
  public final Loader<String> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    paramBundle = a();
    return new dgr(a, a.b, paramBundle);
  }
  
  public final void onLoaderReset(Loader<String> paramLoader) {}
}

/* Location:
 * Qualified Name:     eag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */