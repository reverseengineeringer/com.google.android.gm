import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public final class auv
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  auw a;
  
  private final auw a()
  {
    if (a != null) {
      return a;
    }
    return (auw)getActivity();
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    a().b(false);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      dismiss();
      a().b(true);
      return;
    }
    paramDialogInterface.cancel();
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity();
    String str = getArguments().getString("redirectUri");
    setCancelable(true);
    return new AlertDialog.Builder(paramBundle).setIconAttribute(16843605).setTitle(arh.x).setMessage(paramBundle.getString(arh.w, new Object[] { str })).setPositiveButton(17039370, this).setNegativeButton(17039360, this).create();
  }
}

/* Location:
 * Qualified Name:     auv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */