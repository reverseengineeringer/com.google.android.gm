import android.app.Dialog;
import android.app.DialogFragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.app.ProgressDialog;
import android.content.Loader;
import android.os.Bundle;
import android.os.Handler;

public final class diq
  extends DialogFragment
  implements LoaderManager.LoaderCallbacks<dbu>
{
  int a;
  boolean b;
  private final Handler c = new Handler();
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    ProgressDialog localProgressDialog = new ProgressDialog(getActivity());
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setMessage(getString(dge.fz));
    Bundle localBundle = getArguments();
    a = localBundle.getInt("numFiles");
    b = localBundle.getBoolean("showToast");
    localBundle = localBundle.getBundle("requestArgs");
    if (paramBundle != null)
    {
      getLoaderManager().initLoader(0, localBundle, this);
      return localProgressDialog;
    }
    getLoaderManager().restartLoader(0, localBundle, this);
    return localProgressDialog;
  }
  
  public final Loader<dbu> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new djy(getActivity(), paramBundle, new dbt());
  }
  
  public final void onLoaderReset(Loader<dbu> paramLoader) {}
}

/* Location:
 * Qualified Name:     diq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */