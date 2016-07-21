import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;

public final class csh
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      ((csg)getActivity()).o();
      return;
    }
    dismiss();
    buo.a().a("vacation_responder", "dont_discard", null, 0L);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new AlertDialog.Builder(getActivity()).setPositiveButton(buj.dx, this).setNegativeButton(buj.R, this).setMessage(getResources().getString(buj.bk)).create();
  }
}

/* Location:
 * Qualified Name:     csh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */