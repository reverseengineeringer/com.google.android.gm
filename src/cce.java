import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import java.util.ArrayList;

public final class cce
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private boolean a;
  private ArrayList<String> b;
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1) {
      ((cbk)getActivity()).a(false, a, b);
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    int j = getArguments().getInt("messageId");
    a = getArguments().getBoolean("showToast");
    b = getArguments().getStringArrayList("recipients");
    if (j == buj.as) {}
    for (int i = buj.dx;; i = buj.eB) {
      return new AlertDialog.Builder(getActivity()).setMessage(j).setPositiveButton(i, this).setNegativeButton(buj.R, null).create();
    }
  }
}

/* Location:
 * Qualified Name:     cce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */