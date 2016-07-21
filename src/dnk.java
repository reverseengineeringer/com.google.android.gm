import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public final class dnk
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments().getString("accountName");
    return new AlertDialog.Builder(getActivity()).setMessage(getString(dge.eT, new Object[] { paramBundle })).setNegativeButton(dge.bG, null).setPositiveButton(dge.eA, new dnl(this, paramBundle)).create();
  }
}

/* Location:
 * Qualified Name:     dnk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */