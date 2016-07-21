import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import com.android.email.activity.setup.AccountCredentials;
import com.android.email.activity.setup.AuthenticationView;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;

public final class auf
  extends asp
  implements CompoundButton.OnCheckedChangeListener, aus
{
  private boolean A;
  Spinner t;
  private TextView u;
  private EditText v;
  private AuthenticationView w;
  private EditText x;
  private EditText y;
  private Switch z;
  
  public static auf c(int paramInt)
  {
    auf localauf = new auf();
    localauf.setArguments(a(paramInt, false));
    return localauf;
  }
  
  private final int n()
  {
    if ((((Integer)t.getSelectedItem()).a).intValue() & 0x1) != 0) {
      return 465;
    }
    return 587;
  }
  
  public final void a()
  {
    u.setVisibility(8);
  }
  
  public final Loader<Boolean> e()
  {
    return new auj(a, g, c);
  }
  
  public final int f()
  {
    HostAuth localHostAuth = g.b.c(a);
    boolean bool = z.isChecked();
    a("outgoing_require_login", Boolean.toString(bool));
    if (bool) {
      localHostAuth.a(v.getText().toString().trim(), w.b());
    }
    for (;;)
    {
      String str = x.getText().toString().trim();
      try
      {
        i = Integer.parseInt(y.getText().toString().trim());
        a("outgoing_port", Integer.toString(i));
        int j = ((Integer)t.getSelectedItem()).a).intValue();
        a("outgoing_security", HostAuth.a(j));
        localHostAuth.a(this.i, str, i, j);
        h = null;
        return 4;
        localHostAuth.a(null, null);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int i = n();
          cvm.b(cvm.a, 44 + "Non-integer server port; using '" + i + "'", new Object[0]);
        }
      }
    }
  }
  
  public final void f_()
  {
    u.setVisibility(0);
    u.setText(p);
  }
  
  final void j()
  {
    boolean bool2 = true;
    if (!A) {
      return;
    }
    boolean bool1;
    if ((bhn.b(x)) && (bhn.a(y)))
    {
      bool1 = true;
      if ((!bool1) || (!z.isChecked())) {
        break label87;
      }
      if ((TextUtils.isEmpty(v.getText())) || (!w.a())) {
        break label82;
      }
      bool1 = bool2;
    }
    label82:
    label87:
    for (;;)
    {
      a(bool1);
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  final void k()
  {
    int i = n();
    y.setText(Integer.toString(i));
  }
  
  public final void l()
  {
    j();
  }
  
  public final void m()
  {
    String str = g.b.d(a).b;
    startActivityForResult(AccountCredentials.a(getActivity(), v.getText().toString(), str), 1);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    paramBundle = new ArrayAdapter(paramBundle, 17367048, new awq[] { new awq(Integer.valueOf(0), paramBundle.getString(arh.am)), new awq(Integer.valueOf(1), paramBundle.getString(arh.an)), new awq(Integer.valueOf(9), paramBundle.getString(arh.ao)), new awq(Integer.valueOf(2), paramBundle.getString(arh.ap)), new awq(Integer.valueOf(10), paramBundle.getString(arh.aq)) });
    paramBundle.setDropDownViewResource(17367049);
    t.setAdapter(paramBundle);
    Object localObject;
    if (!A)
    {
      paramBundle = g.b.c(a);
      if (!g.f)
      {
        paramBundle.a(g.c);
        bbn.a(a, paramBundle, g.d);
        localObject = g.c.split("@")[1];
        paramBundle.a(b, (String)localObject, -1, 0);
        g.f = true;
      }
      if ((e & 0x4) != 0)
      {
        localObject = f;
        if (localObject != null)
        {
          v.setText((CharSequence)localObject);
          z.setChecked(true);
        }
        boolean bool = awj.a(getActivity()).a();
        w.a(bool, paramBundle);
      }
      int i = e;
      awq.a(t, Integer.valueOf(i & 0xB));
      localObject = c;
      if (localObject != null) {
        x.setText((CharSequence)localObject);
      }
      i = d;
      if (i == -1) {
        break label413;
      }
      y.setText(Integer.toString(i));
    }
    for (;;)
    {
      localObject = Parcel.obtain();
      ((Parcel)localObject).writeParcelable(paramBundle, paramBundle.describeContents());
      ((Parcel)localObject).setDataPosition(0);
      e = ((HostAuth)((Parcel)localObject).readParcelable(HostAuth.class.getClassLoader()));
      ((Parcel)localObject).recycle();
      A = true;
      j();
      return;
      label413:
      k();
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      HostAuth localHostAuth = g.b.c(getActivity());
      bbn.a(a, localHostAuth, paramIntent.getExtras());
      w.a(true, localHostAuth);
    }
  }
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = g.b.c(a);
    w.a(true, paramCompoundButton);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      arl.a(getView(), are.A, i);
      arl.a(getView(), are.z, i);
      arl.a(getView(), are.G, i);
      j();
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      A = paramBundle.getBoolean("AccountSetupOutgoingFragment.loaded", false);
    }
    i = "smtp";
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i;
    if (c != 0)
    {
      i = 1;
      if (i == 0) {
        break label253;
      }
      paramLayoutInflater = paramLayoutInflater.inflate(arf.f, paramViewGroup, false);
      if ((c != 2) && (c != 3)) {
        break label270;
      }
      paramLayoutInflater.findViewById(are.aq).setVisibility(0);
    }
    label253:
    label270:
    for (;;)
    {
      u = ((TextView)paramLayoutInflater.findViewById(are.aO));
      v = ((EditText)paramLayoutInflater.findViewById(are.z));
      w = ((AuthenticationView)paramLayoutInflater.findViewById(are.G));
      x = ((EditText)paramLayoutInflater.findViewById(are.o));
      y = ((EditText)paramLayoutInflater.findViewById(are.l));
      z = ((Switch)paramLayoutInflater.findViewById(are.m));
      t = ((Spinner)paramLayoutInflater.findViewById(are.n));
      z.setOnCheckedChangeListener(this);
      if (i != 0) {
        w.d();
      }
      t.post(new aug(this));
      paramViewGroup = new aui(this);
      v.addTextChangedListener(paramViewGroup);
      x.addTextChangedListener(paramViewGroup);
      y.addTextChangedListener(paramViewGroup);
      y.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
      a(paramLayoutInflater);
      w.b = this;
      return paramLayoutInflater;
      i = 0;
      break;
      paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.t, arh.aF, false);
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    j();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("AccountSetupOutgoingFragment.loaded", A);
  }
}

/* Location:
 * Qualified Name:     auf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */