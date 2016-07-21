import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

final class crw
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  crw(crv paramcrv) {}
  
  public final Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new CursorLoader(a, cgr.b(), chh.c, null, null, null);
  }
  
  public final void onLoaderReset(Loader<Cursor> paramLoader)
  {
    a.b = null;
    a.invalidateHeaders();
  }
}

/* Location:
 * Qualified Name:     crw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */