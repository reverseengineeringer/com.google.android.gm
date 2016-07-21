import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public final class ati
  extends ats
{
  public boolean a;
  private boolean b;
  private boolean c;
  private TextInputLayout d;
  private EditText e;
  private View f;
  private final TextView.OnEditorActionListener g = new atj(this);
  
  private final void b(boolean paramBoolean)
  {
    atu localatu = (atu)getActivity();
    a = paramBoolean;
    if ((localatu != null) && (bbn.a(c())))
    {
      localatu.e_();
      return;
    }
    cvm.e(cvm.a, "AccountSetupBasics: Proceed for invalid email, manualSetupSelected=%s", new Object[] { Boolean.valueOf(a) });
  }
  
  final void a()
  {
    if (!isAdded()) {
      return;
    }
    a_(bbn.a(c()));
  }
  
  public final void a(String paramString)
  {
    p = paramString;
    d.b(paramString);
  }
  
  public final void a_(boolean paramBoolean)
  {
    super.a_(paramBoolean);
    if (s != null) {
      s.setEnabled(paramBoolean);
    }
    f.setEnabled(paramBoolean);
  }
  
  protected final void b()
  {
    b(true);
  }
  
  public final String c()
  {
    return e.getText().toString().trim();
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    b(e);
  }
  
  public final void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == are.aW)
    {
      b(false);
      return;
    }
    if (i == are.aw)
    {
      b(true);
      return;
    }
    super.onClick(paramView);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c = getArguments().getBoolean("AccountSetupBasicsFragment.isBackEnabled");
    b = getArguments().getBoolean("AccountSetupBasicsFragment.isSetupWizardFlow");
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int j = 0;
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.h, arh.z, true);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(are.E);
    d = ((TextInputLayout)paramLayoutInflater.findViewById(are.h));
    e = ((EditText)paramLayoutInflater.findViewById(are.g));
    f = paramLayoutInflater.findViewById(are.aw);
    f.setOnClickListener(this);
    if (b)
    {
      paramViewGroup.setText(getString(arh.aU, new Object[] { getString(arh.aV) }));
      paramViewGroup.setVisibility(0);
    }
    paramViewGroup = f;
    if (b)
    {
      i = 8;
      paramViewGroup.setVisibility(i);
      paramViewGroup = new atk(this);
      e.setOnEditorActionListener(g);
      e.addTextChangedListener(paramViewGroup);
      if (!TextUtils.isEmpty(p)) {
        a(p);
      }
      if (!c) {
        break label205;
      }
    }
    label205:
    for (int i = j;; i = 8)
    {
      a(i);
      return paramLayoutInflater;
      i = 0;
      break;
    }
  }
  
  public final void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    a();
  }
}

/* Location:
 * Qualified Name:     ati
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */