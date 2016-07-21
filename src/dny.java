import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.google.android.gm.preference.LabelSettingsActivity;

public final class dny
  implements LoaderManager.LoaderCallbacks<dqg>
{
  public dny(LabelSettingsActivity paramLabelSettingsActivity) {}
  
  public final Loader<dqg> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("email");
    return new dnx(a, paramBundle);
  }
  
  public final void onLoaderReset(Loader<dqg> paramLoader) {}
}

/* Location:
 * Qualified Name:     dny
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */