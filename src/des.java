import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import com.android.mail.providers.Account;
import com.google.android.gm.ComposeActivityGmail;
import com.google.android.gm.provider.GmailProvider;

public final class des
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  public des(ComposeActivityGmail paramComposeActivityGmail) {}
  
  public final Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new CursorLoader(a, GmailProvider.c(a.s.c, a.ad), dpy.n, null, null, null);
  }
  
  public final void onLoaderReset(Loader<Cursor> paramLoader)
  {
    a.ad = null;
  }
}

/* Location:
 * Qualified Name:     des
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */