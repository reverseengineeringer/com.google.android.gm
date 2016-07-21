import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

public final class avk
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  long a;
  String b;
  long c;
  Uri d;
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AsyncTask.execute(new avl(this));
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    a = getArguments().getLong("mailboxId");
    b = getArguments().getString("mailboxName");
    c = getArguments().getLong("accountId");
    d = ((Uri)getArguments().getParcelable("updateFolderUri"));
    return new AlertDialog.Builder(getActivity()).setMessage(arh.bt).setPositiveButton(arh.ba, this).setNegativeButton(arh.bs, null).create();
  }
}

/* Location:
 * Qualified Name:     avk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */