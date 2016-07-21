import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.email.activity.setup.AccountSecurity;
import com.android.emailcommon.provider.Account;

public final class asl
  implements LoaderManager.LoaderCallbacks<Account>
{
  public asl(AccountSecurity paramAccountSecurity) {}
  
  public final Loader<Account> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    long l = paramBundle.getLong("ACCOUNT_ID", -1L);
    boolean bool1 = paramBundle.getBoolean("SHOW_DIALOG", false);
    boolean bool2 = paramBundle.getBoolean("EXPIRING", false);
    boolean bool3 = paramBundle.getBoolean("EXPIRED", false);
    return new ask(a.getApplicationContext(), l, bool1, bool2, bool3);
  }
  
  public final void onLoaderReset(Loader<Account> paramLoader) {}
}

/* Location:
 * Qualified Name:     asl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */