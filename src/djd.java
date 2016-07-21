import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;

public final class djd
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new ProgressDialog(getActivity());
    paramBundle.setIndeterminate(true);
    paramBundle.setMessage(getString(dge.bV));
    return paramBundle;
  }
}

/* Location:
 * Qualified Name:     djd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */