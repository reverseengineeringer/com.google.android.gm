import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import com.google.android.apps.common.drive.aclfix.PotentialFix;
import com.google.android.gm.ComposeActivityGmail;
import com.google.android.gm.drive.aclfix.FixPermissionDialogState;
import java.util.ArrayList;
import java.util.Iterator;

public final class dix
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private PotentialFix a;
  private String b;
  private ArrayList<PotentialFix> c;
  private int d;
  private boolean e;
  private FixPermissionDialogState f;
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    ((ComposeActivityGmail)getActivity()).a(f, c, d, e);
    buo.a().a("acl_fixer", "outside_domain_dialog", "cancel", 0L);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      ((ComposeActivityGmail)getActivity()).a(a, b, e);
      buo.a().a("acl_fixer", "outside_domain_dialog", "confirm", 0L);
    }
    while (paramInt != -2) {
      return;
    }
    paramDialogInterface.cancel();
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    int i = 1;
    paramBundle = getActivity();
    Object localObject1 = getArguments();
    a = ((PotentialFix)((Bundle)localObject1).getParcelable("fix"));
    b = ((Bundle)localObject1).getString("role");
    f = ((FixPermissionDialogState)((Bundle)localObject1).getParcelable("dialogState"));
    c = ((Bundle)localObject1).getParcelableArrayList("potentialFixes");
    d = ((Bundle)localObject1).getInt("numFiles");
    e = ((Bundle)localObject1).getBoolean("showToast");
    Object localObject2 = a.g;
    localObject1 = paramBundle.getResources();
    int j = dgd.c;
    int k = d;
    mx localmx = mx.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject2 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localmx.a(str));
        break;
        localStringBuilder.append("<br>");
      }
    }
    localObject1 = Html.fromHtml(((Resources)localObject1).getQuantityString(j, k, new Object[] { localStringBuilder.toString() }));
    return new AlertDialog.Builder(paramBundle).setTitle(dge.cq).setMessage((CharSequence)localObject1).setPositiveButton(dge.fs, this).setNegativeButton(dge.bG, this).create();
  }
}

/* Location:
 * Qualified Name:     dix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */