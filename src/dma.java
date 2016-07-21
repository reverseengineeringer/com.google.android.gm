import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.mail.providers.Account;
import com.android.setupwizardlib.SetupWizardLayout;

public final class dma
  extends dkv
  implements dkg
{
  public dma()
  {
    super(dga.N, "2b-target");
  }
  
  public final SetupWizardLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    cxe.a((TextView)paramLayoutInflater.findViewById(dfy.aR), dge.do, this, new CharSequence[0]);
    return paramLayoutInflater;
  }
  
  final CharSequence a()
  {
    return getString(dge.dp);
  }
  
  public final void a(Account paramAccount)
  {
    if (paramAccount != null) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      ((dkx)getActivity()).a(paramAccount);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == dfy.aR)
    {
      dev.a(getActivity());
      new dyv().a(getActivity(), e, getActivity().getString(dge.cH), null);
      return;
    }
    super.onClick(paramView);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new dko();
    paramBundle = new Bundle(3);
    paramBundle.putInt("max-accounts-displayed", 0);
    paramBundle.putBoolean("show-add-account", true);
    paramBundle.putBoolean("show-create-account", true);
    paramView.setArguments(paramBundle);
    i = this;
    if (a != null) {
      ((dkf)a).a(this);
    }
    getChildFragmentManager().beginTransaction().replace(dfy.aJ, paramView).commit();
  }
}

/* Location:
 * Qualified Name:     dma
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */