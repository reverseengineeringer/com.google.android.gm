package com.google.android.gm.ui;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import buo;
import but;
import cdi;
import cfm;
import cfr;
import ckv;
import cmy;
import cmz;
import cna;
import cnk;
import cno;
import com.android.mail.providers.Account;
import com.android.mail.ui.MiniDrawerView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView;
import cvl;
import cvm;
import cxd;
import cxe;
import ddy;
import dga;
import dnm;
import dxa;
import dxb;
import dxd;
import dxe;
import dxf;
import dxk;
import dxl;
import dxn;
import dxo;
import dxp;
import dxq;
import dxs;
import dxt;
import eiz;
import eja;
import ejc;
import eje;
import ejh;
import elh;
import fra;
import frb;
import frm;
import fro;
import frp;
import fru;
import frv;
import frw;
import frx;
import fsc;
import fsf;
import fsi;
import fsl;
import fsy;
import fth;
import ftk;
import ftm;
import fyb;
import fyc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import oi;

public class GmailDrawerFragment
  extends cna
  implements ejc, eje, fth, ftk
{
  public static final String D = cvl.a;
  private static final dxs L = new dxs(Locale.getDefault(), new dxt());
  public fsc E;
  public fsl F;
  public fyc G;
  public final oi<String, fyb> H = new oi();
  public SelectedAccountNavigationView I;
  public ftm J;
  public fsy K;
  private eiz M;
  private final oi<String, dxp> N = new oi();
  private final List<String> O = new ArrayList(2);
  private boolean P;
  private boolean Q;
  private float R;
  private float S;
  private float T;
  private float U;
  private final dxe V = new dxe(this);
  private List<fyb> W;
  private fyb X;
  private dxf Y;
  private dxk Z;
  
  public static void a(Context paramContext, ImageView paramImageView, fyb paramfyb, dxk paramdxk)
  {
    if (paramImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(dnm.a(paramContext, paramfyb.b()).g()))
    {
      paramImageView.setImageDrawable(null);
      return;
    }
    paramImageView.setImageDrawable(a);
  }
  
  public static void a(fyc paramfyc)
  {
    if (paramfyc != null) {
      if ((a != null) && (!a.b())) {
        break label32;
      }
    }
    label32:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramfyc.b();
      }
      return;
    }
  }
  
  private final void c(fyb paramfyb)
  {
    if (paramfyb == null) {
      X = null;
    }
    do
    {
      return;
      localObject1 = X;
      X = paramfyb;
    } while (W == null);
    W = fsl.a(W, (fyb)localObject1, X);
    I.a(X);
    paramfyb = F;
    Object localObject1 = W;
    if ((d) || ((localObject1 != null) && (((List)localObject1).size() <= 1)))
    {
      if (b == null) {
        b = new ArrayList();
      }
      b.clear();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (fyb)((Iterator)localObject1).next();
          b.add(localObject2);
        }
      }
      paramfyb.notifyDataSetChanged();
      return;
    }
    f = true;
    Object localObject2 = e;
    if (e != null)
    {
      if (f != null)
      {
        f.cancel(true);
        f = null;
      }
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break label227;
      }
      e.a(null);
    }
    for (;;)
    {
      paramfyb.notifyDataSetChanged();
      return;
      label227:
      b = ((List)localObject1);
      c.addAll((Collection)localObject1);
      f = new frw((fru)localObject2);
      f.execute(new Void[0]);
    }
  }
  
  private final void l()
  {
    try
    {
      O.clear();
      Iterator localIterator = I.g.iterator();
      while (localIterator.hasNext())
      {
        fyb localfyb = (fyb)localIterator.next();
        if (localfyb != null) {
          O.add(localfyb.b());
        }
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      cvm.d(cvm.a, localIllegalArgumentException, "Data buffer is closed for recent accounts", new Object[0]);
    }
  }
  
  public final void a()
  {
    l();
    h();
  }
  
  public final void a(float paramFloat)
  {
    boolean bool2 = true;
    if ((z == null) || (z.b() == 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Q = bool1;
      if (!Q) {
        break;
      }
      return;
    }
    if (!cxd.a())
    {
      P = false;
      if (!P) {
        break label338;
      }
      cxe.c(J.l);
      cxe.c(J.m);
      cxe.c(J.h);
    }
    for (;;)
    {
      super.a(paramFloat);
      return;
      if ((paramFloat != 0.0F) && (paramFloat != 1.0F)) {
        break;
      }
      label133:
      View localView1;
      View localView2;
      float f2;
      float f3;
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      if ((I.getTop() == 0) && (I.b == 0))
      {
        bool1 = bool2;
        P = bool1;
        if (!P) {
          break;
        }
        float f1 = z.b();
        localView1 = z.b;
        localView2 = J.i;
        f2 = localView2.getWidth();
        f3 = localView2.getHeight();
        localView1.setAlpha(0.0F);
        R = (f1 / f2);
        S = (f1 / f3);
        if (!cxe.a(localView1)) {
          break label307;
        }
        arrayOfInt1 = new int[2];
        arrayOfInt2 = new int[2];
        localView1.getLocationInWindow(arrayOfInt1);
        localView2.getLocationInWindow(arrayOfInt2);
      }
      label307:
      for (T = (arrayOfInt1[0] + localView1.getWidth() / 2.0F - (arrayOfInt2[0] + f2 / 2.0F));; T = (localView1.getX() + localView1.getWidth() / 2.0F - (localView2.getX() + f2 / 2.0F)))
      {
        U = (localView1.getY() + localView1.getHeight() / 2.0F - (localView2.getY() + f3 / 2.0F));
        break;
        bool1 = false;
        break label133;
      }
      label338:
      cxe.c(I);
    }
  }
  
  public final void a(int paramInt)
  {
    cvm.d(D, "GoogleApiClient connection suspended", new Object[0]);
  }
  
  public final void a(Bundle paramBundle)
  {
    cvm.c(D, "GoogleApiClient connected.", new Object[0]);
    if (M.e())
    {
      paramBundle = new frb();
      b = false;
      frm.e.a(M, paramBundle).a(new dxa(this));
    }
  }
  
  protected final void a(LayoutInflater paramLayoutInflater, View paramView, ListView paramListView)
  {
    I = ((SelectedAccountNavigationView)paramLayoutInflater.inflate(dga.d, paramListView, false));
    if (cxd.d())
    {
      paramLayoutInflater = (FrameLayout)paramView;
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setOnApplyWindowInsetsListener(new dxo(this));
      paramLayoutInflater.setForegroundGravity(55);
      K = new fsy();
      paramLayoutInflater.setForeground(K);
    }
    paramLayoutInflater = I;
    if (frx.a(11)) {}
    for (boolean bool = true;; bool = false)
    {
      p = bool;
      o = p;
      paramLayoutInflater = I;
      d = M;
      if (d != null) {
        e = new fsf(paramLayoutInflater.getContext(), d);
      }
      E = new dxq(getActivity(), M, N);
      I.f = E;
      I.i = this;
      I.a = this;
      paramLayoutInflater = I;
      int i = dga.V;
      paramView = new dxn(this);
      dxl localdxl = new dxl(Z);
      k = i;
      c = paramView;
      l = localdxl;
      I.c(0);
      paramListView.addHeaderView(I);
      return;
    }
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    cvm.d(D, "GoogleApiClient connection failed", new Object[0]);
  }
  
  public final void a(SelectedAccountNavigationView paramSelectedAccountNavigationView)
  {
    a(paramSelectedAccountNavigationView, true);
  }
  
  public final void a(SelectedAccountNavigationView paramSelectedAccountNavigationView, boolean paramBoolean)
  {
    int i = b;
    if (i == 0)
    {
      setListAdapter(k);
      paramSelectedAccountNavigationView = "default_list";
    }
    for (;;)
    {
      if (paramBoolean) {
        buo.a().a("account_switcher", "nav_mode", paramSelectedAccountNavigationView, 0L);
      }
      return;
      if (i == 1)
      {
        setListAdapter(F);
        paramSelectedAccountNavigationView = "account_list";
      }
      else
      {
        cvm.e(D, "Unknown navigation mode: %s", new Object[] { Integer.valueOf(i) });
        paramSelectedAccountNavigationView = "error";
      }
    }
  }
  
  public final void a(fyb paramfyb)
  {
    b(paramfyb);
    buo.a().a("account_switcher", "recents", "sanv_click", 0L);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (Q) {
      return;
    }
    super.a(paramBoolean);
    cmy.a(J.i);
    if (P)
    {
      cxe.d(J.l);
      cxe.d(J.m);
      cxe.d(J.h);
      return;
    }
    cxe.d(I);
  }
  
  public final void b(float paramFloat)
  {
    if (Q) {
      return;
    }
    if (P)
    {
      cmy.a(J.i, R, S, T, U, paramFloat);
      B.d(J.l, paramFloat);
      B.d(J.m, paramFloat);
      cmy.c(J.h, paramFloat);
      cmy.b(J.h, C, paramFloat);
    }
    super.b(paramFloat);
  }
  
  public final void b(fyb paramfyb)
  {
    l();
    c(a);
  }
  
  protected final void c_(int paramInt)
  {
    int i = paramInt - getListView().getHeaderViewsCount();
    int j = I.b;
    if (j == 0)
    {
      super.c_(paramInt);
      return;
    }
    if (j == 1)
    {
      paramInt = F.getItemViewType(i);
      Object localObject;
      if (paramInt == 0)
      {
        c(F.a(i));
        b(X);
        localObject = "account_click";
      }
      for (;;)
      {
        buo.a().a("account_switcher", "account_list", (String)localObject, 0L);
        return;
        if (paramInt == 1)
        {
          ddy.a(getActivity(), "from_drawer");
          localObject = "add_accounts_click";
        }
        else if (paramInt == 2)
        {
          localObject = new Intent("android.settings.SYNC_SETTINGS");
          ((Intent)localObject).addFlags(524288);
          ((Intent)localObject).putExtra("authorities", new String[] { "gmail-ls", "com.google.android.gm.email.provider" });
          try
          {
            startActivity((Intent)localObject);
            localObject = "manage_accounts_click";
          }
          catch (ActivityNotFoundException localActivityNotFoundException)
          {
            for (;;)
            {
              cvm.e(D, localActivityNotFoundException, "No sync settings activity found.", new Object[0]);
            }
          }
        }
        else
        {
          String str = "error";
        }
      }
    }
    cvm.e(D, "Unknown navigation mode: %s", new Object[] { Integer.valueOf(j) });
  }
  
  protected final cno d()
  {
    return null;
  }
  
  protected final int f()
  {
    if (P) {
      return 1;
    }
    return 0;
  }
  
  protected final Comparator<cdi> g()
  {
    return L;
  }
  
  public final void h()
  {
    Object localObject2 = null;
    if (e) {
      return;
    }
    Object localObject7 = c();
    Object localObject6 = new ArrayList(localObject7.length);
    if (p == null) {}
    Object localObject3;
    for (Object localObject1 = "";; localObject1 = p.c)
    {
      cvm.b(cvm.a, "rebuildAccountList: current=%s", new Object[] { localObject1 });
      N.clear();
      int j = localObject7.length;
      int i = 0;
      localObject3 = null;
      while (i < j)
      {
        Account localAccount = localObject7[i];
        localObject5 = (fyb)H.get(c);
        cvm.b(cvm.a, "account = %s, owner=%s", new Object[] { localAccount, localObject5 });
        localObject5 = new dxp((fyb)H.get(c), localAccount, a(localAccount));
        ((List)localObject6).add(localObject5);
        N.put(c, localObject5);
        if (((String)localObject1).equals(c)) {
          localObject3 = localObject5;
        }
        i += 1;
      }
    }
    Object localObject5 = O.iterator();
    localObject1 = null;
    label335:
    while (((Iterator)localObject5).hasNext())
    {
      localObject7 = (String)((Iterator)localObject5).next();
      cvm.b(cvm.a, "selectedAccount = %s, account = %s", new Object[] { localObject3, localObject7 });
      if ((localObject3 == null) || (!((String)localObject7).equals(((fyb)localObject3).b()))) {
        if (localObject2 == null)
        {
          localObject2 = (fyb)N.get(localObject7);
        }
        else
        {
          if (localObject1 != null) {
            break label902;
          }
          localObject1 = (fyb)N.get(localObject7);
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject7 = ((List)localObject6).iterator();
        localObject5 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject5;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        Object localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localIllegalArgumentException2;
        continue;
      }
      try
      {
        if (((Iterator)localObject7).hasNext())
        {
          localObject5 = (fyb)((Iterator)localObject7).next();
          cvm.b(cvm.a, "owner = %s", new Object[] { a.c });
          if (localObject3 == null) {
            break label905;
          }
          if (((fyb)localObject5).b().equals(((fyb)localObject3).b())) {
            continue;
          }
          break label905;
          if ((localObject2 != null) || (((fyb)localObject5).b().equals(((fyb)localObject1).b()))) {
            continue;
          }
          localObject2 = localObject5;
          continue;
        }
        if (F == null)
        {
          F = new fsl(getActivity(), dga.a, new dxd(), new dxb(Z));
          F.d = true;
          F.a = E;
          localObject5 = F;
          if (c != true)
          {
            c = true;
            ((fsl)localObject5).notifyDataSetChanged();
          }
        }
        W = ((List)localObject6);
        c((fyb)localObject3);
        F.b(W);
        localObject5 = I;
        if ((t == null) || (!t.isRunning())) {
          continue;
        }
        v = ((fyb)localObject1);
        w = ((fyb)localObject2);
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        localObject5 = localObject1;
        localObject1 = localIllegalArgumentException1;
        localObject4 = localObject5;
        localObject5 = cvm.a;
        if (localObject4 == null) {
          continue;
        }
        localObject4 = a.toString();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = a.toString();
        cvm.b((String)localObject5, (Throwable)localObject1, "Owner's buffer is closed. recent1=%s, recent2=%s", new Object[] { localObject4, localObject2 });
        return;
        if (g != null) {
          continue;
        }
        g = new ArrayList();
        if (localObject1 == null) {
          continue;
        }
        g.add(localObject1);
        if (localObject2 == null) {
          continue;
        }
        g.add(localObject2);
        ((SelectedAccountNavigationView)localObject5).b();
        continue;
        g.clear();
        continue;
        a.add(localObject4);
        if (localObject6 == null) {
          continue;
        }
        a.add(localObject6);
        if (localObject7 == null) {
          continue;
        }
        a.add(localObject7);
        ((dxf)localObject5).notifyDataSetChanged();
        return;
        localObject4 = "null";
        continue;
        localObject2 = "null";
        continue;
      }
      if (Y == null) {
        break;
      }
      localObject5 = Y;
      localObject3 = (dxp)localObject3;
      localObject6 = (dxp)localObject1;
      localObject7 = (dxp)localObject2;
      a.clear();
      if (localObject3 == null)
      {
        ((dxf)localObject5).notifyDataSetChanged();
        return;
      }
      label902:
      break label335;
      label905:
      if (localObject1 == null) {
        localObject1 = localIllegalArgumentException2;
      }
    }
  }
  
  protected final void j()
  {
    Y = new dxf(this);
  }
  
  protected final ListAdapter k()
  {
    return Y;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = b.p();
    if (paramBundle != null) {
      paramBundle.a(V);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Z = new dxk(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    fro localfro = new frp().a().b();
    M = new eja(getActivity().getApplicationContext()).a(frm.c, localfro).a(this).a(this).a();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    Object localObject;
    if (E != null)
    {
      localObject = E;
      if (f != null) {
        f.e = true;
      }
      g.clear();
      e = true;
    }
    E = null;
    if (F != null)
    {
      localObject = F;
      if (e != null) {
        e.a();
      }
    }
    super.onDestroy();
    a(G);
    G = null;
  }
  
  public void onDestroyView()
  {
    if (b != null)
    {
      cmz localcmz = b.p();
      if (localcmz != null) {
        localcmz.b(V);
      }
    }
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    l();
    Object localObject = cfm.a(getActivity());
    List localList = O;
    int i = localList.size();
    SharedPreferences.Editor localEditor = e;
    if (i > 0)
    {
      localObject = (String)localList.get(0);
      localEditor = localEditor.putString("recent-account-one", (String)localObject);
      if (i <= 1) {
        break label100;
      }
    }
    label100:
    for (localObject = (String)localList.get(1);; localObject = null)
    {
      localEditor.putString("recent-account-two", (String)localObject).apply();
      return;
      localObject = null;
      break;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = cfm.a(getActivity());
    List localList = O;
    localList.clear();
    String str = d.getString("recent-account-one", null);
    if (str != null) {
      localList.add(str);
    }
    localObject = d.getString("recent-account-two", null);
    if (localObject != null) {
      localList.add(localObject);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((M != null) && (!M.e()) && (!M.f())) {
      M.b();
    }
  }
  
  public void onStop()
  {
    if ((M != null) && ((M.e()) || (M.f()))) {
      M.d();
    }
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.GmailDrawerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */