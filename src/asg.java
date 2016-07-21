import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.emailcommon.provider.Account;

final class asg
  implements LoaderManager.LoaderCallbacks<Boolean>
{
  asg(ase paramase) {}
  
  public final Loader<Boolean> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = (Account)paramBundle.getParcelable("account");
    return new asi(a.a, paramBundle);
  }
  
  public final void onLoaderReset(Loader<Boolean> paramLoader) {}
}

/* Location:
 * Qualified Name:     asg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */