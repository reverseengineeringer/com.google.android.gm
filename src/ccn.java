import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;

public final class ccn
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private int a;
  private cco b;
  
  public final void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof cco))
    {
      b = ((cco)paramActivity);
      return;
    }
    throw new ClassCastException(String.valueOf(paramActivity.toString()).concat(" must implement OnPriorityChangeListener"));
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 1: 
    default: 
      str = "normal";
      paramInt = 1;
    }
    for (;;)
    {
      buo.a().a("message_priority", "set_from_priority_dialog", str, 0L);
      b.e(paramInt);
      paramDialogInterface.dismiss();
      return;
      str = "high";
      paramInt = 2;
      continue;
      str = "low";
      paramInt = 0;
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    a = getArguments().getInt("priority");
    paramBundle = new AlertDialog.Builder(getActivity());
    paramBundle.setTitle(buj.dd);
    CharSequence[] arrayOfCharSequence = getResources().getTextArray(btw.e);
    int i;
    switch (a)
    {
    case 1: 
    default: 
      i = 1;
    }
    for (;;)
    {
      paramBundle.setSingleChoiceItems(arrayOfCharSequence, i, this);
      paramBundle.setNegativeButton(buj.R, null);
      return paramBundle.create();
      i = 0;
      continue;
      i = 2;
    }
  }
}

/* Location:
 * Qualified Name:     ccn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */