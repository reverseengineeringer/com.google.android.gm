import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.android.email.activity.setup.MultilineSelectionGroup;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.provider.Account;

public final class avc
  extends ats
  implements avw
{
  public String a;
  public int b;
  public MultilineSelectionGroup c;
  public TextView d;
  
  private final boolean c()
  {
    return b == 2;
  }
  
  private final void d()
  {
    Button localButton = q;
    if (!c.b()) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  public final int a()
  {
    if (c()) {
      return arh.bd;
    }
    return arh.bf;
  }
  
  public final void e()
  {
    d();
  }
  
  public final void onClick(View paramView)
  {
    int i = paramView.getId();
    if (((avd)getActivity() != null) && (i == are.aW))
    {
      i = c.a;
      paramView = (avd)getActivity();
      if (paramView != null)
      {
        if (i == 0) {
          paramView.r();
        }
      }
      else {
        return;
      }
      paramView.s();
      return;
    }
    super.onClick(paramView);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      a = paramBundle.getString("CheckSettingsError.message");
      b = paramBundle.getInt("CheckSettingsError.exceptionId");
      return;
    }
    paramBundle = getArguments();
    a = paramBundle.getString("message");
    b = paramBundle.getInt("exceptionId");
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Activity localActivity = getActivity();
    boolean bool = c();
    paramBundle = getString(arh.I);
    if (localActivity != null) {
      paramBundle = lb.d;
    }
    paramViewGroup = a(paramLayoutInflater, paramViewGroup, arf.i, paramBundle, true);
    d = ((TextView)paramViewGroup.findViewById(are.am));
    d.setText(a);
    c = ((MultilineSelectionGroup)paramViewGroup.findViewById(are.an));
    c.c = this;
    c.a(false);
    c.a(paramLayoutInflater, 0, are.ai, arh.bg, a());
    c.a(paramLayoutInflater, 1, are.ax, arh.bQ, arh.bP);
    if (c.b())
    {
      paramLayoutInflater = c;
      if (!bool) {
        break label179;
      }
    }
    label179:
    for (int i = 1;; i = 0)
    {
      paramLayoutInflater.b(i);
      return paramViewGroup;
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("CheckSettingsError.message", a);
    paramBundle.putInt("CheckSettingsError.exceptionId", b);
  }
  
  public final void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    c.a();
    d();
  }
}

/* Location:
 * Qualified Name:     avc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */