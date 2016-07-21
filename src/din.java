import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import com.google.android.gm.browse.TrampolineActivity;

public final class din
  implements LoaderManager.LoaderCallbacks<Intent>
{
  public din(TrampolineActivity paramTrampolineActivity) {}
  
  public final Loader<Intent> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    String str = paramBundle.getString("plid");
    paramBundle = paramBundle.getString("account-name");
    return new dio(a, str, paramBundle);
  }
  
  public final void onLoaderReset(Loader<Intent> paramLoader) {}
}

/* Location:
 * Qualified Name:     din
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */