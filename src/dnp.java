import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

public final class dnp
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    startActivity(new Intent("android.settings.SETTINGS"));
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new aag(getActivity()).b(dge.em).a(dge.el, this).b(17039360, null).a();
  }
}

/* Location:
 * Qualified Name:     dnp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */