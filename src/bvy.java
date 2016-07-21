import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public final class bvy
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public static bvy a(CharSequence paramCharSequence)
  {
    return a(null, paramCharSequence, buj.dx);
  }
  
  public static bvy a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    bvy localbvy = new bvy();
    Bundle localBundle = new Bundle(3);
    localBundle.putCharSequence("title", paramCharSequence1);
    localBundle.putCharSequence("message", paramCharSequence2);
    localBundle.putInt("primary_action", paramInt);
    localbvy.setArguments(localBundle);
    return localbvy;
  }
  
  private final void a(boolean paramBoolean)
  {
    but localbut;
    if (getArguments().getInt("primary_action") == buj.ft)
    {
      localbut = buo.a();
      if (!paramBoolean) {
        break label39;
      }
    }
    label39:
    for (String str = "confirm";; str = "cancel")
    {
      localbut.a("confirm_dialog", "unsubscribe", str, 0L);
      return;
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    a(false);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      a(true);
      DialogInterface.OnClickListener localOnClickListener = ((ckv)getActivity()).k().ad();
      if (localOnClickListener != null) {
        localOnClickListener.onClick(paramDialogInterface, paramInt);
      }
      return;
    }
    a(false);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity());
    Bundle localBundle = getArguments();
    paramBundle.setTitle(localBundle.getCharSequence("title")).setMessage(localBundle.getCharSequence("message")).setPositiveButton(localBundle.getInt("primary_action"), this).setNegativeButton(buj.R, this);
    return paramBundle.create();
  }
}

/* Location:
 * Qualified Name:     bvy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */