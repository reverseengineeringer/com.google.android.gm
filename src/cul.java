import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public final class cul
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public cum a;
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (a != null) {
      a.a(paramInt);
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new AlertDialog.Builder(getActivity()).setItems(getArguments().getInt("items"), this).setTitle(buj.f).create();
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (a != null) {
      a.a();
    }
  }
}

/* Location:
 * Qualified Name:     cul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */