import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;

public class djf
  extends DialogFragment
{
  public void a()
  {
    dismissAllowingStateLoss();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new ProgressDialog(getActivity());
    paramBundle.setIndeterminate(true);
    paramBundle.setMessage(getString(dge.fq));
    return paramBundle;
  }
}

/* Location:
 * Qualified Name:     djf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */