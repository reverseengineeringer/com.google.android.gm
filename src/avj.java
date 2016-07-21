import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class avj
  extends Fragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private cfm a;
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = paramCompoundButton.getId();
    if (i == are.V)
    {
      a.a("enableStrictMode", paramBoolean);
      bhn.a(paramBoolean);
    }
    do
    {
      return;
      if (i == are.S)
      {
        a.a("enableAllInboxes", paramBoolean);
        return;
      }
      if (i == are.U)
      {
        a.a("enableRecyclerView", paramBoolean);
        Toast.makeText(getActivity(), arh.aZ, 0).show();
        return;
      }
      if (i == are.T)
      {
        a.a("enableMotionDrawer", paramBoolean);
        return;
      }
      if (i == are.W)
      {
        a.a("enableWebViewCompose", paramBoolean);
        return;
      }
      if (i == are.R)
      {
        a.a("enableAccountSetupLogoLanding", paramBoolean);
        return;
      }
    } while (i != are.Q);
    a.a("allowNonSystemPartnerProviderApp", paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == are.M) {
      paramView = new WebView(getActivity());
    }
    while (i != are.K) {
      try
      {
        paramView.clearCache(true);
        cvm.d(bbw.a, "Cleared WebView cache.", new Object[0]);
        return;
      }
      finally
      {
        paramView.destroy();
      }
    }
    cfm.a(getActivity()).e(0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (bbw.d) {
      cvm.b(bbw.a, "DebugFragment onCreateView", new Object[0]);
    }
    paramLayoutInflater = paramLayoutInflater.inflate(arf.y, paramViewGroup, false);
    a = cfm.a(getActivity());
    paramLayoutInflater.findViewById(are.M).setOnClickListener(this);
    paramLayoutInflater.findViewById(are.K).setOnClickListener(this);
    paramViewGroup = (CheckBox)paramLayoutInflater.findViewById(are.V);
    paramViewGroup.setChecked(a.d("enableStrictMode"));
    paramViewGroup.setOnCheckedChangeListener(this);
    paramViewGroup = (CheckBox)paramLayoutInflater.findViewById(are.S);
    paramViewGroup.setChecked(a.d("enableAllInboxes"));
    paramViewGroup.setOnCheckedChangeListener(this);
    paramViewGroup = (CheckBox)paramLayoutInflater.findViewById(are.Q);
    paramViewGroup.setChecked(a.d("allowNonSystemPartnerProviderApp"));
    paramViewGroup.setOnCheckedChangeListener(this);
    return paramLayoutInflater;
  }
}

/* Location:
 * Qualified Name:     avj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */