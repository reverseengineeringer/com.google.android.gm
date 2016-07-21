import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.os.Bundle;
import com.android.mail.providers.Attachment;

public final class bvq
  extends DialogFragment
{
  public Attachment a;
  public ProgressDialog b;
  private bvn c;
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    c = new bvn(getActivity());
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    b = null;
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("state", Integer.valueOf(0));
    c.a(a.e, localContentValues);
    super.onCancel(paramDialogInterface);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a = ((Attachment)getArguments().getParcelable("attachment"));
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    b = new ProgressDialog(getActivity());
    b.setTitle(buj.bR);
    b.setMessage(a.c);
    b.setProgressStyle(1);
    b.setIndeterminate(true);
    b.setMax(a.d);
    b.setProgressNumberFormat(null);
    return b;
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    b = null;
    super.onDismiss(paramDialogInterface);
  }
}

/* Location:
 * Qualified Name:     bvq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */