import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public final class cca
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments().getString("message");
    return new AlertDialog.Builder(getActivity()).setMessage(paramBundle).setPositiveButton(buj.dx, new ccb(this)).create();
  }
}

/* Location:
 * Qualified Name:     cca
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */