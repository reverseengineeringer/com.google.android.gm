import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;

public final class dzd
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new AlertDialog.Builder(getActivity()).setPositiveButton(dge.eA, null).setMessage(getResources().getString(dge.gb)).create();
  }
}

/* Location:
 * Qualified Name:     dzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */