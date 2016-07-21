import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.android.email.activity.setup.AccountSettingsFragment;
import java.util.Map;

public final class ate
  implements LoaderManager.LoaderCallbacks<Map<String, Object>>
{
  private final Context b;
  
  public ate(AccountSettingsFragment paramAccountSettingsFragment, Context paramContext)
  {
    b = paramContext;
  }
  
  public final Loader<Map<String, Object>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new atd(b, paramBundle.getString("accountEmail"), paramBundle.getLong("accountId"));
  }
  
  public final void onLoaderReset(Loader<Map<String, Object>> paramLoader) {}
}

/* Location:
 * Qualified Name:     ate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */