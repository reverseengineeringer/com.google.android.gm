import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import java.util.Calendar;

public final class cok
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    int i = Calendar.getInstance().get(1);
    paramBundle = getString(buj.aP, new Object[] { Integer.valueOf(i) });
    return new AlertDialog.Builder(getActivity()).setMessage(paramBundle).setNegativeButton(buj.R, null).create();
  }
}

/* Location:
 * Qualified Name:     cok
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */