import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;

final class dkz
  implements LoaderManager.LoaderCallbacks<String>
{
  dkz(dky paramdky) {}
  
  public final Loader<String> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new dgr(a.getActivity(), paramBundle.getString("gmailAddress"), paramBundle.getString("url"));
  }
  
  public final void onLoaderReset(Loader<String> paramLoader) {}
}

/* Location:
 * Qualified Name:     dkz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */