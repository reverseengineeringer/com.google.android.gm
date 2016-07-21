import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.mail.providers.Account;
import com.android.setupwizardlib.SetupWizardLayout;

public abstract class dkv
  extends Fragment
  implements View.OnClickListener
{
  public static final String a = cvl.a;
  public final String b;
  View c;
  Button d;
  Account e;
  private final int f;
  private View g;
  
  protected dkv(int paramInt, String paramString)
  {
    f = paramInt;
    b = paramString;
  }
  
  public SetupWizardLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = (SetupWizardLayout)paramLayoutInflater.inflate(b(), paramViewGroup, false);
    paramLayoutInflater.inflate(f, (FrameLayout)paramViewGroup.findViewById(dfy.aM));
    paramViewGroup.setHeaderText(a());
    c = paramViewGroup.findViewById(dfy.cm);
    d = ((Button)c.findViewById(dfy.co));
    d.setOnClickListener(this);
    d.setEnabled(false);
    g = c.findViewById(dfy.cn);
    g.setOnClickListener(this);
    e = ((Account)getActivity().getIntent().getParcelableExtra("account"));
    return paramViewGroup;
  }
  
  abstract CharSequence a();
  
  public final void a(int paramInt)
  {
    d.setText(getString(paramInt));
  }
  
  final void a(int paramInt, Object... paramVarArgs)
  {
    paramVarArgs = getString(paramInt, paramVarArgs);
    Object localObject = getView().findViewById(dfy.aN);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = (TextView)getView().findViewById(dfy.cc);
    ((TextView)localObject).setText(paramVarArgs);
    ((TextView)localObject).setVisibility(0);
    ((SetupWizardLayout)getView()).hideProgressBar();
    paramVarArgs = getView().findViewById(dfy.aQ);
    if (paramVarArgs != null) {
      paramVarArgs.setVisibility(8);
    }
    paramVarArgs = getActivity();
    if ((paramVarArgs instanceof dkd)) {
      ((dkd)paramVarArgs).a(getClass().getSimpleName());
    }
  }
  
  protected int b()
  {
    if (getActivitygetResourcesgetConfigurationscreenHeightDp < 600) {
      return dga.G;
    }
    return dga.H;
  }
  
  public final void b(String paramString)
  {
    ((dkd)getActivity()).a(b, paramString, 0L);
  }
  
  public final void b(boolean paramBoolean)
  {
    d.setEnabled(paramBoolean);
  }
  
  boolean g()
  {
    return false;
  }
  
  @Deprecated
  final String h()
  {
    if (e == null) {
      return null;
    }
    return e.c;
  }
  
  void i()
  {
    Activity localActivity = getActivity();
    if ((localActivity instanceof dkw)) {
      ((dkw)localActivity).c();
    }
  }
  
  public final void j()
  {
    g.setVisibility(4);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == dfy.cn)
    {
      getActivity().onBackPressed();
      return;
    }
    if (i == dfy.co)
    {
      i();
      return;
    }
    cvm.d(a, "GmailifyFragment. Clicked view is not handled %x", new Object[] { Integer.valueOf(i) });
  }
}

/* Location:
 * Qualified Name:     dkv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */