import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.net.Uri;
import android.widget.ListView;
import com.android.mail.providers.Folder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class azq
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, DialogInterface.OnMultiChoiceClickListener
{
  final AlertDialog a;
  final HashMap<Folder, Boolean> b;
  final cpx c;
  private final azp d;
  
  public azq(Context paramContext, Uri paramUri, azp paramazp, String paramString, boolean paramBoolean)
  {
    d = paramazp;
    b = new HashMap();
    paramazp = new AlertDialog.Builder(paramContext);
    paramazp.setTitle(paramString);
    paramazp.setPositiveButton(arh.bT, this);
    paramazp.setCancelable(paramBoolean);
    paramazp.setOnCancelListener(this);
    paramUri = paramContext.getContentResolver().query(paramUri, chh.i, null, null, null);
    try
    {
      c = new cpx();
      c.a(new azs(paramContext, paramUri, new HashSet(), arf.A));
      paramazp.setAdapter(c, this);
      paramUri.close();
      a = paramazp.create();
      return;
    }
    finally
    {
      paramUri.close();
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    d.b();
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      onClick(paramDialogInterface, paramInt, true);
      return;
    }
    paramDialogInterface = b.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!paramDialogInterface.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)paramDialogInterface.next();
    } while (!((Boolean)localEntry.getValue()).booleanValue());
    for (paramDialogInterface = (Folder)localEntry.getKey();; paramDialogInterface = null)
    {
      d.a(paramDialogInterface);
      return;
    }
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt, boolean paramBoolean)
  {
    paramDialogInterface = (cuq)c.getItem(paramInt);
    b.clear();
    b.put(a, Boolean.valueOf(true));
    a.getListView().setItemChecked(paramInt, false);
  }
}

/* Location:
 * Qualified Name:     azq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */