import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public final class csi
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private String[] a;
  private csj b;
  
  public final void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    b = ((csj)paramActivity);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b.p();
      return;
    case 1: 
      b.q();
      return;
    }
    b.r();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (getArguments().getBoolean("supportsNoEndDate"))
    {
      a = new String[] { getArguments().getString("endDate"), paramBundle.getString(buj.aQ), paramBundle.getString(buj.aT) };
      return;
    }
    a = new String[] { getArguments().getString("endDate"), paramBundle.getString(buj.aQ) };
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new AlertDialog.Builder(getActivity()).setTitle(buj.dF).setItems(a, this).create();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    b = null;
  }
}

/* Location:
 * Qualified Name:     csi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */