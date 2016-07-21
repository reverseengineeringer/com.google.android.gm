import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import com.android.email.activity.setup.AccountSettingsFragment;
import com.android.mail.providers.Account;

public final class atf
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  public atf(AccountSettingsFragment paramAccountSettingsFragment) {}
  
  public final Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      return null;
    } while ((a.i == null) || (!a.i.a(4194304L)));
    return new CursorLoader(a.b, a.i.M, null, null, null, null);
  }
  
  public final void onLoaderReset(Loader<Cursor> paramLoader) {}
}

/* Location:
 * Qualified Name:     atf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */