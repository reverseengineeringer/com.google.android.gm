import android.app.Dialog;
import android.app.DialogFragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.app.ProgressDialog;
import android.content.Loader;
import android.os.Bundle;
import android.os.Handler;

public final class dij
  extends DialogFragment
  implements LoaderManager.LoaderCallbacks<djw>
{
  private static final long[] a = { 100L, 250L, 500L, 1000L, 2000L, 3000L, 5000L, 10000L, 20000L };
  private final Handler b = new Handler();
  private final djv c = new djv();
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    ProgressDialog localProgressDialog = new ProgressDialog(getActivity());
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setMessage(getString(dge.fq));
    if (paramBundle != null)
    {
      getLoaderManager().initLoader(2, getArguments(), this);
      return localProgressDialog;
    }
    getLoaderManager().restartLoader(2, getArguments(), this);
    return localProgressDialog;
  }
  
  public final Loader<djw> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new djy(getActivity(), paramBundle, c);
  }
  
  public final void onLoaderReset(Loader<djw> paramLoader) {}
}

/* Location:
 * Qualified Name:     dij
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */