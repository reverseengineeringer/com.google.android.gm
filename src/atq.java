import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import com.android.email.activity.setup.AccountSetupFinal;

public final class atq
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  public atq(AccountSetupFinal paramAccountSetupFinal) {}
  
  public final Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new CursorLoader(a, cgr.b(), new String[] { "accountManagerName", "type", "name" }, null, null, null);
  }
  
  public final void onLoaderReset(Loader<Cursor> paramLoader)
  {
    a.f = null;
  }
}

/* Location:
 * Qualified Name:     atq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */