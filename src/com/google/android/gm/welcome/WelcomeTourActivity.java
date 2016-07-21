package com.google.android.gm.welcome;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import buo;
import but;
import cko;
import com.google.android.gm.ui.CirclePageIndicator;
import com.google.android.gm.ui.MailActivityGmail;
import cvl;
import cvm;
import dfy;
import dga;
import dmv;
import eao;
import eap;
import eau;
import eaw;
import glh;
import java.util.ArrayList;
import qv;
import rg;
import su;

public class WelcomeTourActivity
  extends Activity
  implements View.OnClickListener, eaw, su
{
  public static final String a = cvl.a;
  public static Intent c;
  public ViewPager b;
  private CirclePageIndicator d;
  private cko e;
  private View f;
  private View g;
  private View h;
  private View i;
  private int j;
  private WelcomeTourState k;
  private but l;
  private ArrayList<WelcomeTourState.AccountState> m;
  
  private final void b()
  {
    Intent localIntent = new Intent(this, SetupAddressesActivity.class);
    if (m != null) {
      localIntent.putParcelableArrayListExtra("pending-changes", m);
    }
    if (k != null) {
      localIntent.putExtra("tour-state", k);
    }
    startActivityForResult(localIntent, 1);
  }
  
  private final void b(int paramInt)
  {
    l.a("welcome_tour", "page", b.b.a(paramInt).toString(), paramInt);
  }
  
  private final void c()
  {
    if (b.b.a() == 1)
    {
      f.setVisibility(8);
      i.setVisibility(0);
      return;
    }
    f.setVisibility(0);
    i.setVisibility(8);
    int n = b.c;
    cko localcko = e;
    if (n == localcko.b(a.b.a() - 1))
    {
      g.setVisibility(8);
      h.setVisibility(0);
      return;
    }
    g.setVisibility(0);
    h.setVisibility(8);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void a(WelcomeTourState paramWelcomeTourState)
  {
    k = paramWelcomeTourState;
  }
  
  public final boolean a()
  {
    return j == -1;
  }
  
  public final void a_(int paramInt)
  {
    b(paramInt);
    d.invalidate();
    c();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      return;
      switch (paramInt2)
      {
      default: 
        return;
      case -1: 
        paramIntent = dmv.a();
        paramIntent.a(this, 1);
        paramIntent.a(this, false);
        AsyncTask.execute(new eap(this));
        setResult(-1);
        paramIntent = c;
        c = null;
        if (paramIntent != null)
        {
          paramIntent.setFlags(paramIntent.getFlags() ^ 0x10000000);
          paramIntent.putExtra("launched-from-welcome-tour", true);
          startActivity(paramIntent);
          cvm.b(MailActivityGmail.v, "Started pending intent", new Object[0]);
        }
        finish();
        return;
      }
    } while (paramIntent == null);
    m = paramIntent.getParcelableArrayListExtra("pending-changes");
  }
  
  public void onBackPressed()
  {
    if (b.c != e.b(0))
    {
      ViewPager localViewPager = b;
      cko localcko = e;
      localViewPager.b(localcko.a(localcko.b(localcko.b(a.c) - 1)));
      return;
    }
    moveTaskToBack(true);
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n == dfy.cB)
    {
      paramView = b;
      cko localcko = e;
      paramView.b(localcko.a(localcko.b(localcko.b(a.c) + 1)));
      l.a("welcome_tour", "click_button", "next", 0L);
    }
    do
    {
      return;
      if (n == dfy.cD)
      {
        b();
        l.a("welcome_tour", "click_button", "skip", 0L);
        return;
      }
      if (n == dfy.cz)
      {
        b();
        l.a("welcome_tour", "click_button", "done", 0L);
        return;
      }
    } while (n != dfy.cA);
    b();
    l.a("welcome_tour", "click_button", "got_it", 0L);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    j = getIntent().getExtras().getInt("tour-highest-version-seen");
    Object localObject = a;
    if (a())
    {
      paramBundle = "new";
      cvm.a((String)localObject, "Welcome tour started (%s user, version: %d)", new Object[] { paramBundle, Integer.valueOf(j) });
      getLoaderManager().initLoader(21, Bundle.EMPTY, eau.a(this, getLoaderManager(), this));
      setContentView(dga.Z);
      l = buo.a();
      j = getIntent().getExtras().getInt("tour-highest-version-seen");
      b = ((ViewPager)findViewById(dfy.cC));
      b.e = this;
      b.a(new eao(this, getFragmentManager()));
      d = ((CirclePageIndicator)findViewById(dfy.cy));
      d.a = b;
      e = new cko(b);
      f = findViewById(dfy.cx);
      g = findViewById(dfy.cB);
      g.setOnClickListener(this);
      h = findViewById(dfy.cz);
      h.setOnClickListener(this);
      i = findViewById(dfy.cA);
      i.setOnClickListener(this);
      findViewById(dfy.cD).setOnClickListener(this);
      if (b.b.a() == 1) {
        d.setVisibility(8);
      }
      rg.d(b, 3);
      b.b(e.b(0));
      c();
      localObject = buo.a();
      if (!a()) {
        break label414;
      }
      paramBundle = "new";
      label341:
      ((but)localObject).a(9, paramBundle);
      if (!"android.intent.action.MAIN".equals(getIntent().getStringExtra("source"))) {
        break label421;
      }
    }
    label414:
    label421:
    for (paramBundle = "launcher";; paramBundle = "other")
    {
      l.a("welcome_tour", "start_ww", paramBundle, 0L);
      b(0);
      glh.a.a("Application ready", "Application ready welcome");
      return;
      paramBundle = "upgrading";
      break;
      paramBundle = "upgrading";
      break label341;
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    l.a(this);
  }
  
  protected void onStop()
  {
    l.b(this);
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.welcome.WelcomeTourActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */