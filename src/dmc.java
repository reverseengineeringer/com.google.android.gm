import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.google.android.gm.gmailify.GmailifyUnlinkActivity;

public final class dmc
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      cvm.f(GmailifyUnlinkActivity.a, "GmailifyUnlink: Button not implemented: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    dismiss();
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new AlertDialog.Builder(getActivity()).setTitle(dge.db).setMessage(getArguments().getString("error-message")).setNeutralButton(17039370, this).create();
  }
}

/* Location:
 * Qualified Name:     dmc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */