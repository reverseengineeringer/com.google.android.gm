import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Profile;

final class aud
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  private final Context b;
  
  public aud(auc paramauc, Context paramContext)
  {
    b = paramContext;
  }
  
  public final Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new CursorLoader(b, ContactsContract.Profile.CONTENT_URI, new String[] { "display_name" }, null, null, null);
  }
  
  public final void onLoaderReset(Loader<Cursor> paramLoader) {}
}

/* Location:
 * Qualified Name:     aud
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */