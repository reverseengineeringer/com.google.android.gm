import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public final class bxx
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private String a;
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1) {
      ((ClipboardManager)getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a));
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    a = getArguments().getString("subject");
    return new AlertDialog.Builder(getActivity()).setMessage(a).setPositiveButton(buj.aE, this).setNegativeButton(buj.R, this).create();
  }
}

/* Location:
 * Qualified Name:     bxx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */