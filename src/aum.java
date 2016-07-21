import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public final class aum
  extends DialogFragment
{
  auo a;
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity();
    a = new auo(this, paramBundle, ((aun)paramBundle).p());
    return new AlertDialog.Builder(paramBundle).setTitle(getString(arh.aS)).setAdapter(a, null).setPositiveButton(getString(arh.J), null).create();
  }
}

/* Location:
 * Qualified Name:     aum
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */