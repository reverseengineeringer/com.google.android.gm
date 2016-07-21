import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

final class bye
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  bye(byc parambyc) {}
  
  public final Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new CursorLoader(a.getActivity(), a.i, new String[] { "_display_name", "_size" }, null, null, null);
  }
  
  public final void onLoaderReset(Loader<Cursor> paramLoader) {}
}

/* Location:
 * Qualified Name:     bye
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */