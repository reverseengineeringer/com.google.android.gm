import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.emailcommon.provider.Account;

final class ary
  implements LoaderManager.LoaderCallbacks<Boolean>
{
  public ary(ars paramars) {}
  
  public final Loader<Boolean> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    Account localAccount = (Account)paramBundle.getParcelable("account");
    boolean bool1 = paramBundle.getBoolean("email");
    boolean bool2 = paramBundle.getBoolean("calendar");
    boolean bool3 = paramBundle.getBoolean("contacts");
    boolean bool4 = paramBundle.getBoolean("enableNotifications");
    return new arz(this, a.b, localAccount, bool1, bool2, bool3, bool4);
  }
  
  public final void onLoaderReset(Loader<Boolean> paramLoader) {}
}

/* Location:
 * Qualified Name:     ary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */