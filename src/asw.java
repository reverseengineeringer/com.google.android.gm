import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import com.android.mail.providers.Account;

final class asw
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  asw(asv paramasv, SimpleCursorAdapter paramSimpleCursorAdapter) {}
  
  public final Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new CursorLoader(b.getActivity(), b.a.H, chh.e, null, null, null);
  }
  
  public final void onLoaderReset(Loader<Cursor> paramLoader)
  {
    a.swapCursor(null);
  }
}

/* Location:
 * Qualified Name:     asw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */