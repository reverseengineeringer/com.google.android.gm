import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.android.email.activity.setup.AccountCredentials;
import com.android.email.activity.setup.AuthenticationView;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.email.view.CertificateSelector;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.utility.CertificateRequestor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class atv
  extends asp
  implements aus, bbq
{
  private TextView A;
  private Spinner B;
  private CertificateSelector C;
  private View D;
  private View E;
  private EditText F;
  private int G;
  private TextWatcher H;
  private boolean I;
  private String J;
  private ban K;
  private boolean L;
  public Spinner t;
  private TextView u;
  private EditText v;
  private AuthenticationView w;
  private TextInputLayout x;
  private EditText y;
  private EditText z;
  
  private final int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return K.h;
    }
    return K.g;
  }
  
  public static atv b(int paramInt, boolean paramBoolean)
  {
    atv localatv = new atv();
    localatv.setArguments(a(paramInt, paramBoolean));
    return localatv;
  }
  
  private final boolean n()
  {
    return (((Integer)t.getSelectedItem()).a).intValue() & 0x1) != 0;
  }
  
  public final void a()
  {
    u.setVisibility(8);
  }
  
  public final void a(Context paramContext)
  {
    if (cuh.a()) {
      paramContext = new Intent(paramContext, CertificateRequestor.class);
    }
    for (;;)
    {
      paramContext.putExtra("CertificateRequestor.host", y.getText().toString().trim());
      try
      {
        paramContext.putExtra("CertificateRequestor.port", Integer.parseInt(z.getText().toString().trim()));
        startActivityForResult(paramContext, 0);
        return;
        paramContext = new Intent(getString(arh.bq));
        paramContext.setData(CertificateRequestor.a);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          cvm.b(cvm.a, "Couldn't parse port %s", new Object[] { z.getText() });
        }
      }
    }
  }
  
  public final boolean c()
  {
    boolean bool = false;
    int i;
    if ((B != null) && (B.getVisibility() == 0))
    {
      i = ((Integer)B.getSelectedItem()).a).intValue();
      if (G != i) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) || (super.c())) {
        bool = true;
      }
      return bool;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final void d()
  {
    G = g.b.d();
    super.d();
  }
  
  public final Loader<Boolean> e()
  {
    return new aty(a, g, c, L);
  }
  
  public final int f()
  {
    Object localObject2 = g.b;
    int i;
    Object localObject1;
    if (B.getVisibility() == 0)
    {
      i = ((Integer)B.getSelectedItem()).a).intValue();
      switch (i)
      {
      case 1: 
      default: 
        localObject1 = "unknown";
      }
    }
    for (;;)
    {
      a("incoming_delete_policy", (String)localObject1);
      ((Account)localObject2).a(i);
      localObject2 = ((Account)localObject2).d(a);
      localObject1 = v.getText().toString().trim();
      String str = w.b();
      if (!TextUtils.equals(str, g)) {
        L = true;
      }
      ((HostAuth)localObject2).a((String)localObject1, str);
      localObject1 = w.a;
      if ((localObject1 != null) && (!TextUtils.isEmpty(a)))
      {
        bgetActivityc = a;
        a("incoming_auth_type", "oauth");
        localObject1 = y.getText().toString().trim();
      }
      try
      {
        i = Integer.parseInt(z.getText().toString().trim());
        a("incoming_port", Integer.toString(i));
        int j = ((Integer)t.getSelectedItem()).a).intValue();
        a("incoming_security", HostAuth.a(j));
        ((HostAuth)localObject2).a(this.i, (String)localObject1, i, j);
        if (K.p)
        {
          localObject1 = F.getText().toString().trim();
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = null;
            h = ((String)localObject1);
            localObject1 = C.a;
            i = ((String)localObject1);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label503;
            }
            bool = true;
            a("incoming_has_client_cert", Boolean.toString(bool));
            return 2;
            localObject1 = "never";
            continue;
            localObject1 = "on_delete";
            continue;
            a("incoming_auth_type", "password");
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          boolean bool;
          i = b(n());
          cvm.b(cvm.a, 44 + "Non-integer server port; using '" + i + "'", new Object[0]);
          continue;
          localObject1 = String.valueOf(localObject1);
          if (((String)localObject1).length() != 0)
          {
            localObject1 = "/".concat((String)localObject1);
          }
          else
          {
            localObject1 = new String("/");
            continue;
            h = null;
            continue;
            label503:
            bool = false;
          }
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
    if (!I) {
      return;
    }
    if ((!TextUtils.isEmpty(v.getText())) && (w.a()) && (bhn.b(y)) && (bhn.a(z))) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      J = v.getText().toString().trim();
      return;
    }
  }
  
  final void k()
  {
    boolean bool = n();
    int i = b(bool);
    z.setText(Integer.toString(i));
    if (K.k)
    {
      if ((!bool) || (b)) {
        break label97;
      }
      i = 0;
    }
    for (;;)
    {
      C.setVisibility(i);
      try
      {
        String str1 = bbt.a(a);
        TextView localTextView = (TextView)getView().findViewById(are.X);
        localTextView.setText(str1);
        localTextView.setVisibility(i);
        D.setVisibility(i);
        return;
        label97:
        i = 8;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          String str2 = "";
        }
      }
    }
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
    C.b = this;
    paramBundle = getActivity();
    g = ((awp)paramBundle).l();
    Object localObject = g.b.d(a);
    String str;
    if (!g.e)
    {
      f = g.c;
      bbn.a(paramBundle, (HostAuth)localObject, g.d);
      str = g.c.split("@")[1];
      ((HostAuth)localObject).a(b, str, -1, 0);
      g.e = true;
    }
    K = g.a(paramBundle);
    if (K.n)
    {
      localObject = new ArrayAdapter(paramBundle, 17367048, new awq[] { new awq(Integer.valueOf(0), paramBundle.getString(arh.ak)), new awq(Integer.valueOf(2), paramBundle.getString(arh.aj)) });
      ((ArrayAdapter)localObject).setDropDownViewResource(17367049);
      B.setAdapter((SpinnerAdapter)localObject);
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new awq(Integer.valueOf(0), paramBundle.getString(arh.am)));
    ((ArrayList)localObject).add(new awq(Integer.valueOf(1), paramBundle.getString(arh.an)));
    ((ArrayList)localObject).add(new awq(Integer.valueOf(9), paramBundle.getString(arh.ao)));
    if (K.j)
    {
      ((ArrayList)localObject).add(new awq(Integer.valueOf(2), paramBundle.getString(arh.ap)));
      ((ArrayList)localObject).add(new awq(Integer.valueOf(10), paramBundle.getString(arh.aq)));
    }
    paramBundle = new ArrayAdapter(paramBundle, 17367048, (List)localObject);
    paramBundle.setDropDownViewResource(17367049);
    t.setAdapter(paramBundle);
    paramBundle = g.b;
    boolean bool1;
    label446:
    boolean bool2;
    label460:
    label489:
    label556:
    int i;
    if (paramBundle == null)
    {
      cvm.e(cvm.a, "AccountSetupIncomingFragment.disallowEditingForAppRestriction: null account", new Object[0]);
      paramBundle = g.b;
      if ((paramBundle != null) && (t != null)) {
        break label930;
      }
      localObject = cvm.a;
      if (paramBundle != null) {
        break label918;
      }
      bool1 = true;
      if ((paramBundle != null) && (t != null)) {
        break label924;
      }
      bool2 = true;
      cvm.e((String)localObject, "null account or host auth. account null: %b host auth null: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!I)
      {
        localObject = g.b;
        paramBundle = ((Account)localObject).d(a);
        K = g.a(getActivity());
        if ((!K.l) || (!awj.a(getActivity()).a())) {
          break label1039;
        }
        bool1 = true;
        w.a(bool1, paramBundle);
        str = f;
        if (str != null) {
          v.setText(str);
        }
        if (K.p)
        {
          str = h;
          if ((str != null) && (str.length() > 0)) {
            F.setText(str.substring(1));
          }
        }
        G = ((Account)localObject).d();
        awq.a(B, Integer.valueOf(G));
        int j = e;
        i = j;
        if (K.i) {
          i = j | 0x1;
        }
        awq.a(t, Integer.valueOf(i & 0xB));
        localObject = c;
        if (localObject != null) {
          y.setText((CharSequence)localObject);
        }
        i = d;
        if (i == -1) {
          break label1045;
        }
        z.setText(Integer.toString(i));
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(i)) {
        C.a(i);
      }
      localObject = Parcel.obtain();
      ((Parcel)localObject).writeParcelable(paramBundle, paramBundle.describeContents());
      ((Parcel)localObject).setDataPosition(0);
      f = ((HostAuth)((Parcel)localObject).readParcelable(HostAuth.class.getClassLoader()));
      ((Parcel)localObject).recycle();
      I = true;
      j();
      return;
      if ((j & 0x10000) != 0)
      {
        i = 1;
        label814:
        paramBundle = v;
        if (i != 0) {
          break label894;
        }
        bool1 = true;
        label826:
        paramBundle.setEnabled(bool1);
        paramBundle = y;
        if (i != 0) {
          break label900;
        }
        bool1 = true;
        label844:
        paramBundle.setEnabled(bool1);
        paramBundle = z;
        if (i != 0) {
          break label906;
        }
        bool1 = true;
        label862:
        paramBundle.setEnabled(bool1);
        paramBundle = t;
        if (i != 0) {
          break label912;
        }
      }
      label894:
      label900:
      label906:
      label912:
      for (bool1 = true;; bool1 = false)
      {
        paramBundle.setEnabled(bool1);
        break;
        i = 0;
        break label814;
        bool1 = false;
        break label826;
        bool1 = false;
        break label844;
        bool1 = false;
        break label862;
      }
      label918:
      bool1 = false;
      break label446;
      label924:
      bool2 = false;
      break label460;
      label930:
      this.i = t.b;
      x.a(getString(arh.aK));
      y.setContentDescription(getResources().getText(arh.aK));
      if (!K.p)
      {
        E.setVisibility(8);
        F.setVisibility(8);
      }
      if (K.n) {
        break label489;
      }
      A.setVisibility(8);
      B.setVisibility(8);
      z.setImeOptions(5);
      break label489;
      label1039:
      bool1 = false;
      break label556;
      label1045:
      k();
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("CertificateRequestor.alias");
      if (paramIntent != null) {
        C.a(paramIntent);
      }
    }
    while ((paramInt1 != 1) || (paramInt2 != -1)) {
      return;
    }
    HostAuth localHostAuth = g.b.d(getActivity());
    bbn.a(a, localHostAuth, paramIntent.getExtras());
    w.a(K.l, localHostAuth);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      J = paramBundle.getString("AccountSetupIncomingFragment.credential");
      I = paramBundle.getBoolean("AccountSetupIncomingFragment.loaded", false);
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i;
    if (c != 0)
    {
      i = 1;
      if (i == 0) {
        break label334;
      }
      paramLayoutInflater = paramLayoutInflater.inflate(arf.e, paramViewGroup, false);
      if ((c != 2) && (c != 3)) {
        break label351;
      }
      paramLayoutInflater.findViewById(are.aq).setVisibility(0);
    }
    label334:
    label351:
    for (;;)
    {
      u = ((TextView)paramLayoutInflater.findViewById(are.aO));
      v = ((EditText)paramLayoutInflater.findViewById(are.z));
      x = ((TextInputLayout)paramLayoutInflater.findViewById(are.q));
      y = ((EditText)paramLayoutInflater.findViewById(are.o));
      z = ((EditText)paramLayoutInflater.findViewById(are.l));
      t = ((Spinner)paramLayoutInflater.findViewById(are.n));
      A = ((TextView)paramLayoutInflater.findViewById(are.e));
      B = ((Spinner)paramLayoutInflater.findViewById(are.d));
      E = paramLayoutInflater.findViewById(are.as);
      F = ((EditText)paramLayoutInflater.findViewById(are.ar));
      w = ((AuthenticationView)paramLayoutInflater.findViewById(are.G));
      C = ((CertificateSelector)paramLayoutInflater.findViewById(are.N));
      D = paramLayoutInflater.findViewById(are.Y);
      if (i != 0) {
        w.d();
      }
      t.setOnItemSelectedListener(new atw(this));
      H = new atx(this);
      v.addTextChangedListener(H);
      y.addTextChangedListener(H);
      z.addTextChangedListener(H);
      z.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
      a(paramLayoutInflater);
      w.b = this;
      return paramLayoutInflater;
      i = 0;
      break;
      paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.k, arh.al, false);
    }
  }
  
  public final void onDestroyView()
  {
    if (v != null) {
      v.removeTextChangedListener(H);
    }
    v = null;
    x = null;
    if (y != null) {
      y.removeTextChangedListener(H);
    }
    y = null;
    if (z != null) {
      z.removeTextChangedListener(H);
    }
    z = null;
    if (t != null) {
      t.setOnItemSelectedListener(null);
    }
    t = null;
    A = null;
    B = null;
    E = null;
    F = null;
    D = null;
    C = null;
    super.onDestroyView();
  }
  
  public final void onResume()
  {
    super.onResume();
    j();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("AccountSetupIncomingFragment.credential", J);
    paramBundle.putBoolean("AccountSetupIncomingFragment.loaded", I);
  }
}

/* Location:
 * Qualified Name:     atv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */