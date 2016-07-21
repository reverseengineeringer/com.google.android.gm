package com.google.android.gm.gmailify;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import bhl;
import buo;
import but;
import cvl;
import cvm;
import cxa;
import dfy;
import dga;
import dge;
import dgf;
import dkp;
import dks;
import dku;
import dlp;
import dmb;
import dmc;
import dnm;

public class GmailifyUnlinkActivity
  extends Activity
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, dku
{
  public static final String a = cvl.a;
  private String b;
  private String c;
  private int d = 0;
  private View e;
  
  private final void a(String paramString, int paramInt, Object... paramVarArgs)
  {
    Object localObject = (DialogFragment)getFragmentManager().findFragmentByTag("error-dialog-tag");
    if (localObject != null) {
      ((DialogFragment)localObject).dismiss();
    }
    localObject = getString(paramInt, paramVarArgs);
    paramVarArgs = new Bundle(1);
    paramVarArgs.putString("error-message", (String)localObject);
    localObject = new dmc();
    ((dmc)localObject).setArguments(paramVarArgs);
    new Handler().post(new dmb(this, (DialogFragment)localObject));
    buo.a().a("gmailify_unlink", "error", paramString, 0L);
  }
  
  public final void a()
  {
    buo.a().a("gmailify_unlink", "ok", null, 0L);
    dnm.a(this, b).f();
    setResult(-1);
    finish();
  }
  
  public final void a(Exception paramException)
  {
    paramException = paramException.getClass().getSimpleName();
    if (cxa.a(this)) {}
    for (int i = dge.cT;; i = dge.es)
    {
      a(paramException, i, new Object[0]);
      return;
    }
  }
  
  public final void b()
  {
    a("no_3p_account", dge.cW, new Object[] { c, b });
  }
  
  public final void c()
  {
    a("error", dge.cS, new Object[0]);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == dfy.aU)
    {
      d = 2;
      e.setEnabled(true);
    }
    while (paramInt != dfy.aT) {
      return;
    }
    d = 1;
    e.setEnabled(true);
  }
  
  public void onClick(View paramView)
  {
    boolean bool;
    Bundle localBundle;
    if (paramView.getId() == dfy.aS)
    {
      if (d != 1) {
        break label147;
      }
      bool = true;
      localBundle = new Bundle(3);
      localBundle.putString("gmailAddress", b);
      localBundle.putString("thirdPartyEmail", c);
      localBundle.putBoolean("deleteMessages", bool);
      if (!bool) {
        break label152;
      }
    }
    label147:
    label152:
    for (paramView = "delete";; paramView = "keep")
    {
      cvm.b(a, "Gmailify: Unlinking %s and %s and %s the messages", new Object[] { b, c, paramView });
      getLoaderManager().initLoader(1, localBundle, new dks(this, dkp.a(), this));
      AsyncTask.execute(new dlp(this, b, null));
      buo.a().a("gmailify_unlink", "unlink", paramView, 0L);
      return;
      bool = false;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(dga.O);
    b = getIntent().getStringExtra("gmail");
    c = getIntent().getStringExtra("email");
    ((TextView)findViewById(dfy.aW)).setText(getString(dge.ds, new Object[] { c }));
    paramBundle = (RadioGroup)findViewById(dfy.aV);
    paramBundle.setOnCheckedChangeListener(this);
    ((RadioButton)paramBundle.findViewById(dfy.aT)).setText(bhl.a(this, getString(dge.dq), getString(dge.dr, new Object[] { c }), dgf.c));
    e = findViewById(dfy.aS);
    e.setOnClickListener(this);
    buo.a().a("gmailify_unlink", "start", getIntent().getStringExtra("analytics"), 0L);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    d = paramBundle.getInt("should-delete-emails", 0);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("should-delete-emails", d);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.gmailify.GmailifyUnlinkActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */