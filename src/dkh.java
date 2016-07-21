import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.setupwizardlib.SetupWizardLayout;

public final class dkh
  extends dkv
{
  public dkh()
  {
    super(dga.E, "1-about");
  }
  
  public final SetupWizardLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    cxe.a((TextView)paramLayoutInflater.findViewById(dfy.aI), dge.cP, this, new CharSequence[0]);
    return paramLayoutInflater;
  }
  
  final CharSequence a()
  {
    return getString(dge.cQ);
  }
  
  protected final int b()
  {
    return dga.H;
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == dfy.aI)
    {
      b("learn_more");
      dev.a(getActivity());
      new dyv().a(getActivity(), e, getActivity().getString(dge.cv), null);
      return;
    }
    super.onClick(paramView);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(dge.dk);
    b(true);
    j();
  }
}

/* Location:
 * Qualified Name:     dkh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */