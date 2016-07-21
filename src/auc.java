import android.app.Activity;
import android.app.LoaderManager;
import android.os.Bundle;
import android.text.method.TextKeyListener;
import android.text.method.TextKeyListener.Capitalize;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.provider.Account;

public final class auc
  extends ats
{
  public EditText a;
  public EditText b;
  private final int c = 0;
  private View d;
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getView();
    paramBundle = ((awp)getActivity()).l();
    int i = a;
    Account localAccount = b;
    if ((i != 4) && (i != 3))
    {
      String str = d;
      a.setText(str);
      a.setSelection(str.length());
    }
    if (!agetActivitym)
    {
      b.setVisibility(8);
      d.setVisibility(8);
    }
    do
    {
      return;
      if (k != null)
      {
        b.setText(k);
        return;
      }
    } while ((i == 4) || (i == 3));
    paramBundle = getActivity().getApplicationContext();
    if (cwm.a(paramBundle, "android.permission.READ_CONTACTS"))
    {
      getLoaderManager().initLoader(0, Bundle.EMPTY, new aud(this, paramBundle));
      bus.a("contacts_account_setup", "enabled");
      return;
    }
    bus.a("contacts_account_setup", "disabled");
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.p, arh.ay, true);
    a = ((EditText)paramLayoutInflater.findViewById(are.f));
    b = ((EditText)paramLayoutInflater.findViewById(are.Z));
    d = paramLayoutInflater.findViewById(are.aa);
    b.setKeyListener(TextKeyListener.getInstance(false, TextKeyListener.Capitalize.WORDS));
    a(4);
    return paramLayoutInflater;
  }
}

/* Location:
 * Qualified Name:     auc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */