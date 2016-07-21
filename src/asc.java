import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.emailcommon.provider.Account;

final class asc
  implements LoaderManager.LoaderCallbacks<Account>
{
  asc(ars paramars) {}
  
  public final Loader<Account> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = (Account)paramBundle.getParcelable("account");
    return new asd(this, a.b, paramBundle);
  }
  
  public final void onLoaderReset(Loader<Account> paramLoader) {}
}

/* Location:
 * Qualified Name:     asc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */