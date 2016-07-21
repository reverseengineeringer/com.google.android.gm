import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.android.mail.providers.Attachment;
import com.android.mail.ui.AttachmentTileGrid;
import com.google.android.gm.ComposeActivityGmail;
import java.util.ArrayList;
import java.util.Collection;

public final class djq
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public static djq a(Bundle paramBundle)
  {
    djq localdjq = new djq();
    localdjq.setArguments(paramBundle);
    return localdjq;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      paramDialogInterface = (ComposeActivityGmail)getActivity();
      if (paramDialogInterface != null)
      {
        localObject = getArguments();
        if (!((Bundle)localObject).containsKey("attachment")) {
          break label71;
        }
        localObject = (Attachment)((Bundle)localObject).getParcelable("attachment");
        localArrayList = new ArrayList(r.b);
        localArrayList.add(localObject);
        paramDialogInterface.b(localArrayList);
      }
    }
    label71:
    while (!((Bundle)localObject).containsKey("attachments")) {
      return;
    }
    Object localObject = ((Bundle)localObject).getParcelableArrayList("attachments");
    ArrayList localArrayList = new ArrayList(r.b);
    localArrayList.addAll((Collection)localObject);
    paramDialogInterface.b(localArrayList);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity());
    paramBundle.setMessage(dge.bN).setTitle(dge.bP).setPositiveButton(dge.bO, this).setNegativeButton(dge.bG, null);
    return paramBundle.create();
  }
}

/* Location:
 * Qualified Name:     djq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */