package com.android.mail.ui;

import aah;
import aaj;
import acr;
import acz;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.http.HttpResponseCache;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import anf;
import anp;
import btz;
import buc;
import buj;
import buo;
import buq;
import but;
import bvd;
import bvu;
import bzn;
import cde;
import cfx;
import cgm;
import cgr;
import chc;
import chf;
import cjn;
import cjo;
import cjw;
import cke;
import ckf;
import ckg;
import ckt;
import cku;
import ckv;
import cky;
import cll;
import cmz;
import cng;
import cnh;
import cod;
import cof;
import com.android.mail.drawer.CurrentFolderDialogState;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.ui.toastbar.ToastBarOperation;
import cos;
import cpb;
import cpe;
import cpf;
import cpn;
import cpo;
import cqp;
import cqw;
import crj;
import cro;
import csl;
import cst;
import cud;
import cvh;
import cvi;
import cwr;
import cxa;
import cxe;
import cxf;
import gnr;
import gnt;
import hlj;
import java.util.Locale;
import java.util.Set;
import zc;

public class MailActivity
  extends cjn
  implements ckv, cpe
{
  public static boolean s = false;
  public static String t = null;
  private CustomViewToolbar A;
  private bzn B;
  private final cos C = new cos();
  public cjw l;
  public crj m;
  public ToastBarOperation n;
  public boolean o;
  public csl p = new csl();
  public cst q = new cst();
  public cpn r = new cpn();
  public boolean u;
  private cke v;
  private cvh w = new cvi();
  private AccessibilityManager x;
  private bvu y;
  private anf z;
  
  public chc A()
  {
    return new chf(this);
  }
  
  public final ToastBarOperation B()
  {
    return n;
  }
  
  public bvu C()
  {
    return new bvu();
  }
  
  public void D() {}
  
  public bvd a(Context paramContext, anf paramanf)
  {
    return new bvd(paramContext, paramanf);
  }
  
  public final bvu a()
  {
    return y;
  }
  
  public cro a(Bundle paramBundle)
  {
    return new cro(this);
  }
  
  public void a(int paramInt, Account paramAccount) {}
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localcke = v;
      float f = a;
      if (!c)
      {
        if (d != null) {
          d.cancel();
        }
        d = ValueAnimator.ofFloat(new float[] { f, paramInt });
      }
      ValueAnimator localValueAnimator = d;
      if (paramInt == 0) {}
      for (long l1 = (f * 300.0F);; l1 = ((1.0F - f) * 300.0F))
      {
        localValueAnimator.setDuration(l1);
        d.addUpdateListener(new ckf(localcke));
        d.start();
        return;
      }
    }
    cke localcke = v;
    if ((!c) && (d != null))
    {
      d.cancel();
      d = null;
    }
    localcke.b(paramInt);
  }
  
  public final void a(acz paramacz)
  {
    super.a(paramacz);
    cxe.a(this, btz.a);
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, int paramInt) {}
  
  public void a(Account paramAccount) {}
  
  public void a(Account paramAccount, int paramInt)
  {
    if (crj.b(paramInt)) {}
    for (paramInt = buj.aO;; paramInt = buj.aJ)
    {
      cxa.a(this, paramAccount, getString(paramInt));
      return;
    }
  }
  
  public final void a(Account paramAccount, CurrentFolderDialogState paramCurrentFolderDialogState)
  {
    if (getFragmentManager() != null)
    {
      cde localcde = new cde();
      Bundle localBundle = new Bundle(3);
      localBundle.putParcelable("createFolderUri", k);
      localBundle.putParcelable("dialogState", paramCurrentFolderDialogState);
      localBundle.putParcelable("account", paramAccount);
      localcde.setArguments(localBundle);
      localcde.show(getFragmentManager(), "create-folder-dialog");
    }
  }
  
  public final void a(Account paramAccount1, Account paramAccount2)
  {
    Object localObject = null;
    if (paramAccount1 == null)
    {
      paramAccount1 = cxf.a();
      if ((paramAccount2 != null) && (c.equals(paramAccount1))) {
        return;
      }
      a(new gnr(hlj.a), 25, paramAccount1);
      cgr localcgr = cgr.b;
      if (localcgr != null)
      {
        paramAccount1 = (Account)localObject;
        if (cxf.a(this, paramAccount2)) {
          paramAccount1 = c;
        }
        paramAccount2 = localcgr.d().edit();
        paramAccount2.putString("lastViewedVisualElementLoggingAccount", paramAccount1);
        paramAccount2.apply();
      }
      a(new gnr(hlj.b));
      return;
    }
    if (cxf.a(this, paramAccount1)) {}
    for (paramAccount1 = c;; paramAccount1 = null)
    {
      a(new gnr(hlj.a), 25, paramAccount1);
      break;
    }
  }
  
  public final void a(Folder paramFolder)
  {
    l.a(paramFolder);
  }
  
  public final void a(cqp paramcqp)
  {
    l.a(paramcqp);
  }
  
  public void a(gnr paramgnr) {}
  
  public void a(gnr paramgnr, int paramInt, String paramString) {}
  
  public void a(gnr paramgnr, View paramView) {}
  
  public final void a_(ToastBarOperation paramToastBarOperation)
  {
    l.a_(paramToastBarOperation);
  }
  
  public gnt b(Folder paramFolder)
  {
    return null;
  }
  
  public void b(int paramInt, Account paramAccount) {}
  
  public final void b(acz paramacz)
  {
    super.b(paramacz);
    cxe.a(this, btz.C);
  }
  
  public final void b(ToastBarOperation paramToastBarOperation)
  {
    n = null;
  }
  
  public final cjw d()
  {
    return l;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    l.a(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final ConversationCheckedSet h()
  {
    return l.T();
  }
  
  public final cod i()
  {
    return l;
  }
  
  public final Folder j()
  {
    return l.q();
  }
  
  public final cll k()
  {
    return l;
  }
  
  public final cng l()
  {
    return l;
  }
  
  public final cnh m()
  {
    return l;
  }
  
  public final cjo n()
  {
    return l;
  }
  
  public final cpo o()
  {
    return l;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!y.a(paramInt1, paramInt2, paramIntent)) {
      l.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    if (!l.w()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    l.ap();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getIntent();
    if ((localObject != null) && (((Intent)localObject).getCategories() != null) && (((Intent)localObject).getCategories().contains("android.intent.category.LAUNCHER"))) {
      buq.b.a("cold_start_to_list");
    }
    x();
    m = new crj();
    if (cxa.a(getResources()))
    {
      l = new cqw(this, m);
      setContentView(l.ar());
      localObject = (Toolbar)findViewById(buc.cw);
      if ((localObject instanceof CustomViewToolbar))
      {
        A = ((CustomViewToolbar)localObject);
        CustomViewToolbar localCustomViewToolbar = A;
        cjw localcjw = l;
        crj localcrj = m;
        u = localcjw;
        v = localcrj;
        v.a(localCustomViewToolbar);
        w.a(n());
        x.a(m());
        l.a(A);
      }
      f().a((Toolbar)localObject);
      ((Toolbar)localObject).a(l.ak());
      x = ((AccessibilityManager)getSystemService("accessibility"));
      o = x.isEnabled();
      if (o) {
        ((Toolbar)localObject).getRootView().setAccessibilityDelegate(new cku((Toolbar)localObject));
      }
      v = new cke(this);
      l.a(paramBundle);
      f().a().b(v);
      localObject = NfcAdapter.getDefaultAdapter(this);
      if (localObject != null) {
        ((NfcAdapter)localObject).setNdefPushMessageCallback(C, this, new Activity[0]);
      }
      if (getResourcesgetConfigurationhardKeyboardHidden != 1) {
        break label398;
      }
      buo.a().a("configuration", "keyboard", "use_hardware_keyboard", 0L);
    }
    for (;;)
    {
      y = C();
      y.a(this, paramBundle);
      return;
      l = new cpf(this, m);
      break;
      label398:
      buo.a().a("configuration", "keyboard", "do_not_use_hardware_keyboard", 0L);
    }
  }
  
  public Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    return super.onCreateDialog(paramInt, paramBundle);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return (l.a(paramMenu)) || (super.onCreateOptionsMenu(paramMenu));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    l.E();
    if (A != null)
    {
      localObject = A;
      w.a();
      x.a();
    }
    Object localObject = HttpResponseCache.getInstalled();
    if (localObject != null)
    {
      if (((HttpResponseCache)localObject).getRequestCount() > 0) {
        buo.a().a("gmail_auth", "http_response_cache_hit_rate", String.format(Locale.US, "%.1f", new Object[] { Double.valueOf(((HttpResponseCache)localObject).getHitCount() / ((HttpResponseCache)localObject).getRequestCount()) }), 0L);
      }
      ((HttpResponseCache)localObject).flush();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return (l.a(paramMenuItem)) || (super.onOptionsItemSelected(paramMenuItem));
  }
  
  public void onPause()
  {
    super.onPause();
    l.B();
    s = false;
    u = false;
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    l.ao();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    l.b(paramMenu);
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    l.s();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    l.c(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    l.C();
    boolean bool = x.isEnabled();
    if (bool != o)
    {
      o = bool;
      Toolbar localToolbar = (Toolbar)findViewById(buc.cw);
      if ((o) && (localToolbar != null)) {
        localToolbar.getRootView().setAccessibilityDelegate(new cku(localToolbar));
      }
      l.ac();
    }
    if (registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) != null) {}
    for (bool = true;; bool = false)
    {
      cwr.a(bool);
      s = true;
      u = true;
      return;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    l.b(paramBundle);
    y.a(paramBundle);
    u = false;
  }
  
  public boolean onSearchRequested()
  {
    l.W();
    return true;
  }
  
  public void onStart()
  {
    super.onStart();
    l.r();
    y.a();
  }
  
  public void onStop()
  {
    super.onStop();
    l.D();
    y.b();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    l.f(paramBoolean);
  }
  
  public final cmz p()
  {
    return l.ag();
  }
  
  public final ckg q()
  {
    return l;
  }
  
  public final cpb r()
  {
    return l;
  }
  
  public final csl s()
  {
    return p;
  }
  
  public final cst t()
  {
    return q;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("{ViewMode=");
    localStringBuilder.append(m);
    localStringBuilder.append(" controller=");
    localStringBuilder.append(l);
    localStringBuilder.append(" current_focus=");
    localStringBuilder.append(getCurrentFocus());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final cof u()
  {
    return l;
  }
  
  public ckt v()
  {
    return new ckt(this);
  }
  
  public final crj v_()
  {
    return m;
  }
  
  public final anf w()
  {
    return z;
  }
  
  public final cky w_()
  {
    return l;
  }
  
  public final void x()
  {
    if (cud.a(this)) {}
    for (int i = 0;; i = 347136)
    {
      z = new anp(i);
      return;
    }
  }
  
  public final cpn y()
  {
    return r;
  }
  
  public final bzn z()
  {
    if (B == null) {
      B = new bzn(this);
    }
    return B;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */