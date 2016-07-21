import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public final class awa
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new AlertDialog.Builder(getActivity()).setTitle(getArguments().getInt("title")).setPositiveButton(17039370, new awb(this)).create();
  }
}

/* Location:
 * Qualified Name:     awa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */