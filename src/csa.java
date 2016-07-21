import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import java.util.List;

final class csa
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  csa(crz paramcrz) {}
  
  public final Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new CursorLoader(a, a.b, chh.i, null, null, null);
  }
  
  public final void onLoaderReset(Loader<Cursor> paramLoader)
  {
    a.e.clear();
  }
}

/* Location:
 * Qualified Name:     csa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */