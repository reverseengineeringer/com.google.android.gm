package com.android.email.activity.setup;

import android.accounts.AccountAuthenticatorResponse;
import android.app.ActivityManager;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import aqv;
import aqx;
import aqy;
import arb;
import are;
import arf;
import arh;
import arm;
import arn;
import aro;
import arq;
import arr;
import ars;
import asb;
import ase;
import ash;
import asp;
import ass;
import ath;
import ati;
import atl;
import atn;
import atp;
import atq;
import ats;
import att;
import atu;
import atv;
import atz;
import aua;
import auc;
import aue;
import auf;
import auk;
import aul;
import aum;
import aun;
import auv;
import auw;
import avc;
import avd;
import avh;
import avi;
import avm;
import avn;
import avy;
import awi;
import awj;
import awk;
import awn;
import awq;
import bam;
import ban;
import bbn;
import bbo;
import bdi;
import buo;
import but;
import cfm;
import com.android.emailcommon.EmailProviderConfiguration;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.service.HostAuthCompat;
import cvl;
import cvm;
import cxd;
import cyl;
import cym;
import cyo;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

public class AccountSetupFinal
  extends ath
  implements arn, arr, asb, ash, ass, atn, atu, aul, aun, auw, avd, avn, awn
{
  public static final String b = cvl.a;
  private static String g;
  private EmailProviderConfiguration A;
  private boolean B;
  private boolean C;
  public int c = 1;
  public Handler d = new Handler();
  public boolean e = false;
  public Map<String, atp> f;
  private boolean h;
  private String i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private String n;
  private String[] o;
  private Stack<String> p = new Stack();
  private boolean q = false;
  private boolean r = false;
  private boolean s;
  private AccountAuthenticatorResponse t;
  private boolean u = false;
  private boolean v = false;
  private Bundle w;
  private String x;
  private int y;
  private String z;
  
  private final boolean A()
  {
    if (j)
    {
      y = 3;
      z = getString(arh.A);
      a(false, "cannot_add_google_account");
      return false;
    }
    n();
    return true;
  }
  
  private final void B()
  {
    View localView = getCurrentFocus();
    if (localView != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  private final boolean C()
  {
    String str1 = a.c;
    label415:
    label423:
    for (;;)
    {
      try
      {
        Object localObject2 = HostAuth.d(A.e);
        String str2 = HostAuth.d(A.i);
        com.android.emailcommon.provider.Account localAccount = null;
        String str3 = a.h;
        Object localObject1 = localAccount;
        if (bam.c(this, str3))
        {
          cvm.b(b, "ASF.finishAutoSetup incomingProtocol %s available", new Object[] { str3 });
          if (str3.equals(localObject2))
          {
            cvm.b(b, "ASF.finishAutoSetup primaryProtocol matches incomingProtocol", new Object[0]);
            A.a(str1);
            localObject1 = bam.e(this, (String)localObject2);
          }
        }
        else
        {
          if (localObject1 != null) {
            break label423;
          }
          if (!bam.c(this, (String)localObject2)) {
            continue;
          }
          cvm.b(b, "ASF.finishAutoSetup using primaryProtocol", new Object[0]);
          A.a(str1);
          localObject1 = bam.e(this, (String)localObject2);
          localAccount = a.b;
          localObject2 = localAccount.d(this);
          ((HostAuth)localObject2).b(A.m);
          ((HostAuth)localObject2).a(A.n);
          if ((e & 0x1) == 0) {
            break label415;
          }
          i1 = h;
          d = i1;
          if (m)
          {
            localObject1 = localAccount.c(this);
            ((HostAuth)localObject1).b(A.o);
            ((HostAuth)localObject1).a(A.p);
          }
          j(str1);
          localObject1 = h(str1);
          if (localObject1 == null) {
            break;
          }
          i((String)localObject1);
          return false;
        }
        if (str3.equals(str2))
        {
          cvm.b(b, "ASF.finishAutoSetup alternateProtocol matches incomingProtocol", new Object[0]);
          A.b(str1);
          localObject1 = bam.e(this, str2);
          continue;
        }
        cvm.b(b, "ASF.finishAutoSetup no protocol matches incomingProtocol. mUseLogoLanding: %s", new Object[] { Boolean.valueOf(l) });
        localObject1 = localAccount;
        if (!l) {
          continue;
        }
        return true;
        if (bam.c(this, str2))
        {
          cvm.b(b, "ASF.finishAutoSetup using alternateProtocol", new Object[0]);
          A.b(str1);
          localObject1 = bam.e(this, str2);
          continue;
        }
        Log.wtf(b, "ASF.finishAutoSetup No valid EmailServiceInfo found");
        return true;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        e = false;
        v = true;
        return true;
      }
      int i1 = g;
    }
    return true;
  }
  
  private final void D()
  {
    Fragment localFragment = getFragmentManager().findFragmentByTag("AccountCheckStgFrag");
    getFragmentManager().beginTransaction().remove(localFragment).commit();
  }
  
  private final boolean E()
  {
    return p.contains("CheckSettingsIncoming");
  }
  
  private final void F()
  {
    try
    {
      asp localasp = (asp)o();
      localasp.a(z);
      if ((!TextUtils.isEmpty(z)) && (m != null)) {
        m.getViewTreeObserver().addOnGlobalLayoutListener(new att(localasp));
      }
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      cvm.d(b, "AccountSetupFinal.showErrorInServerSettings(): Can't show error, not on the incoming/outgoing server fragment anymore", new Object[0]);
    }
  }
  
  private final void G()
  {
    q = true;
    com.android.emailcommon.provider.Account localAccount = a.b;
    if (t == null) {
      throw new IllegalStateException("in AccountSetupOptions with null mHostAuthRecv");
    }
    Object localObject3 = a.a(this);
    i1 = j & 0xFEFF;
    Object localObject1;
    Object localObject2;
    boolean bool4;
    boolean bool3;
    boolean bool1;
    boolean bool2;
    if (j)
    {
      localObject1 = Integer.valueOf(z);
      localObject2 = Integer.valueOf(s);
      bool4 = true;
      bool3 = v;
      bool1 = u;
      bool2 = true;
      c = d;
      localObject3 = localAccount.d(this);
      i2 = i1;
      if (!r)
      {
        i2 = i1;
        if (b.equals(getString(arh.ck)))
        {
          i2 = i1;
          if (l != null) {
            a("eas_version", l);
          }
        }
      }
    }
    try
    {
      double d1 = Double.parseDouble(l);
      i2 = i1;
      if (d1 >= 12.0D) {
        i2 = i1 | 0x1880;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        aue localaue;
        cvm.f(cvm.a, localNumberFormatException, "Exception thrown parsing the protocol version.", new Object[0]);
        i2 = i1;
        continue;
        boolean bool5 = false;
      }
    }
    j = i2;
    if (localObject1 != null) {
      g = ((Integer)localObject1).intValue();
    }
    if (localObject2 != null) {
      f = ((Integer)localObject2).intValue();
    }
    if (a.a() != null)
    {
      j |= 0x20;
      v = a.a();
    }
    if (a.a() != null)
    {
      bool5 = true;
      a("has_security_policy", Boolean.toString(bool5));
      bool5 = j;
      localObject2 = A;
      localObject1 = new Bundle(5);
      ((Bundle)localObject1).putParcelable("account", localAccount);
      ((Bundle)localObject1).putBoolean("email", bool4);
      ((Bundle)localObject1).putBoolean("calendar", bool3);
      ((Bundle)localObject1).putBoolean("contacts", bool1);
      ((Bundle)localObject1).putBoolean("enableNotifications", bool2);
      ((Bundle)localObject1).putBoolean("isSetupWizardFlow", bool5);
      ((Bundle)localObject1).putParcelable("provider", (Parcelable)localObject2);
      localObject2 = new ars();
      ((ars)localObject2).setArguments((Bundle)localObject1);
      localObject1 = getFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject1).add((Fragment)localObject2, "AccountCreationFragment");
      ((FragmentTransaction)localObject1).commit();
      u();
      return;
      localaue = (aue)o();
      if (localaue == null) {
        throw new IllegalStateException("Fragment missing");
      }
      localaue.a_(false);
      if (w) {
        if (g.isChecked())
        {
          a("background_attachments", "enabled");
          i1 |= 0x100;
          label501:
          localObject1 = (awq)a.getSelectedItem();
          if (localObject1 != null) {
            break label706;
          }
          localObject1 = null;
          label522:
          if (localObject1 != null) {
            a("check_frequency", ((Integer)localObject1).toString());
          }
          if (b.getVisibility() == 0) {
            break label719;
          }
          localObject2 = null;
          label553:
          if (localObject2 != null) {
            a("sync_window", ((Integer)localObject2).toString());
          }
          bool4 = f.isChecked();
          a("sync_email", Boolean.toString(bool4));
          if ((!v) || (!e.isChecked())) {
            break label741;
          }
          bool2 = true;
          label614:
          a("sync_calendar", Boolean.toString(bool2));
          if ((!u) || (!d.isChecked())) {
            break label747;
          }
        }
      }
      label706:
      label719:
      label741:
      label747:
      for (bool1 = true;; bool1 = false)
      {
        a("sync_contacts", Boolean.toString(bool1));
        bool5 = c.isChecked();
        a("enable_notifications", Boolean.toString(bool5));
        bool3 = bool2;
        bool2 = bool5;
        break;
        a("background_attachments", "disabled");
        break label501;
        localObject1 = (Integer)a;
        break label522;
        localObject2 = (Integer)b.getSelectedItem()).a;
        break label553;
        bool2 = false;
        break label614;
      }
    }
  }
  
  private final void H()
  {
    Fragment localFragment = getFragmentManager().findFragmentByTag("AccountCreationFragment");
    if (localFragment == null) {
      cvm.e(cvm.a, "Couldn't find AccountCreationFragment to destroy", new Object[0]);
    }
    for (;;)
    {
      q = false;
      return;
      getFragmentManager().beginTransaction().remove(localFragment).commit();
    }
  }
  
  private final void I()
  {
    q = true;
    ((ats)o()).a_(false);
    Object localObject1 = a.b;
    if (j) {
      c = d;
    }
    for (;;)
    {
      c = 16;
      Object localObject2 = new ase();
      Object localObject3 = new Bundle(1);
      ((Bundle)localObject3).putParcelable("account", (Parcelable)localObject1);
      ((ase)localObject2).setArguments((Bundle)localObject3);
      localObject1 = getFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject1).add((Fragment)localObject2, "AccountFinalizeFragment");
      ((FragmentTransaction)localObject1).commit();
      return;
      localObject2 = (auc)o();
      localObject3 = a.getText().toString().trim();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        c = ((String)localObject3);
      }
      k = b.getText().toString().trim();
    }
  }
  
  private final void J()
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    if (a != null) {
      localFragmentTransaction.remove(a);
    }
    a = new SetupDataFragment();
    localFragmentTransaction.add(a, "setupData");
    localFragmentTransaction.commit();
    a.i = null;
    a.a = -1;
  }
  
  private final void a(boolean paramBoolean, String paramString)
  {
    Object localObject;
    int i1;
    if (j) {
      if (E())
      {
        while ((!"CheckSettingsPreconfig".equals(p.peek())) && (!"CheckSettingsAutodiscover".equals(p.peek()))) {
          p.pop();
        }
        g("CheckSettingsError");
        localObject = (avc)o();
        a = z;
        d.setText(a);
        b = y;
        MultilineSelectionGroup localMultilineSelectionGroup = c;
        int i2 = are.ai;
        int i3 = ((avc)localObject).a();
        localObject = d;
        int i4 = localObject.length;
        i1 = 0;
        if (i1 < i4)
        {
          localMultilineSelectionGroup = localObject[i1];
          if ((localMultilineSelectionGroup == null) || (localMultilineSelectionGroup.getId() != i2)) {
            break label186;
          }
          ((TextView)localMultilineSelectionGroup.findViewById(are.aA)).setText(i3);
        }
      }
    }
    for (;;)
    {
      l(paramString);
      return;
      label186:
      i1 += 1;
      break;
      p.clear();
      J();
      g("AccountSetupLanding");
      localObject = (arm)o();
      ((arm)localObject).a(z, y);
      ((arm)localObject).c();
      continue;
      if (paramBoolean)
      {
        if (E())
        {
          while ((!"CheckSettingsIncoming".equals(p.peek())) && (!"CheckSettingsOutgoing".equals(p.peek()))) {
            p.pop();
          }
          f((String)p.pop());
          F();
        }
        else
        {
          p.clear();
          d("create_account_failed").a(z);
        }
      }
      else
      {
        onBackPressed();
        F();
      }
    }
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (j)
    {
      if ((paramBoolean2) || (cxd.f())) {
        setResult(0);
      }
    }
    else
    {
      finish();
      return;
    }
    if (paramBoolean1) {}
    for (int i1 = 1;; i1 = -1)
    {
      Intent localIntent1 = getIntent();
      Intent localIntent2 = new Intent("com.android.wizard.NEXT");
      localIntent2.putExtra("wizardBundle", localIntent1.getBundleExtra("wizardBundle"));
      localIntent2.putExtra("firstRun", localIntent1.getBooleanExtra("firstRun", false));
      localIntent2.putExtra("scriptUri", localIntent1.getStringExtra("scriptUri"));
      localIntent2.putExtra("actionId", localIntent1.getStringExtra("actionId"));
      localIntent2.putExtra("com.android.setupwizard.ResultCode", i1);
      localIntent2.putExtra("theme", localIntent1.getStringExtra("theme"));
      startActivityForResult(localIntent2, i1);
      if (c == 0) {
        break;
      }
      finish();
      return;
    }
  }
  
  private final void b(int paramInt)
  {
    aro localaro = aro.a(paramInt, w);
    getFragmentManager().beginTransaction().add(localaro, "AccountCheckStgFrag").commit();
    if ((paramInt == 8) && (w != null)) {
      w = null;
    }
  }
  
  private final void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getParcelableArrayExtra("accounts");
    if (paramIntent != null)
    {
      int i2 = paramIntent.length;
      o = new String[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        android.accounts.Account localAccount = (android.accounts.Account)paramIntent[i1];
        o[i1] = name;
        i1 += 1;
      }
    }
  }
  
  private final void b(Bundle paramBundle)
  {
    int i1 = 0;
    Object localObject = a;
    d = paramBundle;
    e = false;
    f = false;
    localObject = a.b;
    atl.a(this, ((com.android.emailcommon.provider.Account)localObject).d(this), paramBundle);
    a.e = true;
    if (a.a(this).m)
    {
      atl.a(this, ((com.android.emailcommon.provider.Account)localObject).c(this), paramBundle);
      a.f = true;
    }
    if (u)
    {
      if (c == 5) {
        i1 = 1;
      }
      c = 6;
      if (i1 != 0) {}
      for (paramBundle = "using_oauth";; paramBundle = "using_password")
      {
        l(paramBundle);
        b(1);
        return;
      }
    }
    bbn.a(this, a);
    if (e)
    {
      c = 9;
      l("skip_autodiscover");
      return;
    }
    c = 7;
    l(null);
    b(8);
  }
  
  private final void b(String paramString1, String paramString2)
  {
    if (j) {}
    for (String str = "setup_wizard_activity";; str = "setup_mail_activity")
    {
      a(str, paramString1, paramString2);
      return;
    }
  }
  
  private final void c(String paramString1, String paramString2)
  {
    if (j) {}
    for (String str = "setup_wizard_error";; str = "setup_mail_error")
    {
      a(str, paramString1, paramString2);
      return;
    }
  }
  
  private final atl d(String paramString)
  {
    g("AccountSetupCredentials");
    atl localatl = (atl)o();
    localatl.b(C);
    l(paramString);
    return localatl;
  }
  
  private final void e(String paramString)
  {
    if (j)
    {
      c = 14;
      l(paramString);
      G();
      return;
    }
    c = 13;
    l(paramString);
    u();
  }
  
  private final boolean f(String paramString)
  {
    B();
    return getFragmentManager().popBackStackImmediate(paramString, 1);
  }
  
  private final void g(String paramString)
  {
    B();
    getFragmentManager().popBackStackImmediate(paramString, 0);
    v();
  }
  
  private final String h(String paramString)
  {
    if ((f != null) && (!f.isEmpty())) {}
    for (paramString = (atp)f.get(paramString); paramString != null; paramString = null) {
      return a;
    }
    return null;
  }
  
  private final void i(String paramString)
  {
    avm localavm = new avm();
    Bundle localBundle = new Bundle();
    localBundle.putString("NoteDialogFragment.AccountName", paramString);
    localavm.setArguments(localBundle);
    localavm.show(getFragmentManager(), "DuplicateAccountDialogFragment");
  }
  
  private final void j(String paramString)
  {
    com.android.emailcommon.provider.Account localAccount = a.b;
    d = paramString;
    c = paramString;
    bbn.a(this, localAccount, a);
  }
  
  private final void k(String paramString)
  {
    if (!paramString.equals(a.h))
    {
      a.a(this, paramString);
      bbn.a(this, a.b, a);
      C();
    }
  }
  
  private final void l(String paramString)
  {
    String str2;
    String str1;
    if (j)
    {
      str2 = "setup_wizard_navigate";
      switch (c)
      {
      default: 
        str1 = null;
      }
    }
    for (;;)
    {
      a(str2, str1, paramString);
      return;
      str2 = "setup_mail_navigate";
      break;
      str1 = "state_landing";
      continue;
      str1 = "state_basics";
      continue;
      str1 = "state_basics_post";
      continue;
      str1 = "state_type";
      continue;
      str1 = "state_password";
      continue;
      str1 = "state_oauth";
      continue;
      str1 = "state_checking_preconfigured";
      continue;
      str1 = "state_autodiscover";
      continue;
      str1 = "state_checking_error";
      continue;
      str1 = "state_manual_incoming";
      continue;
      str1 = "state_checking_incoming";
      continue;
      str1 = "state_manual_outgoing";
      continue;
      str1 = "state_checking_outgoing";
      continue;
      str1 = "state_options";
      continue;
      str1 = "state_creating";
      continue;
      str1 = "state_names";
      continue;
      str1 = "state_finalize";
    }
  }
  
  private final void u()
  {
    Object localObject1 = null;
    Object localObject3 = null;
    ats localats = (ats)o();
    if (localats != null) {}
    int i1;
    for (boolean bool1 = localats.h();; bool1 = false) {
      switch (c)
      {
      case 2: 
      default: 
        i1 = c;
        throw new IllegalStateException(27 + "Incorrect state " + i1);
      }
    }
    boolean bool2;
    boolean bool3;
    boolean bool4;
    Object localObject2;
    label240:
    Object localObject4;
    if (k) {
      if (l)
      {
        bool2 = m();
        bool3 = j;
        bool4 = m;
        localObject2 = o;
        localObject3 = n;
        localObject1 = new aua();
        ((aua)localObject1).setArguments(aua.a(bool2, bool3, bool4, (String[])localObject2, (String)localObject3));
        localObject3 = "AccountSetupLanding";
        if (!j) {
          break label512;
        }
        if (!m) {
          break label505;
        }
        i1 = arh.at;
        localObject4 = getString(i1);
        localObject2 = localObject1;
        localObject1 = localObject4;
        label255:
        n = bool1;
        k = c;
        localObject4 = getFragmentManager().beginTransaction();
        if (localats == null) {
          break label1130;
        }
        if (!((ats)localObject2).h()) {
          break label1109;
        }
        ((FragmentTransaction)localObject4).setCustomAnimations(aqx.a, aqx.b, aqy.a, aqy.d);
      }
    }
    for (;;)
    {
      ((FragmentTransaction)localObject4).replace(are.aP, (Fragment)localObject2, "AccountSetupContentFragment");
      ((FragmentTransaction)localObject4).addToBackStack((String)localObject3);
      ((FragmentTransaction)localObject4).commit();
      if ((((ats)localObject2).h()) && (!bool1) && (localObject3 != null)) {
        p.push(localObject3);
      }
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(findViewById(are.aP).getWindowToken(), 0);
      localObject2 = (AccessibilityManager)getSystemService("accessibility");
      if ((localObject2 != null) && (((AccessibilityManager)localObject2).isEnabled()))
      {
        localObject3 = AccessibilityEvent.obtain();
        ((AccessibilityEvent)localObject3).setEventType(32);
        ((AccessibilityEvent)localObject3).getText().add(localObject1);
        ((AccessibilityManager)localObject2).sendAccessibilityEvent((AccessibilityEvent)localObject3);
      }
      return;
      bool2 = m();
      bool3 = j;
      bool4 = m;
      localObject2 = o;
      localObject3 = n;
      localObject1 = new atz();
      ((atz)localObject1).setArguments(atz.a(bool2, bool3, bool4, (String[])localObject2, (String)localObject3));
      break;
      label505:
      i1 = arh.as;
      break label240;
      label512:
      i1 = arh.ar;
      break label240;
      cvm.e(b, "AccountSetupFinal.updateContentFragment: In landing state but landing was not enabled", new Object[0]);
      bool2 = j;
      bool3 = k;
      localObject2 = new ati();
      localObject1 = new Bundle(2);
      ((Bundle)localObject1).putBoolean("AccountSetupBasicsFragment.isBackEnabled", bool3);
      ((Bundle)localObject1).putBoolean("AccountSetupBasicsFragment.isSetupWizardFlow", bool2);
      ((ati)localObject2).setArguments((Bundle)localObject1);
      localObject3 = "AccountSetupBasics";
      localObject1 = getString(arh.y);
      break label255;
      localObject1 = a.c;
      localObject2 = new auk();
      localObject4 = new Bundle(1);
      ((Bundle)localObject4).putString("emailAddress", (String)localObject1);
      ((auk)localObject2).setArguments((Bundle)localObject4);
      localObject1 = getString(arh.r);
      break label255;
      localObject2 = atl.a(a.c, a.b(this), a.b.d(this).i, C, false);
      localObject3 = "AccountSetupCredentials";
      localObject1 = getString(arh.aH);
      break label255;
      if (A != null) {}
      for (i1 = 1;; i1 = 0)
      {
        localObject2 = a.c;
        if (i1 != 0) {
          localObject1 = A.q;
        }
        localObject1 = avy.a((String)localObject2, (String)localObject1);
        localObject3 = "AccountSetupCredentials";
        if (i1 == 0) {
          break label793;
        }
        localObject4 = getString(arh.aA);
        localObject2 = localObject1;
        localObject1 = localObject4;
        break;
      }
      label793:
      localObject4 = getString(arh.az, new Object[] { A.c });
      localObject2 = localObject1;
      localObject1 = localObject4;
      break label255;
      localObject2 = avh.c(1);
      localObject3 = "CheckSettingsPreconfig";
      localObject1 = getString(arh.E);
      break label255;
      localObject2 = avh.c(8);
      localObject3 = "CheckSettingsAutodiscover";
      localObject1 = getString(arh.F);
      break label255;
      i1 = y;
      localObject1 = z;
      localObject2 = new avc();
      localObject3 = new Bundle(2);
      ((Bundle)localObject3).putString("message", (String)localObject1);
      ((Bundle)localObject3).putInt("exceptionId", i1);
      ((avc)localObject2).setArguments((Bundle)localObject3);
      localObject3 = "CheckSettingsError";
      localObject1 = getString(arh.D, new Object[] { z });
      break label255;
      localObject2 = atv.b(0, false);
      localObject1 = getString(arh.al);
      break label255;
      localObject2 = avh.c(2);
      localObject3 = "CheckSettingsIncoming";
      localObject1 = getString(arh.B);
      break label255;
      localObject2 = auf.c(0);
      localObject1 = getString(arh.aF);
      break label255;
      localObject2 = avh.c(4);
      localObject3 = "CheckSettingsOutgoing";
      localObject1 = getString(arh.C);
      break label255;
      localObject2 = new aue();
      localObject1 = getString(arh.aC);
      break label255;
      localObject2 = new avi();
      localObject3 = "CreateAccount";
      localObject1 = getString(arh.H);
      break label255;
      localObject2 = new auc();
      localObject1 = getString(arh.ax);
      break label255;
      label1109:
      ((FragmentTransaction)localObject4).setCustomAnimations(aqy.b, aqy.c, aqy.a, aqy.d);
      continue;
      label1130:
      ((FragmentTransaction)localObject4).setTransition(0);
    }
  }
  
  private final void v()
  {
    c = ok;
  }
  
  private final int w()
  {
    String str2 = a.b(this);
    if (A != null) {}
    for (String str1 = A.q;; str1 = null)
    {
      B = awj.a(this).a(str2, str1);
      if (!B) {
        break;
      }
      return 5;
    }
    return 4;
  }
  
  private final void x()
  {
    if (h) {}
    Object localObject1;
    label492:
    do
    {
      return;
      q = false;
      localObject1 = (ats)o();
      if (localObject1 != null) {
        ((ats)localObject1).a_(true);
      }
      getFragmentManager().executePendingTransactions();
      Object localObject2;
      switch (c)
      {
      default: 
        cvm.f(cvm.a, "Unknown state %d", new Object[] { Integer.valueOf(c) });
        return;
      case 0: 
        if ((A != null) && (awj.a(this).a(null, A.q)))
        {
          u = true;
          c = 5;
          l("provider_with_oauth_selected");
        }
        for (;;)
        {
          u();
          return;
          A = null;
          c = 1;
          l("account_type_selected");
        }
      case 1: 
        localObject2 = (ati)o();
        localObject1 = ((ati)localObject2).c();
        boolean bool;
        if (!bbn.a((String)localObject1))
        {
          ((ati)localObject2).a_(false);
          bool = false;
        }
        while (!bool)
        {
          c = 2;
          l(null);
          return;
          a.a(this, null);
          if (!TextUtils.equals((CharSequence)localObject1, a.c)) {
            C = false;
          }
          a.a((String)localObject1);
          A = b((String)localObject1);
          if (A != null)
          {
            u = true;
            bool = C();
          }
          else
          {
            u = false;
            localObject2 = h((String)localObject1);
            if (localObject2 != null)
            {
              i((String)localObject2);
              bool = false;
            }
            else
            {
              j((String)localObject1);
              e = false;
              bool = true;
            }
          }
        }
      case 2: 
        if (oa)
        {
          e = true;
          u = false;
          c = 3;
          l("divert_to_manual");
        }
        for (;;)
        {
          u();
          return;
          e = false;
          localObject1 = a.i;
          localObject2 = a.b(this);
          if (u)
          {
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)))
            {
              if (l) {
                k((String)localObject1);
              }
              for (;;)
              {
                if (!z()) {
                  break label492;
                }
                if (!A()) {
                  break;
                }
                b("divert_to_gmail", "ignored_ab");
                return;
                k((String)localObject2);
              }
              c = w();
              l("ignored_ab");
              u();
              return;
            }
            if ((z()) && (!aa.getBoolean("allowAddGmailAsImap", false)))
            {
              if (!A()) {
                break;
              }
              b("divert_to_gmail", "from_basics");
              return;
            }
            c = w();
            l("is_preconfigured");
            continue;
          }
          localObject1 = a.i;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            a.a(this, (String)localObject1);
            bbn.a(this, a.b, a);
            c = w();
            l("type_already_selected");
          }
          else
          {
            c = 3;
            l("no_type_determined");
          }
        }
      case 3: 
        c = w();
        l("type_chosen");
        u();
        return;
      case 4: 
        b(((atl)o()).c());
        u();
        return;
      case 5: 
        b(ob);
        u();
        return;
      case 6: 
        if (v)
        {
          if (C)
          {
            p.pop();
            if (B)
            {
              g("AccountSetupBasics");
              ((ati)o()).a(z);
              l("preconfig_failed_oauth");
              return;
            }
            d("preconfig_password_failed");
            return;
          }
          if (j) {
            y();
          }
          for (;;)
          {
            l("preconfig_failed");
            u();
            return;
            c = 9;
          }
        }
        e("preconfig_succeeded");
        return;
      case 7: 
        if (C)
        {
          p.pop();
          d("autodiscover_password_failed");
          return;
        }
        if (j) {
          y();
        }
        for (;;)
        {
          l("autodiscover_completed");
          u();
          return;
          c = 9;
        }
      case 8: 
        c = 9;
        l("from_error");
        if (!TextUtils.isEmpty(x)) {
          c("try_again_tapped", x);
        }
        u();
        return;
      case 9: 
        ((atv)o()).g();
        c = 10;
        l(null);
        b(2);
        u();
        return;
      case 10: 
        if (a.a(this).m)
        {
          c = 11;
          l(null);
          u();
          return;
        }
        e("from_incoming");
        return;
      case 11: 
        ((auf)o()).g();
        c = 12;
        l(null);
        b(4);
        u();
        return;
      case 12: 
        e("from_outgoing");
        return;
      case 13: 
        c = 14;
        l(null);
        G();
        return;
      case 14: 
        if (j)
        {
          I();
          return;
        }
        c = 15;
        l(null);
        u();
      }
    } while (a.a != 4);
    getFragmentManager().executePendingTransactions();
    I();
    return;
    I();
    return;
    if ((j) && (k) && (a.a != 4))
    {
      localObject1 = getFragmentManager().findFragmentByTag("AccountFinalizeFragment");
      getFragmentManager().beginTransaction().remove((Fragment)localObject1).commit();
      n = a.c;
      c = 0;
      m = false;
      J();
      getLoaderManager().restartLoader(1, null, new atq(this));
      u();
      return;
    }
    finish();
  }
  
  private final void y()
  {
    c = 8;
    y = 0;
    z = getString(arh.t);
  }
  
  private final boolean z()
  {
    return TextUtils.equals(a.a(this).a, "gmail");
  }
  
  public String a(Intent paramIntent)
  {
    return null;
  }
  
  public final void a(int paramInt) {}
  
  public final void a(Bundle paramBundle)
  {
    if (paramBundle.containsKey("emailAddress"))
    {
      a.a(paramBundle.getString("emailAddress"));
      if (!C())
      {
        onBackPressed();
        return;
      }
    }
    if (TextUtils.isEmpty(a.c))
    {
      Toast.makeText(this, arh.bR, 0).show();
      cvm.e(b, "We have credentials but we don't know the email address.", new Object[0]);
      onBackPressed();
      return;
    }
    x();
  }
  
  public final void a(arq paramarq)
  {
    D();
    Object localObject = a;
    if (localObject != null)
    {
      switch (((Bundle)localObject).getInt("autodiscover_error_code"))
      {
      default: 
        return;
      case 0: 
        paramarq = (HostAuthCompat)((Bundle)localObject).getParcelable("autodiscover_host_auth");
        if (paramarq != null) {
          a.b.t = paramarq.a();
        }
        x();
        return;
      case -1: 
        d = 11;
        a(paramarq);
        return;
      }
      w = ((Bundle)localObject);
      paramarq = w.getString("autodiscover_redirect_uri");
      localObject = new auv();
      Bundle localBundle = new Bundle(1);
      localBundle.putString("redirectUri", paramarq);
      ((auv)localObject).setArguments(localBundle);
      ((DialogFragment)localObject).show(getFragmentManager(), "AutodiscoverRedirectRequestDialogFragment");
      return;
    }
    x();
  }
  
  public final void a(bdi parambdi)
  {
    x = parambdi.a();
    y = bbo.a(parambdi);
    z = bbo.a(this, parambdi);
    c("check_settings_error", x);
    D();
    if ((c == 6) || (c == 7))
    {
      v = true;
      if ((y == 1) || (y == 2)) {
        C = true;
      }
      x();
      return;
    }
    a(false, x);
  }
  
  public final void a(EmailProviderConfiguration paramEmailProviderConfiguration)
  {
    if (c != 0) {
      return;
    }
    A = paramEmailProviderConfiguration;
    String str1;
    String str2;
    if (l)
    {
      str1 = "leaving_logo_landing";
      str2 = String.valueOf("landing_provider_selected_");
      if (paramEmailProviderConfiguration != null) {
        break label75;
      }
      paramEmailProviderConfiguration = "null";
      label39:
      paramEmailProviderConfiguration = String.valueOf(paramEmailProviderConfiguration);
      if (paramEmailProviderConfiguration.length() == 0) {
        break label83;
      }
    }
    label75:
    label83:
    for (paramEmailProviderConfiguration = str2.concat(paramEmailProviderConfiguration);; paramEmailProviderConfiguration = new String(str2))
    {
      b(str1, paramEmailProviderConfiguration);
      x();
      return;
      str1 = "leaving_landing";
      break;
      paramEmailProviderConfiguration = b;
      break label39;
    }
  }
  
  public final void a(com.android.emailcommon.provider.Account paramAccount)
  {
    a.a(paramAccount);
  }
  
  public final void a(String paramString)
  {
    D();
    awk.a(paramString).show(getFragmentManager(), "SecurityRequiredDialog");
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (j) {}
    for (String str = "setup_wizard_configuration";; str = "setup_mail_configuration")
    {
      a(str, paramString1, paramString2);
      return;
    }
  }
  
  protected final void a(String paramString1, String paramString2, String paramString3)
  {
    if (!r) {
      super.a(paramString1, paramString2, paramString3);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      x();
      return;
    }
    onBackPressed();
  }
  
  public final boolean a()
  {
    return j;
  }
  
  public EmailProviderConfiguration b(String paramString)
  {
    return awj.a(this).a(paramString);
  }
  
  public final void b()
  {
    if (c != 0) {
      return;
    }
    A = null;
    if (l) {}
    for (String str = "leaving_logo_landing";; str = "leaving_landing")
    {
      b(str, "landing_exchange_selected");
      a.i = bam.f(this, getString(arh.i));
      x();
      return;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    cvm.c(b, "AccountSetupFinal: Autodiscover redirect dialog result=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      b(8);
      return;
    }
    x();
  }
  
  public final void c()
  {
    if (c != 0) {
      return;
    }
    if (l) {}
    for (String str = "leaving_logo_landing";; str = "leaving_landing")
    {
      b(str, "landing_not_now_selected");
      s();
      return;
    }
  }
  
  public final void c(String paramString)
  {
    a.a(this, paramString);
    bbn.a(this, a.b, a);
    x();
  }
  
  public final void d()
  {
    new aum().show(getFragmentManager(), "AddedEmailAddressesDialogFragment");
  }
  
  public final void d_()
  {
    if (c != 0) {
      return;
    }
    if (l) {}
    for (String str = "leaving_logo_landing";; str = "leaving_landing")
    {
      b(str, "landing_google_selected");
      n();
      return;
    }
  }
  
  public final boolean e()
  {
    return (f != null) && (f.size() > 1);
  }
  
  public final void e_()
  {
    if (!q) {
      x();
    }
  }
  
  public final void f()
  {
    v = false;
    C = false;
    D();
    x();
  }
  
  public void finish()
  {
    if ((s) && (t != null))
    {
      t.onError(4, "canceled");
      t = null;
    }
    super.finish();
  }
  
  public final awi g()
  {
    Fragment localFragment = o();
    if ((localFragment instanceof awi)) {
      return (awi)localFragment;
    }
    return null;
  }
  
  public final void h()
  {
    H();
    t();
    if (t != null)
    {
      ban localban = a.a(this);
      Bundle localBundle = new Bundle(2);
      localBundle.putString("authAccount", a.c);
      localBundle.putString("accountType", c);
      t.onResult(localBundle);
      t = null;
      s = false;
    }
    setResult(-1);
    x();
  }
  
  public final void i()
  {
    H();
    y = 0;
    z = getString(arh.cz);
    a(true, "create_account_error");
  }
  
  public final void j()
  {
    x();
  }
  
  public final void k() {}
  
  public boolean m()
  {
    return false;
  }
  
  public boolean n()
  {
    return false;
  }
  
  public final <T extends Fragment> T o()
  {
    return getFragmentManager().findFragmentByTag("AccountSetupContentFragment");
  }
  
  public void onBackPressed()
  {
    B();
    switch (c)
    {
    }
    while (q)
    {
      return;
      a(false, true);
      return;
      finish();
      return;
      if (k)
      {
        J();
      }
      else
      {
        finish();
        return;
        x = null;
        continue;
        H();
        continue;
        D();
      }
    }
    ats localats = (ats)o();
    boolean bool;
    if ((localats != null) && (n))
    {
      String str = (String)p.pop();
      bool = f(str);
      cvm.b(b, "Back press: {tag=%s, State=%s, handled=%s}", new Object[] { str, Integer.valueOf(c), Boolean.valueOf(bool) });
    }
    for (;;)
    {
      if (!bool)
      {
        if ((localats != null) && (localats.h())) {
          p.pop();
        }
        super.onBackPressed();
      }
      v();
      return;
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject2 = getIntent();
    Object localObject3 = ((Intent)localObject2).getAction();
    h = false;
    i = ((Intent)localObject2).getStringExtra("SOURCE_LABEL");
    Object localObject1;
    label411:
    String str1;
    String str2;
    int i1;
    if (i == null)
    {
      localObject1 = "from_other";
      i = ((String)localObject1);
      if (g == null) {
        g = getString(arh.br);
      }
      setContentView(arf.g);
      if (paramBundle == null) {
        break label595;
      }
      q = paramBundle.getBoolean("AccountSetupFinal.is_processing", false);
      c = paramBundle.getInt("AccountSetupFinal.state", 13);
      j = paramBundle.getBoolean("AccountSetupFinal.isSetupWizardFlow", false);
      k = paramBundle.getBoolean("AccountSetupFinal.isLandingEnabled");
      l = paramBundle.getBoolean("AccountSetupFinal.useLogoLanding");
      m = paramBundle.getBoolean("AccountSetupFinal.isFirstLanding");
      n = paramBundle.getString("AccountSetupFinal.lastAddedEmail");
      o = paramBundle.getStringArray("AccountSetupFinal.tapAndGoEmails");
      A = ((EmailProviderConfiguration)paramBundle.getParcelable("AccountSetupFinal.provider"));
      B = paramBundle.getBoolean("AccountSetupFinal.usingOauth");
      t = ((AccountAuthenticatorResponse)paramBundle.getParcelable("AccountSetupFinal.authResp"));
      s = paramBundle.getBoolean("AccountSetupFinal.authErr");
      u = paramBundle.getBoolean("AccountSetupFinal.preconfig");
      e = paramBundle.getBoolean("AccountSetupFinal.noAuto");
      C = paramBundle.getBoolean("AccountSetupFinal.passwordFailed");
      w = paramBundle.getBundle("AccountSetupFinal.autodiscoverRedirectBundle");
      paramBundle = (List)paramBundle.getSerializable("AccountSetupFinal.contentTags");
      p = new Stack();
      p.addAll(paramBundle);
      if (!j) {
        break label927;
      }
      paramBundle = getWindow();
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          localObject1 = paramBundle.getAttributes();
          systemUiVisibility |= 0x1602;
          paramBundle.setAttributes((WindowManager.LayoutParams)localObject1);
        }
        localObject1 = new cyl(5634);
        localObject3 = new cym();
        b = paramBundle;
        c = 3;
        d = ((cyo)localObject1);
        e.run();
        paramBundle.setNavigationBarColor(0);
        paramBundle.setStatusBarColor(0);
      }
      if ((q) || (a.a != 4)) {
        break label1174;
      }
      if (!ActivityManager.isRunningInTestHarness()) {
        break label953;
      }
      r = true;
      paramBundle = ((Intent)localObject2).getStringExtra("EMAIL");
      localObject3 = ((Intent)localObject2).getStringExtra("USER");
      localObject1 = ((Intent)localObject2).getStringExtra("PASSWORD");
      str1 = ((Intent)localObject2).getStringExtra("INCOMING");
      str2 = ((Intent)localObject2).getStringExtra("OUTGOING");
      if (!TextUtils.equals(((Intent)localObject2).getStringExtra("SYNC_LOOKBACK"), "ALL")) {
        break label972;
      }
      i1 = 6;
      label509:
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
        break label977;
      }
      bool1 = true;
      label536:
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (bool1)) {
        break label983;
      }
    }
    label595:
    label643:
    label658:
    label767:
    label873:
    label879:
    label919:
    label927:
    label953:
    label972:
    label977:
    label983:
    for (int i2 = 1;; i2 = 0)
    {
      if ((!TextUtils.isEmpty(paramBundle)) && ((bool1) || (i2 != 0))) {
        break label988;
      }
      cvm.e(cvm.a, "Force account create requires extras EMAIL, USER, INCOMING, OUTGOING, or EMAIL and PASSWORD", new Object[0]);
      finish();
      return;
      localObject1 = i;
      break;
      t = ((AccountAuthenticatorResponse)getIntent().getParcelableExtra("accountAuthenticatorResponse"));
      if (t != null) {
        s = true;
      }
      if (g.equals(localObject3))
      {
        a.a = 4;
        if (((Intent)localObject2).getBooleanExtra("SKIP_LANDING", false)) {
          break label873;
        }
        bool1 = true;
        k = bool1;
        j = ((Intent)localObject2).getBooleanExtra("firstRun", false);
        n = a((Intent)localObject2);
        if (k)
        {
          cfm.a(getApplicationContext());
          l = false;
          c = 0;
          m = true;
        }
        if (j)
        {
          paramBundle = ((Intent)localObject2).getStringExtra("owner_name");
          a.b.k = paramBundle;
          b((Intent)localObject2);
        }
        if (!TextUtils.equals("jumpToIncoming", (CharSequence)localObject3)) {
          break label879;
        }
        c = 9;
        if (!j) {
          break label919;
        }
      }
      for (paramBundle = null;; paramBundle = i)
      {
        b("account_setup_started", paramBundle);
        u();
        C = false;
        break;
        i1 = ((Intent)localObject2).getIntExtra("FLOW_MODE", -1);
        paramBundle = ((Intent)localObject2).getStringExtra("FLOW_ACCOUNT_TYPE");
        if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals(getResources().getString(arh.i))) && (!cxd.b()))
        {
          finish();
          return;
        }
        a.i = bam.f(this, paramBundle);
        a.a = i1;
        break label643;
        bool1 = false;
        break label658;
        if (TextUtils.equals("jumpToOutgoing", (CharSequence)localObject3))
        {
          c = 11;
          break label767;
        }
        if (!TextUtils.equals("jumpToOptions", (CharSequence)localObject3)) {
          break label767;
        }
        c = 13;
        break label767;
      }
      if (!cxd.d()) {
        break label411;
      }
      getWindow().setStatusBarColor(getResources().getColor(arb.b));
      break label411;
      cvm.e(cvm.a, "ERROR: Force account create only allowed while in test harness", new Object[0]);
      finish();
      return;
      i1 = -1;
      break label509;
      bool1 = false;
      break label536;
    }
    label988:
    if (i2 != 0)
    {
      localObject2 = cvm.a;
      localObject3 = cvm.a(paramBundle);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        cvm.b((String)localObject2, "AccountSetupFinal implicit email=%s hasPassword=%b explicitForm=%b", new Object[] { localObject3, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        A = b(paramBundle);
        if (A != null) {
          break;
        }
        cvm.e(cvm.a, "findProviderForDomain couldn't find provider", new Object[0]);
        finish();
        return;
      }
      u = true;
      a.a(paramBundle);
      if (!C())
      {
        cvm.e(cvm.a, "Force create account failed to create account", new Object[0]);
        finish();
        return;
      }
      paramBundle = a.b;
      dg = ((String)localObject1);
      cg = ((String)localObject1);
      c = 13;
      u();
      getFragmentManager().executePendingTransactions();
      label1174:
      getLoaderManager().initLoader(1, null, new atq(this));
      return;
    }
    localObject2 = cvm.a;
    String str3 = cvm.a(paramBundle);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      cvm.b((String)localObject2, "AccountSetupFinal explicit email=%s user=`%s` hasPassword=%b incoming=%s outgoing=%s", new Object[] { str3, localObject3, Boolean.valueOf(bool1), str1, str2 });
      localObject1 = a.b;
      try
      {
        ((com.android.emailcommon.provider.Account)localObject1).d(this).b(str1);
        ((com.android.emailcommon.provider.Account)localObject1).c(this).b(str2);
        a.b.k = ((String)localObject3);
        j(paramBundle);
        if ((i1 < 0) || (i1 > 6)) {
          break;
        }
        f = i1;
      }
      catch (URISyntaxException paramBundle)
      {
        Toast.makeText(this, arh.aP, 1).show();
        finish();
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    h = false;
    if (r) {
      x();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("AccountSetupFinal.is_processing", q);
    paramBundle.putInt("AccountSetupFinal.state", c);
    paramBundle.putBoolean("AccountSetupFinal.isSetupWizardFlow", j);
    paramBundle.putBoolean("AccountSetupFinal.isLandingEnabled", k);
    paramBundle.putBoolean("AccountSetupFinal.useLogoLanding", l);
    paramBundle.putBoolean("AccountSetupFinal.isFirstLanding", m);
    paramBundle.putString("AccountSetupFinal.lastAddedEmail", n);
    paramBundle.putStringArray("AccountSetupFinal.tapAndGoEmails", o);
    paramBundle.putParcelable("AccountSetupFinal.provider", A);
    paramBundle.putBoolean("AccountSetupFinal.usingOauth", B);
    paramBundle.putSerializable("AccountSetupFinal.contentTags", p);
    paramBundle.putParcelable("AccountSetupFinal.authResp", t);
    paramBundle.putBoolean("AccountSetupFinal.authErr", s);
    paramBundle.putBoolean("AccountSetupFinal.preconfig", u);
    paramBundle.putBoolean("AccountSetupFinal.passwordFailed", C);
    paramBundle.putBundle("AccountSetupFinal.autodiscoverRedirectBundle", w);
    h = true;
  }
  
  protected void onStart()
  {
    super.onStart();
    buo.a().a(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    buo.a().b(this);
  }
  
  public final Map<String, atp> p()
  {
    return f;
  }
  
  public final void q()
  {
    v();
  }
  
  public final void r()
  {
    if (c == 8)
    {
      x();
      return;
    }
    cvm.e(b, "AccountSetupFinal.onCheckSettingsErrorEditSettings: State not found", new Object[0]);
  }
  
  public final void s()
  {
    if (c == 0) {}
    for (String str = "from_landing";; str = "from_error")
    {
      b("not_now_tapped", str);
      if (!TextUtils.isEmpty(x)) {
        c("not_now_tapped", x);
      }
      a(m, false);
      return;
    }
  }
  
  public void t()
  {
    Object localObject;
    if (B)
    {
      str = "using_oauth";
      if (!j) {
        break label66;
      }
      localObject = null;
      label20:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label74;
      }
      label27:
      b("account_added", str);
      if (A == null) {
        break label99;
      }
    }
    label66:
    label74:
    label99:
    for (String str = A.b;; str = "not_preconfigured")
    {
      b("account_added_provider", str);
      return;
      str = "using_password";
      break;
      localObject = i;
      break label20;
      str = String.format(Locale.US, "%s_%s", new Object[] { localObject, str });
      break label27;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.AccountSetupFinal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */