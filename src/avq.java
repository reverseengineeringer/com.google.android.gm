import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.widget.EditText;

final class avq
  implements DialogInterface.OnClickListener
{
  avq(avo paramavo, boolean paramBoolean, Uri paramUri) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = c.a.getText().toString();
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("quickResponse", paramDialogInterface);
    if (a)
    {
      c.getActivity().getContentResolver().insert(b, localContentValues);
      return;
    }
    c.getActivity().getContentResolver().update(b, localContentValues, null, null);
  }
}

/* Location:
 * Qualified Name:     avq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */