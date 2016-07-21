import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import com.android.email.activity.setup.AccountServerSettingsActivity;

public final class ast
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = (AccountServerSettingsActivity)getActivity();
    return new AlertDialog.Builder(paramBundle).setIconAttribute(16843605).setTitle(17039380).setMessage(arh.p).setPositiveButton(17039370, new asu(this, paramBundle)).setNegativeButton(paramBundle.getString(17039360), null).create();
  }
}

/* Location:
 * Qualified Name:     ast
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */