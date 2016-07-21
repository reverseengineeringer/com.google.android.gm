import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import java.util.Locale;

final class dlj
  implements LoaderManager.LoaderCallbacks<String>
{
  dlj(dli paramdli) {}
  
  public final Loader<String> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    Activity localActivity = a.getActivity();
    String str = paramBundle.getString("gmailAccount");
    Object localObject = a;
    paramBundle = paramBundle.getString("pairUrl");
    localObject = getResourcesgetConfigurationlocale;
    paramBundle = Uri.parse(paramBundle).buildUpon();
    paramBundle.appendQueryParameter("gmlo", cxa.a((Locale)localObject));
    return new dgr(localActivity, str, paramBundle.build().toString());
  }
  
  public final void onLoaderReset(Loader<String> paramLoader) {}
}

/* Location:
 * Qualified Name:     dlj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */