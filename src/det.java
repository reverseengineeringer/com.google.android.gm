import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import com.google.android.gm.ComposeActivityGmail;

public final class det
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  public final Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new CursorLoader(a, cgy.a(a.s, "/saveTo/message", a.I), null, null, null, null);
  }
  
  public final void onLoaderReset(Loader<Cursor> paramLoader) {}
}

/* Location:
 * Qualified Name:     det
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */