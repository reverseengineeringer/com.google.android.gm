import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public final class avo
  extends DialogFragment
{
  EditText a;
  AlertDialog b;
  
  public static avo a(String paramString, Uri paramUri, boolean paramBoolean)
  {
    avo localavo = new avo();
    Bundle localBundle = new Bundle(4);
    localBundle.putString("quick_response_edited_string", paramString);
    localBundle.putParcelable("quick_response_content_uri", paramUri);
    localBundle.putBoolean("quick_response_create", paramBoolean);
    localavo.setArguments(localBundle);
    return localavo;
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    Object localObject = (Uri)getArguments().getParcelable("quick_response_content_uri");
    boolean bool = getArguments().getBoolean("quick_response_create");
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("quick_response_edited_string");; paramBundle = null)
    {
      if (paramBundle == null) {
        paramBundle = getArguments().getString("quick_response_edited_string");
      }
      for (;;)
      {
        View localView = LayoutInflater.from(getActivity()).inflate(arf.B, null);
        a = ((EditText)localView.findViewById(are.aK));
        if (paramBundle != null) {
          a.setText(paramBundle);
        }
        a.setSelection(a.length());
        a.addTextChangedListener(new avp(this));
        paramBundle = new avq(this, bool, (Uri)localObject);
        localObject = new avr(this, (Uri)localObject);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
        localBuilder.setTitle(getResources().getString(arh.be)).setView(localView).setNegativeButton(17039360, null).setPositiveButton(arh.cp, paramBundle);
        if (!bool) {
          localBuilder.setNeutralButton(arh.ba, (DialogInterface.OnClickListener)localObject);
        }
        b = localBuilder.create();
        return b;
      }
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    if (a.length() == 0) {
      b.getButton(-1).setEnabled(false);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("quick_response_edited_string", a.getText().toString());
  }
}

/* Location:
 * Qualified Name:     avo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */