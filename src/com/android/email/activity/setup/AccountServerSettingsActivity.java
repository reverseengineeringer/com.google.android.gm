package com.android.email.activity.setup;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import are;
import arf;
import aro;
import arq;
import arr;
import asp;
import ass;
import ast;
import ath;
import atn;
import atv;
import auf;
import aux;
import avb;
import ave;
import avg;
import awi;
import awj;
import awk;
import awn;
import bam;
import ban;
import bbo;
import bbw;
import bdi;
import bhk;
import com.android.emailcommon.EmailProviderConfiguration;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Credential;
import com.android.emailcommon.provider.HostAuth;
import cui;
import cvm;

public class AccountServerSettingsActivity
  extends ath
  implements arr, ass, atn, avb, avg, awn
{
  private asp b;
  private boolean c;
  private boolean d;
  private String e;
  private Credential f;
  
  public static Intent a(Context paramContext, Account paramAccount, String paramString, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, AccountServerSettingsActivity.class);
    paramContext.putExtra("account", paramAccount);
    paramContext.putExtra("whichSettings", paramString);
    paramContext.putExtra("fromSettings", paramBoolean);
    return paramContext;
  }
  
  private final Fragment h()
  {
    if (d) {}
    for (int i = 1; "outgoing".equals(e); i = 2) {
      return auf.c(i);
    }
    return atv.b(i, c);
  }
  
  private final boolean i()
  {
    awj localawj;
    if (!d)
    {
      localawj = awj.a(this);
      if (f != null) {
        break label62;
      }
      localObject = localawj.a(a.b.d);
      if (localObject != null) {}
    }
    else
    {
      return false;
    }
    label62:
    for (Object localObject = b;; localObject = f.c) {
      return localawj.a(a.b.f(this), (String)localObject);
    }
  }
  
  private final void j()
  {
    Fragment localFragment1 = getFragmentManager().findFragmentByTag("AccountCheckStgFrag");
    Fragment localFragment2 = getFragmentManager().findFragmentByTag("CheckProgressDialog");
    getFragmentManager().beginTransaction().remove(localFragment1).remove(localFragment2).commit();
  }
  
  public final void a(int paramInt)
  {
    ave localave = new ave();
    Object localObject = new Bundle(1);
    ((Bundle)localObject).putInt("CheckProgressDialog.Mode", paramInt);
    localave.setArguments((Bundle)localObject);
    localObject = aro.a(paramInt, null);
    getFragmentManager().beginTransaction().add(localave, "CheckProgressDialog").add((Fragment)localObject, "AccountCheckStgFrag").commit();
  }
  
  public final void a(Bundle paramBundle)
  {
    awj localawj = awj.a(this);
    Account localAccount = a.b;
    localawj.a(localAccount.d(this), paramBundle);
    localawj.a(localAccount.c(this), paramBundle);
    a(6);
    paramBundle = h();
    getFragmentManager().beginTransaction().replace(are.p, paramBundle).commit();
  }
  
  public final void a(arq paramarq)
  {
    throw new IllegalStateException();
  }
  
  public final void a(bdi parambdi)
  {
    j();
    int i = bbo.a(parambdi);
    parambdi = bbo.a(this, parambdi);
    aux localaux = new aux();
    Bundle localBundle = new Bundle(2);
    localBundle.putString("CheckSettingsErrorDialog.Message", parambdi);
    localBundle.putInt("CheckSettingsErrorDialog.ExceptionId", i);
    localaux.setArguments(localBundle);
    localaux.show(getFragmentManager(), "CheckSettingsErrorDialog");
  }
  
  public final void a(String paramString)
  {
    j();
    awk.a(paramString).show(getFragmentManager(), "SecurityRequiredDialog");
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a("email_settings_configuration", paramString1, paramString2);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      asp localasp = b;
      if (localasp != null) {
        localasp.d();
      }
    }
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final void c()
  {
    super.onBackPressed();
  }
  
  public final void d()
  {
    j();
  }
  
  public final void e()
  {
    asp localasp = b;
    if ((localasp instanceof atv))
    {
      ((atv)localasp).a(this);
      return;
    }
    cvm.f(cvm.a, "Tried to change cert on non-incoming screen?", new Object[0]);
  }
  
  public final void e_() {}
  
  public final void f()
  {
    j();
    asp localasp = b;
    if (localasp != null) {
      localasp.d();
    }
  }
  
  public final awi g()
  {
    return (awi)getFragmentManager().findFragmentByTag("CheckProgressDialog");
  }
  
  public final void k()
  {
    boolean bool = i();
    cvm.b(bbw.a, "onAccountServerSaveComplete: isOAuth: %s", new Object[] { Boolean.valueOf(bool) });
    if (((b instanceof atv)) && (c) && (!bool))
    {
      auf localauf = auf.c(2);
      getFragmentManager().beginTransaction().remove(b).add(are.p, localauf).commit();
      return;
    }
    super.onBackPressed();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        a(paramIntent.getExtras());
      }
    }
    else {
      return;
    }
    finish();
  }
  
  public void onAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
    if ((paramFragment instanceof asp)) {
      b = ((asp)paramFragment);
    }
  }
  
  public void onBackPressed()
  {
    asp localasp = b;
    if ((localasp != null) && (localasp.c()))
    {
      new ast().show(getFragmentManager(), "UnsavedChangesDialogFragment");
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.a = 3;
    setContentView(arf.c);
    setFinishOnTouchOutside(false);
    if (paramBundle == null)
    {
      paramBundle = getIntent();
      Object localObject1 = (Account)paramBundle.getParcelableExtra("account");
      if (localObject1 == null) {
        throw new IllegalArgumentException("No account present in intent");
      }
      a.a((Account)localObject1);
      d = paramBundle.getBooleanExtra("fromSettings", false);
      e = paramBundle.getStringExtra("whichSettings");
      Object localObject2 = ((Account)localObject1).d(this);
      if (localObject2 != null)
      {
        paramBundle = ((HostAuth)localObject2).a(this);
        f = paramBundle;
        c = false;
        if (!d)
        {
          if (localObject2 == null) {
            break label232;
          }
          paramBundle = bam.e(this, b);
          if ((paramBundle != null) && (m)) {
            c = true;
          }
        }
        label150:
        if (!i()) {
          break label290;
        }
        localObject2 = new Intent(this, OAuthAuthenticationActivity.class);
        localObject1 = d;
        if (f != null) {
          break label279;
        }
        paramBundle = awj.a(this).a((String)localObject1);
        if ((paramBundle != null) && (b != null)) {
          break label249;
        }
        cvm.d(bbw.a, "%s is not supported for oauth", new Object[] { cui.b((String)localObject1) });
        finish();
      }
      label232:
      label249:
      label279:
      label290:
      while (bhk.a())
      {
        return;
        paramBundle = null;
        break;
        cvm.d(bbw.a, "null hostAuth in AccountServerSettingsActivity", new Object[0]);
        break label150;
        for (paramBundle = b;; paramBundle = f.c)
        {
          ((Intent)localObject2).putExtra("fallback_email_address", (String)localObject1);
          ((Intent)localObject2).putExtra("provider", paramBundle);
          startActivityForResult((Intent)localObject2, 1);
          return;
        }
      }
      getFragmentManager().beginTransaction().add(are.p, h()).commit();
      return;
    }
    c = paramBundle.getBoolean("dualAuthentication");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("dualAuthentication", c);
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.AccountServerSettingsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */