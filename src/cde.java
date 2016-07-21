import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.mail.drawer.CurrentFolderDialogState;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import java.util.ArrayList;

public final class cde
  extends DialogFragment
  implements LoaderManager.LoaderCallbacks<cdg>, DialogInterface.OnClickListener, View.OnClickListener
{
  private View a;
  private EditText b;
  private TextView c;
  private CheckedTextView d;
  private TextView e;
  private CurrentFolderDialogState f;
  private String g;
  
  private final void a()
  {
    c.setVisibility(8);
    d.setVisibility(0);
  }
  
  private final void a(Folder paramFolder)
  {
    g = b.getText().toString();
    paramFolder = cob.a((Account)getArguments().getParcelable("account"), new ArrayList(), true, paramFolder, buc.cZ, new CurrentFolderDialogState(g, d, paramFolder, d.isChecked()));
    dismiss();
    paramFolder.show(getActivity().getFragmentManager(), null);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Toast.makeText(getActivity(), "Not yet implemented", 0).show();
    paramDialogInterface = b.getText().toString();
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("createFolderUri", getArguments().getParcelable("createFolderUri"));
    localBundle.putParcelable("dialogState", f);
    localBundle.putString("folderName", paramDialogInterface);
    getLoaderManager().initLoader(1, localBundle, this);
  }
  
  public final void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == buc.cR) {
      a();
    }
    do
    {
      return;
      if (i == buc.cZ)
      {
        if (d.isChecked())
        {
          f.d = false;
          f.b = null;
          f.c = null;
          d.setChecked(false);
          e.setVisibility(8);
          return;
        }
        paramView = new cgk();
        d = null;
        c = Uri.EMPTY;
        a(paramView.a());
        return;
      }
    } while (i != buc.dg);
    paramView = f.c;
    cgk localcgk = new cgk();
    d = f.b;
    a = a;
    c = c.b;
    a(localcgk.a());
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    f = ((CurrentFolderDialogState)getArguments().getParcelable("dialogState"));
    paramBundle = new aag(getActivity());
    a = LayoutInflater.from(a.a).inflate(bue.S, null);
    b = ((EditText)a.findViewById(buc.cp));
    c = ((TextView)a.findViewById(buc.cR));
    d = ((CheckedTextView)a.findViewById(buc.cZ));
    e = ((TextView)a.findViewById(buc.dg));
    c.setOnClickListener(this);
    d.setOnClickListener(this);
    if (f != null)
    {
      b.setText(f.a);
      b.setSelection(b.length());
      a();
      boolean bool = f.d;
      d.setChecked(bool);
      if (!bool) {
        break label254;
      }
      e.setText(f.b);
      e.setVisibility(0);
      e.setOnClickListener(this);
    }
    for (;;)
    {
      return paramBundle.a(buj.cN).a(a).b(buj.R, null).a(buj.en, this).a();
      label254:
      e.setVisibility(8);
    }
  }
  
  public final Loader<cdg> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new cdf(getActivity(), paramBundle);
  }
  
  public final void onLoaderReset(Loader<cdg> paramLoader) {}
}

/* Location:
 * Qualified Name:     cde
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */