import android.app.Activity;
import android.app.Fragment;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.setupwizardlib.SetupWizardLayout;

public class ats
  extends Fragment
  implements View.OnClickListener
{
  public int k;
  public cya l;
  public ScrollView m;
  public boolean n;
  public int o;
  public String p;
  public Button q;
  public View r;
  public TextView s;
  
  protected final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 > 0) {}
    for (String str = getString(paramInt2);; str = null) {
      return a(paramLayoutInflater, paramViewGroup, paramInt1, str, paramBoolean);
    }
  }
  
  protected final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = arf.v;; i = arf.o)
    {
      l = ((SetupWizardLayout)paramLayoutInflater.inflate(i, paramViewGroup, false));
      r = l.findViewById(are.aV);
      r.setOnClickListener(this);
      m = ((ScrollView)l.findViewById(are.aU));
      paramViewGroup = m;
      if (Build.VERSION.SDK_INT >= 21) {
        paramViewGroup.setOnApplyWindowInsetsListener(new cyp());
      }
      if (!TextUtils.isEmpty(paramString)) {
        b(paramString.replace("@", "​@").replace(".", "​."));
      }
      paramLayoutInflater.inflate(paramInt, (ViewGroup)l.findViewById(are.aQ), true);
      q = ((Button)l.findViewById(are.aW));
      q.setOnClickListener(this);
      return l;
    }
  }
  
  public final void a(int paramInt)
  {
    if (r != null) {
      r.setVisibility(paramInt);
    }
  }
  
  public void a_(boolean paramBoolean)
  {
    if (q != null) {
      q.setEnabled(paramBoolean);
    }
  }
  
  protected void b() {}
  
  public final void b(int paramInt)
  {
    q.setVisibility(paramInt);
  }
  
  public final void b(View paramView)
  {
    paramView.requestFocus();
    ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(paramView, 1);
  }
  
  public final void b(String paramString)
  {
    if ((l instanceof cxq))
    {
      TextView localTextView = (TextView)((cxq)l).findViewById(cxv.g);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
      return;
    }
    ((SetupWizardLayout)l).setHeaderText(paramString);
  }
  
  public boolean h()
  {
    return false;
  }
  
  public final void i()
  {
    if ((l instanceof cxq))
    {
      ((cxq)l).a(true);
      return;
    }
    ((SetupWizardLayout)l).setProgressBarShown(true);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    paramView = (atu)getActivity();
    if (i == are.aW) {
      paramView.e_();
    }
    do
    {
      return;
      if (i == are.aV)
      {
        paramView.onBackPressed();
        return;
      }
    } while (i != are.aS);
    b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      k = paramBundle.getInt("AccountSetupFragment.state");
      n = paramBundle.getBoolean("AccountSetupFragment.fromInterstitial");
      p = paramBundle.getString("AccountSetupFragment.errorMessage");
      o = paramBundle.getInt("AccountSetupFragment.errorReason");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("AccountSetupFragment.state", k);
    paramBundle.putBoolean("AccountSetupFragment.fromInterstitial", n);
    paramBundle.putString("AccountSetupFragment.errorMessage", p);
    paramBundle.putInt("AccountSetupFragment.errorReason", o);
  }
}

/* Location:
 * Qualified Name:     ats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */