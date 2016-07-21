import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public final class eae
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    dismiss();
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments();
    Activity localActivity = getActivity();
    String str = localActivity.getString(paramBundle.getInt("message"));
    str = localActivity.getString(dge.gf, new Object[] { str });
    return new AlertDialog.Builder(localActivity).setPositiveButton(17039370, this).setTitle(paramBundle.getInt("title")).setMessage(str).create();
  }
}

/* Location:
 * Qualified Name:     eae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */