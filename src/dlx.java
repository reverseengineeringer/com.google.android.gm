import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.android.setupwizardlib.SetupWizardLayout;
import java.util.Arrays;

public final class dlx
  extends dkv
  implements cto
{
  static final String f = cvm.a;
  private Spinner g;
  private LoaderManager.LoaderCallbacks<Boolean> h = new dlz(this);
  
  public dlx()
  {
    super(dga.M, "5-success");
  }
  
  public final SetupWizardLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = Arrays.asList(new String[] { getArguments().getString("gmailAddress"), getArguments().getString("pairedAddress") });
    paramViewGroup = new ArrayAdapter(getActivity(), 17367048, paramViewGroup);
    paramViewGroup.setDropDownViewResource(17367049);
    g = ((Spinner)paramLayoutInflater.findViewById(dfy.x));
    g.setAdapter(paramViewGroup);
    paramViewGroup = g;
    if (getArguments().getBoolean("isActiveGmailAccount")) {}
    for (int i = 0;; i = 1)
    {
      paramViewGroup.setSelection(i);
      return paramLayoutInflater;
    }
  }
  
  final CharSequence a()
  {
    return getString(dge.dn);
  }
  
  public final void a(boolean paramBoolean)
  {
    b("task_done");
    but localbut = buo.a();
    if (paramBoolean) {}
    for (long l = 1L;; l = 0L)
    {
      localbut.a("gmailify_success", "2-account_removed", null, l);
      b(true);
      return;
    }
  }
  
  final void i()
  {
    int i;
    if (g.getSelectedItemPosition() == 0)
    {
      i = 1;
      if (i == 0) {
        break label98;
      }
      buo.a().a("gmailify_success", "selected", "gmail", 0L);
    }
    for (String str = null;; str = (String)g.getSelectedItem())
    {
      Bundle localBundle = new Bundle(2);
      localBundle.putString("g6y-display-address", str);
      localBundle.putString("gmailAddress", getArguments().getString("gmailAddress"));
      AsyncTask.execute(new dlp(getActivity(), getArguments().getString("gmailAddress"), str));
      super.i();
      return;
      i = 0;
      break;
      label98:
      buo.a().a("gmailify_success", "selected", "third-party", 0L);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getLoaderManager().initLoader(5, getArguments(), h);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    j();
    a(17039370);
    d.postDelayed(new dly(this), 1000L);
  }
}

/* Location:
 * Qualified Name:     dlx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */