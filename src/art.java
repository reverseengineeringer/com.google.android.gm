import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.emailcommon.provider.Account;

final class art
  implements LoaderManager.LoaderCallbacks<Account>
{
  art(ars paramars) {}
  
  public final Loader<Account> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = (Account)paramBundle.getParcelable("account");
    return new aru(this, a.b, paramBundle);
  }
  
  public final void onLoaderReset(Loader<Account> paramLoader) {}
}

/* Location:
 * Qualified Name:     art
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */