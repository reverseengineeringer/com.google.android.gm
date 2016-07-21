import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.mail.providers.Account;
import com.android.setupwizardlib.SetupWizardLayout;
import com.google.android.gm.gmailify.GmailifyOptInActivity;

public final class dlq
  extends dkv
  implements dkl
{
  public dlq()
  {
    super(dga.L, "2a-setup");
  }
  
  public final SetupWizardLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    cxe.a((TextView)paramLayoutInflater.findViewById(dfy.aR), dge.do, this, new CharSequence[0]);
    paramLayoutInflater.findViewById(dfy.aL).setOnClickListener(this);
    paramLayoutInflater.findViewById(dfy.aY).setOnClickListener(this);
    return paramLayoutInflater;
  }
  
  final CharSequence a()
  {
    return getString(dge.dj);
  }
  
  public final void a(deo<Account> paramdeo)
  {
    Activity localActivity = null;
    try
    {
      paramdeo = (Account)paramdeo.getItem(0);
      localActivity = getActivity();
      if ((localActivity instanceof dkx)) {
        ((dkx)localActivity).a(paramdeo);
      }
      if (paramdeo != null) {}
      for (boolean bool = true;; bool = false)
      {
        b(bool);
        return;
      }
    }
    catch (IndexOutOfBoundsException paramdeo)
    {
      for (;;)
      {
        paramdeo = localActivity;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == dfy.aR)
    {
      b("learn_more");
      dev.a(getActivity());
      new dyv().a(getActivity(), e, getActivity().getString(dge.cH), null);
    }
    do
    {
      return;
      if (i != dfy.aL) {
        break;
      }
      paramView = getActivity();
      if ((paramView instanceof dkx)) {
        ((dkx)paramView).a(null);
      }
    } while (!(paramView instanceof GmailifyOptInActivity));
    dma localdma = new dma();
    ((GmailifyOptInActivity)paramView).a(localdma);
    return;
    if (i == dfy.aY)
    {
      paramView = getActivity();
      dfh.a(paramView, Uri.parse(ghz.a(paramView.getContentResolver(), "gmail_terms_of_service_url", "https://www.google.com/policies/terms/")), true);
      return;
    }
    super.onClick(paramView);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new dki();
    paramBundle = new Bundle(3);
    paramBundle.putInt("max-accounts-displayed", 1);
    paramBundle.putBoolean("show-add-account", false);
    paramBundle.putBoolean("show-create-account", false);
    paramView.setArguments(paramBundle);
    getChildFragmentManager().beginTransaction().replace(dfy.aJ, paramView).commit();
    g = this;
  }
}

/* Location:
 * Qualified Name:     dlq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */