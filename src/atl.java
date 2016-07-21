import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.android.email.view.CertificateSelector;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.utility.CertificateRequestor;
import java.io.IOException;

public final class atl
  extends ats
  implements View.OnClickListener, bbq
{
  EditText a;
  private boolean b;
  private String c;
  private TextInputLayout d;
  private CheckBox e;
  private TextWatcher f;
  private CertificateSelector g;
  private View h;
  private TextView i;
  
  public static atl a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    atl localatl = new atl();
    Bundle localBundle = new Bundle(5);
    localBundle.putString("email", paramString1);
    localBundle.putString("protocol", paramString2);
    localBundle.putString("certificate", paramString3);
    localBundle.putBoolean("passwordFailed", paramBoolean1);
    localBundle.putBoolean("standalone", paramBoolean2);
    localatl.setArguments(localBundle);
    return localatl;
  }
  
  public static void a(Context paramContext, HostAuth paramHostAuth, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("password");
    if (!TextUtils.isEmpty(str))
    {
      g = str;
      paramHostAuth.d();
      i = paramBundle.getString("certificate");
      return;
    }
    awj.a(paramContext).a(paramHostAuth, paramBundle);
  }
  
  private final String d()
  {
    return a.getText().toString();
  }
  
  public final void a()
  {
    if (!TextUtils.isEmpty(d())) {}
    for (boolean bool = true;; bool = false)
    {
      a_(bool);
      return;
    }
  }
  
  public final void a(Context paramContext)
  {
    if (cuh.a()) {
      paramContext = new Intent(paramContext, CertificateRequestor.class);
    }
    for (;;)
    {
      startActivityForResult(paramContext, 1000);
      return;
      paramContext = new Intent(getString(arh.bq));
      paramContext.setData(CertificateRequestor.a);
    }
  }
  
  public final void a(String paramString)
  {
    p = paramString;
    d.b(p);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = getString(arh.cc);; str = null)
    {
      a(str);
      return;
    }
  }
  
  public final Bundle c()
  {
    Bundle localBundle = new Bundle(2);
    localBundle.putString("password", d());
    localBundle.putString("certificate", g.a);
    return localBundle;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    int k = 0;
    super.onActivityCreated(paramBundle);
    b = ((atn)getActivity()).a();
    paramBundle = getActivity().getApplicationContext();
    String str = getArguments().getString("protocol");
    if (str != null)
    {
      paramBundle = bam.e(paramBundle, str);
      if (paramBundle == null) {}
    }
    for (boolean bool = k;; bool = true)
    {
      int j;
      if (bool)
      {
        paramBundle = g;
        if (b) {
          break label181;
        }
        j = 0;
        paramBundle.setVisibility(j);
        paramBundle = h;
        if (!bool) {
          break label187;
        }
        j = 0;
        label100:
        paramBundle.setVisibility(j);
        paramBundle = i;
        if (!bool) {
          break label193;
        }
        j = k;
        label117:
        paramBundle.setVisibility(j);
        paramBundle = "";
      }
      try
      {
        str = bbt.a(getActivity());
        paramBundle = str;
      }
      catch (IOException localIOException)
      {
        label181:
        label187:
        label193:
        for (;;) {}
      }
      i.setText(paramBundle);
      if (TextUtils.isEmpty(p)) {
        b(getArguments().getBoolean("passwordFailed"));
      }
      for (;;)
      {
        a();
        b(a);
        return;
        j = 8;
        break;
        j = 8;
        break label100;
        j = 8;
        break label117;
        a(p);
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1000)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("CertificateRequestor.alias");
        if (paramIntent != null) {
          g.a(paramIntent);
        }
        return;
      }
      cvm.e(cvm.a, "Unknown result from certificate request %d", new Object[] { Integer.valueOf(paramInt2) });
      return;
    }
    cvm.e(cvm.a, "Unknown request code for onActivityResult in AccountSetupBasics: %d", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public final void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == are.ab)
    {
      ((atn)getActivity()).e_();
      return;
    }
    if (j == are.H)
    {
      ((atn)getActivity()).onBackPressed();
      return;
    }
    super.onClick(paramView);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = getArguments().getBoolean("standalone");
    c = getArguments().getString("email");
    if (bool)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(arf.b, paramViewGroup, false);
      q = ((Button)paramLayoutInflater.findViewById(are.ab));
      q.setOnClickListener(this);
      r = ((Button)paramLayoutInflater.findViewById(are.H));
      r.setOnClickListener(this);
    }
    for (;;)
    {
      d = ((TextInputLayout)paramLayoutInflater.findViewById(are.aD));
      a = ((EditText)paramLayoutInflater.findViewById(are.aM));
      e = ((CheckBox)paramLayoutInflater.findViewById(are.aR));
      g = ((CertificateSelector)paramLayoutInflater.findViewById(are.N));
      h = paramLayoutInflater.findViewById(are.Y);
      i = ((TextView)paramLayoutInflater.findViewById(are.X));
      e.setOnCheckedChangeListener(new atm(this));
      g.b = this;
      g.a(getArguments().getString("certificate"));
      f = new ato(this);
      a.addTextChangedListener(f);
      return paramLayoutInflater;
      paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.j, c, true);
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if (a != null)
    {
      a.removeTextChangedListener(f);
      a = null;
    }
  }
}

/* Location:
 * Qualified Name:     atl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */