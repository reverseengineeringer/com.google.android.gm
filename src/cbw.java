import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public final class cbw
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new AlertDialog.Builder(getActivity()).setMessage(buj.ar).setPositiveButton(buj.bj, new cbx(this)).setNegativeButton(buj.R, null).create();
  }
}

/* Location:
 * Qualified Name:     cbw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */