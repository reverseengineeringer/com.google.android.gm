import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public final class cac
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new AlertDialog.Builder(getActivity()).setTitle(buj.eY).setMessage(buj.fa).setPositiveButton(buj.dx, new cae(this)).setNegativeButton(buj.eX, new cad(this)).create();
  }
}

/* Location:
 * Qualified Name:     cac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */