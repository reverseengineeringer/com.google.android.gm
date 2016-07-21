import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import com.android.mail.providers.Folder;
import java.lang.ref.WeakReference;

public final class cnd
  extends DialogFragment
{
  WeakReference<cnf> a = null;
  private int b;
  private int c;
  
  public final void a(cnf paramcnf)
  {
    a = new WeakReference(paramcnf);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    b = getArguments().getInt("numConversations");
    c = getArguments().getInt("folderType");
    paramBundle = getResources().getQuantityString(buh.p, b, new Object[] { Integer.valueOf(b) });
    if (Folder.a(c, 64)) {}
    for (int i = buj.bE;; i = buj.bI) {
      return new AlertDialog.Builder(getActivity()).setTitle(i).setMessage(paramBundle).setNegativeButton(buj.R, null).setPositiveButton(buj.aW, new cne(this)).create();
    }
  }
}

/* Location:
 * Qualified Name:     cnd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */