import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.Toast;
import java.util.Collections;

public final class cry
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      paramDialogInterface = agetActivitye;
      paramDialogInterface.putStringSet("display_images", Collections.EMPTY_SET);
      paramDialogInterface.putStringSet("display_sender_images_patterns_set", Collections.EMPTY_SET);
      paramDialogInterface.apply();
      Toast.makeText(getActivity(), buj.eD, 0).show();
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new AlertDialog.Builder(getActivity()).setTitle(buj.ai).setMessage(buj.ah).setIconAttribute(16843605).setPositiveButton(buj.ag, this).setNegativeButton(buj.R, this).create();
  }
}

/* Location:
 * Qualified Name:     cry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */