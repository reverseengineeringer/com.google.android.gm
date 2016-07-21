package com.google.android.gm.ui.teasers;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import bam;
import buo;
import but;
import cfm;
import cfr;
import cjo;
import ckv;
import cvm;
import ddy;
import dfx;
import dge;
import dxz;
import ghz;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EasPromoTeaserView
  extends dxz
{
  private static final Set<String> p = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "com.microsoft.office.outlook.USER_ACCOUNT", "com.ninefolders.hd3", "com.samsung.android.exchange", "com.android.exchange", "com.htc.android.mail.eas" })));
  public ckv n;
  private boolean o;
  private boolean q;
  
  public EasPromoTeaserView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EasPromoTeaserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void i()
  {
    buo.a().a("teaser", "dismiss", "eas_promo", 0L);
    cfm.a(getContext()).k();
    super.i();
  }
  
  public final boolean n()
  {
    if ((!o) || (agetContextd.getBoolean("eas-promo-dismissed", false))) {}
    label115:
    label157:
    label244:
    label251:
    label254:
    for (;;)
    {
      return false;
      long l = ghz.a(getContext().getContentResolver(), "gmail-eas-promo-exp-ms", 1472688000000L);
      if (System.currentTimeMillis() <= l)
      {
        Object localObject = getContext().getString(dge.a);
        com.android.mail.providers.Account[] arrayOfAccount = n.n().k();
        int j = arrayOfAccount.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label115;
          }
          if (((String)localObject).equals(e)) {
            break;
          }
          i += 1;
        }
        if (getContext().checkPermission("android.permission.GET_ACCOUNTS", Process.myPid(), Process.myUid()) == 0)
        {
          i = 1;
          if (i != 0)
          {
            localObject = AccountManager.get(getContext()).getAccounts();
            j = localObject.length;
            i = 0;
            if (i >= j) {
              break label251;
            }
            arrayOfAccount = localObject[i];
            if (!p.contains(type)) {
              break label244;
            }
            cvm.b("EasPromo", "found Exchange account of type=%s", new Object[] { type });
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label254;
          }
          if (!q)
          {
            buo.a().a("teaser", "show", "eas_promo", 0L);
            q = true;
          }
          return true;
          i = 0;
          break;
          i += 1;
          break label157;
        }
      }
    }
  }
  
  public final boolean o()
  {
    return false;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    f.setText(dge.ce);
    g.setText(dge.cc);
    a(dge.cd);
    b(dge.ew);
    e.setImageResource(dfx.e);
    p();
    o = bam.c(getContext(), getContext().getString(dge.fj));
  }
  
  protected final void r()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("FLOW_ACCOUNT_TYPE", getContext().getString(dge.a));
    localBundle.putBoolean("SKIP_LANDING", true);
    buo.a().a("teaser", "add_account", "eas_promo", 0L);
    ddy.a(n.g(), "from_eas_promo", localBundle);
    super.i();
  }
  
  protected final void s()
  {
    buo.a().a("teaser", "negative", "eas_promo", 0L);
    cfm.a(getContext()).k();
    super.i();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.teasers.EasPromoTeaserView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */